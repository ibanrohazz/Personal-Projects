DROP TABLE IF EXISTS tasks CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY NOT NULL,
    user_name VARCHAR(30) NOT NULL
);

CREATE TABLE tasks (
    task_id SERIAL PRIMARY KEY NOT NULL,
    task_name VARCHAR(30) NOT NULL,
    task VARCHAR(256),
    task_status INT NOT NULL DEFAULT 0,
    u_id INT NOT NULL REFERENCES users( user_id )
);

INSERT INTO users (user_id, user_name)
    VALUES 
     (1, 'Mike'),
     (2, 'John'),
     (3, 'Jane');

INSERT INTO tasks(task_name, task, u_id)
    VALUES 
     ('Do this', 'This is a task you should do', 1),
     ('Do not do this', 'this is a task you should not do', 1),
     ('Testing the thing', 'this is a test for the thing that should do', 2),
     ('Testing the thing 2', 'this is a test for the thing that should do', 3);

