
DROP TABLE IF EXISTS `taches`;
CREATE TABLE IF NOT EXISTS `taches` (
  `id_tache` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `nom_tache` varchar(255) NOT NULL,
  `statut` int(11) NOT NULL,
  PRIMARY KEY (`id_tache`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nom_user` varchar(255) NOT NULL,
  `prenom_user` varchar(255) NOT NULL,
  `email_user` varchar(255) NOT NULL,
  `mdp_user` varchar(255) NOT NULL,
  `level_user` int(11) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


INSERT INTO `user` (`id_user`, `nom_user`, `prenom_user`, `email_user`, `mdp_user`, `level_user`) 
VALUES (1, 'Santana', 'Vincent', 'vincent.santana@sfr.fr', 'motdepasse', 1);
COMMIT;
