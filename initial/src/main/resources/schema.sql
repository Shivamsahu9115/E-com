CREATE TABLE IF NOT EXISTS public.user
(
   id bigserial NOT NULL,
   firstname character varying(300) NOT NULL,
   lastname character varying(300) NOT NULL,
   email character varying(50) ,
   mobileno character varying(15) ,
   usertype smallint not null,
   username character varying(300) NOT NULL,
   password character varying(300) NOT NULL,
   CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.product
(
   id bigserial NOT NULL,
   name character varying(500) NOT NULL,
   category character varying(300) NOT NULL,
   imageLocation character varying(300) NOT NULL,
   price double precision NOT NULL,
   discountPercent double precision NOT NULL DEFAULT 0,
   description text,
   CONSTRAINT pk_product PRIMARY KEY (id)
);
