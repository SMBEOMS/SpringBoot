CREATE TABLE TBL_PRODUCT(
	PRODUCT_ID NUMBER CONSTRAINT PK_PRODUCT PRIMARY KEY,
	PRODUCT_NAME VARCHAR2(500) NOT NULL,
	PRODUCT_STOCK NUMBER DEFAULT 0,
	PRODUCT_PRICE NUMBER DEFAULT 0,
	REGISTER_DATE DATE DEFAULT SYSDATE,
	UPDATE_DATE DATE DEFAULT SYSDATE
);


CREATE TABLE TBL_ORDER(
	ORDER_ID NUMBER CONSTRAINT PK_ORDER PRIMARY KEY,
	PRODUCT_ID NUMBER NOT NULL,
	PRODUCT_COUNT NUMBER DEFAULT 1,
	ORDER_DATE DATE DEFAULT SYSDATE,
	CONSTRAINT FK_ORDER_PRODUCT FOREIGN KEY(PRODUCT_ID)
	REFERENCES TBL_PRODUCT(PRODUCT_ID)
);

SELECT * FROM TBL_ORDER;