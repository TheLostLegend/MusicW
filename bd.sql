CREATE TABLE Player(
	PlayerID SERIAL NOT NULL CONSTRAINT PK_PlayerID PRIMARY KEY,
	Login  VARCHAR(100) UNIQUE NOT NULL,
	Email VARCHAR(100) NOT NULL,
	Password VARCHAR(20) NOT NULL,
	RegisterData TIMESTAMP NOT NULL,
	LastLoginData TIMESTAMP NOT NULL
);

CREATE TABLE Track(
	TrackID SERIAL NOT NULL CONSTRAINT PK_TrackID PRIMARY KEY,
	Title VARCHAR(100) UNIQUE NOT NULL,
	Duration  INTERVAL,
	LevelMap TEXT
);

CREATE TABLE Leaderboard(
	PlayerID INT CONSTRAINT FK_PlayerID REFERENCES Player (PlayerID) ON DELETE CASCADE,
	TrackID INT CONSTRAINT FK_TrackID REFERENCES Track (TrackID) ON DELETE CASCADE,
	Score Int
);

