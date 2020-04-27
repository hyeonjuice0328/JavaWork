-- JOIN

-- FROM 절에 테이블에도 별칭을 줄 수 있다. 
--20개의 레코드
SELECT s.STUDNO , s.NAME , s.DEPTNO1 
FROM T_STUDENT s;
-- t_student 의 별칭 s

--12개의 레코드 
SELECT d.DEPTNO , d.DNAME 
FROM T_DEPARTMENT d

--240개
SELECT s.STUDNO , s.NAME , s.DEPTNO1, 
	d.DEPTNO , d.DNAME 
FROM T_STUDENT s, T_DEPARTMENT d
;

-- 카티션곱 (Cartesian Product)
-- 두개의 테이블을 JOIN 하게 되면, 
-- 각 테이블의 레코드들의 모든 조합이 출력된다.
-- WHERE 나 ON 등으로 JOIN 조건이 주어지지 않으면 
-- 모든 카티션곱이 출력된다. 

--240개
SELECT s.STUDNO , s.NAME , s.DEPTNO1, 
	d.DEPTNO , d.DNAME 
FROM T_STUDENT s, T_DEPARTMENT d  -- Oracle 방식
;

SELECT s.STUDNO , s.NAME , s.DEPTNO1, 
	d.DEPTNO , d.DNAME 
FROM T_STUDENT s
	CROSS JOIN T_DEPARTMENT d -- ANSI 방식
;

-- equal join
SELECT s.name 학생이름 , s.DEPTNO1 학과번호, d.DNAME "학과이름"
FROM  T_STUDENT s, T_DEPARTMENT d  -- Oracle 방식
WHERE s.DEPTNO1  = d.DEPTNO 
;

--ANSI 방식
SELECT s.name 학생이름 , s.DEPTNO1 학과번호, d.DNAME "학과이름"
FROM  T_STUDENT s JOIN T_DEPARTMENT d  ON s.DEPTNO1  = d.DEPTNO
-- 조건: Equi Join
;

-- 제2전공은? deptno2
SELECT s.NAME 학생이름, s.DEPTNO2 제2학과, d.DNAME 학과이름
FROM T_STUDENT  s, T_DEPARTMENT d
WHERE s.DEPTNO2  = d.DEPTNO 
;

--#6102
SELECT * FROM T_STUDENT ;
SELECT * FROM T_PROFESSOR ;
--oravle방식
SELECT  s.NAME 학생이름, s.PROFNO 지도교수, p.NAME 지도교수이름
FROM T_STUDENT s, T_PROFESSOR p
WHERE s.PROFNO  = p.PROFNO ;
--ANSI 방식
SELECT s.name 학생이름 , s.PROFNO 지도교수, p.NAME 지도교수이름
FROM  T_STUDENT s JOIN T_PROFESSOR p  ON s.PROFNO  = p.PROFNO;
-- 조건: Equi Join

--#6103
SELECT * FROM T_STUDENT ;
SELECT * FROM T_PROFESSOR ;
SELECT * FROM T_DEPARTMENT ; 
--ORCLE
SELECT s.NAME 학생이름, d.DNAME 학과이름, p.NAME 교수이름
FROM T_STUDENT s, T_DEPARTMENT d, T_PROFESSOR p
WHERE s.DEPTNO1 = d.DEPTNO and s.PROFNO = p.PROFNO 
;
--ANCI
SELECT s.NAME 학생이름, d.DNAME 학과이름, p.NAME 교수이름
FROM T_STUDENT s 
	JOIN T_DEPARTMENT d ON s.DEPTNO1 = d.DEPTNO
	JOIN T_PROFESSOR p ON s.PROFNO = p.PROFNO 
;

--#6104
SELECT * FROM T_EMP2 ;
SELECT * FROM T_POST ;
--ORACLE
SELECT E.NAME 사원이름, E.POST 현재, E.PAY 현재연봉,
	P.S_PAY 하한금액, P.E_PAY 상한금액
FROM T_EMP2 E, T_POST P
WHERE E.POST = P.POST ;
--ANCI
SELECT E.NAME 사원이름, E.POST 현재, E.PAY 현재연봉,
	P.S_PAY 하한금액, P.E_PAY 상한금액
FROM T_EMP2 E JOIN T_POST P ON E.POST = P.POST;

--#6105
SELECT * FROM T_STUDENT ;
SELECT * FROM T_PROFESSOR ;
--ORACLE
SELECT S.NAME 학생이름, P.NAME 교수이름
FROM T_STUDENT S, T_PROFESSOR P
WHERE DEPTNO1 = 101 AND 
	S.PROFNO  = P.PROFNO ;
--ANCI
SELECT S.NAME 학생이름, P.NAME 교수이름
FROM T_STUDENT S JOIN T_PROFESSOR P ON S.PROFNO  = P.PROFNO
WHERE DEPTNO1 = 101 ;






















