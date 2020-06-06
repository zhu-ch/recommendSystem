package bit.ss.recommendSystem.modules.DAO;

import bit.ss.recommendSystem.modules.entity.UserEntity;

public interface UserDAO {
    int getUserNumberByName(String userName);
    String getPasswordByName(String userName);
    int getAvailableId();
    int insertUserEntry(UserEntity user);
    int updateLoginTime(UserEntity user);
    UserEntity getUserInfoByUsername(String userName);
}
