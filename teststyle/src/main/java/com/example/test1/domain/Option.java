package com.example.test1.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tbl_opt")
@EqualsAndHashCode(of = "oid")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long oid;
    String color;
    String size;
    int stock;
}
