
import java.util.Map;

enum Mode {
    DRIVING, WALKING, CYCLING, TRANSPORT, FLYING
}

interface PathFinder {

    Path findPath(String from, String to);
}

class Path {

    String route;
    String estimatedTime;

    Path(String route, String estimatedTime) {
        this.route = route;
        this.estimatedTime = estimatedTime;
    }

    public String getRoute() {
        return this.route;
    }

    public String getEstimatedTime() {
        return this.estimatedTime;
    }

    @Override
    public String toString() {
        return "Recommended route: " + this.route + " Estimated time: " + this.estimatedTime;
    }
}

class DrivingMode implements PathFinder {   // Strategy - 1

    @Override
    public Path findPath(String from, String to) {
        return new Path("Take NH48 from Chennai to Bangalore.", "6 hours 40 minutes");
    }
}

class WalkingMode implements PathFinder {   // Strategy - 2

    @Override
    public Path findPath(String from, String to) {
        return new Path("Walking from Chennai to Bangalore is not practical due to the long distance and lack of pedestrian pathways along highways.", "7 days");
    }
}

class CyclingMode implements PathFinder {   // Strategy - 3

    @Override
    public Path findPath(String from, String to) {
        return new Path("Cycling along NH48 from Chennai to Bangalore.", "2 days 20 hours");
    }
}

class TransportMode implements PathFinder { // Strategy - 4

    @Override
    public Path findPath(String from, String to) {
        return new Path("Multiple bus services operate between Chennai and Bangalore, with frequent departures.", "7 hours 45 minutes");
    }
}

class FlyingMode implements PathFinder {    // Strategy - 5

    @Override
    public Path findPath(String from, String to) {
        return new Path("Direct flights from Chennai International Airport (MAA) to Kempegowda International Airport (BLR) in Bangalore.", "1 hour 20 minutes, including boarding time.");
    }
}

class PathFinderFactory {

    private static final Map<Mode, PathFinder> registry = Map.of(
            Mode.WALKING, new WalkingMode(), // k1, v1
            Mode.CYCLING, new CyclingMode(), // k2, v2
            Mode.TRANSPORT, new TransportMode(), // k3, v3
            Mode.FLYING, new FlyingMode(), // k4, v4
            Mode.DRIVING, new DrivingMode() // k5, v5
    );

    public static PathFinder getStrategy(Mode mode) {
        return registry.getOrDefault(mode, new DrivingMode());
    }
}

public class Solution {

    private static String getRoute(String from, String to, Mode mode) {

        PathFinder pathfinder = PathFinderFactory.getStrategy(mode);
        Path path = pathfinder.findPath(from, to);
        return path.toString();
    }

    public static void main(String[] args) {

        System.out.println(getRoute("Zoho, Chennai", "Microsoft, Bangalore", Mode.DRIVING));
    }
}
