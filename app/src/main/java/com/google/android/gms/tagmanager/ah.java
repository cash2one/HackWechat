package com.google.android.gms.tagmanager;

final class ah extends Number implements Comparable<ah> {
    private double bcD;
    private long bcE = 0;
    boolean bcF = true;

    private ah(long j) {
    }

    private int a(ah ahVar) {
        return (this.bcF && ahVar.bcF) ? new Long(this.bcE).compareTo(Long.valueOf(ahVar.bcE)) : Double.compare(doubleValue(), ahVar.doubleValue());
    }

    public static ah rc() {
        return new ah(0);
    }

    public final byte byteValue() {
        return (byte) ((int) longValue());
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return a((ah) obj);
    }

    public final double doubleValue() {
        return this.bcF ? (double) this.bcE : this.bcD;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ah) && a((ah) obj) == 0;
    }

    public final float floatValue() {
        return (float) doubleValue();
    }

    public final int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public final int intValue() {
        return (int) longValue();
    }

    public final long longValue() {
        return this.bcF ? this.bcE : (long) this.bcD;
    }

    public final short shortValue() {
        return (short) ((int) longValue());
    }

    public final String toString() {
        return this.bcF ? Long.toString(this.bcE) : Double.toString(this.bcD);
    }
}
