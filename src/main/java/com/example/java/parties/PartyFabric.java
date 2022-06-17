package com.example.java.parties;

import java.util.concurrent.ThreadLocalRandom;

public class PartyFabric {

    private ThreadLocalRandom random;
    private PartyGenerator pG;
    public PartyFabric(PartyGenerator pG) {
        this.pG=pG;
    }

    public Party CreateParty(){
        Party party = new Party();

        party.setName(pG.getName()[random.current().nextInt(0, pG.getName().length)]);
        party.setFocus(pG.getFocus()[random.current().nextInt(0, pG.getFocus().length)]);
        return party;

    }

}