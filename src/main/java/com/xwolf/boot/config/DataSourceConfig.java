package com.xwolf.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

/**
 * 数据源
 * @author xwolf
 * @date 2017-02-25 08:14
 * @since 1.8
 * @version 1.0.0
 */
@Configuration
public class DataSourceConfig implements EnvironmentAware{

    private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

    private RelaxedPropertyResolver prop;

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        this.prop = new RelaxedPropertyResolver(environment,"spring.datasource.");
    }

    /**
     * 数据库连接池配置
     * @return
     */
    @Bean(initMethod="init",destroyMethod="close",name="dataSource")
    public DataSource dataSource(){
        log.info("数据库连接池配置中......");
        if (StringUtils.isEmpty(prop.getProperty("url"))) {
            throw new ApplicationContextException("数据库连接池url配置错误.");
        }else{
            DruidDataSource druid=new DruidDataSource();
            druid.setUrl(prop.getProperty("url"));
            druid.setUsername(prop.getProperty("username"));
            druid.setPassword(prop.getProperty("password"));
            druid.setDriverClassName(prop.getProperty("driverClassName"));
            druid.setInitialSize(Integer.valueOf(prop.getProperty("druid.initialSize")));
            druid.setMinIdle(Integer.valueOf(prop.getProperty("druid.minIdle")));
            druid.setMaxActive(Integer.valueOf(prop.getProperty("druid.maxActive")));
            druid.setMaxWait(Integer.valueOf(prop.getProperty("druid.maxWait")));
            druid.setTimeBetweenConnectErrorMillis(Long.valueOf(prop.getProperty("druid.timeBetweenEvictionRunsMillis")));
            druid.setMinEvictableIdleTimeMillis(Long.valueOf(prop.getProperty("druid.minEvictableIdleTimeMillis")));
            druid.setValidationQuery(prop.getProperty("druid.validationQuery"));
            druid.setTestWhileIdle(Boolean.parseBoolean(prop.getProperty("druid.testWhileIdle")));
            druid.setTestOnBorrow(Boolean.parseBoolean(prop.getProperty("druid.testOnBorrow")));
            druid.setTestOnReturn(Boolean.parseBoolean(prop.getProperty("druid.testOnReturn")));
            druid.setConnectionProperties(prop.getProperty("druid.connectionProperties"));
            try {
                druid.setFilters(prop.getProperty("druid.filter"));
            } catch (SQLException e) {
                log.error("druid数据库连接池初始化异常");
            }
            return druid;
        }
    }

    /**
     * 静态资源过滤
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean fr = new FilterRegistrationBean();
        fr.setFilter(new WebStatFilter());
        fr.addUrlPatterns("/*");
        fr.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return fr;
    }

    /**
     * 数据源监控
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean();
        registration.setServlet(new StatViewServlet());
        registration.setName("druidMonitor");
        registration.setUrlMappings(Lists.newArrayList("/druid/*"));
        //自定义添加初始化参数
        Map<String, String> intParams = Maps.newHashMap();
        intParams.put("loginUsername","druid");
        intParams.put("loginPassword","druid");
        registration.setName("DruidWebStatFilter");
        registration.setInitParameters(intParams);
        return registration;
    }
}
