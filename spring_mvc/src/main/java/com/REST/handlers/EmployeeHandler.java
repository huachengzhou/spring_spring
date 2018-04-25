package com.REST.handlers;

import com.REST.dao.DepartmentDao;
import com.REST.dao.EmployeeDao;
import com.REST.entities.Employee;
import com.common.ControllerEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class EmployeeHandler {
    private final String HOME = ControllerEnum.View.getVar()+ControllerEnum.REST_NUM.getVar();
    private Logger logger = Logger.getAnonymousLogger();

    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private DepartmentDao departmentDao;

    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id",required = false)Integer id, Map<String,Object> map){
        if (id!=null)map.put("employee",employeeDao.get(id));
        logger.info("getEmployee()");
        logger.info("employee:"+employeeDao.get(id));
    }

    @RequestMapping(value = "/REST/updateEmployee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){//REST API PUT
        employeeDao.save(employee);
        logger.info("updateEmployee()");
        logger.info(""+employee);
        return "redirect:/REST/emps";
    }

    @RequestMapping(value = "/REST/emp/{id}",method = RequestMethod.GET)
    public String input(@PathVariable(value = "id")Integer id, Map<String,Object> map){
        map.put("employee",employeeDao.get(id));
        map.put("departments",departmentDao.getDepartments());//REST API GET
        Map<String,String> genders = new HashMap<>();
        genders.put("1", "Male");
        genders.put("0", "Female");
        map.put("genders",genders);//put map
        return HOME + "input";
    }

    /**
     * 显示所有　员工信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/REST/emps")
    public String list(Map<String, Object> map) {
        map.put("employees", employeeDao.getAll());
        logger.info("list()");
        map.entrySet().iterator().forEachRemaining((m) -> logger.info("key:" + m.getKey() + " value:" + m.getValue()));
        return HOME + "list";
    }

    /**
     * Add Employee
     * @param map
     * @return
     */
    @RequestMapping(value = "/REST/emp")
    public String addEmp(Map<String, Object> map) {
        Map<String,String> genders = new HashMap<>();
        genders.put("1", "Male");
        genders.put("0", "Female");
        map.put("genders",genders);//put map
        map.put("employee", new Employee());
        map.put("departments",departmentDao.getDepartments());
        logger.info("emp()");
        logger.info("" + map);
        return HOME + "empInput";
    }

    /**
     * save employee
     * @param employee
     * @return
     */
    @RequestMapping(value = "/REST/saveEmp",method = RequestMethod.POST)
    public String saveEmp(Employee employee){//REST api POST
        employeeDao.save(employee);
        logger.info("redirect:/emps");
        logger.info(""+employee);
        return "redirect:/REST/emps";
    }

    /**
     * remove employee
     * @param id
     * @return
     */
    @RequestMapping(value = "/REST/removeEmp/{id}",method = RequestMethod.DELETE)
    public String removeEmp(@PathVariable(value = "id") Integer id){//REST api DELETE
        employeeDao.delete(id);
        logger.info("removeEmployee");
        return "redirect:/REST/emps";
    }

//    @InitBinder    //对属性某一个对象不赋值
//    public void  initBind(WebDataBinder binder){
//        binder.setDisallowedFields("lastName");
//    }
}
