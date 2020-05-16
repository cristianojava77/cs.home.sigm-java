-- cleaning up database
delete from country;
ALTER TABLE country ALTER COLUMN id RESTART WITH 1;

delete from maritalstatus;
ALTER TABLE maritalstatus ALTER COLUMN id RESTART WITH 1;

delete from relationship;
ALTER TABLE relationship ALTER COLUMN id RESTART WITH 1;

delete from state;
ALTER TABLE state ALTER COLUMN id RESTART WITH 1;

-- setting up data
insert into country (id, code, language, title, abbreviation) values
(null, 1, 'pt_BR', 'Brasil', 'BR'),
(null, 2, 'pt_BR', 'Argentina', 'AR'),
(null, 3, 'pt_BR', 'Estados Unidos', 'US'),

(null, 1, 'es_ES', 'Brasil', 'BR'),
(null, 2, 'es_ES', 'Argentina', 'AR'),
(null, 3, 'es_ES', 'Estados Unidos', 'US'),

(null, 1, 'en_US', 'Brasil', 'BR'),
(null, 2, 'en_US', 'Argentina', 'AR'),
(null, 3, 'en_US', 'Estados Unidos', 'US'),

insert into maritalstatus (id, code, title, language) values
(null, 1, 'Solteiro(a)', 'pt_BR'),
(null, 2, 'Amasiado(a)', 'pt_BR'),
(null, 3, 'Casado(a)', 'pt_BR'),
(null, 4, 'Separado(a)', 'pt_BR'),
(null, 5, 'Divorciado(a)', 'pt_BR'),
(null, 6, 'Viúvo(a)', 'pt_BR'),

(null, 1, 'Soltero(a)', 'es_ES'),
(null, 2, 'Comprometido(a)', 'es_ES'),
(null, 3, 'Casado(a)', 'es_ES'),
(null, 4, 'Separado(a)', 'es_ES'),
(null, 5, 'Divorciado(a)', 'es_ES'),
(null, 6, 'Viudo(a)', 'es_ES'),

(null, 1, 'Single', 'en_US'),
(null, 2, 'Common-law', 'en_US'),
(null, 3, 'Married', 'en_US'),
(null, 4, 'Separated', 'en_US'),
(null, 5, 'Divorced', 'en_US'),
(null, 6, 'Widowed', 'en_US')
;

insert into relationship (id, code, title, language) values
(null, 1, 'Cônjuge', 'pt_BR'),
(null, 2, 'Pai', 'pt_BR'),
(null, 3, 'Mãe', 'pt_BR'),
(null, 4, 'Irmão/Irmã', 'pt_BR'),
(null, 5, 'Filho(a)', 'pt_BR'),

(null, 1, 'Cónyuge', 'es_ES'),
(null, 2, 'Padre', 'es_ES'),
(null, 3, 'Madre', 'es_ES'),
(null, 4, 'Hermano(a)', 'es_ES'),
(null, 5, 'Hijo(a)', 'es_ES'),

(null, 1, 'Spouse', 'en_US'),
(null, 2, 'Father', 'en_US'),
(null, 3, 'Mother', 'en_US'),
(null, 4, 'Brother/Sister', 'en_US'),
(null, 5, 'Son/Daughter', 'en_US');

insert into state (id, countrycode, title, abbreviation) values
(null, 1, 'Acre', 'AC'),
(null, 1, 'Alagoas', 'AL'),
(null, 1, 'Amapá', 'AP'),
(null, 1, 'Amazonas', 'AM'),
(null, 1, 'Bahia', 'BA'),
(null, 1, 'Ceará', 'CE'),
(null, 1, 'Distrito Federal', 'DF'),
(null, 1, 'Espírito Santo', 'ES'),
(null, 1, 'Goiás', 'GO'),
(null, 1, 'Maranhão', 'MA'),
(null, 1, 'Mato Grosso', 'MT'),
(null, 1, 'Mato Grosso do Sul', 'MS'),
(null, 1, 'Minas Gerais', 'MG'),
(null, 1, 'Pará', 'PA'),
(null, 1, 'Paraíba', 'PB'),
(null, 1, 'Paraná', 'PR'),
(null, 1, 'Pernambuco', 'PE'),
(null, 1, 'Piauí', 'PI'),
(null, 1, 'Rio de Janeiro', 'RJ'),
(null, 1, 'Rio Grande do Norte', 'RN'),
(null, 1, 'Rio Grande do Sul', 'RS'),
(null, 1, 'Rondônia', 'RO'),
(null, 1, 'Roraima', 'RR'),
(null, 1, 'Santa Catarina', 'SC'),
(null, 1, 'São Paulo', 'SP'),
(null, 1, 'Sergipe', 'SE'),
(null, 1, 'Tocantins', 'TO'),

(null, 2, 'Buenos Aires', 'BA'),
(null, 2, 'Catamarca', 'CA'),
(null, 2, 'Chaco', 'CH'),
(null, 2, 'Chubut', 'CT'),
(null, 2, 'Córdoba', 'CB'),
(null, 2, 'Corrientes', 'CR'),
(null, 2, 'Entre Ríos', 'ER'),
(null, 2, 'Formosa', 'FO'),
(null, 2, 'Jujuy', 'JY'),
(null, 2, 'La Pampa', 'LP'),
(null, 2, 'La Rioja', 'LR'),
(null, 2, 'Mendoza', 'MZ'),
(null, 2, 'Misiones', 'MI'),
(null, 2, 'Neuquén', 'NQ'),
(null, 2, 'Río Negro', 'RN'),
(null, 2, 'Salta', 'SA'),
(null, 2, 'San Juan', 'SJ'),
(null, 2, 'San Luis', 'SL'),
(null, 2, 'Santa Cruz', 'SC'),
(null, 2, 'Santa Fe', 'SF'),
(null, 2, 'Santiago del Estero', 'SE'),
(null, 2, 'Tierra del Fuego', 'TF'),
(null, 2, 'Tucumán', 'TU'),

(null, 3, 'Alabama', 'AL'),
(null, 3, 'Alaska', 'AK'),
(null, 3, 'Arizona', 'AZ'),
(null, 3, 'Arkansas', 'AR'),
(null, 3, 'California', 'CA'),
(null, 3, 'Colorado', 'CO'),
(null, 3, 'Connecticut', 'CT'),
(null, 3, 'Delaware', 'DE'),
(null, 3, 'Florida', 'FL'),
(null, 3, 'Georgia', 'GA'),
(null, 3, 'Hawaii', 'HI'),
(null, 3, 'Idaho', 'ID'),
(null, 3, 'Illinois', 'IL'),
(null, 3, 'Indiana', 'IN'),
(null, 3, 'Iowa', 'IA'),
(null, 3, 'Kansas', 'KS'),
(null, 3, 'Kentucky', 'KY'),
(null, 3, 'Louisiana', 'LA'),
(null, 3, 'Maine', 'ME'),
(null, 3, 'Maryland', 'MD'),
(null, 3, 'Massachusetts', 'MA'),
(null, 3, 'Michigan', 'MI'),
(null, 3, 'Minnesota', 'MN'),
(null, 3, 'Mississippi', 'MS'),
(null, 3, 'Missouri', 'MO'),
(null, 3, 'Montana', 'MT'),
(null, 3, 'Nebraska', 'NE'),
(null, 3, 'Nevada', 'NV'),
(null, 3, 'New Hampshire', 'NH'),
(null, 3, 'New Jersey', 'NJ'),
(null, 3, 'New Mexico', 'NM'),
(null, 3, 'New York', 'NY'),
(null, 3, 'North Carolina', 'NC'),
(null, 3, 'North Dakota', 'ND'),
(null, 3, 'Ohio', 'OH'),
(null, 3, 'Oklahoma', 'OK'),
(null, 3, 'Oregon', 'OR'),
(null, 3, 'Pennsylvania', 'PA'),
(null, 3, 'Rhode Island', 'RI'),
(null, 3, 'South Carolina', 'SC'),
(null, 3, 'South Dakota', 'SD'),
(null, 3, 'Tennessee', 'TN'),
(null, 3, 'Texas', 'TX'),
(null, 3, 'Utah', 'UT'),
(null, 3, 'Vermont', 'VT'),
(null, 3, 'Virginia', 'VA'),
(null, 3, 'Washington', 'WA'),
(null, 3, 'West Virginia', 'WV'),
(null, 3, 'Wisconsin', 'WI'),
(null, 3, 'Wyoming', 'WY')
;
