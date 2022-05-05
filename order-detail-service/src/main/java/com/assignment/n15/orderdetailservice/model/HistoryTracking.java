package com.assignment.n15.orderdetailservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history_tracking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HistoryTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String location;
    private Date timeArrived;
}
