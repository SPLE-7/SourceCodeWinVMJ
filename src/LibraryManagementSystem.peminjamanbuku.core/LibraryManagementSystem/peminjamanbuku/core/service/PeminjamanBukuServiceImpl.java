package LibraryManagementSystem.peminjamanbuku.core;
import java.util.*;
import com.google.gson.Gson;
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
import LibraryManagementSystem.peminjamanbuku.PeminjamanBukuFactory;
import vmj.auth.annotations.Restricted;

import java.util.Map;

import LibraryManagementSystem.buku.core.Buku;
import vmj.auth.model.core.User;

public class PeminjamanBukuServiceImpl extends PeminjamanBukuServiceComponent{

    public PeminjamanBuku createPeminjamanBuku(Map<String, Object> requestBody) {
		String status = (String) requestBody.get("status");
		Buku daftarbukuimpl = bukuRepository.getObject(UUID.fromString((String) requestBody.get("idBuku")));
		
		// Perhatikan nama id user yang dipakai di frontend atau API
		User akunimpl = userRepository.getObject(UUID.fromString((String) requestBody.get("id")));

    String tanggalPeminjaman = (String) requestBody.get("tanggalPeminjaman");
    String tanggalPengembalian = (String) requestBody.get("tanggalPengembalian");

		PeminjamanBuku peminjamanbuku = PeminjamanBukuFactory.createPeminjamanBuku(
			"LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuImpl",
			status,
			akunimpl,
			daftarbukuimpl,
			tanggalPeminjaman,
			tanggalPengembalian
		);
	
		peminjamanRepository.saveObject(peminjamanbuku);
		return peminjamanbuku;
	}

    public HashMap<String, Object> getPeminjamanBuku(Map<String, Object> requestBody){
		List<HashMap<String, Object>> peminjamanbukuList = getAllPeminjamanBuku(requestBody);
		for (HashMap<String, Object> peminjamanbuku : peminjamanbukuList){

			UUID recordId = (UUID) peminjamanbuku.get("idPeminjamanBuku");
      UUID id = UUID.fromString((String) requestBody.get("idPeminjamanBuku"));
			if (recordId.equals(id)){
				return peminjamanbuku;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllPeminjamanBuku(Map<String, Object> requestBody){
		String table = "peminjamanbuku_impl";
		List<PeminjamanBuku> List = peminjamanRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<PeminjamanBuku> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

}
