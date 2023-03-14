
CREATE SEQUENCE IF NOT EXISTS public.students_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 922337203685477580711
    CACHE 1;

CREATE TABLE IF NOT EXISTS public.students
(
    id bigint NOT NULL DEFAULT nextval('students_id_seq'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    birthdate date,
    "number" integer,
    CONSTRAINT students_pkey PRIMARY KEY (id)
);
