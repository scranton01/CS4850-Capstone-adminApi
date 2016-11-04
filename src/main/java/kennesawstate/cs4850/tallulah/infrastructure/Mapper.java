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
    void deleteUserBy(int userId);
    int findCurrentGroupId();
    int findLatestGroupId();
    List<Integer> findAllGroupId();
    int deleteGroupBy(int groupId);
    Group findGroupBy(int groupId);

}
