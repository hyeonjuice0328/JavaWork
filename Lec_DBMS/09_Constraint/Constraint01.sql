-- 제약조건

SELECT * FROM T_DEPT2 ;
SELECT * FROM T_PROFESSOR ;
--부서코드 DCODE 를 참조하는 테이블 생성할 예정
-- 테이블 생성시 동시에 설정하기 
--#9001
DROP TABLE t_emp3 CASCADE CONSTRAINT;
--CASCADE CONSTRAINT 제약조건도 같이 지우기 
CREATE TABLE t_emp3 (
	NO number(4) PRIMARY KEY,
	name varchar2(10) NOT null,
	jumin char(13) NOT NULL unique,
	area number(1) CHECK(area < 5),
	deptno varchar2(6) REFERENCES t_dept2(dcode)
);
--별도의 항목으로 제약조건 정의 가능 
-- not null은 제외
DROP TABLE t_emp4 CASCADE CONSTRAINT;
CREATE TABLE t_emp4 (
	NO number(4),
	name varchar2(10) NOT null,
	jumin char(13) NOT NULL,
	area number(1),
	deptno varchar2(6),
	PRIMARY KEY(no),
	UNIQUE(jumin),
	check(area < 5),
	FOREIGN KEY(deptno) REFERENCES t_dept2(dcode)
);



--#9002
--제약조건명을 명시하여 정의 
DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
	NO number(4) CONSTRAINT emp3_no_pk PRIMARY KEY,
	name varchar2(10) CONSTRAINT emp3_name_nn NOT null,
	jumin char(13) 
	CONSTRAINT emp3_jumin_nn NOT NULL 
	CONSTRAINT emp3_jumin_uk unique,
	area number(1) CONSTRAINT emp3_area_ck CHECK(area < 5),
	deptno varchar2(6) CONSTRAINT emp3_deptno_fk 
	REFERENCES t_dept2(dcode)
);


DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
	NO number(4) ,
	name varchar2(10) CONSTRAINT emp3_name_nn NOT null,
	jumin char(13) CONSTRAINT emp3_jumin_nn NOT NULL 
	area number(1), 
	deptno varchar2(6),
	 CONSTRAINT emp3_no_pk PRIMARY KEY(no),
	 CONSTRAINT emp3_jumin_uk UNIQUE(jumin),
	 CONSTRAINT emp3_area_ck CHECK(area < 5),
	 CONSTRAINT emp3_deptno_fk FOREIGN KEY(deptno) REFERENCES t_dept2(dcode)
);



--#9002
-- 제약조건 조회하기 
SELECT OWNER , CONSTRAINT_NAME , CONSTRAINT_TYPE , STATUS 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_EMP4'; --table name 대문자로

SELECT OWNER , CONSTRAINT_NAME , CONSTRAINT_TYPE , STATUS 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_EMP3'; 
 


--#9005: 제약 조건에 맞는 또는 위배되는 DML 시도 해보기 
INSERT INTO t_emp3 VALUES (1, '오라클', '1234561234567', 4, 1000);
-- 두번 실행하면 오류 : ORA-00001: unique constraint (SCOTT0316.EMP3_NO_PK) violated
INSERT INTO t_emp3 VALUES (2, '오라클', '1234561234567', 4, 1000);
INSERT INTO t_emp3 VALUES (3, '오라클', '1234561234567', 4, 1000);
-- jumin ORA-00001: unique constraint (SCOTT0316.EMP3_JUMIN_UK) violated
INSERT INTO t_emp3 VALUES (4, '오라클', '2222222222222222', 4, 1000);
-- ORA-12899: value too large for column "SCOTT0316"."T_EMP3"."JUMIN" (actual: 16, maximum: 13)
INSERT INTO t_emp3 VALUES (4, '오라클', '2222222222222', 10, 1000);
--check오류 :  ORA-01438: value larger than specified precision allowed for this column
INSERT INTO t_emp3 VALUES (4, '오라클', '2222222222222', 3, 2000);
--  ORA-02291: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - parent key not found
INSERT INTO t_emp3 (NO, jumin, area, dptno) VALUES (5, '3333333333333', 4, 1001);
--  ORA-01400: cannot insert NULL into ("SCOTT0316"."T_EMP3"."NAME")

--INSERT 뿐 아니라 UPDATE/DELETE 에서도 오류 발생 가능
UPDATE t_emp3 SET area = 10, WHERE NO = 1; -- check값 오류 
--ORA-01747: invalid user.table.column, table.column, or column specification



--#9005 테이블 생성 후에 ALTER 명령 사용해서 제약조건 추가 가능 ! 
-- 이미 만들어져있는 t_emp4 의 name 컬럼에 UNIQUE 제약조건 추가하기 
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_uk UNIQUE(name); -- 성공

--#9006
-- t_emp4의 area에 not null추가 
-- 기본적으로 컬럼은 null을 허용한다. 이미 지정이 되어있는데 또 추가하려고 하면 에러가 난다. 그래서 ADD 로 주가하는게 아니라 MODIFY로 간다. 
--ALTER TABLE t_emp4 ADD CONSTRAINT emp4_area_nn NOT NULL; 
ALTER TABLE t_emp4 MODIFY (area CONSTRAINT emp4_area_nn NOT NULL); -- 성공

--#9007
--외래키 추가 ,참조
ALTER TABLE t_emp4    
ADD CONSTRAINT emp4_name_fk FOREIGN KEY(name) REFERENCES t_emp2(name);
--참조되는 부모 테이블의 컬럼은 PRIMATY KEY 이거나 UNIQUE 해야 한다. 
--ORA-02270: no matching unique or primary key for this column-list

--	1. 부모 테이블의 name 을 unique 로 바꾼뒤 쿼리는 다시 실행해보기 
ALTER TABLE t_emp2 ADD CONSTRAINT emp2_name_uk UNIQUE(name);
-- 2  다시 실행 
ALTER TABLE t_emp4 
ADD CONSTRAINT emp4_name_fk FOREIGN KEY(name) REFERENCES t_emp2(name);


--#9008
DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
	NO number(4) CONSTRAINT emp3_no_pk PRIMARY KEY,
	name varchar2(10) CONSTRAINT emp3_name_nn NOT null,
	jumin char(13) 
	CONSTRAINT emp3_jumin_nn NOT NULL 
	CONSTRAINT emp3_jumin_uk unique,
	area number(1) CONSTRAINT emp3_area_ck CHECK(area < 5),
	deptno varchar2(6) 
		CONSTRAINT emp3_deptno_fk REFERENCES t_dept2(dcode)
		ON DELETE CASCADE -- 부모가 삭제되면 자식도 같이 삭제  
		-- ON DELETE SET NULL -- 부모가 삭데죄면 NULL값으로 
		);


--#9009
-- 부모 테이블이 삭제되면 NULL 이 되도록 설정하기 
-- 테이블이 이미 만들어져있기 떄문에 ALTER 사용하기 
ALTER TABLE t_emp4 DROP CONSTRAINT emp4_name_fk; -- 기존 제약 조건 삭제 

ALTER TABLE t_emp4 
	ADD CONSTRAINT emp4_name_fk FOREIGN KEY(name) 
	REFERENCES t_emp2(name)
	ON DELETE SET NULL ;

-----------------------------------------------
-- DISABLE NOVALIDATE

--  #9010
SELECT * FROM t_novalidate;
SELECT * FROM t_validate;

SELECT OWNER, CONSTRAINT_NAME , CONSTRAINT_TYPE, STATUS 
FROM USER_CONSTRAINTS 
WHERE table_name = 'T_NOVALIDATE';

INSERT INTO t_novalidate VALUES(1, 'DDD');  -- 처음에는 에러!  PK니까!

--제약조건 끄기
ALTER TABLE T_NOVALIDATE 
disable novalidate constraint SYS_C007109;

--제약조건 다시 키기 
--이미 조건이 달라져있기 때문에 다시 키는것은 불가능
--데이터들 다시 정리하고 키는 건 가능 ! 
ALTER TABLE T_NOVALIDATE 
disable novalidate constraint SYS_C007109;













