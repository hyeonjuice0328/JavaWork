

-- OR REPLACE 기존에 있다면 삭제 후 생성해주세요 라는 의미 
CREATE OR REPLACE VIEW v_prof 
AS 
SELECT PROFNO, NAME, EMAIL, HPAGE
FROM T_PROFESSOR 
; -- DDL 명령어 이기 때문에 실행했을 때 아무런 반응은 나오지 않는다. 

SELECT * FROM v_prof;

SELECT TNAME FROM TAB; 
--SCOTT 계정이 가지고 있는 테이블명 
-- 테이블 목록에 방금 생성한 v_prof 확인가능.

--VIEW 생성 시 별도의 컬럼 이름을 지정해 줄 수 있다. 
CREATE OR REPLACE VIEW v_prof(PFNO, NM, EM, HP) 
AS 
SELECT PROFNO, NAME, EMAIL, HPAGE
FROM T_PROFESSOR 
;

--#8102
SELECT * FROM T_PROFESSOR ;
SELECT * FROM T_DEPARTMENT ;

CREATE OR REPLACE VIEW v_prof_dept
AS
SELECT PROFNO 교수번호 , P.NAME 교수명, D.DNAME 소속학과명
FROM T_PROFESSOR P, T_DEPARTMENT D
WHERE P.DEPTNO = D.DEPTNO ;

SELECT * FROM v_prof_dept;

--#8103
SELECT * FROM T_STUDENT ;
SELECT * FROM T_DEPARTMENT ;
SELECT DEPTNO1, MAX(HEIGHT), max(WEIGHT) FROM T_STUDENT GROUP BY DEPTNO1 ;


SELECT d.DNAME "학과명", s.max_height "최대키", s.max_weight "최대몸무게"
FROM (SELECT DEPTNO1, MAX(HEIGHT) max_height , max(WEIGHT) max_weight FROM T_STUDENT GROUP BY DEPTNO1) s, 
	t_department d
WHERE s.deptno1 = d.DEPTNO ;

--#8104
SELECT * FROM T_STUDENT ;
SELECT * FROM T_DEPARTMENT ;

SELECT  DEPTNO1 ,MAX(HEIGHT) max_height 
	FROM T_STUDENT GROUP BY DEPTNO1 ;

SELECT d.DNAME "학과명", a.max_height "최대키", 
	s.NAME "학생이름" , s.HEIGHT "키" 
FROM 
	(SELECT DEPTNO1 ,MAX(HEIGHT) max_height FROM 
	T_STUDENT GROUP BY DEPTNO1) a,T_STUDENT s,t_department d
WHERE s.deptno1 = a.deptno1 
	AND a.max_height = s.HEIGHT 
	AND s.DEPTNO1  = d.DEPTNO ;


--#8105
--학년 별 평균 키 
SELECT grade, AVG(height) FROM T_STUDENT GROUP BY GRADE; 
SELECT s.GRADE 학년, s.NAME 이름, s.HEIGHT 키, a.avg_height 평균키
FROM (SELECT grade, AVG(height) avg_height FROM T_STUDENT GROUP BY GRADE) a, 
	t_student s
WHERE a.grade = s.GRADE AND s.HEIGHT > a.avg_height 
ORDER BY 1;


























