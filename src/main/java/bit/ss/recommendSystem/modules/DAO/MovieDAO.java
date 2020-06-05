package bit.ss.recommendSystem.modules.DAO;

import bit.ss.recommendSystem.modules.entity.MovieEntity;
import bit.ss.recommendSystem.modules.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieDAO {
    List<MovieEntity> getDefaultMovie(int num);

    List<MovieEntity> getMoviesByName(MovieEntity movie);

    int getMoviesNumByName(MovieEntity movie);

    List<MovieEntity> getRecommendMovieById(UserEntity user);

    List<MovieEntity> getRelatedMovies(MovieEntity movie);

    MovieEntity getMovieById(int id);
}
