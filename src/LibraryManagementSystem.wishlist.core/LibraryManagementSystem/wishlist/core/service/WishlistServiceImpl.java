package LibraryManagementSystem.wishlist.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import LibraryManagementSystem.wishlist.WishlistFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

import LibraryManagementSystem.buku.core.Buku;
import vmj.auth.model.core.User;

public class WishlistServiceImpl extends WishlistServiceComponent{

    public Wishlist createWishlist(Map<String, Object> requestBody){
		
		// TODO: MASIH BINGUNG
		User akunimpl = userRepository.getObject(UUID.fromString((String) requestBody.get("id")));
		Buku daftarbukuimpl = bukuRepository.getObject(UUID.fromString((String) requestBody.get("idBuku")));
		//to do: fix association attributes
		Wishlist wishlist = WishlistFactory.createWishlist(
			"LibraryManagementSystem.wishlist.core.WishlistImpl",
		akunimpl
		, daftarbukuimpl);
		wishlistRepository.saveObject(wishlist);
		return wishlist;
	}

    public HashMap<String, Object> getWishlist(Map<String, Object> requestBody){
		List<HashMap<String, Object>> wishlistList = getAllWishlist(requestBody);
		for (HashMap<String, Object> wishlist : wishlistList){
			UUID recordId = UUID.fromString((String) wishlist.get("idWishlist"));
			if (recordId.equals(requestBody.get("idWishlist"))){
				return wishlist;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllWishlist(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Wishlist> List = wishlistRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Wishlist> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteWishlist(Map<String, Object> requestBody){
		UUID recordId = UUID.fromString((String) requestBody.get("idWishlist"));
		wishlistRepository.deleteObject(recordId);
		return getAllWishlist(requestBody);
	}
}
