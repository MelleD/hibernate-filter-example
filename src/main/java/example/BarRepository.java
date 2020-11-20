/*
 * Copyright (c) 2020 Bosch Software Innovations GmbH. All rights reserved.
 */

package example;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepository extends JpaRepository<Bar, Integer> {

   @Override
   @Query
   Optional<Bar> findById( Integer integer );
}
