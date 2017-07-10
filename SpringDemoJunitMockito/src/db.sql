CREATE TABLE code (
  id integer NOT NULL NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  CODE_TYPE varchar(45) NOT NULL,
  VALUE varchar(45) NOT NULL,
  DESCB varchar(45) DEFAULT NULL,
  INACTIVE_IND varchar(45) DEFAULT 'N',
  PRIMARY KEY (id)
);
CREATE TABLE department 
(
  dept_id integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  dept_name varchar(100) NOT NULL,
  dept_email varchar(150),
  descb varchar(1000),
  statusId integer DEFAULT NULL,
  contact varchar(45),
  CONSTRAINT  status_fk  FOREIGN KEY ( statusId ) REFERENCES  code  ( id ),
  PRIMARY KEY (dept_id)
);



