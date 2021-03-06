public class MinionGame {

	public static void main(String[] args) {
		int positionNorbert = getPositionNorbert();
		int minionsLeft = getMinionsLeft(positionNorbert);
		int minionsRight = getMinionsRight(positionNorbert);
		int minionsLeftTaken = 0;
		int minionsRightTaken = 0;
		int starter = getBeginner();
		int minionsTotalPlayer = 0;
		int minionsTotalComputer = 0;

		// Ausgabe der Position von Norbert,
		System.out.println("Norbert ist an Position ");
		getOrder(positionNorbert, minionsLeft, minionsRight, minionsLeftTaken, minionsRightTaken);

		// Ausgabe der Position von Norbert,
		System.out.println("Norbert ist an Position " + (positionNorbert));

		// AUsgabe der Anzahl von Minions links
		System.out.println("Es sind " + getMinionsLeft(positionNorbert) + " Minions Links");

		// Ausgabe der Anzahl von Minions rechts
		System.out.println("Es sind " + getMinionsRight(positionNorbert) + " Minions Rechts");

		// Beginner feststellen durch Aufrufen der Methode
		getBeginner();

		// Schleife für den Spielverlauf

		while ((minionsLeft > 0) && (minionsRight > 0)) {
			getOrder(positionNorbert, minionsLeft, minionsRight, minionsLeftTaken, minionsRightTaken);
			if (starter == 1) {

				boolean choiceValid = false;
				int choice = 0;
				char side = 0;
				char takeNorbert = 'n';

				while (choiceValid == false) {
					choice = 0;
					System.out.println(
							"Von welcher Seite willst du ziehen?(Eingabe 'l' für Links, Eingabe 'r' für Rechts");
					side = StaticScanner.nextChar();
					while (choiceValid = true) {

						if (side == 'r' || side == 'l') {
							System.out.println("Wähle zwischen 1 und 3 Minions");
							choice = StaticScanner.nextInt();

							if (choice == 1 || choice == 2 || choice == 3) {
								if (side == 'r' && minionsRight >= choice || side == 'l' && minionsLeft >= choice) {

									if (side == 'l') {

										minionsLeft = minionsLeft - choice;
										minionsLeftTaken = minionsLeftTaken + choice;

									} else if (side == 'r') {

										minionsRight = minionsRight - choice;
										minionsRightTaken = minionsRightTaken + choice;
									}
									System.out.println("Du ziehst " + choice + " Minions von " + side);

									System.out.println("erfolgreicher Zug vom Spieler");
									choiceValid = true;
									System.out.println("Du ziehst " + choice + " Minions von " + side);
									minionsTotalPlayer = minionsTotalPlayer + choice;
									System.out.println("Du hast " + minionsTotalPlayer + " Minions in Total");

									break;
								}

							} else {
								if ((side == 'l') && (choice > minionsLeft)) {

									System.out.println("Du musst zwischen 1 und 3 Minions wählen!");
									choiceValid = false;
								} else if ((side == 'r') && (choice > minionsRight)) {

									System.out.println("Du musst zwischen 1 und 3 Minions wählen!");
									choiceValid = false;
								} else if ((minionsLeft < 1) || (minionsRight < 1)){
									System.out.println ("Auf dieser Seite ist nur noch Norbert übrig");
									System.out.println ("Möchtest du wirklich Norbert ziehen? Du hast dann verloren!");
									System.out.println ("Gebe 'y' für Ja und 'n' für nein ein:");
									takeNorbert = StaticScanner.nextChar();
										if( takeNorbert == 'n') {
											choiceValid = false;
									}
										
										else if (takeNorbert == 'y') {
											choiceValid = true;
										}
								}
								
							}

						} else {
							System.out.println("Du musst l oder r eingeben um die Seite zu wählen");
							choiceValid = false;
						}
					}

				}

				System.out.println("Player Zug beendet.");
				starter = 0;

			} else if (starter == 0) {
				int choice = 0;
				char side = 0;
				if ((minionsLeft == 1 || minionsLeft == 2 || minionsLeft == 3) && minionsLeft < minionsRight) {
					// hier noch 3,2 oder 1 auswählen
					choice = 1;
					side = 'l';
					minionsLeft = minionsLeft - choice;
					minionsLeftTaken = minionsLeftTaken + choice;
					System.out.println("3,2 oder 1 von Links");

				} else if ((minionsRight == 1 || minionsRight == 2 || minionsRight == 3)
						&& minionsLeft > minionsRight) {
					// hier noch 3,2 oder 1 auswählen
					choice = 1;
					side = 'r';
					minionsRight = minionsRight - choice;
					minionsRightTaken = minionsRightTaken + choice;
					System.out.println("3,2 oder 1 von Rechts");
				} else {
					double probabilitySide = Math.random();
					double probabilityAmount = Math.random();
					if (probabilitySide > 0.5) {

						// links

						if (probabilityAmount <= 0.3) {

							choice = 1;
							side = 'l';
							minionsLeft = minionsLeft - choice;
							minionsLeftTaken = minionsLeftTaken + choice;
							System.out.println("Ich nehme 1 Minion von Links");
						} else if (probabilityAmount > 0.3 && probabilityAmount <= 0.6) {

							choice = 2;
							side = 'l';
							minionsLeft = minionsLeft - choice;
							minionsLeftTaken = minionsLeftTaken + choice;
							System.out.println("Ich nehme 2 Minions von Links");
						} else if (probabilityAmount > 0.6 && probabilityAmount < 1) {

							choice = 3;
							side = 'l';
							minionsLeft = minionsLeft - choice;
							minionsLeftTaken = minionsLeftTaken + choice;
							System.out.println("Ich nehme 3 Minions von Links");
						}
					} else {

						// rechts

						if (probabilityAmount <= 0.3) {
							choice = 1;
							side = 'r';
							minionsRight = minionsRight - choice;
							minionsRightTaken = minionsRightTaken + choice;
							System.out.println("Ich nehme 1 Minion von Rechts");
						} else if (probabilityAmount > 0.3 && probabilityAmount <= 0.6) {

							choice = 2;
							side = 'r';
							minionsRight = minionsRight - choice;
							minionsRightTaken = minionsRightTaken + choice;
							System.out.println("Ich nehme 2 Minions von Rechts");
						} else if (probabilityAmount > 0.6 && probabilityAmount < 1) {

							choice = 3;
							side = 'r';
							minionsRight = minionsRight - choice;
							minionsRightTaken = minionsRightTaken + choice;
							System.out.println("Ich nehme 3 Minions von Rechts");

						}
					}

				}

				System.out.println("Der Computer zieht " + choice + " Minions von " + side);

				System.out.println("Computer Zug beendet.");
				starter = 1;
				minionsTotalComputer = minionsTotalComputer + choice;
			} else {
				System.out.println("Fehler");

			}

		}

	}

	// Methoden

	// Methode für Position Norbert erhalten

	public static int getPositionNorbert() {
		int positionNorbert = 1;

		while (positionNorbert < 3 || positionNorbert > 9) {

			positionNorbert = (int) (Math.random() * 10);
		}

		return positionNorbert;

	}

	// Methode für Anzahl Minions links erhalten

	public static int getMinionsLeft(int positionNorbert) {
		int minionsLeft;

		minionsLeft = positionNorbert - 1;

		return minionsLeft;

	}

	// Methode für Minions rechts erhalten

	public static int getMinionsRight(int positionNorbert) {
		int minionsRight;

		minionsRight = 11 - positionNorbert;

		return minionsRight;

	}

	// Methode für Reihenfolge als String erstellen und oben aufrufen bzw anzeigen
	// können

	public static void getOrder(int positionNorbert, int minionsLeft, int minionsRight, int minionsLeftTaken,
			int minionsRightTaken) {

		for (int i = 0; i < 11; i++) {
			// minions links weg
			if (i < minionsLeftTaken) {
				System.out.print(" - ");
				// minions links
			} else if (((i < (minionsLeft + minionsLeftTaken) && (i < positionNorbert) && (i > minionsLeftTaken)))) {
				System.out.print(" M ");
				// minions rechts
			} else if (i < (minionsLeftTaken + minionsLeft + 1 + minionsRight) && (i > positionNorbert)) {
				System.out.print(" M ");
			}
			// minions rechts weg
			else if ((i < 11) && (i >= (minionsLeftTaken + minionsLeft + 1 + minionsRight))) {
				System.out.print(" - ");
			} else if (i == positionNorbert) {
				System.out.print(" O ");
			}
		}
	}

	// Methode um den Beginner festzulegen

	public static int getBeginner() {
		double starterSelection;
		int starter;

		starterSelection = Math.random();
		if (starterSelection >= 0.5)

		{
			System.out.println("Computer beginnt");
			starter = 0;

		} else {
			System.out.println("Spieler beginnt");
			starter = 1;
		}

		return starter;
	}

}
