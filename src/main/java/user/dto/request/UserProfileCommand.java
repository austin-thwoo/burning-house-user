package user.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import user.application.UserProfileInterFace;
import user.application.UserProfileInterFace.*;
import user.domain.common.Address;
import user.domain.common.UserType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileCommand {

    @NotBlank(groups = {UpdateValidationGroup.class,DeleteValidationGroup.class})
    @NotNull(groups = {UpdateValidationGroup.class,DeleteValidationGroup.class})
    private String id;

    @NotBlank(groups = {CreateValidationGroup.class})
    @NotNull(groups = {CreateValidationGroup.class})
    private String userId;

    @NotBlank(groups = {CreateValidationGroup.class,UpdateValidationGroup.class})
    @NotNull(groups = {CreateValidationGroup.class,UpdateValidationGroup.class})
    private String nickname;


    @NotBlank(groups = {CreateValidationGroup.class,UpdateValidationGroup.class})
    @NotNull(groups = {CreateValidationGroup.class,UpdateValidationGroup.class})
    private Address address;
    @NotBlank(groups = {CreateValidationGroup.class,UpdateValidationGroup.class})
    @NotNull(groups = {CreateValidationGroup.class,UpdateValidationGroup.class})
    private String phoneNumber;

    @NotBlank(groups = {CreateValidationGroup.class,UpdateValidationGroup.class})
    @NotNull(groups = {CreateValidationGroup.class,UpdateValidationGroup.class})
    private UserType userType;

}
