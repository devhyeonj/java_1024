-- 가전 제품을 조회
select * from product where pr_pc_num = 
(select pc_num from product_category where pc_name = '가전');

-- 제품명으로 tv를 검색하여 조회

select  * from product where pr_title like '%tv';

-- abc회원이 구매 확정한 목록을 조회
select * from buy where bu_state = '구매확정' and bu_me_id = 'abc';



