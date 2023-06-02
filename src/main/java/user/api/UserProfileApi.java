package user.api;

import globalCommon.dto.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import user.application.UserProfileService;
import user.dto.request.UserProfileCommand;
import user.dto.response.UserProfileResponse;
import static user.application.UserProfileInterFace.CreateValidationGroup;

@RestController
@EnableAutoConfiguration
@RequiredArgsConstructor
//@Api(value = "미인증 사용자")
@RequestMapping("/auth")
public class UserProfileApi {


    private final UserProfileService userProfileService;

//    @ApiOperation(value = "회원가입")
    @PostMapping
    public ApiResponse<UserProfileResponse> save(@Validated(CreateValidationGroup.class)@RequestBody UserProfileCommand command) {
        return new ApiResponse<>(userProfileService.save(command));
    }

//    @GetMapping("/overlap/{nickname}")
//    public ApiResponse<Boolean> save(@PathVariable(name = "nickname")String nickname) {
//        return new ApiResponse<>(userProfileService.overlap(nickname));
//    }


//    @ApiResponses(value = {
//            @io.swagger.annotations.ApiResponse(code = 200, message = "로그인을 성공했습니다."),
//            @io.swagger.annotations.ApiResponse(code = 404, message = "고객 아이디로 정보를 조회할 수 없습니다.\n삭제되거나 없는 고객입니다.")
//    })
//    @ApiOperation(value = "로그인", notes = "로그인->토큰발행")
//    @PostMapping("/login")
//    public ApiResponse<TokenResponse> login(@RequestBody LoginCommand loginCommand) {
//        return new ApiResponse<>(loginService.login(loginCommand));
//    }


}
