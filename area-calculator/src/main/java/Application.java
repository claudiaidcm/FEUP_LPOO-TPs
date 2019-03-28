public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator =  new AreaAggregator();

        Shape circle1 = new Circle(2);
        Shape circle2 = new Circle(2);
        Shape square1 =  new Square(2);
        Shape square2 =  new Square(4);

        aggregator.addShape(circle1);
        aggregator.addShape(circle2);
        aggregator.addShape(square1);
        aggregator.addShape(square2);

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());

        
    }


}
