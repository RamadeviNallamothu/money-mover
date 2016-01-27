INSERT into account_type (id,account_type) values(1,'Checking_Account'); 
INSERT into account_type (id,account_type) values(2,'Saving_Account'); 
INSERT into account_type (id,account_type) values(3,'Loan_Account'); 
INSERT into account_type (id,account_type) values(4,'Trading_Account');

INSERT into customer_detail (customer_id,first_name,last_name,address,phone_num) values(1,'Mark','Zuekberg','New York USA', 7202171825);
INSERT into customer_detail (customer_id,first_name,last_name,address,phone_num) values(2,'Steve','Zuekberg','New York USA', 7202171826);
INSERT into customer_detail (customer_id,first_name,last_name,address,phone_num) values(3,'Laura','Zuekberg','New York USA', 7202171827);
INSERT into customer_detail (customer_id,first_name,last_name,address,phone_num) values(4,'Alex','Zuekberg','New York USA', 7202171828);
INSERT into customer_detail (customer_id,first_name,last_name,address,phone_num) values(5,'Mike','Zuekberg','New York USA', 7202171829);
INSERT into customer_detail (customer_id,first_name,last_name,address,phone_num) values(6,'Brian','Zuekberg','New York USA', 7202171830);
INSERT into customer_detail (customer_id,first_name,last_name,address,phone_num) values(7,'Brad','Zuekberg','New York USA', 7202171831);

INSERT into account_balance (customer_id,account_type_id,balance) values(1,1,5000);
INSERT into account_balance (customer_id,account_type_id,balance) values(1,2,2000);
INSERT into account_balance (customer_id,account_type_id,balance) values(2,1,3000);
INSERT into account_balance (customer_id,account_type_id,balance) values(3,1,4000);
INSERT into account_balance (customer_id,account_type_id,balance) values(4,2,5000);

INSERT into account_transaction_details (customer_id,account_type_id,transaction_type,transaction_amount,transaction_date,remark)values(1,1,'CREDIT',5000,sysdate,'Initial Deposit');
INSERT into account_transaction_details (customer_id,account_type_id,transaction_type,transaction_amount,transaction_date,remark)values(1,2,'CREDIT',2000,sysdate,'Initial Deposit');
INSERT into account_transaction_details (customer_id,account_type_id,transaction_type,transaction_amount,transaction_date,remark)values(2,1,'CREDIT',3000,sysdate,'Initial Deposit');
INSERT into account_transaction_details (customer_id,account_type_id,transaction_type,transaction_amount,transaction_date,remark)values(3,1,'CREDIT',4000,sysdate,'Initial Deposit');
INSERT into account_transaction_details (customer_id,account_type_id,transaction_type,transaction_amount,transaction_date,remark)values(4,2,'CREDIT',5000,sysdate,'Initial Deposit');

INSERT into account_detail (account_number,account_type,user,balance,transaction_amount,transaction_date,transaction_notes,transaction_type) values('12345','Checking_Account','foo', 5000,5000,sysdate,'Initial Deposit','CREDIT');
INSERT into account_detail (account_number,account_type,user,balance,transaction_amount,transaction_date,transaction_notes,transaction_type) values('12344','Checking_Account','george', 1000,1000,sysdate,'Initial Deposit','CREDIT');
INSERT into account_detail (account_number,account_type,user,balance,transaction_amount,transaction_date,transaction_notes,transaction_type) values('12333','Saving_Account','george', 3000,3000,sysdate,'Initial Deposit','CREDIT');
INSERT into account_detail (account_number,account_type,user,balance,transaction_amount,transaction_date,transaction_notes,transaction_type) values('12222','Checking_Account','michel', 4000,4000,sysdate,'Initial Deposit','CREDIT');
INSERT into account_detail (account_number,account_type,user,balance,transaction_amount,transaction_date,transaction_notes,transaction_type) values('11111','Saving_Account','foo', 5200,5200,sysdate,'Initial Deposit','CREDIT');










