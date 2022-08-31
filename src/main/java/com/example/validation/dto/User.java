package com.example.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    /*
     Validation - null값에 대하여 미리 검증하는 과정
     @Valid 붙여주면 된다. 그후 검증이 필요한 dto에서 각 상황에 맞는 어노테이션 설정을 해준다.
￼￼￼￼￼
    @Size - 뮨저 갈이 측정
    @NotNull - null 불가
    @NotEmpty - null, "" 불가
    @NotBlank - null, "", " " 불가
    @Past - 과거 날짜
    @PastOrPresent - 오늘이거나 과거 날짜
    @Future - 미래 날짜
    @FutureOrPresent - 오늘이거나 미래 날짜
    @Pattern - 정규식 적용
    @Max - 최대값
    @min - 최소값
    @AssertTrue / False - 별도의 로직 적용

    message에서 저장한 내용은 BindingResult에 보내진다.
    */
    @NotBlank
    private String name;
    @Min(value = 0)
   //@Max(value = 90)
    private int age;
    @Email
    private String email;
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "양식과 맞지 않습니다. 01x-xxx(x)-xxxx")
    private String phoneNumber;
}
