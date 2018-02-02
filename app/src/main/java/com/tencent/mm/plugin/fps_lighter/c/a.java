package com.tencent.mm.plugin.fps_lighter.c;

public final class a {
    public long mBm;
    public long mBn;
    public boolean mBo;
    public int mBp;
    public int mBq;
    public int mBr = 1;
    public long mBs;
    public boolean mBt;
    public int scene;

    public final long aKP() {
        return this.mBm - this.mBn;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(16);
        stringBuilder.append("\t");
        stringBuilder.append(this.scene);
        stringBuilder.append(" ");
        stringBuilder.append(this.mBn);
        stringBuilder.append(" ");
        stringBuilder.append(this.mBm);
        stringBuilder.append(" ");
        stringBuilder.append(this.mBo);
        stringBuilder.append(" ");
        stringBuilder.append(this.mBp);
        stringBuilder.append(" ");
        stringBuilder.append(this.mBq);
        stringBuilder.append(" ");
        stringBuilder.append(this.mBr);
        stringBuilder.append(" ");
        stringBuilder.append(this.mBs);
        stringBuilder.append(" ");
        stringBuilder.append(this.mBt);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
