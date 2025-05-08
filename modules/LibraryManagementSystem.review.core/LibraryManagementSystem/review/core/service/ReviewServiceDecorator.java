package LibraryManagementSystem.review.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class ReviewServiceDecorator extends ReviewServiceComponent{
	protected ReviewServiceComponent record;

    public ReviewServiceDecorator(ReviewServiceComponent record) {
        this.record = record;
    }

	public Review createReview(Map<String, Object> requestBody){
		return record.createReview(requestBody);
	}

	public HashMap<String, Object> getReview(Map<String, Object> requestBody){
		return record.getReview(requestBody);
	}

	public List<HashMap<String,Object>> getAllReview(Map<String, Object> requestBody){
		return record.getAllReview(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Review> List){
		return record.transformListToHashMap(List);
	}

}
