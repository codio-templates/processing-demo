let grow = 0

function setup() {
  createCanvas(400, 400);
  noFill()
  stroke(39, 209, 220)
  strokeWeight(3)
  angleMode(DEGREES)
}

function draw() {
  background(55, 55, 55);
  let vertices = 8
  let angle = 360/vertices
  let r = 125
  beginShape()
  for (let i = 0; i < 360; i += angle) {
    let x = cos(i) * r + width/2
    let y = sin(i) * (sin(grow) * r) + height/2
    vertex(x, y)
  }
  endShape(CLOSE)
  grow += 0.3
}