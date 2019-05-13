package cetc.netsafe.modules.kg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cetc.netsafe.modules.kg.model.Movie;
import cetc.netsafe.modules.kg.service.KgService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
/**
 * KG控制器
 *
 * @author niuzhendong
 * @email niuzhendong@cetcbigdata.com
 * @date 2019-5-11
 */
@RestController
@RequestMapping(value="/kg")
public class KgController {
	
    @Autowired
    private KgService kgService;
    
    @ApiOperation(value="/addMovie", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int")
    @RequestMapping(value="/addMovie/{id}", method=RequestMethod.GET)
    public boolean addMobie(@PathVariable("id")String id) {
        return kgService.addMovie(new Movie());
    }
    
    @ApiOperation(value="findOneMovie", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String")
    @RequestMapping(value="/findOneMovie/{id}", method=RequestMethod.GET)
    public List<Map<Object, Object>> findOneMovie(@PathVariable("id")String id){
        return kgService.findOneMovie(Long.parseLong(id));
    }
}
