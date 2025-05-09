package LibraryManagementSystem.review.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import LibraryManagementSystem.buku.core.Buku;

public interface Review {
	public UUID getIdReview();
	public void setIdReview(UUID idReview);
	public String getPostedAt();
	public void setPostedAt(String postedAt);
	public Buku getDaftarbukuimpl();
	public void setDaftarbukuimpl(Buku daftarbukuimpl);
	HashMap<String, Object> toHashMap();
}
