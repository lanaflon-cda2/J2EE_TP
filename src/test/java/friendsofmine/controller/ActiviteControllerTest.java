package friendsofmine.controller;

import friendsofmine.Bootstrap;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by valen on 28/02/2017.
 */
@WebMvcTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ActiviteControllerTest {

    @MockBean
    private Bootstrap bootstrap;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testList() throws Exception{
        this.mockMvc.perform(get("/activites"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("activites"))
                .andExpect(content().string(Matchers.containsString("<h1>Activites</h1>")))
                .andDo(print());
    }

}