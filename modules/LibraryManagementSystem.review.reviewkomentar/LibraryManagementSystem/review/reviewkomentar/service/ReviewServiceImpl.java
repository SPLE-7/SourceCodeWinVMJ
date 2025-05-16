package LibraryManagementSystem.review.reviewkomentar;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.review.core.ReviewServiceDecorator;
import LibraryManagementSystem.review.core.ReviewImpl;
import LibraryManagementSystem.review.core.Review;
import LibraryManagementSystem.review.core.ReviewServiceComponent;
import LibraryManagementSystem.review.ReviewFactory;

public class ReviewServiceImpl extends ReviewServiceDecorator {
    public ReviewServiceImpl (ReviewServiceComponent record) {
        super(record);
    }

    public Review createReviewComment(Map<String, Object> requestBody){
  
        String comment = (String) requestBody.get("comment");

        Review reviewComment = ReviewFactory.createReview(
          "LibraryManagementSystem.review.reviewkomentar.ReviewImpl"
        , record.createReview(requestBody)
        , comment
        );

        reviewRepository.saveObject(reviewComment);
        return reviewComment;
      }

      public List<HashMap<String,Object>> getAllReviewComment(Map<String, Object> requestBody){
        String table = "review_reviewkomentar";
        List<Review> List = reviewRepository.getAllObject(table);
        return this.transformListToHashMap(List);
      }
    
        public List<HashMap<String,Object>> transformListToHashMap(List<Review> List){
        List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
            for(int i = 0; i < List.size(); i++) {
                resultList.add(List.get(i).toHashMap());
            }
    
            return resultList;
      }

}
