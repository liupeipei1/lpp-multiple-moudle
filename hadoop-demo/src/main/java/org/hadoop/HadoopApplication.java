package org.hadoop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class HadoopApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheMain.class, args);
    }
}