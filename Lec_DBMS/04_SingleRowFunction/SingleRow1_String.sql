-- INITCAP() 함수

-- #4101 (ppt)
SELECT INITCAP('pretty girl') 
FROM DUAL; 

-- #4102
SELECT ID, INITCAP(ID) 
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

-- LOWER(), UPPER()
-- #4103
SELECT NAME , ID , UPPER(ID) 대문자, LOWER(ID) 소문자
FROM T_STUDENT 
WHERE DEPTNO1  = 201;

-- LENGTH / lengthB
-- #4104
SELECT name, id, LENGTH(id) 글자수
FROM T_STUDENT 
WHERE LENGTH(id) > 8;

--#4105
SELECT name 이름 ,length(NAME) 길이, LENGTHB(NAME) 바이트  
FROM T_STUDENT WHERE DEPTNO1 = 201;


-- concat()
-- #4106
SELECT CONCAT(name, POSITION) 교수님명단 
FROM T_PROFESSOR 
WHERE DEPTNO = 101;

SELECT * FROM T_PROFESSOR ;

-- SUBSTR() 
SELECT SUBSTR('ABCD', 2, 3)
FROM DUAL ;

SELECT SUBSTR('ABCDE', 20 , 3) -- null 에러 아님! 
FROM DUAL ;

SELECT * FROM T_STUDENT ;

--예제 #4107
SELECT NAME , SUBSTR(jumin, 1,6) 생년월일
FROM T_STUDENT
WHERE DEPTNO1 = 101;

--예제 #4108
SELECT NAME , SUBSTR(JUMIN,1,6) 생년월일 
FROM T_STUDENT 
WHERE SUBSTR(JUMIN , 3,2) = '08';

--예제 #4109
SELECT NAME , JUMIN 
FROM T_STUDENT 
WHERE SUBSTR(JUMIN , 7,1) ='2' AND GRADE = 4; 


-- INSTR()함수
SELECT INSTR('A*B*C*', '*', 1, 1) FROM DUAL ; --2
SELECT INSTR('A*B*C*', '*', 1, 2) FROM DUAL ; --4
SELECT INSTR('A*B*C*', '*', 3, 2) FROM DUAL ; --6
--Oracle은 음수 인덱스를 지원한다. 음수 인덱스는 검색도 음수의 방향으로 검색된다. 
SELECT INSTR('A*B*C*', '*', -4, 1) FROM DUAL ; --2
SELECT INSTR('A*B*C*', '*', -4, 2) FROM DUAL ; -- 0 없으면 0 리턴 
SELECT INSTR('A*B*C*', '*', -2, 2) FROM DUAL ; -- 2

--#4110
SELECT NAME,TEL, INSTR(tel, ')') AS 위치 
-- 1,1 첫번째 오는 첫번째 값은 default값으로 지정되어있어 따로 기입하지 않아도 된다.  
FROM T_STUDENT WHERE DEPTNO1 = 101;

--#4111
SELECT NAME , TEL , SUBSTR(tel, 1, INSTR(TEL , ')')-1 ) AS 지역번호 
FROM T_STUDENT WHERE DEPTNO1 = 101;

SELECT NAME , TEL ,SUBSTR(TEL ,1, INSTR(TEL , ')')-1) 지역번호 
FROM T_STUDENT WHERE DEPTNO1 = 101;

--LTRIM(), RTRIM(), TRIM()
SELECT 
	LTRIM('슈퍼슈퍼슈가맨', '슈퍼')LTRIM, 
	LTRIM('슈퍼슈퍼슈가맨', '슈')LTRIM, 
	LTRIM('  슈퍼슈가맨', ' ')LTRIM
FROM DUAL ;

--#4117
SELECT * FROM T_DEPT2 ;

SELECT RTRIM(DNAME , '부')  
FROM T_DEPT2 ;

--REPLACE 함수
SELECT REPLACE ('수퍼맨 수퍼걸','수퍼','파워') REPLACE예제
FROM dual;

--#4118
SELECT NAME, REPLACE (name , SUBSTR(name, 1, 1) , '#') 학생
FROM T_STUDENT WHERE DEPTNO1  = 102;

--#4119
SELECT NAME, REPLACE (name, substr(name, 2,1), '#') 학생
FROM T_STUDENT WHERE DEPTNO1 = 101;

SELECT * FROM T_STUDENT WHERE DEPTNO1  = 101;

--#4120
SELECT NAME , substr(JUMIN , 6, 7) 주민번호
FROM T_STUDENT WHERE DEPTNO1 =101;

SELECT NAME , REPLACE (JUMIN , substr(JUMIN , 7, 7), '*******') 주민번호
FROM T_STUDENT WHERE DEPTNO1 =101;

--#4121
SELECT name, tel , REPLACE (tel, SUBSTR(tel, INSTR(tel, ')')+1, 3), '###') 전화번호 
FROM T_STUDENT WHERE DEPTNO1 = 102;















