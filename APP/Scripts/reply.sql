CREATE SEQUENCE SEQ_REPLY;

CREATE TABLE TBL_REPLY(
	REPLY_ID NUMBER CONSTRAINT PK_REPLY PRIMARY KEY,
	REPLY_CONTENT VARCHAR2(1000) NOT NULL,
	REPLY_WRITER VARCHAR2(1000) NOT NULL,
	REPLY_REGISTER_DATE DATE DEFAULT SYSDATE,
	REPLY_UPDATE_DATE DATE DEFAULT SYSDATE,
	BOARD_ID NUMBER,
	CONSTRAINT FK_REPLY_BOARD FOREIGN KEY(BOARD_ID)
	REFERENCES TBL_BOARD(BOARD_ID)
);

SELECT *
FROM
(
	SELECT ROWNUM R1, R.* FROM
	(
		SELECT * FROM TBL_REPLY
		WHERE BOARD_ID = 5202
		ORDER BY REPLY_ID DESC
	) R
);

INSERT INTO TBL_REPLY
(REPLY_ID, REPLY_CONTENT, REPLY_WRITER, BOARD_ID)
VALUES(SEQ_REPLY.NEXTVAL, '테스트 댓글 내용2', '테스터2', 5205);

INSERT INTO TBL_REPLY
(REPLY_ID, REPLY_CONTENT, REPLY_WRITER, BOARD_ID)
(SELECT SEQ_REPLY.NEXTVAL, REPLY_CONTENT, REPLY_WRITER, BOARD_ID FROM TBL_REPLY);