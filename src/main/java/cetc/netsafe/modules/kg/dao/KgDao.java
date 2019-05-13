package cetc.netsafe.modules.kg.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cetc.netsafe.modules.kg.model.Movie;
/**
 * kgDao
 *
 * @author niuzhendong
 * @email niuzhendong@cetcbigdata.com
 * @date 2019-5-11
 */
@Repository
public interface KgDao {

	boolean save(Movie movie);

	List<Map<Object,Object>> findById(long id);
	
}
