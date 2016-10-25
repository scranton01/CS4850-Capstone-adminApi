CREATE TABLE GROUPS(
GROUP_ID NUMBER(9) NOT NULL,
USER_ID NUMBER(9),
DEVICE_ID NUMBER(9),
CHANNEL_ID NUMBER(9),
MESSAGE_ID NUMBER(9),
PRIMARY KEY (GROUP_ID),
FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID),
FOREIGN KEY (DEVICE_ID REFERENCES DEVICES(DEVICE_ID)),
FOREIGN KEY (CHANNEL_ID REFERENCES CHANNELS(CHANNEL_ID)),
FOREIGN KEY (MESSAGE_ID REFERENCES MESSAGES(MESSAGE_ID))
);

CREATE TABLE USERS(
USER_ID NUMBER(9) NOT NULL,
EMAIL VARCHAR(254) NOT NULL,
LOGIN_DETAIL VARCHAR,
USER_TYPE VARCHAR(10) NOT NULL,
PRIMARY KEY (USER_ID)
)

CREATE TABLE DEVICES(
DEVICE_ID NUMBER(9) NOT NULL,
NAME VARCHAR(20) NOT NULL,
USER_ID VARCHAR(9),
PRIMARY KEY (DEVICE_ID),
FOREIGN KEY (USER_ID REFERENCES USERS(USER_ID))
)

CREATE TABLE CHANNELS(
CHANNEL_ID NUMBER(9),
NAME VARCHAR(10),
TITLE VARCHAR(10),
TEXT VARCHAR(1000),
REFRESH_TIME NUMBER(12),
CHANNEL_TYPE VARCHAR(10),
PRIMARY KEY (CHANNEL_ID)
)

CREATE TABLE MESSAGES(
MESSAGE_ID NUMBER(9),
TEXT VARCHAR(1000),
PRIORITY NUMBER(9),
PRIMARY KEY (MESSAGE_ID)
)