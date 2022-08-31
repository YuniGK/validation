package com.example.validation.controller;

import com.example.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    /*
     Validation - null값에 대하여 미리 검증하는 과정
     @Valid 붙여주면 된다. 그후 검증이 필요한 dto에서 각 상황에 맞는 어노테이션 설정을 해준다.

     BindingResult - 검증 오류가 발생할 경우 오류 내용을 보관
    */

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();

            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                System.out.println("bindingResult = " + field.getField() + "message = " + message);

                sb.append("field = "+field.getField());
                sb.append("message = "+message);

            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());

        }

        System.out.println("user = " + user);

        return ResponseEntity.ok(user);
    }

}
