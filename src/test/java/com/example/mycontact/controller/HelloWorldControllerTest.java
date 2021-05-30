package com.example.mycontact.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@SpringBootTest
class HelloWorldControllerTest {

    @Autowired
    private HelloWorldController helloWorldController;

    private MockMvc mockMvc;

    @Test
    void 헬로월드() {
        System.out.println(helloWorldController.helloWorld());
        Assertions.assertEquals(helloWorldController.helloWorld(), "HelloWorld");
    }

    @Test
    void 목엠비씨테스트(){
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();

        try {
            mockMvc.perform(
                    MockMvcRequestBuilders.get("/api/helloWorld")
            ).andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("HelloWorld"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}