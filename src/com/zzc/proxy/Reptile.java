package com.zzc.proxy;

import java.util.concurrent.Callable;

interface Reptile {
    ReptileEgg lay() throws Exception;
}

class FireDragon implements Reptile{
    public FireDragon() {
    }

    @Override
    public ReptileEgg lay() throws Exception {
        return new ReptileEgg(() -> new FireDragon());
    }

    public static void main(String[] args) throws Exception {
        FireDragon fireDragon = new FireDragon();
        System.out.println(fireDragon instanceof Reptile);
        ReptileEgg fireDragonEgg = fireDragon.lay();
        FireDragon sonDragon = (FireDragon) fireDragonEgg.hatch();
        fireDragonEgg.hatch();
    }
}

class ReptileEgg {

    private Reptile reptile;
    private boolean isBirth;

    public ReptileEgg(Callable<Reptile> createReptile) throws Exception {
        if (createReptile.call() instanceof FireDragon) {
            this.reptile = new FireDragon();
        }
        isBirth = false;
    }

    public Reptile hatch() {
        if (!isBirth) {
            isBirth = true;
            return reptile;
        }
        return null;
    }
}