package com.example.booking_online.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

@Data
@SuperBuilder
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDTO implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdBy;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createdDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String updatedBy;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date updatedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long status;
}
