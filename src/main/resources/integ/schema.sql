SET MODE ORACLE;
CREATE SCHEMA IF NOT EXISTS INTEG;
set schema integ;

drop TABLE if exists integ.INTEG_PERSON;
CREATE TABLE INTEG_PERSON (
    id  INTEGER  GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1) PRIMARY KEY
    , firstname VARCHAR(30)
    , lastname VARCHAR(30)
    , email VARCHAR(40)
    , phone1 VARCHAR(15)
    , phone2 VARCHAR(15)
    , address_id NUMERIC(10)
    , ts_create TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
    , ts_update TIMESTAMP  DEFAULT CURRENT_TIMESTAMP -- ON UPDATE CURRENT_TIMESTAMP
);


drop table if exists integ.INTEG_ADDRESS;
CREATE TABLE INTEG_ADDRESS (
    id  INTEGER  GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1) PRIMARY KEY
    , streetnum VARCHAR(10)
    , streetname VARCHAR(30)
    , city VARCHAR(20)
    , country VARCHAR(20)
    , postalcode VARCHAR(10)
    , lat DECIMAL(8,6)
    , lon DECIMAL(9,6)
    , ts_create TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
    , ts_update TIMESTAMP  DEFAULT CURRENT_TIMESTAMP -- ON UPDATE CURRENT_TIMESTAMP
);

drop table if exists integ.INTEG_XREF_PERSON;
CREATE TABLE INTEG_XREF_PERSON ( -- contact_channels.postalAddress
    --  put uniq constraint {id_person, xref_sysid} if one person can have only one account.
     id NUMBER(5)  NOT NULL
    , xref_sys_id VARCHAR(10) NOT NULL
    , xref_person_id VARCHAR(5)
    , xref_status VARCHAR(10)
    , ts_create TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
    , ts_update TIMESTAMP  DEFAULT CURRENT_TIMESTAMP -- ON UPDATE CURRENT_TIMESTAMP -- ON UPDATE won't work for postgres https://stackoverflow.com/questions/9556474/how-do-i-automatically-update-a-timestamp-in-postgresql/9556527
    , ts_refreshed TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    ,PRIMARY KEY (id,xref_sys_id)
)
;


insert into INTEG_ADDRESS (id, streetnum, streetname, city, country, postalcode) values
 ( 0,'1001', 'Anon St', 'My City', 'Canada', '000 000')
,( 1,'1001', 'My Street', 'My City', 'Canada', 'L1L0Z0')
,( 2,'2002', 'My Street', 'My City', 'Canada', 'L1L0Z0')
,( 3,'3003', 'My Street', 'My City', 'Canada', 'L1L0Z0')
,( 6,'1', 'North Pole St', 'Antarctica', 'Canada', 'OoO0Z0')
;


insert into INTEG_PERSON (id, firstname, lastname, email, phone1, phone2, address_id) values
 (1, 'Miki', 'Mouse', 'miki.mouse@gmail.com', '1111111111', '999999999',1)
,(2, 'Rat', 'Atouee', 'ratatouee@gmail.com', '2222222222', '999999999',2)
,(3, 'Richard', 'Seter', 'my.richy@gmail.com', '3333333333', '999999999',3)
,(4, 'Cyber', 'Johney', 'cyber.pcc@anon.oc', null, null, null)
,(0, 'Anamica', 'Caller', null, '55555555', null, null)
,(6, 'Stonage', 'Frostboy', null, null, null, 6)
;

insert into INTEG_XREF_PERSON (id, xref_sys_id, xref_person_id) values
( 1,'AMANDA', null)
,( 1,'HANSEN', null)
,( 2,'AMANDA', null)
,( 3,'HANSEN', null)
;
commit;



drop TABLE if exists INTEG_CASE;
CREATE TABLE INTEG_CASE (
    id  INTEGER  GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1) PRIMARY KEY
    , status VARCHAR(30) -- TRIAGE / PENDING/ DONE
    , type_id VARCHAR(30)
    , reportedby_person_id INTEGER -- to PERSON.id
    , createdby_emp_id VARCHAR(10) -- employee userid
    , address_id INTEGER -- address id, must be within markham jurisdiction.
    , description VARCHAR(200) not null
    , ts_create TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
    , ts_update TIMESTAMP  DEFAULT CURRENT_TIMESTAMP -- ON UPDATE CURRENT_TIMESTAMP
);

-- AI_TRIAGE, AWAIT_TRIAGE, PENDING_INTERNAL, PENDING_EXTERNAL, TASKS_DONE, CLOSED, REOPENED
insert into INTEG_CASE (id, status, type_id,reportedby_person_id,createdby_emp_id,address_id,description) values
( 1,'AWAIT_TRIAGE', 'WATER_PIPE', 1, 'rose', 1,'Water pipe leak, inside house')
,( 2,'AWAIT_TRIAGE', 'COMPLAINT', 1, 'rose', 0,'Neigbor just lookin at me')
,( 3,'AWAIT_TRIAGE', 'TREE', 1, 'rose', 1,'Tree in intersection xstree/ystreet blocking pedestrian walk')
,( 4,'AWAIT_TRIAGE', 'INFO', 0, 'rose', 0,'Habibi, I forgot my name .. what is it?')
;

drop table if exists integ.INTEG_CASE_PROPS_LOOKUP;
create table INTEG_CASE_PROPS_LOOKUP (
    type_id varchar(100) -- a fixed list
    , version varchar(5) not null -- 1 api version
    , propname varchar(100) not null
    , propdatatype varchar(10)  -- default "string"
    , propdesc varchar(100)
    ,PRIMARY KEY (type_id,version,propname)
);

drop table if exists integ.INTEG_CASE_PROPS_VAL;
create table INTEG_CASE_PROPS_VAL (
    case_id varchar(100) -- a fixed list
    , propname varchar(100) not null
    , propvalue varchar(10)

    ,PRIMARY KEY (case_id,propname,propvalue)
    -- , FOREIGN KEY (case_id, , points to case.id)
    --, FOREIGN KEY (propname), points to
);