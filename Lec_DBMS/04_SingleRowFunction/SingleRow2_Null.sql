SELECT
	*
FROM
	T_PROFESSOR ;
-- null 와 산술연산을 하면 결과는 무조건 null 이 나온다. 
 SELECT
	name,
	pay,
	bonus,
	pay + BONUS
FROM
	T_PROFESSOR ;
-- 그룹 함수에서 null은 동작에서 제외된다. 
 SELECT
	SUM(pay),
	SUM(BONUS)
	FROM T_PROFESSOR ;
-- nvl(nullvalue)()함수 : null 값이 나오면 대신 이 값으로 바꾸어서 출력해주세요 라는 기능
 SELECT
	name,
	pay,
	bonus,
	pay + BONUS 총지급액,
	PAY + NVL(BONUS , 0) 총지급액
FROM
	T_PROFESSOR ;
--#4201
 SELECT
	name,
	pay,
	NVL(BONUS , 0) BONUS,
	pay*12 + NVL(BONUS, 0) 연봉
FROM
	T_PROFESSOR
WHERE
	DEPTNO = 101;
--#4202 nvl2( a , b, 0 ) : a가 null이면 b 아니면 0 으로 출력 
 SELECT
	name,
	pay,
	NVL2(BONUS , BONUS , 0) BONUS,
	NVL2(BONUS , pay*12 + BONUS , pay*12)연봉
FROM
	T_PROFESSOR
WHERE
	DEPTNO = 101;













