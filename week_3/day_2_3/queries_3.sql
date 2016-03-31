/* 1)List the students who didn’t appear for any exams.
 Format: name */
SELECT `name` 
	FROM `marks`
	JOIN `students` ON `students`.`id` = `marks`.`student_id` 
	WHERE `annual` IS NULL AND `quarterly` IS NULL AND `half_yearly` IS NULL;

/*2) Find the total marks scored by each students IN the annual exams. If the student hasn’t appeared for any annual exam, he should still be listed with total marks scored as “0”.
 Format: name, marks, year*/
SELECT `name`,SUM(COALESCE(`annual`,0)) AS `marks`,`year` 
	FROM `marks` 
	JOIN `students` ON `students`.`id` = `marks`.`student_id`  
	GROUP BY `student_id`,`year`;

/*3) List the students with the total marks scored IN quarterly FROM all the subjects they had appeared during the year 2003.
 Format: name, total, grade*/
SELECT `name`,SUM(COALESCE(`quarterly`,0)) AS `marks`,`year` 
	FROM `marks` 
	JOIN `students` ON `students`.`id` = `marks`.`student_id`  
	WHERE `year` = 2003 
	GROUP BY `student_id`,`year`;

/*4) List the 9th AND 10th grade students who received more than 3 medals.
 Format: name, grade, no_of_medals*/
SELECT `name`,COUNT(`medal_won`) AS `no_of_medals`
	FROM `medals`
	JOIN `students` ON `students`.`id` = `medals`.`student_id`  
	WHERE `grade` IN (9,10) 
	GROUP BY `student_id` HAVING COUNT(`medal_won`) > 3;

/*5) List the students who got less than 2 medals. This should also include the students who has not won any medals.
 Format: name, grade, no_of_medals*/
SELECT `name`,COUNT(`medal_won`) AS `no_of_medals`,`grade` 
	FROM `students` S 
	LEFT OUTER JOIN  `medals` M ON S.`id` = M.`student_id` 
	GROUP BY S.`ID`,`grade` HAVING COUNT(`medal_won`) < 2;

/*6) List the students who has not yet received any medals but scored more than 90 marks IN all the subjects IN the annual exam for that year.
-- Format: name, year*/
SELECT `year`,`student_id`
	FROM `marks` 
	WHERE `annual`>90 
	AND `student_id` IN 
	(SELECT s.`id` 
		FROM `students` s 
		LEFT OUTER JOIN `medals` m on m.`student_id` = s.`id` 
		GROUP BY s.`id` HAVING COUNT(`medal_won`) = 0) 
	GROUP BY `year`,`student_id` 
	HAVING COUNT(`subject_id`)=5;


/*7) List the records FROM the medals table for the students who had won more than 3 medals.
-- Format: name, game_id, medal_won, year, grade*/
SELECT `name`,`game_id`,`medal_won`,`year`,`grade` 
	FROM `medals` 
	JOIN `students` 
	WHERE `students`.`id` = `student_id` AND `student_id` IN 
	(SELECT `student_id` 
		FROM `medals` 
		GROUP BY `student_id` 
		HAVING COUNT(`medal_won`) > 3);

/*8) List the number of medals AND percentage of marks(based on total for the 5 subjects) scored IN each year.
-- Format: name, medals, quarterly_per, half_yearly_per, annual_per, year, grade*/
SELECT st.`name`, `medals`,`quarterly_per`,`half_yearly_per`,`annual_per`,`year`,`grade` 
	FROM ((SELECT COUNT(`medal_won`) as `medals`,`student_id` FROM `medals` GROUP BY `student_id`,`year`) as m) 
	JOIN (SELECT `grade`,`student_id`,sum(COALESCE(`annual`,0))/5 as `annual_per`,sum(COALESCE(`quarterly`,0))/5 as `quarterly_per`,sum(COALESCE(`half_yearly`,0))/5 as `half_yearly_per`,`year` FROM `marks` GROUP BY `year`,`student_id`,`grade`) as t on m.`student_id` = t.`student_id` 
	JOIN `students` st 
	WHERE m.`student_id` = st.`id`;

/* 9)Lets assign some rating for the total marks scored - S(450-500), A(400-449), B(350-399), C(300-349), D(250,299), E(200-249), F(below 200). List the students with the grade obtained IN each year for each exam(quarterly, half-yearly AND annual)
-- Format: name, quarterly_rating, half_yearly_rating, annual_rating, year, grade*/
DELIMITER $$

DROP FUNCTION IF EXISTS get_grade;
CREATE FUNCTION get_grade(score int) RETURNS char
	DETERMINISTIC
BEGIN
DECLARE grade char;
	IF score >= 450 THEN
SET grade = 'S';
	ELSEIF score >= 400 THEN
		SET grade = 'A';
	ELSEIF score >= 350 THEN
		SET grade = 'B';
	ELSEIF score >= 300 THEN
		SET grade = 'C';
	ELSEIF score >= '250' THEN
		SET grade = 'D';
	ELSEIF score >= 'E' THEN
		SET grade = 'F';
	END IF;
RETURN(grade);
END;
$$
delimiter ;

select s.name,get_grade(sum(COALESCE(`annual`,0))) as annual_rating,get_grade(sum(COALESCE(`quarterly`,0))) as quarterly_rating,get_grade(sum(COALESCE(`half_yearly`,0))) as half_yearly,year,grade 
	from marks m 
	join students s on m.student_id = s.id 
	group by student_id,year,grade;








