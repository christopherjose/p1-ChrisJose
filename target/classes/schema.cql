CREATE KEYSPACE IF NOT EXISTS
p1 with REPLICATION = {'class': 'SimpleStrategy','replication_factor':'1'};

CREATE TABLE IF NOT EXISTS p1.customerAccount (
customer_id int PRIMARY KEY, --Or use UUID--
first_name text,
last_name text,
phone_no text,
email text,
address text,
address2 text,
city text,
state text,
zip text);

INSERT INTO p1.customerAccount
 (customer_id, first_name, last_name, phone_no, email, address,
 address2, city, state, zip) values
 (0, 'Bobby', 'Bilyeu','415-311-8021', 'bilyeubobby@sfstate.edu',
'812 Noriega St','', 'San Francisco', 'CA', '94122');



