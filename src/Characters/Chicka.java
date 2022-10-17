package Characters;

import Core.FullObservation;
import Enum.EnumCharacters;
import Enum.EnumRooms;
import java.util.ArrayList;


public class Chicka extends Character {


	public Chicka(int difficulty) {
		super(difficulty);
		this.name = EnumCharacters.IDChicka;
		this.tickPeriod = 1300;
		this.locations = new ArrayList<>() {{
			add(EnumRooms.ShowStage);
			add(EnumRooms.DiningArea);
			add(EnumRooms.DiningAreaClose);
			add(EnumRooms.Restrooms);
			add(EnumRooms.RestroomsClose);
			add(EnumRooms.EastHallA);
			add(EnumRooms.EastHallAClose);
			add(EnumRooms.EastHallB);
			add(EnumRooms.Office);
		}};
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

