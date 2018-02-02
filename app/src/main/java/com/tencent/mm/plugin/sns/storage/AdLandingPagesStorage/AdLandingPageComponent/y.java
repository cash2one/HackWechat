package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.util.ArrayList;
import java.util.List;

public final class y extends s {
    public List<a> pYN = new ArrayList();
    public String rhp = "";
    public float rhq;
    public String rhr = "";
    public int rhs;
    public int rht;
    public int rhu;
    public int rhv;
    public String rhw = "";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (yVar.rhp != null) {
            if (yVar.rhp.equals(this.rhp)) {
            }
            return false;
        }
        if (yVar.rhq == this.rhq) {
            if (yVar.rhr != null) {
                if (yVar.rhr.equals(this.rhr)) {
                }
            }
            if (yVar.rhs == this.rhs && yVar.rht == this.rht && yVar.rhu == this.rhu && yVar.rhv == this.rhv) {
                if (yVar.pYN != null) {
                    if (yVar.pYN.equals(this.pYN)) {
                    }
                }
                if (yVar.rhw == null) {
                    if (this.rhw == null) {
                        return true;
                    }
                } else if (yVar.rhw.equals(this.rhw)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
