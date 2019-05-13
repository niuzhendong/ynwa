package cetc.netsafe.modules.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cetc.netsafe.datasource.annotation.DataSource;
import cetc.netsafe.datasource.annotation.DataSourceType;
import cetc.netsafe.modules.sys.dao.SysDao;
import cetc.netsafe.modules.sys.service.SysService;

@Service
public class SysServiceImpl implements SysService {

    @Autowired
    private SysDao sysDao;

    @Override
    @DataSource(DataSourceType.Mysql)
    public boolean addMovie(int id){
        return sysDao.save(id);
    }
    @Override
    @DataSource(DataSourceType.Mysql)
    @Cacheable(value = "sys.mov", key = "#id", condition = "#id!=null")
    public List<Map<Object, Object>> findOneMovie(long id){
        return sysDao.findById(id);
    }
}
