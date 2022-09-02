package com.kh.myapp3.domain.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.myapp3.domain.Member;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO{

  private final JdbcTemplate jt;

  /**
   * 가입
   *
   * @param member 가입정보
   * @return 회원
   */
  @Override
  public Member insert(Member member) {
    StringBuffer sql = new StringBuffer();
    sql.append("insert into member (member_id,email,pw,nickname) ");
    sql.append("values(?,?,?,?) ");

    Long memberId = generateMemberId();
    jt.update(sql.toString(), memberId, member.getEmail(), member.getPw(), member.getNickname());

    return findById(memberId);
  }

  //신규 회원번호 생성
  private Long generateMemberId(){
    String sql = "select member_member_id_seq.nextval from dual ";
    Long memberId = jt.queryForObject(sql, Long.class);
    return memberId;
  }

  /**
   * 조회 by 회원아이디
   *
   * @param memberId 회원아이디
   * @return 회원정보
   */
  @Override
  public Member findById(Long memberId) {
    StringBuffer sql = new StringBuffer();

    sql.append("select member_id,email,pw,nickname,cdate,udate ");
    sql.append("  from member ");
    sql.append(" where member_id = ? ");

    Member findedMember = null;
    try {
      findedMember = jt.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(Member.class));
    } catch (DataAccessException e) {
      log.info("찾고자하는 회원이 없습니다!={}",memberId);
    }

    return findedMember;
  }

  /**
   * 수정
   *
   * @param memberId 아이디
   * @param member   수정할 정보
   */
  @Override
  public void update(Long memberId, Member member) {

  }

  /**
   * 탈퇴
   *
   * @param memberId 아이디
   */
  @Override
  public void del(Long memberId) {

  }

  /**
   * 목록
   *
   * @return 회원전체
   */
  @Override
  public List<Member> all() {
    return null;
  }
}
