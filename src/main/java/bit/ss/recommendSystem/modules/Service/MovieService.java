package bit.ss.recommendSystem.modules.Service;

import bit.ss.recommendSystem.modules.DAO.MovieDAO;
import bit.ss.recommendSystem.modules.DAO.UserDAO;
import bit.ss.recommendSystem.modules.entity.MovieEntity;
import bit.ss.recommendSystem.modules.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieDAO movieDAO;

    @Autowired
    private UserDAO userDAO;

    public List<MovieEntity> getHomepageMovies() {
        return movieDAO.getDefaultMovie();
    }

    public int getHomepageMovieNum() {
        return movieDAO.getDefaultMovieNum();
    }

    public MovieEntity getMovieDetails(MovieEntity movie, String userName) {
        //todo wh:记录点击？
        return movieDAO.getMovieById(movie.getId());
    }

    public List<MovieEntity> getMoviesByName(MovieEntity movie) {
        return movieDAO.getMoviesByName(movie);
    }

    public int getMoviesNumByName(MovieEntity movie) {
        return movieDAO.getMoviesNumByName(movie);
    }

    public List<MovieEntity> getRecommendMovies(String userName){
        UserEntity userEntity=userDAO.getUserInfoByUsername(userName);
        return movieDAO.getRecommendMovieById(userEntity);
    }

    public int getRecommendMoviesNum(String userName){
        UserEntity userEntity=userDAO.getUserInfoByUsername(userName);
        return movieDAO.getRecommendMovieNumById(userEntity);
    }

    public List<MovieEntity> getRelatedMovies(MovieEntity movie){
        return movieDAO.getRelatedMovies(movie);
    }

    public int getRelatedMoviesNum(MovieEntity movie){
        return movieDAO.getRelatedMoviesNum(movie);
    }
}
