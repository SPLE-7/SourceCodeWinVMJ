package LibraryManagementSystem.review.reviewkomentar;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.review.core.ReviewServiceDecorator;
import LibraryManagementSystem.review.core.ReviewImpl;
import LibraryManagementSystem.buku.core.Buku;
import LibraryManagementSystem.review.core.ReviewServiceComponent;

public class ReviewServiceImpl extends ReviewServiceDecorator {
    public ReviewServiceImpl (ReviewServiceComponent record) {
        super(record);
    }

    public List<Buku> getListObject(Map<String, Object> requestBody){
        return bukuRepository.getAllObject("buku_comp");
    }
    
}
