package com.tencent.mm.modelrecovery;

public class b$a {
    public int hKb;
    public int hKc;
    public int hKd;
    public int hKe;
    public int hKf;
    public int hKg;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.hKb > 0) {
            stringBuffer.append("totalCount:" + this.hKb + " ");
        }
        if (this.hKc > 0) {
            stringBuffer.append("enterRecoveryCount:" + this.hKc + " ");
        }
        if (this.hKd > 0) {
            stringBuffer.append("existRecoveryProcessCount:" + this.hKd + " ");
        }
        if (this.hKe > 0) {
            stringBuffer.append("foregroundExpCount:" + this.hKe + " ");
        }
        if (this.hKf > 0) {
            stringBuffer.append("backgroundExpCount:" + this.hKf + " ");
        }
        if (this.hKg > 0) {
            stringBuffer.append("normalCount:" + this.hKg + " ");
        }
        return stringBuffer.toString();
    }
}
