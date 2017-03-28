package controller;

import config.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class HelloControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = 
            MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testHelloGet() throws Exception {

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("nameForm"))
                .andExpect(model().attributeExists("name"));
    }

    @Test
    public void testHelloPost() throws Exception {

        mockMvc.perform(post("/hello")
                .param("value", "test")
        )
                .andExpect(status().isOk())
                .andExpect(view().name("helloView"))
                .andExpect(model().attributeExists("helloMessage"))
                .andExpect(model().attribute("helloMessage", "Hello test!"));
    }
}
