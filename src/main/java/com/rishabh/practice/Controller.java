package com.rishabh.practice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/calculate")
    public ResponseEntity<?> getMessage(
            @RequestParam int firstNum, @RequestParam int secondNum,
            @RequestParam String function) {

        try{
            return ResponseEntity.ok(calculate(firstNum, secondNum, function));
        } catch (Exception e){
            return ResponseEntity.ok("Invalid function");
        }
    }

    private int calculate(int a, int b, String function) {
        switch (function) {
            case "add" -> {
                return (a + b);
            }
            case "subtract" -> {
                return (a - b);
            }
            case "multiply" -> {
                return (a * b);
            }
            case "divide" -> {
                return (a / b);
            }
            case "modulus" -> {
                return (a % b);
            }
            default -> throw new IllegalArgumentException("Invalid Operation");
        }
    }
}
