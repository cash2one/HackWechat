package com.tencent.mm.pluginsdk.i.a.d;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.pluginsdk.i.a.d.f.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class k implements b {
    private final String filePath;
    private final String groupId;
    protected volatile int jTA = 15000;
    private final String method;
    final int networkType;
    final int priority;
    protected final Map<String, String> requestHeaders = new HashMap();
    public final String url;
    public final String vgd;
    final int vgn;
    protected volatile int vhM = HardCoderJNI.sHCENCODEVIDEOTIMEOUT;
    protected volatile int vhN = 15000;
    private final String vhw;

    public k(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3) {
        this.vgd = str;
        this.filePath = str2;
        this.vhw = str3;
        this.groupId = str4;
        this.url = str5;
        this.method = str6;
        this.vgn = i;
        this.networkType = i2;
        this.priority = Math.max(i3, 0);
    }

    public boolean bZn() {
        return false;
    }

    public String aab() {
        return this.groupId;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public final String bZj() {
        return this.vgd;
    }

    public final Map<String, String> getRequestHeaders() {
        if (this.requestHeaders.size() == 0) {
            return null;
        }
        return Collections.unmodifiableMap(this.requestHeaders);
    }

    public final void setConnectTimeout(int i) {
        this.jTA = i;
    }

    public final int getConnectTimeout() {
        return this.jTA;
    }

    public final void setReadTimeout(int i) {
        this.vhM = i;
    }

    public final int getReadTimeout() {
        return this.vhM;
    }

    public final int bZy() {
        return this.vhN;
    }
}
