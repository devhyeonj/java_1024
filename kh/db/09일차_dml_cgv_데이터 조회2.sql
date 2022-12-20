-- 영화인 등록
insert into movie_person(mp_name,mp_birth,mp_contry) values
	('안태진',null,'한국'),('조성하','1966-08-08','한국'),
    ('류준열','1986-09-25','한국'),('박명훈','1975-05-28','한국'),
    ('유해진','1970-01-04','한국'),('김성철','1991-12-31','한국'),
    ('최무성','1968-01-12','한국'),('안은지','1991-05-06','한국')
    ,('조윤서','1993-01-04','한국');
-- 영화 등록
    insert into movie(mo_title,mo_contents,mo_age,mo_run,mo_opening_date,mo_state) 
	values('올빼미','맹인이지만 뛰어난 침술 실력을 지닌 ‘경수’는 
어의 ‘이형익’에게 그 재주를 인정받아 궁으로 들어간다.
그 무렵, 청에 인질로 끌려갔던 ‘소현세자’가 8년 만에 귀국하고,
‘인조’는 아들을 향한 반가움도 잠시 정체 모를 불안감에 휩싸인다.
그러던 어느 밤, 어둠 속에서는 희미하게 볼 수 있는 ‘경수’가
‘소현세자’의 죽음을 목격하게 되고
진실을 알리려는 찰나 더 큰 비밀과 음모가 드러나며
목숨마저 위태로운 상황에 빠진다.
아들의 죽음 후 ‘인조’의 불안감은 광기로 변하여 폭주하기 시작하고
세자의 죽음을 목격한 ‘경수’로 인해 관련된 인물들의 민낯이 서서히 드러나게 되는데...','15세 이상',118,'2022-11-23','현재상영중');

-- 영화 장르 등록
insert into movie_genre(mg_ge_name,mg_mo_num) 
	values('스릴러',2);
    
-- 영화 캐스팅 등록
insert into movie_casting(mc_mp_num,mc_mo_num) 
	values(16,2),(17,2),(18,2),(19,2),(20,2),(21,2),(22,2),(23,2),(24,2);
    
-- 트레일러 등록
insert into trailer(tr_title,tr_mo_num,tr_file_name)
values('[올빼미]박스오피스 1위 리뷰 예고편',2,'http://h.vod.cgv.co.kr/vodCGVa/86481/86481_210223_1200_128_960_540.mp4');

-- 스틸컷 등록
insert into stillcut(st_mo_num,st_file_name)
values(2,'https://img.cgv.co.kr/Movie/Thumbnail/StillCut/000086/86481/86481210724_727.jpg');

-- 상영시간 등록 상영날짜 , 상영시간 , 총좌석수 , 예매가능좌석수 , 영화번호(fk) , 영화관번호(fk)
insert into screen_schedule(ss_date,ss_time,ss_total_seat,ss_possible_seat,ss_mo_num,ss_ci_num)
	values('2022-12-20','13:50',124,124,2,2),('2022-12-20','11:00',124,124,2,6),('2022-12-20','17:10',124,124,2,6);

-- abc 회원이 올빼미 12월 20일 13:50을 3장 예매
-- 예매
insert into ticketing(ti_amount,ti_me_id,ti_ss_num,ti_total_price)
	values(3,'abc',24,30000);
    
-- 좌석 예매
insert into ticketing_seat(ts_ti_num,ts_se_num)
	select 2, se_num from seat where se_name = 'A1' and se_ci_num = 2;
insert into ticketing_seat(ts_ti_num,ts_se_num)
	select 2, se_num from seat where se_name = 'B1' and se_ci_num = 2;
insert into ticketing_seat(ts_ti_num,ts_se_num)
	select 2, se_num from seat where se_name = 'C1' and se_ci_num = 2;

-- 상영정보에 예매 가능 좌석 수정
update screen_schedule
	set ss_possible_seat = ss_possible_seat -3
    where ss_num = 24;
    
-- abc회원이 예매한 올빼미 상영좌석을 조회(관이름과 좌석번호 조회)
select se_name as 'abc회원이 예매한 영화 올빼미 좌석' from ticketing
join screen_schedule on ss_num = ti_ss_num
join movie on mo_num = ss_mo_num
join ticketing_seat on ts_ti_num = ti_num
join seat on ts_se_num = se_num
where mo_title like '올빼미' and ti_me_id like 'abc'; 

-- 올빼미 12월 20일 13:50 상영에 예매 가능한 좌석을 조회
select se_name as '예매 가능한 좌석' , case when ts_num is null then 'O' else 'X' end as '예약가능' from(select * from screen_schedule where ss_date = '2022-12-20' and ss_time = '13:50')as ss
join (select * from movie where mo_title = '올빼미')as mo on mo_num = ss_mo_num
join cinema on ss_ci_num = ci_num
join seat on se_ci_num = ci_num -- 여기까지 올빼미 12월 20일 13:50 모든 좌석을 불러옴
left join ticketing on ti_num = ti_ss_num -- left join 을 안하면 사라짐
left join ticketing_seat on se_num = ts_se_num; -- left join 을 안하면 사라짐

-- screen_schedule에 영화 제목 속성을 추가하면 movie 테이블과 join을 하지 않아도 됨. 단 , 데이터는 중복
-- ticekting_seat에 좌석 이름을 추가하면 좌석명을 알기 위해 seat 테이블과 join 하지 않아도 됨

-- 영화별 누적 관객 수를 조회
select mo_title as 영화제목, sum(ti_amount) as 누적관객수 from ticketing
join screen_schedule on ti_ss_num = ss_num
join movie on ss_mo_num = mo_num
group by ti_num;

-- 강사님코드
select mo_title as 영화제목, ifnull(sum(ti_amount),0) as 관객수 from movie
	left join (select * from screen_schedule where ss_date <= now()) as ss 
    on ss_mo_num = mo_num
    left join ticketing on ti_ss_num = ss_num
    group by mo_num;

-- 순위
select mo_title as 영화제목, ifnull(sum(ti_amount),0) as 관객수 from movie
	left join (select * from screen_schedule where ss_date <= now()) as ss 
    on ss_mo_num = mo_num
    left join ticketing on ti_ss_num = ss_num
    group by mo_num
    order by 관객수 desc;

-- 날짜가 지났을 때 변경되어야 할 쿼리를 작성
-- 회원이 본 영화 수를 체크
UPDATE member 
SET 
    me_movie_count = (SELECT 
            COUNT(DISTINCT ss_mo_num)
        FROM
            ticketing
                JOIN
            screen_schedule ON ss_num = ti_ss_num
        WHERE
            ss_date < NOW())
where 
	me_id = 'abc';
    
-- 'abc' 회원이 본 영화 목록 갯수
select count(distinct ss_mo_num) from ticketing
join screen_schedule on ss_num = ti_ss_num
where ss_date < now();

-- 올빼미 12월 20일 13:50 예매를 취소할 때 실행해야 하는 쿼리를 작성
delete from ticketing
where ti_ss_num = '24';
    
-- 좌석 취소
delete from ticketing_seat
where ts_ti_num = '2';

-- 상영정보에 예매 가능 좌석 수정
update screen_schedule
	set ss_possible_seat = ss_possible_seat +3
    where ss_num = 24;
