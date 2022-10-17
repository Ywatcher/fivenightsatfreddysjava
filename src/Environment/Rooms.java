package Environment;

import Enum.EnumCameras;
import Enum.EnumRooms;
import Enum.EnumDistance;

public class Rooms {
    /*
    * this class offers the information of room states,
    * and mapping between cameras with rooms.
    * this class should not contain(or depend on) anything about characters.
    * */

    private Integer pirateCoveStage=0;

    public EnumDistance lookFrmCamera(EnumCameras camera, EnumRooms room){
        EnumDistance distance = null;
        switch (camera){
            case CAM1A -> {
                if (room== EnumRooms.ShowStage)
                    distance = EnumDistance.Far;
                else distance = EnumDistance.None;
            }
            case CAM1B -> {
                if (room == EnumRooms.DiningArea)
                    distance = EnumDistance.Far;
                else if (room== EnumRooms.DiningAreaClose)
                    distance = EnumDistance.Close;
                else distance = EnumDistance.None;
                }
            case CAM1C -> {
                if(room== EnumRooms.PirateCove)
                    distance = EnumDistance.Far;
                else distance = EnumDistance.None;
            }
            case CAMs2A -> {
                if(room== EnumRooms.WestHallA)
                    distance = EnumDistance.Far;
                else distance = EnumDistance.None;
            }
            case CAMs2B -> {
                if (room== EnumRooms.WestHallB)
                    distance = EnumDistance.Far;
                else distance = EnumDistance.None;
            }
            case CAM3 -> {
                if (room== EnumRooms.SupplyCloset)
                    distance = EnumDistance.Far;
                else distance = EnumDistance.None;
            }
            case CAMs4A -> {
                if (room== EnumRooms.EastHallA)
                    distance = EnumDistance.Far;
                else if (room== EnumRooms.EastHallAClose)
                    distance = EnumDistance.Close;
                else distance = EnumDistance.None;
            }
            case CAMs4B -> {
                if (room== EnumRooms.EastHallB)
                    distance = EnumDistance.Far;
                else distance = EnumDistance.None;
            }
            case CAM5 -> {
                if (room== EnumRooms.Backstage)
                    distance = EnumDistance.Far;
                else if (room== EnumRooms.BackstageClose)
                    distance = EnumDistance.Close;
                else distance = EnumDistance.None;
            }
            case CAM6 -> {
                if (room== EnumRooms.Kitchen)
                    distance = EnumDistance.Far;
                else distance = EnumDistance.None;
            }
            case CAM7 -> {
                if (room== EnumRooms.Restrooms)
                    distance = EnumDistance.Far;
                else if (room==EnumRooms.RestroomsClose)
                    distance = EnumDistance.Close;
                else distance = EnumDistance.None;
            }
            case Office -> {
                if (room==EnumRooms.Office)
                    distance = EnumDistance.Far;
                else distance = EnumDistance.None;
            }
        }
        return distance;
    }

    public Integer environmentState(EnumCameras camera){
        if(camera== EnumCameras.CAM1C)
            return this.pirateCoveStage;
        else return 0;
    }
    public void incPirateCoveStage(){
        pirateCoveStage = pirateCoveStage + 1;
    }


}
