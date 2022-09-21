INSERT INTO users(login, password) VALUES ('login1', '12345');
INSERT INTO users(login, password) VALUES ('nnnnn', '37373');
INSERT INTO users(login, password) VALUES ('vvvvv', '12344555');
INSERT INTO users(login, password) VALUES ('bsbsbs', '9494940');
INSERT INTO users(login, password) VALUES ('assrh', '567383');

INSERT INTO chatrooms(name, owner) VALUES ('C', 1);
INSERT INTO chatrooms(name, owner) VALUES ('C++', 2);
INSERT INTO chatrooms(name, owner) VALUES ('Java', 3);
INSERT INTO chatrooms(name, owner) VALUES ('Swift', 4);
INSERT INTO chatrooms(name, owner) VALUES ('C#', 5);

INSERT INTO messages(author, room, text, date) VALUES ((1), (1), 'text1', '2022-04-23 11:34');
INSERT INTO messages(author, room, text, date) VALUES ((2), (2), 'text2', '2022-04-24 13:45');
INSERT INTO messages(author, room, text, date) VALUES ((3), (3), 'text3', '2022-04-24 08:43');
INSERT INTO messages(author, room, text, date) VALUES ((4), (4), 'text4', '2022-04-25 17:12');
INSERT INTO messages(author, room, text, date) VALUES ((5), (5), 'text5', '2022-04-25 16:18');


INSERT INTO lists_chatrooms(user_id, chatroom_id) VALUES (1, 1);
INSERT INTO lists_chatrooms(user_id, chatroom_id) VALUES (2, 2);
INSERT INTO lists_chatrooms(user_id, chatroom_id) VALUES (3, 3);
INSERT INTO lists_chatrooms(user_id, chatroom_id) VALUES (4, 5);
INSERT INTO lists_chatrooms(user_id, chatroom_id) VALUES (5, 5);