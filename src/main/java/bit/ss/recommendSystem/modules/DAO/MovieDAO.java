package bit.ss.recommendSystem.modules.DAO;

import bit.ss.recommendSystem.modules.entity.MovieEntity;
import bit.ss.recommendSystem.modules.entity.UserEntity;

import java.util.List;

public interface MovieDAO {
    List<MovieEntity> getDefaultMovie();
    List<MovieEntity> getRecommendMovieById(UserEntity user);
    int getDefaultMovieNum();
    int getRecommendMovieNumById(UserEntity user);
    MovieEntity getMovieById(int id);
    List<MovieEntity> getMoviesByName(MovieEntity movie);
    int getMoviesNumByName(MovieEntity movie);
}
