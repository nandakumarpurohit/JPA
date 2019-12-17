CREATE TABLE CD (ID BIGINT NOT NULL, DESCRIPTION VARCHAR(3000), GENRE VARCHAR(255), TITLE VARCHAR(100), total_duration FLOAT, unit_cost FLOAT, PRIMARY KEY (ID))
CREATE TABLE MUSICIAN (ID BIGINT NOT NULL, BIO VARCHAR(5000), date_of_birth DATE, first_name VARCHAR(50), last_name VARCHAR(50), preferred_instrument VARCHAR(255), MUSICIANS_ID BIGINT, PRIMARY KEY (ID))
ALTER TABLE MUSICIAN ADD CONSTRAINT FK_MUSICIAN_MUSICIANS_ID FOREIGN KEY (MUSICIANS_ID) REFERENCES CD (ID)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
