package LibraryManagementSystem.review.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ReviewResource {
    HashMap<String, Object> getReview(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllReview(VMJExchange vmjExchange);
	HashMap<String, Object> createReview(VMJExchange vmjExhange);
}
