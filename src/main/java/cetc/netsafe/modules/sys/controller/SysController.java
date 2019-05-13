package cetc.netsafe.modules.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cetc.netsafe.modules.sys.service.SysService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/sys")
public class SysController {
	
    @Autowired
    private SysService sysService;
    
    @ApiOperation(value="/addMovie", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int")
    @RequestMapping(value="/addMovie/{id}", method=RequestMethod.GET)
    public boolean addMobie(@PathVariable("id")int id) {
        return sysService.addMovie(id);
    }
    
    @ApiOperation(value="/findOneMovie", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String")
    @RequestMapping(value="/findOneMovie/{id}", method=RequestMethod.GET)
    public List<Map<Object, Object>> findOneMovie(@PathVariable("id")String id){
        return sysService.findOneMovie(Long.parseLong(id));
    }
}
