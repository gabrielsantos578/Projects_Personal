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

create table Empresa(
   codigoEmpresa serial primary key,
   codigoUsuario int not null,
   nomeEmpresa varchar(200) unique not null,
   cnpj varchar(18) unique not null,
   constraint fk_Usuario_Empresa foreign key (codigoUsuario) references Usuario(idUsuario)
);

create table Loja(
    idLoja serial primary key,
    codigoEmpresa int not null,
    cep varchar(9) not null,
    cidade varchar(50) not null,
    rua varchar(100) not null,
    bairro varchar(100) not null,
    numLoja varchar(5) not null,
    constraint fk_Empresa_Loja foreign key (codigoEmpresa) references Empresa(codigoEmpresa)
);

create table Colaborador(
   codigoColaborador serial primary key,
   codigoUsuario int not null,
   codigoEmpresa int not null,
   nomeColaborador varchar(200) not null,
   cpf varchar(14) unique not null,
   numTelefone varchar(16) not null,
   cep varchar(9) not null,
   cidade varchar(50) not null,
   rua varchar(100) not null,
   bairro varchar(100) not null,
   numCasa varchar(5) not null,
   constraint fk_Usuario_Colaborador foreign key (codigoUsuario) references Usuario(idUsuario),
   constraint fk_Empresa_Colaborador foreign key (codigoEmpresa) references Empresa(codigoEmpresa)
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
   /*codigoEmpresa int not null,
   codigoBarra int unique not null,*/
   nomeProduto varchar(200) not null,
   descricaoProduto varchar(1000) not null,
   codigoCategoria int not null,
   codigoMarca int not null,
   loteProduto int not null,
   precoProduto numeric(5,2) not null,
   /*dataFabricacao date not null,*/
   dataFabricacao varchar(10) not null,
   quantidadeEstoque numeric(4,3) not null,
   /*constraint fk_Empresa_Produto foreign key (codigoEmpresa) references Empresa(codigoEmpresa),*/
   constraint fk_Categoria_Produto foreign key (codigoCategoria) references Categoria(codigoCategoria),
   constraint fk_Marca_Produto foreign key (codigoMarca) references Marca(codigoMarca)
);

create table Venda(
   codigoVenda serial primary key,
   codigoCliente int not null,
   valorFinal numeric(5,2),
   dataVenda date not null,
   constraint fk_Cliente_Compra foreign key (codigoCliente) references Cliente(codigoCliente) 
);

create table Itens(
   idItens serial primary key,
   codigoVenda int not null,
   codigoProduto int not null,
   quantidadeTotal numeric(4,3) not null,
   precoTotal numeric(5,2) not null,
   constraint fk_Venda_Itens foreign key (codigoVenda) references Venda(codigoVenda),
   constraint fk_Produto_Itens foreign key (codigoProduto) references Produto(codigoProduto) 
);
