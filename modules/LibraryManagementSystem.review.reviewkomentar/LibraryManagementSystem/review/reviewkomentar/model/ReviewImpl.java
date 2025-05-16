package LibraryManagementSystem.review.reviewkomentar;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import LibraryManagementSystem.review.core.ReviewDecorator;
import LibraryManagementSystem.review.core.Review;
import LibraryManagementSystem.review.core.ReviewComponent;

@Entity(name="review_reviewkomentar")
@Table(name="review_reviewkomentar")
public class ReviewImpl extends ReviewDecorator {

	protected String comment;
	public ReviewImpl() {
        super();
        this.objectName = ReviewImpl.class.getName();
    }
    
    public ReviewImpl(String commentValue) {
    	super();
		this.comment = commentValue;
		this.objectName = ReviewImpl.class.getName();
    }
	
	public ReviewImpl(ReviewComponent record, String commentValue) {
		super(record);
		this.comment = commentValue;
		this.objectName = ReviewImpl.class.getName();
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
    public String toString() {
        return "{" +
            " idReview='" + getIdReview() + "'" +
            " postedAt='" + getPostedAt() + "'" +
			" score='" + getScore() + "'" +
			" comment='" + getComment() + "'" +
            " daftarbukuimpl='" + getDaftarbukuimpl() + "'" +
            "}";
    }

	@Override
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> reviewMap = new HashMap<String,Object>();
		reviewMap.put("idReview",getIdReview());
		reviewMap.put("postedAt",getPostedAt());
		reviewMap.put("score",getScore());
		reviewMap.put("comment",getComment());
		reviewMap.put("daftarbukuimpl",getDaftarbukuimpl());

        return reviewMap;
    }
}
