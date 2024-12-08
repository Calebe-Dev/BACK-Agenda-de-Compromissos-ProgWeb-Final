-- Inserindo dados de exemplo na tabela 'compromisso'
INSERT INTO compromisso (id, title, description, compromisso_date, start_time, end_time, compromisso_status, local, priority) 
VALUES (1, 'Reunião de Projeto', 'Discussão sobre o andamento do projeto X', '2024-11-20', '10:00:00', '11:00:00','Pendente', 'Sala de Reuniões 1', 2);

INSERT INTO compromisso (id, title, description, compromisso_date, start_time, end_time, local, compromisso_status, priority) 
VALUES (2, 'Consulta Médica', 'Consulta de rotina com o Dr. Silva', '2024-11-21', '15:00:00', '16:00:00','Pendente', 'Clínica São José', 1);

INSERT INTO compromisso (id, title, description, compromisso_date, start_time, end_time, local, compromisso_status, priority) 
VALUES (3, 'Aula de Yoga', 'Sessão de yoga para relaxamento', '2024-11-22', '18:00:00', '19:00:00','Pendente', 'Academia Zen', 3);
