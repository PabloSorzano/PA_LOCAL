use SmartHouse;

select * from usuario;
select * from casa;
select * from catalogo_dispositivos;
select * from cuarto;
select * from cuarto_dispositivos;

drop procedure if exists sp_AltaUsuario;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AltaUsuario`(in xNombre varchar(50), in xAPat varchar(50), in xAMat varchar(50), in xTelefonoM varchar(10), in xEmail varchar(100), in xContraseña varchar(100))
begin
declare xIDU int;
declare xMsj VARCHAR(50);
declare existe int;
	insert into usuario (idUsuario,Nombre,Apellido_Paterno,Apellido_Materno,Telefono_Movil,Email,contrasenia) values (null,xNombre,xAPat,xAMat,xTelefonoM,xEmail,xContraseña);
end ;;
DELIMITER ;
#///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
drop procedure if exists sp_AltaCasa;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AltaCasa`(in xidUser int, in xCoorde varchar(200), in xEstado varchar(25), in xMunicipio varchar(25), in xCodigoPostal varchar(5), in xColonia varchar(25), in xCalle varchar(25), in xNumInt varchar(10))
begin
declare xIDU int;
declare xMsj VARCHAR(50);
declare existe int;
declare existe1 int;

set existe=(select count(*) from casa where casa.idUsuario=xidUser);
if (existe=0) then
	insert into casa (idCasa,idUsuario,Coordenadas,Estado,Municipio,CodigoPostal,Colonia,Calle,Numero_Interior) values (null,xidUser,xCoorde,xEstado,xMunicipio,xCodigoPostal,xColonia,xCalle,xNumInt);
	set xMsj='Registro exitoso';
    select xMsj;
else
	set xMsj='El usuario ya está registrado';
	select xMsj;
end if;
	
end ;;
DELIMITER ;
#///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
drop procedure if exists sp_AltaCuarto;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AltaCuarto`(in xidUser int, in xCoorde varchar(200), in xEstado varchar(25), in xMunicipio varchar(25), in xCodigoPostal varchar(5), in xColonia varchar(25), in xCalle varchar(25), in xNumInt varchar(10))
begin
declare xIDU int;
declare xMsj VARCHAR(50);
declare existe int;
declare existe1 int;

set existe=(select count(*) from casa where casa.idUsuario=xidUser);
if (existe=0) then
	insert into casa (idCasa,idUsuario,Coordenadas,Estado,Municipio,CodigoPostal,Colonia,Calle,Numero_Interior) values (null,xidUser,xCoorde,xEstado,xMunicipio,xCodigoPostal,xColonia,xCalle,xNumInt);
	set xMsj='Registro exitoso';
    select xMsj;
else
	set xMsj='El usuario ya está registrado';
	select xMsj;
end if;
	
end ;;
DELIMITER ;
#///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
drop procedure if exists sp_EliminaDatos;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_EliminaDatos`(in idUsuario int)
begin
	delete from Usuario where Usuario.idUsuario = idUsuario;
end ;;
DELIMITER ;
#///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
drop procedure if exists sp_EliminaCasa;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_EliminaCasa`(in idUsuario int)
begin
	delete from Usuario where Usuario.idUsuario = idUsuario;
end ;;
DELIMITER ;
#///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
drop procedure if exists sp_EliminaCuestionario;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_EliminaCuestionario`(in XTitulo varchar(500))
begin

declare xMsj VARCHAR(500);
declare existe int;
declare idC int;

set existe=(select count(*) from Cuestionario where Cuestionario.TituloC=XTitulo);						

if (existe=1) then
		
        set idC  = (select idCuestionario from Cuestionario where Cuestionario.TituloC=XTitulo);
		delete from preguntaCerrada where preguntaCerrada.idCuestionario=idC; 
        delete from preguntaAbierta where preguntaabierta.idCuestionario=idC;
        delete from preguntas where preguntas.IdCuestionario=idC;
        delete from cuestionario where Cuestionario.idCuestionario=idC;
        set xMsj='Teoria eliminada, puta que sad';
        select xMsj;
else
     set xMsj='La teoria no existe con el titulo ingresado, puta que sad';
     select xMsj;
end if;
end ;;
DELIMITER ;
#//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


