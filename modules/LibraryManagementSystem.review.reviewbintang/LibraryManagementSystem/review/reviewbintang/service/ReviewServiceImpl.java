package LibraryManagementSystem.review.reviewbintang;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.review.core.ReviewServiceDecorator;
import LibraryManagementSystem.review.core.ReviewImpl;
import LibraryManagementSystem.review.core.ReviewServiceComponent;

public class ReviewServiceImpl extends ReviewServiceDecorator {
    public ReviewServiceImpl (ReviewServiceComponent record) {
        super(record);
    }
}
