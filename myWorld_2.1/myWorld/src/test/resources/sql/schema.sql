drop table if exists `users`;

create table users (
  `firstName` varchar(40) NOT NULL,
  `middleName` varchar(20) DEFAULT NULL,
  `lastName` varchar(40) NOT NULL,
  `dob` date NOT NULL,
  `uuid` varchar(40) NOT NULL,
  `interests` text,
  `phoneNum` varchar(20) DEFAULT NULL,
  `gender` bit(1) NOT NULL,
  `relStatus` enum('1','2','3','4','5','6','7','8','9') DEFAULT NULL,
  `lang` text,
  `locations` text,
  `homeTown` text,
  `education` text,
  `about` text,
  `company` text,
  `email` varchar(256) NOT NULL,
  `timestamp` bigint(20) DEFAULT NULL,
  `friendsCount` int(11) DEFAULT '0',
  `disabled` enum('0','1') DEFAULT '0',
  `updatedTimestamp` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;