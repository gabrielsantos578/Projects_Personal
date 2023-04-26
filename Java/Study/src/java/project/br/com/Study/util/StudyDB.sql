/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Alunos
 * Created: 09/08/2022
 */

Create table Produto (
    codigoProduto serial unique primary key,
    nomeProduto varchar(50) not null,
    precoProduto numeric(7,2) not null,
    quantidadeEstoque numeric(3,0) not null
);

Create table Compra (
    codigoCompra serial unique primary key,
    valorFinal numeric(8,2) not null
);

Create table Item (
    codigoItem serial unique primary key,
    codigoCompra int not null,
    codigoProduto int not null,
    quantidadeItem numeric(3,0) not null,
    valorTotal numeric(8,2) not null,
    constraint fk_Compra_Item foreign key (codigoCompra) references Compra(codigoCompra),
    constraint fk_Produto_Item foreign key (codigoProduto) references Produto(codigoProduto)
);
