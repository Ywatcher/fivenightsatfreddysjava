package Characters;

import Characters.Character;
import Core.FullObservation;
import Enum.EnumCharacters;

public class Chicka extends Character {


	public Chicka(int difficulty) {
		super(difficulty);
		this.name = EnumCharacters.IDChicka;
		this.tickPeriod = 1300;

	}

	public void tick(FullObservation obs, tools.Timer timer) {
		if (state == 8 && obs.isOfficeDoor2Open() && obs.isOfficeMonitorUp()) {
			state = 9;
			killPlayer();
			return;
		}
		int rand1 = 1 + (int) (Math.random() * Difficulty);
		if (rand1 == Difficulty) {
			return;
		} else {
			int rand2 = 1 + (int) (Math.random() * 8);
			if (rand2 >= 4) {
				if (rand2 >= state) {
					if (obs.getBonnieState() == state + 1
							|| obs.getFreddyState() == state + 1) {
						return;
					} else {
						if (state + 1 > 8) {
							return;
						} else {
							state = 1 + state;
						}
					}
				} else {
					return;
				}
			} else {
				if (rand2 >= state) {
					if (obs.getBonnieState() == state + 1
							|| obs.getFreddyState() == state + 1) {
						return;
					} else {
						if (state + 1 > 8) {
							return;
						} else {
							state = state + 1;
						}
					}
				} else {
					if (rand2 == state) {
						if (obs.getBonnieState() == state + 1
								|| obs.getFreddyState() == state + 1) {
							return;
						} else {
							state = state - 1;
						}
						return;
					}
					return;
				}
			}
		}
	}
}

