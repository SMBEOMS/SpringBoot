CREATE SEQUENCE SEQ_BOARD;

CREATE TABLE TBL_BOARD(
	BOARD_ID NUMBER CONSTRAINT PK_BOARD PRIMARY KEY,
	BOARD_TITLE VARCHAR(500) NOT NULL,
	BOARD_WRITER VARCHAR(500) NOT NULL,
	BOARD_CONTENT VARCHAR(1000) NOT NULL,
	BOARD_REGISTER_DATE DATE DEFAULT SYSDATE,
	BOARD_UPDATE_DATE DATE DEFAULT SYSDATE
);

INSERT INTO TBL_BOARD
(BOARD_ID, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT)
VALUES(SEQ_BOARD.NEXTVAL, '테스트 제목1', '테스트1', '테스트 내용1');

INSERT INTO TBL_BOARD
(BOARD_ID, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT)
VALUES(SEQ_BOARD.NEXTVAL, '테스트 제목2', '테스트2', '테스트 내용2');

INSERT INTO TBL_BOARD
(BOARD_ID, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT)
VALUES(SEQ_BOARD.NEXTVAL, '테스트 제목3', '테스트3', '테스트 내용3');

INSERT INTO TBL_BOARD
(BOARD_ID, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT)
VALUES(SEQ_BOARD.NEXTVAL, '한동석 Spring Boot 강의', '한동석', '하하호호 재밌어.');

INSERT INTO TBL_BOARD
(BOARD_ID, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT)
(SELECT SEQ_BOARD.NEXTVAL, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT FROM TBL_BOARD);

SELECT COUNT(*) FROM TBL_BOARD;

SELECT * FROM
(
	SELECT ROWNUM R, B.* FROM
	(
		SELECT * FROM TBL_BOARD
		ORDER BY BOARD_ID DESC
	) B
	WHERE ROWNUM <= 30
)
WHERE R > 20;

SELECT COUNT(BOARD_ID) FROM TBL_BOARD
WHERE BOARD_CONTENT LIKE '%내용1%';

SELECT BOARD_ID FROM TBL_BOARD
ORDER BY 1 DESC;


