package user.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user.domain.UserProfile;
import user.dto.request.UserProfileCommand;
import user.dto.response.UserProfileResponse;
import user.repository.UserProfileRepository;
import user.repository.UserProfileRepositorySupport;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserProfileRepositorySupport userProfileRepositorySupport;

    public UserProfileResponse save(UserProfileCommand command) {
        UserProfile userProfile = userProfilePlace(command);
        return new UserProfileResponse(userProfile);
    }

    private UserProfile userProfilePlace(UserProfileCommand command) {
        isDuplicated(command.getNickname());
        //TODO :eamil 인증 아마 파이어베이스?

        return userCreate(command);
    }

    private UserProfile userCreate(UserProfileCommand command) {
     return    UserProfile.create(command);

    }

    public Boolean isDuplicated(String nickname) {
        return userProfileRepository.existsByNickname(nickname);
    }


    private UserProfile getUserProfileById(Long userProfileId) {
        return userProfileRepositorySupport.findUserProfileById(userProfileId);
    }

}
