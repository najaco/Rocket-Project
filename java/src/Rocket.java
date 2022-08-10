import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
/**
 * Filename: Rocket.java
 * Rocket Project from AP Computer Science
 * @since Winter 2015
 * @author Nathan Cohen
 */


public class Rocket extends SimpleAnimation {
    private static final long serialVersionUID = 1L;

    // Global variables available anywhere in this file without passing them.
    int frames; // tracks what frame (still picture) the animation sequence is on.
    int v; // used to modify the vertical position of the rocket and fire.
    int h;
    int lazer;
    int lazer2;
    int lazer3;
    int lazer4;
    int sunH; // used to modify the horizontal position of the sun.
    int sunV;
    int sunHb;
    int sunVb;
    // used to modify the vertical position of the sun.
    int cloudsH1; // used to modify the horizontal position of the left clouds.
    int cloudsH2; // used to modify the horizontal position of the right clouds.
    int green; // used to modify the green color aspect of the sky.
    int blue; // used to modify the blue color aspect of the sky.
    int launchArmH; // use to modify the horizontal position of the launch arm.
    int launchArmV;
    int count; // contains the value that will be displayed on the clock.
    int LLightR = 0;
    int LLightG = 191;
    int LLightB = 225;
    int RLightR = 255;
    int RLightG = 69;
    int RLightB = 0;
    int LPBars;
    int LPOpening;
    int RF1;
    int RFX;
    int chck;
    int x;
    int y;
    int vert;
    int horiz;
    Color brown = new Color(164, 84, 30); // defines the color brown for program use.
    Color skyColor;
    Color sand = new Color(238, 203, 173); // Peach Puff 2
    Color msand = new Color(205, 175, 149); // Peach Puff 3
    Color sun1 = new Color(255, 248, 220); // Cornsilk
    Color house = new Color(245, 222, 129); // Seashell
    Color Outerrings = new Color(205, 201, 201); // Snow 2
    Color Wingcircle = new Color(105, 105, 105); // Dim Gray - circles on wings
    Color MF = new Color(218, 224, 254);
    Color BottomHouse = new Color(205, 133, 63);
    Color LLight = new Color(LLightR, LLightG, LLightB); // Deep Sky Blue
    Color RLight = new Color(RLightR, RLightG, RLightB); // Orange Red
    Color F1 = new Color(0, 255, 255);
    Color F2 = new Color(30, 144, 255);
    Color F3 = new Color(0, 0, 128);
    Color Space = new Color(25, 25, 40);
    Font Countdown = new Font("Times", Font.PLAIN, 30);
    Font wh = new Font("Times", Font.PLAIN, 16);
    AudioClip launch;
    AudioClip lazerfire;
    AudioClip explosion;
    AudioClip SWTheme;

    public void init() {
        resize(950, 650);

        // By using a speed of 33ms between frames, there will be approximately
        // 30 frames in one second, because 1000 � by 33 is approximately 30.
        // Television video is based on 30 frames per second.
        // This is a reasonable speed for this animation. Once the init() method
        // has finished loading the applet, then the drawFrame method will be call
        // approximately every 1/30 of a second.
        setMillisecondsPerFrame(33); // don't change this speed

        // Initially set the global variable frames to zero when the program runs.
        frames = 0;
        v = 0;
        h = 0;
        lazer = 0;
        sunH = 0;
        sunV = 0;
        sunHb = 0;
        sunVb = 0;
        cloudsH1 = 0;
        cloudsH2 = 0;
        green = 255;
        blue = 255;
        launchArmH = 0;
        launchArmV = 0;
        count = 10;
        LPBars = 0;
        LPOpening = 0;
        RF1 = 0;
        vert = 0;
        horiz = 0;
        launch = getAudioClip(getCodeBase(), "sounds/rocketLaunch.wav");
        lazerfire = getAudioClip(getCodeBase(), "sounds/blaster.wav");
        explosion = getAudioClip(getCodeBase(), "sounds/explosion.wav");
        SWTheme = getAudioClip(getCodeBase(), "sounds/swtheme.wav");

    }

    public void drawFrame(Graphics g) {
        // Call either paintScene1 or paintScene2
        if (frames <= 1000) {
            paintScene1(g);
        } else if (frames < 2349) {
            paintScene2(g);
        } else if (frames > 2350 && frames < 3100) {
            paintScene3(g, MF);
        } else if (frames > 3100) {
            paintScene4(g);
        }
        paintRocket(g);
        // paintScene3(g, MF);

        frames++; // DO NOT WRITE CODE THAT INCREMENTS frames ANYWHERE ELSE!

        // This code is temporarily being used to display the value of frames
        // in the upper left hand corner. Deactivate this code when your entire
        // Rocket program is complete.
        /*
         * g.setFont(wh); g.setColor(Color.black); g.drawString("" + frames, 20, 20);
         * g.drawString("(" + getWidth() + "," + getHeight() + ")", 20, 40);
         */
    } // end drawFrame()

    public void paintScene1(Graphics g) {
        // DO NOT WRITE ANY CODE BEFORE THIS! WE WILL ALWAYS PAINT THE SKY FIRST!
        // This code repaints the entire applet the Sky Color. DO NOT ERASE THIS CODE!
        skyColor = new Color(64, green, blue);
        g.setColor(skyColor);
        g.fillRect(0, 0, 950, 650);

        // Write an if statement with a compound boolean expression that will animate
        // the sun by incrementing sunH and sunV if the value of frames is greater
        // than 90 and less than 1000. Also, inside this if statement, write the code
        // for another if statement that decrements the values of the variables green
        // and blue if the value of green is greater than 64 and frames contains an
        // even value.
        if (frames > 90 && frames < 1000) {
            sunH++;
            sunV++;
            sunHb += 2;
            sunVb++;
            cloudsH1++;
            if (green > 64 && frames % 2 == 0) {
                green--;
                blue--;
            }
        }
        if (frames % 3 == 0) {
            RFX = 1;
        } else if (frames % 2 == 0) {
            RFX = 0;
        } else if (frames % 1 == 0) {
            RFX = -1;
        }
        // paint the sun
        g.setColor(sun1);
        // We will modify this line to animate the sun and you can change the location
        // a little if you need to later.
        g.fillOval(sunH + 500, sunV + 100, 100, 100);
        g.setColor(Color.pink);
        g.fillOval(sunHb + 300, sunVb + 120, 100, 100);

        // paint the ground and mountains
        // Mountains
        g.setColor(msand);
        int xm[] = { 0, 50, 100, 150, 200, 750, 830, 850, 900, 950, 1000, 1000 };
        int ym[] = { 650, 250, 450, 340, 640, 640, 260, 440, 350, 640, 650, 650 };
        g.fillPolygon(xm, ym, 12);
        // Ground
        g.setColor(sand);
        g.fillRect(0, 600, 1000, 50);

        // paint the left cloud bank
        g.setColor(Color.white);
        g.fillOval(120 + cloudsH1, 160, 200, 50);
        g.fillOval(200 + cloudsH1, 160, 200, 50);
        g.fillOval(160 + cloudsH1, 150, 200, 50);

        // paint the right cloud bank
        g.fillOval(520 - cloudsH1, 130, 200, 50);
        g.fillOval(620 - cloudsH1, 130, 200, 50);
        g.fillOval(560 - cloudsH1, 120, 200, 50);

        // paint the NASA building - window, door, and door knob
        g.setColor(house);
        g.fillRect(175, 500, 150, 100);
        g.fillArc(175, 450, 150, 100, 0, 180);
        // right door
        g.fillRoundRect(325, 525, 50, 75, 20, 5);
        // left door
        g.fillRoundRect(150, 525, 25, 75, 20, 5);
        g.setColor(BottomHouse);
        g.fillRoundRect(145, 550, 225, 50, 20, 5);
        g.setColor(Color.black);
        g.fillArc(365, 525, 15, 150, 0, 180);
        g.fillArc(145, 525, 15, 150, 0, 180);

        g.drawRect(175, 500, 150, 100);
        g.drawArc(175, 450, 150, 100, 0, 180);
        g.fillRect(225, 525, 50, 75);
        g.fillArc(225, 515, 48, 25, 0, 180);
        g.setColor(house);
        g.fillRect(176, 500, 149, 2);
        g.setColor(Color.black);
        g.drawArc(200, 500, 100, 200, 0, 180);
        // door outlines
        g.drawRoundRect(325, 525, 50, 75, 20, 5);
        g.drawRoundRect(150, 525, 25, 75, 20, 5);
        // Antenna
        g.setColor(Color.GRAY);
        g.drawLine(245, 450, 265, 300);
        g.drawLine(265, 450, 245, 300);
        g.drawLine(245, 300, 245, 450);
        g.drawLine(265, 300, 265, 450);
        g.drawLine(245, 300, 255, 275);
        g.drawLine(265, 300, 255, 275);
        g.drawLine(255, 450, 255, 275);
        g.drawRect(245, 270, 10, 5);
        g.drawRect(255, 270, 10, 5);
        // Flashing Lights On Top of Antenna
        if (frames % 20 < 10) {
            g.setColor(RLight);
        } else {
            g.setColor(LLight);
        }

        g.fillRect(245, 270, 10, 5);

        if (frames % 20 < 10) {
            g.setColor(LLight);
        } else {
            g.setColor(RLight);
        }
        g.fillRect(255, 270, 10, 5);

        // paint the control tower

        // Paint the count-down clock

        // ***************************************************************************

        // SKIP THE FOLLOWING INSTRUCTION UNTIL YOU ARE CODING PHASE 3.
        // Paint the animated numbers on the count-down clock.
        // When count is greater than or equal to zero, do the following:
        // define myFont2 to be ("Times", Font.PLAIN, 36) by constructing
        // this font. Then, set the drawing font to myFont2. Set the
        // drawing color to red. Then, use an if-else statement in this
        // if statement to call drawString and paint the number on the
        // count-down clock. If the value in the variable count is 10,
        // paint the number 10 in the correct position on the clock.
        // If the value in the variable count is 0 - 9, then paint the
        // correct number at a slightly different position on the clock.
        // This is because it takes more space to paint a 10 than a
        // single digit number.

        // Write an if statement that will decrement count by one ONLY WHEN
        // THE FOLLOWING IS TRUE ... when (frames + 61) is evenly divisible by 30
        // and when count is greater than 0.
        //
        if (((frames) + 61) % 30 == 0) {
            if (count <= 10 && count > -1) {
                count--;
            } else if (count == -1) {
                // initiate rocket Launch
            }
        }

        g.setColor(Color.WHITE);
        g.fillRect(215, 350, 80, 50);
        g.setColor(Color.BLACK);
        g.fillRect(225, 363, 60, 25);
        String counter = "";
        g.setColor(Color.RED);
        g.setFont(Countdown);
        if (count <= 10 && count >= 0) {
            counter = "" + count + "";
        } else if (count == -1) {
            counter = "0";
        }
        g.drawString("" + counter + "", 250, 385);

        // Launch Arm Ropes
        if (count <= 10 && count > 7) {
            if (launchArmH < 85) {
                launchArmH++;
                launchArmV++;
            }
        }
        g.setColor(Color.GRAY);
        g.fillRect(400, 530, 5, 60);
        g.fillRect(695, 530, 5, 60);
        g.drawLine(400, 530, 485 - launchArmH, 488 + launchArmV);
        g.drawLine(695, 530, 610 + launchArmH, 488 + launchArmV);
        if (count < 10 && count > 7) {
            if (LPOpening < 7) {
                LPOpening++;
            }
        } else if (count <= 7) {
            if (LPBars < 90) {
                LPBars++;
            } else if (LPBars >= 90) {
                LPOpening--;
            }
        }
        g.setColor(skyColor);
        g.fillRect(400, 500, 5, LPBars);
        g.fillRect(695, 500, 5, LPBars);
        g.setColor(Color.BLACK);
        g.fillRect(400, 590, 300, 40);
        g.setColor(Color.orange);
        g.fillArc(400, 550, 300, 80, 0, -180);
        g.setColor(Color.BLACK);
        g.fillRect(400, 590, 5, LPOpening);
        g.fillRect(695, 590, 5, LPOpening);

        // ***************************************************************************

        // paint the launch pad with its base and vertical post.

        // SKIP THE FOLLOWING INSTRUCTION UNTIL PHASE 1 IS COMPLETE AND
        // EVERYTHING WORKS FINE, THEN WRITE THIS CODE DURING PHASE 2.
        // Phase 2. Paint the launch arm here by doing these two things:
        // 1) Write an if statement with a compound boolean expression
        // whose code will execute if frames is greater than 33 and
        // frames is less than some other number. You must figure out
        // the other number exactly or the launch arm will not stop in
        // the correct position and still be connected to the launch
        // pad vertical post. The only line of code in the if is the
        // line: launchArmH--;
        // 2) After the if statement paint the launch arm. Paint it using
        // fillRect with the correct 4 numbers, then build launchArmH
        // into your code.

    } // end of paintScene1 method

    public void paintRocket(Graphics g) {

        if (frames > 1000 && chck == 475) {

        } else {
            rocketfire(F1, F2, F3, count, v, h, g, RFX);
        }

        if (frames > 1899 && frames < 3010) {
            v--;
            rocketfire(F1, F2, F3, count, v, h, g, RFX);
        } else {

        }
        g.setColor(MF);
        // left wing
        int lwx[] = { 520 + h, 451 + h, 540 + h, 540 + h };
        int lwy[] = { 340 + v, 480 + v, 480 + v, 340 + v };
        g.fillPolygon(lwx, lwy, 4);
        // right wing
        int rwx[] = { 560 + h, 560 + h, 650 + h, 580 + h };
        int rwy[] = { 340 + v, 480 + v, 480 + v, 340 + v };
        g.fillPolygon(rwx, rwy, 4);
        // g.fillRect(630,400,50,100);
        // cockpit
        int cpx[] = { 630 + h, 645 + h, 660 + h, 675 + h, 675 + h, 650 + h, 630 + h };
        int cpy[] = { 420 + v, 400 + v, 400 + v, 420 + v, 480 + v, 500 + v, 500 + v };
        g.fillPolygon(cpx, cpy, 7);
        g.setColor(Color.black);
        g.drawPolygon(cpx, cpy, 7);
        // Window Pane background
        int cpwx[] = { 630 + h, 645 + h, 660 + h, 675 + h };
        int cpwy[] = { 420 + v, 400 + v, 400 + v, 420 + v };
        g.fillPolygon(cpwx, cpwy, 4);
        g.setColor(MF);
        // left window of cockpit
        int xlwin[] = { 630 + h, 645 + h, 650 + h, 639 + h };
        int ylwin[] = { 420 + v, 400 + v, 400 + v, 420 + v };
        g.fillPolygon(xlwin, ylwin, 4);
        // middle window of cockpit
        g.setColor(MF);
        g.fillRect(645 + h, 401 + v, 5, 19);
        g.fillRect(655 + h, 401 + v, 5, 19);
        g.fillRect(650 + h, 400 + v, 5, 5);
        // right window of cockpit
        int xrwin[] = { 655 + h, 666 + h, 675 + h, 660 + h };
        int yrwin[] = { 400 + v, 420 + v, 420 + v, 400 + v };
        g.fillPolygon(xrwin, yrwin, 4);
        // end of cockpit
        g.setColor(Color.black);
        g.drawLine(645 + h, 400 + v, 660 + h, 400 + v);
        g.setColor(MF);
        // draw left wing
        g.setColor(MF);
        g.fillOval(450 + h, 400 + v, 201, 201);
        g.setColor(Color.black);
        g.setColor(Color.black);
        g.drawOval(450 + h, 400 + v, 201, 201);
        g.setColor(MF);
        g.fillRect(542 + h, 375 + v, 17, 50);
        g.setColor(Color.black);
        g.drawLine(542 + h, 375 + v, 542 + h, 400 + v);
        g.drawLine(558 + h, 375 + v, 558 + h, 400 + v);
        g.drawLine(542 + h, 375 + v, 558 + h, 375 + v);
        g.drawLine(630 + h, 420 + v, 675 + h, 420 + v);

        g.drawLine(520 + h, 340 + v, 470 + h, 440 + v);
        g.drawLine(540 + h, 400 + v, 540 + h, 340 + v);
        g.drawLine(520 + h, 340 + v, 540 + h, 340 + v);
        // draw right wing
        g.drawLine(580 + h, 340 + v, 630 + h, 440 + v);
        g.drawLine(560 + h, 400 + v, 560 + h, 340 + v);
        g.drawLine(560 + h, 340 + v, 580 + h, 340 + v);

        // middle
        g.setColor(skyColor);
        g.drawOval(525 + h, 475 + v, 50, 50);
        g.fillRect(450 + h, 495 + v, 201, 20);

        g.setColor(MF);
        int midx[] = { 450 + h, 440 + h, 440 + h, 450 + h, 650 + h, 660 + h, 660 + h, 650 + h };
        int midy[] = { 490 + v, 500 + v, 510 + v, 515 + v, 515 + v, 510 + v, 500 + v, 490 + v };
        g.fillPolygon(midx, midy, 8);
        g.setColor(Color.black);
        g.fillArc(435 + h, 497 + v, 10, 15, 90, -180);
        g.fillArc(655 + h, 497 + v, 10, 15, 90, 180);
        g.setColor(Color.black);
        g.drawLine(450 + h, 490 + v, 440 + h, 500 + v);
        g.drawLine(440 + h, 500 + v, 440 + h, 510 + v);
        g.drawLine(440 + h, 510 + v, 450 + h, 515 + v);
        g.drawLine(650 + h, 515 + v, 660 + h, 510 + v);
        g.drawLine(660 + h, 510 + v, 660 + h, 500 + v);
        g.drawLine(660 + h, 500 + v, 650 + h, 490 + v);
        // Middle Circle
        chck = 475 + v;
        g.drawOval(525 + h, chck, 50, 50);
        // upper-lower back black circles
        g.fillOval(520 + h, 525 + v, 20, 20);
        g.fillOval(540 + h, 530 + v, 20, 20);
        g.fillOval(560 + h, 525 + v, 20, 20);
        g.setColor(Outerrings);
        g.drawOval(520 + h, 525 + v, 20, 20);
        g.drawOval(540 + h, 530 + v, 20, 20);
        g.drawOval(560 + h, 525 + v, 20, 20);
        // lower-lower back black circles
        g.setColor(Color.black);
        g.fillOval(515 + h, 555 + v, 20, 20);
        g.fillOval(540 + h, 560 + v, 20, 20);
        g.fillOval(565 + h, 555 + v, 20, 20);
        g.setColor(Outerrings);
        g.drawOval(515 + h, 555 + v, 20, 20);
        g.drawOval(540 + h, 560 + v, 20, 20);
        g.drawOval(565 + h, 555 + v, 20, 20);
        // between wings
        g.setColor(Color.black);
        g.drawLine(570 + h, 485 + v, 560 + h, 400 + v);
        g.drawLine(530 + h, 485 + v, 540 + h, 400 + v);
        // circles on wings
        g.setColor(Outerrings);
        g.fillOval(495 + h, 400 + v, 10, 10); // g.drawLine(540, 400, 540, 340);
        g.fillOval(520 + h, 375 + v, 10, 10);
        g.fillOval(597 + h, 400 + v, 10, 10);// 560
        g.fillOval(570 + h, 375 + v, 10, 10);
        // Cockpit Hallway
        g.setColor(Color.black);
        g.drawLine(630 + h, 440 + v, 575 + h, 490 + v);
        g.drawLine(655 + h, 495 + v, 573 + h, 510 + v);
        // Middle Turret
        int xturretbot[] = { 542 + h, 547 + h, 553 + h, 558 + h };
        int yturretbot[] = { 525 + v, 475 + v, 475 + v, 525 + v };
        g.setColor(Color.BLACK);
        g.fillPolygon(xturretbot, yturretbot, 4);
        g.setColor(Color.GRAY);
        g.fillRect(540 + h, 490 + v, 20, 30);
        g.fillRect(540 + h, 465 + v, 5, 50);
        g.fillRect(555 + h, 465 + v, 5, 50);
        g.setColor(Color.BLACK);
        g.drawRect(540 + h, 465 + v, 5, 50);
        g.drawRect(555 + h, 465 + v, 5, 50);
        g.setColor(Color.GRAY);
        g.fillRect(540 + h, 490 + v, 20, 30);
        g.setColor(Color.BLACK);
        g.drawRect(540 + h, 490 + v, 20, 30);

        // ***************************************************************************

        // Phase 2 Coding: Painting the fire coming out of the rocket.
        // We want 100 lines of fire coming out of the rocket.
        // There should be 1/3 red, 1/3 orange, and 1/3 yellow.
        // Write the code inside the deactivated if statement using a
        // while loop. YOU WILL NOT ACTIVATE AND FINISH THE IF STATEMENT
        // UNTIL THE FIRE IS DONE. SO WAIT UNTIL PHASE 3 FOR THIS!!!

        // Place the loop inside this if statement and make the if statement
        // execute if count is less than or equal to 3.
        // if ()
        // {
        // Write the code for the rocket fire here

        // } // end of if

        // This code makes the rocket lift off after 12 seconds by varying
        // the vertical position of the rocket by decrementing v. For this
        // code to work you must build v into your code that paints the rocket.
        // This code assumes that there are 30 frames/sec.
        if (frames > 300) // 33 x 12 = 396 but 300 works better.
        {
            v--;
        }

        // code to play launch sound - ACTIVATE IN PHASE 3
        if (frames == 0) {
            launch.play();
        }

        // reset v for rocket entering second scene
        if (frames == 1001) {
            v = 300;
        }
        if (frames > 1001 && frames < 1200) {
            v--;
        }
        if (frames > 1000 && chck == 475) {
            v = 0;
        }
        if (frames > 1200 && frames < 1500) {
            h--;
        }

        g.setColor(Color.red);
        if (frames > 1550 && frames < 1725) {
            lazer--;
            lazer--;
            g.fillRect(540 + h, 450 + v + lazer, 4, 20);
        }
        if (frames > 1583 && frames < 1758) {
            lazer2--;
            lazer2--;
            g.fillRect(555 + h, 450 + v + lazer2, 4, 20);
        }
        if (frames > 1616 && frames < 1783) {
            lazer3--;
            lazer3--;
            g.fillRect(540 + h, 450 + v + lazer3, 4, 20);
        }
        if (frames > 1649 && frames < 1809) {
            lazer4--;
            lazer4--;
            g.fillRect(555 + h, 450 + v + lazer4, 4, 20);
        }
        if (frames == 1550) {
            lazerfire.play();
        } else if (frames == 1583) {
            lazerfire.play();
        } else if (frames == 1616) {
            lazerfire.play();
        } else if (frames == 1649) {
            lazerfire.play();
        }

        // tie fighters
        if (frames > 1001 && frames < 1809) {
            g.setColor(Color.GRAY);
            g.fillRect(142, 150, 210, 10);
            g.setColor(Color.BLACK);
            g.drawRect(142, 150, 210, 10);
            g.setColor(Color.GRAY);
            g.fillOval(200, 100, 100, 100);
            g.setColor(Color.BLACK);
            g.drawOval(200, 100, 100, 100);
            g.fillRect(137, 75, 10, 150);
            g.fillRect(350, 75, 10, 150);
            g.fillOval(213, 114, 75, 75);
            g.setColor(Color.GRAY);
            // window lines
            g.drawLine(213, 114, 286, 186);
            g.drawLine(213, 186, 286, 114);
            g.drawLine(250, 114, 250, 186);
            g.drawLine(250, 114, 250, 186);
            g.drawLine(213, 150, 286, 150);
            g.setColor(Color.BLACK);
            g.fillOval(238, 140, 25, 25);
            g.setColor(Color.GRAY);
            g.drawOval(238, 140, 25, 25);
            ;
        }

        else if (frames >= 1809 && frames < 1900) {
            g.setColor(Color.yellow);
            paintExplosion(g);
            g.setColor(Color.orange);
            paintExplosion(g);
        }
        if (frames == 1809) {
            explosion.play();
        }

    } // end of paintRocket method

    public void paintScene2(Graphics g) {
        g.setColor(Space);
        g.fillRect(0, 0, 950, 650);
        // stars

        y = 0;
        int col = 0;
        while (col < 22) {
            int row = 0;
            if (col % 2 == 0) {
                x = -5;
            } else {
                x = -5;
            }
            while (row < 4) {
                paintStar(x, y, g);
                x = (int) (Math.random() * 950);
                row++;
            }
            y += 30;
            col++;
        }

        // other code

    }

    public void paintScene3(Graphics g, Color MF) {
        int o = 2350;
        g.setColor(Space);
        g.fillRect(0, 0, 950, 650);
        y = 0;
        int col = 0;
        while (col < 22) {
            int row = 0;
            if (col % 2 == 0) {
                x = -5;
            } else {
                x = -5;
            }
            while (row < 4) {
                paintStar(x, y, g);
                x = (int) (Math.random() * 950);
                row++;
            }
            y += 30;
            col++;
        }
        // small Melinium Falcon
        g.setColor(MF);
        g.fillRect(200 + horiz, 660 + vert, 20, 20);
        if (frames < 401 + o) {
            g.fillRect(210 + horiz, 650 + vert, 10, 20);
        }
        if (frames > 401 + o) {
            g.fillRect(210 + horiz, 660 + vert, 20, 10);
        }

        if (frames > 0 + o && frames < 400 + o) {
            vert--;
        }
        if (frames == 401 + o) {
            lazerfire.play();
        }
        if (frames > 400 + o && frames < 1000 + o) {
            horiz++;
            horiz++;
        }

        // draw DeathStar
        if (frames < 550 + o) {
            g.setColor(Color.GRAY);
            g.fillOval(50, 50, 500, 500);
            g.setColor(Color.black);
            g.drawOval(300, 150, 125, 125);
            g.fillOval(350, 200, 25, 25);
            g.drawOval(325, 175, 75, 75);
            g.drawLine(362, 150, 362, 275);
            g.drawLine(300, 212, 425, 212);
            g.setColor(Space);
            g.fillRect(300, 350, 250, 201);
            g.setColor(Color.GRAY);
            g.fillRect(300, 362, 225, 13);
            g.setColor(Space);
            g.fillArc(515, 350, 50, 50, 0, 360);
            g.setColor(Color.GRAY);
            g.fillRect(300, 390, 180, 20);
            g.fillRect(300, 440, 210, 7);
            g.fillRect(300, 540, 210, 7);
            g.fillRect(300, 470, 190, 7);
            g.fillRect(300, 490, 120, 10);
            g.fillRect(300, 510, 140, 14);
        } else {

        }

        if (frames > 500 + o && frames < 700 + o) {
            g.setColor(Color.RED);
            paintDeathStarExplosion(g);
            g.setColor(Color.orange);
            paintDeathStarExplosion(g);
            g.setColor(Color.yellow);
            paintDeathStarExplosion(g);

        } else {
        }
        if (frames == 500 + o) {
            explosion.play();
        }
        if (frames == 600 + o) {
            SWTheme.play();
        }

    }

    public void paintScene4(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 950, 650);
    }

    public void rocketfire(Color F1, Color F2, Color F3, int count, int v, int h, Graphics g, int RFX) {
        if (count <= 3) {

            g.setColor(F1);
            g.fillArc(450 + RFX + h, 425 + v, 200, 200, 0, -180);
            g.setColor(F2);
            g.fillArc(475 + RFX + h, 450 + v, 150, 174, 0, -180);
            g.setColor(F3);
            g.fillArc(500 + RFX + h, 475 + v, 100, 140, 0, -180);
        }
    }

    public void paintStar(int x, int y, Graphics g) {
        g.setColor(Color.yellow);
        int starx[] = { x, x + 1, x + 4, x + 1, x, x - 1, x - 4, x - 1 };
        int stary[] = { y, y + 3, y + 4, y + 5, y + 8, y + 5, y + 4, y + 3 };
        g.fillPolygon(starx, stary, 8);
    }

    public void paintExplosion(Graphics g) {
        int counter = 0;
        int a;
        int b;
        while (counter < 60) {
            a = (int) ((Math.random() * 100) + 200);
            b = (int) ((Math.random() * 100) + 100);
            g.drawLine(250, 150, a, b);
            counter++;
        }
    }

    public void paintDeathStarExplosion(Graphics g) {
        int counter = 0;
        int a;
        int b;
        while (counter < 100) {
            a = (int) ((Math.random() * 500) + 25);
            b = (int) ((Math.random() * 500) + 25);
            g.drawLine(275, 275, a, b);
            counter++;
        }
    }

} // end class Rocket

/*
 * HERE IS THE LIST OF JAVA DRAWING AND PAINTING COMMANDS and INFORMATION.
 * ---------------------------------------------------------------------------
 * 
 * g.setColor(Color.red);
 * 
 * Sets the current color of the paint brush to draw or paint. Whichever drawing
 * or painting command comes next will draw or paint with this color. Here is
 * the list of Java Color constants that can be used:
 * 
 * Color.red Color.yellow Color.blue Color.orange Color.pink Color.cyan
 * Color.magenta Color.black Color.white Color.gray Color.lightGray
 * Color.darkGray
 * 
 * To create a custom color, call the Color class constructor and pass it the
 * appropriate RGB values (red, green, blue values) ...
 * 
 * Color colorVariableName = new Color (R, G, B);
 * 
 * For example, the color brown has the following RGB values: red = 164, green =
 * 84, and blue = 30.
 * 
 * So to construct brown use ... Color brown = new Color(164, 84, 30);
 * 
 * then you would call setColor as follows:
 * 
 * g.setColor(brown);
 * 
 * //Note: DON'T TRY TO USE Color.brown in parentheses ( ). It is not a
 * constant!
 * 
 * ------------------------------------------------------------------------
 * 
 * g.drawLine(x1, y1, x2, y2);
 * 
 * Draws a line from (x1, y1) to (x2, y2)
 * 
 * To draw a line from the point (10, 25) to the point (40, 55) use ...
 * 
 * g.drawLine(10, 25, 40, 55);
 * 
 * -------------------------------------------------------------------------
 * 
 * g.drawRect(x, y, width, height);
 * 
 * Draws the outline of a rectangle whose upper-left corner is (x, y) and whose
 * dimensions are the specified width and height. To draw a rectangle with
 * upper-left hand corner at the point (50,50) with a width of 200 and height of
 * 150 use ...
 * 
 * g.drawRect(50, 50, 200, 150);
 * 
 * -------------------------------------------------------------------------
 * 
 * g.fillRect(x, y, width, height);
 * 
 * Paints a rectangle whose upper-left corner is (x, y) and whose dimensions are
 * the specified width and height. To paint a rectangle with upper-left hand
 * corner at the point (50,50) with a width of 200 and height of 150 use ...
 * 
 * g.fillRect(50, 50, 200, 150);
 * 
 * -------------------------------------------------------------------------
 * 
 * g.clearRect(x, y, width, height);
 * 
 * Erases a rectangular area whose upper-left corner is (x, y) and whose
 * dimensions are the specified width and height with the current background
 * color. To erase the rectangular area with an upper left hand corner of (10,
 * 25) that has a width of 40 pixels and a height of 30 pixels use ...
 * 
 * g.clearRect(10, 25, 40, 30);
 * 
 * -------------------------------------------------------------------------
 * 
 * g.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
 * 
 * Draws the outline of a rounded rectangle whose upper-left corner is (x, y)
 * and whose dimensions are the specified width and height. The arcWidth and
 * arcHeight values control how much the corners are rounded. To make the
 * corners perfectly rounded (symmetrical) make these last two values the same
 * number. For example, to draw a rounded-rectangle with an upper-left corner
 * positioned at the point (40, 40) that has a width of 75 and a height of 35
 * and an arcWidth and arcHeight of 5 use ...
 * 
 * g.drawRoundRect(40, 40, 75, 35, 5, 5);
 * 
 * -------------------------------------------------------------------------
 * 
 * g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
 * 
 * Paints a rounded rectangle whose upper-left corner is (x, y) and whose
 * dimensions are the specified width and height. The arcWidth and arcHeight
 * values control how much the corners are rounded. To make the corners
 * perfectly rounded (symmetrical) make these last two values the same number.
 * For example, to paint a rounded-rectangle with an upper-left corner
 * positioned at the point (40, 40) that has a width of 75 and a height of 35
 * and an arcWidth and arcHeight of 5 use ...
 * 
 * g.fillRoundRect(40, 40, 75, 35, 5, 5);
 * 
 * -------------------------------------------------------------------------
 * 
 * g.drawOval(x, y, width, height);
 * 
 * Draws the outline of an oval that is inscribed within a rectangular area
 * whose upper-left corner is (x, y) and whose dimensions are the specified
 * width and height. To draw a circle, make the width and height equal. For
 * example, to draw an oval with upper-left corner at the point (10, 25) and a
 * width of 50 and a height of 25 use ...
 * 
 * g.drawOval(10, 25, 50, 25);
 * 
 * -------------------------------------------------------------------------
 * 
 * g.fillOval(x, y, width, height);
 * 
 * Paints an oval that is inscribed within a rectangular area whose upper-left
 * corner is (x, y) and whose dimensions are the specified width and height. To
 * draw a circle, make the width and height equal. For example, to paint an oval
 * with upper-left corner at the point (10, 25) and a width of 50 and a height
 * of 25 use ...
 * 
 * g.fillOval(10, 25, 50, 25);
 * 
 * -------------------------------------------------------------------------
 * 
 * g.drawArc(x, y, width, height, startAngle, arcAngle);
 * 
 * Draws the outline of an arc that is inscribed within a rectangle whose
 * upper-left corner is (x, y) and whose dimensions are the specified width and
 * height. The arc is drawn from startAngle to startAngle + arcAngle. The angles
 * are expressed in degrees. A startAngle of 0 indicates the 3 o'clock position.
 * A positive arc indicates a counterclockwise rotation, and a negative arc
 * indicates a clockwise rotation from 3 o'clock. For example, to draw an arc
 * whose upper-left corner is (10, 25) and whose rectangular area has a width of
 * 50 and a height of 50 with a starting angle of 0 sweeping for 90 degrees use
 * ...
 * 
 * g.drawArc(10, 25, 50, 50, 0, 90);
 * 
 * -------------------------------------------------------------------------
 * 
 * g.fillArc(x, y, width, height, startAngle, arcAngle);
 * 
 * Paints an arc that is inscribed within a rectangle whose upper-left corner is
 * (x, y) and whose dimensions are the specified width and height. The arc is
 * drawn from startAngle to startAngle + arcAngle. The angles are expressed in
 * degrees. A startAngle of 0 indicates the 3 o'clock position. A positive arc
 * indicates a counterclockwise rotation, and a negative arc indicates a
 * clockwise rotation from 3 o'clock. For example, to paint an arc whose
 * upper-left corner is (10, 25) and whose rectangular area has a width of 50
 * and a height of 50 with a starting angle of 0 sweeping for 90 degrees use ...
 * 
 * g.fillArc(10, 25, 50, 50, 0, 90);
 * 
 * -------------------------------------------------------------------------
 * 
 * g.drawPolygon(x, y, n);
 * 
 * Draws an n-sided polygon where x and y have already been defined as lists in
 * lines of code prior to the command.
 * 
 * The following line defines a list named x that will hold all of the x values
 * (abscissas) of the points of the polygon. int x [ ] = {x1, x2, x3, .... };
 * 
 * The following line defines a list named y that will hold all of the y values
 * (ordinates) of the points of the polygon. int y [ ] = {y1, y2, y3, .... };
 * 
 * So, to draw the pentagon defined by the 5 points: (10, 25) , (40, 25) , (60,
 * 50) , (30, 60) , (40, 40) use ...
 * 
 * int x [ ] = {10, 40, 60, 30, 40}; int y [ ] = {25, 25, 50, 60, 40};
 * g.drawPolygon(x, y, 5); // The number is 5 because it is a pentagon.
 * 
 * -------------------------------------------------------------------------
 * 
 * g.fillPolygon(x, y, n);
 * 
 * Paints an n-sided polygon where x and y have already been defined as lists in
 * lines of code prior to the command.
 * 
 * The following line defines a list named x that will hold all of the x values
 * (abscissas) of the points of the polygon. int x [ ] = {x1, x2, x3, .... };
 * 
 * The following line defines a list named y that will hold all of the y values
 * (ordinates) of the points of the polygon. int y [ ] = {y1, y2, y3, .... };
 * 
 * For example, to paint a pentagon by connecting the points: (10, 25) , (40,
 * 25) , (60, 50) , (30, 60) , (40, 40) use
 * 
 * int x [ ] = {10, 40, 60, 30, 40}; int y [ ] = {25, 25, 50, 60, 40};
 * g.fillPolygon(x, y, 5); // The number is 5 because it is a pentagon.
 * 
 * 
 * -------------------------------------------------------------------------
 * 
 * g.drawString(str, x, y);
 * 
 * Draws the String value stored in the String variable str at the point (x, y)
 * starting at the position of the base line of the first character in str. To
 * draw the words "Java Rules" beginning at the point (10, 50), then use ...
 * 
 * g.drawString("Java Rules", 10, 50);
 * 
 * -------------------------------------------------------------------------
 * 
 * getWidth()
 * 
 * Call this method without any object to get the width in pixels of the panel.
 * When calling this method do not put g and a dot before it.
 * 
 * getHeight()
 * 
 * Call this method without any object to get the height in pixels of the panel.
 * When calling this method do not put g and a dot before it.
 * 
 * For example, if you wanted to find the location one-fourth of the way across
 * the window, you could use getWidth() / 4 as a parameter. You could also use
 * getHeight() / 4 to find the location 1/4 of the way down.
 * 
 * To draw the string "Java Rules" at this location in the applet window use ...
 * 
 * g.drawString("Java Rules", getWidth() / 4, getHeight() / 4);
 * 
 * -------------------------------------------------------------------------
 * 
 * THE END.
 */
