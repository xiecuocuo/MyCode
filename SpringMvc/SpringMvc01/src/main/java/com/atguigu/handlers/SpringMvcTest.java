package com.atguigu.handlers;

import com.atguigu.bean.Address;
import com.atguigu.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.util.Map;

@RequestMapping("/springmvc")
//@SessionAttributes(value ={"person"},types={Address.class})
@Controller
public class SpringMvcTest {
    private static final String SUCCESS="success";
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/WEB-INF/views/success.jsp";
    }
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        /*
        * redirect的路径一定不能在WEB-INF路径下，因为redirect是相当于用户直接访问了路径，
        * 而用户不能访问WEB-INF目录下的文件，只有程序内部转发的时候才能转发到WEB-INF下的JSP。
        * */
//        return "redirect:/WEB-INF/views/success.jsp";
        return "redirect:/index.jsp";
    }
    @RequestMapping("/testHelloView")
    public String testHelloView(){
        return "helloView";
    }
    /*
    * 1.有ModelAttribute标记的方法，会在每个目标方法执行之前被SpringMvc调用
    * 2。@ModelAttribute注解也可以来修饰目标方法POJO类型的入参，其value属性值有如下的作用：
    * 1）.SpringMvc会使用value属性值在implicitModel中查找对应的对象，若存在，则会直接传入到目标方法的入参中。
    * 2）.SpringMvc会以value为key,POJO的对象为value，存入request中。
    *
    * */
/*    @ModelAttribute
    public void getOldPersonData(@RequestParam("id") Integer id,Map<String,Object> map){
        if(id !=null){
            //模拟从数据库中获取对象
            Person p=new Person();
            p.setUsername("zhaoyuhui");
            p.setId(1);
            p.setPassword("123456");//取数据库中的数据
            System.out.println("从数据库中查询获取原始数据"+p);
            map.put("person",p);
        }
    }*/

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(/*@ModelAttribute */Person person){
        System.out.println("需要修改的数据为"+person);
        return SUCCESS;
    }
    /*
    * SessionAttributes不仅可以通过属性名指定放到Session中的属性，而且可以通过模型属性的对象类型指定哪些模型属性需要放到Session中
    * */
    @RequestMapping("/testSessionAttribute")
    public String testSessionAttribute(Map<String,Object> map){
        System.out.println("testSessionAttribute ---");
        Person person=new Person();
        person.setUsername("ynf");
        person.setPassword("123");
        Address address=new Address();
        address.setCity("卫辉");
        address.setProvince("河南");
        //添加模型数据到Map中
        map.put("person",person);
        map.put("address",address);
        return SUCCESS;
    }


    //SpringMvc会把Map中的模型数据放在request域对象中
    @RequestMapping("/testMap")
    public String testMap(Map map){//实际上可以是Model类型或者ModelMap类型的参数
        System.out.println("testModelAndView ---");
        //添加模型数据到Map中
        map.put("username","ynf");
        return SUCCESS;
    }
    //SpringMvc会把Model中的模型数据放在request域对象中
    @RequestMapping("/testModel")
    public String testModel(Model model){//实际上可以是Model类型或者ModelMap类型的参数
        System.out.println("testModelAndView ---");
        //添加模型数据到Model中
        model.addAttribute("username","ynf");
        return SUCCESS;
    }

    /*
    * 目标方法的返回值可以是ModelAndView类型
    * 其中可以包含视图和模型信息
    * SpringMvc会把modelAndView中的模型数据放在request域对象中
    * */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(ModelAndView modelAndView){
        System.out.println("testModelAndView ---");
        //添加模型数据到ModelAndView中
        modelAndView.addObject("username","ynf");
        modelAndView.setViewName(SUCCESS);
        return modelAndView;
    }

    /*
    * 使用Servlet原生Api作为目标方法的参数
    * */
    @RequestMapping("/testRequestApi")
    public String testRequestApi(HttpServletRequest request, HttpServletResponse response, Writer writer){
        System.out.println("testRequestApi-----request=:"+request+", response="+response+",writer:="+writer);
        return SUCCESS;
    }


    @RequestMapping("/testPojo")
    public String testPojo(Person person){
        System.out.println("testPojo: "+person);
        return SUCCESS;
    }

    /*
    * 了解：
    * @CookieValue:映射一个Cookie值，属性同@RequestParam
    * */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String id){
        System.out.println("testCookieValue: JSESSIONID="+id);
        return SUCCESS;
    }

    /*
    * 映射请求头信息
    * 用法同@RequestParam
    * 使用较少
    * */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Language") String al){
        System.out.println("testRequestHeader: Accept-Language="+al);
        return SUCCESS;
    }

    /*
    * RequestParam来映射请求参数
    * value值及请求参数的值
    * required:该参数值是否必须，默认是true
    * defaultValue:请求参数的默认值
    * */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username",required = false) String un,@RequestParam(value = "age") Integer age){
        System.out.printf("testRequestParam username="+un+",password="+age);
        return SUCCESS;
    }



    /*
    * Rest风格的URL:
    * 以增删改查为例：
    * 新增：/order/ POST
    * 修改: /order/1 PUT
    * 获取：/order/1 GET
    * 删除：/order/1 DELETE
    *
    * 如何发送PUT请求和DELETE请求？
    * 1.需要配置HIddenHttpMethodFilter
    * 2.需要发送POST请求
    * 3.需要发送POST请求时携带一个name="_method"的隐藏域，值为DELETE或PUT
    * */
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public String testRestGET(@PathVariable Integer id){
        System.out.println("testRestGET----"+id);
        return SUCCESS;
    }
    @RequestMapping(value = "/testRest",method = RequestMethod.POST)
    public String testRestPOST(){
        System.out.println("testRestPOST");
        return SUCCESS;
    }
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    public String testRestPUT(@PathVariable Integer id){
        System.out.println("testRestPUT----"+id);
        return SUCCESS;
    }
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    public String testRestDELETE(@PathVariable Integer id){
        System.out.println("testRestDELETE----"+id);
        return SUCCESS;
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println("delete value is"+id);
        return SUCCESS;
    }

    /*了解：可以使用params和headers来更加精确的映射请求，params和headers支持简单的表达式。
    * */
    @RequestMapping(value = "/testParamsAndHeaders",
            params = {"username","age!=10"},
            headers = {"Accept-Language=zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2"})
    public String testParamsAndHeaders(){
        System.out.println("testParamsAndHeaders   ");
        return SUCCESS;
    }

    /*
    * 常用：使用method属性来指定请求方式
    * */
    @RequestMapping(value = "/testMethod??",method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod   ");
        return SUCCESS;
    }
    /*
    * RequestMapping除了修饰方法，还可以来修饰类
    * */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("testRequestMapping");
        return SUCCESS;
    }
}
