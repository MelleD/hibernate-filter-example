/*
 * Copyright (c) 2020 Bosch Software Innovations GmbH. All rights reserved.
 */

package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Application {


   public static void main( String[] args ) {
      SpringApplication.run( Application.class, args );
   }

}
