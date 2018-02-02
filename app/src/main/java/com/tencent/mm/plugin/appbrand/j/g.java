package com.tencent.mm.plugin.appbrand.j;

import com.tencent.mm.plugin.appbrand.j.f.a;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class g {
    public volatile boolean bgH = false;
    Map<String, String> jBB;
    ArrayList<String> jBC;
    int jBD = 15;
    HttpURLConnection jBF = null;
    String jBG;
    String jBL;
    Map<String, String> jBM;
    a jBN;
    int jBx;
    String jbo;
    String mFileName;
    String mMimeType;
    String mName;
    String mUrl;
    private long startTime;

    g(String str, String str2, String str3, String str4, int i, String str5, a aVar) {
        this.jBL = str;
        this.mUrl = str2;
        this.jBN = aVar;
        this.mName = str3;
        this.mFileName = str4;
        this.jBx = i;
        this.mMimeType = str5;
        this.startTime = System.currentTimeMillis();
    }

    public final int aiz() {
        return (int) (System.currentTimeMillis() - this.startTime);
    }
}
