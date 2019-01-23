CREATE TABLE Landlord (
  UserID int(10) NOT NULL,
  PRIMARY KEY (UserID));
CREATE TABLE Offer (
  ID             int(10) NOT NULL AUTO_INCREMENT,
  Header         varchar(80),
  Description    varchar(255),
  Marked         int(1) NOT NULL,
  `Date`         date NOT NULL,
  Photo          blob,
  RenterUserID   int(10),
  LandlordUserID int(10) NOT NULL,
  PRIMARY KEY (ID));
CREATE TABLE Parameter (
  ID    int(10) NOT NULL AUTO_INCREMENT,
  Name  varchar(120) NOT NULL,
  Value varchar(120),
  PRIMARY KEY (ID));
CREATE TABLE Parameter_Offer (
  ParameterID int(10) NOT NULL,
  OfferID     int(10) NOT NULL,
  PRIMARY KEY (ParameterID,
  OfferID));
CREATE TABLE Renter (
  UserID int(10) NOT NULL,
  PRIMARY KEY (UserID));
CREATE TABLE `User` (
  ID       int(10) NOT NULL AUTO_INCREMENT,
  Name     varchar(50) NOT NULL,
  Surname  varchar(50) NOT NULL,
  Email    varchar(250) NOT NULL,
  Phone    varchar(20),
  Password varchar(250) NOT NULL,
  PRIMARY KEY (ID));
ALTER TABLE Landlord ADD CONSTRAINT FKLandlord482413 FOREIGN KEY (UserID) REFERENCES `User` (ID);
ALTER TABLE Renter ADD CONSTRAINT FKRenter742984 FOREIGN KEY (UserID) REFERENCES `User` (ID);
ALTER TABLE Parameter_Offer ADD CONSTRAINT FKParameter_550159 FOREIGN KEY (ParameterID) REFERENCES Parameter (ID);
ALTER TABLE Offer ADD CONSTRAINT FKOffer750363 FOREIGN KEY (LandlordUserID) REFERENCES Landlord (UserID);
ALTER TABLE Offer ADD CONSTRAINT FKOffer165623 FOREIGN KEY (RenterUserID) REFERENCES Renter (UserID);
ALTER TABLE Parameter_Offer ADD CONSTRAINT FKParameter_888909 FOREIGN KEY (OfferID) REFERENCES Offer (ID);
