package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.Spittle;
import spittr.data.SpittleReponstory;
import java.util.*;


@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING=Long.MAX_VALUE+"";
    private SpittleReponstory spittleReponstory;

    public SpittleController() {
    }

    @Autowired
    public SpittleController(SpittleReponstory spittleReponstory){
        this.spittleReponstory=spittleReponstory;
    }
    //Model实际上为一个Map,它会传递给视图然后渲染到客户端
  /*@RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        //在调用addAttribute方法时，可以传key,也可以不传key,不传key的话，默认key时是由value值所决定的。
        //例如在本例中：value为List<Spittle>,key默认为spittleList
        model.addAttribute(spittleReponstory.findSpittles(Long.MAX_VALUE,20));
        return "spittles";
    }*/
    //也可以显示的指定key例如：
  /*@RequestMapping(method = RequestMethod.GET)
    public String spittles2(Model model){
        model.addAttribute("spittleList",spittleReponstory.findSpittles(Long.MAX_VALUE,20));
        return "spittles";
    }*/
    //如果希望key为非String类型的话，可以用java.util,Map来替代Model
    /*@RequestMapping(method = RequestMethod.GET)
    public String spittles3(Map map){
        map.put("spittleList",spittleReponstory.findSpittles(Long.MAX_VALUE,20));
        return "spittles";
    }*/
    //方法直接返回Spittle列表，当处理器先当处理器方法像这样返回对象或集合时， 这个值会放到模型中， 模型的key会根据其
    //类型推断得出（在本例中， 也就是spittleList）
    //而逻辑视图的名称将会根据请求路径推断得出。 因为这个方法处理针对“/spittles”的GET请求， 因此视图的名称将会是spittles（去掉开头的斜线)
    /*@RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles4(){
        return spittleReponstory.findSpittles(Long.MAX_VALUE,20);
    }
*/
/*    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles5(@RequestParam(value = "max") long max,@RequestParam(value = "count")int count){
        return spittleReponstory.findSpittles(max,count);
    }*/
    //如果这些参数在请求中不存在的话，就使用默认值Long.MAX_VALUE和20。 @RequestParam注解的defaultValue属性可以完成这项任务：
/*    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittle6(@RequestParam(value = "max",defaultValue =MAX_LONG_AS_STRING) long max,@RequestParam(value = "count",defaultValue ="20" )int count){
        return spittleReponstory.findSpittles(max,count);
    }*/

/*    @RequestMapping(method = RequestMethod.GET,value = "show")
    public String showSpittle(@RequestParam("spittle_id")long spittleId,Model model){
        model.addAttribute(spittleReponstory.findOne(spittleId));
        return "spittle";
    }*/
    //spittle()方法的spittleId参数上添加了@PathVariable("spittleId")注解， 这表明在请求路径中， 不
    //管占位符部分的值是什么都会传递到处理器方法的spittleId参数.如果对“/spittles/54321”发送GET请求， 那么将会把“54321”传递进
    //来， 作为spittleId的值
/*    @RequestMapping(method = RequestMethod.GET,value = "/{spittleId}")
    public String spittle7(@PathVariable("spittleId") Long spittleId,Model model){
        model.addAttribute(spittleReponstory.findOne(spittleId));
        return "spittle";
    }*/
    //如果方法的参数名与占位符一致，那么可以省略@PathVariable的value属性
/*    @RequestMapping(method = RequestMethod.GET,value = "/{spittleId}")
    public String spittle8(@PathVariable Long spittleId,Model model){
        *//*
        * spittle()方法会将参数传递到SpittleRepository的findOne()方法中， 用来获取某个Spittle对象， 然后将Spittle
对象添加到模型中。 模型的key将会是spittle， 这是根据传递到addAttribute()方法中的类型推断得到的。*//*
        model.addAttribute(spittleReponstory.findOne(spittleId));
        return "spittle";
    }*/
}