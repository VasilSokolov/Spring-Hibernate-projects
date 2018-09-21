package app.game.store.model.dto.json;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "game")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class GameDto {

    @Expose(serialize = true, deserialize = false)
    @XmlAttribute(name = "id")
    private Long id;

    @Expose
    @NotNull
    @Size(min = 2, max = 20, message = "Invalid title, must be between 2 and 30")
    @XmlElement
    private String title;

    @Expose
    private String youtubeId;

    @Expose
    @SerializedName("imageUrk")
    private String imageUrl;

    @Expose
    private Double size;

    @Expose
    private BigDecimal price;

    @Expose
    private String description;

    //	@Expose
    private Date releaseDate;

    @Expose
    @XmlElementWrapper(name = "users")
    @XmlElement(name = "user")
    private Set<UserDto> users;

    public GameDto() {
    }

    public GameDto(Long id, String title, String youtubeId, String imageUrl, Double size, BigDecimal price,
                   String description, Date releaseDate, Set<UserDto> users) {
        this.id = id;
        this.title = title;
        this.youtubeId = youtubeId;
        this.imageUrl = imageUrl;
        this.size = size;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<UserDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDto> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "GameDto [id=" + id + ", title=" + title + ", youtubeId=" + youtubeId + ", imageUrl=" + imageUrl
                + ", size=" + size + ", price=" + price + ", description=" + description + ", releaseDate="
                + releaseDate + ", users=" + users + "]";
    }


}
