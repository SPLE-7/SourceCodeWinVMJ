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

    public WishlistImpl(UUID idWishlist, User akunimpl, Buku daftarbukuimpl) {
        this.idWishlist = idWishlist;
        this.akunimpl = akunimpl;
        this.daftarbukuimpl = daftarbukuimpl;
    }

    public WishlistImpl() {}

    public UUID getIdWishlist() {
        return this.idWishlist;
    }

    public void setIdWishlist(UUID idWishlist) {
        this.idWishlist = idWishlist;
    }

    public User getAkunimpl() {
        return this.akunimpl;
    }

    public void setAkunimpl(User akunimpl) {
        this.akunimpl = akunimpl;
    }

    public Buku getDaftarbukuimpl() {
        return this.daftarbukuimpl;
    }

    public void setDaftarbukuimpl(Buku daftarbukuimpl) {
        this.daftarbukuimpl = daftarbukuimpl;
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> wishlistMap = new HashMap<>();
        System.out.println(getIdWishlist() + " Ini testing");
        wishlistMap.put("idWishlist", getIdWishlist());
        wishlistMap.put("akunimpl", getAkunimpl());
        wishlistMap.put("daftarbukuimpl", getDaftarbukuimpl());
        return wishlistMap;
    }
}
