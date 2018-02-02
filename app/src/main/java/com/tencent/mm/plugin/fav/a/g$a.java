package com.tencent.mm.plugin.fav.a;

public class g$a {
    public int cOY;
    public int index;
    public long mnX;
    public String mnY;
    public long mnZ;
    public long moa;
    public boolean mob;
    public int moc;
    public int mod;
    public int moe;
    public int mof;
    public int mog;
    public boolean moh;
    public boolean moi;
    public int moj;
    public int scene;
    public long timestamp;
    public int type;

    public final String toString() {
        int i;
        int i2 = 1;
        String str = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
        Object[] objArr = new Object[18];
        objArr[0] = Integer.valueOf(this.scene);
        objArr[1] = Integer.valueOf(this.index);
        objArr[2] = Long.valueOf(this.mnX);
        objArr[3] = Integer.valueOf(this.type);
        objArr[4] = this.mnY;
        objArr[5] = Integer.valueOf(this.cOY);
        objArr[6] = Long.valueOf(this.timestamp);
        objArr[7] = Long.valueOf(this.mnZ);
        objArr[8] = Long.valueOf(this.moa);
        if (this.mob) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[9] = Integer.valueOf(i);
        objArr[10] = Integer.valueOf(this.moc);
        objArr[11] = Integer.valueOf(this.mod);
        objArr[12] = Integer.valueOf(this.moe);
        objArr[13] = Integer.valueOf(this.mof);
        objArr[14] = Integer.valueOf(this.mog);
        objArr[15] = Integer.valueOf(this.moh ? 1 : 0);
        if (!this.moi) {
            i2 = 0;
        }
        objArr[16] = Integer.valueOf(i2);
        objArr[17] = Integer.valueOf(this.moj);
        return String.format(str, objArr);
    }
}
