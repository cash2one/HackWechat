package com.tencent.mm.ac;

public final class a {
    public String appId = "";
    public String filePath = "";
    public String fnF = "";
    public int fnG = 0;
    public int fromScene = 0;
    public String hks = "";
    public int hkt = 0;
    public int hku = 0;
    public boolean hkv = false;
    public boolean hkw = false;
    public long hkx = 0;
    public double hky = 1.0d;
    public d hkz;
    public String processName = "";

    public final boolean a(a aVar) {
        if (aVar == null || this.fnF == null || !this.fnF.equalsIgnoreCase(aVar.fnF) || this.hks == null || !this.hks.equalsIgnoreCase(aVar.hks)) {
            return false;
        }
        return true;
    }
}
