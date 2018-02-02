package com.tencent.b.a.a;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public final class n implements Runnable {
    public static long bpG = -1;
    private a bpE = null;
    int bpF = 0;
    private Context mContext = null;
    private int mType = 0;

    public n(Context context, int i) {
        this.mContext = context;
        this.mType = i;
    }

    private void sO() {
        g w = r.Z(this.mContext).w(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1)})));
        g w2 = r.Z(this.mContext).w(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2)})));
        g w3 = r.Z(this.mContext).w(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(4)})));
        if (!s.b(w, w2) || !s.b(w, w3)) {
            w = s.a(s.a(w, w2), s.a(w, w3));
            new StringBuilder("local mid check failed, redress with mid:").append(w.toString());
            r.Z(this.mContext).b(w);
        }
    }

    private void b(JSONObject jSONObject) {
        if (i.bpu != null && j.bpA != 1) {
            if (j.bpB <= 0 || this.bpF <= j.bpB) {
                i.bpu.bH("[" + new m(this.mContext, jSONObject).sN().toString() + "]");
                bpG = System.currentTimeMillis();
                this.bpF++;
                return;
            }
            new StringBuilder("limit dispatch:").append(j.bpB);
        }
    }

    public final void run() {
        new StringBuilder("request type:").append(this.mType);
        switch (this.mType) {
            case 1:
                b(null);
                return;
            case 2:
                if (this.bpE == null) {
                    this.bpE = r.Z(this.mContext).sQ();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i.bpv <= 0) {
                    i.bpv = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0);
                }
                long abs = Math.abs(currentTimeMillis - i.bpv);
                new StringBuilder("check entity: ").append(this.bpE.toString()).append(",duration:").append(abs);
                if (this.bpE.boW < 0 || this.bpE.boW > 100) {
                    this.bpE.boW = 3;
                }
                long j = ((long) this.bpE.boW) * e.bpp;
                new StringBuilder("duration:").append(abs).append(",maxCheckDays:").append(j).append(",mLastCheckTime:").append(i.bpv).append(",mCheckEntity:").append(this.bpE);
                if (abs >= j) {
                    sO();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("dur", abs);
                        jSONObject.put("md", j);
                        jSONObject.put("lct", i.bpv);
                        jSONObject.put("cur", currentTimeMillis);
                    } catch (JSONException e) {
                    }
                    if (bpG <= 0) {
                        b(jSONObject);
                        return;
                    }
                    return;
                } else if (abs > e.bpp) {
                    sO();
                    return;
                } else {
                    return;
                }
            default:
                new StringBuilder("wrong type:").append(this.mType);
                return;
        }
    }
}
