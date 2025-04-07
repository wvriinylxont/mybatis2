package com.example.mybatis.memo;

import lombok.*;

import java.time.*;

// 스프링은 커맨드 객체를 기본생성자로 생성한 다음, setter로 값을 집어넣는다
// 롬복에서 @Builder를 사용할 때 @AllArgsConstructor도 필요
@Getter
// 값 받아오는거 setter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Memo {
  private int mno;
  private String title;
  private String content;
  private String writer;
  // 빌더를 사용한 경우 필드에 값을 직접 지정하는 인스턴스 초기화를 무시
  private LocalDate regDate;
}
