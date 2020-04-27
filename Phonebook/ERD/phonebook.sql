
/* Drop Tables */

DROP TABLE phonebook CASCADE CONSTRAINTS;

/* Create Tables */

CREATE TABLE phonebook
(
	pb_uid number NOT NULL,
	pb_name varchar2(40) NOT NULL,
	pb_phonenum varchar2(40),
	pb_memo clob,
	pb_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (pb_uid)
);


DROP SEQUENCE phonebook_seq;
CREATE SEQUENCE phonebook_seq;

SELECT * FROM PHONEBOOK ;


SELECT COUNT(*) cnt FROM TEST_MEMBER; -- 테이블의 모든 레코드 갯수
SELECT max(MB_NO) FROM TEST_MEMBER ; -- mb_no 의 최댓값
SELECT min(MB_NO) FROM TEST_MEMBER ;

SELECT COUNT(*) cnt FROM PHONEBOOK ;







