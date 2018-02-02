package com.tencent.mm.plugin.freewifi;

public class k$a {
    public String bssid;
    public int fCR;
    public String fpA;
    public String fpz;
    public String kZo;
    private int mCr;
    public String mCs;
    public String mCt;
    public String mCu;
    public int mCv;
    public long mCw;
    public String mCx;
    public String mCy;
    private long mCz;
    public int result;
    public String ssid;

    private k$a() {
    }

    public final k aLg() {
        k kVar = new k((byte) 0);
        k.a(kVar, this.ssid);
        k.b(kVar, this.bssid);
        k.c(kVar, this.fpA);
        k.d(kVar, this.fpz);
        k.a(kVar, this.mCr);
        k.e(kVar, this.mCs);
        k.f(kVar, this.mCt);
        k.g(kVar, this.mCu);
        k.b(kVar, this.mCv);
        k.a(kVar, (long) Integer.valueOf("1" + String.format("%03d", new Object[]{Integer.valueOf(this.mCv)}) + String.format("%03d", new Object[]{Long.valueOf(this.mCw)})).intValue());
        k.h(kVar, this.mCx);
        k.c(kVar, this.result);
        k.d(kVar, this.fCR);
        k.i(kVar, this.mCy);
        k.b(kVar, this.mCz);
        k.j(kVar, this.kZo);
        return kVar;
    }
}
