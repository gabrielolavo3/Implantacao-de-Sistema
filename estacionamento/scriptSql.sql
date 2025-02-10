CREATE SCHEMA IF NOT EXISTS bancoEstacionamento;
USE bancoEstacionamento;

CREATE TABLE IF NOT EXISTS Usuario (
  `idUsuario` INT PRIMARY KEY AUTO_INCREMENT,
  `nomeLogin` VARCHAR(25) NOT NULL,
  `senha` VARCHAR(8) NOT NULL
);

CREATE TABLE IF NOT EXISTS Veiculo (
  `Placa` VARCHAR(7) PRIMARY KEY,
  `Cor` VARCHAR(12) NOT NULL,
  `Modelo` VARCHAR(20) NOT NULL,
  `Porte` VARCHAR(10) NOT NULL  
);

CREATE TABLE IF NOT EXISTS Ticket (
  `idTicket` INT AUTO_INCREMENT,
  `codigoIdentificacao` VARCHAR(10) NOT NULL,
  `Veiculo_Placa` VARCHAR(7) NOT NULL,
  
  PRIMARY KEY (`idTicket`, `Veiculo_Placa`),
  CONSTRAINT `fk_Ticket_Veiculo1` FOREIGN KEY (`Veiculo_Placa`) REFERENCES `Veiculo` (`Placa`)
  ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Vaga (
  `idVaga` INT PRIMARY KEY AUTO_INCREMENT,
  `situacaoVaga` VARCHAR(10) NOT NULL,
  `Veiculo_Placa` VARCHAR(7) NULL,  
  
  CONSTRAINT `fk_Vaga_Veiculo1` FOREIGN KEY (`Veiculo_Placa`) REFERENCES `Veiculo` (`Placa`)
  ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Movimentacao (
  `idMovimentacao` INT AUTO_INCREMENT,
  `Entrada` INT NOT NULL,
  `Saida` INT NOT NULL,
  `Veiculo_Placa` VARCHAR(7),
  PRIMARY KEY (`idMovimentacao`, `Veiculo_Placa`),
  
  CONSTRAINT `fk_Movimentacao_Veiculo1` FOREIGN KEY (`Veiculo_Placa`) REFERENCES `Veiculo` (`Placa`)
  ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Pagamento (
  `idPagamento` INT AUTO_INCREMENT,
  `Valor` FLOAT NOT NULL,
  `Horario` INT NOT NULL,
  `tipoPagamento` VARCHAR(15) NOT NULL,
  `Veiculo_Placa` VARCHAR(7),
  `Vaga_idVaga` INT,
  PRIMARY KEY (`idPagamento`, `Veiculo_Placa`, `Vaga_idVaga`),
  
  CONSTRAINT `fk_Pagamento_Veiculo1` FOREIGN KEY (`Veiculo_Placa`) REFERENCES `Veiculo` (`Placa`) 
  ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Pagamento_Vaga` FOREIGN KEY (`Vaga_idVaga`) REFERENCES `Vaga` (`idVaga`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS Relatorio (
  `idRelatorio` INT AUTO_INCREMENT,
  `Horario` INT NULL,
  `Veiculo_Placa` VARCHAR(7),
  `Pagamento_idPagamento` INT,
  `Ticket_idTicket` INT,
  `Vaga_idVaga` INT,  
  PRIMARY KEY (`idRelatorio`, `Veiculo_Placa`, `Pagamento_idPagamento`, `Ticket_idTicket`, `Vaga_idVaga`),

  CONSTRAINT `fk_Relatorio_Veiculo1` FOREIGN KEY (`Veiculo_Placa`) REFERENCES `Veiculo` (`Placa`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Relatorio_Pagamento1` FOREIGN KEY (`Pagamento_idPagamento`) REFERENCES `Pagamento` (`idPagamento`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Relatorio_Ticket1` FOREIGN KEY (`Ticket_idTicket`) REFERENCES `Ticket` (`idTicket`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Relatorio_Vaga1` FOREIGN KEY (`Vaga_idVaga`) REFERENCES `Vaga` (`idVaga`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);
