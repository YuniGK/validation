package com.example.validation.annotaion;

import com.example.validation.validator.YearMonthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/*
ConstraintValidator - 커스텀 Validator, 그리고 커스텀 어노테이션을 만들어 예외 처리를 할 수 있다.

@Constraint - validatedBy 값으로 NotEqualValidator. class를 지정하였다.
차후 NotEqualValidator 클래스를 만들어 검증하게 할 것이다.

@Target
만들어진 어노테이션이 부착될 수 있는 타입을 지정하는 것이다.
TYPE은 클래스, 인터페이스, Enum에 부착할 수 있게 한다는 의미이다.

@Retention
어노테이션의 라이프 사이클, 즉 어노테이션이 언제까지 살아 남아 있을지를 정하는 것이다.
*/
@Constraint(validatedBy = {YearMonthValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface YearMonth {

    String message() default "yyyyMM 형식에 맞지 않습니다.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    //패턴을 지정하지 않으면 yyyyMM형식으로 지정된다.
    String pattern() default "yyyyMMdd";

}
