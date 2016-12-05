package com.cmxy.config;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.cmxy.persistence")
public class JpaConfig {
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource,EntityManagerFactory emf) {
		JpaTransactionManager tm = 
		new JpaTransactionManager();
		tm.setEntityManagerFactory(emf);
		tm.setDataSource(dataSource);
		return tm;
		}
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		return adapter;	
	}
	@Bean 
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,JpaVendorAdapter jpaVendorAdapter){
		LocalContainerEntityManagerFactoryBean emfb=new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);

		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setPackagesToScan("com.cmxy.entity");
		return emfb;
	}

	@Bean
	public PersistenceAnnotationBeanPostProcessor paProcessor(){
		return new PersistenceAnnotationBeanPostProcessor();
	}
	@Bean(initMethod="init",destroyMethod="close",name = "graduationDataSource")
	@ConfigurationProperties(prefix="datasource.druid")
	public DataSource graduationDataSource() { 
		DruidDataSource druidDataSource=new DruidDataSource();
		try {
			druidDataSource.setFilters("stat, wall");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return druidDataSource;
	}
	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean srb=new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		srb.addInitParameter("loginUsername","user");// 用户名
		srb.addInitParameter("loginPassword", "1234");// 密码
		srb.addInitParameter("resetEnable", "false");// 禁用HTML页面上的"Reset All"功能
		return srb;
	}

	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}

}
