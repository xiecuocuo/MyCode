package cn.ynf.action;

import cn.ynf.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
//注意: 在 IOC 容器中配置 Struts2 的 Action 时, 需要配置 scope 属性, 其值必须为 prototype
@Controller
@Scope("prototype")
public class PersonAction {
    @Autowired
    private PersonService personService;

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public String execute(){
        System.out.println("execute....");
        personService.save();
        return "success";
    }
}
