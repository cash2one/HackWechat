package com.tencent.mm.plugin.fps_lighter.c;

public final class b {
    public int axZ;
    public long beginTime;
    public long jHU;
    public long mBu;
    public long mBv;
    public int mBw;

    public final String getKey() {
        return this.mBv + ">" + this.axZ;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(16);
        for (int i = 0; i < this.axZ; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(this.mBv);
        stringBuilder.append(" ");
        stringBuilder.append(this.jHU);
        stringBuilder.append(" ");
        stringBuilder.append(this.beginTime);
        stringBuilder.append(" ");
        stringBuilder.append(this.axZ);
        stringBuilder.append(" ");
        stringBuilder.append(this.mBu);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
