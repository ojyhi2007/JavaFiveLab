public class CachedFraction extends Fraction {
    private Double cachedValue;
    private boolean cacheValid;

    public CachedFraction(int numerator, int denominator) {
        super(numerator, denominator);
        this.cacheValid = false;
    }

    @Override
    public void setNumerator(int numerator) {
        super.setNumerator(numerator);
        invalidateCache();
    }

    @Override
    public void setDenominator(int denominator) {
        super.setDenominator(denominator);
        invalidateCache();
    }

    @Override
    public double toDouble() {
        if (!cacheValid) {
            cachedValue = super.toDouble();
            cacheValid = true;
        }
        return cachedValue;
    }

    private void invalidateCache() {
        cacheValid = false;
        cachedValue = null;
    }
}