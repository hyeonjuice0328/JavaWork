-- 계층형 쿼리

SELECT * FROM T_DEPT2 ;

SELECT LPAD(DNAME, 10, '*') 부서명 FROM T_DEPT2 ;

--level
SELECT dname, LEVEL
FROM t_dept2
CONNECT BY PRIOR dcode = pdept
START WITH dcode = 0001
;
/* 해설
 * LEVEL 은 오라클에서 계속 사용할 수 있는 것으로
 * 해당 데이터가 몇번째 단계 이냐를 의미하는 것.
 * 
 * CONNECT BY PRIOR  :  각 row 들이 어떻게 연결되어야 하는지 조건 지정
 * PRIOR를 어느쪽에 주느냐가 중요!
 */

-- PRIOR 를 다른곳에 .. 위치시켜보기
SELECT dname, LEVEL
FROM t_dept2
CONNECT BY dcode = PRIOR pdept
START WITH dcode = 0001
;


SELECT dcode,dname,pdept, LEVEL
FROM t_dept2
CONNECT BY dcode = PRIOR pdept
--START WITH dcode = 1005  -- S/W지원(1) -> 기술부(2) -> 사장실(3)
START WITH dcode = 1011
;

SELECT LPAD(DNAME , LEVEL * 6, '*') 부서명 
FROM T_DEPT2 
CONNECT BY PRIOR DCODE = PDEPT 
START WITH dcode = 0001 ;

SELECT * FROM T_EMP2 ;

SELECT LPAD(e.NAME || ' ' || d.dname || ' ' || NVL(e.POST, '사원'), LEVEL*22, ' - ') "이름과 직급"
FROM T_EMP2 e , (SELECT dname, dcode, pdept FROM T_DEPT2) d
WHERE e.DEPTNO = d.dcode
CONNECT BY PRIOR e.EMPNO = e.PEMPNO 
START WITH e.EMPNO = 20000101
;

SELECT dname, dcode, pdept FROM T_DEPT2 ;


SELECT LEVEL - 1 HR
FROM DUAL 
CONNECT BY LEVEL <= 24
;






