package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d extends JceStruct {
    public int cIu = 0;
    public String hqd = "";
    public String model = "";
    public String platform = "";
    public String zTn = "";
    public String zTo = "";
    public int zTp = 0;
    public String zTq = "";

    public final JceStruct newInit() {
        return new d();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.zTn != null) {
            jceOutputStream.write(this.zTn, 0);
        }
        if (this.zTo != null) {
            jceOutputStream.write(this.zTo, 1);
        }
        if (this.hqd != null) {
            jceOutputStream.write(this.hqd, 2);
        }
        if (this.model != null) {
            jceOutputStream.write(this.model, 3);
        }
        if (this.zTp != 0) {
            jceOutputStream.write(this.zTp, 4);
        }
        if (this.zTq != null) {
            jceOutputStream.write(this.zTq, 5);
        }
        if (this.platform != null) {
            jceOutputStream.write(this.platform, 6);
        }
        if (this.cIu != 0) {
            jceOutputStream.write(this.cIu, 7);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.zTn = jceInputStream.readString(0, false);
        this.zTo = jceInputStream.readString(1, false);
        this.hqd = jceInputStream.readString(2, false);
        this.model = jceInputStream.readString(3, false);
        this.zTp = jceInputStream.read(this.zTp, 4, false);
        this.zTq = jceInputStream.readString(5, false);
        this.platform = jceInputStream.readString(6, false);
        this.cIu = jceInputStream.read(this.cIu, 7, false);
    }
}
