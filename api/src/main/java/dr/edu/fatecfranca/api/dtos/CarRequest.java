package dr.edu.fatecfranca.api.dtos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CarRequest (

    @NotBlank(message = "A marca é obrigatória.")
    private String brand;

    @NotBlank(message = "O modelo é obrigatório.")
    private String model;

    @NotBlank(message = "A cor é obrigatória.")
    private String color;

    @NotNull(message = "O ano de fabricação é obrigatório.")
    @Positive(message = "O ano de fabricação deve ser maior que zero.")
    private Integer yearManufacture;

    @NotNull(message = "É obrigatório informar se o carro é importado.")
    private Boolean imported;

    @NotBlank(message = "A placa é obrigatória.")
    @Pattern(
        regexp = "([A-Z]{3}-[0-9]{4}|[A-Z]{3}[0-9][A-Z][0-9]{2})",
        message = "A placa deve seguir o formato ABC-1234 ou ABC1D23."
    )
    private String plates;

    @PastOrPresent(message = "A data de venda não pode estar no futuro.")
    private LocalDate sellingDate;

    @Positive(message = "O preço de venda deve ser maior que zero.")
    @Digits(
        integer = 10,
        fraction = 2,
        message = "O preço deve ter até 10 dígitos inteiros e 2 decimais."
    )
    private BigDecimal sellingPrice;

    @Positive(message = "O ID do cliente deve ser maior que zero.")
    private Long customerId;
) {}


