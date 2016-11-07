package kennesawstate.cs4850.tallulah.infrastructure;

import kennesawstate.cs4850.tallulah.domain.Group;
import kennesawstate.cs4850.tallulah.domain.Sample;
import kennesawstate.cs4850.tallulah.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    Sample getSample();
    List<Integer> findAllUserId();
    void createUser(@Param("name")String name, @Param("email") String email, @Param("userType") String userType);
    void createGroupId();
    int findCurrentUserId();
    User findUserBy(int userId);
    int deleteUserBy(int userId);
    int findCurrentGroupId();
    int findLatestGroupId();
    List<Integer> findAllGroupId();
    int deleteGroupBy(int groupId);
    Group findGroupBy(int groupId);
    List<User> findUserByGroupId(int groupId);
    int removeUserFromGroup(@Param("groupId")int groupId, @Param("userId")int userId);
    int updateLoginDetail(@Param("userId")int userId, @Param("loginDetail")String loginDetail);
    int addUserToGroup(@Param("groupId") int groupId, @Param("userId") int userId);
    Group findUserInGroupBy(@Param("groupId") int groupId, @Param("userId") int userId);
}
