package LibraryManagementSystem.wishlist.wishlistwithstatus;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import LibraryManagementSystem.wishlist.core.WishlistDecorator;
import LibraryManagementSystem.wishlist.core.Wishlist;
import LibraryManagementSystem.wishlist.core.WishlistComponent;

@Entity(name="wishlist_wishlistwithstatus")
@Table(name="wishlist_wishlistwithstatus")
public class WishlistImpl extends WishlistDecorator {

	public Map<UUID, String> status;
	public WishlistImpl() {
        super();
        this.objectName = WishlistImpl.class.getName();
    }
    
    public WishlistImpl(Map<UUID, String> status) {
    	super();
		this.status = status;
		this.objectName = WishlistImpl.class.getName();
    }
	
	public WishlistImpl(WishlistComponent record, Map<UUID, String> status) {
		super(record);
		this.status = status;
		this.objectName = WishlistImpl.class.getName();
	}


	public void updateStatus(UUID bookId, String newStatus) {
		// TODO: implement this method
	}
}
