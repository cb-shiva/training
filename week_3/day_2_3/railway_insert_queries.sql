/* Coaches table */

insert into  coaches values ( "1A"        ,      4.00 );
insert into  coaches values	( "2A"        ,      3.50 );
insert into  coaches values	( "2S"        ,      0.40 );
insert into  coaches values	( "3A"        ,      2.50 );
insert into  coaches values	( "3E"        ,      2.00 );
insert into  coaches values	( "CC"        ,      1.80 );
insert into  coaches values	( "FC"        ,      3.00 );
insert into  coaches values	( "SL"        ,      0.80 );
				 
 
/* Users table  */

insert into  users values(    100 ,     100 , "abc"       );
insert into  users values(    101 ,     101 , "aaa"       );
insert into  users values(    102 ,     102 , "bbb"       );
insert into  users values(    103 ,     103 , "ccc"       );
insert into  users values(    104 ,     104 , "ddd"       );
			

/* Trains table */

 insert into  trains values(12577,	    "Bagmati Express" );
 insert into  trains values(12607,      "Lalbagh express" );
 insert into  trains values(12609,      "Bangalore Exp"   );
 insert into  trains values(12610,      "Chennai Express" );
 insert into  trains values(12639,      "Brindavan Exp"   );
 insert into  trains values(12658,      "Chennai Mail"    );
 insert into  trains values(14198,      "Vaigai Express"  );
 insert into  trains values(16198,      "Pandian Express" );
 insert into  trains values(22682,      "Mysore Express"  );

/*Stations table*/
				
 insert into  stations values(        12 , "MAS"          );
 insert into  stations values(        13 , "SBC"          );
 insert into  stations values(        14 , "MYS"          );
 insert into  stations values(        15 , "MDU"          );

		
/*TrainCoaches table*/

insert into  TrainCoaches (TrainNo, CoachCode, NoOfSeats) values
(   12577 , "1A"        ,        50 ),
(   12577 , "2A"        ,        50 ),
(   12577 , "2S"        ,        50 ),
(   12577 , "3A"        ,        50 ),
(   12577 , "3E"        ,        50 ),
(   12577 , "CC"        ,        50 ),
(   12577 , "FC"        ,        50 ),
(   12577 , "SL"        ,        50 ),
(   12607 , "1A"        ,       100 ),
(   12607 , "2A"        ,       100 ),
(   12607 , "2S"        ,       100 ),
(   12607 , "3A"        ,       100 ),
(   12607 , "3E"        ,       100 ),
(   12607 , "CC"        ,       100 ),
(   12607 , "FC"        ,       100 ),
(   12607 , "SL"        ,       100 ),
(   12609 , "1A"        ,       150 ),
(   12609 , "2A"        ,       150 ),
(   12609 , "2S"        ,       150 ),
(   12609 , "3A"        ,       150 ),
(   12609 , "3E"        ,       150 ),
(   12609 , "CC"        ,       150 ),
(   12609 , "FC"        ,       150 ),
(   12609 , "SL"        ,       150 ),
(   12610 , "1A"        ,       200 ),
(   12610 , "2A"        ,       200 ),
(   12610 , "2S"        ,       200 ),
(   12610 , "3A"        ,       200 ),
(   12610 , "3E"        ,       200 ),
(   12610 , "CC"        ,       200 ),
(   12610 , "FC"        ,       200 ),
(   12610 , "SL"        ,       200 ),
(   12639 , "1A"        ,       250 ),
(   12639 , "2A"        ,       250 ),
(   12639 , "2S"        ,       250 ),
(   12639 , "3A"        ,       250 ),
(   12639 , "3E"        ,       250 ),
(   12639 , "CC"        ,       250 ),
(   12639 , "FC"        ,       250 ),
(   12639 , "SL"        ,       250 ),
(   12658 , "1A"        ,        50 ),
(   12658 , "2A"        ,        50 ),
(   12658 , "2S"        ,        50 ),
(   12658 , "3A"        ,        50 ),
(   12658 , "3E"        ,        50 ),
(   12658 , "CC"        ,        50 ),
(   12658 , "FC"        ,        50 ),
(   12658 , "SL"        ,        50 ),
(   22682 , "1A"        ,       100 ),
(   22682 , "2A"        ,       100 ),
(   22682 , "2S"        ,       100 ),
(   22682 , "3A"        ,       100 ),
(   22682 , "3E"        ,       100 ),
(   22682 , "CC"        ,       100 ),
(   22682 , "FC"        ,       100 ),
(   22682 , "SL"        ,       100 ),
(   16198 , "1A"        ,       100 ),
(   16198 , "2A"        ,       100 ),
(   16198 , "2S"        ,       100 ),
(   16198 , "3A"        ,       100 ),
(   16198 , "3E"        ,       100 ),
(   16198 , "CC"        ,       100 ),
(   16198 , "FC"        ,       100 ),
(   16198 , "SL"        ,       100 ),
(   14198 , "1A"        ,       100 ),
(   14198 , "2A"        ,       100 ),
(   14198 , "2S"        ,       100 ),
(   14198 , "3A"        ,       100 ),
(   14198 , "3E"        ,       100 ),
(   14198 , "CC"        ,       100 ),
(   14198 , "FC"        ,       100 ),
(   14198 , "SL"        ,       100 );
					

/*Routes table*/

 insert into  routes (RouteId,OriginStationId,DestinationStationId,DistanceInKms) values

(       1 ,              12 ,                   13 ,           362 ),
(       2 ,              13 ,                   12 ,           362 ),
(       3 ,              12 ,                   14 ,           500 ),
(       4 ,              15 ,                   12 ,           350 ),
(       5 ,              12 ,                   15 ,           350 );
			


 

/* Train route maps*/

insert into  trainroutemaps (RouteId,TrainNo,ArrivalTime,DepartureTime,DurationInMins)values

(       1 ,   12577 , "20:40:00"    , "14:20:00"      ,            380 ),
(       1 ,   12607 , "21:35:00"    , "15:30:00"      ,            365 ),
(       1 ,   12609 , "20:05:00"    , "13:35:00"      ,            390 ),
(       1 ,   12639 , "14:00:00"    , "07:50:00"      ,            370 ),
(       2 ,   12610 , "14:30:00"    , "08:00:00"      ,            390 ),
(       2 ,   12658 , "04:40:00"    , "22:40:00"      ,            360 ),
(       3 ,   22682 , "08:20:00"    , "23:30:00"      ,            530 ),
(       4 ,   16198 , "05:30:00"    , "20:30:00"      ,            540 ),
(       5 ,   14198 , "06:30:00"    , "21:30:00"      ,            540 );
				  
				   

insert into  bookings (BookingRefNo,RouteId,TrainNo,CoachCode,DateOfJourney,DateOfBooking,NoOfTickets)values
         (500 ,       1 ,   12577 , "1A"        , "2005-04-28"    , "2005-02-14"    ,           2 ),
         (501 ,       1 ,   12607 , "2A"        , "2005-03-20"    , "2005-03-10"    ,           2 ),
         (502 ,       1 ,   12609 , "CC"        , "2005-04-20"    , "2005-04-10"    ,          51 ),
         (503 ,       2 ,   12610 , "FC"        , "2006-12-20"    , "2007-01-10"    ,         150 ),
         (504 ,       2 ,   12610 , "CC"        , "2006-12-20"    , "2007-01-10"    ,         150 ),
         (505 ,       2 ,   12610 , "SL"        , "2006-12-20"    , "2007-01-10"    ,         150 ),
         (506 ,       2 ,   12610 , "2A"        , "2006-12-20"    , "2007-01-10"    ,         100 ),
         (507 ,       1 ,   12639 , "2A"        , "2015-02-20"    , "2015-02-14"    ,          10 ),
         (508 ,       2 ,   12658 , "3A"        , "2015-03-20"    , "2015-03-14"    ,          10 ),
         (509 ,       3 ,   22682 , "CC"        , "2015-04-20"    , "2015-04-14"    ,          10 ),
         (510 ,       4 ,   16198 , "FC"        , "2004-04-20"    , "2004-04-14"    ,          10 ),
         (511 ,       5 ,   14198 , "SL"        , "2004-06-20"    , "2004-06-14"    ,          10 ),
         (512 ,       5 ,   14198 , "3E"        , "2004-07-20"    , "2004-07-14"    ,           5 );
				
