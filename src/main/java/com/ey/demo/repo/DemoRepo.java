package com.ey.demo.repo;



import com.ey.demo.model.TemplateMst;
import com.ey.demo.model.TestPost;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DemoRepo {


    public List<TemplateMst> test(String query,JdbcTemplate jdbcTemplate) {
        return jdbcTemplate.query(query,new BeanPropertyRowMapper(TemplateMst.class));
    }
    public void testPost(TestPost testPost, JdbcTemplate jdbcTemplate) {
        String query = "INSERT INTO test_bd(NAME) VALUES (?)";
        jdbcTemplate.update(query,new Object[]{testPost.getName()});
    }
    public void testPostOra(TestPost testPost, JdbcTemplate jdbcTemplate) {
        String query = "INSERT INTO TEST_TBL(NAME) VALUES (?)";
        jdbcTemplate.update(query,new Object[]{testPost.getName()});
    }
}
