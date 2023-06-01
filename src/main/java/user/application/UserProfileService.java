package user.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import user.domain.UserProfile;
import user.dto.request.UserProfileCommand;
import user.dto.response.UserProfileResponse;
import user.repository.UserProfileRepository;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    public UserProfileResponse save(UserProfileCommand command) {

        UserProfile userProfile=userPlace(command);


        return new UserProfileResponse(userProfile);
    }

    private UserProfile userPlace(UserProfileCommand command) {
        isDuplicated(command.getNickname());
        //TODO;
        return userCreate(command);
    }

    private UserProfile userCreate(UserProfileCommand command) {
        return null;

    }

    public Boolean isDuplicated(String nickname) {

        return userProfileRepository.existsByNickname(nickname);


    }
}
