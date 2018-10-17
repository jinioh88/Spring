package com.example.test1.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString()
@Table(name = "tbl_basket")
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long bid;
    @ManyToOne(targetEntity = Goods.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "goods_id")
    Goods goods;
    @ManyToOne(targetEntity = Option.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "option_id")
    Option option;
    int quantity;
    private LocalDateTime regTime;
}
