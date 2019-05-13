package cetc.netsafe.modules.hive.service;

import java.util.List;
import java.util.Map;

/**
 * hive
 *
 * @author niuzhendong
 * @email niuzhendong@cetcbigdata.com
 * @date 2019-5-11
 */
public interface HiveService {
	List<Map<String, String>> findOneMovie(long id);
}
