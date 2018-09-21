package app.game.store.model.dto.binding;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import app.game.store.model.entity.User;

public class GameBindingModel {

    private Long id;
    private String title;
    private String youtubeId;
    private String imageUrl;
    private Double size;
    private BigDecimal price;
    private String description;
    private Date releaseDate;
    private Set<User> users;
}
