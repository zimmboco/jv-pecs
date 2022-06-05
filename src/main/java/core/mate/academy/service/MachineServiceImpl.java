package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.LinkedList;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl implements MachineService<Machine> {
    @Override
    public List getAll(Class<? extends Machine> type) {
        if (type == Bulldozer.class) {
            return new BulldozerProducer().get();
        } else if (type == Excavator.class) {
            return new ExcavatorProducer().get();
        } else if (type == Truck.class) {
            return new TruckProducer().get();
        } else {
            return new LinkedList<>();
        }
    }

    @Override
    public void fill(List<? super Machine> list, Machine value) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> list) {
        for (int i = 0; i < list.size(); i++) {
            Machine machine = list.get(i);
            machine.doWork();
        }
    }
}
