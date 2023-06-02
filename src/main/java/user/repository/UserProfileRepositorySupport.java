package user.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import localCommon.exception.UserNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import user.domain.UserProfile;


import static user.domain.QUserProfile.userProfile;


@Repository
@Log4j2
public class UserProfileRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;


    public UserProfileRepositorySupport(JPAQueryFactory queryFactory, EntityManager entityManager) {
        super(UserProfile.class);
        this.queryFactory = queryFactory;

    }


  public UserProfile findUserProfileById(Long userProfileId){
      UserProfile result=queryFactory.selectFrom(userProfile).where(userProfile.id.eq(userProfileId)).fetchOne();
      if (result==null){
          throw new UserNotFoundException("dd",HttpStatus.BAD_REQUEST);

      }
      return new UserProfile();
  }

//    public Page<UserProfileSearchResponseModel> findAllFollowingUserProfileBySearch(Pageable pageable, UserProfiles userProfile, String searchQuery, String beBesty) {
//        QUserFollows followsCheck = new QUserFollows("followsCheck");
//        QueryResults<UserProfileSearchResponseModel> result = queryFactory.select(Projections.constructor(UserProfileSearchResponseModel.class,
//                        userFollows.to.id, userFollows.to.userId, userFollows.to.nickName, userFollows.to.countryCode, userFollows.to.imageUrlMini, userFollows.besty, followsCheck.id.isNotNull()))
//                .from(userFollows)
//                .leftJoin(userProfiles).on(userProfiles.id.eq(userFollows.from.id))
//                .leftJoin(followsCheck).on(followsCheck.from.id.eq(userProfile.getId()).and(followsCheck.to.id.eq(userFollows.from.id)))
//                .where(userFollows.id.isNotNull()
//                        .and(userFollows.from.id.eq(userProfile.getId()))
//                        .and(followSearchQuery(searchQuery))
//                        .and(bestyType(beBesty)))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetchResults();
//
//        return new PageImpl<>(result.getResults(), pageable, result.getTotal());
//    }


//    public UserProfileCountResponseModel setCountResponseModel(UserProfiles userProfile, String searchQuery) {
//        QUserFollows myBesty = new QUserFollows("myBesty");
//        QUserFollows follower = new QUserFollows("follower");
//        QUserFollows following = new QUserFollows("following");
//        queryFactory.select(queryFactory.selectFrom(userFollows)
//                .where(userFollows.to.id.eq(userProfile.getId())
//                        .and(userFollows.besty.isTrue())
//                        .and(followSearchQuery(searchQuery)).as("ss"))
//                .fetchCount()).from()


//    }

}
