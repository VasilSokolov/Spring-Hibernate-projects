package app.game.store.model.dto.json;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.google.gson.annotations.Expose;

public class GameDto {

	@Expose
	private Long id;

	@Expose
	private String title;

	@Expose
	private String youtubeId;

	@Expose
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
