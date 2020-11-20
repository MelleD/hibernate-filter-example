/*
 * Copyright (c) 2020 Robert Bosch Manufacturing Solutions GmbH, Germany. All rights reserved.
 */

package example;

import java.util.StringJoiner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bar {

   @Id
   @GeneratedValue
   private int id;

   private String name;

   @ManyToOne
   @JoinColumn(name = "foo_id")
   private Foo foo;

   public int getId() {
      return id;
   }

   public void setId( final int id ) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName( final String name ) {
      this.name = name;
   }

   public void setFoo( Foo foo ) {
      this.foo = foo;
   }

   public Foo getFoo() {
      return foo;
   }

   @Override
   public String toString() {
      return new StringJoiner( ", ", Bar.class.getSimpleName() + "[", "]" )
            .add( "id=" + id )
            .add( "name='" + name + "'" )
            .add( "foo=" + foo )
            .toString();
   }
}
