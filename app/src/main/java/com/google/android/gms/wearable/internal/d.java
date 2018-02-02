package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class d implements f {
    private Uri aMK;
    private byte[] bdg;
    private Map<String, g> bes;

    public d(f fVar) {
        this.aMK = fVar.getUri();
        this.bdg = fVar.getData();
        Map hashMap = new HashMap();
        for (Entry entry : fVar.rq().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), ((g) entry.getValue()).oy());
            }
        }
        this.bes = Collections.unmodifiableMap(hashMap);
    }

    public final byte[] getData() {
        return this.bdg;
    }

    public final Uri getUri() {
        return this.aMK;
    }

    public final /* synthetic */ Object oy() {
        return this;
    }

    public final Map<String, g> rq() {
        return this.bes;
    }

    public final String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity{ ");
        stringBuilder.append("uri=" + this.aMK);
        stringBuilder.append(", dataSz=" + (this.bdg == null ? "null" : Integer.valueOf(this.bdg.length)));
        stringBuilder.append(", numAssets=" + this.bes.size());
        if (isLoggable && !this.bes.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            for (Entry entry : this.bes.entrySet()) {
                stringBuilder.append(str + ((String) entry.getKey()) + ": " + ((g) entry.getValue()).getId());
                str = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
