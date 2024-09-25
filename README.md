# Thomas Laber
Projektbeschreibung

Dieses Projekt ist ein Rechtschreibtrainer für Volksschulkinder. Die Anwendung zeigt den Kindern Bilder und fordert sie auf, das entsprechende Wort für das Bild einzugeben. Das Ziel ist es, die richtige Schreibweise von Wörtern zu trainieren. Bei jeder Eingabe wird das eingegebene Wort mit der korrekten Schreibweise verglichen, und das Kind erhält sofortiges Feedback, ob die Eingabe richtig oder falsch war.

Funktionsübersicht

1. Wort-Bild-Paare
   Jedes Wort-Bild-Paar wird durch eine Klasse dargestellt, die ein Wort und die dazugehörige Bild-URL enthält.
   Objekte dieser Klasse sind immer in einem gültigen Zustand, da entsprechende Checks durchgeführt werden (z.B. keine null-Werte, gültige URLs).
2. Rechtschreibtrainer
   Der Rechtschreibtrainer verwaltet eine Sammlung von Wort-Bild-Paaren.
   Zu Beginn ist kein Paar ausgewählt. Ein Wort-Bild-Paar kann entweder explizit durch einen Index oder zufällig ausgewählt werden.
   Nachdem ein Paar ausgewählt wurde:
   Die Bild-URL kann abgerufen werden.
   Das zugehörige Wort kann erraten werden.
   Bei einer falschen Antwort bleibt das aktuelle Paar ausgewählt, und das Kind kann einen neuen Versuch starten.
   Bei einer richtigen Antwort wird das aktuelle Paar abgeschlossen, und ein neues muss vor dem nächsten Versuch ausgewählt werden.
   Der Trainer führt eine Statistik darüber, wie oft Wörter geraten wurden und wie viele Versuche richtig oder falsch waren.
3. Persistenz
   Der Zustand des Rechtschreibtrainers (Wort-Bild-Paare, ausgewähltes Paar und Statistik) wird gespeichert und kann beim nächsten Programmstart wiederhergestellt werden.
   Das Speicherformat kann flexibel gewählt werden (z.B. JSON, XML, SQLite).
   Es wird ein Muster (Design Pattern) implementiert, das eine austauschbare Speicherstrategie ermöglicht.
4. Grafische Benutzeroberfläche
   Die Anwendung verwendet JOptionPane zur Anzeige von Bildern und zur Eingabe der Wörter.
   Ablauf der Benutzerinteraktion:
   Beim Start werden die persistierten Daten geladen. Wenn keine vorhanden sind, wird eine neue Trainer-Session mit festgelegten Wort-Bild-Paaren gestartet.
   Ein Wort-Bild-Paar wird zufällig ausgewählt, und das Bild sowie die Statistik werden angezeigt.
   Das Kind gibt das Wort ein.
   Es wird sofortiges Feedback gegeben, ob die Eingabe richtig oder falsch war.
   Die Schleife wiederholt sich, bis das Programm beendet wird.
   Beim Beenden wird der aktuelle Zustand des Trainers persistiert.