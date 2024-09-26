# Rechtschreibtrainer für Volksschulkinder

## Inhaltsverzeichnis
1. [Überblick](#Überblick)
2. [Funktionalität](#Funktionalität)
3. [Klassendiagramm](#Klassendiagramm)
4. [Technologien](#Technologien)
5. [Anleitung zur Ausführung](#Anleitung-zur-Ausführung)
6. [Persistenz](#Persistenz)
7. [Grafische Oberfläche](#Grafische-Oberfläche)
8. [Weiterentwicklungsmöglichkeiten](#Weiterentwicklungsmöglichkeiten)

---

## Überblick
Dieser Rechtschreibtrainer ist speziell für Volksschulkinder entwickelt worden, um die korrekte Schreibweise von Wörtern in einer spielerischen und interaktiven Umgebung zu üben. Die Kinder sehen ein Bild (z.B. einen Hund) und sollen das zugehörige Wort eingeben. Das Programm überprüft die Eingabe und gibt Rückmeldung, ob das Wort richtig geschrieben wurde.

## Funktionalität
Die Hauptfunktionalitäten des Rechtschreibtrainers sind:
- Anzeige eines Bildes mit einer Eingabemöglichkeit für das zugehörige Wort.
- Überprüfung der Eingabe auf korrekte Rechtschreibung.
- Speicherung der Anzahl richtiger und falscher Versuche.
- Zufällige Auswahl eines Wort-Bild-Paars.
- Speicherung und Laden des Trainer-Zustands (inklusive Statistiken) beim Beenden und Starten des Programms.

## Klassendiagramm
Es gibt zwei zentrale Klassen:
1. **WortBildPaar**: Repräsentiert ein Paar aus einem Bild und dem dazugehörigen Wort.
   - Attribute: `wort`, `bildUrl`
   - Methoden: `isValid()`
2. **Rechtschreibtrainer**: Verwaltet eine Liste von Wort-Bild-Paaren, führt die Rechtschreibprüfung durch und speichert den Status.
   - Attribute: `wortBildPaare[]`, `aktuellesPaar`, `statistik`
   - Methoden: `waehleZufaelligesPaar()`, `pruefeWort()`, `ladeDaten()`, `speichereDaten()`

## Technologien
- Programmiersprache: Java
- GUI: `JOptionPane` für die grafische Oberfläche.
- Persistenz: JSON für das Speichern und Laden der Daten (z.B. über die Bibliothek `org.json`).

## Anleitung zur Ausführung
1. Stelle sicher, dass Java installiert ist.
2. Klone das Repository oder lade den Quellcode herunter.
3. Starte das Programm durch Ausführen der `Main.java`.
4. Beim Start werden entweder gespeicherte Daten geladen oder es wird ein neuer Trainer mit festen Wort-Bild-Paaren gestartet.
5. Folge den Anweisungen in den `JOptionPane`-Dialogen.

## Persistenz
Der Zustand des Trainers (die verfügbaren Wort-Bild-Paare, das aktuell ausgewählte Paar und die Statistiken) wird im JSON-Format gespeichert. Dies ermöglicht es, die Session zu einem späteren Zeitpunkt wiederherzustellen.

- Speicherformat: JSON
- Implementierung: Die Daten werden beim Beenden des Programms automatisch gespeichert und beim Starten wieder geladen.
- Austauschbarkeit: Die Implementierung der Persistenz ist gekapselt, sodass eine andere Speicherstrategie (z.B. XML oder eine Datenbank) leicht implementiert werden kann.

## Grafische Oberfläche
Die grafische Oberfläche wurde mittels `JOptionPane` realisiert. Der Ablauf ist wie folgt:
1. Ein zufälliges Wort-Bild-Paar wird ausgewählt.
2. Ein Fenster zeigt das Bild an und fordert das Kind zur Eingabe des zugehörigen Wortes auf.
3. Eine Rückmeldung (richtig oder falsch) wird angezeigt.
4. Die Statistik wird nach jedem Versuch aktualisiert.
5. Bei einem korrekten Versuch wird das nächste Wort-Bild-Paar ausgewählt, andernfalls wird das gleiche Paar erneut angezeigt.

## Weiterentwicklungsmöglichkeiten
- Erweiterung der grafischen Oberfläche für eine attraktivere Darstellung (z.B. durch Nutzung von `Swing` oder `JavaFX`).
- Hinzufügen von Schwierigkeitsgraden (z.B. längere oder schwierigere Wörter).
- Integration einer Sprachausgabe zur Unterstützung der Kinder beim Lernen.
- Erweiterte Statistiken, wie die durchschnittliche Zeit pro Versuch.
