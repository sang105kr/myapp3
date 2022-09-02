package com.kh.myapp3.domain.svc;

import com.kh.myapp3.domain.Member;
import com.kh.myapp3.domain.dao.MemberDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberSVCImpl implements MemberSVC{

   private final MemberDAO memberDAO;

  /**
   * 가입
   *
   * @param member 가입정보
   * @return 회원아이디
   */
  @Override
  public Member insert(Member member) {

    //회원 아이디 생성
    Long generateMemberId = memberDAO.generateMemberId();
    member.setMemberId(generateMemberId);
    memberDAO.insert(member);
    return memberDAO.findById(generateMemberId);
  }

  /**
   * 조회 by 회원아이디
   *
   * @param memberId 회원아이디
   * @return 회원정보
   */
  @Override
  public Member findById(Long memberId) {
    return memberDAO.findById(memberId);
  }

  /**
   * 수정
   *
   * @param memberId 아이디
   * @param member   수정할 정보
   * @return 수정건수
   */
  @Override
  public void update(Long memberId, Member member) {
    int cnt = memberDAO.update(memberId, member);
    log.info("수정건수={}",cnt);
  }

  /**
   * 탈퇴
   *
   * @param memberId 아이디
   * @return 삭제건수
   */
  @Override
  public void del(Long memberId) {
    int cnt = memberDAO.del(memberId);
    log.info("삭제건수={}", cnt);
  }

  /**
   * 목록
   *
   * @return 회원전체
   */
  @Override
  public List<Member> all() {
    return memberDAO.all();
  }
}