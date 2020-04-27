SELECT * FROM T_PROFESSOR ;
SELECT COUNT(*), COUNT(HPAGE) FROM T_PROFESSOR ;
-- 그룹함수 결과는 NULL 이 절대절대 나오지 않는다. 산술에서 제외될 뿐! 
SELECT COUNT(bonus), sum(bonus), avg(BONUS) FROM T_PROFESSOR ; 
SELECT MAX(hiredate), min(hiredate) FROM T_EMP ;

--NULL 허용 컬럼의 그룹함수 적용시 
--nvl, nvl2 사용해야 한다. 
SELECT AVG(bonus), avg(nvl(BONUS,0))
FROM T_PROFESSOR ;

-- select절에 그룹함수와 그룹함수가 아닌 것을 같이 사용 할 수 없다. 
--SELECT deptno, AVG(BONUS) 
--FROM T_PROFESSOR ;

SELECT deptno, ROUND(AVG(NVL(BONUS,0)),1) 보너스평균 
FROM T_PROFESSOR 
GROUP BY DEPTNO; -- 그룹함수가 아닌 것을 그룹함수로 만들어준다.

--#5101
SELECT DEPTNO , POSITION, AVG(PAY) 평균급여 
FROM T_PROFESSOR 
GROUP BY DEPTNO , POSITION
ORDER BY DEPTNO ASC, POSITION ASC 
;

SELECT DEPTNO , AVG(PAY) 평균급여 
FROM T_PROFESSOR 
--WHERE AVG(PAY) > 450 -- 그룹함수는 where 절에서 사용불가 
GROUP BY DEPTNO 
HAVING AVG(PAY) > 400
--HAVING : 그룹함수 결과에 대한 조건절
;

--<SELECT 쿼리문 순서> 
-- SELECT
-- FROM
-- WHERE
-- GOURP BY
-- HAVING
-- ORDER BY

--#5102
SELECT * FROM T_EMP ;

SELECT MGR 매니저, 
	COUNT(JOB) 직원수, 
	sum(sal) 급여총액, 
	TRUNC((avg(sal))) 급여평균,
	AVG(nvl(COMM,0)) 교통비평균 
FROM T_EMP 
WHERE job <> 'PRESIDENT'
GROUP BY MGR ;

--#5103
SELECT * FROM T_PROFESSOR ;

SELECT DEPTNO , 
	COUNT(DEPTNO) 총인원,
	ROUND(avg(SYSDATE-HIREDATE),1) 근속평균,
	AVG(pay) 급여평균, AVG(nvl(BONUS,0)) 보너스평균 
FROM T_PROFESSOR
WHERE POSITION LIKE '%교수' 
GROUP BY DEPTNO   
;

--#5104
SELECT * FROM T_STUDENT ;

SELECT DEPTNO1 학과, 
	max(WEIGHT) - min(WEIGHT) 최대최소몸무게차
FROM T_STUDENT
GROUP BY DEPTNO1;

--#5015
SELECT DEPTNO1 학과, 
	max(WEIGHT) - min(WEIGHT) 최대최소몸무게차
FROM T_STUDENT
GROUP BY DEPTNO1
HAVING max(WEIGHT) - min(WEIGHT) >=30;












