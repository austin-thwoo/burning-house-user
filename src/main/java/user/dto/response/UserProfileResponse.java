package user.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import user.domain.UserProfile;
import user.domain.common.Address;
import user.domain.common.UserType;

@Getter
@NoArgsConstructor
public class UserProfileResponse {
    private Long id;
    private Long userId;
    private Address address;
    private String nickName;
    private String phoneNumber;
    private UserType userType;

    public UserProfileResponse(UserProfile userProfile){
        this.id= userProfile.getId();
        this.userId=userProfile.getUserId();
        this.address=userProfile.getAddress();
        this.nickName=userProfile.getNickname();
        this.phoneNumber=userProfile.getPhoneNumber();
        this.userType=userProfile.getUserType();


    }

}
