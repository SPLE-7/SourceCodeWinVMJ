package LibraryManagementSystem.wishlist.wishlistwithnote;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import LibraryManagementSystem.wishlist.core.WishlistDecorator;
import LibraryManagementSystem.wishlist.core.Wishlist;
import LibraryManagementSystem.wishlist.core.WishlistComponent;

@Entity(name="wishlist_wishlistwithnote")
@Table(name="wishlist_wishlistwithnote")
public class WishlistImpl extends WishlistDecorator {

	public String notes;

	public WishlistImpl() {
        super();
        this.objectName = WishlistImpl.class.getName();
    }
    
    public WishlistImpl(String notes) {
    	super();
		this.notes = notes;
		this.objectName = WishlistImpl.class.getName();
    }
	
	public WishlistImpl(WishlistComponent record, String notes) {
		super(record);
		this.notes = notes;
		this.objectName = WishlistImpl.class.getName();
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public void updateNote(UUID bookId, String newNotes) {
		// TODO: implement this method
	}

	@Override
    public String toString() {
        return "{" +
            " idWishlist='" + getIdWishlist() + "'" +
			" notes='" + getNotes() + "'" +
            " akunimpl='" + getAkunimpl() + "'" +
            " daftarbukuimpl='" + getDaftarbukuimpl() + "'" +
            "}";
    }

	@Override
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> wishlistMap = new HashMap<>();
        System.out.println(getIdWishlist() + " Ini testing");
        wishlistMap.put("idWishlist", getIdWishlist());
		wishlistMap.put("notes", getNotes());
        wishlistMap.put("akunimpl", getAkunimpl());
        wishlistMap.put("daftarbukuimpl", getDaftarbukuimpl());
        return wishlistMap;
    }
}
