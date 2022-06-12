CREATE TABLE IF NOT EXISTS pet_names (
    id SERIAL NOT NULL,
    name VARCHAR(255) NOT NULL,
    species VARCHAR(255) NOT NULL,
    gender VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

insert into pet_names (name, species, gender) values ('dogMale', 'dog', 'male');
insert into pet_names (name, species, gender) values ('dogFemale', 'dog', 'female');
insert into pet_names (name, species, gender) values ('catMale', 'cat', 'male');
insert into pet_names (name, species, gender) values ('catFemale', 'cat', 'female');