-- test 계정 추가. 비번 설정 없음 
create user test;
-- test1 계정 추가 비번이 1234
create user test1 identified by '1234';
-- test1 계정에게 shoppingmall2 DB에 있는 모든 테이블의 select 권한을 부여
-- '%' : 외부에서 접근 허용, 'localhost' : 내부에서 접근 허용 
grant select on shoppingmall2.* to test1@'%';
-- test1 계정에게 shoppingmall2 DB에 있는 모든 테이블의 모든 권한을 부여
grant all privileges on shoppingmall2.* to test1@'%';

-- 권한 회수 
revoke all on shoppingmall2.* from test1;

-- 계정 삭제 
drop user test;