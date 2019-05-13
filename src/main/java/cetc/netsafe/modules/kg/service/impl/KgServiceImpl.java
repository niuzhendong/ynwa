package cetc.netsafe.modules.kg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cetc.netsafe.datasource.annotation.DataSource;
import cetc.netsafe.datasource.annotation.DataSourceType;
import cetc.netsafe.modules.kg.dao.KgDao;
import cetc.netsafe.modules.kg.model.Movie;
import cetc.netsafe.modules.kg.service.KgService;
/**
 * kg
 *
 * @author niuzhendong
 * @email niuzhendong@cetcbigdata.com
 * @date 2019-5-11
 */
@Service
public class KgServiceImpl implements KgService {

    @Autowired
    private KgDao kgDao;

    @Override
    @DataSource(DataSourceType.Neo4j)
    public boolean addMovie(Movie movie){
        return kgDao.save(movie);
    }
    @Override
    @DataSource(DataSourceType.Neo4j)
    @Cacheable(value = "kg.mov", key = "#id", condition = "#id!=null")
    public List<Map<Object, Object>> findOneMovie(long id){
        return kgDao.findById(id);
    }
}
