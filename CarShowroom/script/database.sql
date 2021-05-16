CREATE DATABASE showrooms
    WITH OWNER postgres;

DROP DATABASE showrooms;

SELECT *
FROM showroom
         INNER JOIN car c ON showroom.id = c.showroom_id
         INNER JOIN engine e ON c.engine_id = e.id;
