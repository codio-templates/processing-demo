let redColor, cx1, cy1, cx2, cy2
let bx1, by1, bx2, by2
let vx1, vy1, vx2, vy2

function insideSquare() {
  if (mouseX > 33 &&
    mouseX < 283 &&
    mouseY > 25 &&
    mouseY < 275) {
    return 1
  }
  if (mouseX > 317 &&
    mouseX < 567 &&
    mouseY > 25 &&
    mouseY < 275) {
    return 2
  }
}

function setup() {
  createCanvas(600, 300);
  noStroke()
  redColor = color(231, 76, 60)
  vx1 = 0.8
  vy1 = -1.3
  vx2 = -0.8
  vy2 = 1.3
  bx1 = 158
  by1 = 150
  bx2 = 442
  by2 = 150
}

function draw() {
  background(55);
  fill(200)
  square(33, 25, 250)
  square(317, 25, 250)
  
  bx1 += vx1
  by1 += vy1
  bx2 += vx2
  by2 += vy2

  cx1 = constrain(bx1, 33, 283)
  cy1 = constrain(by1, 25, 275)
  cx2 = constrain(bx2, 337, width - 53)
  cy2 = constrain(by2, 45, 255)

  fill(redColor)
  circle(cx1, cy1, 40)

  fill(redColor)
  circle(cx2, cy2, 40)
  
  if (bx1 < 33 || bx1 > 283) {
    vx1 *= -1
  }
  if (by1 < 25 || by1 > 275) {
    vy1 *= -1
  }
  if (bx2 < 337 || bx2 > 547) {
    vx2 *= -1
  }
  if (by2 < 45 || by2 > 255) {
    vy2 *= -1
  }

  fill(55)
  rect(0, 0, 33, 288)
  rect(283, 0, 34, 288)
  rect(0, 0, width, 25)
  rect(0, height - 25, width, 25)
}