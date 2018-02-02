package com.tencent.mm.plugin.g.a.a;

import java.util.Arrays;

public final class c {
    public String bpq = "";
    String kvT = null;
    public e kvU = null;
    public double kvV = 0.0d;

    public final int hashCode() {
        if (this.kvU == null) {
            return 0;
        }
        return Arrays.hashCode(this.kvU.kvY.kwz);
    }

    public final boolean equals(Object obj) {
        if (this.kvU == null || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Arrays.equals(((c) obj).kvU.kvY.kwz, this.kvU.kvY.kwz);
    }
}
