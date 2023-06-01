package user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.domain.UserProfile;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {
    Boolean existsByNickname(String nickname);
}
