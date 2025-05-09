package LibraryManagementSystem.wishlist.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import LibraryManagementSystem.buku.core.Buku;
import vmj.auth.model.core.User;

public interface Wishlist {
    public UUID getIdWishlist();
    public void setIdWishlist(UUID idWishlist);

    User getAkunimpl();
    void setAkunimpl(User akunimpl);
    
    Buku getDaftarbukuimpl();
    void setDaftarbukuimpl(Buku daftarbukuimpl);
    
    HashMap<String, Object> toHashMap();
}
