package user.domain;


import globalCommon.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import user.domain.common.Address;
import user.domain.common.UserType;
import user.dto.request.UserProfileCommand;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_USER")
public class UserProfile extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String nickname;

    @Embedded
    private Address address;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserType userType;


    public static UserProfile create(UserProfileCommand command) {
        return UserProfile.builder()
                .userId(command.getUserId())
                .nickname(command.getNickname())
                .address(command.getAddress())
                .phoneNumber(command.getPhoneNumber())
                .userType(command.getUserType())
                .build();
    }
}
