package com.example.rinhabackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class DescricaoMaiorQueDezException extends Exception{

    public DescricaoMaiorQueDezException(){
        super("Descrição maior que 10");
    }

}
