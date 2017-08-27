package utils;

/**
 * Created by Alexander on 27.08.2017.
 */
public class Range {

    private String from;
    private String to;

    public static Range range() {
        return new Range();
    }

    public String from() {
        return from;
    }

    public Range from(String from) {
        this.from = from;
        return this;
    }

    public String to() {
        return to;
    }

    public Range to(String to) {
        this.to = to;
        return this;
    }
}
