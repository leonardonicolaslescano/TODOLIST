package com.lescanapp.TODOList.items.repo;

import com.lescanapp.TODOList.items.model.Item;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepo
        extends JpaRepository<Item, Long> {

    @Query("select item from Item item where item.complete=true")
    List<Item> getCompletedItems();

    @Query("select item from Item item where item.complete=false")
    List<Item> getIncompletedItems();

    @Modifying
    @Transactional
    @Query("update Item as item set item.complete = :complete where item.id = :id ")
    void setItemComplete(@Param("id") Long id, @Param("complete") boolean complete);

    @Modifying
    @Transactional
    @Query("delete from Item as item where item.id = :id ")
    void delete(Long id);
}
