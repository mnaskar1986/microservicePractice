Insert into user_dao(id, date_of_birth, name)
values(1001, current_date(), 'Ram');

Insert into user_dao(id, date_of_birth, name)
values(1002, current_date(), 'Raj');

Insert into user_dao(id, date_of_birth, name)
values(1003, current_date(), 'Shyam');

Insert into user_post(id, user_dao_id, description) 
values(2001, 1001, 'Need to learn Cloud.');

Insert into user_post(id, user_dao_id, description) 
values(2002, 1001, 'Need to learn Mongo DB.');

Insert into user_post(id, user_dao_id, description) 
values(2003, 1001, 'Need to learn DevOps.');

Insert into user_post(id, user_dao_id, description) 
values(2004, 1003, 'Preparing for the interview.');

Insert into user_post(id, user_dao_id, description) 
values(2005, 1003, 'Taking a course on MERN.');
