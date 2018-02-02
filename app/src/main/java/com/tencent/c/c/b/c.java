package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c extends JceStruct {
    static byte[] zTl;
    static byte[] zTm;
    public int hui = 0;
    public int requestType = 0;
    public int zSt = 0;
    public int zTc = 0;
    public int zTd = 0;
    public int zTe = 0;
    public byte[] zTf = null;
    public int zTg = 0;
    public long zTh = 0;
    public byte[] zTi = null;
    public int zTj = 0;
    public int zTk = 0;

    public final JceStruct newInit() {
        return new c();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.zTc != 0) {
            jceOutputStream.write(this.zTc, 0);
        }
        jceOutputStream.write(this.zSt, 1);
        jceOutputStream.write(this.requestType, 2);
        if (this.zTd != 0) {
            jceOutputStream.write(this.zTd, 3);
        }
        if (this.zTe != 0) {
            jceOutputStream.write(this.zTe, 4);
        }
        if (this.zTf != null) {
            jceOutputStream.write(this.zTf, 5);
        }
        if (this.zTg != 0) {
            jceOutputStream.write(this.zTg, 6);
        }
        if (this.hui != 0) {
            jceOutputStream.write(this.hui, 7);
        }
        if (this.zTh != 0) {
            jceOutputStream.write(this.zTh, 8);
        }
        if (this.zTi != null) {
            jceOutputStream.write(this.zTi, 9);
        }
        if (this.zTj != 0) {
            jceOutputStream.write(this.zTj, 10);
        }
        if (this.zTk != 0) {
            jceOutputStream.write(this.zTk, 11);
        }
    }

    static {
        byte[] bArr = new byte[1];
        zTl = bArr;
        bArr[0] = (byte) 0;
        bArr = new byte[1];
        zTm = bArr;
        bArr[0] = (byte) 0;
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.zTc = jceInputStream.read(this.zTc, 0, false);
        this.zSt = jceInputStream.read(this.zSt, 1, false);
        this.requestType = jceInputStream.read(this.requestType, 2, false);
        this.zTd = jceInputStream.read(this.zTd, 3, false);
        this.zTe = jceInputStream.read(this.zTe, 4, false);
        this.zTf = jceInputStream.read(zTl, 5, false);
        this.zTg = jceInputStream.read(this.zTg, 6, false);
        this.hui = jceInputStream.read(this.hui, 7, false);
        this.zTh = jceInputStream.read(this.zTh, 8, false);
        this.zTi = jceInputStream.read(zTm, 9, false);
        this.zTj = jceInputStream.read(this.zTj, 10, false);
        this.zTk = jceInputStream.read(this.zTk, 11, false);
    }
}
