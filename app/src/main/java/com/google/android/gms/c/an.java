package com.google.android.gms.c;

import android.text.TextUtils;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

public final class an extends af<an> {
    public String aOB;
    public String aYP;
    public long aYQ;
    public String st;

    public final /* synthetic */ void a(af afVar) {
        an anVar = (an) afVar;
        if (!TextUtils.isEmpty(this.st)) {
            anVar.st = this.st;
        }
        if (!TextUtils.isEmpty(this.aOB)) {
            anVar.aOB = this.aOB;
        }
        if (!TextUtils.isEmpty(this.aYP)) {
            anVar.aYP = this.aYP;
        }
        if (this.aYQ != 0) {
            anVar.aYQ = this.aYQ;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("category", this.st);
        hashMap.put("action", this.aOB);
        hashMap.put("label", this.aYP);
        hashMap.put(DownloadSettingTable$Columns.VALUE, Long.valueOf(this.aYQ));
        return aj(hashMap);
    }
}
