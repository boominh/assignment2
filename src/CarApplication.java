void main() {
    // Instance of this class
    CarController cc = new CarController();
    
    Volvo240 volvo = new Volvo240();
    Saab95 saab = new Saab95();
    
    volvo.setPosition(0, 0);
    saab.setPosition(100, 100);
    
    cc.addCar(volvo);
    cc.addCar(saab);
    
    // Start a new view and send a reference to the controller
    cc.newFrame("CarSim 1.0", cc);
    cc.startTimer();
}