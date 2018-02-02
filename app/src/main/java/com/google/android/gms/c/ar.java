package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class ar extends af<ar> {
    public String aYP;
    public String aZd;
    public long aZe;
    public String st;

    public final /* synthetic */ void a(af afVar) {
        ar arVar = (ar) afVar;
        if (!TextUtils.isEmpty(this.aZd)) {
            arVar.aZd = this.aZd;
        }
        if (this.aZe != 0) {
            arVar.aZe = this.aZe;
        }
        if (!TextUtils.isEmpty(this.st)) {
            arVar.st = this.st;
        }
        if (!TextUtils.isEmpty(this.aYP)) {
            arVar.aYP = this.aYP;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("variableName", this.aZd);
        hashMap.put("timeInMillis", Long.valueOf(this.aZe));
        hashMap.put("category", this.st);
        hashMap.put("label", this.aYP);
        return aj(hashMap);
    }
}
