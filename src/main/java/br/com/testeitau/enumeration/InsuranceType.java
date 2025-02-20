package br.com.testeitau.enumeration;


public enum InsuranceType
{
    BASIC("basic",  2),
    PARTIAL("partial",  3),
    TOTAL("total", 4);

    private final String name;
    private final int value;

    InsuranceType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

}