CREATE SEQUENCE SEQ_FILE;

CREATE TABLE TBL_FILE(
	FILE_ID NUMBER CONSTRAINT PK_FILE PRIMARY KEY,
	FILE_NAME VARCHAR2(1000) NOT NULL,
	FILE_UPLOAD_PATH VARCHAR2(1000) NOT NULL,
	FILE_UUID VARCHAR2(500) NOT NULL,
	FILE_SIZE VARCHAR2(1000) NOT NULL,
	FILE_IS_IMAGE CHAR(1),
	BOARD_ID NUMBER,
	CONSTRAINT FK_FILE_BOARD FOREIGN KEY(BOARD_ID)
	REFERENCES TBL_BOARD(BOARD_ID)
);
SELECT * FROM TBL_BOARD ORDER BY 1 DESC;
SELECT * FROM TBL_FILE;
SELECT FILE_ID, FILE_NAME, FILE_UPLOAD_PATH, FILE_UUID, FILE_SIZE, FILE_IS_IMAGE, BOARD_ID
FROM TBL_FILE WHERE FILE_UPLOAD_PATH = TO_CHAR(SYSDATE, 'YYYY/MM/DD');