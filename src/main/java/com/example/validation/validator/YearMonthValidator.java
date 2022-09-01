package com.example.validation.validator;

import com.example.validation.annotaion.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//ConstraintValidator - 커스텀 Validator, 그리고 커스텀 어노테이션을 만들어 예외 처리를 할 수 있다.
public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    /*
        isValid - 메서드는 필수로 오버라이딩하여 예외 상황을 검증하도록 한다.
        어노테이션이 부착된 객체를 인자로 한다.

        initialize - 메서드에서 초기화했던 필드명을 이용해 어노테이션이 부착된 객체로부터 필드 값을 가져온다.

        BeanWrapperImpl - 리플렉션을 이용해 필드 값을 가져온다.
    */
    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try{
            LocalDate localDate = LocalDate.parse(value+"01", DateTimeFormatter.ofPattern(this.pattern));
        }catch (Exception e){
            return false;
        }

        return true;
    }
}
