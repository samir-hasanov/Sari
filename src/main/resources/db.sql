CREATE TABLE IF NOT EXISTS public.salon
(
    active integer DEFAULT 1,
    barbar_id_id bigint,
    data_date timestamp(6) without time zone,
    id bigint NOT NULL DEFAULT nextval('salon_id_seq'::regclass),
    address character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    path character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT salon_pkey PRIMARY KEY (id),
    CONSTRAINT fkfloxjogh5rl6veuppp6gs1xok FOREIGN KEY (barbar_id_id)
    REFERENCES public.barbar (id) MATCH SIMPLE
                           ON UPDATE NO ACTION
                           ON DELETE NO ACTION
    )
//////////////////////////////////////////////
CREATE TABLE IF NOT EXISTS public.barbar
(
    active integer DEFAULT 1,
    data_date timestamp(6) without time zone,
    gender_id_id bigint,
    id bigint NOT NULL DEFAULT nextval('barbar_id_seq'::regclass),
    email character varying(255) COLLATE pg_catalog."default",
    image character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    phone character varying(255) COLLATE pg_catalog."default",
    surname character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT barbar_pkey PRIMARY KEY (id),
    CONSTRAINT fkthcf1jya8y7aeunv07dc9k2v4 FOREIGN KEY (gender_id_id)
    REFERENCES public.gender (id) MATCH SIMPLE
                           ON UPDATE NO ACTION
                           ON DELETE NO ACTION
    )
//////////////////////////////////////////////
CREATE TABLE IF NOT EXISTS public.gender
(
    active integer DEFAULT 1,
    id bigint NOT NULL DEFAULT nextval('gender_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT gender_pkey PRIMARY KEY (id)
    )

//////////////////////////////////////////////////////////////////

CREATE TABLE IF NOT EXISTS public.appointment
(
    id bigint NOT NULL DEFAULT nextval('appointment_id_seq'::regclass),
    appointment_date date,
    appointment_end_time time(6) without time zone,
    appointment_start_time time(6) without time zone,
    created_at timestamp(6) without time zone,
    data_date timestamp(6) without time zone,
    status smallint,
    barbar_id_id bigint,
    user_phone_id_id bigint,
    CONSTRAINT appointment_pkey PRIMARY KEY (id),
    CONSTRAINT uk_grc7m49sergykhk2g388tsou3 UNIQUE (user_phone_id_id),
    CONSTRAINT fk3hs5xi7xmh3tvx8pwgajj8cnh FOREIGN KEY (user_phone_id_id)
    REFERENCES public.user_phone (id) MATCH SIMPLE
                                 ON UPDATE NO ACTION
                                 ON DELETE NO ACTION,
    CONSTRAINT fkc16k7da1oyo22he2eucl4kh1r FOREIGN KEY (barbar_id_id)
    REFERENCES public.barbar (id) MATCH SIMPLE
                                 ON UPDATE NO ACTION
                                 ON DELETE NO ACTION,
    CONSTRAINT appointment_status_check CHECK (status >= 0 AND status <= 1)
    )

///////////////////////////////////////////////////////
CREATE TABLE IF NOT EXISTS public.user_phone
(
    id bigint NOT NULL DEFAULT nextval('user_phone_id_seq'::regclass),
    phone character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT user_phone_pkey PRIMARY KEY (id)
    )
