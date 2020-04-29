package com.learnnew.spring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraCqlClusterFactoryBean;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DataCenterReplication;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {
	@Value("${spring.data.cassandra.keyspacename}")
	protected String keyspaceName;
	//private String basePackages = "com.learnnew.spring.data.cassandra";

	@Override
	protected String getKeyspaceName() {
		return this.keyspaceName;
	}
	
	  @Override
	  protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
	    System.out.println("=================================keyspace==============="+keyspaceName);
	    CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(keyspaceName).ifNotExists()
	      .with(KeyspaceOption.DURABLE_WRITES, true).withNetworkReplication(DataCenterReplication.of("foo", 1))
	      ;

	    return Arrays.asList(specification);
	  }
	  @Override
	  protected boolean getMetricsEnabled() { return false; }

}
