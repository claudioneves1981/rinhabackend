package com.example.rinhabackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class TransacaoMenorQueZeroException extends Exception{

    public TransacaoMenorQueZeroException(){
        super("Transação menor que zero");

    }
}
