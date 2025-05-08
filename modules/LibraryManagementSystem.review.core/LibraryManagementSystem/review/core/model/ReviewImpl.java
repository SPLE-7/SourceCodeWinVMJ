package LibraryManagementSystem.review.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import LibraryManagementSystem.buku.core.Buku;

@Entity(name="review_impl")
@Table(name="review_impl")
public class ReviewImpl extends ReviewComponent {

	public ReviewImpl(UUID idReview, Date postedAt, Buku daftarbukuimpl) {
		this.idReview = idReview;
		this.postedAt = postedAt;
		this.daftarbukuimpl = daftarbukuimpl;
	}

	public ReviewImpl(Date postedAt, Buku daftarbukuimpl) {
		this.idReview =  idReview.randomUUID();
		this.postedAt = postedAt;
		this.daftarbukuimpl = daftarbukuimpl;
	}

	public ReviewImpl() { }

	public UUID getIdReview() {
		return this.idReview;
	}

	public void setIdReview(UUID idReview) {
		this.idReview = idReview;
	}
	public Date getPostedAt() {
		return this.postedAt;
	}

	public void setPostedAt(Date postedAt) {
		this.postedAt = postedAt;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> reviewMap = new HashMap<String,Object>();
		reviewMap.put("idReview",getIdReview());
		reviewMap.put("postedAt",getPostedAt());
		reviewMap.put("daftarbukuimpl",getDaftarbukuimpl());

        return reviewMap;
    }
}
