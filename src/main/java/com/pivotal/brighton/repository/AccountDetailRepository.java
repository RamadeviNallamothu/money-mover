package com.pivotal.brighton.repository;

import com.pivotal.brighton.domain.AccountDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.*;

import java.util.List;

/**
 * Created by pivotal on 1/26/16.
 */
@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountDetailRepository extends PagingAndSortingRepository<AccountDetail, String>{

    @RestResource(path ="user", rel = "user")
    List<AccountDetail> findByUser(@Param("user")  String user);

}
