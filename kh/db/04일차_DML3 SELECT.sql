/*select  속성 | 식등 순서 지켜야함~~
	[from 테이블명]
    [where 조건절] -- 조건에 맞는 결과를 조회, ==가 아닌 =를, 같지 않은 경우는 != 를 이용
    -- 속성명1로 정렬(오름차순 | 내림차순) 한 후, 속성명1의 값이 같은 행들을 속성명2로 정렬(오름차순 | 내림차순)
    -- 정렬방법이 생략되면 asc(오름차순)
   [order by 속성명1 [asc | desc], 속성명2 [asc | desc]
   -- 검색 결과의 개수를 제한
   -- limit 번지, 개수 : 지정번지부터 개수
   -- limit 개수 : 0번지부터 개수
   [limit절]
    ;
*/
use shoppingmall;
-- member 테이블의 me_id와 me_pw 조회
select me_id,me_pw
	from member;
-- member 테이블에 있는 모든 회원 정보를 조회
select * from member;    
-- member 테이블에 아이디가 abc인 회원 정보를 조회
select * from member where me_id = 'abc';
-- 관리자의 아이디를 조회
select me_id from member where me_authority = 'ADMIN';
-- 일반 회원의 아이디를 조회
select me_id from member where me_authority = 'MEMBER';
select me_id from member where me_authority != 'ADMIN';
select me_id from member where me_authority <> 'ADMIN'; -- 같지않다

-- 회원들을 아이디순으로 오름차순으로 정렬
select * from member order by me_id;
-- 회원들을 생일순으로 내림차순으로 정렬
select * from member order by me_birth desc;

-- 회원들을 아이디순으로 오름차순으로 정렬하여 처음 2명 조회
select * from member order by me_id limit 0, 2;

select * from member;   
-- 회원들을 아이디순으로 오름차순으로 정렬하여 2번째 2명만 조회
select * from member order by me_id limit 2, 2;

-- 회원들을 아이디순으로 오름차순으로 정렬하여 3번쨰 2명만 조회
select * from member order by me_id limit 4, 2;
-- n번째 x명 조회 limit (n-1)*x , x 기억하기!!!!!!!!!페이징 부분

-- 게시글에서 조회수가 1이상 100이하인 게시글들을 조회
select * from board where bo_views >= 1 and bo_views <= 100;
-- A이상 B이하 : between A and B
select * from board where bo_views between 1 and 100;

-- 게시글에서 카테고리 번호가 1번(공지) 또는 2번

select * from board where bo_bc_num = 1 or bo_bc_num = 2;

/* 문자열 검색
- 	= 는 두 문자열이 동일해야 true 
- like을 이용하여 문자열1이 문자열2에 있는지 확인 할 수 있다
... where 속성명 like 문자열
- _ : 한 글자를 의미
... where bo_title like '_ _ _' : 제목이 3글자인 게시글들을 가져옴
- % : 0글자 이상을 의미
... where bo_title like '공지%' : 제목이 공지로 시작하는 모든 게시글들
... where bo_title like '%공지' : 제목이 공지로 끝나는 모든 게시글들
... where bo_title like '%공지%' : 제목이 공지가 들어가는 모든 게시글들
*/

-- 2022년도에 작성된 게시글들을 조회

select * from board where bo_reg_date like '2022%';

-- A as B : A의 이름을 B로 수정(일시적) - select문으로 검색 결과를 출력할 때

