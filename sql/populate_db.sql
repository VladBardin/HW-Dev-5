INSERT INTO WORKER
(ID, NAME, BIRTHDAY, LEVEL, SALARY)
VALUES
   (1, 'Andy', '1989-05-02', 'Senior', 55000),
   (2, 'Thomas', '1999-11-28', 'Junior', 2500),
   (3, 'Hector', '1977-06-15', 'Senior', 75000),
   (4, 'Henry', '1993-05-13', 'Middle', 12500),
   (5, 'Victor', '1985-03-01', 'Senior', 65000),
   (6, 'Paul', '1997-10-20', 'Junior', 3000),
   (7, 'Miranda', '2002-06-21', 'Trainee', 850),
   (8, 'Evdokia', '2000-02-09', 'Trainee', 750),
   (9, 'Maria', '2001-02-18', 'Junior', 70000),
   (10, 'Alexander', '1990-08-28', 'Middle', 10500);

   INSERT INTO CLIENT
(ID, NAME)
VALUES
    (1, 'ITCorp'),
    (2, 'Smart Tech'),
    (3, 'Casual Uknown'),
    (4, 'Pan-American InfoBanking'),
    (5, 'NatCom');

    INSERT INTO project
    (ID, CLIENT_ID, START_DATE, FINISH_DATE)
    VALUES
     (1, 1, '2022-12-12', '2028-10-01'),
     (2, 1, '2021-11-13', '2023-11-02'),
     (3, 2, '2018-10-20', '2024-12-03'),
     (4, 2, '2020-09-21', '2027-01-27'),
     (5, 3, '2015-08-19', '2023-02-26'),
     (6, 3, '2014-07-05', '2022-03-18'),
     (7, 4, '2016-06-17', '2023-04-20'),
     (8, 4, '2018-05-18', '2024-05-13'),
     (9, 4, '2020-04-20', '2023-06-14'),
     (10, 5, '2023-03-29', '2023-07-15');

     INSERT INTO PROJECT_WORKER
     (PROJECT_ID, PROJECT_WORKER)
     VALUES
     (1, 1),
     (1, 2),
     (2, 2),
     (2, 1),
     (2, 3),
     (3, 5),
     (4, 6),
     (4, 7),
     (4, 8),
     (4, 1),
     (4, 9),
     (5, 9),
     (5, 4),
     (5, 10),
     (6, 8),
     (6, 6),
     (6, 5),
     (7, 3),
     (7, 4),
     (7, 10),
     (8, 8),
     (8, 6),
     (9, 7),
     (10, 6),
     (10, 3);