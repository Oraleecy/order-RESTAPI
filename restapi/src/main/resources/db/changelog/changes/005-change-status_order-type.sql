ALTER TABLE "order" ALTER COLUMN status SET DEFAULT('CREATED');
CREATE TYPE order_status as enum('CREATED','PROCESSING','DELIVERED');
ALTER TABLE "order" ALTER COLUMN status set DEFAULT('CREATED');