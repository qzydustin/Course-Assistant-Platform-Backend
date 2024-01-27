DROP SCHEMA IF EXISTS `cap`;

CREATE SCHEMA IF NOT EXISTS `cap`;
USE `cap`;

CREATE TABLE student (
    id BIGINT AUTO_INCREMENT NOT NULL,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (email)
);

CREATE TABLE instructor (
    id BIGINT AUTO_INCREMENT NOT NULL,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (email)
);

CREATE TABLE course (
    id BIGINT AUTO_INCREMENT NOT NULL,
    instructor_id BIGINT NULL,
    code VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    information VARCHAR(255) NULL,
    department VARCHAR(255) NOT NULL,
    semester VARCHAR(255) NOT NULL,
    unit INT NOT NULL,
    seat INT NOT NULL,
    weekday VARCHAR(255) NOT NULL,
    start_time VARCHAR(255) NOT NULL,
    end_time VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (code, semester),
    FOREIGN KEY (instructor_id) REFERENCES instructor (id)
);

CREATE TABLE student_course (
    id BIGINT AUTO_INCREMENT NOT NULL,
    student_id BIGINT NULL,
    course_id BIGINT NULL,
    grade INT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (course_id) REFERENCES course (id),
    FOREIGN KEY (student_id) REFERENCES student (id)
);

CREATE TABLE post (
    id BIGINT AUTO_INCREMENT NOT NULL,
    course_id BIGINT NULL,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255) NULL,
    student_id BIGINT NULL,
    instructor_id BIGINT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (course_id) REFERENCES course (id),
    FOREIGN KEY (instructor_id) REFERENCES instructor (id),
    FOREIGN KEY (student_id) REFERENCES student (id)
);

CREATE TABLE post_comment (
    id BIGINT AUTO_INCREMENT NOT NULL,
    post_id BIGINT NULL,
    content VARCHAR(255) NULL,
    student_id BIGINT NULL,
    instructor_id BIGINT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (instructor_id) REFERENCES instructor (id),
    FOREIGN KEY (post_id) REFERENCES post (id),
    FOREIGN KEY (student_id) REFERENCES student (id)
);

CREATE TABLE announcement (
    id BIGINT AUTO_INCREMENT NOT NULL,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255) NULL,
    course_id BIGINT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (course_id) REFERENCES course (id)
);

CREATE TABLE assignment (
    id BIGINT AUTO_INCREMENT NOT NULL,
    course_id BIGINT NULL,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255) NULL,
    file_path VARCHAR(255) NULL,
    start_date DATETIME NULL,
    end_date DATETIME NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (course_id) REFERENCES course (id)
);

CREATE TABLE assignment_submission (
    id BIGINT AUTO_INCREMENT NOT NULL,
    assignment_id BIGINT NULL,
    content VARCHAR(255) NULL,
    file_path VARCHAR(255) NULL,
    student_id BIGINT NULL,
    submit_date DATETIME NULL,
    score DOUBLE NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (assignment_id) REFERENCES assignment (id),
    FOREIGN KEY (student_id) REFERENCES student (id)
);
