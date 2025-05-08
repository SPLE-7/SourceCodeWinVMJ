package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import LibraryManagementSystem.recommendation.RecommendationFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class RecommendationResourceImpl extends RecommendationResourceComponent{
	
	private RecommendationServiceImpl recommendationServiceImpl = new RecommendationServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/recommendation/list")
    public List<HashMap<String,Object>> getAllRecommendation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return recommendationServiceImpl.getAllRecommendation(requestBody);
	}
}
