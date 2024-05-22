package com.shoes.bladex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    private String code;
    private String description;
    private String category;
    private Double salePrice;
    private Double buyPrice;
    private Double profit;
    private Double profitMargin;
    private String status;
    private String supplierCode;
    private String supplierName;

    private Integer size_6;
    private Integer size_7;
    private Integer size_8;
    private Integer size_9;

    @Column(columnDefinition = "LONGTEXT")
    private String itemPic;
}
