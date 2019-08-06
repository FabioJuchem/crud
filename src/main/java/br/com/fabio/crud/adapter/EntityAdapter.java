package br.com.fabio.crud.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public interface EntityAdapter<E,P,R> {

    E toEntity(P dto);

    R toResponse(E e);

    void updateEntity(E e, P dto);

    default List<E> toEntity(Collection<P> dtos) {
        return (List)this.toEntity(dtos, ArrayList::new);
    }

    default Collection<E> toEntity(Collection<P> dtos, Supplier<Collection<E>> supplier) {
        return (Collection)dtos.stream().collect(supplier, (list, dto) -> {
            list.add(this.toEntity(dto));
        }, (left, right) -> {
            left.addAll(right);
        });
    }

    default List<R> toResponse(Collection<E> entities) {
        return (List)this.toResponse(entities, ArrayList::new);
    }

    default Collection<R> toResponse(Collection<E> entities, Supplier<Collection<R>> supplier) {
        return (Collection)entities.stream().collect(supplier, (list, e) -> {
            list.add(this.toResponse(e));
        }, (left, right) -> {
            left.addAll(right);
        });
    }
}
