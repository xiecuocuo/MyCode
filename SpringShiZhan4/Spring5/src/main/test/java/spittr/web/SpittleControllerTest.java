package spittr.web;

import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.Spittle;
import spittr.data.SpittleReponstory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpittleControllerTest {
    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i=0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles=createSpittleList(50);
        SpittleReponstory mockRepository= Mockito.mock(SpittleReponstory.class);
        Mockito.when(mockRepository.findSpittles(238900,50)).thenReturn(expectedSpittles);
        //将这个Repository注入到一个新的SpittleController实例中
        SpittleController controller = new SpittleController(mockRepository);
        //创建MockMvc并使用这个控制器
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        //对“/spittles”发起GET请求， 然后断言视图的名称为spittles并且模型中包含名为spittleList的属性，
        //在spittleList中包含预期的内
        mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList",
                        JUnitMatchers.hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void testSpittle() throws Exception {
        Spittle expectedSpittle=new Spittle("Hello",new Date());
        SpittleReponstory mockRepository= Mockito.mock(SpittleReponstory.class);
        Mockito.when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);
        //将这个Repository注入到一个新的SpittleController实例中
        SpittleController controller = new SpittleController(mockRepository);
        //创建MockMvc并使用这个控制器
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        //对“/spittles/12345”发起GET请求， 然后断言视图的名称是spittle， 并且预期的Spittle对象放到了模型之中
        mockMvc.perform(MockMvcRequestBuilders.get("/spittles/12345"))
                .andExpect(MockMvcResultMatchers.view().name("spittle"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittle"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittle",expectedSpittle));
    }
    @Test
    public void testRegister() throws Exception{
        SpittleController controller = new SpittleController();
        MockMvc mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spittles/register")).andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }
}
