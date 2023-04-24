INSERT INTO INGREDIENTES(id, nome) VALUES (4,'Açúcar'),(28,'Água'),(42,'Água fervente'),(23,'Alho'),(27,'Arroz'),(31,'Azeitona'),(39,'Baunilha'),(41,'Caldo de galinha'),(29,'Canela em pó'),(17,'Carne moída'),(20,'Cebola'),(21,'Cebola ralada'),(2,'Cenoura'),(14,'Chocolate em pó'),(25,'Chocolate meio amargo'),(38,'Coco ralado'),(40,'Coxinha da asa'),(13,'Creme de leite'),(36,'Dente de alho'),(1,'Farinha de trigo'),(5,'Fermento em pó'),(7,'Fubá'),(26,'Gema'),(10,'Leite'),(11,'Leite condensado'),(37,'Mandioca'),(3,'Manteiga'),(16,'Massa de lasanha'),(22,'Molho de tomate'),(19,'Mussarela'),(8,'Óleo'),(9,'Ovo'),(33,'Pimentão amarelo'),(34,'Pimentão verde'),(32,'Pimentão vermelho'),(18,'Presunto'),(24,'Queijo ralado'),(6,'Sal'),(35,'Salsinha'),(30,'Seleta de legumes');

INSERT INTO PERFIS(id, descricao) VALUES (1,'ADMIN'),(2,'USUARIOLOGADO');

INSERT INTO UNIDADE_MEDIDA(id,nome) VALUES (19,'A gosto'),(17,'Caixa'),(1,'Colher'),(2,'Colher de chá'),(5,'Colher de sopa'),(16,'Copo'),(8,'Copo americano'),(20,'Gotas'),(14,'Gramas'),(12,'Lata'),(11,'Pacote'),(3,'Pitada'),(15,'Quilo'),(21,'Tablete'),(4,'Unidade'),(13,'Vidro'),(7,'Xícara de café'),(6,'Xícara de chá');

INSERT INTO USUARIOS(id, ativo, email, senha, codigo_verificador) VALUES (1,1,'admin@gft.com','$2a$10$iVjzvzpJR10YLDlPzpybk.toiOAFWVxBMdQelUv7QiRgfuif3s.5G',NULL),(16,1,'usuario@gft.com','$2a$10$68E7Uc7OIZ558teqR24t9.zYEH/BD.E/eMfNnh48H..t9An0b0ifi',NULL);

INSERT INTO USUARIOS_TEM_PERFIS (usuario_id, perfil_id)  VALUES (1,1),(16,2);

INSERT INTO USUARIO_LOGADO(id, data_nascimento, nome, id_usuario) VALUES (1,'2022-06-30','Usuario Gft',16);

INSERT INTO RECEITAS(id, modo_preparo, nome, porcoes, tempo_preparo) VALUES (1, 'No liquidificador, coloque 3 cenouras médias, 3 ovos, 1 xícara de óleo de canola e 2 xícaras de açúcar. Bata até ficar homogêneo.', 'Bolo de Cenoura', 6, 30);
INSERT INTO RECEITAS(id, modo_preparo, nome, porcoes, tempo_preparo) VALUES (2, 'Primeiramente,bata os ovos,óleo e leite, por um minuto.Logo após, vai acrescentando aos poucos o açúcar,depois o fubá,a farinha de trigo e o sal', 'Bolo de Fubá', 8, 50);
INSERT INTO RECEITAS(id, modo_preparo, nome, porcoes, tempo_preparo) VALUES (3, 'Em uma panela em fogo médio, aqueça 1 fio de azeite.Acrescente a cebola e refogue.Quando a cebola começar a dourar, adicione o alho na panela e deixe refogando.', 'Lasanha', 10, 60);
INSERT INTO RECEITAS(id, modo_preparo, nome, porcoes, tempo_preparo) VALUES (4, 'Derreta em banho-maria 200 gramas de chocolate meio amargo e 2 colheres de sopa sem sal. Reserve. Na bateira, coloque 2 ovos, 2 gemas, meia xícara de chá de açúcar. Bata até obter um creme claro.', 'Petit Gateau', 3, 60);
INSERT INTO RECEITAS(id, modo_preparo, nome, porcoes, tempo_preparo) VALUES (5, 'Em uma panela de pressão, coloque 2 colheres de sopa de óleo, 2 peitos de frango, sal a gosto e pimenta-do-reino a gosto. Cozinhe por 15 minutos na pressão.', 'Torta de Frango', 4, 40);
INSERT INTO RECEITAS(id, modo_preparo, nome, porcoes, tempo_preparo) VALUES (6, 'Coloque todos os ingredientes em um recipiente que possa ir ao micro-ondas e misture. Leve o recipiente ao micro-ondas e deixe por 4 minutos em potência alta.', 'Brigadeiro', 12, 30);


INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (1,10,1,1,1);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (2,1,2,1,2);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (3,2,3,1,3);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (4,5,4,1,5);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (5,8,5,1,9);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (6,10,11,1,8);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (7,10,18,1,4);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (8,1,19,1,7);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (9,3,17,1,3);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (11,10,1,2,1);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (12,1,2,2,2);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (23,2,3,2,3);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (14,5,4,2,5);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (15,8,5,2,9);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (16,10,11,2,8);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (17,10,18,2,4);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (18,1,19,2,7);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (19,3,17,2,3);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (20,4,12,2,8);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (21,10,1,3,1);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (22,1,2,3,2);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (23,2,3,3,3);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (24,5,4,3,5);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (25,8,5,3,9);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (26,10,11,3,8);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (27,10,18,3,4);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (28,1,19,3,7);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (29,3,17,3,3);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (30,4,12,3,8);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (31,10,1,1,1);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (32,1,2,1,2);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (33,2,3,1,3);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (34,5,4,1,5);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (35,8,5,1,9);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (36,10,11,1,8);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (37,10,18,1,4);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (38,1,19,1,7);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (39,3,17,1,3);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (40,4,12,2,8);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (41,10,1,2,1);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (42,1,2,2,2);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (43,2,3,2,3);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (44,5,4,2,5);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (45,8,5,2,9);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (46,10,11,2,8);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (47,10,18,2,4);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (48,1,19,2,7);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (49,3,17,2,3);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (50,4,12,2,8);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (51,10,1,3,1);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (52,1,2,3,2);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (53,2,3,3,3);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (54,5,4,3,5);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (55,8,5,3,9);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (56,10,11,3,8);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (57,10,18,3,4);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (58,1,19,3,7);
INSERT INTO RECEITA_INGREDIENTE(id, quantidade, id_ingrediente, id_receita, id_unidade_medida) VALUES (59,3,17,3,3);
