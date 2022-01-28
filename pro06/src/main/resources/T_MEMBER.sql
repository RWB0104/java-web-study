-- 회원 테이블 생성
CREATE TABLE `T_MEMBER` (
    `ID` varchar(10) NOT NULL COMMENT '아이디',
    `PWD` varchar(10) NOT NULL COMMENT '비밀번호',
    `NAME` varchar(50) NOT NULL COMMENT '이름',
    `EMAIL` varchar(50) NOT NULL COMMENT '이메일',
    `JOINDATE` date NOT NULL DEFAULT sysdate() COMMENT '가입일자',
    PRIMARY KEY (`ID`)
)
ENGINE=InnoDB DEFAULT
CHARSET=utf8mb4
COMMENT='회원 정보';

-- 회원 정보 추가
INSERT INTO T_MEMBER(ID, PWD, NAME, EMAIL) VALUES('hong', '1212', '홍길동', 'hong@gmail.com');
INSERT INTO T_MEMBER(ID, PWD, NAME, EMAIL) VALUES('lee', '1212', '이순신', 'lee@test.com');
INSERT INTO T_MEMBER(ID, PWD, NAME, EMAIL) VALUES('kim', '1212', '김유신', 'kim@web.com');