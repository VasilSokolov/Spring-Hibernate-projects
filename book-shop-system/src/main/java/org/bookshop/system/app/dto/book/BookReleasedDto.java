package org.bookshop.system.app.dto.book;

import java.math.BigDecimal;

public class BookReleasedDto {

    private String title;
    private String editionType;
    private BigDecimal price;

    public BookReleasedDto() {
    }

    public BookReleasedDto(String title, String editionType, BigDecimal price) {
        this.title = title;
        this.editionType = editionType;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditionType() {
        return editionType;
    }

    public void setEditionType(String editionType) {
        this.editionType = editionType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookReleasedDto [title=" + title + ", editionType=" + editionType + ", price=" + price + "]";
    }


}
