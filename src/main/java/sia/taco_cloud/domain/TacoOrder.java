package sia.taco_cloud.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TacoOrder {
    private Long id;

    @NotNull
    private Date placedAt = new Date();

    @NotBlank(message = "Delivery name is required")
    @Size(max = 50, message = "Delivery name must not go beyond 50 characters")
    private String deliveryName;

    @NotBlank(message = "Street is required")
    @Size(max = 50, message = "Street must not go beyond 50 characters")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    @Size(max = 50, message = "City must not go beyond 50 characters")
    private String deliveryCity;

    @NotBlank(message = "State is required")
    @Size(max = 50, message = "State must not go beyond 50 characters")
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    @Size(max = 10, message = "Zip code must not go beyond 10 characters")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }
}
