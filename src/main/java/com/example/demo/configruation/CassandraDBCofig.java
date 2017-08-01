package com.example.demo.configruation;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.policies.AddressTranslator;
import org.apache.catalina.Container;
import org.hibernate.exception.spi.Configurable;
import org.springframework.cassandra.config.CassandraCqlClusterFactoryBean;
import org.springframework.cassandra.config.DataCenterReplication;
import org.springframework.cassandra.core.keyspace.CreateKeyspaceSpecification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;

import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.util.Collections;

/**
 * Created by THANH NGA on 7/10/2017.
 */
@Configuration
public class CassandraDBCofig extends AbstractCassandraConfiguration {

    @Override
    public String getKeyspaceName() {
        return "foodtiny_test";
    }

    @Bean
    public CassandraCqlClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setPort(9042);
        cluster.setContactPoints("127.0.0.1");
        return cluster;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] { "com.example.demo.entities.cassandraEntities" };
    }

    @Bean
    public CassandraMappingContext mappingContext() {
        return new BasicCassandraMappingContext();
    }

    @Bean
    public CassandraConverter converter() {
        return new MappingCassandraConverter(mappingContext());
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

}
