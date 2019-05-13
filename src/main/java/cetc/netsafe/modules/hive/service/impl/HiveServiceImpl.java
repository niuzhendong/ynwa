package cetc.netsafe.modules.hive.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cetc.netsafe.datasource.annotation.DataSource;
import cetc.netsafe.datasource.annotation.DataSourceType;
import cetc.netsafe.modules.hive.dao.HiveDao;
import cetc.netsafe.modules.hive.service.HiveService;

@Service
public class HiveServiceImpl implements HiveService {

	@Autowired
	private HiveDao hiveDao;
	
	@Override
	@DataSource(DataSourceType.Hive)
    @Cacheable(value = "hive.mov", key = "#id", condition = "#id!=null")
	public List<Map<String, String>> findOneMovie(long id) {
		// TODO Auto-generated method stub
		return hiveDao.findOneMovie(id);
	}

}
