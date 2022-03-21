package edu.poniperro.logica;

import java.util.EnumSet;
import java.util.Set;

public enum Planeta {

    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27, 7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7);

    private static final double G = 6.67300E-11;
    private final double masa;
    private final double radio;

    private Planeta(double masa, double radio) {
        this.masa = masa;
        this.radio = radio;
    }

    public double getMasa() {
        return this.masa;
    }

    public double getRadio() {
        return this.radio;
    }

    private double gravedadEnSuperficie() {
        return Planeta.G * this.masa / Math.pow(this.radio, 2);
    }

    private double gravedadEnSuperficiePlaneta(Planeta planeta) {
        return Planeta.G * planeta.getMasa() / Math.pow(planeta.getRadio(), 2);
    }

    private double masaEnEARTH(double peso) {
        return peso / this.gravedadEnSuperficiePlaneta(EARTH);
    }

    public double pesoSuperficie(double peso) {
        return masaEnEARTH(peso) * gravedadEnSuperficie();
    }

    public static Set<Planeta> getPlanetasTerrestres() {
        return EnumSet.range(Planeta.MERCURY, Planeta.MARS);
    }

    public static Set<Planeta> getGigantesGaseosos() {
        return EnumSet.complementOf((EnumSet<Planeta>) Planeta.getPlanetasTerrestres());
    }
}
