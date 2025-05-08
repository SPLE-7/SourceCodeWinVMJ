package LibraryManagementSystem.wishlist.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import LibraryManagementSystem.buku.core.Buku;
import vmj.auth.model.core.User;

@Entity(name = "wishlist_impl")
@Table(name = "wishlist_impl")
public class WishlistImpl extends WishlistComponent {

    public WishlistImpl(User akunimpl, Buku daftarbukuimpl) {
        this.akunimpl = akunimpl;
        this.daftarbukuimpl = daftarbukuimpl;
        this.idWishlist = UUID.randomUUID();
    }

    public WishlistImpl() {
        this.idWishlist = UUID.randomUUID();
    }

    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> wishlistMap = new HashMap<>();
        wishlistMap.put("akunimpl", getAkunimpl());
        wishlistMap.put("daftarbukuimpl", getDaftarbukuimpl());
        return wishlistMap;
    }
}
