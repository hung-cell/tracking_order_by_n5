package com.assignment.n15.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_fk", referencedColumnName = "id")
    private List<ProductItems> orderListItems;

}
