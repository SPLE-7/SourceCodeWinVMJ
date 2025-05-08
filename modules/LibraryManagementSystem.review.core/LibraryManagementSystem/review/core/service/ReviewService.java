package LibraryManagementSystem.review.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ReviewService {
	Review createReview(Map<String, Object> requestBody);
	HashMap<String, Object> getReview(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllReview(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Review> List);
}
