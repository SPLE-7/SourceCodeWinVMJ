package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface RecommendationResource {
    List<HashMap<String,Object>> getAllRecommendation(VMJExchange vmjExchange);
}
