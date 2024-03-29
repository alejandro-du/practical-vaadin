var Bicycle = /** @class */ (function () {
    function Bicycle(color) {
        this.speed = 0;
        this.gear = 1;
        this.color = color;
    }
    Bicycle.prototype.speedUp = function (increase) {
        this.speed += increase;
    };
    Bicycle.prototype.applyBreak = function (decrease) {
        return this.speed -= decrease;
    };
    Bicycle.prototype.changeGear = function (newGear) {
        return this.gear = newGear;
    };
    Bicycle.prototype.print = function () {
        console.log("".concat(this.color, " bicycle: ").concat(this.speed, " Km/h (").concat(this.gear, ")"));
    };
    return Bicycle;
}());
var redBicycle = new Bicycle("red");
redBicycle.print();
redBicycle.speedUp(10);
redBicycle.changeGear(2);
redBicycle.speedUp(10);
redBicycle.changeGear(3);
redBicycle.speedUp(8);
redBicycle.applyBreak(5);
redBicycle.print();
// this will produce a compile time error:
// redBicycle.speedUp("10");
