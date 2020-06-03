package bit.ss.recommendSystem.modules.Service;

import bit.ss.recommendSystem.modules.DAO.MovieDAO;
import bit.ss.recommendSystem.modules.DAO.UserDAO;
import bit.ss.recommendSystem.modules.entity.MovieEntity;
import bit.ss.recommendSystem.modules.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieDAO movieDAO;

    @Autowired
    private UserDAO userDAO;

    public List<MovieEntity> getHomepageMovies(UserEntity user) {
        UserEntity userInfo = userDAO.getUserInfoByUsername(user);
        if (userInfo.getLastLoginTime().equals(userInfo.getRegisterTime())) {
            //第一次登录
            return movieDAO.getDefaultMovie();
        } else {
            return movieDAO.getRecommendMovieById(userInfo);
        }
    }

    public int getHomepageMovieNum(UserEntity user) {
        UserEntity userInfo = userDAO.getUserInfoByUsername(user);
        if (userInfo.getLastLoginTime().equals(userInfo.getRegisterTime())) {
            //第一次登录
            return movieDAO.getDefaultMovieNum();
        } else {
            return movieDAO.getRecommendMovieNumById(userInfo);
        }
    }

    public MovieEntity getMovieDetails(MovieEntity movie,String userName) {
        //todo 记录点击？
        return movieDAO.getMovieById(movie.getId());
    }

    public List<MovieEntity> getMoviesByName(MovieEntity movie){
        return movieDAO.getMoviesByName(movie);
    }

    public int getMoviesNumByName(MovieEntity movie){
        return movieDAO.getMoviesNumByName(movie);
    }

}
