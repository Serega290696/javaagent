package com.agent;

public class Criminal {

    public static void main(String[] args) {
        System.out.println("I think someone is following me. . .");
        Bucket b = new Bucket();
        Weapon m16 = new Weapon(100);
        Drugs drugs = new Drugs(10, Drugs.DrugsType.COCO);
        System.out.println("empty bucket size (bytes) = " + Criminal.printObjectSize(b));
        System.out.println("m16 size (bytes) = " + Criminal.printObjectSize(m16));
        System.out.println("drugs size (bytes) = " + Criminal.printObjectSize(drugs));
    }

    public static long printObjectSize(Object obj) {
        return Agent008.getSize(obj);
    }

    static class Bucket {

    }

    static class Weapon {
        private int cost;
//        private int secretcost=1000000;
//        private int secretcost2=1000000;

        public Weapon(int cost) {
            this.cost = cost;
        }
    }

    static class Drugs {
        private Integer cost;
        private DrugsType drugsType;

        public Drugs(Integer cost, DrugsType drugsType) {
            this.cost = cost;
            this.drugsType = drugsType;
        }

        enum DrugsType {
            COCO,
            AMP;
        }

    }
}
