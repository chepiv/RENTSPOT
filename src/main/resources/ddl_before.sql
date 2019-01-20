CREATE TABLE LANDLORD (
  LANDLORD_ID     INT(10) NOT NULL auto_increment,
  USERID INT(10) NOT NULL,
  PRIMARY KEY (LANDLORD_ID)
);
CREATE TABLE OFFER (
  OFFER_ID         INT(10) NOT NULL auto_increment,
  RENTERID   INT(10) NOT NULL,
  LANDLORDID INT(10),
  MARKED     INT(1),
  `DATE`     DATE,
  PHOTO      BLOB,
  PRIMARY KEY (OFFER_ID)
);
CREATE TABLE PARAMETER (
  PARAM_ID    INT(10) NOT NULL auto_increment,
  NAME  VARCHAR(120),
  VALUE VARCHAR(120),
  PRIMARY KEY (PARAM_ID)
);
CREATE TABLE PARAMETER_OFFER (
  PARAMETERID INT(10) NOT NULL,
  OFFERID     INT(10) NOT NULL,
  PRIMARY KEY (PARAMETERID, OFFERID)
);
CREATE TABLE RENTER (
  RENTER_ID     INT(10) NOT NULL auto_increment,
  USERID INT(10) NOT NULL,
  PRIMARY KEY (RENTER_ID)
);
CREATE TABLE `USER` (
  USER_ID       INT(10)     NOT NULL auto_increment,
  NAME     VARCHAR(50),
  SURNAME  VARCHAR(50),
  EMAIL    VARCHAR(250),
  PHONE    VARCHAR(20) NOT NULL,
  PASSWORD VARCHAR(250),
  PRIMARY KEY (USER_ID)
);
ALTER TABLE LANDLORD
  ADD CONSTRAINT fklandlord FOREIGN KEY (USERID) REFERENCES `USER` (USER_ID);
ALTER TABLE RENTER
  ADD CONSTRAINT fkrenter FOREIGN KEY (USERID) REFERENCES `USER` (USER_ID);
ALTER TABLE PARAMETER_OFFER
  ADD CONSTRAINT fkparameter FOREIGN KEY (PARAMETERID) REFERENCES PARAMETER (PARAM_ID);
ALTER TABLE OFFER
  ADD CONSTRAINT fkoffer FOREIGN KEY (LANDLORDID) REFERENCES LANDLORD (LANDLORD_ID);
ALTER TABLE OFFER
  ADD CONSTRAINT fkoffer_renter FOREIGN KEY (RENTERID) REFERENCES RENTER (RENTER_ID);
ALTER TABLE PARAMETER_OFFER
  ADD CONSTRAINT fkparameter_offer FOREIGN KEY (OFFERID) REFERENCES OFFER (OFFER_ID);