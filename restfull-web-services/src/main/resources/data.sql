INSERT INTO users(name, birthdate) VALUES ('Keertan', '2004-06-19'),
                                       ('Palak', '2007-02-02'),
                                       ('Ayesha', '2003-09-15'),
                                       ('Ali', '2002-12-08'),
                                       ('Sara', '2005-04-21'),
                                       ('Hamza', '2001-11-30'),
                                       ('Hina', '2006-07-12'),
                                       ('Ahmed', '2004-03-25'),
                                       ('Fatima', '2003-01-18'),
                                       ('Bilal', '2005-08-09'),
                                       ('Zainab', '2002-05-14'),
                                       ('Usman', '2001-10-27'),
                                       ('Maham', '2006-06-05'),
                                       ('Danish', '2004-02-11'),
                                       ('Iqra', '2003-12-22');

INSERT INTO posts
(post_title, post_caption, post_created_date, user_id)
VALUES
    ('Learning Spring Boot',
     'Today I started learning Spring Boot REST APIs.',
     '2026-07-12 10:30:00',
     1),

    ('JPA Relationships',
     'Learning how ManyToOne relationships work in JPA.',
     '2026-07-12 11:15:00',
     1),

    ('Database Practice',
     'Practicing SQL queries with Spring Data JPA.',
     '2026-07-12 12:00:00',
     2),

    ('REST API Development',
     'Created my first REST API using Spring Boot.',
     '2026-07-12 13:20:00',
     2),

    ('Hibernate Mapping',
     'Understanding entity and table mapping.',
     '2026-07-12 14:10:00',
     1);