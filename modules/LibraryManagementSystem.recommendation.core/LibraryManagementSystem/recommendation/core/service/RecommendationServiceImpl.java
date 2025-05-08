package LibraryManagementSystem.recommendation.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import LibraryManagementSystem.recommendation.RecommendationFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class RecommendationServiceImpl extends RecommendationServiceComponent{

    public List<HashMap<String,Object>> getAllRecommendation(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Recommendation> List = recommendationRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Recommendation> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

}
