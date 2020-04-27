-- 비등가 JOIN

SELECT * FROM T_CUSTOMER ;
SELECT * FROM T_GIFT ;

--#6201
--ORACLE
SELECT  C.C_NAME 고객명, C.C_POINT POINT, G.G_NAME 상품명
FROM T_CUSTOMER C , T_GIFT G
WHERE C.C_POINT BETWEEN G.G_START AND G.G_END ;
--ANCI
SELECT  C.C_NAME 고객명, C.C_POINT POINT, G.G_NAME 상품명
FROM T_CUSTOMER C JOIN T_GIFT G  
	ON C.C_POINT BETWEEN G.G_START AND G.G_END ;
	
--#6202
--ORACLE
SELECT  G.G_NAME 상품명, COUNT(*) 필요수량
FROM T_CUSTOMER C , T_GIFT G
WHERE C.C_POINT BETWEEN G.G_START AND G.G_END
GROUP BY G_NAME;
--ANCI
SELECT  G.G_NAME 상품명, COUNT(*) 필요수량
FROM T_CUSTOMER C JOIN T_GIFT G
	ON C.C_POINT BETWEEN G.G_START AND G.G_END
GROUP BY G_NAME;

--#6203
SELECT * FROM T_STUDENT ;
SELECT * FROM T_EXAM01 ;
SELECT * FROM T_CREDIT ;
--ORACLE
SELECT S.NAME 학생이름, E.TOTAL 점수, C.GRADE 학점  
FROM T_STUDENT S, T_EXAM01 E, T_CREDIT C
WHERE S.STUDNO = E.STUDNO AND 
	E.TOTAL BETWEEN C.MIN_POINT AND C.MAX_POINT 
ORDER BY C.GRADE ASC;
--ANCI
SELECT S.NAME 학생이름, E.TOTAL 점수, C.GRADE 학점  
FROM T_STUDENT S 
	JOIN T_EXAM01 E ON S.STUDNO = E.STUDNO
	JOIN T_CREDIT C
	ON E.TOTAL BETWEEN C.MIN_POINT AND C.MAX_POINT 
ORDER BY C.GRADE ASC;

--#6204
SELECT * FROM T_CUSTOMER ;
SELECT * FROM T_GIFT;
--ORACLE
SELECT C.C_NAME 고객명, C.C_POINT POINT, G.G_NAME 상품명
FROM T_CUSTOMER C, T_GIFT G
WHERE C.C_POINT >= G.G_START AND G.G_NAME ='산악용자전거';
--ANCI
SELECT C.C_NAME 고객명, C.C_POINT POINT, G.G_NAME 상품명
FROM T_CUSTOMER C JOIN T_GIFT G ON C.C_POINT >= G.G_START
WHERE G.G_NAME ='산악용자전거';

--#6205
SELECT * FROM T_EMP2 ;
SELECT * FROM T_POST ;
--ORACLE
SELECT E.NAME 이름, (TO_CHAR(SYSDATE,'YYYY') - TO_CHAR(E.BIRTHDAY,'YYYY'))+1 현재나이,
	NVL(E.POST, ' ') 현재직급, P.POST 예상직급
FROM T_EMP2 E, T_POST P
WHERE (TO_CHAR(SYSDATE,'YYYY') - TO_CHAR(E.BIRTHDAY,'YYYY'))+1 BETWEEN P.S_AGE AND P.E_AGE;
--ANCI
SELECT E.NAME 이름, (TO_CHAR(SYSDATE,'YYYY') - TO_CHAR(E.BIRTHDAY,'YYYY'))+1 현재나이,
	NVL(E.POST, ' ') 현재직급, P.POST 예상직급
FROM T_EMP2 E JOIN T_POST P 
	ON (TO_CHAR(SYSDATE,'YYYY') - TO_CHAR(E.BIRTHDAY,'YYYY'))+1 BETWEEN P.S_AGE AND P.E_AGE;

-- #6206)
--t_student 테이블과 t_professor 테이블 Join : 
--학생이름과 지도교수 이름을 출력하세요. 
--단! 지도교수가 결정되지 않은 학생의 명단도 함께 출력하세요

--** 기존의 INNER Join 방식으로 먼저 만들어 보고 OUTER Join 을 해보고 비교해보자

SELECT s.name "학생이름", p.name "교수이름"
FROM t_student s LEFT OUTER JOIN t_professor p
	ON s.profno = p.PROFNO
;

-- #6207
SELECT s.name "학생이름", p.name "교수이름"
FROM t_student s RIGHT OUTER JOIN t_professor p
	ON s.profno = p.PROFNO
;

-- #6208
SELECT s.name "학생이름", p.name "교수이름"
FROM t_student s FULL OUTER JOIN t_professor p
	ON s.profno = p.PROFNO
;


------------------------------------------------
-- self join

-- #6209) 
-- t_dept2 테이블에서 
-- 부서명 과 그 부서의 상위부서명을 출력하세요
SELECT * FROM T_DEPT2 ;
SELECT d1.dname "부서명", d2.dname "상위부서명"
FROM t_dept2 d1, t_dept2 d2
WHERE d1.pdept = d2.dcode;

-- ANSI
SELECT d1.dname "부서명", d2.dname "상위부서명"
FROM t_dept2 d1 JOIN t_dept2 d2
	ON d1.pdept = d2.dcode;

--#6210
SELECT * FROM T_PROFESSOR;
SELECT P1.PROFNO 교수번호, P1.NAME 교수명, P1.HIREDATE 입사일, 
	COUNT(P2.HIREDATE) 빠른사람 
FROM T_PROFESSOR P1 LEFT OUTER JOIN T_PROFESSOR P2
	ON P2.HIREDATE < P1.HIREDATE 
GROUP BY P1.PROFNO , P1.NAME, P1.HIREDATE 
ORDER BY 4; -- 4번째 컬럼을 기준으로 오름차순 














