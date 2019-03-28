public class Application {
    public static void main(String[] args) {
        //Instantiate AreaAggregator class
        AreaAggregator areaAggregator =  new AreaAggregator();

        //Creating shapes of different sides and dimensions
        Shape circle1 = new Circle(2);
        Shape circle2 = new Circle(2);
        Shape square1 =  new Square(2);
        Shape square2 =  new Square(4);

        //Adding the shapes created to tge areaAggregator list of shapes
        areaAggregator.addShape(circle1);
        areaAggregator.addShape(circle2);
        areaAggregator.addShape(square1);
        areaAggregator.addShape(square2);

        //Printing the sum of all the shapes' areas
        System.out.println(areaAggregator.output());

        
    }


}
