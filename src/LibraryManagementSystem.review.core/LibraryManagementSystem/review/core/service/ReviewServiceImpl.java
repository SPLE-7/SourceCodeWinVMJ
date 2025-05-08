package LibraryManagementSystem.review.core;
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
import LibraryManagementSystem.review.ReviewFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

import java.time.LocalDate;

import LibraryManagementSystem.buku.core.Buku;

public class ReviewServiceImpl extends ReviewServiceComponent{

    public Review createReview(Map<String, Object> requestBody){
		Buku daftarbukuimpl = bukuRepository.getObject(UUID.fromString((String) requestBody.get("idBuku")));
		LocalDate postedAt = LocalDate.now();
		//to do: fix association attributes
		Review review = ReviewFactory.createReview(
			"LibraryManagementSystem.review.core.ReviewImpl"
		, postedAt
		, daftarbukuimpl
		);
		reviewRepository.saveObject(review);
		return review;
	}

    public HashMap<String, Object> getReview(Map<String, Object> requestBody){
		List<HashMap<String, Object>> reviewList = getAllReview(requestBody);
		for (HashMap<String, Object> review : reviewList){
			UUID recordId = UUID.fromString((String) review.get("idReview"));
			if (recordId.equals(requestBody.get("idReview"))){
				return review;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllReview(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Review> List = reviewRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Review> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

}
