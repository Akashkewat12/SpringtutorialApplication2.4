package com.spring.Springtutorial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotNull(message = "Required field in Employee : name")
    private String name;
    private String email;
    private Integer age;
    private LocalDate dataOfJoining;
    @JsonProperty("isActive")
    private Boolean isActive;
}
