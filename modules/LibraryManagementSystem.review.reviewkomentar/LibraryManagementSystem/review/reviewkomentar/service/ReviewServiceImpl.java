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
  
        // Buku buku = this.record.createBuku(requestBody);
  
        String comment = (String) requestBody.get("comment");

        System.out.println("comment: " + comment);

        Review reviewComment = ReviewFactory.createReview(
          "LibraryManagementSystem.review.reviewkomentar.ReviewImpl"
        , record.createReview(requestBody)
        , comment
        );

        System.out.println("reviewKomentar: " + reviewComment);

        reviewRepository.saveObject(reviewComment);
        return reviewComment;
      }
}
