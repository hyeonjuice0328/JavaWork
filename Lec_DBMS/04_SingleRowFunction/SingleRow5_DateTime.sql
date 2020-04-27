-- 날짜 함수
SELECT SYSDATE FROM dual;

--기본적인 날짜 연산
SELECT 
	SYSDATE 오늘,
	sysdate + 1 내일,
	sysdate -2 그저께,
	SYSDATE + 1/24 한시간뒤 
FROM DUAL;

-- 일자 차이 계산
SELECT 
	SYSDATE 오늘,
	TO_DATE('2020-03-16 09:00:00', 'YYYY-MM-DD hh:mi:ss') 시작한날,
	SYSDATE- TO_DATE('2020-03-16 09:00:00', 'YYYY-MM-DD hh:mi:ss') 경과 
FROM dual;

-- MONTH_BETWEEN : 날짜 사이의 개월수 
SELECT 
	MONTHS_BETWEEN('2012-03-01', '2012-01-01')"날짜 사이의 개월수 ",
	MONTHS_BETWEEN('2012-01-01','2012-03-01')
FROM DUAL;

--#4501
SELECT * FROM T_PROFESSOR ;

SELECT NAME 이름, 
	TO_CHAR(SYSDATE, 'YYYY-MM-DD') 오늘,
	TO_CHAR(HIREDATE, 'YYYY-MM-DD') 입사일,
	TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(HIREDATE,'YYYY') 근속연수,
	ROUND(MONTHS_BETWEEN(SYSDATE,HIREDATE),1) 근속개월, 
	TRUNC(TO_CHAR(SYSDATE - TO_DATE(HIREDATE,'YYYY-MM-DD')),2) 근속일
FROM T_PROFESSOR ;

--ADD_MONTH() 개월 추가 
SELECT SYSDATE, ADD_MONTHS(SYSDATE,3) "3개월추가" FROM dual;
SELECT 
	SYSDATE,
	LAST_DAY(SYSDATE) "이번달 마지막날",
	NEXT_DAY(SYSDATE, '목') "돌아오는 목요일" 
FROM dual;

-- 날짜의 ROUND() 함수  ,  하루의 반은 정오 12:00:00 이다. 이를 넘어서면 다음 날짜
-- 날짜의 TRUNC() 함수,  무조건 당일 출력.
-- 원서 접수나 상품 주문 등에서 오전까지 접수된 건은 당일 접수 처리. 오후접수는 익일 처리 등에서 사용.
SELECT 
	SYSDATE,
	ROUND(SYSDATE),
	trunc(SYSDATE)
FROM dual;


















