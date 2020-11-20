/*
 * Copyright (c) 2020 Bosch Software Innovations GmbH. All rights reserved.
 */

package example;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Application implements CommandLineRunner {

   @Autowired
   private FooRepository fooRepository;

   @Autowired
   private BarRepository barRepository;

   public static void main( String[] args ) {
      SpringApplication.run( Application.class, args );
   }

   @Override
   public void run( String... args ) throws Exception {
      Foo foo = new Foo();
      foo.setTenantId( "test" );

      Bar bar = new Bar();
      bar.setName( "Like Foo" );
      foo.setBars( Set.of( bar ) );
      fooRepository.saveAndFlush( foo );
   }
}
