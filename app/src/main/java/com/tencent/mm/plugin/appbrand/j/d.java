package com.tencent.mm.plugin.appbrand.j;

import com.tencent.mm.plugin.appbrand.j.c.a;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class d {
    a jBA;
    Map<String, String> jBB;
    ArrayList<String> jBC;
    int jBD = 15;
    String jBE;
    HttpURLConnection jBF;
    String jBG;
    int jBx;
    byte[] jBy;
    String jBz;
    String jbo;
    String mUrl;
    private long startTime;

    public d(String str, byte[] bArr, int i, a aVar, String str2) {
        this.mUrl = str;
        this.jBy = bArr;
        this.jBA = aVar;
        this.jBx = i;
        this.jBz = str2;
        this.startTime = System.currentTimeMillis();
    }

    public final int aiz() {
        return (int) (System.currentTimeMillis() - this.startTime);
    }

    public final long getDataSize() {
        if (this.jBy != null) {
            return (long) this.jBy.length;
        }
        return 0;
    }
}
