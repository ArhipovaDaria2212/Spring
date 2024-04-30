//package web.config;
//
//import org.postgresql.ds.PGSimpleDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.stereotype.Component;
//import web.model.User;
//
//import javax.persistence.SharedCacheMode;
//import javax.persistence.ValidationMode;
//import javax.persistence.spi.ClassTransformer;
//import javax.persistence.spi.PersistenceUnitInfo;
//import javax.persistence.spi.PersistenceUnitTransactionType;
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.io.UncheckedIOException;
//import java.net.URL;
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Component
//public class HibernatePersistenceUnitInfo implements PersistenceUnitInfo {
//
//    @Override
//    public String getPersistenceUnitName() {
//        return "PersistenceUnit";
//    }
//
//    @Override
//    public String getPersistenceProviderClassName() {
//        return "org.hibernate.jpa.HibernatePersistenceProvider";
//    }
//
//    @Override
//    public PersistenceUnitTransactionType getTransactionType() {
//        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
//    }
//
//    @Override
//    public DataSource getJtaDataSource() {
//        return null;
//    }
//
//    @Override
//    public DataSource getNonJtaDataSource() {
//        return null;
//    }
//
//    @Override
//    public List<String> getMappingFileNames() {
//        return Collections.emptyList();
//    }
//
//    @Override
//    public List<URL> getJarFileUrls() {
//        try {
//            return Collections.list(this.getClass()
//                    .getClassLoader()
//                    .getResources(""));
//        }catch(IOException e) {
//            throw new UncheckedIOException(e);
//        }
//    }
//
//    @Override
//    public URL getPersistenceUnitRootUrl() {
//        return null;
//    }
//
//    @Override
//    public List<String> getManagedClassNames() {
//        Class<?>[] entities = new Class<?>[] {
//                User.class
//        };
//        return Arrays.stream(entities).map(Class::getName).collect(Collectors.toList());
//    }
//
//    @Override
//    public boolean excludeUnlistedClasses() {
//        return false;
//    }
//
//    @Override
//    public SharedCacheMode getSharedCacheMode() {
//        return null;
//    }
//
//    @Override
//    public ValidationMode getValidationMode() {
//        return null;
//    }
//
//    @Override
//    public Properties getProperties() {
//        return hibernateProperties();
//    }
//
//    @Override
//    public String getPersistenceXMLSchemaVersion() {
//        return "";
//    }
//
//    @Override
//    public ClassLoader getClassLoader() {
//        return null;
//    }
//
//    @Override
//    public void addTransformer(ClassTransformer classTransformer) {
//
//    }
//
//    @Override
//    public ClassLoader getNewTempClassLoader() {
//        return null;
//    }
//
//    private Properties hibernateProperties(){
//        final Properties properties = new Properties();
//
//        properties.put("hibernate.hbm2ddl.auto", "update" );
//        properties.put("hibernate.show_sql", true);
//        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver" );
//        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect" );
//        properties.put("hibernate.connection.datasource", getDataSource());
//
//        return properties;
//    }
//
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("1234");
//        return dataSource;
//    }
//}
//
//
