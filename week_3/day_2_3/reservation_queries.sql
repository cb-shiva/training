-- 1)To get the list of all trains
SELECT `TrainName` FROM `Trains`;

-- 2)To get the list of all train routes in the database
SELECT `origin`.`StationCode`,`dest`.`StationCode` 
	FROM `Routes` 
	join `Stations` `origin` on `OriginStationId` = `StationId` 
	join `Stations` `dest` on `DestinationStationId` = `dest`.`StationId`;

-- 3)Total number of seats in the each train.
SELECT `origin`.`StationCode`,`dest`.`StationCode` 
	FROM `Routes` 
	join `Stations` `origin` on `OriginStationId` = `StationId` 
	join `Stations` `dest` on `DestinationStationId` = `dest`.`StationId`;

-- 4)List of all routes goes to Bangalore
SELECT `origin`.`StationCode` as `Origin`,`dest`.`StationCode` as `Destinantion`,`DistanceInKms` 
	FROM `Routes` 
	join `Stations` `origin` on `OriginStationId` = `StationId` 
	join `Stations` `dest` on `DestinationStationId` = `dest`.`StationId` 
	where `dest`.`StationCode` = "SBC";

-- 5)List of all routes starting from bangalore, calcutta and chennai
SELECT `origin`.`StationCode` as `Origin`,`dest`.`StationCode` as `Destinantion`,`DistanceInKms` 
	FROM `Routes` 
	join `Stations` `origin` on `OriginStationId` = `StationId` 
	join `Stations` `dest` on `DestinationStationId` = `dest`.`StationId` 
	where `origin`.`StationCode` = "SBC" 
	or `origin`.`StationCode` = "CL" 
	or `origin`.`StationCode` = "MAS";

-- 6)List of all the bookings booked between 1st Jan 2005 and 31st Dec 2005
select `train`.`TrainName`,`CoachCode`,`DateOfJourney`,`DateOfBooking`,`NoOfTickets` 
	from `Bookings` `booking` 
	join `Trains` `train` on `booking`.`TrainNo`= `train`.`TrainNo` 
	where `booking`.`DateOfBooking` between '2005-01-01' and '2005-12-31';

-- 7)List of all trains whose name begins with B
select `TrainName` from `Trains` where `TrainName` like "B%";

-- 8)List of all bookings where DOB is not null
select `train`.`TrainName`,`CoachCode`,`DateOfJourney`,`DateOfBooking`,`NoOfTickets` 
	from `Bookings` `booking` 
	join `Trains` `train` on `booking`.`TrainNo`= `train`.`TrainNo` 
	where `booking`.`DateOfBooking` is not null;

-- 9)List of all bookings for the booked in 2006, DOJ in 2007
select `train`.`TrainName`,`CoachCode`,`DateOfJourney`,`DateOfBooking`,`NoOfTickets` 
	from `Bookings` `booking` 
	join `Trains` `train` on `booking`.`TrainNo`= `train`.`TrainNo` 
	where year(`booking`.`DateOfBooking`) = 2006 and year(`booking`.`DateOfJourney`) = 2007;

-- 10)Total number of coaches in the all the trains
select `train`.`TrainName`,count(`CoachCode`)  as `coach_count`
	from `TrainCoaches` `traincoach` 
	join `Trains` `train` on `traincoach`.`TrainNo` = `train`.`TrainNo` 
	group by `traincoach`.`TrainNo`;

-- 11)Total number of bookings in the database for the train no 16198
select count(*) as `booking_count` from `Bookings` where `TrainNo` = "16198";

-- 12)Total no of tickets column 'total' , booked for train no. 14198
select sum(`NoOfTickets`) as `total` from `Bookings` where `TrainNo` = "14198";

-- 13)Minimum distance route
SELECT `origin`.`StationCode`,`dest`.`StationCode`,`DistanceInKms`
	FROM `Routes` `r`
	join `Stations` `origin` on `OriginStationId` = `StationId` 
	join `Stations` `dest` on `DestinationStationId` = `dest`.`StationId`
	order by `r`.`DistanceInKms` limit 1; 

-- 14)Total number of tickets booked for each train in the database
select `train`.`TrainName`,sum(`NoOfTickets`) `total`
	from `Bookings` `booking` 
	join `Trains` `train` on `booking`.`TrainNo`= `train`.`TrainNo` 
	group by `train`.`TrainNo`;

-- 15)cost for 50 kms for each coach.
select `CoachCode`,`CostPerKm`*50 as `total_cost` from `Coaches`;

-- 16)List the train name and departure time for the trains starting from Bangalore.	
select `train`.`TrainName`, `trainroutemap`.`DepartureTime` 
	from `Bookings` `booking` 
	join `Trains` `train` on `booking`.`TrainNo`= `train`.`TrainNo` 
	join `TrainRouteMaps` `trainroutemap` on `booking`.`RouteId` = `trainroutemap`.`RouteId` and `booking`.`TrainNo` = `trainroutemap`.`TrainNo` 
	join `Routes` `route` on `booking`.`RouteId` = `route`.`RouteId` 
	join `Stations` `station` on `station`.`StationId` = `route`.`OriginStationId` 
	where `station`.`StationCode` = "SBC";

-- 17)List the trains for which the total no of tickets booked is greater than 500
select `train`.`TrainName`,sum(`NoOfTickets`) 
	from `Bookings` `booking` 
	join `Trains` `train` on `booking`.`TrainNo`= `train`.`TrainNo`
	group by `train`.`TrainNo` 
	having sum(`NoOfTickets`)>500;

-- 18)List the trains for which the total no of tickets booked is lesser than 50
select `train`.`TrainName`,sum(`NoOfTickets`) 
	from `Bookings` `booking` 
	join `Trains` `train` on `booking`.`TrainNo`= `train`.`TrainNo` 
	group by `train`.`TrainNo` 
	having sum(`NoOfTickets`)<50;

-- 19)List the bookings along with train name, origin station, destination station and coach code after the date of journey ’25th Feb 2015’
select `train`.`TrainName`, `trainroutemap`.`DepartureTime` 
	from `Bookings` `booking` 
	join `Trains` `train` on `booking`.`TrainNo`= `train`.`TrainNo` 
	join `TrainRouteMaps` `trainroutemap` on `booking`.`RouteId` = `trainroutemap`.`RouteId` and `booking`.`TrainNo` = `trainroutemap`.`TrainNo` 
	join `Routes` `route` on `booking`.`RouteId` = `route`.`RouteId` 
	join `Stations` `origin` on `route`.`OriginStationId` = `origin`.`StationId` 
	join `Stations` `dest` on `route`.`DestinationStationId` = `dest`.`StationId` 
	join `TrainCoaches` `traincoach` on `booking`.`TrainNo` = `traincoach`.`TrainNo` 
	join `Coaches` `coach` on `traincoach`.`CoachCode` = `coach`.`CoachCode` 
	where `booking`.`DateOfJourney`> DATE(25-02-2015);

-- 20)List the trains via the route Mysore - Chennai
SELECT `origin`.`StationCode` as `Origin`,`dest`.`StationCode` as `Destinantion`,`DistanceInKms` 
	FROM `Routes`
	join `Stations` `origin` on `OriginStationId` = `StationId` 
	join `Stations` `dest` on `DestinationStationId` = `dest`.`StationId` 
	where `dest`.`StationCode` = "MYS" and `origin`.`StationCode` = "MAS";

-- 21)List the trains for which are booked till now.
select `train`.`TrainName` 
	from `Trains` `train` 
	left join `Bookings` `booking` on `train`.`TrainNo` = `booking`.`TrainNo` 
	where `booking`.`TrainNo` is not null;

