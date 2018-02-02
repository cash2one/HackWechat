package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;

final class n$a {
    private final String aOB;
    private final String aOC;
    private final ComponentName aOD;

    public n$a(ComponentName componentName) {
        this.aOB = null;
        this.aOC = null;
        this.aOD = (ComponentName) w.ag(componentName);
    }

    public n$a(String str, String str2) {
        this.aOB = w.aM(str);
        this.aOC = w.aM(str2);
        this.aOD = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n$a)) {
            return false;
        }
        n$a com_google_android_gms_common_internal_n_a = (n$a) obj;
        return v.b(this.aOB, com_google_android_gms_common_internal_n_a.aOB) && v.b(this.aOD, com_google_android_gms_common_internal_n_a.aOD);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.aOB, this.aOD});
    }

    public final Intent oP() {
        return this.aOB != null ? new Intent(this.aOB).setPackage(this.aOC) : new Intent().setComponent(this.aOD);
    }

    public final String toString() {
        return this.aOB == null ? this.aOD.flattenToString() : this.aOB;
    }
}
