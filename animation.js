// Global variables available anywhere in this file without passing them.
var frames; // tracks what frame (still picture) the animation sequence is on.
var v = 0; // used to modify the vertical position of the rocket and fire.
var h = 0;
var lazer = 0;
var lazer2;
var lazer3;
var lazer4;
var sunH = 0; // used to modify the horizontal position of the sun.
var sunV = 0;
var sunHb;
var sunVb;
// used to modify the vertical position of the sun.
var cloudsH1 = 0; // used to modify the horizontal position of the left clouds.
var cloudsH2 = 0; // used to modify the horizontal position of the right clouds.
var green = 255; // used to modify the green color aspect of the sky.
var blue = 255; // used to modify the blue color aspect of the sky.
var launchArmH = 0; // use to modify the horizontal position of the launch arm.
var launchArmV = 0;
var count = 10; // contains the value that will be displayed on the clock.
var LLightR = 0;
var LLightG = 191;
var LLightB = 225;
var RLightR = 255;
var RLightG = 69;
var RLightB = 0;
var LPBars = 0;
var LPOpening = 0;
var RF1 = 0;
var RFX;
var chck;
var x;
var y;
var vert = 0;
var horiz = 0;
const brown = new Color(164, 84, 30); // defines the color brown for program use.
let skyColor = new Color(64, green, blue);
const sand = new Color(238, 203, 173); // Peach Puff 2
const msand = new Color(205, 175, 149); // Peach Puff 3
const sun1 = new Color(255, 248, 220); // Cornsilk
const house = new Color(245, 222, 129); // Seashell
const Outerrings = new Color(205, 201, 201); // Snow 2
const Wingcircle = new Color(105, 105, 105); // Dim grey - circles on wings
const MF = new Color(218, 224, 254);
const BottomHouse = new Color(205, 133, 63);
const LLight = new Color(LLightR, LLightG, LLightB); // Deep Sky Blue
const RLight = new Color(RLightR, RLightG, RLightB); // Orange Red
const F1 = new Color(0, 255, 255);
const F2 = new Color(30, 144, 255);
const F3 = new Color(0, 0, 128);
const Space = new Color(25, 25, 40);
const Countdown = new Font("Times", Font.PLAIN, 30);
const wh = new Font("Times", Font.PLAIN, 16);
const launch = new Audio("sounds/rocketLaunch.wav");
const lazerfire = new Audio("sounds/blaster.wav");
const explosion = new Audio("sounds/explosion.wav");
const SWTheme = new Audio("sounds/swtheme.wav");
const rocketFire = (F1, F2, F3, count, v, h, g, RFX) => {
  if (count <= 3) {
    g.setColor(F1);
    g.fillArc(450 + RFX + h, 425 + v, 200, 200, 0, -180);
    g.setColor(F2);
    g.fillArc(475 + RFX + h, 450 + v, 150, 174, 0, -180);
    g.setColor(F3);
    g.fillArc(500 + RFX + h, 475 + v, 100, 140, 0, -180);
  }
};

const paintDeathStarExplosion = (g) => {
  for (let i = 0; i < 100; i++) {
    const a = Math.random() * 500 + 25;
    const b = Math.random() * 500 + 25;
    g.drawLine(275, 275, a, b);
  }
};

const paintExplosion = (g) => {
  for (let i = 0; i < 100; i++) {
    const a = Math.random() * 100 + 200;
    const b = Math.random() * 100 + 100;
    g.drawLine(250, 150, a, b);
  }
};

const paintRocket = (g, frames) => {
  if (frames > 1000 && chck == 475) {
  } else {
    rocketFire(F1, F2, F3, count, v, h, g, RFX);
  }

  if (frames > 1899 && frames < 3010) {
    v--;
    rocketFire(F1, F2, F3, count, v, h, g, RFX);
  } else {
  }
  g.setColor(MF);
  // left wing
  const lwx = [520 + h, 451 + h, 540 + h, 540 + h];
  const lwy = [340 + v, 480 + v, 480 + v, 340 + v];
  g.fillPolygon(lwx, lwy, 4);
  // right wing
  const rwx = [560 + h, 560 + h, 650 + h, 580 + h];
  const rwy = [340 + v, 480 + v, 480 + v, 340 + v];
  g.fillPolygon(rwx, rwy, 4);
  // g.fillRect(630,400,50,100);
  // cockpit
  const cpx = [630 + h, 645 + h, 660 + h, 675 + h, 675 + h, 650 + h, 630 + h];
  const cpy = [420 + v, 400 + v, 400 + v, 420 + v, 480 + v, 500 + v, 500 + v];
  g.fillPolygon(cpx, cpy, 7);
  g.setColor(Color.black);
  g.drawPolygon(cpx, cpy, 7);
  // Window Pane background
  const cpwx = [630 + h, 645 + h, 660 + h, 675 + h];
  const cpwy = [420 + v, 400 + v, 400 + v, 420 + v];
  g.fillPolygon(cpwx, cpwy, 4);
  g.setColor(MF);
  // left window of cockpit
  const xlwin = [630 + h, 645 + h, 650 + h, 639 + h];
  const ylwin = [420 + v, 400 + v, 400 + v, 420 + v];
  g.fillPolygon(xlwin, ylwin, 4);
  // middle window of cockpit
  g.setColor(MF);
  g.fillRect(645 + h, 401 + v, 5, 19);
  g.fillRect(655 + h, 401 + v, 5, 19);
  g.fillRect(650 + h, 400 + v, 5, 5);
  // right window of cockpit
  const xrwin = [655 + h, 666 + h, 675 + h, 660 + h];
  const yrwin = [400 + v, 420 + v, 420 + v, 400 + v];
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
  const midx = [
    450 + h,
    440 + h,
    440 + h,
    450 + h,
    650 + h,
    660 + h,
    660 + h,
    650 + h,
  ];
  const midy = [
    490 + v,
    500 + v,
    510 + v,
    515 + v,
    515 + v,
    510 + v,
    500 + v,
    490 + v,
  ];
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
  g.fillOval(597 + h, 400 + v, 10, 10); // 560
  g.fillOval(570 + h, 375 + v, 10, 10);
  // Cockpit Hallway
  g.setColor(Color.black);
  g.drawLine(630 + h, 440 + v, 575 + h, 490 + v);
  g.drawLine(655 + h, 495 + v, 573 + h, 510 + v);
  // Middle Turret
  const xturretbot = [542 + h, 547 + h, 553 + h, 558 + h];
  const yturretbot = [525 + v, 475 + v, 475 + v, 525 + v];
  g.setColor(Color.black);
  g.fillPolygon(xturretbot, yturretbot, 4);
  g.setColor(Color.grey);
  g.fillRect(540 + h, 490 + v, 20, 30);
  g.fillRect(540 + h, 465 + v, 5, 50);
  g.fillRect(555 + h, 465 + v, 5, 50);
  g.setColor(Color.black);
  g.drawRect(540 + h, 465 + v, 5, 50);
  g.drawRect(555 + h, 465 + v, 5, 50);
  g.setColor(Color.grey);
  g.fillRect(540 + h, 490 + v, 20, 30);
  g.setColor(Color.black);
  g.drawRect(540 + h, 490 + v, 20, 30);

  if (frames > 300) {
    // 33 x 12 = 396 but 300 works better.
    v--;
  }

  // code to play launch sound - ACTIVATE IN PHASE 3
  if (frames == 0) {
    launch.play();
    // console.log("Attempting to play launch sound");
    // launch.addEventListener("canplaythrough", event => {launch.play();})
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
    g.setColor(Color.grey);
    g.fillRect(142, 150, 210, 10);
    g.setColor(Color.black);
    g.drawRect(142, 150, 210, 10);
    g.setColor(Color.grey);
    g.fillOval(200, 100, 100, 100);
    g.setColor(Color.black);
    g.drawOval(200, 100, 100, 100);
    g.fillRect(137, 75, 10, 150);
    g.fillRect(350, 75, 10, 150);
    g.fillOval(213, 114, 75, 75);
    g.setColor(Color.grey);
    // window lines
    g.drawLine(213, 114, 286, 186);
    g.drawLine(213, 186, 286, 114);
    g.drawLine(250, 114, 250, 186);
    g.drawLine(250, 114, 250, 186);
    g.drawLine(213, 150, 286, 150);
    g.setColor(Color.black);
    g.fillOval(238, 140, 25, 25);
    g.setColor(Color.grey);
    g.drawOval(238, 140, 25, 25);
  } else if (frames >= 1809 && frames < 1900) {
    g.setColor(Color.yellow);
    paintExplosion(g);
    g.setColor(Color.orange);
    paintExplosion(g);
  }
  if (frames == 1809) {
    explosion.play();
  }
};
const paintStar = (x, y, g) => {
  g.setColor(Color.yellow);
  const starx = [x, x + 1, x + 4, x + 1, x, x - 1, x - 4, x - 1];
  const stary = [y, y + 3, y + 4, y + 5, y + 8, y + 5, y + 4, y + 3];
  g.fillPolygon(starx, stary, 8);
};
const paintScene1 = (g, frames) => {
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
  var xm = [0, 50, 100, 150, 200, 750, 830, 850, 900, 950, 1000, 1000];
  var ym = [650, 250, 450, 340, 640, 640, 260, 440, 350, 640, 650, 650];
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
  g.setColor(Color.grey);
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
  if ((frames + 61) % 30 == 0) {
    if (count <= 10 && count > -1) {
      count--;
    } else if (count == -1) {
      // initiate rocket Launch
    }
  }

  g.setColor(Color.white);
  g.fillRect(215, 350, 80, 50);
  g.setColor(Color.black);
  g.fillRect(225, 363, 60, 25);
  var counter = "";
  g.setColor(Color.red);
  g.setFont(Countdown);
  if (count <= 10 && count >= 0) {
    counter = `${count}`;
  } else if (count == -1) {
    counter = "0";
  }
  g.drawString(counter, 250, 385);

  // Launch Arm Ropes
  if (count <= 10 && count > 7) {
    if (launchArmH < 85) {
      launchArmH++;
      launchArmV++;
    }
  }
  g.setColor(Color.grey);
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
  g.fillRect(395, 500, 10, LPBars);
  g.fillRect(690, 500, 10, LPBars);
  g.setColor(Color.black);
  g.fillRect(400, 590, 300, 40);
  g.setColor(Color.orange);
  g.fillArc(400, 550, 300, 80, 0, -180);
}; // end of paintScene1 method

const paintScene2 = (g, frames) => {
  g.setColor(Space);
  g.fillRect(0, 0, 950, 650);
  // stars

  y = 0;
  var col = 0;
  while (col < 22) {
    var row = 0;
    if (col % 2 == 0) {
      x = -5;
    } else {
      x = -5;
    }
    while (row < 4) {
      paintStar(x, y, g);
      x = Math.random() * 950;
      row++;
    }
    y += 30;
    col++;
  }
};
const paintScene3 = (g, frames) => {
  const o = 2350;
  g.setColor(Space);
  g.fillRect(0, 0, 950, 650);
  y = 0;
  var col = 0;
  while (col < 22) {
    var row = 0;
    if (col % 2 == 0) {
      x = -5;
    } else {
      x = -5;
    }
    while (row < 4) {
      paintStar(x, y, g);
      x = Math.random() * 950;
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
    g.setColor(Color.grey);
    g.fillOval(50, 50, 500, 500);
    g.setColor(Color.black);
    g.drawOval(300, 150, 125, 125);
    g.fillOval(350, 200, 25, 25);
    g.drawOval(325, 175, 75, 75);
    g.drawLine(362, 150, 362, 275);
    g.drawLine(300, 212, 425, 212);
    g.setColor(Space);
    g.fillRect(300, 350, 250, 201);
    g.setColor(Color.grey);
    g.fillRect(300, 362, 225, 13);
    g.setColor(Space);
    g.fillArc(515, 350, 50, 50, 0, 360);
    g.setColor(Color.grey);
    g.fillRect(300, 390, 180, 20);
    g.fillRect(300, 440, 210, 7);
    g.fillRect(300, 540, 210, 7);
    g.fillRect(300, 470, 190, 7);
    g.fillRect(300, 490, 120, 10);
    g.fillRect(300, 510, 140, 14);
  } else {
  }

  if (frames > 500 + o && frames < 700 + o) {
    g.setColor(Color.red);
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
};
const paintScene4 = (g, frames) => {
  g.setColor(Color.black);
  g.fillRect(0, 0, 950, 650);
};

function drawAnimation(g, frames) {
  // console.log(`Frame = ${frames}`)
  if (frames <= 1000) {
    paintScene1(g, frames);
  } else if (frames < 2349) {
    paintScene2(g, frames);
  } else if (frames > 2350 && frames < 3100) {
    paintScene3(g, frames);
  } else if (frames > 3100) {
    paintScene4(g, frames);
  }
  paintRocket(g, frames);
}
