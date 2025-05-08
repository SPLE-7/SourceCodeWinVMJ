package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class RecommendationResourceComponent implements RecommendationResource{
	
	public RecommendationResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> getAllRecommendation(VMJExchange vmjExchange);
}
