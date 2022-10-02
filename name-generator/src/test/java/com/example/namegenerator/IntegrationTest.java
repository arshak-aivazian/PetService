package com.example.namegenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

//    @Test
//    @WithMockUser(username="spring")
//    public void getPetNameByFilter() throws Exception {
//
//        AndFilter andFilter = AndFilter.builder()
//                .value(List.of(
//                        SearchCriteria.builder().key("gender").value("male").operation("EQ").build(),
//                        SearchCriteria.builder().key("species").value("dog").operation("EQ").build()
//                ))
//                .build();
//
//        RandomNameRequest request = new RandomNameRequest();
//        request.setUsername("admin");
//        request.setFilter(andFilter);
//
//        mockMvc.perform(post("/api/generate")
//                .content(getJsonString(request)))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("[0].name").value("dogMale"))
//                .andExpect(jsonPath("[0].gender").value("male"))
//                .andExpect(jsonPath("[0].species").value("dog"));
//    }

    private String getJsonString(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

}
