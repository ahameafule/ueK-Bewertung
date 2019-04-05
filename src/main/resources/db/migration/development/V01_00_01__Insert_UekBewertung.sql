INSERT INTO uekbewertung.user (first_name, last_name) VALUES 
		('Joel', 'Ahameafule'),
		('Erik', 'Lohse'), 
		('Santiago', 'Vollmar'),
		('Moritz', 'Lauper'),
		('Tom', 'Wilhelm'),
		('Kevin', 'Bodmer'),
		('Dele', 'Alli');
		
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
		('Die Organisation des ÜK entsprach meinen Erwartungen.'),
		('Die vermittelten Lerninhalte decken die Handlungsziele des Moduls ab.'),
		('Ich hatte genügend Zeit, um meine Aufträge und die Übungen zu erledigen.'),
		('Die Lernformen im ÜK waren abwechslungsreich.'),
		('Die zur Verfügung gestellten Mittel und Unterlagen haben mich unterstützt.'),
		('Ich konnte den Inhalt gut verstehen.');