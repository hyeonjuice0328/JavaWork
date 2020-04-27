
-- 묵시적 자동 형변환 '1'문자 타입이 1 숫자 타입으로 변환
SELECT 1 + 1
FROM dual;

SELECT '1' + 1
FROM dual;
-- 실제로 하는 동작 과정 
SELECT TO_NUMBER('1') + 1
FROM DUAL;
--TO_CHAR 함수(날짜>문자)
 SELECT
	SYSDATE,
	TO_CHAR(SYSDATE, 'YYYY') 연도4자리,
	TO_CHAR(SYSDATE, 'RRRR') 연도Y2K버그이후,
	TO_CHAR(SYSDATE, 'YY') 연도2자리,
	TO_CHAR(SYSDATE, 'YEAR') 연도영문
FROM
	DUAL;

SELECT
	SYSDATE,
	TO_CHAR(SYSDATE, 'DD') DAY숫자2자리,
	TO_CHAR(SYSDATE, 'DDTH') 몇번째날,
	TO_CHAR(SYSDATE, 'DAY') 요일,
	TO_CHAR(SYSDATE, 'Dy') 요일앞자리
FROM
	dual;

SELECT
	TO_CHAR(SYSDATE, 'MON') 월3자리,
	-- 7월
 TO_CHAR(SYSDATE, 'MONTH') 월전체,
	-- 7월
 TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE=ENGLISH') 월영문3자리,
	-- JUL
 TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE=ENGLISH') "월영문전체(대)",
	-- JULY
 TO_CHAR(SYSDATE, 'month', 'NLS_DATE_LANGUAGE=ENGLISH') "월영문전체(소)",
	-- july
 TO_CHAR(SYSDATE, 'Month', 'NLS_DATE_LANGUAGE=ENGLISH') "월영문전체(첫글자대)"
	-- July

	FROM DUAL;

SELECT
	TO_CHAR(SYSDATE, 'HH24') 시24hr,
	TO_CHAR(SYSDATE, 'HH') 시12hr,
	TO_CHAR(SYSDATE, 'MI') 분,
	TO_CHAR(SYSDATE, 'SS') 초,
	TO_CHAR(SYSDATE, 'HH:MI:SS') 시분초
FROM
	dual;
-- #4301
 SELECT
	TO_CHAR(SYSDATE, 'YYYY-MM-DD') 날짜,
	SYSDATE 날짜
FROM
	DUAL;

SELECT
	*
FROM
	t_student;
-- #4302
 SELECT
	NAME ,
	BIRTHDAY 생일
FROM
	T_STUDENT
WHERE
	TO_CHAR(BIRTHDAY, 'MM') = 3;
-- TO_CHAR : 대소문자 지정예
 SELECT
	SYSDATE,
	TO_CHAR(SYSDATE, 'Dy Month DD, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A1,
	TO_CHAR(SYSDATE, 'dy month dd, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A2,
	TO_CHAR(SYSDATE, 'DY MONTH DD, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A3
FROM
	DUAL;
--#########################################################################

--숫자에서 문자로 변환하는 함수 TO_CHAR
 SELECT
	1234,
	TO_CHAR(1234, '99999') "9하나당1자리",
	-- 5자리에 맞추어 출력 
 TO_CHAR(1234, '099999') 빈자리0으로,
	-- 6자리에 맞추어 출력 + 빈자리는 0으로 채워진다.
 TO_CHAR(1234, '$99999') 빈자리$로,
	TO_CHAR(1234.1263, '9999.99') 소수점이하2자리,
	TO_CHAR(123456789, '999,999,999') 천단위구분기호
FROM
	DUAL;
--#4303
 SELECT
	NAME ,
	TO_CHAR(PAY*12 + NVL(BONUS, 0), '9,999') 연봉
FROM
	T_PROFESSOR
WHERE
	DEPTNO = 101;
--#########################################################################

-- TO_NUMBER() 함수 - 숫자로 변환
 SELECT
	TO_NUMBER('123.44')
FROM
	dual;
--#########################################################################

-- TO_DATE() 함수 - 문자가 날짜로 변환
 SELECT
	TO_DATE('2020-04-08', 'YYYY-MM-DD') TO_DATE
FROM
	dual;
--#4304
 SELECT
	*
FROM
	T_PROFESSOR ;

SELECT
	name,
	TO_CHAR(HIREDATE, 'YYYY-MM-DD') 입사일,
	TO_CHAR(pay*12, '99,999') 연봉,
	TO_CHAR((pay*12)* 1.1 , '999,999') 인상후
FROM
	T_PROFESSOR
WHERE
	TO_CHAR(HIREDATE, 'YYYY') < '2000' ;









