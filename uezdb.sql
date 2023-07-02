-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 02/07/2023 às 20:04
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `uezdb`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(7) NOT NULL,
  `nomeCliente` varchar(255) NOT NULL,
  `emailCliente` varchar(255) NOT NULL,
  `senhaCliente` varchar(50) NOT NULL,
  `cpfCliente` varchar(14) NOT NULL,
  `rgCliente` varchar(13) DEFAULT NULL,
  `cepCliente` varchar(9) DEFAULT NULL,
  `numerocasaCliente` varchar(255) DEFAULT NULL,
  `historicocriminalCliente` text DEFAULT NULL,
  `datacadCliente` varchar(30) DEFAULT NULL,
  `telefoneCliente` varchar(20) DEFAULT NULL,
  `aprovacaoCliente` tinyint(4) DEFAULT 0,
  `avaliacaoCliente` double NOT NULL DEFAULT 5,
  `situacaoCliente` varchar(25) NOT NULL DEFAULT 'Ativo',
  `motivobanCliente` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nomeCliente`, `emailCliente`, `senhaCliente`, `cpfCliente`, `rgCliente`, `cepCliente`, `numerocasaCliente`, `historicocriminalCliente`, `datacadCliente`, `telefoneCliente`, `aprovacaoCliente`, `avaliacaoCliente`, `situacaoCliente`, `motivobanCliente`) VALUES
(1, 'Renato', 'renato@gmail.com', 'renatouzer', '187.999.999-20', '11.111.111-1', '25225-225', '98', 'hmm', '2011-11-01', '1111111111', 0, 5, 'Banido', 'Avaliação baixa'),
(2, 'Matheus', 'matheus@gmail.com', 'matheus123', '999.999.999-99', '11.111.111-1', '29092-222', '12', 'bla bla bla', '0000-00-00', '9182323123', 0, 5, 'Ativo', '111'),
(3, 'Caio Reges', 'reges@email.com', 'reges', '198.897.079-66', '11.930-403-45', '25225-210', '91', 'nulo', '20:05:00 01/07/2023', '+55 21 91208-2222', 0, 5, 'Ativo', NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idFuncionario` int(7) NOT NULL,
  `nomeFuncionario` varchar(255) NOT NULL,
  `emailFuncionario` varchar(255) NOT NULL,
  `senhaFuncionario` varchar(50) NOT NULL,
  `telefoneFuncionario` varchar(20) DEFAULT NULL,
  `cpfFuncionario` varchar(14) NOT NULL,
  `rgFuncionario` varchar(13) DEFAULT NULL,
  `cargoFuncionario` varchar(255) DEFAULT NULL,
  `datacadFuncionario` text DEFAULT NULL,
  `situacaoFuncionario` text DEFAULT 'Ativo',
  `motivodemicaoFuncionario` text DEFAULT NULL,
  `aprovacao` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `funcionario`
--

INSERT INTO `funcionario` (`idFuncionario`, `nomeFuncionario`, `emailFuncionario`, `senhaFuncionario`, `telefoneFuncionario`, `cpfFuncionario`, `rgFuncionario`, `cargoFuncionario`, `datacadFuncionario`, `situacaoFuncionario`, `motivodemicaoFuncionario`, `aprovacao`) VALUES
(0, 'João David', 'joaodavid@gmail.com', 'david', '+55 (21)98296-4498', '187.600.677-30', '82.394.733-4', 'Dev Desktop', '17:01:57 28/06/2023', 'Ativo', 'nulo', 1),
(1, 'Renato Gomes', '1111111111111', '111', '+11 (11)11111-1111', '111.111.111-11', '11.111.111-1', 'Moderador', '15:45:50 28/06/2023', 'Ativo', 'nulo', 1),
(2, 'Matheus', 'matheus@gmail.com', 'matheus', '+66(21)21212-1212', '189.209.328-23', '92.027.380-9', 'Designer', '16:50:06 28/06/2023', 'Ativo', 'nulo	', 0),
(4, 'Yago Estevão', 'estevão@gmail.com', 'estevao', '+66(21)21212-1212', '189.209.328-23', '92.027.380-9', 'Sei lá', '16:50:06 28/06/2023', 'Ativo', 'nulo	', 0),
(5, 'Neemias', 'Neemias@gmail.com', 'neemias', '+66(21)21212-1212', '189.209.328-23', '92.027.380-9', 'Sei lá', '16:50:06 28/06/2023', 'Ativo', 'nulo	', 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `pedido`
--

CREATE TABLE `pedido` (
  `idPedido` int(7) NOT NULL,
  `datacriacaoPedido` date DEFAULT NULL,
  `idUzerPedido` int(7) DEFAULT NULL,
  `statusPedido` varchar(255) DEFAULT NULL,
  `servicoPedido` varchar(255) DEFAULT NULL,
  `idUezerPedido` int(7) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `servico`
--

CREATE TABLE `servico` (
  `idServico` int(7) NOT NULL,
  `nomeServico` varchar(255) NOT NULL,
  `adomicilioServico` tinyint(1) DEFAULT NULL,
  `adistanciaServico` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `uzer`
--

CREATE TABLE `uzer` (
  `idUzer` int(7) NOT NULL,
  `nomeUzer` varchar(255) NOT NULL,
  `emailUzer` varchar(255) NOT NULL,
  `senhaUzer` varchar(50) NOT NULL,
  `telefoneUzer` varchar(20) DEFAULT NULL,
  `cpfUzer` varchar(14) NOT NULL,
  `rgUzer` varchar(13) DEFAULT NULL,
  `cepUzer` varchar(9) DEFAULT NULL,
  `numerocasaUzer` varchar(255) DEFAULT NULL,
  `historicocriminalUzer` text DEFAULT NULL,
  `bioUzer` varchar(255) DEFAULT NULL,
  `datacadUzer` varchar(25) DEFAULT NULL,
  `idServico` int(7) DEFAULT NULL,
  `aprovacaoUzer` text DEFAULT '\'pendente\'',
  `situacaoUzer` varchar(25) NOT NULL DEFAULT 'Ativo',
  `avaliacaoUzer` double NOT NULL DEFAULT 5,
  `motivobanUzer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `uzer`
--

INSERT INTO `uzer` (`idUzer`, `nomeUzer`, `emailUzer`, `senhaUzer`, `telefoneUzer`, `cpfUzer`, `rgUzer`, `cepUzer`, `numerocasaUzer`, `historicocriminalUzer`, `bioUzer`, `datacadUzer`, `idServico`, `aprovacaoUzer`, `situacaoUzer`, `avaliacaoUzer`, `motivobanUzer`) VALUES
(2, 'Renato', 'renato@gmail.com', 'renatouzer', '187.999.999-20', '11.111.111-1', '25225-225', '98', 'hmm', '11111', '1111111111', '0000-00-00', NULL, '1', 'Banido', 5, '111111');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Índices de tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- Índices de tabela `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `idUzerPedido` (`idUzerPedido`),
  ADD KEY `idUezerPedido` (`idUezerPedido`);

--
-- Índices de tabela `servico`
--
ALTER TABLE `servico`
  ADD PRIMARY KEY (`idServico`);

--
-- Índices de tabela `uzer`
--
ALTER TABLE `uzer`
  ADD PRIMARY KEY (`idUzer`),
  ADD KEY `idServico` (`idServico`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idFuncionario` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111116;

--
-- AUTO_INCREMENT de tabela `servico`
--
ALTER TABLE `servico`
  MODIFY `idServico` int(7) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `uzer`
--
ALTER TABLE `uzer`
  MODIFY `idUzer` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`idUzerPedido`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`idUezerPedido`) REFERENCES `uzer` (`idUzer`);

--
-- Restrições para tabelas `uzer`
--
ALTER TABLE `uzer`
  ADD CONSTRAINT `uzer_ibfk_1` FOREIGN KEY (`idServico`) REFERENCES `servico` (`idServico`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
