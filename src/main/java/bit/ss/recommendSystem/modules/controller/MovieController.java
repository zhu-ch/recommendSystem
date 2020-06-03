package bit.ss.recommendSystem.modules.controller;

import bit.ss.recommendSystem.common.persistence.Page;
import bit.ss.recommendSystem.common.web.BaseApi;
import bit.ss.recommendSystem.common.web.MsgType;
import bit.ss.recommendSystem.modules.Service.MovieService;
import bit.ss.recommendSystem.modules.entity.MovieEntity;
import bit.ss.recommendSystem.modules.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/movie")
public class MovieController extends BaseApi {
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "getHomepageMovies", method = RequestMethod.POST)
    @ResponseBody
    public Object getHomepageMovies(@RequestBody UserEntity user) {
        try {
            Page<MovieEntity> page = new Page<>();
            page.setResultList(movieService.getHomepageMovies(user));
            page.setTotal(movieService.getHomepageMovieNum(user));
            return retMsg.Set(MsgType.SUCCESS, page);
        } catch (Exception e) {
            e.printStackTrace();
            return retMsg.Set(MsgType.ERROR, e.toString());
        }
    }

    @RequestMapping(value = "getMoviesByName", method = RequestMethod.POST)
    @ResponseBody
    public Object getMoviesByName(@RequestBody MovieEntity movie) {
        try {
            Page<MovieEntity> page = new Page<>();
            page.setResultList(movieService.getMoviesByName(movie));
            page.setTotal(movieService.getMoviesNumByName(movie));
            return retMsg.Set(MsgType.SUCCESS, page);
        } catch (Exception e) {
            e.printStackTrace();
            return retMsg.Set(MsgType.ERROR, e.toString());
        }
    }

    @RequestMapping(value = "getMovieDetails", method = RequestMethod.POST)
    @ResponseBody
    public Object getMovieDetails(@RequestParam String userName, @RequestBody MovieEntity movie) {
        try {
            return movieService.getMovieDetails(movie, userName);
        } catch (Exception e) {
            e.printStackTrace();
            return retMsg.Set(MsgType.ERROR, e.toString());
        }
    }
}
