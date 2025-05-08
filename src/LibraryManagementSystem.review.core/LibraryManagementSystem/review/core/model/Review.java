package LibraryManagementSystem.review.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import LibraryManagementSystem.buku.core.Buku;

public interface Review {
	public UUID getIdReview();
	public void setIdReview(UUID idReview);
	public Date getPostedAt();
	public void setPostedAt(Date postedAt);
	public Buku getDaftarbukuimpl();
	public void setDaftarbukuimpl(Buku daftarbukuimpl);
	HashMap<String, Object> toHashMap();
}
