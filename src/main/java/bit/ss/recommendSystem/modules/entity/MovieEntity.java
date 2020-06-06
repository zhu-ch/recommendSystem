package bit.ss.recommendSystem.modules.entity;

import bit.ss.recommendSystem.common.persistence.DataEntity;
import lombok.Data;

@Data
public class MovieEntity extends DataEntity<MovieEntity> {
    int id;
    String movieName;
    String showDate;
    String director;
    String actors;
    String picture;
    float rating;
    String description;
    String types;
}
