package bit.ss.recommendSystem.modules.entity;

import lombok.Data;

@Data
public class MovieEntity {
    String id;
    String movieName;
    String showDate;
    String director;
    String actors;
    String picture;
    Integer rating;
    String description;
    String types;
}
