package Characters;

import Characters.Character;
import Core.FullObservation;
import Enum.EnumCharacters;
public class Bonnie extends Character {


	public Bonnie(int difficulty) {
		super(difficulty);
		this.name = EnumCharacters.IDBonnie;
		this.tickPeriod = 1000;
	}

	public void tick(FullObservation obs, tools.Timer timer) {

		if (state == 8 && obs.isOfficeDoor1Open() && obs.isOfficeMonitorUp()) {
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
					if (obs.getChickaState() == state + 1
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
					if (obs.getChickaState() == state + 1
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
						if (obs.getChickaState() == state + 1
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

