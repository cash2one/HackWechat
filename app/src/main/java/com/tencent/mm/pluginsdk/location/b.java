package com.tencent.mm.pluginsdk.location;

public final class b {
    public int fzv;
    public float hxF;
    public float hxG;
    public int scene;
    public long vcV;

    public b(long j, float f, float f2, int i, int i2) {
        this.hxF = f;
        this.hxG = f2;
        this.fzv = i;
        this.scene = i2;
        this.vcV = j;
    }

    public final String toString() {
        return String.format("%d-%d-%d", new Object[]{Integer.valueOf((int) (this.hxF * 1000000.0f)), Integer.valueOf((int) (this.hxG * 1000000.0f)), Integer.valueOf(this.fzv)});
    }
}
