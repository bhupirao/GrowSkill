package com.growSkill.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentCustomerSession {

    @Id
    @Column(unique = true)
    private Integer userId;


    private String uuid;

    private LocalDateTime localDateTime;


}
