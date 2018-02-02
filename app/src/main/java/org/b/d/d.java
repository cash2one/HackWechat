package org.b.d;

public final class d implements Comparable<d> {
    final String aAM;
    final String value;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        d dVar = (d) obj;
        int compareTo = this.aAM.compareTo(dVar.aAM);
        return compareTo != 0 ? compareTo : this.value.compareTo(dVar.value);
    }

    public d(String str, String str2) {
        this.aAM = str;
        this.value = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (dVar.aAM.equals(this.aAM) && dVar.value.equals(this.value)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.aAM.hashCode() + this.value.hashCode();
    }
}
