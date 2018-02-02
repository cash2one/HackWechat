package com.eclipsesource.a;

final class c extends h {
    private final boolean abA;
    private final boolean abB;
    private final boolean abz;
    private final String value;

    c(String str) {
        this.value = str;
        this.abz = "null".equals(str);
        this.abA = "true".equals(str);
        this.abB = "false".equals(str);
    }

    final void a(i iVar) {
        iVar.F(this.value);
    }

    public final String toString() {
        return this.value;
    }

    public final int hashCode() {
        return this.value.hashCode();
    }

    public final boolean isBoolean() {
        return this.abA || this.abB;
    }

    public final boolean hp() {
        return this.abz ? super.hp() : this.abA;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.value.equals(((c) obj).value);
    }
}
