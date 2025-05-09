package LibraryManagementSystem.review.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import LibraryManagementSystem.buku.core.Buku;
import LibraryManagementSystem.buku.core.BukuComponent;

@Entity
@Table(name="review_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ReviewComponent implements Review{
	@Id
	protected UUID idReview; 

	protected String postedAt;

  @ManyToOne(targetEntity=LibraryManagementSystem.buku.core.BukuComponent.class)
	public Buku daftarbukuimpl;

	protected String objectName = ReviewComponent.class.getName();

	public ReviewComponent() {

	} 

	public ReviewComponent(
        UUID idReview, String postedAt, Buku daftarbukuimpl
    ) {
        this.idReview = idReview;
        this.postedAt = postedAt;
        this.daftarbukuimpl = daftarbukuimpl;
    }

	public UUID getIdReview() {
		return this.idReview;
	}

	public void setIdReview(UUID idReview) {
		this.idReview = idReview;
	}
	public String getPostedAt() {
		return this.postedAt;
	}

	public void setPostedAt(String postedAt) {
		this.postedAt = postedAt;
	}
	
	public Buku getDaftarbukuimpl() {
		return this.daftarbukuimpl;
	}

	public void setDaftarbukuimpl(Buku daftarbukuimpl) {
		this.daftarbukuimpl = daftarbukuimpl;
	}
	

	@Override
    public String toString() {
        return "{" +
            " idReview='" + getIdReview() + "'" +
            " postedAt='" + getPostedAt() + "'" +
            " daftarbukuimpl='" + getDaftarbukuimpl() + "'" +
            "}";
    }
	
}
