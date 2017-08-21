package cn.wcode.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import cn.wcode.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by homiss on 2017/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@TransactionConfiguration(defaultRollback = false)
@AutoConfigureMockMvc
@SpringBootTest(classes = Application.class)
public class AppQuestionControllerTest {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private MockMvc mvc;



  @Test
  public void addQuestionGroup() throws Exception {
    MvcResult result = mvc.perform(post("/api/app/question/v1/add")
        .param("userId", "6")
        .param("token", "1bb9881b-11fe-46b8-adc5-795b433568ae")
        .param("groupId", "1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();
  }

  @Test
  public void importQuestion() throws Exception {

  }

  @Test
  public void importData() throws Exception {
    /* mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/多线程/Java面试题之多线程(一).html")
        .param("groupId", "1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();

    mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/多线程/Java面试题之多线程(二).html")
        .param("groupId", "1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();

    mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/多线程/Java面试题之多线程(三).html")
        .param("groupId", "1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();

    mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/基础知识/基础知识.html")
        .param("groupId", "2"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();

    mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/集合/集合相关.html")
        .param("groupId", "3"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn(); */

    /*mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/框架/Spring 面试题.html")
        .param("groupId", "4"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();*/
    /* mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/框架/MyBatis面试题.html")
        .param("groupId", "11"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();
    mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/框架/Hibernate面试题.html")
        .param("groupId", "12"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();

    mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/算法/排序算法.html")
        .param("groupId", "5"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();

    mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/JVM/JVM面试题.html")
        .param("groupId", "6"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();

    mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/JDBC/JDBC面试题.html")
        .param("groupId", "7"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();
    mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/JDBC/Redis面试题.html")
        .param("groupId", "10"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();


    mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/网络编程/Java网络编程面试题.html")
        .param("groupId", "8"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();


    mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/异常处理/Java异常处理面试题.html")
        .param("groupId", "9"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();

    mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/IO/Java I-O面试题.html")
        .param("groupId", "13"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();

    mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/设计模式/设计模式.html")
        .param("groupId", "14"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();*/

    mvc.perform(post("/question/import")
        .param("filepath", "/Users/homiss/github/Java-interview-questions/手写代码/手写代码.html")
        .param("groupId", "15"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success").value(true))
        .andReturn();

  }

}