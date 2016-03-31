CREATE TABLE `TrainCoaches` (
	`TrainNo` varchar(15),
	`CoachCode` varchar(15),
	`NoOfSeats` int,
);

CREATE TABLE `Coaches`(
	`CoachCode` varchar(15),
	`CostPerKm` FLOAT(7,3),
);

CREATE TABLE `Bookings`(
	`BookingRefNo` varchar(10),
	`RouteId` varchar(15),
	`TrainNo` varchar(15),
	`CoachCode` varchar(15),
	`DateOfJourney` ,
	`DateOfBooking` ,
	`NoOfTickets` int,
);

CREATE TABLE `Users`(
	`UserId` varchar(10),
	`Login` varchar(20),
	`Password` varchar(20),
);

CREATE TABLE `Trains`(
	`TrainNo` varchar(15),
	`TrainName`
);

CREATE TABLE `TrainRouteMaps`(
	`RouteId` varchar(15),
);