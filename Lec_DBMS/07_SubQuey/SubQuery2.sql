--================다중칼럼========================
--#7201
SELECT GRADE , MAX(HEIGHT) 
FROM T_STUDENT 
group BY GRADE ; --컬럼이 2개

SELECT GRADE 학년, NAME 이름, HEIGHT 키
FROM T_STUDENT 
WHERE(GRADE,HEIGHT) IN (SELECT GRADE , MAX(HEIGHT) 
	FROM T_STUDENT group BY GRADE)
ORDER BY 학년 ASC;
--order by 에서 유일하게 select 의 별칭을 사용할 수 있다. 
--왜냐하면 select 절이 수행 되고 order by 가 수행되기 때문이다. 

--#7202
SELECT * FROM T_PROFESSOR ;
SELECT * FROM T_DEPARTMENT;
SELECT DEPTNO , min(HIREDATE)
FROM T_PROFESSOR GROUP BY DEPTNO ;

SELECT p.PROFNO 교수번호, p.NAME 교수명, TO_CHAR(p.HIREDATE, 'YYYY-MM-DD')입사일, d.DNAME 학과명
FROM T_PROFESSOR p, T_DEPARTMENT d
WHERE (p.DEPTNO , p.HIREDATE) IN (SELECT DEPTNO , min(HIREDATE)FROM T_PROFESSOR GROUP BY DEPTNO) 
	AND p.DEPTNO = d.DEPTNO
ORDER BY "학과명" ASC ;

--#7203
SELECT * FROM T_EMP2 ;
SELECT POST , MAX(PAY) FROM T_EMP2 GROUP BY POST ;

SELECT NAME 사원명, POST 직급, PAY 연봉
FROM T_EMP2
WHERE (POST , PAY) IN (SELECT POST , MAX(PAY) FROM T_EMP2 GROUP BY POST)
ORDER BY pay;

--#7204
SELECT * FROM T_EMP2 ;
SELECT * FROM T_DEPT2 ;
--부서별 평균 연봉???? 
SELECT avg(PAY)FROM T_EMP2 GROUP BY DEPTNO ; 

SELECT d.DNAME 부서명, e.NAME 직원명, e.PAY 연봉
FROM T_EMP2 e, T_DEPT2 d
WHERE e.DEPTNO = d.DCODE AND 
	e.PAY <ALL (SELECT avg(PAY)FROM T_EMP2 GROUP BY DEPTNO)
ORDER BY e.NAME ;

--=====================상호연관 서브쿼리==================================
--#7205)t_emp2 테이블 :직원들 중에서 자신의 직급의 평균연봉과 같거나 많이 받는 사람들의 이름과 직급, 현재 연봉을 출력하세요.

--일단 자신이 직급을 구해야 한다.
--그 것을 Sub Query 에 전달해 주어야 한다
--Sub Query는 받은뒤 수행하여 결과를 다시 Main Query에 전달해야 한다
--post 는 null을 허용하는 
SELECT a.NAME 사원이름, nvl(a.POST, ' ')직급 , a.PAY 연봉
FROM t_emp2 a
--WHERE a.PAY >= (a.POST직급의 평균연봉);
WHERE a.PAY >= (SELECT AVG(b.PAY) FROM T_EMP2 b WHERE nvl(a.POST, ' ')=nvl(b.POST,' '));
--특정 직급의 평균 연봉 - 서브쿼리로 사용?
SELECT AVG(b.PAY) FROM T_EMP2 b WHERE '과장'=b.POST ; --과장직급의 평균 연봉 


--스칼라서브쿼리
--#7206) t_emp2, t_dept2 테이블: 조회하여 사원들의 이름과 부서 이름을 출력
SELECT NAME 사원이름,
	(SELECT d.DNAME FROM T_DEPT2 d WHERE e.DEPTNO = d.DCODE)부서이름
FROM T_EMP2 e;

















