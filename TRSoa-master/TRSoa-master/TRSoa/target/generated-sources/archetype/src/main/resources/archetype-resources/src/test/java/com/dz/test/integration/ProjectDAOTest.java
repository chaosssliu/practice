#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.dz.test.integration;

import ${package}.config.MvcConfig;
import ${package}.config.PersistenceJPAConfig;
import ${package}.dao.ProjectDAO;
import ${package}.vo.ProjectVO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by daweizhuang on 10/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceJPAConfig.class, MvcConfig.class})
@WebAppConfiguration
@Ignore
public class ProjectDAOTest {
    @Autowired
    ProjectDAO projectDAO;

    @Test
    @Transactional
    public void testMapping() {

        List<ProjectVO> resList = projectDAO.getProjectNameList();
        assertTrue(resList.get(0) instanceof ProjectVO);

    }

}
