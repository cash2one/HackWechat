package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class ao extends af<ao> {
    public String aYR;
    public boolean aYS;

    public final /* synthetic */ void a(af afVar) {
        ao aoVar = (ao) afVar;
        if (!TextUtils.isEmpty(this.aYR)) {
            aoVar.aYR = this.aYR;
        }
        if (this.aYS) {
            aoVar.aYS = this.aYS;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("description", this.aYR);
        hashMap.put("fatal", Boolean.valueOf(this.aYS));
        return af.aj(hashMap);
    }
}
