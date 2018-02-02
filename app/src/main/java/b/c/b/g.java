package b.c.b;

import b.e.d;

public abstract class g extends a implements d {
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return obj instanceof d ? obj.equals(cJu()) : false;
        } else {
            g gVar = (g) obj;
            if (cJv().equals(gVar.cJv()) && getName().equals(gVar.getName()) && cjL().equals(gVar.cjL()) && e.h(cJt(), gVar.cJt())) {
                return true;
            }
            return false;
        }
    }

    public int hashCode() {
        return (((cJv().hashCode() * 31) + getName().hashCode()) * 31) + cjL().hashCode();
    }

    public String toString() {
        g cJu = cJu();
        if (cJu != this) {
            return cJu.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
