package com.friendship41.song4music.web.service.kakaoauth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KakaoUserInfo
{
    @JsonProperty
    private boolean secure_resource;
    @JsonProperty
    private Properties properties;
    @JsonProperty
    private int id;
    @JsonProperty
    private Kakao_account kakao_account;

    public boolean isSecure_resource()
    {
        return secure_resource;
    }

    public void setSecure_resource(boolean secure_resource)
    {
        this.secure_resource = secure_resource;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Properties getProperties()
    {
        return properties;
    }

    public void setProperties(Properties properties)
    {
        this.properties = properties;
    }

    public Kakao_account getKakao_account()
    {
        return kakao_account;
    }

    public void setKakao_account(Kakao_account kakao_account)
    {
        this.kakao_account = kakao_account;
    }

    @Override
    public String toString()
    {
        return "KakaoUserInfo{" +
                "secure_resource=" + secure_resource +
                ", properties=" + properties +
                ", id=" + id +
                ", kakao_account=" + kakao_account +
                '}';
    }

    public class Properties{
        @JsonProperty
        private String nickname;
        @JsonProperty
        private String profile_image;
        @JsonProperty
        private String thumbnail_image;

        public String getNickname()
        {
            return nickname;
        }

        public void setNickname(String nickname)
        {
            this.nickname = nickname;
        }

        public String getProfile_image()
        {
            return profile_image;
        }

        public void setProfile_image(String profile_image)
        {
            this.profile_image = profile_image;
        }

        public String getThumbnail_image()
        {
            return thumbnail_image;
        }

        public void setThumbnail_image(String thumbnail_image)
        {
            this.thumbnail_image = thumbnail_image;
        }

        @Override
        public String toString()
        {
            return "Properties{" +
                    "nickname='" + nickname + '\'' +
                    ", profile_image='" + profile_image + '\'' +
                    ", thumbnail_image='" + thumbnail_image + '\'' +
                    '}';
        }
    }

    public class Kakao_account{
        @JsonProperty
        private boolean profile_needs_agreement;
        @JsonProperty
        private Profile profile;
        @JsonProperty
        private boolean email_needs_agreement;
        @JsonProperty
        private boolean is_email_valid;
        @JsonProperty
        private boolean is_email_verified;
        @JsonProperty
        private String email;

        public boolean isProfile_needs_agreement()
        {
            return profile_needs_agreement;
        }

        public void setProfile_needs_agreement(boolean profile_needs_agreement)
        {
            this.profile_needs_agreement = profile_needs_agreement;
        }

        public Profile getProfile()
        {
            return profile;
        }

        public void setProfile(Profile profile)
        {
            this.profile = profile;
        }

        public boolean isEmail_needs_agreement()
        {
            return email_needs_agreement;
        }

        public void setEmail_needs_agreement(boolean email_needs_agreement)
        {
            this.email_needs_agreement = email_needs_agreement;
        }

        public boolean isIs_email_valid()
        {
            return is_email_valid;
        }

        public void setIs_email_valid(boolean is_email_valid)
        {
            this.is_email_valid = is_email_valid;
        }

        public boolean isIs_email_verified()
        {
            return is_email_verified;
        }

        public void setIs_email_verified(boolean is_email_verified)
        {
            this.is_email_verified = is_email_verified;
        }

        public String getEmail()
        {
            return email;
        }

        public void setEmail(String email)
        {
            this.email = email;
        }

        @Override
        public String toString()
        {
            return "Kakao_account{" +
                    "profile_needs_agreement=" + profile_needs_agreement +
                    ", profile=" + profile +
                    ", email_needs_agreement=" + email_needs_agreement +
                    ", is_email_valid=" + is_email_valid +
                    ", is_email_verified=" + is_email_verified +
                    ", email='" + email + '\'' +
                    '}';
        }

        public class Profile{
            @JsonProperty
            private String nickname;
            @JsonProperty
            private String thumbnail_image_url;
            @JsonProperty
            private String profile_image_url;

            public String getNickname()
            {
                return nickname;
            }

            public void setNickname(String nickname)
            {
                this.nickname = nickname;
            }

            public String getThumbnail_image_url()
            {
                return thumbnail_image_url;
            }

            public void setThumbnail_image_url(String thumbnail_image_url)
            {
                this.thumbnail_image_url = thumbnail_image_url;
            }

            public String getProfile_image_url()
            {
                return profile_image_url;
            }

            public void setProfile_image_url(String profile_image_url)
            {
                this.profile_image_url = profile_image_url;
            }

            @Override
            public String toString()
            {
                return "Profile{" +
                        "nickname='" + nickname + '\'' +
                        ", thumbnail_image_url='" + thumbnail_image_url + '\'' +
                        ", profile_image_url='" + profile_image_url + '\'' +
                        '}';
            }
        }
    }
}
