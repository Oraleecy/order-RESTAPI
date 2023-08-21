DO $$
    BEGIN
        DROP TABLE Order_Product;
    EXCEPTION
        WHEN OTHERS THEN NULL;
    end $$;

DO $$
    BEGIN
        DROP TABLE Product;
    EXCEPTION
        WHEN OTHERS THEN NULL;
    end $$;


DO $$
    BEGIN
        DROP TABLE "Order";
    EXCEPTION
        WHEN OTHERS THEN NULL;
    end $$;
