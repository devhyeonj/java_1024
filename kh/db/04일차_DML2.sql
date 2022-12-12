use shoppingmall;

insert into board_category(bc_name) values('공지'),('자유'),('문의');

insert into board(bo_title, bo_contents,bo_me_id,bo_bc_num)
	values('공지 제목1','내용1','qwe',1);
    
select * from board_category;
select * from board;