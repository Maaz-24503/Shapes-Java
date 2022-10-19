

abstract class Shape {
    public abstract double area();
    public abstract double perimeter();
    public abstract void scale(double scaleFactor);
}

class Circle extends Shape {
        private double Radius;

    private static int DecPlaces = 2;

    public Circle(){}

    public Circle(double radius){

        Radius =radius;
    }

    public double getRadius() {

        return Radius;
    }

    public void setRadius(double radius) {

        Radius = radius;
    }

    public double area(){
        return (Radius*Radius)*Math.PI;
    }

    public double perimeter(){

        return (2*Radius)*Math.PI;
    }

    public void scale(double scaleFactor){
        Radius = Radius*scaleFactor;
    }

    public static int getDecPlaces() {
        return DecPlaces;
    }

    public static void setDecPlaces(int decPlaces) {
        DecPlaces = decPlaces;
    }

    @Override
    public String toString() {
        String s = "%." + DecPlaces +"f";
        String temp = String.format(s,Radius);
        return "Circle("+temp+")";
    }
}

class Rectangle extends Shape {
        private double Width;
    private double Height;

    private static int DecPlaces = 2;

    public Rectangle(){}

    public Rectangle(double width, double height){

        Width = width;
        Height = height;
    }

    public double getHeight() {

        return Height;
    }

    public double getWidth() {

        return Width;
    }

    public void setHeight(double height) {

        Height = height;
    }

    public void setWidth(double width) {

        Width = width;
    }

    public double area(){

        return Width*Height;
    }

    public double perimeter(){

        return 2*(Width+Height);
    }

    public double diagonalLength(){

        double diagonal_sqrd = (Width*Width) + (Height*Height);
        return Math.sqrt (diagonal_sqrd);
    }

    public void scale(double scaleFactor){
        Width = Width*scaleFactor;
        Height = Height*scaleFactor;
    }

    public static int getDecPlaces() {
        return DecPlaces;
    }

    public static void setDecPlaces(int decPlaces) {
        DecPlaces = decPlaces;
    }

    @Override
    public String toString() {
        String s = "%." + DecPlaces +"f";
        String wid = String.format(s,Width);
        String hei = String.format(s,Height);
        return "Rectangle("+wid+", "+hei+")";
    }
}

class EquiTriangle extends Shape {
        private double Side;

    private static int DecPlaces = 2;

    public EquiTriangle(){}

    public EquiTriangle(double side){

        Side = side;
    }

    public double getSide() {

        return Side;
    }

    public void setSide(double side) {

        Side = side;
    }

    public double area(){

        double Sin_60 = Math.sqrt(3)/2.0;
        return 0.5*Side*Side*Sin_60;
    }

    public double perimeter(){

        return 3*Side;
    }

    public double altitude(){

        double Sin_60 = Math.sqrt(3)/2.0;
        return Sin_60*Side;
    }

    public void scale(double scaleFactor){
        Side = Side *scaleFactor;
    }

    public static int getDecPlaces() {
        return DecPlaces;
    }

    public static void setDecPlaces(int decPlaces) {
        DecPlaces = decPlaces;
    }

    @Override
    public String toString() {
        String s = "%." + DecPlaces +"f";
        String side = String.format(s,Side);
        return "EquiTriangle("+side+")";
    }
}

import java.util.Scanner;
class TestShape {
  public static void main(String[] args) {
            Shape[] shape = new Shape[10];
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String first = sc.next();
            if(first.equals("create")){
               String second = sc.next();
               if(second.equals("circle")){
                   int ind = Integer.parseInt(sc.next());
                   double rad = Double.parseDouble(sc.next());
                   shape[ind] = new Circle(rad);
               }
               else if(second.equals("rectangle")){
                   int ind = Integer.parseInt(sc.next());
                   double width = Double.parseDouble(sc.next());
                   double height = Double.parseDouble(sc.next());
                   shape[ind] = new Rectangle(width,height);
               }
               else if(second.equals("equilateral")&& sc.next().equals("triangle")){
                   int ind = Integer.parseInt(sc.next());
                   double side = Double.parseDouble(sc.next());
                   shape[ind] = new EquiTriangle(side);
               }
            }
            else if(first.equals("count")){
                String second = sc.next();
                if(second.equals("circles")){
                    int count = 0;
                    for(int i = 0; i< shape.length; i++){
                        if(shape[i] instanceof Circle) count++;
                    }
                    System.out.println("Number of circle objects: "+count);
                }
                else if (second.equals("rectangles")) {
                    int count = 0;
                    for(int i = 0; i< shape.length; i++){
                        if(shape[i] instanceof Rectangle) count++;
                    }
                    System.out.println("Number of rectangle objects: "+count);
                }

                else if (second.equals("equilateral") && sc.next().equals("triangles")){
                    int count = 0;
                    for(int i = 0; i< shape.length; i++){
                        if(shape[i] instanceof EquiTriangle) count++;
                    }
                    System.out.println("Number of equilateral triangle objects: "+count);
                }
            }
            else if(first.equals("show")){
                String second = sc.next();
                if(second.equals("area")){
                    int index = Integer.parseInt(sc.next());
                    if(shape[index]==null) System.out.println("No object in this position");
                    else if(shape[index] instanceof Circle){
                        String s = "%." + Circle.getDecPlaces() +"f";
                        String temp = String.format(s,( shape[index]).area());
                        System.out.println("Area: "+temp);
                    }
                    else if(shape[index] instanceof Rectangle){
                        String s = "%." + Rectangle.getDecPlaces() +"f";
                        String temp = String.format(s,( shape[index]).area());
                        System.out.println("Area: "+temp);
                    }
                    else if(shape[index] instanceof EquiTriangle){
                        String s = "%." + EquiTriangle.getDecPlaces() +"f";
                        String temp = String.format(s,( shape[index]).area());
                        System.out.println("Area: "+temp);
                    }
                }
                else if(second.equals("perimeter")){
                    int index = Integer.parseInt(sc.next());
                    if(shape[index]==null) System.out.println("No object in this position");
                    else if(shape[index] instanceof Circle){
                        String s = "%." + Circle.getDecPlaces() +"f";
                        String temp = String.format(s,( shape[index]).perimeter());
                        System.out.println("Perimeter: "+temp);
                    }
                    else if(shape[index] instanceof Rectangle){
                        String s = "%." + Rectangle.getDecPlaces() +"f";
                        String temp = String.format(s,( shape[index]).perimeter());
                        System.out.println("Perimeter: "+temp);
                    }
                    else if(shape[index] instanceof EquiTriangle){
                        String s = "%." + EquiTriangle.getDecPlaces() +"f";
                        String temp = String.format(s,(( shape[index]).perimeter()));
                        System.out.println("Perimeter: "+temp);
                    }
                }
                else if(second.equals("radius")){
                    int ind = Integer.parseInt(sc.next());
                    if(shape[ind] instanceof Circle){
                        String s = "%." + Circle.getDecPlaces() +"f";
                        String temp = String.format(s,((Circle) shape[ind]).getRadius());
                        System.out.println("Radius: "+temp);
                    }
                    else if(shape[ind]==null) System.out.println("Not object in this position");
                    else System.out.println("Not a circle in this position");
                }
                else if(second.equals("width")){
                    int ind = Integer.parseInt(sc.next());
                    if(shape[ind] instanceof Rectangle){
                        String s = "%." + Circle.getDecPlaces() +"f";
                        String temp = String.format(s,((Rectangle) shape[ind]).getWidth());
                        System.out.println("Width: "+temp);
                    }
                    else if(shape[ind]==null) System.out.println("Not object in this position");
                    else System.out.println("Not a rectangle in this position");
                }
                else if (second.equals("height")){
                    int ind = Integer.parseInt(sc.next());
                    if(shape[ind] instanceof Rectangle){
                        String s = "%." + Circle.getDecPlaces() +"f";
                        String temp = String.format(s,((Rectangle) shape[ind]).getHeight());
                        System.out.println("Height: "+temp);
                    }
                    else if(shape[ind]==null) System.out.println("Not object in this position");
                    else System.out.println("Not a rectangle in this position");
                }
                else if(second.equals("diagonal") && sc.next().equals("length")){
                    int ind = Integer.parseInt(sc.next());
                    if(shape[ind] instanceof Rectangle){
                        String s = "%." + Circle.getDecPlaces() +"f";
                        String temp = String.format(s,((Rectangle) shape[ind]).diagonalLength());
                        System.out.println("Diagonal length: "+temp);
                    }
                    else if(shape[ind]==null) System.out.println("Not object in this position");
                    else System.out.println("Not a rectangle in this position");
                }
                else if(second.equals("side")){
                    int ind = Integer.parseInt((sc.next()));
                    if(shape[ind] instanceof EquiTriangle){
                        String s = "%." + Circle.getDecPlaces() +"f";
                        String temp = String.format(s,((EquiTriangle) shape[ind]).getSide());
                        System.out.println("Side: "+temp);
                    }
                    else if(shape[ind]==null) System.out.println("Not object in this position");
                    else System.out.println("Not an equilateral triangle in this position");
                }
                else if(second.equals("altitude")){
                    int ind = Integer.parseInt((sc.next()));
                    if(shape[ind] instanceof EquiTriangle){
                        String s = "%." + Circle.getDecPlaces() +"f";
                        String temp = String.format(s,((EquiTriangle) shape[ind]).altitude());
                        System.out.println("Altitude: "+temp);
                    }
                    else if(shape[ind]==null) System.out.println("Not object in this position");
                    else System.out.println("Not an equilateral triangle in this position");
                }
                else if(second.equals("type")){
                    int ind = Integer.parseInt(sc.next());
                    if(shape[ind]==null) System.out.println("No object in this position");
                    else if(shape[ind] instanceof Circle){
                        System.out.println("Type: Circle");
                    }
                    else if(shape[ind] instanceof Rectangle){
                        System.out.println("Type: Rectangle");
                    }
                    else if(shape[ind] instanceof EquiTriangle){
                        System.out.println("Type: EquiTriangle");
                    }
                }
                else if(second.equals("all")){
                    int check = 0;
                    for(int i = 0; i<shape.length; i++){
                        if(shape[i]==null) check++;
                        else{
                            System.out.print("Index "+ i+": ");
                            System.out.println(shape[i]);
                        }
                    }
                    if(check==10) System.out.println("Array is empty");
                }


                else{
                    int index = Integer.parseInt(second);
                    if(shape[index]==null) System.out.println("No object in this position");

                    else {
                        System.out.println(shape[index]);
                    }
                }
            }
            else if(first.equals("scale")){
                int index = Integer.parseInt(sc.next());
                double SF = Double.parseDouble(sc.next());
                if(shape[index]==null) System.out.println("No object in this position");
                else if(shape[index] instanceof Circle){
                    Circle temp = (Circle)shape[index];
                    temp.scale(SF);
                }
                else if(shape[index] instanceof Rectangle){
                    Rectangle temp = (Rectangle)shape[index];
                    temp.scale(SF);
                }
                else if(shape[index] instanceof EquiTriangle){
                    EquiTriangle temp = (EquiTriangle) shape[index];
                    temp.scale(SF);
                }
            }
            else if(first.equals("clear")){
                int ind = Integer.parseInt(sc.next());
                shape[ind] = null;
            }
            else if(first.equals("decimal")){
                int DP = Integer.parseInt(sc.next());
                Circle.setDecPlaces(DP);
                Rectangle.setDecPlaces(DP);
                EquiTriangle.setDecPlaces(DP);
            }
        }
    }
}