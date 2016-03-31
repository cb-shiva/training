alter table marks add (created_at datetime not null default current_timestamp,updated_at datetime on update current_timestamp default current_timestamp);
alter table students add (created_at datetime not null default current_timestamp,updated_at datetime on update current_timestamp default current_timestamp);
alter table medals add (created_at datetime not null default current_timestamp,updated_at datetime on update current_timestamp default current_timestamp);

update marks set annual = 0 where annual is null;
update marks set quarterly = 0 where quarterly is null;
update marks set half_yearly = 0 where half_yearly is null;

alter table marks modify column annual int(11) not null;
alter table marks modify column quarterly int(11) not null;
alter table marks modify column half_yearly int(11) not null;


insert into marks(student_id,subject_id,quarterly,half_yearly,annual,year,grade) values ("100001","2","100","100","100","2008","11");

create table students_summary (
	student_id bigint(19) not null,
	student_name varchar(100) not null,
	year int(11) ,
	percentage float(4,2),
	no_of_medals_received  int(11)
);

select m.student_id as student_id,s.name as student_name,m.year as year,

INSERT INTO `students_summary`
SELECT `st`.`id` as `student_id`, st.`name` as `student_name`, `year` ,`annual_per` as `percentage`,`medals` as `no_of_medals_received`
	FROM ((SELECT COUNT(`medal_won`) as `medals`,`student_id` FROM `medals` GROUP BY `student_id`,`year`) as m) 
	JOIN (SELECT `student_id`,sum(COALESCE(`annual`,0))/5 as `annual_per`,`year` FROM `marks` GROUP BY `year`,`student_id`) as t on m.`student_id` = t.`student_id` 
	JOIN `students` `st` 
	WHERE `m`.`student_id` = `st`.`id`;



alter table marks add (average float(7,3));
DELIMITER $$
create trigger avg_calc before insert on marks
	for each row
	begin
		set new.average = (new.annual + new.half_yearly + new.quarterly)/3;
	end
$$
delimiter ;

alter table medals add (medal_recieved varchar(10));
delimiter $$
create trigger medal_copy before insert on medals
	for each row
	begin
		if new.medal_won is null then
			set new.medal_won = new.medal_recieved;
		elseif new.medal_recieved is null then
			set new.medal_recieved = new.medal_won;
		end if;
	end
$$
delimiter ;


alter table medals drop medal_won;
