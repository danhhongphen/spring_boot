create table todo (
    id serial not null,
    username character varying(64),
    description character varying(256),
    target_date timestamp without time zone,
    done boolean,
    CONSTRAINT todo_pk PRIMARY KEY (id)
);