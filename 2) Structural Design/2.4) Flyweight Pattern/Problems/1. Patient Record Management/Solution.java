
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Address {

    String street;
    String city;
    int zipcode;
}

class TreatmentDetail {

}

class Patient {

    private PatientIntrinsicState intrinsicState;
    private PatientExtrinsicState extrinsicState;
}

class PatientIntrinsicState {

    Date dateOfBirth;
    String bloodGroup;
    String hospitalName;
}

class PatientExtrinsicState {

    long patientId;
    String Name;
    int age;
    List<TreatmentDetail> treatmentDetails;
}

interface PatientFlyweightRegistry {

    void addPatient(long patientId, PatientIntrinsicState patient);

    PatientIntrinsicState getPatientIntrinsicState(long patientId);
}

class PatientIntrinsicFlyweight implements PatientFlyweightRegistry {

    private static Map<Long, PatientIntrinsicState> patientRegistry = new HashMap<Long, PatientIntrinsicState>();

    @Override
    public void addPatient(long patientId, PatientIntrinsicState patient) {
        if (!patientRegistry.containsKey(patientId)) {
            patientRegistry.put(patientId, patient);
        }
    }

    @Override
    public PatientIntrinsicState getPatientIntrinsicState(long patientId) {
        return patientRegistry.get(patientId);
    }
}

public class Solution {

    // Client class
}
