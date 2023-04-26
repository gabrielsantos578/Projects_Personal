/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Alunos
 * Created: 09/08/2022
 */

create table Usuario(
   idUsuario serial primary key,
   nomeUsuario varchar(200) unique not null, 
   emailUsuario varchar(200) unique not null,
   senhaUsuario varchar(50) not null
);

create table Cliente(
   codigoCliente serial primary key,
   codigoUsuario int not null,
   nomeCliente varchar(200) not null,
   cpf varchar(14) unique not null,
   cep varchar(9) not null,
   cidade varchar(50) not null,
   rua varchar(100) not null,
   bairro varchar(100) not null,
   numCasa varchar(5) not null,
   constraint fk_Usuario_Cliente foreign key (codigoUsuario) references Usuario(idUsuario)
);

create table Categoria(
   codigoCategoria serial primary key,
   nomeCategoria varchar(50) unique not null 
);

create table Marca(
   codigoMarca serial primary key,
   nomeMarca varchar(50) unique not null 
);

create table Produto(
   codigoProduto serial primary key,
   nomeProduto varchar(200) not null,
   descricaoProduto varchar(1000) not null,
   codigoCategoria int not null,
   codigoMarca int not null,
   loteProduto varchar(12) not null,
   precoProduto numeric(7,2) not null,
   dataFabricacao varchar(10) not null,
   quantidadeEstoque numeric(7,3) not null,
   constraint fk_Categoria_Produto foreign key (codigoCategoria) references Categoria(codigoCategoria),
   constraint fk_Marca_Produto foreign key (codigoMarca) references Marca(codigoMarca)
);

create table Venda(
   codigoVenda serial primary key,
   nomeCliente varchar(200) not null,
   cpfCliente varchar(14) unique not null,
   valorFinal numeric(7,2),
   dataVenda varchar(10) not null
);

create table Item(
   idItem serial primary key,
   codigoVenda int not null,
   codigoProduto int not null,
   quantidadeTotal numeric(6,3) not null,
   precoTotal numeric(7,2) not null,
   constraint fk_Venda_Itens foreign key (codigoVenda) references Venda(codigoVenda),
   constraint fk_Produto_Itens foreign key (codigoProduto) references Produto(codigoProduto) 
);
