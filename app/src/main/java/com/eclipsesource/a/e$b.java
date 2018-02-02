package com.eclipsesource.a;

public class e$b {
    private final h abJ;
    private final String name;

    e$b(String str, h hVar) {
        this.name = str;
        this.abJ = hVar;
    }

    public final int hashCode() {
        return ((this.name.hashCode() + 31) * 31) + this.abJ.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        e$b com_eclipsesource_a_e_b = (e$b) obj;
        if (this.name.equals(com_eclipsesource_a_e_b.name) && this.abJ.equals(com_eclipsesource_a_e_b.abJ)) {
            return true;
        }
        return false;
    }
}
