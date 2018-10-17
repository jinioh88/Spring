package com.example.test1.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tbl_shipping")
@EqualsAndHashCode(of = "sid")
public class Shipping {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long sid;
    String method;
    int price;
    boolean canbundle;
}
