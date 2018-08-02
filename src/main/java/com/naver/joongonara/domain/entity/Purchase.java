package com.naver.joongonara.domain.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int moneyAmount;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Product product;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private User seller;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private User buyer;

    @Column
    @CreatedDate
    private LocalDateTime createdAt;

}
