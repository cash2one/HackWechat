package com.eclipsesource.a;

final class g extends h {
    private final String abC;

    g(String str) {
        if (str == null) {
            throw new NullPointerException("string is null");
        }
        this.abC = str;
    }

    final void a(i iVar) {
        iVar.writeString(this.abC);
    }

    public final boolean isString() {
        return true;
    }

    public final String hC() {
        return this.abC;
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
        return this.abC.equals(((g) obj).abC);
    }
}
