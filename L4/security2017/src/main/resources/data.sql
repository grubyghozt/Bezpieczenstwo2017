insert into USER_PROFILE values (1,'USER'),(2,'ADMIN');

delete from hibernate_sequence;

insert into hibernate_sequence(next_val) VALUES (10),(10),(10),(10),(10),(10),(10),(10),(10),(10);
INSERT INTO USER(Id, username, encodedPassword, isEnabled) VALUES (1,'xyz@xyz.com','07b446c993fc40edab5ff2fab1b7da7f3792a0add52a36ae4a826c977755c456ce885aff3f8dd9bf', 1);

insert into APP_USER_USER_PROFILE (USER_ID, USER_PROFILE_ID) VALUE (1,1);

insert into TRANSFERS(Id, accountNumber, amount,receiver, userId) VALUES (1, 11111, 22.22, 'ktostan', 1);