-- dual 은 Row(행) 1개짜리 dummy TABLE; sql계의 println
SELECT 'abcd' FROM DUAL;
SELECT '안녕하세요' FROM DUAL;
SELECT 100 FROM dual;
SELECT 100 + 10 FROM dual;

-- * : '모든 컬럼'
SELECT * FROM T_EMP ;

-- 원하는 컬럼만 조회
SELECT EMPNO , ENAME 
FROM T_EMP;

SELECT * FROM T_PROFESSOR ;

SELECT NAME 
FROM T_PROFESSOR;

SELECT bonus FROM T_PROFESSOR ;

SELECT '안녕하세요'FROM T_PROFESSOR ;

SELECT name, '교수님 안녕하세요' FROM T_PROFESSOR ;

-- 컬럼 별명(alias) 사용한 출력
SELECT STUDNO 학번, NAME 이름 
FROM T_STUDENT;

SELECT studno"학번 학생", NAME AS 이름
FROM T_STUDENT ;

SELECT EMPNO 사원번호, ENAME"사원명", JOB AS 별명
FROM T_EMP ;

SELECT DEPTNO "부서#", DNAME 부서명, LOC AS 위치
FROM T_DEPT ;

-- DISTINCT 중복값 제거 후 출력
SELECT * FROM T_EMP ;
SELECT DISTINCT deptno FROM T_EMP ;

SELECT DISTINCT DEPTNO1 
FROM T_STUDENT ;

SELECT DISTINCT job FROM T_EMP ;

-- || : 필드, 문자열 연결 연산
SELECT name, POSITION 
	FROM T_PROFESSOR ;

SELECT name || '-' || POSITION AS 교수님명단
	FROM T_PROFESSOR ;

SELECT * FROM T_STUDENT ;

SELECT NAME ||'의 키는' || 
HEIGHT || 'cm, '||
'몸무게는 '|| WEIGHT || 
'kg 입니다' "학생의 키와 몸무게"
FROM T_STUDENT ;
