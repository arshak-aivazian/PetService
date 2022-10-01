package com.example.namegenerator.repository;

import com.example.namegenerator.entity.PetName;
import dto.filter.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PetNameSpecification implements Specification<PetName> {

    private final SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<PetName> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (Operaton.GR.name().equalsIgnoreCase(criteria.getOperation())) {
            return builder.greaterThanOrEqualTo(
                    root.<String>get(criteria.getKey()), criteria.getValue().toString());
        } else if (Operaton.LO.name().equalsIgnoreCase(criteria.getOperation())) {
            return builder.lessThanOrEqualTo(
                    root.<String>get(criteria.getKey()), criteria.getValue().toString());
        } else if (Operaton.EQ.name().equalsIgnoreCase(criteria.getOperation())) {
            return builder.equal(root.get(criteria.getKey()), criteria.getValue());
        } else if (Operaton.IN.name().equalsIgnoreCase(criteria.getOperation())) {
            List<String> values = new ArrayList<>((List) criteria.getValue());
            return root.get(criteria.getKey()).in(values);
        }
        return null;
    }

    private enum Operaton {
        GR,
        LO,
        EQ,
        IN
    }
}
