-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-07-2018 a las 04:51:33
-- Versión del servidor: 10.1.33-MariaDB
-- Versión de PHP: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `redsocial`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `accion`
--

CREATE TABLE `accion` (
  `id` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `publicacion_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `amigo`
--

CREATE TABLE `amigo` (
  `id` int(11) NOT NULL,
  `amigo_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `amigo`
--

INSERT INTO `amigo` (`id`, `amigo_id`, `usuario_id`) VALUES
(190, 1, 31),
(191, 2, 31),
(192, 4, 31),
(193, 31, 1),
(194, 31, 2),
(195, 31, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`) VALUES
(1, 'plato fuerte'),
(2, 'ensaladas'),
(3, 'pasabocas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE `comentario` (
  `id` int(11) NOT NULL,
  `comentario` longtext,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `publicacion_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(237),
(237),
(237),
(237),
(237),
(237),
(237),
(237),
(237),
(237),
(237);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingrediente`
--

CREATE TABLE `ingrediente` (
  `id` int(11) NOT NULL,
  `cantidad` varchar(255) DEFAULT NULL,
  `medida` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ingrediente`
--

INSERT INTO `ingrediente` (`id`, `cantidad`, `medida`, `nombre`) VALUES
(72, '100', 'kilogramos', 'carne'),
(73, '10', 'litros', 'agua'),
(82, '200', NULL, 'sd'),
(85, '300', NULL, '234'),
(88, '300', NULL, '234'),
(91, '200', 'g', 'asd'),
(94, '200', 'g', 'asd'),
(97, '200', 'g', 'asd'),
(100, '200', 'g', 'asd'),
(103, '3', 'g', 'asd'),
(106, '3', 'g', 'asd'),
(109, '3', 'g', 'asd'),
(112, '23', 'g', 'dsf'),
(115, '23', 'g', 'sdf'),
(118, '233', 'g', 'asd'),
(121, '', 'g', 'asd'),
(124, '', '', ''),
(127, '344', 'g', 'wer'),
(130, '23', 'g', 'asd'),
(133, '23', 'g', 'qwe'),
(136, '23', 'g', 'qwe'),
(139, '23', 'g', 'asd'),
(142, '23', 'g', 'asd'),
(145, '23', 'g', 'asd'),
(148, '23', 'g', 'asdsad'),
(151, '223', 'g', 'asdsad'),
(154, '', 'g', 'asd'),
(157, '2', 'g', 'zxc'),
(160, '23', 'g', 'asd'),
(163, '23', 'g', 'asd'),
(166, '3234', 'g', 'ssdf'),
(169, '200', 'g', 'pollo'),
(172, '4', 'g', '23'),
(175, '233', 'g', 'hola'),
(176, '233', 'g', 'carne'),
(179, '230', 'g', 'pollo'),
(180, '250', 'g', 'carne'),
(181, '300', 'kgg', 'pescado'),
(184, '250', 'g', 'pollos'),
(185, '300', 'kg', 'pollos ricos'),
(186, '250', 'g', 'pollos'),
(187, '300', 'kg', 'pollos ricos'),
(188, '300', 'kg', 'pollos ricos'),
(189, '250', 'g', 'pollos'),
(198, '300', 'g', 'moras'),
(201, '200', 'g', 'moras'),
(202, '200', 'g', 'ivas'),
(205, '34', 'xzf', 'asd'),
(208, '', '', 'asd'),
(211, '', '', ''),
(212, '', '', ''),
(215, '', '', ''),
(216, '345', 'g', 'que mas'),
(219, '345', 'g', 'pollos'),
(222, '32', 'g', '123'),
(225, '232', '23', 'asd'),
(226, '2302', '23', 'que mas ve'),
(229, '234', 'g', 'asd'),
(230, '23', 'g', 'asdasd'),
(233, '234', 'g', 'gabriel'),
(236, '342', 'g', 'asdasd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE `mensaje` (
  `id` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `leido` bit(1) NOT NULL,
  `msj` varchar(255) DEFAULT NULL,
  `destino_id` int(11) DEFAULT NULL,
  `origen_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paso`
--

CREATE TABLE `paso` (
  `id` int(11) NOT NULL,
  `descripcion` longtext,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `paso`
--

INSERT INTO `paso` (`id`, `descripcion`, `nombre`) VALUES
(74, 'descripcion del paso 1', 'paso 1'),
(77, 'descripcion del paso 2', 'paso 2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paso_ingrediente`
--

CREATE TABLE `paso_ingrediente` (
  `id` int(11) NOT NULL,
  `cantidad` varchar(255) DEFAULT NULL,
  `medida` varchar(255) DEFAULT NULL,
  `ingrediente_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `paso_ingrediente`
--

INSERT INTO `paso_ingrediente` (`id`, `cantidad`, `medida`, `ingrediente_id`) VALUES
(75, '555', 'ffff', 72),
(76, '444', 'ffff', 73),
(78, '444', 'ffff', 73);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paso_ingredientes`
--

CREATE TABLE `paso_ingredientes` (
  `paso_id` int(11) NOT NULL,
  `ingredientes_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `paso_ingredientes`
--

INSERT INTO `paso_ingredientes` (`paso_id`, `ingredientes_id`) VALUES
(74, 75),
(74, 76),
(77, 78);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicacion`
--

CREATE TABLE `publicacion` (
  `id` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `image_receta` longtext,
  `privacidad` bit(1) NOT NULL,
  `categoria_id` int(11) DEFAULT NULL,
  `receta_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `publicacion`
--

INSERT INTO `publicacion` (`id`, `fecha`, `hora`, `image_receta`, `privacidad`, `categoria_id`, `receta_id`, `usuario_id`) VALUES
(70, '2018-07-02', '21:37:18', 'http://www.wallpaper-mobile.com/free_download/640_480_wallpapers/11201322/B/B_minionator_U9uLl3jA.jpg', b'1', 1, 71, 1),
(80, '2018-07-02', '22:39:19', '', b'1', 1, 81, 1),
(83, '2018-07-02', '22:44:22', '', b'1', 1, 84, 1),
(86, '2018-07-02', '22:45:38', '', b'1', 1, 87, 1),
(89, '2018-07-02', '22:49:32', '', b'1', 1, 90, 1),
(92, '2018-07-02', '22:51:58', '', b'1', 1, 93, 1),
(95, '2018-07-02', '22:52:22', '', b'1', 1, 96, 1),
(98, '2018-07-02', '22:53:07', '', b'1', 1, 99, 1),
(101, '2018-07-02', '22:53:20', '', b'1', 1, 102, 1),
(104, '2018-07-02', '22:54:40', '', b'1', 1, 105, 1),
(107, '2018-07-02', '22:54:44', '', b'1', 1, 108, 1),
(110, '2018-07-02', '22:55:21', '', b'1', 1, 111, 1),
(113, '2018-07-02', '22:56:30', '', b'1', 1, 114, 1),
(116, '2018-07-02', '23:00:58', '', b'1', 1, 117, 1),
(119, '2018-07-02', '23:01:42', '', b'1', 1, 120, 1),
(122, '2018-07-02', '23:02:23', '', b'1', 1, 123, 1),
(125, '2018-07-02', '23:02:39', '', b'1', 1, 126, 1),
(128, '2018-07-02', '23:04:23', '', b'1', 1, 129, 1),
(131, '2018-07-02', '23:06:29', '', b'1', 1, 132, 1),
(134, '2018-07-02', '23:06:36', '', b'1', 1, 135, 1),
(137, '2018-07-02', '23:10:54', '', b'1', 1, 138, 1),
(140, '2018-07-02', '23:11:08', '', b'1', 1, 141, 1),
(143, '2018-07-02', '23:11:09', '', b'1', 1, 144, 1),
(146, '2018-07-02', '23:11:21', '', b'1', 1, 147, 1),
(149, '2018-07-02', '23:11:54', '', b'1', 1, 150, 1),
(152, '2018-07-02', '23:13:50', '', b'1', 1, 153, 1),
(155, '2018-07-02', '23:14:57', '', b'1', 1, 156, 1),
(158, '2018-07-02', '23:18:37', '', b'1', 1, 159, 1),
(161, '2018-07-02', '23:18:50', '', b'1', 1, 162, 1),
(164, '2018-07-02', '23:19:28', '', b'1', 1, 165, 1),
(167, '2018-07-02', '23:23:35', '', b'1', 1, 168, 1),
(170, '2018-07-02', '23:24:59', '', b'1', 1, 171, 1),
(173, '2018-07-02', '23:28:16', '', b'1', 1, 174, 1),
(177, '2018-07-02', '23:29:27', '', b'1', 1, 178, 1),
(182, '2018-07-02', '23:32:24', '', b'1', 1, 183, 1),
(196, '2018-07-03', '16:36:53', 'https://firebasestorage.googleapis.com/v0/b/socialfood-8d9c6.appspot.com/o/imagenes%2Fdescarga%20(2).jpg?alt=media&token=283f8dd9-1e82-44b0-bee7-e1c510bc936c', b'1', 1, 197, 1),
(199, '2018-07-03', '16:38:29', 'https://firebasestorage.googleapis.com/v0/b/socialfood-8d9c6.appspot.com/o/imagenes%2Fdescarga%20(2).jpg?alt=media&token=1bf4f3f3-117e-4b27-be70-f41f4f50011a', b'1', 1, 200, 1),
(203, '2018-07-03', '16:48:14', '', b'1', 1, 204, 1),
(206, '2018-07-03', '16:48:31', '', b'1', 1, 207, 1),
(209, '2018-07-03', '16:52:14', '', b'1', 2, 210, 1),
(213, '2018-07-03', '16:52:42', '', b'1', 3, 214, 1),
(217, '2018-07-03', '16:57:45', 'https://firebasestorage.googleapis.com/v0/b/socialfood-8d9c6.appspot.com/o/imagenes%2Fdescarga.jpg?alt=media&token=a686c5e4-23b5-440b-8794-b6531f2cb2d3', b'1', 3, 218, 1),
(220, '2018-07-03', '16:58:49', 'https://firebasestorage.googleapis.com/v0/b/socialfood-8d9c6.appspot.com/o/imagenes%2Fimages.jpg?alt=media&token=865491ff-27b1-4c2f-a50d-dc13d5e3d5be', b'1', 3, 221, 1),
(223, '2018-07-03', '17:03:30', 'https://firebasestorage.googleapis.com/v0/b/socialfood-8d9c6.appspot.com/o/imagenes%2Fimages.jpg?alt=media&token=15f54fff-95f3-4851-a943-722f1295a9d1', b'1', 1, 224, 1),
(227, '2018-07-03', '17:05:52', 'https://firebasestorage.googleapis.com/v0/b/socialfood-8d9c6.appspot.com/o/imagenes%2Fdescarga%20(2).jpg?alt=media&token=b02a6563-bfe7-418a-99da-b59292206332', b'1', 1, 228, 1),
(231, '2018-07-03', '21:43:21', 'https://firebasestorage.googleapis.com/v0/b/socialfood-8d9c6.appspot.com/o/imagenes%2Fdescarga%20(1).jpg?alt=media&token=bbd39539-5f91-499e-83a5-971bd8fa1d1b', b'1', 1, 232, 1),
(234, '2018-07-03', '21:49:11', 'https://firebasestorage.googleapis.com/v0/b/socialfood-8d9c6.appspot.com/o/imagenes%2Fdescarga%20(2).jpg?alt=media&token=dfc39422-0757-49b1-839b-286e1295494b', b'1', 2, 235, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE `receta` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `receta`
--

INSERT INTO `receta` (`id`, `nombre`) VALUES
(71, 'receta 1'),
(81, 'sd'),
(84, 'sdf'),
(87, 'sdf'),
(90, 'da'),
(93, 'da'),
(96, 'da'),
(99, 'da'),
(102, 'asd'),
(105, 'asd'),
(108, 'asd'),
(111, 'sdf'),
(114, 'sdf'),
(117, 'asd'),
(120, 'asd'),
(123, ''),
(126, 'wer'),
(129, 'asd'),
(132, 'qwe'),
(135, 'qwe'),
(138, 'asdasd'),
(141, 'asdasd'),
(144, 'asdasd'),
(147, 'asdasd'),
(150, 'asdadasdsd'),
(153, 'asd'),
(156, 'xxzzx'),
(159, 'asd'),
(162, 'asd'),
(165, 'sdf'),
(168, 'asd'),
(171, 'asd'),
(174, 'vamos a cocinar'),
(178, 'vamos a cocinar'),
(183, 'que mas ves'),
(197, 'Postre de frutos rojos'),
(200, 'que mas ve'),
(204, ''),
(207, ''),
(210, ''),
(214, ''),
(218, 'pollos'),
(221, 'asdsad'),
(224, 'jasjas'),
(228, 'asdsd'),
(232, 'Pollo'),
(235, 'pollo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta_ingredientes`
--

CREATE TABLE `receta_ingredientes` (
  `receta_id` int(11) NOT NULL,
  `ingredientes_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `receta_ingredientes`
--

INSERT INTO `receta_ingredientes` (`receta_id`, `ingredientes_id`) VALUES
(71, 72),
(71, 73),
(81, 82),
(84, 85),
(87, 88),
(90, 91),
(93, 94),
(96, 97),
(99, 100),
(102, 103),
(105, 106),
(108, 109),
(111, 112),
(114, 115),
(117, 118),
(120, 121),
(123, 124),
(126, 127),
(129, 130),
(132, 133),
(135, 136),
(138, 139),
(141, 142),
(144, 145),
(147, 148),
(150, 151),
(153, 154),
(156, 157),
(159, 160),
(162, 163),
(165, 166),
(168, 169),
(171, 172),
(174, 175),
(174, 176),
(178, 180),
(178, 179),
(178, 181),
(183, 188),
(183, 186),
(183, 184),
(183, 185),
(183, 187),
(183, 189),
(197, 198),
(200, 201),
(200, 202),
(204, 205),
(207, 208),
(210, 211),
(210, 212),
(214, 215),
(214, 216),
(218, 219),
(221, 222),
(224, 225),
(224, 226),
(228, 229),
(228, 230),
(232, 233),
(235, 236);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta_pasos`
--

CREATE TABLE `receta_pasos` (
  `receta_id` int(11) NOT NULL,
  `pasos_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `receta_pasos`
--

INSERT INTO `receta_pasos` (`receta_id`, `pasos_id`) VALUES
(71, 74),
(71, 77);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `imagen_usuario` longtext,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `privacidad` bit(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `correo`, `imagen_usuario`, `nickname`, `password`, `privacidad`) VALUES
(1, 'pedrolop90@hotmail.com', 'https://firebasestorage.googleapis.com/v0/b/socialfood-8d9c6.appspot.com/o/perfil%2FIMG_5423.jpg?alt=media&token=26e0a5db-4332-4bf7-91e6-f1a6915d1d22', 'pedro', '12345', b'1'),
(2, 'nataligamgoa610@gmail.com', NULL, 'Nataligao', '123', b'1'),
(32, 'Kyokazu10@gmail.com', NULL, 'Kyokazu', '12345', b'1'),
(4, 'natao@gmail.com', NULL, 'Helen', '123', b'1'),
(8, 'pedro@gmail.com', NULL, 'Pedro', '123', b'1'),
(13, 'memo@gmail.com', NULL, 'Memo', '12345', b'1'),
(14, 'jose@gmail.com', NULL, 'jose', '1123', b'1'),
(17, 'gabriel@gmail.com', NULL, 'Gabriel', '1123', b'1'),
(18, 'maria@gmail.com', NULL, 'maria', '123', b'1'),
(21, 'natalig@gmail.com', NULL, 'josep', '123', b'1'),
(22, 'ange@gmail.com', NULL, 'angelica', '12345', b'1'),
(24, 'h@gmail.com', NULL, 'helen', '12', b'1'),
(25, 'x@gmail.com', NULL, 'x', '12', b'1'),
(28, 'josepedro@gmail.com', NULL, 'pedrojose', '12345', b'1'),
(29, 'mariocasas@gmail.com', NULL, 'mario', '123', b'1'),
(31, 'helen@gmail.com', 'https://firebasestorage.googleapis.com/v0/b/socialfood-8d9c6.appspot.com/o/perfil%2Fdhdhd.jpg?alt=media&token=4f737e96-2acb-473f-8a83-ad6b1a8f7a1a', 'HelenMarianneE', 'helen', b'1'),
(67, 'perez@hotmail.com', NULL, 'perez', '12345', b'1'),
(79, 'pedrolop90789.gmail.com', NULL, 'pedro', '12345', b'1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `accion`
--
ALTER TABLE `accion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsg6twqgitokhooyfkfqhyan0q` (`publicacion_id`),
  ADD KEY `FK64u66sc0q4bqoyk1hqhk8esrw` (`usuario_id`);

--
-- Indices de la tabla `amigo`
--
ALTER TABLE `amigo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoa1lvbbjec64hi91warw7ewov` (`amigo_id`),
  ADD KEY `FKjgkde6g7e19vk6chnd9om4hx6` (`usuario_id`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3gh68jx5umvb7fm8uuv5chiwu` (`publicacion_id`),
  ADD KEY `FKixspmid2pb85o8ypsd20jakxg` (`usuario_id`);

--
-- Indices de la tabla `ingrediente`
--
ALTER TABLE `ingrediente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK28dj1velk03b57ky9vv9rms43` (`destino_id`),
  ADD KEY `FKjjvorsdma9237jssl6hkvgmfc` (`origen_id`);

--
-- Indices de la tabla `paso`
--
ALTER TABLE `paso`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `paso_ingrediente`
--
ALTER TABLE `paso_ingrediente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdn0bkqiwaskspbiu2rpn91hxg` (`ingrediente_id`);

--
-- Indices de la tabla `paso_ingredientes`
--
ALTER TABLE `paso_ingredientes`
  ADD UNIQUE KEY `UK_m6rbv952s4pnvlwiegw86qawm` (`ingredientes_id`),
  ADD KEY `FKhgrjqw5suok648w5uh4fbq46m` (`paso_id`);

--
-- Indices de la tabla `publicacion`
--
ALTER TABLE `publicacion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKayf9y7cdtc50ta20wnuys5rlp` (`categoria_id`),
  ADD KEY `FK50gvy80xbf2fywoffgasbxk2w` (`receta_id`),
  ADD KEY `FKdo1oimidqi94636gg0dut6gcr` (`usuario_id`);

--
-- Indices de la tabla `receta`
--
ALTER TABLE `receta`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `receta_ingredientes`
--
ALTER TABLE `receta_ingredientes`
  ADD UNIQUE KEY `UK_bprrybbc3qf3xnt994wq3j92` (`ingredientes_id`),
  ADD KEY `FKbl8nm6s0d3hi6qb6wpx8qyrru` (`receta_id`);

--
-- Indices de la tabla `receta_pasos`
--
ALTER TABLE `receta_pasos`
  ADD UNIQUE KEY `UK_ktqqsxdpqy5pdeyhfo1n2mpdo` (`pasos_id`),
  ADD KEY `FKn2vyncf6sn5yrmltwbnvlns8b` (`receta_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_2mlfr087gb1ce55f2j87o74t` (`correo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
