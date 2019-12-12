package kr.ac.jbnu.jclip.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import kr.ac.jbnu.jclip.controller.user.ProviderType;
import kr.ac.jbnu.jclip.social.google.GoogleUserDetails;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserInfo {

    private String email;

    @Enumerated(EnumType.STRING)
    private ProviderType provider;

    private String providerId;

    private String displayName;

    private String profileUrl;

    private String imageUrl;

    private String accessToken;

    private long expireTime;

    @Builder
    private UserInfo(String email, ProviderType provider, String providerId, String displayName, String profileUrl,
            String imageUrl, String accessToken, long expireTime) {
        this.email = email;
        this.provider = provider;
        this.providerId = providerId;
        this.displayName = displayName;
        this.profileUrl = profileUrl;
        this.imageUrl = imageUrl;
        this.accessToken = accessToken;
        this.expireTime = expireTime;
    }

    public static UserInfo valueOf(GoogleUserDetails userDetails) {
        return UserInfo.builder().expireTime(userDetails.getExpiration()).accessToken(userDetails.getAccess_token())
                .providerId(userDetails.getSub()).email(userDetails.getEmail()).displayName(userDetails.getName())
                .imageUrl(userDetails.getPicture()).provider(ProviderType.GOOGLE).profileUrl(userDetails.getProfile())
                .build();
    }
}
