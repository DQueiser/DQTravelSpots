delete from pointofinterest;
delete from usertrips;
delete from role;
delete from user;
INSERT INTO `user` VALUES (1,'Dave','Queiser', 'dqueiser@gmail.com','dqueiser','Superstrong1','2019-10-13')
INSERT INTO `user` VALUES (2,'Mark','Watney', 'mars1@rover.com','mwatney','BotanyPowersRule','2019-10-15 12:34:56')
INSERT INTO `role` VALUES (1, 'Admin', 'dqueiser', 1)
INSERT INTO `role` VALUES (2, 'User', 'mwatney', 2)
INSERT INTO `usertrips` VALUES (1,2,'ACIDPLANIT','3', 'A bit barren. Homegrown potatoes are good, but a bit musty.','2019-10-15 12:34:56')
INSERT INTO `pointofinterest` VALUES (1,1,'ACIDPLANIT','That Cool Greenhouse', 'A greenhouse which is really old and made of iron and is green.','Definitely a photo spot.','www.somethingiamadeup.com','2019-10-17 12:34:56')
INSERT INTO `pointofinterest` VALUES (2,1,'ACIDPLANIT','Pathfinder', 'An old rover','In a pinch, this will save your life.','www.somethingelseiamadeup.com','2019-10-17 12:34:56')