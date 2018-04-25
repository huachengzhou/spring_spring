package com.ioc;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import common.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceConfigXMLTest {
    private final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void datasourceTest(){
        ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource)context.getBean("combopooleddatasource");
        DruidDataSource druidDataSource = (DruidDataSource)context.getBean("druiddatasource");
        logger.info(comboPooledDataSource.getUser()+" "+comboPooledDataSource.getPassword());
        logger.info(druidDataSource.getPassword()+" "+druidDataSource.getUsername());
    }
}
