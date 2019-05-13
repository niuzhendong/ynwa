package cetc.netsafe.modules.sys.service;

import java.util.List;
import java.util.Map;

public interface SysService {
    boolean addMovie(int id);
    List<Map<Object, Object>> findOneMovie(long id);
}
