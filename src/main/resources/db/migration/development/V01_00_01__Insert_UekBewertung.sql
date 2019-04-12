INSERT INTO uekbewertung.user (first_name, last_name, password) VALUES 
		('Joel', 'Ahameafule', '$2a$04$NJIdeWhWhwXFNJHna081iOg7o.FiyDjCI/C9MCFprUIVRuBSRHPGy'),
		('Erik', 'Lohse', '$2a$04$NJIdeWhWhwXFNJHna081iOg7o.FiyDjCI/C9MCFprUIVRuBSRHPGy');

INSERT INTO uekbewertung.authority VALUES (
	1,
				'WRITE'
			);
INSERT INTO uekbewertung.authority VALUES (
	2,
				'READ'
			);
			
			
INSERT INTO uekbewertung.role	VALUES (
	1,
			'ADMIN'
		);
INSERT INTO uekbewertung.role	VALUES (
	2,
			'USER'
		);
		
/*
 * Link Authorities to Role-Admin (read & write)
 * public.authority_role(authority_id, role_id)
 * */		
INSERT INTO uekbewertung.authority_role VALUES (
			1, 
			1
		);
INSERT INTO uekbewertung.authority_role VALUES (
			2, 
			1
		);
		
INSERT INTO uekbewertung.authority_role VALUES (
			2, 
			2
		);

INSERT INTO uekbewertung.users_role VALUES (
			1, 
			1
		);	
INSERT INTO uekbewertung.users_role VALUES (
			2, 
			2
		);

INSERT INTO uekbewertung.location (city, postal, street, telephone) VALUES 
		('Zürich', '8048', 'Herostrasse 12', '031 917 53 80'),
		('Worblaufen', '3048', 'Worblaufenstrasse 200', '031 917 53 80');
		
INSERT INTO uekbewertung.course (course_number, course_lead, location) VALUES
		('223', 1, 1),
		('223', 7, 2),
		('223', 3, 2),
		('223', 5, 1),
		('223', 7, 1);
		
INSERT INTO uekbewertung.question (text) VALUES
		('Die Organisation des üK entsprach meinen Erwartungen.'),
		('Die vermittelten Lerninhalte decken die Handlungsziele des Moduls ab.'),
		('Ich hatte genügend Zeit, um meine Aufträge und die Übungen zu erledigen.'),
		('Die Lernformen im UK waren abwechslungsreich.'),
		('Die zur Verfügung gestellten Mittel und Unterlagen haben mich unterstützt.'),
		('Ich konnte den Inhalt gut verstehen.');