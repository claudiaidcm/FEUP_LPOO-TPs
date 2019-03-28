public class AreaXMLOutputter {

    AreaAggregator areaAggregator;

    public AreaXMLOutputter(AreaAggregator areaAggregator) {
        this.areaAggregator = areaAggregator;
    }

    public String output() {
        return "<area>"+ areaAggregator.sum() + "</area>";
    }
}
