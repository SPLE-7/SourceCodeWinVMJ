package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class RecommendationResourceDecorator extends RecommendationResourceComponent{
	protected RecommendationResourceComponent record;

    public RecommendationResourceDecorator(RecommendationResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> getAllRecommendation(VMJExchange vmjExchange){
		return record.getAllRecommendation(vmjExchange);
	}
}
