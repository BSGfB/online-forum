/*create table `role` (
  `role_id`		int 			    not null auto_increment,
  `name` 	    varchar(50)		not null unique,
  primary key (`role_id`)
);

create table `user` (
  `user_id` 					int(11) 		  not null 		auto_increment,
  `image`  				    varchar(128) 	not null,
  `email` 				    varchar(128) 	not null  	unique,
  `email_verified` 		tinyint(1) 		not null		default 0,
  `password` 			    varchar(128) 	not null,
  `nick` 				      varchar(20) 	not null		unique,
  `registration_date`	timestamp 		not null		default current_timestamp,
  `karma`				      float			    not null  	default 0.0,
  `role_id` 				  int				    not null		default 0,
  primary key (`user_id`)
);
*/

/*
create table `channel` (
  `channel_id` 		int 		    not null 		  auto_increment,
  `name` 			    varchar(64) not null,
  `description` 	text 		    default null,
  `date` 			    timestamp 	not null		  default current_timestamp,
  primary key (`channel_id`)
);
*/
/*
create table `thread` (
  `thread_id` 	int 		    not null 		  auto_increment,
  `channel_id`	int 		    not null,
  `name` 			  varchar(64) not null,
  `description` text 		    default null,
  `date` 			  timestamp 	not null		  default current_timestamp,
  primary key (`thread_id`)
);

create table `post` (
  `post_id` 				int 		    not null 		  auto_increment,
  `parent_post_id` 	int 		    default null,
  `thread_id`		    int 		    not null,
  `user_id`			    int 		    not null,
  `title` 			    varchar(64) not null,
  `content` 			  text 		    default null,
  `date` 			      timestamp 	not null		  default current_timestamp,
  primary key (`post_id`)
);

alter table `user`
  add foreign key (`role_id`) references `role`(`role_id`);

alter table `thread`
  add foreign key (`channel_id`) references `channel`(`channel_id`);

alter table `post`
  add foreign key (`thread_id`) references `thread`(`thread_id`),
  add foreign key (`user_id`) references `user`(`user_id`),
  add foreign key (`parent_post_id`) references `post`(`post_id`);
*/