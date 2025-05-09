package LibraryManagementSystem.wishlist.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;

import LibraryManagementSystem.buku.core.Buku;

@MappedSuperclass
public abstract class WishlistDecorator extends WishlistComponent {
    @OneToOne(cascade = CascadeType.ALL)
    protected WishlistComponent record;

    public WishlistDecorator() {
        super();
        this.record = record;
        this.idWishlist = UUID.randomUUID();
    }

    public WishlistDecorator(WishlistComponent record) {
        this.record = record;
        this.idWishlist = UUID.randomUUID();
    }

    public WishlistDecorator(UUID idWishlist, WishlistComponent record) {

      this.record = record;
      this.idWishlist =  idWishlist;
    }

    public WishlistDecorator(WishlistComponent record, String objectName) {
        super();
        this.record = record;
        this.objectName = objectName;
    }

    public UUID getIdWishlist() {
      return record.getIdWishlist();
    }
  
    public void setIdWishlist(UUID idWishlist) {
      record.idWishlist = idWishlist;
    }
  
      public User getAkunimpl() {
      return record.getAkunimpl();
    }
  
    public void setAkunimpl(User akunimpl) {
      record.akunimpl = akunimpl;
    }
  
      public Buku getDaftarbukuimpl() {
      return record.getDaftarbukuimpl();
    }
  
    public void setDaftarbukuimpl(Buku daftarbukuimpl) {
      record.daftarbukuimpl = daftarbukuimpl;
    }

    public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }
}
