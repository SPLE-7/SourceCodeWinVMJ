package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import LibraryManagementSystem.statistik.StatistikFactory;
import vmj.auth.annotations.Restricted;

import LibraryManagementSystem.buku.core.Buku;
//add other required packages

public class StatistikResourceImpl extends StatistikResourceComponent{
	
	private StatistikServiceImpl statistikServiceImpl = new StatistikServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/statistik/list")
    public List<HashMap<String,Object>> getAllStatistik(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return statistikServiceImpl.getAllStatistik(requestBody);
	}

	public int hitungTotalBuku() {
		return statistikServiceImpl.hitungTotalBuku();
	}

	@Route(url="call/statistik/list/object")
    public List<Buku> getListObject(){
		return statistikServiceImpl.getListObject();
	}
}
