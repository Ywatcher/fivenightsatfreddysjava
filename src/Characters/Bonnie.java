package Characters;

import Core.FullObservation;
import Enum.EnumCharacters;
import Enum.EnumRooms;

import java.util.ArrayList;

public class Bonnie extends Character {

	public Bonnie(int difficulty) {
		super(difficulty);
		this.name = EnumCharacters.IDBonnie;
		this.tickPeriod = 1000;
		this.locations = new ArrayList<>() {{
			add(EnumRooms.ShowStage);
			add(EnumRooms.DiningArea);
			add(EnumRooms.DiningAreaClose);
			add(EnumRooms.Backstage);
			add(EnumRooms.BackstageClose);
			add(EnumRooms.WestHallA);
			add(EnumRooms.SupplyCloset);
			add(EnumRooms.WestHallB);
			add(EnumRooms.Office);
		}};
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

