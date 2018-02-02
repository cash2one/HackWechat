package android.support.v7.widget;

class e$b {
    int OZ;
    Object Pa;
    int Pb;
    int pK;

    e$b(int i, int i2, int i3, Object obj) {
        this.pK = i;
        this.OZ = i2;
        this.Pb = i3;
        this.Pa = obj;
    }

    public final String toString() {
        String str;
        StringBuilder append = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
        switch (this.pK) {
            case 1:
                str = "add";
                break;
            case 2:
                str = "rm";
                break;
            case 4:
                str = "up";
                break;
            case 8:
                str = "mv";
                break;
            default:
                str = "??";
                break;
        }
        return append.append(str).append(",s:").append(this.OZ).append("c:").append(this.Pb).append(",p:").append(this.Pa).append("]").toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e$b android_support_v7_widget_e_b = (e$b) obj;
        if (this.pK != android_support_v7_widget_e_b.pK) {
            return false;
        }
        if (this.pK == 8 && Math.abs(this.Pb - this.OZ) == 1 && this.Pb == android_support_v7_widget_e_b.OZ && this.OZ == android_support_v7_widget_e_b.Pb) {
            return true;
        }
        if (this.Pb != android_support_v7_widget_e_b.Pb) {
            return false;
        }
        if (this.OZ != android_support_v7_widget_e_b.OZ) {
            return false;
        }
        if (this.Pa != null) {
            if (this.Pa.equals(android_support_v7_widget_e_b.Pa)) {
                return true;
            }
            return false;
        } else if (android_support_v7_widget_e_b.Pa != null) {
            return false;
        } else {
            return true;
        }
    }

    public final int hashCode() {
        return (((this.pK * 31) + this.OZ) * 31) + this.Pb;
    }
}
