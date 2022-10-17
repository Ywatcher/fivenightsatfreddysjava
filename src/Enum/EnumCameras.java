package Enum;

public enum EnumCameras {
    CAM1A, // -> ShowStage, //0 for b, c, fr
    CAM1B, // -> DiningArea, //1 for bonnie, chicka, freddy; 2 for b, c close
    CAM1C, // -> PirateCove, //0 for fo-0, 1 for fo-1, 2 .. 3 .. (foxy not here at stage 3)
    CAMs2A, // -> WestHallA, //5 for b
    CAMs2B, // -> WestHallB, //7 for b, 3 for foxy ( foxy run)
    CAM3, // -> SupplyCloset, //6 for b
    CAMs4A, // -> EastHallA, //5 for c, 3 for fr, 6 for c close
    CAMs4B, // -> EastHallB, //7 for c, 4 for fr
    CAM5, // -> Backstage, //3 for b, 4 for b close,
    CAM6, // -> Kitchen
    CAM7, // -> Restrooms, //3 for c, 4 for c close, 2 for fr
    Office// Environent.Office
    // office is not camera; yet we include it to out enumeration without a loss of generality
}
