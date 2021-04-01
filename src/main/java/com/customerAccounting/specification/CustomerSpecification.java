package com.customerAccounting.specification;

import com.customerAccounting.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class CustomerSpecification implements Specification<Customer> {
    private final Customer filter;


    public Predicate toPredicate(Root<Customer> root, CriteriaQuery <?> criteriaQuery, CriteriaBuilder cb) {
      List <Predicate> predicates = new ArrayList<>();
      if (filter.getFirstName() != null){
          predicates.add(cb.like(cb.lower(root.get("firstName")), filter.getFirstName().toLowerCase() + "%"));
      }
      if (filter.getLastName() != null){
          predicates.add(cb.like(cb.lower(root.get("lastName")), filter.getLastName().toLowerCase() + "%"));
      }

      return criteriaQuery.where(cb.and(predicates.toArray(new Predicate[0])))
              .distinct(true).getRestriction();
  }
}
