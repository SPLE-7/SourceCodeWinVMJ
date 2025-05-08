package LibraryManagementSystem.review.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import LibraryManagementSystem.review.ReviewFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class ReviewResourceImpl extends ReviewResourceComponent{
	
	private ReviewServiceImpl reviewServiceImpl = new ReviewServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/review")
    public HashMap<String,Object> createReview(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Review result = reviewServiceImpl.createReview(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/review/detail")
    public HashMap<String, Object> getReview(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reviewServiceImpl.getReview(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/review/list")
    public List<HashMap<String,Object>> getAllReview(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reviewServiceImpl.getAllReview(requestBody);
	}
}
