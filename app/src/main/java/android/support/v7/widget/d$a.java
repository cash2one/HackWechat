package android.support.v7.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class d$a implements Comparable<d$a> {
    final /* synthetic */ d Or;
    public final ResolveInfo resolveInfo;
    public float weight;

    public final /* synthetic */ int compareTo(Object obj) {
        return Float.floatToIntBits(((d$a) obj).weight) - Float.floatToIntBits(this.weight);
    }

    public d$a(d dVar, ResolveInfo resolveInfo) {
        this.Or = dVar;
        this.resolveInfo = resolveInfo;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.weight) + 31;
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
        if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(((d$a) obj).weight)) {
            return false;
        }
        return true;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.weight));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
