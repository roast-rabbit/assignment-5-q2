CREATE TABLE public.product (
                id SERIAL NOT NULL,
                name VARCHAR NOT NULL,
                CONSTRAINT product_id PRIMARY KEY (id)
);


CREATE TABLE public.order_1 (
                id SERIAL NOT NULL,
                date DATE NOT NULL,
                customer_name VARCHAR NOT NULL,
                CONSTRAINT order_id PRIMARY KEY (id)
);


CREATE TABLE public.order_detail (
                order_id INTEGER NOT NULL,
                product_id INTEGER NOT NULL,
                CONSTRAINT order_detail_key PRIMARY KEY (order_id, product_id)
);


ALTER TABLE public.order_detail ADD CONSTRAINT product_order_detail_fk
FOREIGN KEY (product_id)
REFERENCES public.product (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.order_detail ADD CONSTRAINT order_order_detail_fk
FOREIGN KEY (order_id)
REFERENCES public.order_1 (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
