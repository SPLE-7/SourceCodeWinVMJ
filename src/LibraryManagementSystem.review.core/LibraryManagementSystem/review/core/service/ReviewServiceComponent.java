package LibraryManagementSystem.review.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

import LibraryManagementSystem.buku.core.Buku;

public abstract class ReviewServiceComponent implements ReviewService{
	protected RepositoryUtil<Review> reviewRepository;
    protected RepositoryUtil<Buku> bukuRepository;

    public ReviewServiceComponent(){
        this.reviewRepository = new RepositoryUtil<Review>(LibraryManagementSystem.review.core.ReviewComponent.class);
        this.bukuRepository = new RepositoryUtil<Buku>(LibraryManagementSystem.buku.core.BukuComponent.class);
    }	

    public abstract Review createReview(Map<String, Object> requestBodye);
    public abstract HashMap<String, Object> getReview(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllReview(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Review> List);

}
