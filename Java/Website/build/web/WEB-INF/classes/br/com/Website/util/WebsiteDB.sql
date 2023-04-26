/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sindicato
 * Created: 02/01/2023
 */

Create table Usuario(
    idUsuario serial primary key,
    nomeUsuario varchar(100) not null,
    emailUsuario varchar(100) unique not null,
    senhaUsuario varchar(30) not null
);

Create table Empresa(
    codigoEmpresa serial primary key,
    idUsuario int not null,
    senhaEmpresa varchar(30) not null,
    nomeEmpresa varchar(100) not null,
    cnpjEmpresa char(18) unique not null,
    descricaoEmpresa varchar(1000) not null,
    constraint fk_Usuario_Empresa foreign key (idUsuario) references Usuario(idUsuario)
);

Create table Loja(
    idLoja serial primary key,
    codigoEmpresa int not null,
    telefoneLoja varchar(16) not null,
    cepEndereco varchar(5) not null,
    cidadeEndereco varchar(30) not null,
    estadoEndereco varchar(30) not null,
    bairroEndereco varchar(50) not null,
    ruaEndereco varchar(50) not null,
    numEndereco varchar(5) not null,
    constraint fk_Empresa_Loja foreign key (codigoEmpresa) references Empresa(codigoEmpresa)
);

Create table Produto(
    codigoProduto serial primary key,
    codigoEmpresa int not null,
    nomeProduto varchar(70) not null,
    precoProduto numeric(7,2) not null,
    descricaoProduto varchar(1000) not null,
    constraint fk_Empresa_Produto foreign key (codigoEmpresa) references Empresa(codigoEmpresa)
);

Create table Cliente(
    codigoCliente serial primary key,
    idUsuario int not null,
    senhaCliente varchar(30) not null,
    nomeCliente varchar(100) not null,
    cpfCliente char(14) unique not null,
    telefoneCliente varchar(16) not null,
    cepEndereco varchar(5) not null,
    cidadeEndereco varchar(30) not null,
    estadoEndereco varchar(30) not null,
    bairroEndereco varchar(50) not null,
    ruaEndereco varchar(50) not null,
    numEndereco varchar(5) not null,
    constraint fk_Usuario_Cliente foreign key (idUsuario) references Usuario(idUsuario)
);

Create table Compra(
    codigoCompra serial primary key,
    cpfCliente char(14) not null,
    numPedido int not null,
    statusPedido varchar(12) not null,
    dataCompra varchar(10) not null,
    valorFinal numeric(7,2),
    constraint fk_Usuario_Compra foreign key (cpfCliente) references Cliente(cpfCliente)
);

Create table Item(
    idItem serial primary key,
    codigoCompra int not null,
    codigoProduto int not null,
    nomeProduto varchar(70) not null,
    precoProduto numeric(7,2) not null,
    quantidadeProduto int not null,
    valorTotal numeric(7,2),
    constraint fk_Compra_Item foreign key (codigoCompra) references Compra(codigoCompra),
    constraint fk_Produto_Item foreign key (codigoProduto) references Produto(codigoProduto)
);
