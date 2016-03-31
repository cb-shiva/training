-- Write SQL queries for the below questions after loading the sample exercise data.

-- Queries that uses “students” table:

--1)Select all the students
SELECT * FROM `students`;

-- 2)Select all the students whose names starts with “H”
SELECT * FROM `students` WHERE `name` like "H%";

-- 3)Select all the students whose name has the alphabet “a”
SELECT * FROM `students` WHERE `name` like "%a%";

-- 4)Select all the students AND list the results sorted IN alphabetical order(a-z).
SELECT * FROM `students` ORDER BY `name`;

-- 5)List the first “2” students with the results sorted IN the alphabetical order(a-z).
SELECT * FROM `students` ORDER BY `name` LIMIT 2;

-- 6)List the next “2” students(3rd AND 4th) when they are sorted IN the alphabetical order.
SELECT * FROM `students` ORDER BY `name` LIMIT 2 OFFSET 2;


-- Queries that uses “marks” table:

--1) Select the students who has not appeared IN the annual exams.
-- Format: All columns of the “marks” table.
SELECT * FROM `marks` WHERE `annual` IS NULL group by `year`;

--2) Select the students who has not appeared IN the annual exams during the year “2005”.
-- Format: student_id, subject_id, year
SELECT `student_id`,`subject_id`,`year` FROM `marks` WHERE `annual` IS NULL AND `year` = "2005" group by `year`;;

-- 3)Select the students who has appeared IN one of the exams - quarterly, half_yearly OR annual.
-- Format: student_id, subject_id, year
SELECT `student_id`,`subject_id`,`year` FROM `marks` WHERE `annual` IS NOT NULL OR `quarterly` IS NOT NULL OR `half_yearly` IS NOT NULL;

-- 4)Select the students who has scored more than 90 IN all the exams - quarterly, half_yearly AND annual.
-- Format: student_id, subject_id, year, quarterly, half_yearly, annual
SELECT `student_id`,`subject_id`,`year`,`quarterly`,`half_yearly`,`annual` FROM `marks` WHERE `annual` > 90 AND `half_yearly` > 90 AND `quarterly` > 90;

-- 5)List the average marks(in quarterly, half_yearly & annual) for each subject scored for the year.
-- Format: student_id, subject_id, average, year
 SELECT `student_id`,`subject_id`,((COALESCE(`quarterly`,0)+COALESCE(`half_yearly`,0)+COALESCE(`annual`,0))/3) AS `average`,`year` FROM `marks`;

-- 6)List the average marks(in quarterly, half_yearly & annual) for each subject scored for the years 2003 & 2004
-- Format: student_id, subject_id, average, year
 SELECT `student_id`,`subject_id`,((COALESCE(`quarterly`,0)+COALESCE(`half_yearly`,0)+COALESCE(`annual`,0))/3) AS `average`,`year` FROM `marks` WHERE `year` IN (2003,2004);
