CREATE TABLE courses (
                         id BIGSERIAL PRIMARY KEY,
                         title VARCHAR(100) NOT NULL,
                         description VARCHAR(1000),
                         tutor_id BIGINT NOT NULL
);

CREATE TABLE tutors (
                        id BIGSERIAL PRIMARY KEY,
                        first_name VARCHAR(100) NOT NULL,
                        last_name VARCHAR(100) NOT NULL,
                        user_id BIGINT NOT NULL
);

CREATE TABLE students (
                          id BIGSERIAL PRIMARY KEY,
                          first_name VARCHAR(100) NOT NULL,
                          last_name VARCHAR(100) NOT NULL,
                          user_id BIGINT NOT NULL
);

/*ALTER TABLE tutors
    ADD CONSTRAINT fk_user_id_tutors
        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE students
    ADD CONSTRAINT fk_user_id_students
        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;*/

ALTER TABLE courses
    ADD CONSTRAINT fk_tutor_id
        FOREIGN KEY (tutor_id) REFERENCES tutors(id) ON DELETE SET NULL;

CREATE TABLE students_courses (
                                  student_id BIGINT NOT NULL,
                                  course_id BIGINT NOT NULL,
                                  PRIMARY KEY (student_id, course_id)
);

ALTER TABLE students_courses
    ADD CONSTRAINT fk_student_id
        FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE;

ALTER TABLE students_courses
    ADD CONSTRAINT fk_course_id
        FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE;



INSERT INTO tutors (first_name, last_name, user_id) VALUES
                                                        ('Ivan', 'Petrov', 1),
                                                        ('Elena', 'Sidorova', 2);

INSERT INTO students (first_name, last_name, user_id) VALUES
                                                          ('Sergey', 'Kuznetsov', 4),
                                                          ('Maria', 'Orlova', 5);

INSERT INTO courses (title, description, tutor_id) VALUES
                                                       ('Mathematics 101', 'Introduction to basic mathematics concepts', 1),
                                                       ('Physics 101', 'Basics of physics including mechanics and thermodynamics', 1),
                                                       ('Chemistry 101', 'Basic principles of chemistry and laboratory techniques', 2),
                                                       ('History 101', 'World history from ancient times to modern era', 2);

INSERT INTO students_courses (student_id, course_id) VALUES
                                                         (1, 1),
                                                         (1, 2),
                                                         (2, 3),
                                                         (2, 4);

CREATE TABLE tasks (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description VARCHAR(1000),
                       course_id BIGINT NOT NULL,
                       max_score INT
);

ALTER TABLE tasks
    ADD CONSTRAINT fk_course_id
        FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE;

INSERT INTO tasks (title, description, course_id, max_score) VALUES
                                                                 -- "Mathematics 101"
                                                                 ('Homework 1', 'Solve algebraic equations.', 1, 100),
                                                                 ('Quiz 1', 'Complete a test on basic mathematical concepts.', 1, 50),

                                                                 -- "Physics 101"
                                                                 ('Lab Report', 'Write a report on the mechanics lab experiment.', 2, 70),
                                                                 ('Problem Set', 'Solve problems related to thermodynamics.', 2, 80),

                                                                 --  "Chemistry 101"
                                                                 ('Experiment Log', 'Keep a log of observations during the experiment.', 3, 60),
                                                                 ('Research Paper', 'Write a research paper on "Acids and Bases".', 3, 100),

                                                                 -- "History 101"
                                                                 ('Essay', 'Write an essay on "The Influence of the Roman Empire on Europe".', 4, 80),
                                                                 ('Presentation', 'Prepare a presentation on medieval history.', 4, 90);
CREATE TABLE marks (
                       id BIGSERIAL PRIMARY KEY,
                       task_id BIGINT NOT NULL,
                       student_id BIGINT NOT NULL,
                       mark INT NOT NULL
);

ALTER TABLE marks
    ADD CONSTRAINT fk_task_id
        FOREIGN KEY (task_id) REFERENCES tasks(id) ON DELETE CASCADE;

ALTER TABLE marks
    ADD CONSTRAINT fk_student_id
        FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE;


INSERT INTO marks (task_id, student_id, mark) VALUES
                                                  -- Оцінки для Сергія Кузнецова (student_id = 1)
                                                  (1, 1, 90),  -- Homework 1 з курсу "Mathematics 101"
                                                  (2, 1, 45),  -- Quiz 1 з курсу "Mathematics 101"
                                                  (3, 1, 65),  -- Lab Report з курсу "Physics 101"
                                                  (4, 1, 75),  -- Problem Set з курсу "Physics 101"

                                                  -- Оцінки для Марії Орлової (student_id = 2)
                                                  (5, 2, 60),  -- Experiment Log з курсу "Chemistry 101"
                                                  (6, 2, 90),  -- Research Paper з курсу "Chemistry 101"
                                                  (7, 2, 70),  -- Essay з курсу "History 101"
                                                  (8, 2, 85);  -- Presentation з курсу "History 101"
