
package com.assignment.n15.orderdetailservice.model;


        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

        import javax.persistence.*;
        import java.util.List;

@Entity
@Table(name = "t_order_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String status;
    private long orderNumber;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_details_fk", referencedColumnName = "id")
    private List<HistoryTracking> listHistory;

    @ManyToOne
    @JoinColumn(name = "supplier_id",nullable = false)
    private Supplier supplier;

}
