package com.seesea.study.controller;


import com.seesea.study.mongodb.Mian;
import com.seesea.study.mongodb.TestBig;
import com.seesea.study.util;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    Mian mian;

    @Test
    public void test1() throws Exception {

        this.mockMvc.perform(get("/test")).andDo(print()).andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string(containsString("Hello World")))
                .andDo(document("home"));
    }


    @Test
    public void test() throws IOException {
        File file = new File("G:\\上线相关\\e签宝\\模板\\借款协议.pdf");

        TestBig testBig = new TestBig();
        testBig.setId(1);

        testBig.setData(util.byte2Base64StringFun(FileUtils.readFileToByteArray(file)));



    }

}