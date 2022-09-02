package com.kh.myapp3.domain.dao;


import com.kh.myapp3.domain.Member;

import java.util.List;

public interface MemberDAO {

  /**
   * 가입
   * @param member 가입정보
   * @return 회원
   */
  Member insert(Member member);

  /**
   * 조회 by 회원아이디
   * @param memberId 회원아이디
   * @return 회원정보
   */
  Member findById(Long memberId);

  /**
   * 수정
   * @param memberId 아이디
   * @param member  수정할 정보
   */
  void update(Long memberId, Member member);

  /**
   * 탈퇴
   * @param memberId 아이디
   */
  void del(Long memberId);

  /**
   * 목록
   * @return 회원전체
   */
  List<Member> all();

}
