package com.ey.demo.service;


import com.ey.demo.model.ServiceResponse;
import com.ey.demo.model.TemplateMst;
import com.ey.demo.model.TestPost;
import com.ey.demo.repo.DemoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class DemoService {
    @Autowired
    DemoRepo demoRepo;
    @Autowired
    @Qualifier("jdbcTemplateUniv")
    JdbcTemplate jdbcTemplateUniv;

    @Autowired
    @Qualifier("jdbcTemplateSw")
    JdbcTemplate jdbcTemplateSw;

    public List<TemplateMst> test(String schema) {
        String query = "select unum_temple_id,ustr_temple_code,ustr_temple_name from gmst_config_template_mst";
        if(schema.equals("U"))
        {

            return demoRepo.test(query,jdbcTemplateUniv);
        }
        else
        {
            return demoRepo.test(query,jdbcTemplateSw);
        }

    }
    @Transactional(value = "iitbTransactionManager")
    public void testpost(TestPost testPost)
    {
        demoRepo.testPost(testPost,jdbcTemplateSw);
        demoRepo.testPostOra(testPost,jdbcTemplateUniv);
        throw new RuntimeException("my exp");
    }
}
