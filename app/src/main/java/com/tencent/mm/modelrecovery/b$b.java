package com.tencent.mm.modelrecovery;

public class b$b {
    public int hKh;
    public int hKi;
    public int hKj;
    public int hKk;
    public int hKl;
    public int hKm;
    public int hKn;
    public int hKo;
    public int hKp;
    public int hKq;
    public int hKr;
    public int hKs;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.hKh > 0) {
            stringBuffer.append("appForegroundExpCount:" + this.hKh + " ");
        }
        if (this.hKi > 0) {
            stringBuffer.append("appBackgroundExpCount:" + this.hKi + " ");
        }
        if (this.hKj > 0) {
            stringBuffer.append("componentForegroundExpCount:" + this.hKj + " ");
        }
        if (this.hKk > 0) {
            stringBuffer.append("componentBackgroundExpCount:" + this.hKk + " ");
        }
        if (this.hKl > 0) {
            stringBuffer.append("appForegroundCrashOrAnrExpCount:" + this.hKl + " ");
        }
        if (this.hKm > 0) {
            stringBuffer.append("appBackgroundCrashOrAnrExpCount:" + this.hKm + " ");
        }
        if (this.hKn > 0) {
            stringBuffer.append("componentForegroundCrashOrAnrExpCount:" + this.hKn + " ");
        }
        if (this.hKo > 0) {
            stringBuffer.append("componentBackgroundCrashOrAnrExpCount:" + this.hKo + " ");
        }
        if (this.hKp > 0) {
            stringBuffer.append("appForegroundTimeoutExpCount:" + this.hKp + " ");
        }
        if (this.hKq > 0) {
            stringBuffer.append("appBackgroundTimeoutExpCount:" + this.hKq + " ");
        }
        if (this.hKr > 0) {
            stringBuffer.append("componentForegroundTimeoutExpCount:" + this.hKr + " ");
        }
        if (this.hKs > 0) {
            stringBuffer.append("componentBackgroundTimeoutExpCount:" + this.hKs + " ");
        }
        return stringBuffer.toString();
    }
}
