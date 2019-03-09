package com.fturk.ch1;


import java.time.Month;

/*
  An enumeration is like a fixed set of constants.

  -It is impossible to create an invalid enum type without introducing a compiler error.

  -Since an enum is like a set of constants, use the uppercaste letter convention that you used for constant.

  -Behind the scenes, an enum is a type of class that mainly contains static members. It also includes some helper
  methods like name() that you will see shortly.

  -You can't do is extend an enum.

  -Try to keep your enums simple. If your enum is more than a page or two, it is way too long. Most enums
are just a handful of lines.

 -Public constructor is not allow in enum.
 */
enum Season {
    WINTER("Cold", new Month[]{Month.DECEMBER, Month.JANUARY, Month.FEBRUARY}, 1) {
        @Override
        public void printMont() {
            System.out.println(Season.WINTER.seasonOfMonth);
        }
    },
    SPRING("Cold-Hot", new Month[]{Month.MARCH, Month.APRIL, Month.MAY}, 2) {
        @Override
        public void printMont() {
            System.out.println(Season.SPRING.seasonOfMonth);
        }
    },
    SUMMER("Hot", new Month[]{Month.JUNE, Month.JULY, Month.AUGUST}) {
        @Override
        public void printMont() {
            System.out.println(Season.SUMMER.seasonOfMonth);
        }
    },
    FALL("Hot-Cold", new Month[]{Month.SEPTEMBER, Month.NOVEMBER, Month.OCTOBER}) {
        @Override
        public void printMont() {
            System.out.println(Season.FALL.seasonOfMonth);
        }
    };

    private int order;

    private Month[] seasonOfMonth;

    protected String monthTempState;

    Season(String tempState, Month[] months) {
        this.seasonOfMonth = months;
        this.monthTempState = tempState;
    }

    Season(String tempState, Month[] months, int order) {
        this.seasonOfMonth = months;
        this.monthTempState = tempState;
        this.order = order;

    }

    public abstract void printMont();


    public static void printAllSeasons() {
        for (Season s : Season.values()) {
            System.out.println(s.name() + " " + s.ordinal());
        }
    }

    public Month[] getSeasonOfMonth() {
        return seasonOfMonth;
    }

    public String getMonthTempState() {
        return monthTempState;
    }

    public void printMonthsOfSeason() {
        for (Month month : this.getSeasonOfMonth()) {
            System.out.print(month.name() + " " + " " + month.getValue() + " ,");
        }
        System.out.println();
    }

    public void printSeasonalMonthTempState() {
        switch (this) {
            case FALL:
                System.out.println("cloudy , warm  and  "+FALL.getMonthTempState());
                break;
            case SUMMER:
                System.out.println("Sunny , very "+SUMMER.getMonthTempState());
                break;
            case SPRING:
                System.out.println("Sunny ,rainy and "+ SPRING.getMonthTempState());
                break;
            case WINTER:
                System.out.println("Very "+WINTER.getMonthTempState());
                break;
        }
    }
}

public class EnumExample {

    public static void main(String[] args) {
        Season.printAllSeasons();
        Season.FALL.printMonthsOfSeason();
        Season.FALL.printSeasonalMonthTempState();
    }
}

