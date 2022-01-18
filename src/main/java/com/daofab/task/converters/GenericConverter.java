package com.daofab.task.converters;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface GenericConverter <E,D>{

    E createFromDTO(D dto);

    D createFrom(E entity);

    E updateEntity(E entity, D dto);

    default List createFromEntities(final Collection<E> entities) {
        return entities.stream()
                .map(this::createFrom)
                .collect(Collectors.toList());
    }

    default List createFromDtos(final Collection<D> dtos) {
        return dtos.stream()
                .map(this::createFromDTO)
                .collect(Collectors.toList());
    }
}
