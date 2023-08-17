class Color {
  constructor(r, g, b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  to_hex() {
    const int_to_hex = (n) => {
      return ("0" + n.toString(16)).slice(-2);
    };
    return `#${int_to_hex(this.r)}${int_to_hex(this.g)}${int_to_hex(this.b)}`;
  }

  static black = new Color(0, 0, 0);
  static white = new Color(255, 255, 255);
  static pink = new Color(255, 192, 203);
  static red = new Color(255, 0, 0);
  static green = new Color(0, 255, 0);
  static blue = new Color(0, 0, 255);
  static grey = new Color(128, 128, 128);
  static gray = new Color(128, 128, 128);
  static orange = new Color(255, 165, 0);
  static yellow = new Color(255, 255, 0);
}

class Font {
  constructor(name, type, size) {
    this.name = name;
    this.type = type;
    this.size = size;
  }

  to_font_str() {
    return `${this.type} ${this.size}px ${this.name} `;
  }
}
class Graphics {
  constructor(ctx, height, width) {
    this.ctx = ctx;
    this.height = height;
    this.width = width;
  }
  rad(d, h) {
    return (d * d) / (8 * h) + h / 2;
  }

  clear() {
    this.ctx.clearRect(0, 0, this.width, this.height);
  }

  setColor(c) {
    this.ctx.fillStyle = c.to_hex();
    this.ctx.strokeStyle = c.to_hex();
  }

  drawRect(x, y, w, h) {
    this.ctx.strokeRect(x, y, w, h);
  }
  fillRect(x, y, w, h) {
    this.ctx.fillRect(x, y, w, h);
  }

  oval(x, y, w, h, fill, stroke) {
    const radiusX = w / 2;
    const radiusY = h / 2;
    const offsetX = x + radiusX;
    const offsetY = y + radiusY;
    this.ctx.beginPath();
    this.ctx.ellipse(offsetX, offsetY, radiusX, radiusY, 0, 0, 2 * Math.PI);
    if (fill) {
      this.ctx.fill();
    }
    if (stroke) {
      this.ctx.stroke();
    }
  }

  fillOval(x, y, w, h) {
    this.oval(x, y, w, h, true, false);
  }
  drawOval(x, y, w, h) {
    this.oval(x, y, w, h, false, true);
  }

  drawArc(x, y, w, h, startAngle, endAngle) {
    this.arc(x, y, w, h, startAngle, endAngle, false, true);
  }
  fillArc(x, y, w, h, startAngle, endAngle) {
    this.arc(x, y, w, h, startAngle, endAngle, true, false);
  }
  arc(x, y, w, h, startAngle, endAngle, fill, stroke) {
    this.ctx.beginPath();
    const radiusX = w / 2;
    const radiusY = h / 2;
    const offsetX = x + radiusX;
    const offsetY = y + radiusY;
    var ccw = true;
    if (endAngle < 0) {
      endAngle *= -1;
      ccw = false;
    }
    this.ctx.ellipse(
      offsetX,
      offsetY,
      radiusX,
      radiusY,
      0,
      startAngle * (Math.PI / 180),
      endAngle * (Math.PI / 180),
      ccw
    );
    if (fill) {
      this.ctx.fill();
    }
    if (stroke) {
      this.ctx.stroke();
    }
  }
  roundRect(x, y, width, height, radius = 5, fill = false, stroke = true) {
    if (typeof radius === "number") {
      radius = { tl: radius, tr: radius, br: radius, bl: radius };
    } else {
      radius = { ...{ tl: 0, tr: 0, br: 0, bl: 0 }, ...radius };
    }
    this.ctx.beginPath();
    this.ctx.moveTo(x + radius.tl, y);
    this.ctx.lineTo(x + width - radius.tr, y);
    this.ctx.quadraticCurveTo(x + width, y, x + width, y + radius.tr);
    this.ctx.lineTo(x + width, y + height - radius.br);
    this.ctx.quadraticCurveTo(
      x + width,
      y + height,
      x + width - radius.br,
      y + height
    );
    this.ctx.lineTo(x + radius.bl, y + height);
    this.ctx.quadraticCurveTo(x, y + height, x, y + height - radius.bl);
    this.ctx.lineTo(x, y + radius.tl);
    this.ctx.quadraticCurveTo(x, y, x + radius.tl, y);
    this.ctx.closePath();
    if (fill) {
      ctx.fill();
    }
    if (stroke) {
      ctx.stroke();
    }
  }

  drawRoundRect(x, y, w, h, d, ah) {
    this.roundRect(x, y, w, h, this.rad(d, ah), false, true);
  }
  fillRoundRect(x, y, w, h, d, ah) {
    this.roundRect(x, y, w, h, this.rad(d, ah), true, false);
  }

  drawLine(x1, y1, x2, y2) {
    this.ctx.beginPath();
    this.ctx.moveTo(x1, y1);
    this.ctx.lineTo(x2, y2);
    this.ctx.stroke();
  }

  setFont(f) {
    this.ctx.font = f.to_font_str();
  }

  drawString(s, x, y) {
    this.ctx.fillText(s, x, y);
  }

  polygon(xs, ys, fill, stroke) {
    var points = xs.map((e, i) => {
      return { x: e, y: ys[i] };
    });
    if (points.length > 0) {
      var point = points[0];

      this.ctx.beginPath();
      this.ctx.moveTo(point.x, point.y); // point 1

      for (var i = 1; i < points.length; ++i) {
        point = points[i];

        this.ctx.lineTo(point.x, point.y);
      }

      this.ctx.closePath(); // go back to point 1
      if (fill) {
        this.ctx.fill();
      }
      if (stroke) {
        this.ctx.stroke();
      }
    }
  }

  fillPolygon(xs, ys, _) {
    this.polygon(xs, ys, true, false);
  }
  drawPolygon(xs, ys, _) {
    this.polygon(xs, ys, false, true);
  }
}
