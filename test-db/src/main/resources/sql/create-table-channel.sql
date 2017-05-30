DROP TABLE IF EXISTS `channel`;
CREATE TABLE `channel` (
  `channel_id` 		INT 		    NOT NULL		  AUTO_INCREMENT,
  `name` 			    VARCHAR(64) NOT NULL,
  `description` 	TEXT 		    DEFAULT NULL,
  `date` 			    TIMESTAMP 	NOT NULL		  DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`channel_id`)
);
