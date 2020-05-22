
/* Drop Tables */

DROP TABLE wtable CASCADE CONSTRAINTS;

/* Create Tables */

CREATE TABLE wtable
(
	wuid number NOT NULL,
	wname varchar2(40) NOT NULL,
	wsubject varchar2(100) NOT NULL,
	wcontent clob,
	wviewcnt number DEFAULT 0,
	wregdate date DEFAULT SYSDATE,
	PRIMARY KEY (wuid)
);

/* 시퀀스 생성하기 */
CREATE SEQUENCE wtable_sequence;
/* 테이블 전체보기*/
SELECT * FROM wtable;

-- 기본데이터 작성
INSERT INTO wtable VALUES
(wtable_sequence.nextval, '첫째글:', '안녕하세요', '김희철', 0, sysdate);
INSERT INTO wtable VALUES
(wtable_sequence.nextval, '둘째글:','1111', '김수길', 0, sysdate);
INSERT INTO wtable VALUES
(wtable_sequence.nextval, '세째글:', '7394', '최진덕' , 0, sysdate);
INSERT INTO wtable VALUES
(wtable_sequence.nextval, '네째글:', '9090', '이혜원', 0, sysdate);
INSERT INTO wtable VALUES
(wtable_sequence.nextval, '다섯째글: 게시판', '7531', '박수찬', 0, sysdate);

DELETE FROM TEST_WRITE WHERE WR_UID >10;




