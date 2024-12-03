Drop Table If Exists Personne, Beneficiaire, Compte, DroitDeGestion, Transaction;
Drop Domain If Exists domainCompte, IbanCheck, NumeroCheck;

-----------------------------------------------------------
/*Domaines pour les types de comptes, le numéro de compte et L'IBAN*/

Create Domain domainCompte As varchar
	Check(Value IN (
	'Livret A','Compte de Dépôt','Livret de développement durable et solidaire','Livret d''épargne populaire','Livret jeune','Compte épargne logement','Plan épargne logement','Plan d''épargne retraite populaire','Compte d''épargne','livret d''épargne bancaire','Compte à terme'
	));

Create Domain IbanCheck As varchar
	Check(Value Similar To('[A-Z]{2}[0-9]{25}'));

Create Domain NumeroCheck As varchar
	Check(Value Similar To('[0-9]{11}'));

------------------------------------------------------------
/*Creation des tables Personne,Beneficiaire,Compte,DroitDeGestion et Transaction*/

CREATE TABLE Personne(
	idpers varchar(3) Primary Key,
	nom varchar Not Null,
	prenom varchar Not Null
	);
CREATE TABLE Beneficiaire(
	idbenef varchar(3) Primary Key,
	nom varchar Not Null,
	prenom varchar Not Null
	);
CREATE TABLE Compte(
	proprietaire varchar(3) Not Null,
	numero NumeroCheck Primary Key,
	iban IbanCheck Not null Unique,
	typeCompte domainCompte Not Null,
	montant varchar Not Null,
	Foreign Key(proprietaire) References Personne(idpers)
	);
CREATE TABLE DroitDeGestion(
	personne varchar(3) Not Null,
	compte NumeroCheck Not Null,
	Foreign Key(personne) References Personne(idpers),
	Foreign Key(compte) References Compte(numero),
	PRIMARY KEY(personne,compte)
    );

CREATE TABLE Transaction(
	id_transaction varchar(5) Primary Key,
	IbanCredite IbanCheck Not Null,
	IbanDebite IbanCheck Not Null,
	Montant varchar Not Null,
	Foreign Key(IbanCredite) References Compte(Iban),
	Foreign Key(IbanDebite) References Compte(Iban)
	);