package com.thoughtworks.amawta;

import static org.assertj.core.api.Assertions.assertThat;

import com.thoughtworks.amawta.controller.PostController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmawtaApplicationTests {

    @Autowired
    private PostController postController;


    @Test
    public void ShouldReturnPostControllerNotNullWhenContextLoads() throws Exception {
        assertThat(postController).isNotNull();
    }

}
