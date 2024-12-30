-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2024 at 10:03 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cardealer`
--

-- --------------------------------------------------------

--
-- Table structure for table `mobil`
--

CREATE TABLE `mobil` (
  `id_mobil` int(11) NOT NULL,
  `harga` double DEFAULT NULL,
  `jenis` varchar(255) DEFAULT NULL,
  `kapasitas_mesin` int(11) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `no_mesin` varchar(255) DEFAULT NULL,
  `no_rangka` varchar(255) DEFAULT NULL,
  `plat_nomor` varchar(255) DEFAULT NULL,
  `id_pabrikan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mobil`
--

INSERT INTO `mobil` (`id_mobil`, `harga`, `jenis`, `kapasitas_mesin`, `nama`, `no_mesin`, `no_rangka`, `plat_nomor`, `id_pabrikan`) VALUES
(1, 500000000, 'SUV', 2400, 'Fortuner', '123456789012', 'TF2345678901234', 'B 1234 ABC', 1),
(3, 600000, 'Sports', 0, 'Icha', 'a', 'a', 'a', 3),
(4, 4000000000, 'Sports', 3800, 'GT-R Nismo', 'NGTNR123456789', 'NGTNR1234567890', 'D 4567 GTR', 2),
(5, 450000000, 'SUV', 2000, 'X-Trail', '123456789012', 'NX2345678901234', 'A 1234 JKL', 2),
(6, 200000000, 'MPV', 1500, 'Ertiga', '456789012345', 'SE2345678901234', 'B 4567 MNO', 5),
(7, 220000000, 'SUV', 1500, 'Terios', '789012345678', 'DT2345678901234', 'D 7890 YZ', 9),
(8, 600000000, 'SUV', 2500, 'Pajero Sport', '789012345678', 'MP2345678901234', 'B 7890 GHI', 8),
(9, 6000000000, 'Sports', 5204, 'Huracan', 'L535 123456', 'LAH1234567890', 'B 2222 LLL', 7),
(10, 1800000000, 'Sports', 5000, 'Mustang', 'Coyote5.0 123456', 'FO51234567890', 'B 4444 NNN', 10),
(11, 2000000000, 'Sports', 6200, 'Camaro', 'LT1 6.2L 123456', 'CH51234567890', 'B 5555 OOO', 11);

-- --------------------------------------------------------

--
-- Table structure for table `pabrikan`
--

CREATE TABLE `pabrikan` (
  `id_pabrikan` int(11) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `no_telp` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pabrikan`
--

INSERT INTO `pabrikan` (`id_pabrikan`, `alamat`, `nama`, `no_telp`) VALUES
(1, 'Jl. Toyota no. 1', 'Toyota', '081111111111'),
(2, 'Jl. Nissan no. 1', 'Nissan', '082222222222'),
(3, 'Jl. Ferrari no. 1', 'Ferrari', '083333333333'),
(4, 'Jl. Porsche no. 1', 'Porsche', '084444444444'),
(5, 'Jl. Suzuki no. 1', 'Suzuki', '085555555555'),
(6, 'Jl. Mazda no. 1', 'Mazda', '086666666666'),
(7, 'Jl. Lamborghini no. 1', 'Lamborghini', '087777777777'),
(8, 'Jl. Mitsubishi no. 1', 'Mitsubishi', '088888888888'),
(9, 'Jl. Daihatsu', 'Daihatsu', '089999999999'),
(10, 'Jl. Ford no. 1', 'Ford', '081010101010'),
(11, 'Jl. Chevrolet no. 1', 'Chevrolet', '081212121212');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `id_penjualan` int(11) NOT NULL,
  `tanggal_penjualan` datetime(6) DEFAULT NULL,
  `id_mobil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id_penjualan`, `tanggal_penjualan`, `id_mobil`) VALUES
(1, '2024-12-30 12:38:21.000000', 1),
(2, '2024-12-30 14:45:27.000000', 4),
(3, '2024-12-30 15:05:44.000000', 10),
(5, '2024-12-30 15:11:30.000000', 8),
(6, '2024-12-30 15:22:18.000000', 11);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `role` varchar(31) NOT NULL,
  `id_user` int(11) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `no_telp` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`id_mobil`),
  ADD KEY `FKpd2lj743ct9myepbicak8t8l` (`id_pabrikan`);

--
-- Indexes for table `pabrikan`
--
ALTER TABLE `pabrikan`
  ADD PRIMARY KEY (`id_pabrikan`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id_penjualan`),
  ADD KEY `FKi4f1ymksuyyqc4ss7vtq6jq65` (`id_mobil`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mobil`
--
ALTER TABLE `mobil`
  MODIFY `id_mobil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `pabrikan`
--
ALTER TABLE `pabrikan`
  MODIFY `id_pabrikan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id_penjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mobil`
--
ALTER TABLE `mobil`
  ADD CONSTRAINT `FKpd2lj743ct9myepbicak8t8l` FOREIGN KEY (`id_pabrikan`) REFERENCES `pabrikan` (`id_pabrikan`);

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `FKi4f1ymksuyyqc4ss7vtq6jq65` FOREIGN KEY (`id_mobil`) REFERENCES `mobil` (`id_mobil`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
