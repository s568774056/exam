package com.imooc.backstage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.imooc.backstage.domain.Api;
import com.imooc.backstage.service.ApiService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=ApiService.class)
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private ApiService apiService;
    @Test
    public void girlList() throws Exception {
       /* mvc.perform(MockMvcRequestBuilders.post("/api/select").param("page", "0").param("size","2"))
                .andExpect(MockMvcResultMatchers.status().isOk())*/
       /* .andExpect(MockMvcResultMatchers.content().string("abc"))*/;
        Api api = new Api();
        apiService.test(api, 0,2);
    }
    


}
