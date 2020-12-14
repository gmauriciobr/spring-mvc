use lojadb;

CREATE TABLE pedido (
  id INT NOT NULL auto_increment,
  status_pedido varchar(1),
  nome varchar(250),
  valor double,
  data_entrega date,
  url_produto varchar(250),
  url_imagem varchar(250),
  descricao varchar(250),
  PRIMARY KEY (id)
);
