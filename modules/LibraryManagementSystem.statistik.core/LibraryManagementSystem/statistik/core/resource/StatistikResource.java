package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface StatistikResource {
    List<HashMap<String,Object>> getAllStatistik(VMJExchange vmjExchange);
}
