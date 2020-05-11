package com.friendship41.song4music.web.service.kakaoauth;

import com.friendship41.song4music.repository.entity.Member;
import com.friendship41.song4music.web.service.LoginService;
import com.friendship41.song4music.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

@Service("KakaoLoginService")
public class KakaoLoginService implements LoginService {
    @Autowired
    @Qualifier("WebMemberService")
    private MemberService webMemberService;

    @Value("${app_key}")
    private String app_key;

    @Value("${redirect_uri}")
    private String redirect_uri;

    @Override
    public Member login()
    {
        return null;
    }

    @Override
    public Member login(final String code) {
        KakaoTokenResponse token = getKakaoTokenResponse(code);
        KakaoUserInfo kakaoUserInfo = getUserInfo(token);
        Member dbMember = webMemberService.getMemberById(kakaoUserInfo.getId()+"");

        Member tempMember = new Member(kakaoUserInfo.getId()+"",
                kakaoUserInfo.getProperties().getNickname(),
                null,
                "N",
                new Date(),
                0,
                0,
                "K",
                token.getAccess_token(),
                token.getRefresh_token());

        if(dbMember == null)
        {
            webMemberService.save(tempMember);
            dbMember = webMemberService.getMemberById(kakaoUserInfo.getId()+"");
        }
        else {
            webMemberService.updateTokenById(dbMember.getMMemberId(), tempMember);
        }
        return dbMember;
    }

    private KakaoTokenResponse getKakaoTokenResponse(String code){
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", app_key);
        params.add("redirect_uri",redirect_uri);
        params.add("code", code);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Content-Type",
                MediaType.APPLICATION_FORM_URLENCODED_VALUE+";charset-UTF-8");

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        KakaoTokenResponse response = null;
        try
        {
            response = restTemplate.postForObject(new URI("https://kauth.kakao" +
                    ".com/oauth/token"), body, KakaoTokenResponse.class);

        }
        catch (URISyntaxException e)
        {
            e.printStackTrace();
        }

        return response;
    }
    private KakaoUserInfo getUserInfo(KakaoTokenResponse token){
        KakaoUserInfo kakaoUserInfo = null;
        try{
            URI requestURI = new URI("https://kapi.kakao.com/v2/user/me");

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer {"
                    +token.getAccess_token()+"}");
            headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
            headers.add("Content-Type",
                    MediaType.APPLICATION_FORM_URLENCODED_VALUE+";charset-UTF-8");

            HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<>(headers);

            RestTemplate restTemplate = new RestTemplate();
            kakaoUserInfo = restTemplate.postForObject(requestURI,body,
                    KakaoUserInfo.class);
        }catch (URISyntaxException e){
            e.printStackTrace();
        }

        return kakaoUserInfo;
    }

}
