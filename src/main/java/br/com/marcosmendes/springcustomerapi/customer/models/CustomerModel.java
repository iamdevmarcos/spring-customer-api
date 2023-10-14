package br.com.marcosmendes.springcustomerapi.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_customers")
public class CustomerModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(length = 50)
    private String customerName;

    @Column(length = 14)
    private String customerDocument;

    private String customerAddress;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
