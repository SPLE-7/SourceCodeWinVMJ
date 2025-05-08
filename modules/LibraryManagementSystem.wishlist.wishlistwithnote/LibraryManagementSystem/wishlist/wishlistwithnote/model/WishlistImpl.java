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

	public Map<UUID, String> notes;
	public WishlistImpl() {
        super();
        this.objectName = WishlistImpl.class.getName();
    }
    
    public WishlistImpl(Map<UUID, String> notes) {
    	super();
		this.notes = notes;
		this.objectName = WishlistImpl.class.getName();
    }
	
	public WishlistImpl(WishlistComponent record, Map<UUID, String> notes) {
		super(record);
		this.notes = notes;
		this.objectName = WishlistImpl.class.getName();
	}


	public void updateNote(UUID bookId, String newNotes) {
		// TODO: implement this method
	}
}
