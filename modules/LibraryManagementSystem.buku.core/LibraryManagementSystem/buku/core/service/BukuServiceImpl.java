package LibraryManagementSystem.buku.core;
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
import LibraryManagementSystem.buku.BukuFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class BukuServiceImpl extends BukuServiceComponent{

    public Buku createBuku(Map<String, Object> requestBody){
		String judulBuku = (String) requestBody.get("judulBuku");
		String penulis = (String) requestBody.get("penulis");
		String penerbit = (String) requestBody.get("penerbit");
		String jumlahHalamanStr = (String) requestBody.get("jumlahHalaman");
		int jumlahHalaman = Integer.parseInt(jumlahHalamanStr);
		String deskripsiBuku = (String) requestBody.get("deskripsiBuku");
		String genre = (String) requestBody.get("genre");
		
		//to do: fix association attributes
		Buku buku = BukuFactory.createBuku(
			"LibraryManagementSystem.buku.core.BukuImpl"
		, judulBuku
		, penulis
		, penerbit
		, jumlahHalaman
		, deskripsiBuku
		, genre
		);
		bukuRepository.saveObject(buku);
		return buku;
	}

    public HashMap<String, Object> getBuku(Map<String, Object> requestBody){
		// TODO:Nama tabel
		List<HashMap<String, Object>> bukuList = getAllBuku(requestBody);
		for (HashMap<String, Object> buku : bukuList){
			UUID recordId = UUID.fromString((String) buku.get("idBuku"));
			// TODO:Masih bingung
			if (recordId.equals(requestBody.get("idBuku"))) {
				return buku;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllBuku(Map<String, Object> requestBody){
		// TODO:Nama tabel
		String table = (String) requestBody.get("table_name");
		List<Buku> List = bukuRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Buku> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteBuku(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("idBuku"));
		UUID recordId = UUID.fromString(idStr);
		bukuRepository.deleteObject(recordId);
		return getAllBuku(requestBody);
	}

}
