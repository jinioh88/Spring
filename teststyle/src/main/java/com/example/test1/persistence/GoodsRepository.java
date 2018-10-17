package com.example.test1.persistence;

import com.example.test1.domain.Goods;
import com.example.test1.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods,Long> {
    public Goods findGoodsByGid(Long id);

    @Query("select g.optionList from Goods g where g.gid = ?1")
    public List<Option> findOptionByGid(Long gid);
}
