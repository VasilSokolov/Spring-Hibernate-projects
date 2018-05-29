package db_advanced.ingredients.product;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "label")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ClassicLabel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Basic
	private String title;
	
	@Basic
	private String subtitle;
	
	@OneToOne(mappedBy = "label", targetEntity = BasicShampoo.class)
	private BasicShampoo basicShampoo;
	
	public ClassicLabel(String title, String subtitle) {
		this.title = title;
		this.subtitle = subtitle;
//		this.basicShampoo = basicShampoo;
	}

	public ClassicLabel() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getId() {
		return id;
	}

	public BasicShampoo getBasicShampoo() {
		return basicShampoo;
	}

	public void setBasicShampoo(BasicShampoo basicShampoo) {
		this.basicShampoo = basicShampoo;
	}
}
