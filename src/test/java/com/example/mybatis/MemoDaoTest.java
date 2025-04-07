package com.example.mybatis;

import com.example.mybatis.memo.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.transaction.annotation.*;

import java.time.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MemoDaoTest {
  @Autowired
  private MemoDao memoDao;

  @Test
  public void saveTest() {
    Memo m = Memo.builder().title("토익 접수").content("토익 접수 확인").writer("spring").build();
    int result = memoDao.save(m);
    assertEquals(1, result);
  }

 // @Test
  public void findAllTest() {
    assertEquals(1, memoDao.findAll().size());
  }

  @Test
  public void findByMnoTest() {
    Optional<Memo> result = memoDao.findByMno(1);
    // Optional을 전달받으면 get()으로 객체를 꺼낼 수 있다
    // 단, 없으면 NoSuchElementException 발생
    // Memo memo = result.get();
    // null을 체크할 수가 있다
    if(result.isPresent()) {
      Memo memo = result.get();
    }
  }

  @Test
  public void updateTest() {
    int result = memoDao.update("토익접수 했니", 1);
    assertEquals(1, result);
    result = memoDao.update("귀찮아요", 100);
    assertEquals(0, result);
  }
  // 테스트에서 사용하면 자동 rollback
  @Transactional
  @Test
  public void deleteTest() {
    int result = memoDao.delete(1);
    assertEquals(1, result);
    result = memoDao.delete(100);
    assertEquals(0, result);
  }
}
