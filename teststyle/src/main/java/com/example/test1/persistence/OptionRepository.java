package com.example.test1.persistence;

import com.example.test1.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option,Long> {

    public Option findOptionByOid(Long oid);
}
