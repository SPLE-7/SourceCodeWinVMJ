package LibraryManagementSystem.review.reviewbintang;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import LibraryManagementSystem.review.core.ReviewDecorator;
import LibraryManagementSystem.review.core.Review;
import LibraryManagementSystem.review.core.ReviewComponent;

@Entity(name="review_reviewbintang")
@Table(name="review_reviewbintang")
public class ReviewImpl extends ReviewDecorator {

	protected int starValue;
	public ReviewImpl() {
        super();
        this.objectName = ReviewImpl.class.getName();
    }
    
    public ReviewImpl(int starValue) {
    	super();
		this.starValue = starValue;
		this.objectName = ReviewImpl.class.getName();
    }
	
	public ReviewImpl(ReviewComponent record, int starValue) {
		super(record);
		this.starValue = starValue;
		this.objectName = ReviewImpl.class.getName();
	}

	public int getStarValue() {
		return this.starValue;
	}

	public void setStarValue(int starValue) {
		this.starValue = starValue;
	}
}
