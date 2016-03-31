-- Select the students who has not appeared in the annual exams.
-- Format: All columns of the “marks” table.
SELECT `marks`.`id`,`students`.`name`,`subject_id`,`year`,`quarterly`,`half_yearly`,`annual`,`year`,`grade` FROM `marks` JOIN `students` ON `students`.`id` = `marks`.`student_id`  WHERE `annual` IS NULL group by `year`;

-- Select the students who has not appeared in the annual exams during the year “2005”.
-- Format: student_id, subject_id, year
SELECT `name`,`subject_id`,`year` FROM `marks` JOIN `students` ON `students`.`id` = `marks`.`student_id` WHERE `annual` IS NULL and `year` = "2005";

-- Select the students who has appeared in one of the exams - quarterly, half_yearly or annual.
-- Format: student_id, subject_id, year
SELECT `name`,`subject_id`,`year` FROM `marks` JOIN `students` ON `students`.`id` = `marks`.`student_id` WHERE `annual` IS NOT NULL or `quarterly` IS NOT NULL or `half_yearly` IS NOT NULL;

-- Select the students who has scored more than 90 in all the exams - quarterly, half_yearly and annual.
-- Format: student_id, subject_id, year, quarterly, half_yearly, annual
SELECT `name`,`subject_id`,`year`,`quarterly`,`half_yearly`,`annual` FROM `marks` JOIN `students` ON `students`.`id` = `marks`.`student_id` WHERE `annual` > 90 and `half_yearly` > 90 and `annual` > 90;

-- List the average marks(in quarterly, half_yearly & annual) for each subject scored for the year.
-- Format: student_id, subject_id, average, year
 SELECT `marks`.`student_id`,`subject_id`,((COALESCE(`quarterly`,0)+COALESCE(`half_yearly`,0)+COALESCE(`annual`,0))/3) as `average`,`year` from `marks` JOIN `students` ON `students`.`id` = `marks`.`student_id`;

-- List the average marks(in quarterly, half_yearly & annual) for each subject scored for the years 2003 & 2004
-- Format: student_id, subject_id, average, year
 SELECT `marks`.`student_id`,`subject_id`,((COALESCE(`quarterly`,0)+COALESCE(`half_yearly`,0)+COALESCE(`annual`,0))/3) as `average`,`year` from `marks` JOIN `students` ON `students`.`id` = `marks`.`student_id` WHERE `year` in (2003,2004);
