package com.example.test1.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "optionList")
@Table(name = "tbl_goods")
@EqualsAndHashCode(of = "pid")
public class Goods {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long gid;
    String name;
    String provider;
    int price;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "goodno")
    List<Option> optionList = new ArrayList<>();

    @Transient
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="shippno", nullable = false, unique = true, insertable = false, updatable = false)
    Shipping shipping;

}
