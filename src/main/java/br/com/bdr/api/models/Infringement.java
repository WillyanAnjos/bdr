package br.com.bdr.api.models;

import br.com.bdr.api.enums.VehicleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "records")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Infringement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

    @NotNull(message = "A velocidade não pode estar vazia")
    private int speed;

    @Pattern(regexp = "[A-Z]{3}-\\d{4}", message = "Placa inválida")
    private String plate;

    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "Nao pode estar vazio")
    public VehicleType vehicleType;
}
