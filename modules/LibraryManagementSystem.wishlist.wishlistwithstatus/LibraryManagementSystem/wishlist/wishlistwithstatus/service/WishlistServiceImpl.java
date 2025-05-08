package LibraryManagementSystem.wishlist.wishlistwithstatus;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.wishlist.core.WishlistServiceDecorator;
import LibraryManagementSystem.wishlist.core.WishlistImpl;
import LibraryManagementSystem.wishlist.core.WishlistServiceComponent;

public class WishlistServiceImpl extends WishlistServiceDecorator {
    public WishlistServiceImpl (WishlistServiceComponent record) {
        super(record);
    }

	public void updateStatus(UUID bookId, String newStatus) {
		// TODO: implement this method
	}
}
