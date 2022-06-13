CREATE DATABASE `kpacs` /*!40100
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci */ /*!80016
    DEFAULT ENCRYPTION='N' */;


-- ----------------------------
-- Table structure for kPac
-- ----------------------------
CREATE TABLE `kpac` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `description` varchar(255) DEFAULT NULL,
                        `showDate` date DEFAULT NULL,
                        `title` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for kPacSet
-- ----------------------------
CREATE TABLE `kpacset` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `title` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for cars
-- ----------------------------
DROP TABLE IF EXISTS `cars`;
CREATE TABLE `cars`  (
                         `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
                         `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                         `manufacturer_id` bigint(0) UNSIGNED NOT NULL,
                         `is_deleted` bit(1) NOT NULL DEFAULT b'0',
                         PRIMARY KEY (`id`) USING BTREE,
                         INDEX `FK_manufacturer_id`(`manufacturer_id`) USING BTREE,
                         CONSTRAINT `FK_manufacturer_id` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturers` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for kPacSet_kPac
-- ----------------------------
CREATE TABLE `kpacset_kpac` (
                                `kPacSet_id` bigint NOT NULL,
                                `kPac_id` bigint NOT NULL,
                                UNIQUE KEY `UK_3v7jj34gw9tfed8k4pisunmnq` (`kPac_id`),
                                KEY `FKln0t8ngdvey1qccsnnq36tcm4` (`kPacSet_id`),
                                CONSTRAINT `FKfoepsng8adatbjsf69l9m5mxl` FOREIGN KEY (`kPac_id`) REFERENCES `kpac` (`id`),
                                CONSTRAINT `FKln0t8ngdvey1qccsnnq36tcm4` FOREIGN KEY (`kPacSet_id`) REFERENCES `kpacset` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
