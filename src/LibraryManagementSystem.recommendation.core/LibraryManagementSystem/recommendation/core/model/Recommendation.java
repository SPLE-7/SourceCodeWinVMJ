package LibraryManagementSystem.recommendation.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import LibraryManagementSystem.buku.core.Buku;

public interface Recommendation {
	public Buku getDaftarbukuimpl();
	public void setDaftarbukuimpl(Buku daftarbukuimpl);
	HashMap<String, Object> toHashMap();
}
