package nsg.portafolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nsg.portafolio.listener.AuditProductListerner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
@EntityListeners(AuditProductListerner.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;

    
    
//    private String operation;
//
//    @Column(name = "date_event")
//    private LocalDateTime dateEvent;

//    @PrePersist
//    public void onPrePersist() {
//        audit("INSERT");
//    }
//
//    @PreUpdate
//    public void onPreUpdate() {
//        audit("UPDATE");
//    }
//
//    public void audit(String operation) {
//        setOperation(operation);
//        setDateEvent(LocalDateTime.now());
//    }
}
