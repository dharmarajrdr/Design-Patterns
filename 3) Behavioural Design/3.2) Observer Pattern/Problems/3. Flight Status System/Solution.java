
import java.util.ArrayList;
import java.util.List;

// Observer = Interface
interface FlightStatusTracker {
    void onStatusUpdate(String status);
}

class PassengerNotifier implements FlightStatusTracker {

    public void onStatusUpdate(String status) {
        System.out.println("Dear passenger, flight status changed to: " + status);
    }
}

class AirportDisplayBoard implements FlightStatusTracker {

    public void onStatusUpdate(String status) {
        System.out.println("Display board updated: " + status);
    }
}

class AirlineStaff implements FlightStatusTracker {

    public void onStatusUpdate(String status) {
        System.out.println("Staff alerted, flight status: " + status);
    }
}

// Subject = Service class
class StatusTrackingService {
    
    private final List<FlightStatusTracker> trackers;

    public StatusTrackingService() { this.trackers = new ArrayList<>(); }

    public void addTracker(FlightStatusTracker tracker) { this.trackers.add(tracker); }

    public void removeTracker(FlightStatusTracker tracker) { this.trackers.remove(tracker); }

    private void notifyStatusChange(String status) {
        this.trackers.forEach(tracker -> tracker.onStatusUpdate(status));
    }

    public void updateStatus(String status) {
        // update logic here
        notifyStatusChange(status);
    }
}

public class Solution {

    public static void main(String[] args) {
        
        StatusTrackingService statusTrackingService = new StatusTrackingService();
        AirlineStaff airlineStaff = new AirlineStaff();
        statusTrackingService.addTracker(new PassengerNotifier());
        statusTrackingService.addTracker(new AirportDisplayBoard());
        statusTrackingService.addTracker(airlineStaff);
        statusTrackingService.updateStatus("Delayed");
        
        statusTrackingService.removeTracker(airlineStaff);
        statusTrackingService.updateStatus("Cancelled");
    }
}
