package ru.nsu.valikov.pizzeria.services;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import ru.nsu.valikov.pizzeria.Pizzeria;
import ru.nsu.valikov.workers.chef.Chef;
import ru.nsu.valikov.workers.courier.Courier;

/**
 * Opens a pizzeria.
 */
public class PizzeriaStarter extends Pizzeria implements Start {
    public PizzeriaStarter(List<Courier> couriers, List<Chef> workers) {
        super(couriers, workers);
    }

    @Override
    public void start() {
        Executor executor = Executors.newFixedThreadPool(couriers.size() + workers.size());
        workers.forEach(executor::execute);
        couriers.forEach(executor::execute);
    }
}