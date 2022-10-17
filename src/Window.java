import Characters.Bonnie;
import Characters.Chicka;
import Characters.Foxy;
import Environent.Office;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.*;

public class Window extends JFrame {

	private Office officePerception;

	public static boolean needToMove = true; // perspective move or not
	public static boolean needStatic = false;
	public static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();
	public static double Width = screenSize.getWidth();
	public static double Height = screenSize.getHeight();
	public static int cameraPosition;
	public static int Static = 1;
	public static boolean startGame = false;
	public static boolean startClicked = false;
	public static String cameraLocation = "Show Stage";
	public static boolean isLoading = true;
	public static int officeView = -100;
	private Image Image;
	public static int Fox = 1;
	public static int bonnie = 1;
	public static int foxdie = 1;
	public static int freddie = 1;
	public static int chicka = 1;
	public static int powerOut = 1;
	public static boolean mainmenumusicplaying = false;
	public static boolean gamemusicplaying = false;
	public static boolean screamplay = false;
	private Graphics Graphic;
	static AudioClip knock;
	AudioClip run;
	static AudioClip scream;
	AudioClip ambiance1;
	AudioClip ambiance2;
	AudioClip ambiance3;
	static AudioClip door;
	static AudioClip light;
	AudioClip main1;
	AudioClip main2;
	static AudioClip blip;
	BufferedImage stage;
	BufferedImage currentView;
	BufferedImage
			foxrun1, foxrun2, foxrun3, foxrun4, foxrun5, foxrun6, foxrun7,
			foxrun8, foxrun9, foxrun10, foxrun11, foxrun12, foxrun13, foxrun14,
			foxrun15, foxrun16, foxrun17, foxrun18, foxrun19, foxrun20,
			foxrun21, foxrun22, foxrun23, foxrun24, foxrun25, foxrun26,
			foxrun27, foxrun28, foxrun29, foxrun30, foxrun31, static1, static2,
			static3, static4, static5, static6, static7, static8, mainMenu,
			mainMenu2, mainMenu3, mainMenu4, stageNoBonnie, stageNoChicka,
			stageNoBonnieChicka, stageFreddyStare, stageNone, diningNone,
			diningBonnieFar, diningBonnieClose, diningChickaFar,
			diningChickaClose, diningFreddy, eastHallAChickaFar,
			eastHallAChickaClose, eastHallAFreddy, eastHallANone,
			eastHallBNone, eastHallBChicka, eastHallBFreddy, backstageNone,
			backstageFar, backstageClose, piratecoveStage0, piratecoveStage1,
			piratecoveStage2, piratecoveStage3, restroomsNone,
			restroomsChickaClose, restroomsChickaFar, restroomsFreddy,
			westHallANone, westHallABonnie, westHallBNone, westHallBBonnie,
			supplyclosetNone, supplyclosetBonnie, fiveNightsLogo, newGameLogo,
			arrows, office, officeLeftLight, officeRightLight, officeBonnie,
			officeChicka, officePowerOut, officePowerOutFreddy, name,
			cameraBar, loading, newspaper, leftNone, leftLight, leftDoor,
			leftBoth, rightNone, rightLight, rightDoor, rightBoth,
			cameraMinimap, A1, B1, C1, A2, B2, Three, A4, B4, Five, Six, blank,
			supplycloset, showstage, piratecove, backstage, diningarea,
			westhall, ehallcorner, whallcorner, restrooms, easthall, use1,
			use2, use3, use4, use5, use, powerleft, percentsign, leftdoor1,
			leftdoor2, leftdoor3, leftdoor4, leftdoor5, leftdoor6, leftdoor7,
			leftdoor8, leftdoor9, leftdoor10, leftdoor11, leftdoor12,
			leftdoor13, rightdoor1, rightdoor2, rightdoor3, rightdoor4,
			rightdoor5, rightdoor6, rightdoor7, rightdoor8, rightdoor9,
			rightdoor10, rightdoor11, rightdoor12, rightdoor13, onehundred,
			ninety, eighty, seventy, sixty, fifty, forty, thirty, twenty, ten,
			zero, lose, win;

	private BufferedImage[] imgsBonnie;
	private BufferedImage[] imgsChicka;
	private BufferedImage[] imgsFoxy;
	private BufferedImage[] imgsFreddy;
 	private BufferedImage[] imgsPowerOut;
	private BufferedImage[] imgsUsageBar; 
	


	public Window() {
		super("Five Nights at Freddy's");
		setSize((int) width(Width), (int) height(Height));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		try {
			knock = Applet.newAudioClip(Window.class.getResource("FoxyKnock.wav"));
			run = Applet.newAudioClip(Window.class.getResource("FoxyRun.wav"));
			scream = Applet.newAudioClip(Window.class.getResource("XSCREAM.wav"));
			ambiance1 = Applet.newAudioClip(Window.class.getResource("Ambiance1.wav"));
			ambiance2 = Applet.newAudioClip(Window.class.getResource("Ambience2.wav"));
			door = Applet.newAudioClip(Window.class.getResource("Door.wav"));
			light = Applet.newAudioClip(Window.class.getResource("Ambiance3.wav"));
			main1 = Applet.newAudioClip(Window.class.getResource("Mainmenu1.wav"));
			main2 = Applet.newAudioClip(Window.class.getResource("Mainmenu2.wav"));
			blip = Applet.newAudioClip(Window.class.getResource("blip.wav"));
		} catch (Exception a) {
			a.printStackTrace();
		}
		// load img
		try {
			loading = ImageIO.read(Window.class.getResource("jump.jpg"));
			lose = ImageIO.read(Window.class.getResource("Lose.png"));
			win = ImageIO.read(Window.class.getResource("StandardWin.png"));
			zero = ImageIO.read(Window.class.getResource("zero.png"));
			ten = ImageIO.read(Window.class.getResource("ten.png"));
			twenty = ImageIO.read(Window.class.getResource("twenty.png"));
			thirty = ImageIO.read(Window.class.getResource("thirty.png"));
			forty = ImageIO.read(Window.class.getResource("forty.png"));
			fifty = ImageIO.read(Window.class.getResource("fifty.png"));
			sixty = ImageIO.read(Window.class.getResource("sixty.png"));
			seventy = ImageIO.read(Window.class.getResource("seventy.png"));
			eighty = ImageIO.read(Window.class.getResource("eighty.png"));
			ninety = ImageIO.read(Window.class.getResource("ninety.png"));
			onehundred = ImageIO.read(Window.class
					.getResource("onehundred.png"));
			supplycloset = ImageIO.read(Window.class.getResource("50.png"));
			showstage = ImageIO.read(Window.class.getResource("54.png"));
			piratecove = ImageIO.read(Window.class.getResource("70.png"));
			backstage = ImageIO.read(Window.class.getResource("71.png"));
			diningarea = ImageIO.read(Window.class.getResource("72.png"));
			westhall = ImageIO.read(Window.class.getResource("74.png"));
			ehallcorner = ImageIO.read(Window.class.getResource("75.png"));
			whallcorner = ImageIO.read(Window.class.getResource("76.png"));
			restrooms = ImageIO.read(Window.class.getResource("77.png"));
			easthall = ImageIO.read(Window.class.getResource("79.png"));
			blank = ImageIO.read(Window.class.getResource("blank.png"));
			leftdoor1 = ImageIO.read(Window.class.getResource("89.png"));
			leftdoor2 = ImageIO.read(Window.class.getResource("91.png"));
			leftdoor3 = ImageIO.read(Window.class.getResource("92.png"));
			leftdoor4 = ImageIO.read(Window.class.getResource("93.png"));
			leftdoor5 = ImageIO.read(Window.class.getResource("94.png"));
			leftdoor6 = ImageIO.read(Window.class.getResource("95.png"));
			leftdoor7 = ImageIO.read(Window.class.getResource("96.png"));
			leftdoor8 = ImageIO.read(Window.class.getResource("97.png"));
			leftdoor9 = ImageIO.read(Window.class.getResource("98.png"));
			leftdoor10 = ImageIO.read(Window.class.getResource("99.png"));
			leftdoor11 = ImageIO.read(Window.class.getResource("100.png"));
			leftdoor12 = ImageIO.read(Window.class.getResource("101.png"));
			leftdoor13 = ImageIO.read(Window.class.getResource("102.png"));
			rightdoor1 = ImageIO.read(Window.class.getResource("106.png"));
			rightdoor2 = ImageIO.read(Window.class.getResource("107.png"));
			rightdoor3 = ImageIO.read(Window.class.getResource("108.png"));
			rightdoor4 = ImageIO.read(Window.class.getResource("109.png"));
			rightdoor5 = ImageIO.read(Window.class.getResource("110.png"));
			rightdoor6 = ImageIO.read(Window.class.getResource("111.png"));
			rightdoor7 = ImageIO.read(Window.class.getResource("112.png"));
			rightdoor8 = ImageIO.read(Window.class.getResource("113.png"));
			rightdoor9 = ImageIO.read(Window.class.getResource("114.png"));
			rightdoor10 = ImageIO.read(Window.class.getResource("115.png"));
			rightdoor11 = ImageIO.read(Window.class.getResource("116.png"));
			rightdoor12 = ImageIO.read(Window.class.getResource("117.png"));
			rightdoor13 = ImageIO.read(Window.class.getResource("118.png"));
			A1 = ImageIO.read(Window.class.getResource("170.png"));
			B1 = ImageIO.read(Window.class.getResource("171.png"));
			C1 = ImageIO.read(Window.class.getResource("177.png"));
			A2 = ImageIO.read(Window.class.getResource("172.png"));
			B2 = ImageIO.read(Window.class.getResource("165.png"));
			Three = ImageIO.read(Window.class.getResource("168.png"));
			A4 = ImageIO.read(Window.class.getResource("169.png"));
			B4 = ImageIO.read(Window.class.getResource("173.png"));
			Five = ImageIO.read(Window.class.getResource("174.png"));
			Six = ImageIO.read(Window.class.getResource("175.png"));
			fiveNightsLogo = ImageIO.read(Window.class.getResource("444.png"));
			newGameLogo = ImageIO.read(Window.class.getResource("448.png"));
			arrows = ImageIO.read(Window.class.getResource("450.png"));
			mainMenu = ImageIO.read(Window.class.getResource("431.png"));
			name = ImageIO.read(Window.class.getResource("433.png"));
			mainMenu2 = ImageIO.read(Window.class.getResource("440.png"));
			mainMenu3 = ImageIO.read(Window.class.getResource("441.png"));
			mainMenu4 = ImageIO.read(Window.class.getResource("539.png"));
			newspaper = ImageIO.read(Window.class.getResource("539.png"));
			office = ImageIO.read(Window.class.getResource("39.png"));
			cameraMinimap = ImageIO.read(Window.class.getResource("145.png"));
			leftNone = ImageIO.read(Window.class.getResource("122.png"));
			leftLight = ImageIO.read(Window.class.getResource("125.png"));
			leftDoor = ImageIO.read(Window.class.getResource("124.png"));
			leftBoth = ImageIO.read(Window.class.getResource("130.png"));
			rightNone = ImageIO.read(Window.class.getResource("134.png"));
			rightDoor = ImageIO.read(Window.class.getResource("135.png"));
			rightLight = ImageIO.read(Window.class.getResource("131.png"));
			rightBoth = ImageIO.read(Window.class.getResource("47.png"));
			officeLeftLight = ImageIO.read(Window.class.getResource("58.png"));
			officeRightLight = ImageIO
					.read(Window.class.getResource("127.png"));
			officeBonnie = ImageIO.read(Window.class.getResource("225.png"));
			officeChicka = ImageIO.read(Window.class.getResource("227.png"));
			officePowerOut = ImageIO.read(Window.class.getResource("304.png"));
			officePowerOutFreddy = ImageIO.read(Window.class
					.getResource("305.png"));
			stage = ImageIO.read(Window.class.getResource("19.png"));
			stageNoBonnie = ImageIO.read(Window.class.getResource("68.png"));
			stageNoChicka = ImageIO.read(Window.class.getResource("223.png"));
			stageNoBonnieChicka = ImageIO.read(Window.class
					.getResource("224.png"));
			stageFreddyStare = ImageIO
					.read(Window.class.getResource("355.png"));
			stageNone = ImageIO.read(Window.class.getResource("484.png"));
			diningNone = ImageIO.read(Window.class.getResource("48.png"));
			diningBonnieFar = ImageIO.read(Window.class.getResource("90.png"));
			diningBonnieClose = ImageIO.read(Window.class
					.getResource("120.png"));
			diningChickaFar = ImageIO.read(Window.class.getResource("215.png"));
			diningChickaClose = ImageIO.read(Window.class
					.getResource("222.png"));
			diningFreddy = ImageIO.read(Window.class.getResource("492.png"));
			eastHallANone = ImageIO.read(Window.class.getResource("67.png"));
			eastHallAChickaFar = ImageIO.read(Window.class
					.getResource("221.png"));
			eastHallAChickaClose = ImageIO.read(Window.class
					.getResource("226.png"));
			eastHallAFreddy = ImageIO.read(Window.class.getResource("487.png"));
			eastHallBNone = ImageIO.read(Window.class.getResource("49.png"));
			eastHallBChicka = ImageIO.read(Window.class.getResource("220.png"));
			eastHallBFreddy = ImageIO.read(Window.class.getResource("486.png"));
			backstageNone = ImageIO.read(Window.class.getResource("83.png"));
			backstageFar = ImageIO.read(Window.class.getResource("205.png"));
			backstageClose = ImageIO.read(Window.class.getResource("555.png"));
			piratecoveStage0 = ImageIO.read(Window.class.getResource("66.png"));
			piratecoveStage1 = ImageIO
					.read(Window.class.getResource("211.png"));
			piratecoveStage2 = ImageIO
					.read(Window.class.getResource("338.png"));
			piratecoveStage3 = ImageIO
					.read(Window.class.getResource("553.png"));
			restroomsNone = ImageIO.read(Window.class.getResource("41.png"));
			restroomsChickaFar = ImageIO.read(Window.class
					.getResource("217.png"));
			restroomsChickaClose = ImageIO.read(Window.class
					.getResource("219.png"));
			restroomsFreddy = ImageIO.read(Window.class.getResource("494.png"));
			westHallANone = ImageIO.read(Window.class.getResource("44.png"));
			westHallABonnie = ImageIO.read(Window.class.getResource("206.png"));
			westHallBNone = ImageIO.read(Window.class.getResource("0.png"));
			westHallBBonnie = ImageIO.read(Window.class.getResource("188.png"));
			supplyclosetNone = ImageIO.read(Window.class.getResource("62.png"));
			supplyclosetBonnie = ImageIO.read(Window.class.getResource("190.png"));
			static1 = ImageIO.read(Window.class.getResource("12.png"));
			static2 = ImageIO.read(Window.class.getResource("13.png"));
			static3 = ImageIO.read(Window.class.getResource("14.png"));
			static4 = ImageIO.read(Window.class.getResource("15.png"));
			static5 = ImageIO.read(Window.class.getResource("16.png"));
			static6 = ImageIO.read(Window.class.getResource("17.png"));
			static7 = ImageIO.read(Window.class.getResource("18.png"));
			static8 = ImageIO.read(Window.class.getResource("20.png"));
			imgsUsageBar = new BufferedImage[5];
			imgsUsageBar[0] = ImageIO.read(Window.class.getResource("212.png"));
			imgsUsageBar[1] = ImageIO.read(Window.class.getResource("213.png"));
			imgsUsageBar[2] = ImageIO.read(Window.class.getResource("214.png"));
			imgsUsageBar[3] = ImageIO.read(Window.class.getResource("456.png"));
			imgsUsageBar[4] = ImageIO.read(Window.class.getResource("455.png"));
			use = ImageIO.read(Window.class.getResource("189.png"));
			powerleft = ImageIO.read(Window.class.getResource("207.png"));
			percentsign = ImageIO.read(Window.class.getResource("208.png"));
			cameraBar = ImageIO.read(Window.class.getResource("420.png"));

			foxrun1 = ImageIO.read(Window.class.getResource("244.png"));
			foxrun2 = ImageIO.read(Window.class.getResource("245.png"));
			foxrun3 = ImageIO.read(Window.class.getResource("246.png"));
			foxrun4 = ImageIO.read(Window.class.getResource("247.png"));
			foxrun5 = ImageIO.read(Window.class.getResource("248.png"));
			foxrun6 = ImageIO.read(Window.class.getResource("250.png"));
			foxrun7 = ImageIO.read(Window.class.getResource("280.png"));
			foxrun8 = ImageIO.read(Window.class.getResource("282.png"));
			foxrun9 = ImageIO.read(Window.class.getResource("283.png"));
			foxrun10 = ImageIO.read(Window.class.getResource("284.png"));
			foxrun11 = ImageIO.read(Window.class.getResource("285.png"));
			foxrun12 = ImageIO.read(Window.class.getResource("286.png"));
			foxrun13 = ImageIO.read(Window.class.getResource("287.png"));
			foxrun14 = ImageIO.read(Window.class.getResource("288.png"));
			foxrun15 = ImageIO.read(Window.class.getResource("289.png"));
			foxrun16 = ImageIO.read(Window.class.getResource("290.png"));
			foxrun17 = ImageIO.read(Window.class.getResource("292.png"));
			foxrun18 = ImageIO.read(Window.class.getResource("302.png"));
			foxrun19 = ImageIO.read(Window.class.getResource("306.png"));
			foxrun20 = ImageIO.read(Window.class.getResource("327.png"));
			foxrun21 = ImageIO.read(Window.class.getResource("329.png"));
			foxrun22 = ImageIO.read(Window.class.getResource("330.png"));
			foxrun23 = ImageIO.read(Window.class.getResource("331.png"));
			foxrun24 = ImageIO.read(Window.class.getResource("332.png"));
			foxrun25 = ImageIO.read(Window.class.getResource("333.png"));
			foxrun26 = ImageIO.read(Window.class.getResource("334.png"));
			foxrun27 = ImageIO.read(Window.class.getResource("335.png"));
			foxrun28 = ImageIO.read(Window.class.getResource("336.png"));
			foxrun29 = ImageIO.read(Window.class.getResource("337.png"));
			foxrun30 = ImageIO.read(Window.class.getResource("339-241.png"));
			foxrun31 = ImageIO.read(Window.class.getResource("340.png"));
			imgsPowerOut = new BufferedImage[]{
					ImageIO.read(Window.class.getResource("326.png")),
					ImageIO.read(Window.class.getResource("307.png")),
					ImageIO.read(Window.class.getResource("348.png")),
					ImageIO.read(Window.class.getResource("308.png")),
					ImageIO.read(Window.class.getResource("309.png")),
					ImageIO.read(Window.class.getResource("310.png")),
					ImageIO.read(Window.class.getResource("311.png")),
					ImageIO.read(Window.class.getResource("312.png")),
					ImageIO.read(Window.class.getResource("313.png")),
					ImageIO.read(Window.class.getResource("314.png")),
					ImageIO.read(Window.class.getResource("315.png")),
					ImageIO.read(Window.class.getResource("316.png")),
					ImageIO.read(Window.class.getResource("317.png")),
					ImageIO.read(Window.class.getResource("318.png")),
					ImageIO.read(Window.class.getResource("319.png")),
					ImageIO.read(Window.class.getResource("320.png")),
					ImageIO.read(Window.class.getResource("321.png")),
					ImageIO.read(Window.class.getResource("322.png")),
					ImageIO.read(Window.class.getResource("323.png")),
					ImageIO.read(Window.class.getResource("324.png")),
					ImageIO.read(Window.class.getResource("325.png"))
			};
			imgsBonnie = new BufferedImage[]{
					ImageIO.read(Window.class.getResource("291.png")),
					ImageIO.read(Window.class.getResource("293.png")),
					ImageIO.read(Window.class.getResource("294.png")),
					ImageIO.read(Window.class.getResource("295.png")),
					ImageIO.read(Window.class.getResource("296.png")),
					ImageIO.read(Window.class.getResource("297.png")),
					ImageIO.read(Window.class.getResource("298.png")),
					ImageIO.read(Window.class.getResource("299.png")),
					ImageIO.read(Window.class.getResource("300.png")),
					ImageIO.read(Window.class.getResource("301.png")),
					ImageIO.read(Window.class.getResource("303.png"))
			};
			imgsChicka = new BufferedImage[]{
					ImageIO.read(Window.class.getResource("65.png")),
					ImageIO.read(Window.class.getResource("69.png")),
					ImageIO.read(Window.class.getResource("216.png")),
					ImageIO.read(Window.class.getResource("228.png")),
					ImageIO.read(Window.class.getResource("229.png")),
					ImageIO.read(Window.class.getResource("230.png")),
					ImageIO.read(Window.class.getResource("231.png")),
					ImageIO.read(Window.class.getResource("232.png")),
					ImageIO.read(Window.class.getResource("233.png")),
					ImageIO.read(Window.class.getResource("234.png")),
					ImageIO.read(Window.class.getResource("235.png")),
					ImageIO.read(Window.class.getResource("236.png")),
					ImageIO.read(Window.class.getResource("237.png")),
					ImageIO.read(Window.class.getResource("239.png")),
					ImageIO.read(Window.class.getResource("279.png")),
					ImageIO.read(Window.class.getResource("281.png"))
			};
			imgsFoxy = new BufferedImage[]{
					ImageIO.read(Window.class.getResource("242.png")),
					ImageIO.read(Window.class.getResource("243.png")),
					ImageIO.read(Window.class.getResource("396.png")),
					ImageIO.read(Window.class.getResource("397.png")),
					ImageIO.read(Window.class.getResource("398.png")),
					ImageIO.read(Window.class.getResource("399.png")),
					ImageIO.read(Window.class.getResource("400.png")),
					ImageIO.read(Window.class.getResource("401.png")),
					ImageIO.read(Window.class.getResource("402.png")),
					ImageIO.read(Window.class.getResource("403.png")),
					ImageIO.read(Window.class.getResource("404.png")),
					ImageIO.read(Window.class.getResource("405.png")),
					ImageIO.read(Window.class.getResource("406.png")),
					ImageIO.read(Window.class.getResource("407.png")),
					ImageIO.read(Window.class.getResource("408.png")),
					ImageIO.read(Window.class.getResource("409.png")),
					ImageIO.read(Window.class.getResource("410.png")),
					ImageIO.read(Window.class.getResource("411.png")),
					ImageIO.read(Window.class.getResource("412.png"))
			};
			imgsFreddy = new BufferedImage[]{
					ImageIO.read(Window.class.getResource("489.png")),
					ImageIO.read(Window.class.getResource("490.png")),
					ImageIO.read(Window.class.getResource("491.png")),
					ImageIO.read(Window.class.getResource("493.png")),
					ImageIO.read(Window.class.getResource("495.png")),
					ImageIO.read(Window.class.getResource("496.png")),
					ImageIO.read(Window.class.getResource("497.png")),
					ImageIO.read(Window.class.getResource("498.png")),
					ImageIO.read(Window.class.getResource("499.png")),
					ImageIO.read(Window.class.getResource("500.png")),
					ImageIO.read(Window.class.getResource("501.png")),
					ImageIO.read(Window.class.getResource("502.png")),
					ImageIO.read(Window.class.getResource("503.png")),
					ImageIO.read(Window.class.getResource("504.png")),
					ImageIO.read(Window.class.getResource("505.png")),
					ImageIO.read(Window.class.getResource("506.png")),
					ImageIO.read(Window.class.getResource("507.png")),
					ImageIO.read(Window.class.getResource("508.png")),
					ImageIO.read(Window.class.getResource("509.png")),
					ImageIO.read(Window.class.getResource("510.png")),
					ImageIO.read(Window.class.getResource("511.png")),
					ImageIO.read(Window.class.getResource("512.png")),
					ImageIO.read(Window.class.getResource("513.png")),
					ImageIO.read(Window.class.getResource("514.png")),
					ImageIO.read(Window.class.getResource("515.png")),
					ImageIO.read(Window.class.getResource("516.png")),
					ImageIO.read(Window.class.getResource("517.png")),
					ImageIO.read(Window.class.getResource("518.png"))
			};
		} catch (IOException a) {
			a.printStackTrace();
		}

		isLoading = false;

	}


	public void paint(Graphics g) {
		Image = createImage(getWidth(), getHeight());
		Graphic = Image.getGraphics();
		paintComponent(Graphic); //TODO : this.Graphic
		g.drawImage(Image, 0, 0, this);
	}

	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, getWidth(), getHeight());
		if (isLoading == true) {
			g.drawImage(loading, 370, 200, this);
		} else {
			if (startGame == false) {
				// TODO : separate the actions that need refreshing with those init once
				if(mainmenumusicplaying == false) {
					main1.play();
					ambiance1.play();
					mainmenumusicplaying = true;
				}
				ambiance2.stop();
				ambiance1.stop(); //?
				needToMove = false;
				int random;
				random = (int) (Math.random() * 20);
				if (random > 18) {
					random = (int) (Math.random() * 2);
					switch (random) {
					case 1:
						g.drawImage(mainMenu2, 0, 0, this);
						break;
					case 2:
						g.drawImage(mainMenu3, 0, 0, this);
						break;
					}
				} else {
					g.drawImage(mainMenu, 0, 0, this);
				}
				g.drawImage(fiveNightsLogo, 100, 50, this);
				g.drawImage(newGameLogo, 100, 400, this);
				g.drawImage(arrows, 30, 405, this);
				g.drawImage(name, 1050, 700, this);
				if (startClicked) {
					g.drawImage(newspaper, 0, 0, this);
				}
			}
			else { // Game started
				// TODO: move these statements to an event that is triggered by gamestart
				this.gameStart();
				// TODO ------------------

				if (officePerception.monitorUp) {
					this.drawMonitor(g);
				} else {
					this.drawOffice(g);
				}
				if (needStatic) {//a blurry screen
					this.drawStatic(g);
				}
				
				if (officePerception.getPower() <= 0) {
					needToMove = false;
					assert ( 1<=powerOut && powerOut<=20);
					g.drawImage(imgsPowerOut[powerOut-1],0,0,this);
					
					Main.death = true; //todo: move this statement to main
				}
				g.drawImage(
						makeColorTransparent(
								(makeColorTransparent(cameraBar, Color.black)),
								Color.GRAY),
						262, 660, this);

				this.drawUsage(g);
				this.drawPower(g);

				// Game over
				//ToDO: move these statements to an event triggered by gameover
				if (Main.deather == true) {
					g.drawImage(lose, 0, 0, this);
				}
				if (Main.gameWin == true) {
					g.drawImage(win, 0, 0, this);
				}
				// TODO ---------------
			}
		}
		repaint();
	}

	public double height(double height) {
		if (height > 720) {
			height = 720;
		}
		return height;
	}

	public double width(double width) {
		if (width > 1280) {
			width = 1280;
		}
		return width;
	}

	public static Image makeColorTransparent(java.awt.Image image2,
			final Color color) {
		ImageFilter filter = new RGBImageFilter() {
			public int markerRGB = color.getRGB() | 0xFF000000;

			public final int filterRGB(int x, int y, int rgb) {
				if ((rgb | 0xFF000000) == markerRGB) {
					return 0x00FFFFFF & rgb;
				} else {
					return rgb;
				}
			}
		};

		ImageProducer ip = new FilteredImageSource(image2.getSource(), filter);
		return Toolkit.getDefaultToolkit().createImage(ip);
	}
	private void gameStart(){
		main1.stop();
		ambiance1.stop(); //
		mainmenumusicplaying = false;
		if(gamemusicplaying == false) {
			ambiance2.play();
			ambiance1.play();
			gamemusicplaying = true;
		}
	}

	public void setOffice(Office office){
		this.officePerception = office;
	}

	private void drawMonitor(Graphics g){

		if (cameraLocation.equals("Show Stage")) {
			needToMove = true;
			// TODO use perception interface to get whether characters are in room
			if (Bonnie.isInRoom() != 0 && Chicka.isInRoom() != 0
					&& Freddy.isInRoom() != 0) {
				g.drawImage(stageNone, cameraPosition - 200, 0,
						this);
			}
			if (Bonnie.isInRoom() == 0 && Chicka.isInRoom() == 0
					&& Freddy.isInRoom() == 0) {
				g.drawImage(stage, cameraPosition - 200, 0, this);
			}
			if (Bonnie.isInRoom() != 0 && Chicka.isInRoom() == 0
					&& Freddy.isInRoom() == 0) {
				g.drawImage(stageNoBonnie, cameraPosition - 200, 0,
						this);
			}
			if (Bonnie.isInRoom() == 0 && Chicka.isInRoom() != 0
					&& Freddy.isInRoom() == 0) {
				g.drawImage(stageNoChicka, cameraPosition - 200, 0,
						this);
			}
			if (Bonnie.isInRoom() != 0 && Chicka.isInRoom() != 0
					&& Freddy.isInRoom() == 0) {
				g.drawImage(stageNoBonnieChicka,
						cameraPosition - 200, 0, this);
			}
			g.drawImage(
					makeColorTransparent(showstage, Color.black),
					800, 290, this);
		}
		if (cameraLocation.equals("Dining Area")) {
			needToMove = true;

			if (Bonnie.isInRoom() != 1 && Chicka.isInRoom() != 1
					&& Freddy.isInRoom() != 1
					&& Bonnie.isInRoom() != 2
					&& Chicka.isInRoom() != 2) {
				g.drawImage(diningNone, cameraPosition - 200, 0,
						this);
			}
			if (Bonnie.isInRoom() == 1 && Chicka.isInRoom() != 1
					&& Freddy.isInRoom() != 1
					&& Bonnie.isInRoom() != 2
					&& Chicka.isInRoom() != 2) {
				g.drawImage(diningBonnieFar, cameraPosition - 200,
						0, this);
			}
			if (Bonnie.isInRoom() != 1 && Chicka.isInRoom() != 1
					&& Freddy.isInRoom() != 1
					&& Bonnie.isInRoom() != 1
					&& Chicka.isInRoom() == 2) {
				g.drawImage(diningChickaClose,
						cameraPosition - 200, 0, this);
			}
			if (Bonnie.isInRoom() != 1 && Chicka.isInRoom() == 1
					&& Freddy.isInRoom() != 1
					&& Bonnie.isInRoom() != 2
					&& Chicka.isInRoom() != 2) {
				g.drawImage(diningChickaFar, cameraPosition - 200,
						0, this);
			}
			if (Bonnie.isInRoom() != 1 && Chicka.isInRoom() != 1
					&& Freddy.isInRoom() != 1
					&& Bonnie.isInRoom() == 2
					&& Chicka.isInRoom() != 2) {
				g.drawImage(diningChickaClose,
						cameraPosition - 200, 0, this);
			}
			if (Bonnie.isInRoom() != 1 && Chicka.isInRoom() != 1
					&& Freddy.isInRoom() == 1
					&& Bonnie.isInRoom() != 2
					&& Chicka.isInRoom() != 2) {
				g.drawImage(diningFreddy, cameraPosition - 200, 0,
						this);
			}
			g.drawImage(
					makeColorTransparent(diningarea, Color.black),
					800, 290, this);
		}
		if (cameraLocation.equals("East Hall A")) {
			needToMove = true;

			if (Chicka.isInRoom() == 5 && Freddy.isInRoom() != 3
					&& Chicka.isInRoom() != 6) {
				g.drawImage(eastHallAChickaFar,
						cameraPosition - 200, 0, this);
			}
			if (Chicka.isInRoom() != 5 && Freddy.isInRoom() != 3
					&& Chicka.isInRoom() == 6) {
				g.drawImage(eastHallAChickaClose,
						cameraPosition - 200, 0, this);
			}
			if (Chicka.isInRoom() != 5 && Freddy.isInRoom() == 3
					&& Chicka.isInRoom() != 6) {
				g.drawImage(eastHallAFreddy, cameraPosition - 200,
						0, this);
			}
			if (Chicka.isInRoom() != 5 && Freddy.isInRoom() != 3
					&& Chicka.isInRoom() != 6) {
				g.drawImage(eastHallANone, cameraPosition - 200, 0,
						this);
			}
			g.drawImage(
					makeColorTransparent(easthall, Color.black),
					800, 290, this);
		}
		if (cameraLocation.equals("East Hall B")) {
			needToMove = true;

			if (Chicka.isInRoom() != 7 && Freddy.isInRoom() != 4) {
				g.drawImage(eastHallBNone, cameraPosition - 200, 0,
						this);
			}
			if (Chicka.isInRoom() == 7 && Freddy.isInRoom() != 4) {
				g.drawImage(eastHallBChicka, cameraPosition - 200,
						0, this);
			}
			if (Chicka.isInRoom() != 7 && Freddy.isInRoom() == 4) {
				g.drawImage(eastHallBFreddy, cameraPosition - 200,
						0, this);
			}
			g.drawImage(
					makeColorTransparent(ehallcorner, Color.black),
					800, 290, this);
		}
		if (cameraLocation.equals("Backstage")) {
			needToMove = true;

			if (Bonnie.isInRoom() != 3 && Bonnie.isInRoom() != 4) {
				g.drawImage(backstageNone, cameraPosition - 200, 0,
						this);
			}
			if (Bonnie.isInRoom() == 3 && Bonnie.isInRoom() != 4) {
				g.drawImage(backstageFar, cameraPosition - 200, 0,
						this);
			}
			if (Bonnie.isInRoom() != 3 && Bonnie.isInRoom() == 4) {
				g.drawImage(backstageClose, cameraPosition - 200,
						0, this);
			}
			g.drawImage(
					makeColorTransparent(backstage, Color.black),
					800, 290, this);
		}
		if (cameraLocation.equals("Pirate Cove")) {
			needToMove = true;

			if (Foxy.getStage() == 0) {
				g.drawImage(piratecoveStage0, -100, 0, this);
			} else if (Foxy.getStage() == 1) {
				g.drawImage(piratecoveStage1, -100, 0, this);
			} else if (Foxy.getStage() == 2) {
				g.drawImage(piratecoveStage2, -100, 0, this);
			} else if (Foxy.getStage() == 3) {
				g.drawImage(piratecoveStage3, -100, 0, this);
			}
			g.drawImage(
					makeColorTransparent(piratecove, Color.black),
					800, 290, this);
		}
		if (cameraLocation.equals("Restrooms")) {
			needToMove = true;

			if (Chicka.isInRoom() == 3 && Freddy.isInRoom() != 2
					&& Chicka.isInRoom() != 4) {
				g.drawImage(restroomsChickaFar,
						cameraPosition - 200, 0, this);
			}
			if (Chicka.isInRoom() != 3 && Freddy.isInRoom() != 2
					&& Chicka.isInRoom() == 4) {
				g.drawImage(restroomsChickaClose,
						cameraPosition - 200, 0, this);
			}
			if (Chicka.isInRoom() != 3 && Freddy.isInRoom() == 2
					&& Chicka.isInRoom() != 4) {
				g.drawImage(restroomsFreddy, cameraPosition - 200,
						0, this);
			}
			if (Chicka.isInRoom() != 3 && Freddy.isInRoom() != 2
					&& Chicka.isInRoom() != 4) {
				g.drawImage(restroomsNone, cameraPosition - 200, 0,
						this);
			}
			g.drawImage(
					makeColorTransparent(restrooms, Color.black),
					800, 290, this);
		}
		if (cameraLocation.equals("West Hall A")
				&& Foxy.getStage() != 3) {
			needToMove = true;

			if (Bonnie.isInRoom() != 5) {
				g.drawImage(westHallANone, cameraPosition - 200, 0,
						this);
			}
			if (Bonnie.isInRoom() == 5) {
				g.drawImage(westHallABonnie, cameraPosition - 200,
						0, this);
			}
			g.drawImage(
					makeColorTransparent(westhall, Color.black),
					800, 290, this);
		}
		if (cameraLocation.equals("West Hall B")) {
			needToMove = true;

			if (Bonnie.isInRoom() != 7) {
				g.drawImage(westHallBNone, cameraPosition - 200, 0,
						this);
			}
			if (Bonnie.isInRoom() == 7) {
				g.drawImage(westHallBBonnie, cameraPosition - 200,
						0, this);
			}
			g.drawImage(
					makeColorTransparent(whallcorner, Color.black),
					800, 290, this);
		}
		if (cameraLocation.equals("Supply Closet")) {
			needToMove = true;

			if (Bonnie.isInRoom() != 6) {
				g.drawImage(supplyclosetNone, -100, 0, this);
			}
			if (Bonnie.isInRoom() == 6) {
				g.drawImage(supplyclosetBonnie, -100, 0, this);
			}
			g.drawImage(
					makeColorTransparent(supplycloset, Color.black),
					800, 290, this);
		}
		if (cameraLocation.equals("West Hall A")
				&& Foxy.getStage() == 3) {// todo as an event

			if (Foxy.getStage() == 3) {
				needToMove = false;
				if (Fox == 1) {
					g.drawImage(foxrun1, 0, 0, this);
					run.play();
				}
				if (Fox == 2)
					g.drawImage(foxrun2, 0, 0, this);
				if (Fox == 3)
					g.drawImage(foxrun3, 0, 0, this);
				if (Fox == 4)
					g.drawImage(foxrun4, 0, 0, this);
				if (Fox == 5)
					g.drawImage(foxrun5, 0, 0, this);
				if (Fox == 6)
					g.drawImage(foxrun6, 0, 0, this);
				if (Fox == 7)
					g.drawImage(foxrun7, 0, 0, this);
				if (Fox == 8)
					g.drawImage(foxrun8, 0, 0, this);
				if (Fox == 9)
					g.drawImage(foxrun9, 0, 0, this);
				if (Fox == 10)
					g.drawImage(foxrun10, 0, 0, this);
				if (Fox == 11)
					g.drawImage(foxrun11, 0, 0, this);
				if (Fox == 12)
					g.drawImage(foxrun12, 0, 0, this);
				if (Fox == 13)
					g.drawImage(foxrun13, 0, 0, this);
				if (Fox == 14)
					g.drawImage(foxrun14, 0, 0, this);
				if (Fox == 15)
					g.drawImage(foxrun15, 0, 0, this);
				if (Fox == 16)
					g.drawImage(foxrun16, 0, 0, this);
				if (Fox == 17)
					g.drawImage(foxrun17, 0, 0, this);
				if (Fox == 18)
					g.drawImage(foxrun18, 0, 0, this);
				if (Fox == 19)
					g.drawImage(foxrun19, 0, 0, this);
				if (Fox == 20)
					g.drawImage(foxrun20, 0, 0, this);
				if (Fox == 21)
					g.drawImage(foxrun21, 0, 0, this);
				if (Fox == 22)
					g.drawImage(foxrun22, 0, 0, this);
				if (Fox == 23)
					g.drawImage(foxrun23, 0, 0, this);
				if (Fox == 24)
					g.drawImage(foxrun24, 0, 0, this);
				if (Fox == 25)
					g.drawImage(foxrun25, 0, 0, this);
				if (Fox == 26)
					g.drawImage(foxrun26, 0, 0, this);
				if (Fox == 27)
					g.drawImage(foxrun27, 0, 0, this);
				if (Fox == 28)
					g.drawImage(foxrun28, 0, 0, this);
				if (Fox == 29)
					g.drawImage(foxrun29, 0, 0, this);
				if (Fox == 30)
					g.drawImage(foxrun30, 0, 0, this);
				if (Fox == 31)
					g.drawImage(foxrun31, 0, 0, this);

			}
			g.drawImage(
					makeColorTransparent(westhall, Color.black),
					800, 290, this);
		}
		g.drawImage(
				makeColorTransparent(cameraMinimap, Color.black),
				825, 325, this);
		g.drawImage(blank, 923, 343, this);
		g.drawImage(blank, 904, 399, this);
		g.drawImage(blank, 877, 481, this);
		g.drawImage(blank, 926, 596, this);
		g.drawImage(blank, 926, 631, this);
		g.drawImage(blank, 850, 578, this);
		g.drawImage(blank, 1034, 596, this);
		g.drawImage(blank, 1034, 631, this);
		g.drawImage(blank, 796, 431, this);
		g.drawImage(blank, 1146, 436, this);
		g.drawImage(makeColorTransparent(A1, Color.black), 927,
				347, this);
		g.drawImage(makeColorTransparent(B1, Color.black), 908,
				403, this);
		g.drawImage(makeColorTransparent(C1, Color.black), 881,
				485, this);
		g.drawImage(makeColorTransparent(A2, Color.black), 930,
				600, this);
		g.drawImage(makeColorTransparent(B2, Color.black), 930,
				635, this);
		g.drawImage(makeColorTransparent(Three, Color.black), 855,
				582, this);
		g.drawImage(makeColorTransparent(A4, Color.black), 1038,
				600, this);
		g.drawImage(makeColorTransparent(B4, Color.black), 1038,
				635, this);
		g.drawImage(makeColorTransparent(Five, Color.black), 800,
				435, this);
		g.drawImage(makeColorTransparent(Six, Color.black), 1150,
				440, this);
	}

	private void drawOffice(Graphics g){ // TODO: use another module to decide whether (and which) character kills player.
		// TODO: separate the character anime and other effects, i.e. scream
		if (Bonnie.playerdeath == true && officePerception.monitorUp == false) {
			needToMove = false;
			if (bonnie == 1) {
				scream.play();
			}
			g.drawImage(imgsBonnie[bonnie-1], 0, 0, this);
			if (bonnie == 11){
				scream.stop();
			}
		}
		else if (Chicka.playerdeath == true && officePerception.monitorUp == false) {
			needToMove = false;
			main1.stop();
			ambiance1.stop();
			if (chicka == 1) {
				scream.play();
			}
			g.drawImage(imgsChicka[chicka-1], 0, 0, this);
			if (chicka == 16) {
				scream.stop();
			}
		}
		else if (Freddy.playerdeath == true && officePerception.monitorUp == false) {
			needToMove = false;
			main1.stop();
			ambiance1.stop();
			if (freddie == 1) {
				scream.play();
			}
			g.drawImage(imgsFreddy[freddie-1], 0, 0, this);
			if (freddie == 28) {
				scream.stop();
			}
		}
		else if (Foxy.playerdeath == true && officePerception.door1open == true) {
			needToMove = false;
			main1.stop();
			ambiance1.stop();
			if (foxdie == 1) {
				scream.play();
			}
			g.drawImage(imgsFoxy[foxdie-1], 0, 0, this);
			if (foxdie == 19) {
				scream.stop();
			}

		}
		else if (officePerception.light1on == true
				&& Bonnie.isInRoom() == 8) {
			g.drawImage(officeBonnie, officeView, 0, this);
			g.drawImage(
					makeColorTransparent(leftLight, Color.black),
					officeView, 250, this);
			g.drawImage(
					makeColorTransparent(rightNone, Color.black),
					officeView + 1490, 250, this);
		}
		else if (officePerception.light1on == true
				&& Bonnie.isInRoom() != 8) {
			g.drawImage(officeLeftLight, officeView, 0, this);
			g.drawImage(
					makeColorTransparent(leftLight, Color.black),
					officeView, 250, this);
			g.drawImage(
					makeColorTransparent(rightNone, Color.black),
					officeView + 1490, 250, this);
		} else if (officePerception.light2on == true
				&& Chicka.isInRoom() == 8) {
			g.drawImage(officeChicka, officeView, 0, this);
			g.drawImage(
					makeColorTransparent(leftNone, Color.black),
					officeView, 250, this);
			g.drawImage(
					makeColorTransparent(rightLight, Color.black),
					officeView + 1490, 250, this);
		} else if (officePerception.light2on == true
				&& Chicka.isInRoom() != 8) {
			g.drawImage(officeRightLight, officeView, 0, this);
			g.drawImage(
					makeColorTransparent(leftNone, Color.black),
					officeView, 250, this);
			g.drawImage(
					makeColorTransparent(rightLight, Color.black),
					officeView + 1490, 250, this);
		}
		else {
			g.drawImage(office, officeView, 0, this);
			g.drawImage(
					makeColorTransparent(leftNone, Color.black),
					officeView, 250, this);
			g.drawImage(
					makeColorTransparent(rightNone, Color.black),
					officeView + 1490, 250, this);
		}
		if (officePerception.door1open == false) {
			g.drawImage(makeColorTransparent(leftdoor13, Color.white), officeView + 80 , 0, this);
		}
		if (officePerception.door2open == false) {
			g.drawImage(makeColorTransparent(rightdoor13, Color.white), officeView + 1270, 0, this);
		}
	}

	private void drawStatic(Graphics g){
		if (Static == 1)
			g.drawImage(static1,
					0, 0, this);
		if (Static == 2)
			g.drawImage(static2,
					0, 0, this);
		if (Static == 3)
			g.drawImage(static3,
					0, 0, this);
		if (Static == 4)
			g.drawImage(static4,
					0, 0, this);
		if (Static == 5)
			g.drawImage(static5,
					0, 0, this);
		if (Static == 6)
			g.drawImage(static6,
					0, 0, this);
		if (Static == 7)
			g.drawImage(static7,
					0, 0, this);
		if (Static == 8)
			g.drawImage(static8,
					0, 0, this);
	}

	private void drawUsage(Graphics g){
		// Usage bar
		// draw nothing if usage==0
		if (officePerception.getUsage()>0) {
			assert(officePerception.getUsage()<=5);
			g.drawImage(
					makeColorTransparent(imgsUsageBar[officePerception.getUsage()-1], Color.black),
					90,672,this
			);

		}
		// The "Usage:" note
		g.drawImage(makeColorTransparent(use, Color.black), 10, 680,
				this);
	}

	private void drawPower(Graphics g){
		g.drawImage(makeColorTransparent(powerleft, Color.black), 10,
				650, this);
		g.drawImage(makeColorTransparent(percentsign, Color.black),
				215, 650, this);

		if (officePerception.powerRemaining <= 100 && officePerception.powerRemaining > 90) {
			g.drawImage(makeColorTransparent(onehundred, Color.black),
					157, 646, this);
		}
		if (officePerception.powerRemaining <= 90 && officePerception.powerRemaining > 80) {
			g.drawImage(makeColorTransparent(ninety, Color.black), 160,
					646, this);
		}
		if (officePerception.powerRemaining <= 80 && officePerception.powerRemaining > 70) {
			g.drawImage(makeColorTransparent(eighty, Color.black), 160,
					646, this);
		}
		if (officePerception.powerRemaining <= 70 && officePerception.powerRemaining > 60) {
			g.drawImage(makeColorTransparent(seventy, Color.black),
					160, 646, this);
		}
		if (officePerception.powerRemaining <= 60 && officePerception.powerRemaining > 50) {
			g.drawImage(makeColorTransparent(sixty, Color.black), 160,
					646, this);
		}
		if (officePerception.powerRemaining <= 50 && officePerception.powerRemaining > 40) {
			g.drawImage(makeColorTransparent(fifty, Color.black), 160,
					646, this);
		}
		if (officePerception.powerRemaining <= 40 && officePerception.powerRemaining > 30) {
			g.drawImage(makeColorTransparent(forty, Color.black), 160,
					646, this);
		}
		if (officePerception.powerRemaining <= 30 && officePerception.powerRemaining > 20) {
			g.drawImage(makeColorTransparent(thirty, Color.black), 160,
					646, this);
		}
		if (officePerception.powerRemaining <= 20 && officePerception.powerRemaining > 10) {
			g.drawImage(makeColorTransparent(twenty, Color.black), 160,
					646, this);
		}
		if (officePerception.powerRemaining <= 10 && officePerception.powerRemaining > 0) {
			g.drawImage(makeColorTransparent(ten, Color.black), 160,
					646, this);
		}
		if (officePerception.powerRemaining == 0) {
			g.drawImage(makeColorTransparent(zero, Color.black), 160,
					646, this);
		}
	}

}
