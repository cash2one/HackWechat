package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class b extends JceStruct {
    static byte[] zSY;
    static byte[] zSZ;
    static ArrayList<Integer> zTa = new ArrayList();
    static ArrayList<byte[]> zTb = new ArrayList();
    public int zSF = 0;
    public byte[] zSG = null;
    public String zSH = "";
    public byte[] zSI = null;
    public long zSJ = 0;
    public String zSK = "";
    public int zSL = 0;
    public String zSM = "";
    public int zSN = 0;
    public String zSO = "";
    public int zSP = 0;
    public int zSQ = 0;
    public int zSR = 0;
    public ArrayList<Integer> zSS = null;
    public int zST = 0;
    public boolean zSU = false;
    public int zSV = 0;
    public int zSW = 0;
    public ArrayList<byte[]> zSX = null;

    public final JceStruct newInit() {
        return new b();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.zSF, 0);
        if (this.zSG != null) {
            jceOutputStream.write(this.zSG, 1);
        }
        if (this.zSH != null) {
            jceOutputStream.write(this.zSH, 2);
        }
        if (this.zSI != null) {
            jceOutputStream.write(this.zSI, 3);
        }
        if (this.zSJ != 0) {
            jceOutputStream.write(this.zSJ, 4);
        }
        if (this.zSK != null) {
            jceOutputStream.write(this.zSK, 5);
        }
        if (this.zSL != 0) {
            jceOutputStream.write(this.zSL, 6);
        }
        if (this.zSM != null) {
            jceOutputStream.write(this.zSM, 7);
        }
        if (this.zSN != 0) {
            jceOutputStream.write(this.zSN, 8);
        }
        if (this.zSO != null) {
            jceOutputStream.write(this.zSO, 9);
        }
        jceOutputStream.write(this.zSP, 10);
        if (this.zSQ != 0) {
            jceOutputStream.write(this.zSQ, 11);
        }
        if (this.zSR != 0) {
            jceOutputStream.write(this.zSR, 12);
        }
        if (this.zSS != null) {
            jceOutputStream.write(this.zSS, 13);
        }
        if (this.zST != 0) {
            jceOutputStream.write(this.zST, 14);
        }
        jceOutputStream.write(this.zSU, 15);
        if (this.zSV != 0) {
            jceOutputStream.write(this.zSV, 16);
        }
        jceOutputStream.write(this.zSW, 17);
        if (this.zSX != null) {
            jceOutputStream.write(this.zSX, 18);
        }
    }

    static {
        byte[] bArr = new byte[1];
        zSY = bArr;
        bArr[0] = (byte) 0;
        bArr = new byte[1];
        zSZ = bArr;
        bArr[0] = (byte) 0;
        zTa.add(Integer.valueOf(0));
        bArr = new byte[1];
        bArr[0] = (byte) 0;
        zTb.add(bArr);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.zSF = jceInputStream.read(this.zSF, 0, true);
        this.zSG = jceInputStream.read(zSY, 1, false);
        this.zSH = jceInputStream.readString(2, false);
        this.zSI = jceInputStream.read(zSZ, 3, false);
        this.zSJ = jceInputStream.read(this.zSJ, 4, false);
        this.zSK = jceInputStream.readString(5, false);
        this.zSL = jceInputStream.read(this.zSL, 6, false);
        this.zSM = jceInputStream.readString(7, false);
        this.zSN = jceInputStream.read(this.zSN, 8, false);
        this.zSO = jceInputStream.readString(9, false);
        this.zSP = jceInputStream.read(this.zSP, 10, false);
        this.zSQ = jceInputStream.read(this.zSQ, 11, false);
        this.zSR = jceInputStream.read(this.zSR, 12, false);
        this.zSS = (ArrayList) jceInputStream.read(zTa, 13, false);
        this.zST = jceInputStream.read(this.zST, 14, false);
        this.zSU = jceInputStream.read(this.zSU, 15, false);
        this.zSV = jceInputStream.read(this.zSV, 16, false);
        this.zSW = jceInputStream.read(this.zSW, 17, false);
        this.zSX = (ArrayList) jceInputStream.read(zTb, 18, false);
    }
}
