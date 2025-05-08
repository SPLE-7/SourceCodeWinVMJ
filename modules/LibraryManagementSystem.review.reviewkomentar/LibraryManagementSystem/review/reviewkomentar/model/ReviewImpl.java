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

	public ReviewImpl() {
        super();
        this.objectName = ReviewImpl.class.getName();
    }
    
    public ReviewImpl(String commentValue) {
    	super();
		this.objectName = ReviewImpl.class.getName();
    }
	
	public ReviewImpl(ReviewComponent record, String commentValue) {
		super(record);
		this.objectName = ReviewImpl.class.getName();
	}
}
