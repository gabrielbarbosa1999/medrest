alter table tb_pacientes add column ativo boolean;
update tb_pacientes set ativo = true;