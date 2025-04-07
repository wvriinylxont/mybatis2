package com.example.mybatis.memo;

import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface MemoDao {
  @Insert("insert into memo(mno,title,content,writer) values(memo_seq.nextval,#{title}, #{content}, #{writer})")
  public int save(Memo memo);

  @Select("select * from memo")
  public List<Memo> findAll();

  // rownum=1로 결과의 개수를 오라클에게 알려준다
  @Select("select * from memo where mno=#{mno} and rownum=1")
  public Memo findByMno(int mno);

  @Update("update memo set content=#{content} where mno=#{mno} and rownum=1")
  public int update(String content, int mno);

  @Delete("delete from memo where mno=#{mno} and rownum=1")
  public int delete(int mno);
}
