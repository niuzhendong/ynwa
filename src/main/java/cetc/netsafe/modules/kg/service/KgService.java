package cetc.netsafe.modules.kg.service;

import java.util.List;
import java.util.Map;

import cetc.netsafe.modules.kg.model.Movie;
/**
 * kg
 *
 * @author niuzhendong
 * @email niuzhendong@cetcbigdata.com
 * @date 2019-5-11
 */
public interface KgService {
    boolean addMovie(Movie movie);
    List<Map<Object, Object>> findOneMovie(long id);
}
