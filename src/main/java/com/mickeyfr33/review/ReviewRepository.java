package com.mickeyfr33.review;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by michaelsmith on 12/14/16.
 * Copyright Acceptto Corporation.
 */
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {


}
