CREATE TABLE users
(
    userId  BIGSERIAL PRIMARY KEY,
    login VARCHAR(20),
    password INT
);

CREATE TABLE chatrooms
(
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(20),
    owner int not null,
    CONSTRAINT owner FOREIGN KEY (owner) REFERENCES users (userId)
);

CREATE TABLE messages
(
    id BIGSERIAL PRIMARY KEY,
    CONSTRAINT author FOREIGN KEY (author) REFERENCES users (userId),
    CONSTRAINT room FOREIGN KEY (room) REFERENCES chatrooms (id),
    text VARCHAR(100),
    date TIMESTAMP,
    author int not null,
    room int not null

);

CREATE TABLE lists_chatrooms
(
    user_id BIGSERIAL REFERENCES users(userId),
    chatroom_id BIGSERIAL REFERENCES chatrooms(id)
);
