package sia.taco_cloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import sia.taco_cloud.domain.TacoOrder;
import sia.taco_cloud.repository.OrderRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        log.atDebug().log("Order form visited");
        return new String("orderForm");
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order,
            Errors errors,
            SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            log.info("We've got some Order errors");
            for (var error : errors.getAllErrors()) {
                log.info("Error: {}", error.getObjectName() + ": ", error.getDefaultMessage());
            }
            return "orderForm";
        }

        log.info("Order submitted: {} \n", order);
        orderRepository.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }

}
