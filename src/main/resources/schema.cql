CREATE KEYSPACE database IF NOT EXISTS
with replication = {'class': 'SimpleStrategy','replication_factor':1}

CREATE TABLE database.customerAccount (
customer_id text PRIMARY KEY, --Or use UUID--
first_name text,
last_name text,
phone_no text,
email text,
address text,
address2 text,
city text,
state text,
zip text,
order_id list<text>);

INSERT INTO database.customerAccount (
'C0000', 'Bobby', 'Bilyeu','415-311-8021', 'bilyeubobby@sfstate.edu',
'812 Noriega St', 'San Francisco', 'CA', '94122', ['S0000']
);

CREATE TABLE database.orderAccount (
order_id text,
customer_id text,
product_id text,
sold_id UUID,
product_name text,
size text,
disposition text,
quantity int,
sticker_price int;
sale_price int;
perc_discount int;
total_sale_price int;
PRIMARY KEY(order_id, sold_id);



)

