package uebung05.logistics;

import uebung05.logistics.quantities.FloatUnit;
import uebung05.logistics.quantities.IntUnit;
import uebung05.logistics.quantities.NeedCollector;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<Vehicle> vehicles= new ArrayList<>();

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void fillUpVehicles(){
        for(Vehicle vehicle : vehicles){
            vehicle.fillUpAll();
        }
    }

    public void logTick(int intensityRate){
        for(Vehicle vehicle : vehicles){
            vehicle.consumeAll(intensityRate);
        }
    }

    public NeedCollector collectNeeds(){
        NeedCollector need = new NeedCollector();
        for(Vehicle vehicle : vehicles){
            vehicle.reportNeeds(need);
        }
        return need;
    }

    public void showOverallNeed(){
        NeedCollector need = collectNeeds();
        need.show();
    }

    public void showNeed(IntUnit unit){
        NeedCollector need = collectNeeds();
        int amount = need.getNeed(unit);
        if(amount > 0) System.out.println(unit + ": " + amount);
    }

    public void showNeed(FloatUnit unit){
        NeedCollector need = collectNeeds();
        float amount = need.getNeed(unit);
        if(amount > 0){
            System.out.println(unit + ": " + amount);
        }
    }

}