/*
 * Copyright (c) 2020 Robert Bosch Manufacturing Solutions GmbH, Germany. All rights reserved.
 */

package example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith( SpringRunner.class )
@SpringBootTest( classes = { Application.class })
public class FooTest {

   @PersistenceContext
   private EntityManager entityManager;

   @Autowired
   private FooRepository fooRepository;


   @Test
   @Transactional
   public void testWithFilter() {
      Session session = entityManager.unwrap( Session.class );
      session.enableFilter( "tenantFilter" )
             .setParameter( "tenantId",
                   "test" ).validate();
      final Optional<Foo> foo1 = fooRepository.findById( 1);
      assertThat(foo1).isPresent();
      foo1.get().getBars().forEach( System.out::println );
   }


}
