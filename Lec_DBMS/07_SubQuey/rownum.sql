-- SELECT 결과물중 맨 위의 5개만 출력해보고 싶으면 어케 해야 하나?
--   ex) 게시판.. 페이징

-- DBMS 마다 구현 방법 다름
--	MYSQL : LIMIT
-- 	MS SQL server : TOP
-- 	ORACLE : ROWNUM 

SELECT empno, ename, sal FROM t_emp;

-- 자동적으로 오라클에서 붙여주는 행번호 객체 (ROWNUM)
SELECT ROWNUM, empno, ename, sal FROM t_emp;
-- 직원번호 역순.  그러나 ROWNUM 은 1 ~ 
SELECT ROWNUM, empno, ename, sal FROM t_emp ORDER BY empno DESC;

-- 상위 5개만!
SELECT ROWNUM, empno, ename, sal FROM t_emp ORDER BY empno DESC;

-- SELECT 에 ROWNUM 없어도 동작
SELECT empno, ename, sal FROM t_emp 
WHERE ROWNUM <= 5 ORDER BY empno DESC;


-- ROWNUM > 5 ??? 동작안함..   ROWNUM 범위가 1이 포함안되면 동작안함.
SELECT ROWNUM, empno, ename, sal FROM t_emp 
WHERE ROWNUM > 5 ORDER BY empno DESC;

-- 상위 5개 출력 
-- row1 ~ row5 까지 출력 (1 page)
SELECT ROWNUM, empno, ename, sal FROM t_emp 
WHERE ROWNUM >= 1 AND ROWNUM < 1 + 5
ORDER BY empno DESC;

-- (2page)
SELECT ROWNUM, empno, ename, sal FROM t_emp 
WHERE ROWNUM >= 6 AND ROWNUM < 6 + 5
ORDER BY empno DESC;  -- 안나온다.. 후엥..

--phonebook
SELECT * FROM PHONEBOOK ;
INSERT INTO PHONEBOOK (SELECT * FROM PHONEBOOK);
--primary key 제약 조건 중복되는데 중복허용 하지 않기 떄문에 에러 발생 

INSERT INTO PHONEBOOK 
	(SELECT phonebook_seq.nextval, PB_NAME , 
	PB_PHONENUM , PB_MEMO , SYSDATE FROM PHONEBOOK);

--ROWNUM rev.
SELECT PB_UID, pb_name, pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC;

SELECT T.*
FROM (SELECT PB_UID, pb_name, pb_phonenum 
	FROM PHONEBOOK ORDER BY PB_UID DESC) T;

SELECT ROWNUM AS RNUM, T.*
FROM (SELECT PB_UID, pb_name, pb_phonenum 
	FROM PHONEBOOK ORDER BY PB_UID DESC) T;

SELECT * FROM 
(
SELECT ROWNUM AS RNUM, T.*
FROM (SELECT PB_UID, pb_name, pb_phonenum 
	FROM PHONEBOOK ORDER BY PB_UID DESC) T
) WHERE RNUM >= 6 AND RNUM < 6+5;
--더이상 RNUM은 ROWNUM이 아니다. 

























