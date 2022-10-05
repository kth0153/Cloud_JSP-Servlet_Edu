USE STUDY;
DESC TBOARD_PART;
SELECT * FROM TBOARD_PART;
-- #####################################################################################
DROP TABLE IF EXISTS TBOARD_PART;
CREATE TABLE IF NOT EXISTS TBOARD_PART (
	FIDX		TINYINT			NOT NULL					COMMENT 'P/K, 머릿글 번호',
    FPART		NVARCHAR(4)		NOT NULL					COMMENT '머릿글',
    PRIMARY KEY (FIDX)
) COMMENT='게시판의 글머릿글에 사용';

INSERT INTO TBOARD_PART VALUES 
('1', '학습'), ('2', '생활'), ('3', '취업'), ('4', '고민'), ('5', '과정');
SELECT * FROM TBOARD_PART;

SELECT FIDX, FPART FROM TBOARD_PART ORDER BY fidx desc limit 0,10;

-- #####################################################################################

DROP TABLE IF EXISTS TBOARD;
CREATE TABLE IF NOT EXISTS TBOARD (
	FIDX		INT					NOT NULL				COMMENT '일련번호, P/K, ',
    FNUM		INT					NOT NULL	DEFAULT 0	COMMENT '목록번호(질문), 답글의 경우 0',
    FGROUP		INT					NOT NULL				COMMENT '그룹번호, 1차 정렬 필드, 질문은 자신의 FIDX, 답글은 선택글의 FGROUP번호',
    FLEVEL		INT					NOT NULL	DEFAULT 0	COMMENT '질문은 0, 답글은 선택한 글의 FLEVEL+1',
    FSTEP		INT					NOT NULL				COMMENT '2차 정렬 필드, 질문은 0, 답글은 그룹내 선택한 목록의 FSTEP 이상인 글은 모두 1증가 이후 선택 목록의 FSTEP값을 갖는다, ',
    FTOP		ENUM('Yes', 'No')	NOT NULL				COMMENT '상단노출, 1페이지 상단에 노출하고자 하는 목록은 Yes(1)',
    FPARTIDX	TINYINT				NOT NULL				COMMENT '머릿글, 별도의 테이블을 만들어 관리, fk_tboard_fpartidx_tboardPart_fidx',
    FSUBJECT	NVARCHAR(50)		NOT NULL				COMMENT '게시판의 제목 필드',
    FCONTENT	TEXT				NOT NULL				COMMENT '게시판의 내용 필드',
    FID			VARCHAR(20)									COMMENT '회원의 경우 아이디 저장, 이름은 회원명 저장, 비밀번호는 저장하지 않음',
    FNAME		NVARCHAR(20)		NOT NULL				COMMENT '작성자 이름, 회원의 경우 회원명 저장(Join으로 인한 검색속도 저하문제 보완)',
    FPASSW		VARCHAR(20)			NULL					COMMENT '삭제 수정을 위한 비밀번호, 회원의 경우 Null',
    FHIT		SMALLINT			NOT NULL	DEFAULT 0	COMMENT '글 조횟수',
    FDELETED	ENUM('Yes', 'No')	NOT NULL				COMMENT '작성자에 의해 삭제된 경우(1, Yes)',
    FDATE		DATETIME			NOT NULL				COMMENT '24시간 이내의 글은 new표시',
	PRIMARY KEY (FIDX),
    FOREIGN KEY	(FPARTIDX)		REFERENCES	TBOARD_PART (FIDX)
    ON UPDATE CASCADE
) COMMENT='JSP&SERVLET을 활용한 Q&A 게시판 수업을 위한 게시글 정보 테이블';
SELECT IFNULL(max(fidx)+1,1) aidx, IFNULL(max(FNUM)+1,1) anum from TBOARD;
select * from TBOARD;

delete from tboard where fidx>0;

delete from TBOARD_FILE where fidx>0;

-- #####################################################################################
DROP TABLE IF EXISTS TBOARD_FILE;
CREATE TABLE IF NOT EXISTS TBOARD_FILE (
	FIDX		INT					NOT NULL				COMMENT '일련번호, P/K',
    FBOARDIDX	INT					NOT NULL				COMMENT 'F/K, 게시판의 목록 FIDX',
    FFILENAME	VARCHAR(30)			NOT NULL				COMMENT '업로드된 파일의 원래 이름',
    FSAVENAME	VARCHAR(30)			NOT NULL				COMMENT '업로드된 파일의 저장된 이름',
    FFILESIZE	INT					NOT NULL				COMMENT '업로드된 파일의 크기',
    FDOWNLOAD	INT					NOT NULL	DEFAULT 0	COMMENT '다운로드 수' ,
    PRIMARY KEY (FIDX)
 --   FOREIGN KEY (FBOARDIDX)		REFERENCES	TBOARD (FIDX)
) COMMENT='게시글에 파일을 첨부할 경우 다중 파일 업로드가 가능하도록 별도의 테이블로 관리';

-- auto_increment가 설정되지 않았기에 fidx 값을 구해야 함
select IFNULL(max(fidx)+1,1) aidx from TBOARD_FILE;
select * from tboard_file;
insert into TBOARD_FILE(FIDX,FBOARDIDX,FFILENAME,FSAVENAME,FFILESIZE)
values('1','1','memo.txt','memo.txt','1024'),
('2','1','memo.txt','memo.txt','1024'),
('3','1','memo.txt','memo.txt','1024'),
('4','1','memo.txt','memo.txt','1024'),
('5','1','memo.txt','memo.txt','1024');

select * from TBOARD_FILE order by fidx desc;

-- java에서 작성 법
-- "insert into TBOARD_FILE(FIDX,FBOARDIDX,FFILENAME,FSAVENAME,FFILESIZE)"
-- + "values('"+idx+"','1','"+orgName+"','"+regFileName+"','"+fileSize+"');";

desc TBOARD_FILE;
show tables;

select IFNULL(max(fidx)+1,1) aidx, IF(max(fboardidx)<1,max(fboardidx)+1,max(fboardidx)+1)aboardidx from TBOARD_FILE;



insert into TBOARD_FILE(FIDX,FBOARDIDX,FFILENAME,FSAVENAME,FFILESIZE) 
values('6','1','01_JSP&Servlet.pdf','01_JSP&Servlet2.pdf','4070275'),
('6','1','test.txt','test8.txt','9'),
('6','1','화면 캡처 2022-09-26 154422.png','화면 캡처 2022-09-26 1544227.png','24765');