package com.study.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldControllerTest {

    private MockMvc mvcMock;

    @Before
    public void setUp() {
        mvcMock = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
        mvcMock.perform(MockMvcRequestBuilders.get("/hello/world/1")
                .accept(MediaType.APPLICATION_JSON)
                .header("User-Agent", "test"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World.1 test")));
    }
}
