package com.tencent.mm.pluginsdk.model;

public final class q {
    public String fqV;
    private int vdD;
    public String vdE;
    public String vdF;
    public String vdG;
    public int vdH;

    q(int i, String str, String str2, String str3, String str4, int i2) {
        this.vdD = i;
        this.fqV = str;
        this.vdE = str2;
        this.vdH = i2;
        this.vdF = str3;
        this.vdG = str4;
    }

    public final String toString() {
        return "id:" + this.vdD + ";productId:" + this.fqV + ";full:" + this.vdE + ";productState:" + this.vdH + ";priceCurrencyCode:" + this.vdF + ";priceAmountMicros:" + this.vdG;
    }
}
