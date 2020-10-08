-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 08 Okt 2020 pada 20.40
-- Versi server: 10.3.16-MariaDB
-- Versi PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_final`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `account`
--

CREATE TABLE `account` (
  `id` int(5) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `account`
--

INSERT INTO `account` (`id`, `username`, `password`) VALUES
(1, 'ray', '$2a$10$HVF0czY2.lCKhduosamNHuCdldHEzb4a2XT3nOz/134MF8mQsz/.2'),
(2, 'dia', '$2a$10$HVF0czY2.lCKhduosamNHuCdldHEzb4a2XT3nOz/134MF8mQsz/.2'),
(3, 'oliv', '$2a$10$HVF0czY2.lCKhduosamNHuCdldHEzb4a2XT3nOz/134MF8mQsz/.2'),
(4, 'panna', '$2a$10$HVF0czY2.lCKhduosamNHuCdldHEzb4a2XT3nOz/134MF8mQsz/.2'),
(5, 'gunawan', '$2a$10$HVF0czY2.lCKhduosamNHuCdldHEzb4a2XT3nOz/134MF8mQsz/.2'),
(6, 'nathan', '$2a$10$HVF0czY2.lCKhduosamNHuCdldHEzb4a2XT3nOz/134MF8mQsz/.2'),
(7, 'chrisna', '$2a$10$HVF0czY2.lCKhduosamNHuCdldHEzb4a2XT3nOz/134MF8mQsz/.2'),
(8, 'herul', '$2a$10$HVF0czY2.lCKhduosamNHuCdldHEzb4a2XT3nOz/134MF8mQsz/.2'),
(9, 'yogi', '$2a$10$HVF0czY2.lCKhduosamNHuCdldHEzb4a2XT3nOz/134MF8mQsz/.2'),
(10, 'irfan', '$2a$10$HVF0czY2.lCKhduosamNHuCdldHEzb4a2XT3nOz/134MF8mQsz/.2'),
(11, 'testname', '$2a$10$dN7aq6rMr1UBuKB8imjA0.PT4/gvw2uW8nx5sH0miIgBlpt7KuPpC'),
(12, 'testname2', '$2a$10$meNLoAApsIaal5BHZaXGxew0mGc/8C4Ou37a7QUKbzhNbn96G4EUe'),
(13, 'testname22', '$2a$10$WeY3YIIs5Yx0ahOM7B6tLOzVKzmzLTNuTXd377tGdcIigW1kikLJK'),
(15, 'testname223', '$2a$10$Nh4GaPoRnf7tSLl.1GNIluG1ikGGVbjGWesQiXyiBWcoSHRXxOlhC');

-- --------------------------------------------------------

--
-- Struktur dari tabel `role`
--

CREATE TABLE `role` (
  `id` int(5) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_HR'),
(3, 'ROLE_INTERVIEWER'),
(4, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `name`, `email`) VALUES
(1, 'Nathaniel Ray Raharjo', 'nathaniel.raharjo@gmail.com'),
(2, 'Yosefa Oktaviana Dia', 'yosefadia27@gmail.com'),
(3, 'Olivia Michelle', 'michelleolivia301@gmail.com'),
(4, 'Novi Panna Vira', 'novipannavira@gmail.com'),
(5, 'Gunawan Zega', 'faktagunawanzega@gmail.com'),
(6, 'Jonathan Purnama Halim', 'jonathanpurnama13@gmail.com'),
(7, 'Willy Chrisna', 'willychrisna77@gmail.com'),
(8, 'Herul Syahwandi S', 'herul.syah@gmail.com'),
(9, 'Bachtiar Nur Yogi P', 'bachtiarnuryogipratama@gmail.com'),
(10, 'Muhamad Irfan Bernadius ', 'muhamadi7696@gmail.com'),
(11, 'test name', 'test@email.com'),
(12, 'test name 2', 'test2@email.com'),
(13, 'test name 2', 'test22@email.com'),
(14, 'test name 2', 'test222@email.com'),
(15, 'test name 2', 'test2222@email.com');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user_role`
--

CREATE TABLE `user_role` (
  `id` int(5) NOT NULL,
  `user` int(5) NOT NULL,
  `role` int(5) NOT NULL DEFAULT 4
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user_role`
--

INSERT INTO `user_role` (`id`, `user`, `role`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 4),
(5, 5, 3),
(6, 6, 2),
(7, 7, 1),
(8, 8, 2),
(9, 9, 3),
(10, 10, 4),
(11, 6, 1),
(12, 12, 4),
(13, 13, 4),
(14, 15, 4);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indeks untuk tabel `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indeks untuk tabel `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_account` (`user`),
  ADD KEY `fk_role` (`role`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT untuk tabel `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `fk_role` FOREIGN KEY (`role`) REFERENCES `role` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
