insert into article(title, content) values('가가', '11');
insert into article(title, content) values('나나', '22');
insert into article(title, content) values('다다', '33');

-- article 더미 데이터
insert into article(title, content) values('돈까스', '댓글 ㄱ');
insert into article(title, content) values('피자', '댓글 ㄱㄱ');
insert into article(title, content) values('햄복어', '댓글 ㄱㄱㄱ');

-- comment 더미 데이터
---- 4번 게시글의 댓글듯
insert into comment(article_id, nickname, body) values(4, 'Park', '샐드');
insert into comment(article_id, nickname, body) values(4, 'Kim', '김치');
insert into comment(article_id, nickname, body) values(4, 'Choi', '인석');

---- 5번 게시글의 댓글듯
insert into comment(article_id, nickname, body) values(5, 'Park', '사라다');
insert into comment(article_id, nickname, body) values(5, 'Kim', '무김치');
insert into comment(article_id, nickname, body) values(5, 'Choi', '썩소');

---- 6번 게시글의 댓글듯
insert into comment(article_id, nickname, body) values(6, 'Park', '샐러드');
insert into comment(article_id, nickname, body) values(6, 'Kim', '진짜');
insert into comment(article_id, nickname, body) values(6, 'Choi', '삼동');



