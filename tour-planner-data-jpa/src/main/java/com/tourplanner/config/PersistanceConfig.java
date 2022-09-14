package com.tourplanner.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = { "com.tourplanner.repositories" })
public class PersistanceConfig {
	
	//db conneection

	@Bean
	public DataSource dataSource(@Value("${db.driverClassname}") String driverClassname, @Value("${db.url}") String url,
			@Value("${db.username}") String username, @Value("${db.password}") String password) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driverClassname);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = null;
		HibernateJpaVendorAdapter jpaVendorAdapter = null;

		jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setShowSql(true);

		entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		entityManagerFactoryBean.setPackagesToScan("com.tourplanner.entities");

		return entityManagerFactoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory);
		return jpaTransactionManager;
	}

}
