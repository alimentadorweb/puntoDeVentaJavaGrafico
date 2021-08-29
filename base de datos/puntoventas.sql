-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 26-11-2019 a las 15:45:50
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 5.6.39

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `puntoventas-jlat`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblcliente`
--

CREATE TABLE `tblcliente` (
  `NoCuenta` int(4) NOT NULL,
  `Nombre` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `Direccion` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  `Rfc` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `Colonia` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `Comunidad` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `Municipio` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `CodigoPostal` varchar(12) DEFAULT NULL,
  `Tarifa` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `FechaRegistro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tblcliente`
--

INSERT INTO `tblcliente` (`NoCuenta`, `Nombre`, `Direccion`, `Telefono`, `Rfc`, `Colonia`, `Comunidad`, `Municipio`, `CodigoPostal`, `Tarifa`, `FechaRegistro`) VALUES
(1, 'joaquin martinez comelon', 'col. flavio crespo calle independencia s/n', '345', '345', 'r434r43', 'Los chipibos', 'desconocido', '34234', 'Industrial', '2010-08-11'),
(2, 'cliende demo', 'dicrecosma', '2463554', '2548', 'desconcocis', 'mucniso', 'oijasd', '055', 'Especial', '2014-03-17'),
(3, 'David Arriaga', 'San Salvador, El Salvador, Centro America', '2222222', '17498393', 'san salvador', 'uno', 'sansalvador', '1294', 'Industrial', '2019-11-26');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblorden`
--

CREATE TABLE `tblorden` (
  `NoOrden` int(4) NOT NULL,
  `Fecha` date DEFAULT NULL,
  `NoCuenta` int(4) DEFAULT NULL,
  `Tipo` varchar(15) CHARACTER SET latin1 DEFAULT NULL,
  `Inspector` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `MotivoCorte` varchar(50) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tblorden`
--

INSERT INTO `tblorden` (`NoOrden`, `Fecha`, `NoCuenta`, `Tipo`, `Inspector`, `MotivoCorte`) VALUES
(1, '2010-07-15', 1, 'reconexion', 'juan hernandez hernandez', 'a cubierto su pago'),
(2, '2010-08-10', 2, 'RECONEXION', 'joe', 'ya pago'),
(3, '2011-08-10', 2, 'corte', 'changoleon', 'no paga'),
(4, '2011-08-10', 1, 'corte', 'utito', 'asda');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblpago`
--

CREATE TABLE `tblpago` (
  `ClvFolio` int(4) NOT NULL,
  `NoCuenta` int(4) DEFAULT NULL,
  `FechaCubierta` date DEFAULT NULL,
  `MesesTranscurridos` int(4) DEFAULT NULL,
  `FechaDePago` date DEFAULT NULL,
  `Rezago` float(4,0) DEFAULT NULL,
  `PagoCalculado` float(4,0) DEFAULT NULL,
  `Recargo` float(4,0) DEFAULT NULL,
  `Total` float(4,0) DEFAULT NULL,
  `FechaDeRegistro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tblpago`
--

INSERT INTO `tblpago` (`ClvFolio`, `NoCuenta`, `FechaCubierta`, `MesesTranscurridos`, `FechaDePago`, `Rezago`, `PagoCalculado`, `Recargo`, `Total`, `FechaDeRegistro`) VALUES
(1, 1, '2009-08-10', 12, '2010-08-10', 9480, 0, 284, 9765, '2010-08-09'),
(2, 1, '2014-03-19', 0, '2014-03-19', 790, 0, 24, 814, '2014-03-19'),
(3, 1, '2014-03-19', 6, '2014-09-18', 4740, 0, 142, 4882, '2014-03-19'),
(4, 2, '2014-03-19', 3, '2014-06-20', 4500, 0, 135, 4635, '2014-03-19'),
(5, 3, '2019-10-01', 0, '2019-10-01', 790, 0, 24, 814, '2019-10-21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblusuario`
--

CREATE TABLE `tblusuario` (
  `ClvUsuario` int(4) NOT NULL,
  `Usuario` varchar(80) CHARACTER SET latin1 DEFAULT NULL,
  `passwd` varchar(120) CHARACTER SET latin1 DEFAULT NULL,
  `Archivo` bit(1) DEFAULT NULL,
  `IniciarSesion` bit(1) DEFAULT NULL,
  `CerrarSesion` bit(1) DEFAULT NULL,
  `RegistroDeUsuario` bit(1) DEFAULT NULL,
  `SalirDeAplicacion` bit(1) DEFAULT NULL,
  `Clientes` bit(1) DEFAULT NULL,
  `RegistroDeClientes` bit(1) DEFAULT NULL,
  `Pagos` bit(1) DEFAULT NULL,
  `RegistroDePagos` bit(1) DEFAULT NULL,
  `EmisionesOrdenes` bit(1) DEFAULT NULL,
  `Reportes` bit(1) DEFAULT NULL,
  `ReporteDeIngresos` bit(1) DEFAULT NULL,
  `ReporteDePagos` bit(1) DEFAULT NULL,
  `ReporteDeOrdenes` bit(1) DEFAULT NULL,
  `Herramientas` bit(1) DEFAULT NULL,
  `Calculadora` bit(1) DEFAULT NULL,
  `RespaldarBd` bit(1) DEFAULT NULL,
  `RestaurarBd` bit(1) DEFAULT NULL,
  `Ayuda` bit(1) DEFAULT NULL,
  `MostrarAyuda` bit(1) DEFAULT NULL,
  `AcercaDe` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tblusuario`
--

INSERT INTO `tblusuario` (`ClvUsuario`, `Usuario`, `passwd`, `Archivo`, `IniciarSesion`, `CerrarSesion`, `RegistroDeUsuario`, `SalirDeAplicacion`, `Clientes`, `RegistroDeClientes`, `Pagos`, `RegistroDePagos`, `EmisionesOrdenes`, `Reportes`, `ReporteDeIngresos`, `ReporteDePagos`, `ReporteDeOrdenes`, `Herramientas`, `Calculadora`, `RespaldarBd`, `RestaurarBd`, `Ayuda`, `MostrarAyuda`, `AcercaDe`) VALUES
(1, 'solis', 'so', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
(2, 'jose', 'ca', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
(3, 'javier', 'ja', b'1', b'1', b'1', b'1', b'1', b'0', b'0', b'0', b'0', b'0', b'1', b'1', b'0', b'0', b'1', b'1', b'0', b'0', b'1', b'1', b'0'),
(4, 'user', 'user', b'1', b'1', b'1', b'1', b'1', b'0', b'0', b'1', b'1', b'1', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
(5, 'joshua', '123456', b'0', b'1', b'0', b'1', b'0', b'0', b'0', b'0', b'1', b'0', b'0', b'1', b'0', b'0', b'0', b'1', b'0', b'0', b'0', b'0', b'0');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tblcliente`
--
ALTER TABLE `tblcliente`
  ADD PRIMARY KEY (`NoCuenta`);

--
-- Indices de la tabla `tblorden`
--
ALTER TABLE `tblorden`
  ADD PRIMARY KEY (`NoOrden`);

--
-- Indices de la tabla `tblpago`
--
ALTER TABLE `tblpago`
  ADD PRIMARY KEY (`ClvFolio`);

--
-- Indices de la tabla `tblusuario`
--
ALTER TABLE `tblusuario`
  ADD PRIMARY KEY (`ClvUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tblcliente`
--
ALTER TABLE `tblcliente`
  MODIFY `NoCuenta` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tblorden`
--
ALTER TABLE `tblorden`
  MODIFY `NoOrden` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tblpago`
--
ALTER TABLE `tblpago`
  MODIFY `ClvFolio` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tblusuario`
--
ALTER TABLE `tblusuario`
  MODIFY `ClvUsuario` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
