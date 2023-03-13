CREATE TABLE person
(
    id         bigint AUTO_INCREMENT,
    surname    varchar(100) NOT NULL,
    given_name varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE country
(
    id               bigint AUTO_INCREMENT,
    name             varchar(100),
    head_of_state_id bigint NOT NULL REFERENCES person (id),
    PRIMARY KEY (id)
);
