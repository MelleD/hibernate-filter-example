/*
 * Copyright (c) 2020 Robert Bosch Manufacturing Solutions GmbH, Germany. All rights reserved.
 */

package example;

import java.util.Set;
import java.util.StringJoiner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.ParamDef;

@FilterDef( name = "tenantFilter",
            parameters = @ParamDef( name = "tenantId", type = "string" ) )
@Filters(
      @Filter( name = "tenantFilter", condition = "tenant_id = :tenantId" )
)
@Entity
public class Foo {

   @Id
   @GeneratedValue
   private int id;

   @Column( name = "tenant_id" )
   private String tenantId;

   @OneToMany( mappedBy = "foo", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER )
   @OnDelete( action = OnDeleteAction.CASCADE )
   private Set<Bar> bars;

   public int getId() {
      return id;
   }

   public void setId( final int id ) {
      this.id = id;
   }

   public String getTenantId() {
      return tenantId;
   }

   public void setTenantId( final String tenantId ) {
      this.tenantId = tenantId;
   }

   public void setBars( final Set<Bar> bars ) {
      this.bars = bars;
      this.bars.forEach( bar -> bar.setFoo( this ) );
   }

   public Set<Bar> getBars() {
      return bars;
   }

   @Override
   public String toString() {
      return new StringJoiner( ", ", Foo.class.getSimpleName() + "[", "]" )
            .add( "id=" + id )
            .add( "tenantId='" + tenantId + "'" )
            .toString();
   }
}
