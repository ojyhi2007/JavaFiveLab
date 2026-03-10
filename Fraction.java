import java.util.Objects;

public class Fraction implements FractionValueable {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        validateDenominator(denominator);
        this.numerator = numerator;
        this.denominator = denominator;
        normalizeSign();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        normalizeSign();
    }

    @Override
    public void setDenominator(int denominator) {
        validateDenominator(denominator);
        this.denominator = denominator;
        normalizeSign();
    }

    @Override
    public double toDouble() {
        return (double) numerator / denominator;
    }

    private void validateDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        }
    }

    private void normalizeSign() {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction fraction)) return false;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}