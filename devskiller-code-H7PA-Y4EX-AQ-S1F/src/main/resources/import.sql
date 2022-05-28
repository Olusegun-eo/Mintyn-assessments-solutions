insert into streaming_platform (id, name, headquarter, website, launched) values (1, 'Netflix', 'Bahamas', 'www.netflix.com', '1997-08-29');
insert into streaming_platform (id, name, headquarter, website, launched) values (2, 'Amazon Prime', 'Aruba', 'www.amazon.com/prime', '2005-02-02');
insert into streaming_platform (id, name, headquarter, website, launched) values (3, 'Disney+', 'Canada', 'www.disneyplus.com', '2019-12-12');
insert into streaming_platform (id, name, headquarter, website, launched) values (4, 'Hulu', 'Canada', 'www.hulu.com', '2007-10-29');
insert into streaming_platform (id, name, headquarter, website, launched) values (5, 'Apple TV+', 'Costa Rica', 'www.apple.com/apple-tv-plus', '2019-11-01');
insert into streaming_platform (id, name, headquarter, website, launched) values (6, 'HBO Go', 'Panama', 'www.play.hbogo.com', '2010-02-18');
insert into streaming_platform (id, name, headquarter, website, launched) values (7, 'YouTube Premium', 'Grenada', 'www.youtube.com/premium', '2011-02-02');
insert into streaming_platform (id, name, headquarter, website, launched) values (8, 'DirectTV Now', 'Jamaica', 'www.d-now.com', '2015-04-06');
insert into streaming_platform (id, name, headquarter, website, launched) values (9, 'fuboTV', 'Panama', 'www.fubo.com/tv', '2012-12-02');
insert into streaming_platform (id, name, headquarter, website, launched) values (10, 'Hotstar', 'Panama', 'www.hotstar.com/premium', '2008-01-14');
insert into streaming_platform (id, name, headquarter, website, launched) values (11, 'Zee5', 'Canada', 'www.zee.com/premium-tv', '2007-02-02');
insert into streaming_platform (id, name, headquarter, website, launched) values (12, 'Now TY', 'Panama', 'www.nowtv.com', '2001-03-03');
insert into streaming_platform (id, name, headquarter, website, launched) values (13, 'Sling TV', 'Canada', 'www.slingtv.com/premium', '2018-11-11');
insert into streaming_platform (id, name, headquarter, website, launched) values (14, 'MercTV', 'Jamaica', 'www.merc.com/tv', '2004-05-05');
insert into streaming_platform (id, name, headquarter, website, launched) values (15, 'PlutoTV', 'Jamaica', 'www.pluto.com/tv', '2016-09-02');
insert into streaming_platform (id, name, headquarter, website, launched) values (16, 'Shudder', 'Bahamas', 'www.shudder.com', '2011-02-02');
insert into streaming_platform (id, name, headquarter, website, launched) values (17, 'Sky Go', 'Jamaica', 'www.sky-go.com', '2019-02-02');

insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (1, 'Stranger Things', 25, 98, 'SF', 1);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (2, 'Black Mirror', 22, 88, 'SF', 1);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (3, 'Mindhunter', 19, 99, 'THRILLER', 1);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (4, 'Peaky Blinders', 11, 78, 'THRILLER', 1);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (5, 'The Crown', 23, 84, 'DRAMA', 1);

insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (6, 'The Boys', 8, 60, 'ACTION', 2);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (7, 'Bosch', 10, 44, 'DRAMA', 2);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (8, 'Good Omens', 6, 69, 'FANTASY', 2);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (9, 'Greys Anatomy', 22, 49, 'DRAMA', 2);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (10, 'Supernatural', 31, 97, 'SF', 2);

insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (11, 'The Mandalorian', 11, 99, 'SF', 3);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (12, 'Monsters at Work', 14, 66, 'ANIMATION', 3);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (13, 'What If...?', 17, 12, 'ANIMATION', 3);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (14, 'Arrow', 3, 52, 'ACTION', 3);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (15, 'The Flash', 34, 72, 'ACTION', 3);

insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (16, 'Freakish', 23, 90, 'HORROR', 4);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (17, 'Harlots', 24, 92, 'DRAMA', 4);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (18, 'Future Man', 26, 33, 'ACTION', 4);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (19, 'The 100', 16, 13, 'SF', 4);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (20, 'Doctor Who', 16, 83, 'SF', 4);

insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (21, 'Ghostwriter', 13, 57, 'ACTION', 5);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (22, 'See', 14, 72, 'DRAMA', 5);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (23, 'Dickinson', 26, 33, 'DRAMA', 5);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (24, 'Peanuts - Snoopy in Space', 26, 13, 'ANIMATION', 5);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (25, 'Helpsters', 16, 83, 'ANIMATION', 5);

insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (26, 'Succession', 63, 45, 'DRAMA', 6);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (27, 'Watchmen', 14, 52, 'SF', 6);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (28, 'Big Little Lies', 45, 45, 'DRAMA', 6);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (29, 'Oz', 16, 13, 'ANIMATION', 6);
insert into series (id, title, number_of_episodes, score, type, streaming_platform_id) values (30, 'Barry', 16, 83, 'FANTASY', 6);