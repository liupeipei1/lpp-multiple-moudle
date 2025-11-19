package org.hadoop.configuration;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
@org.springframework.context.annotation.Configuration
public class HadoopConfig {

    @Value("${spring.hadoop.fs.defaultFS}")
    private String fsDefaultFS;

    @Value("${spring.hadoop.hadoop.tmp.dir}")
    private String hadoopTmpDir;

    @Bean
    public Configuration hadoopConfiguration() {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", fsDefaultFS);
        conf.set("hadoop.tmp.dir", hadoopTmpDir);
        return conf;
    }

    @Bean
    public FileSystem hdfsFileSystem(Configuration configuration) throws IOException {
        return FileSystem.get(configuration);
    }
}