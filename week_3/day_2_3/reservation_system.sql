CREATE DATABASE `reservation_system`;

CREATE TABLE `Coaches`(
	`CoachCode` varchar(15) NOT NULL,
	`CostPerKm` FLOAT(7,3) NOT NULL,
	PRIMARY KEY (`CoachCode`)
);

CREATE TABLE `Users`(
	`UserId` varchar(10) NOT NULL,
	`Login` varchar(20) NOT NULL,
	`Password` varchar(20) NOT NULL,
	PRIMARY KEY (`UserId`)
);

CREATE TABLE `Trains`(
	`TrainNo` varchar(15) NOT NULL,
	`TrainName`varchar(30) NOT NULL,
	PRIMARY KEY (`TrainNo`)
);

CREATE TABLE `Stations`(
	`StationId` varchar(15) NOT NULL,
	`StationCode` varchar(15) NOT NULL,
	PRIMARY KEY (`StationId`)
);

CREATE TABLE `TrainCoaches` (
	`TrainNo` varchar(15) NOT NULL,
	`CoachCode` varchar(15) NOT NULL,
	`NoOfSeats` int NOT NULL,
	FOREIGN KEY (`TrainNo`) REFERENCES `Trains` (`TrainNo`),
	FOREIGN KEY (`CoachCode`) REFERENCES `Coaches` (`CoachCode`)	
);

CREATE TABLE `Routes`(
	`RouteId` varchar(15) NOT NULL,
	`OriginStationId` varchar(15) NOT NULL,
	`DestinationStationId` varchar(15) NOT NULL,
	`DistanceInKms` FLOAT(7,3) NOT NULL,
	PRIMARY KEY (`RouteId`),
	FOREIGN KEY (`OriginStationId`) REFERENCES `Stations` (`StationId`),
	FOREIGN KEY (`DestinationStationId`) REFERENCES `Stations` (`StationId`)
);

CREATE TABLE `Bookings`(
	`BookingRefNo` varchar(10) NOT NULL,
	`RouteId` varchar(15) NOT NULL,
	`TrainNo` varchar(15) NOT NULL,
	`CoachCode` varchar(15) NOT NULL,
	`DateOfJourney` datetime ,
	`DateOfBooking` datetime ,
	`NoOfTickets` int NOT NULL,
	PRIMARY KEY (`BookingRefNo`),
	FOREIGN KEY (`TrainNo`) REFERENCES `Trains` (`TrainNo`),
	FOREIGN KEY (`RouteId`) REFERENCES `Routes` (`RouteId`),
	FOREIGN KEY (`CoachCode`) REFERENCES `Coaches` (`CoachCode`)	
);

CREATE TABLE `TrainRouteMaps`(
	`RouteId` varchar(15) NOT NULL,
	`TrainNo` varchar(15) NOT NULL,
	`ArrivalTime` time NOT NULL,
	`DepartureTime` time NOT NULL,
	`DurationInMins` int NOT NULL,
	PRIMARY KEY(`RouteId`,`TrainNo`),
	FOREIGN KEY (`TrainNo`) REFERENCES `Trains` (`TrainNo`),
	FOREIGN KEY (`RouteId`) REFERENCES `Routes` (`RouteId`)
);


