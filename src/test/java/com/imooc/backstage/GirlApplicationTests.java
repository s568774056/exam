package com.imooc.backstage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

import com.imooc.backstage.dao.ApiDao;
import com.imooc.backstage.domain.Api;
import com.imooc.backstage.service.ApiService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlApplicationTests {
	@Test
	public void contextLoads() {

	}
	 @Autowired
	    private ApiService apiService;
	    @Test
	    public void girlList() throws Exception {
	       /* mvc.perform(MockMvcRequestBuilders.post("/api/select").param("page", "0").param("size","2"))
	                .andExpect(MockMvcResultMatchers.status().isOk())*/
	       /* .andExpect(MockMvcResultMatchers.content().string("abc"))*/;
	        Api api = new Api();
	        api.setAddress("z");
	        apiService.test(api, 0,2);
	     //   apiService.testUpdate(api, 0,2);

	    }
	    
		@Autowired
		private ApiDao apiDao;
		@Test
		public void girlAdd() {
			
		}
}
