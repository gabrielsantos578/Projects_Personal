/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Alunos
 * Created: 09/08/2022
 */

CREATE TABLE TestDT(
    idTest serial primary key,
    dateTest date,
    timeTest time 
);

CREATE TABLE TestLO(
    idTest serial primary key,
    nome char[100]
);

INSERT INTO TEST VALUES (id, 'aaaa-mm-dd', 'hh:mm:ss');



CREATE TABLE TestDT(
    idTest serial primary key,
    dateTest varchar(11),
    timeTest varchar(9) 
);

CREATE TABLE TestLO(
    idTest serial primary key,
    nome varchar(100)
);