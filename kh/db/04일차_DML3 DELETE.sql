/*
-- delete 문
delete from 테이블명 where 조건절;
-- 조건절에는 일반적으로 기본키가 옴
*/
-- auto_increment는 번호를 기억하고 있음 그래서 삭제해도 삭제한 번호 건너뜀
-- 데이터 베이스 초기화해야지 일관성있게 됨
select * from board_category;

-- 3번 카테고리인 문의를 제거하는 쿼리문
delete from board_category
 where bc_num = 3;