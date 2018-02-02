package com.tencent.mm.plugin.fps_lighter.c;

import java.util.ArrayList;
import java.util.List;

public final class c {
    public int axZ;
    public int hTi;
    public List<String> mBA = new ArrayList();
    public long mBB;
    public long mBu;
    public long mBv;
    public List<String> mBz = new ArrayList();

    public c(b bVar) {
        this.mBu = bVar.mBu;
        this.mBv = bVar.mBv;
        this.mBz.add(bVar.jHU);
        this.mBB = bVar.jHU;
        this.mBA.add(bVar.beginTime);
        this.axZ = bVar.axZ;
        this.hTi = 1;
    }

    public final String getKey() {
        return this.mBv + ">" + this.axZ;
    }

    public final String aKQ() {
        return this.mBu + ">" + (this.axZ - 1);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mBv);
        stringBuilder.append(" ");
        stringBuilder.append(this.mBB);
        stringBuilder.append(" ");
        stringBuilder.append(this.axZ);
        stringBuilder.append(" ");
        stringBuilder.append(this.hTi);
        stringBuilder.append(" ");
        stringBuilder.append(this.mBu);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
