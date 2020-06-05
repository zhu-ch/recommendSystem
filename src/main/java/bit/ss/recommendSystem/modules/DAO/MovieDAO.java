package bit.ss.recommendSystem.modules.DAO;

import bit.ss.recommendSystem.modules.entity.MovieEntity;
import bit.ss.recommendSystem.modules.entity.UserEntity;

import java.util.List;

public interface MovieDAO {
    List<MovieEntity> getDefaultMovie();
    int getDefaultMovieNum();

    List<MovieEntity> getMoviesByName(MovieEntity movie);
    int getMoviesNumByName(MovieEntity movie);

    List<MovieEntity> getRecommendMovieById(UserEntity user);
    int getRecommendMovieNumById(UserEntity user);

    List<MovieEntity> getRelatedMovies(MovieEntity movie);
    int getRelatedMoviesNum(MovieEntity movie);

    MovieEntity getMovieById(int id);
}
