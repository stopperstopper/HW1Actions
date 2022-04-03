package component;

public enum EnumMonth {
    JANUARY("января", 0),
    FEBRUARY("февраля",1),
    MARCH("марта",2),
    APRIL("апреля",3),
    MAY("мая",4),
    JUNE("июня",5),
    JULY("июля",6),
    AUGUST("августа",7),
    SEPTEMBER("сентября",8),
    OCTOBER("октября",9),
    NOVEMBER("ноября",10),
    DECEMBER("декабря",11);


    private String name;
    private int monthNumber;


    EnumMonth(String name, int monthNumber) {
        this.name=name;
        this.monthNumber=monthNumber;
    }

    public String getName() {
        return name;
    }
    public int getMonthNumber() {
        return monthNumber;
    }
}
