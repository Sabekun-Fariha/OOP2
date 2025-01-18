public class Triangle {

    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) throws ILLegalTriangleException{
        if(!isValidTriangle(side1, side2, side3)){
            throw new ILLegalTriangleException("The sum of any two sides must be greater than the third side.");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public boolean isValidTriangle(double side1, double side2, double side3){
        return (side1 + side2 > side3) &&
                (side1 + side3 > side2) &&
                (side2 + side3 > side1);
    }

    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    public double getArea(){
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
    }

    @Override
    public String toString(){
        return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3;
    }
}
