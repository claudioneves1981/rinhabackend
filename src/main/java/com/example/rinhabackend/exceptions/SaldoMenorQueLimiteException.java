package com.example.rinhabackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class SaldoMenorQueLimiteException extends Exception{

    public SaldoMenorQueLimiteException(){
        super("Saldo menor que limite");
    }
}
