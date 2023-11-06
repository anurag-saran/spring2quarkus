DROP TABLE IF EXISTS AcmeBank;

CREATE TABLE AcmeBank (
    id integer not null primary key,
    name varchar(255),
    accountNo varchar(255)
);

INSERT INTO AcmeBank (id, name, accountNo) values(1, 'Jon Doe', '842001');
INSERT INTO AcmeBank (id, name, accountNo) values(2, 'david finch', '881145');
