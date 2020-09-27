package spittr.web;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import spittr.Spitter;
import spittr.data.SpitterRepository;

public class SpitterControllerTest {
    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository spitterRepository= Mockito.mock(SpitterRepository.class);
        Spitter unsaved=new Spitter("jbauer","24hours","jack","bauer","");
        Spitter saved=new Spitter(24L,"jbauer","24hours","jack","bauer","");
        Mockito.when(spitterRepository.save(unsaved)).thenReturn(saved);
        SpitterController spitterController=new SpitterController(spitterRepository);
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(spitterController).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register")
                .param("firstName", "")
                .param("lastName", "Bauer")
                .param("username", "a")
                .param("password", "24hours")
                .param("email", "jbauer@ctu.gov"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/jbauer")
        );
    }
}
