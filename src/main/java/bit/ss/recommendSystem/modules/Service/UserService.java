package bit.ss.recommendSystem.modules.Service;

import bit.ss.recommendSystem.modules.DAO.UserDAO;
import bit.ss.recommendSystem.modules.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public boolean isNameUnused(String userName) {
        return userDAO.getUserNumberByName(userName) == 0;
    }

    public String login(UserEntity user){
        if (userDAO.getUserNumberByName(user.getUserName()) == 0)
            return "User not exist";
        if (userDAO.getPasswordByName(user.getUserName()).equals(user.getPassword())) {
            user.setLastLoginTime(new Date());
            userDAO.updateLoginTime(user);
            return "Success";
        } else
            return "Wrong password";
    }

    public boolean register(UserEntity user) {
        if (!isNameUnused(user.getUserName()))
            return false;
        user.preInsert();
        return userDAO.insertUserEntry(user) == 1;
    }
}
