DROP TABLE FielMetaDataTable;
CREATE TABLE FielMetaDataTable
(
	fileId integer NOT NULL,
	fileName varchar(50),
	fileExtension varchar(20),
	fileSize BIGINT,
	fileAuthor varchar(50),
	uploadTime BIGINT,
	PRIMARY KEY(fileId)
);