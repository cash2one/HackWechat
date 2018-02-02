package com.eclipsesource.a;

final class d extends h {
    private final String abC;

    d(String str) {
        if (str == null) {
            throw new NullPointerException("string is null");
        }
        this.abC = str;
    }

    public final String toString() {
        return this.abC;
    }

    final void a(i iVar) {
        iVar.G(this.abC);
    }

    public final boolean isNumber() {
        return true;
    }

    public final int hq() {
        return Integer.parseInt(this.abC, 10);
    }

    public final long hr() {
        return Long.parseLong(this.abC, 10);
    }

    public final double hs() {
        return Double.parseDouble(this.abC);
    }

    public final int hashCode() {
        return this.abC.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.abC.equals(((d) obj).abC);
    }
}
