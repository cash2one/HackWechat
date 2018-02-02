package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class a extends JceStruct {
    static ArrayList<e> zUv;
    public int fCR = 0;
    public String ffq = "";
    public int hLh = 0;
    public String hqd = "";
    public String imei = "";
    public String imsi = "";
    public String model = "";
    public int requestType = 0;
    public int sdkVer = 0;
    public int zPM = 0;
    public String zSh = "";
    public long zUp = 0;
    public String zUq = "";
    public ArrayList<e> zUr = null;
    public String zUs = "";
    public String zUt = "";
    public int zUu = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.zUp, 0);
        jceOutputStream.write(this.zUq, 1);
        jceOutputStream.write(this.zUr, 2);
        jceOutputStream.write(this.hLh, 3);
        jceOutputStream.write(this.zSh, 4);
        jceOutputStream.write(this.fCR, 5);
        jceOutputStream.write(this.requestType, 6);
        jceOutputStream.write(this.zUs, 7);
        if (this.imei != null) {
            jceOutputStream.write(this.imei, 8);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 9);
        }
        if (this.hqd != null) {
            jceOutputStream.write(this.hqd, 10);
        }
        if (this.model != null) {
            jceOutputStream.write(this.model, 11);
        }
        if (this.zUt != null) {
            jceOutputStream.write(this.zUt, 12);
        }
        if (this.zUu != 0) {
            jceOutputStream.write(this.zUu, 13);
        }
        if (this.sdkVer != 0) {
            jceOutputStream.write(this.sdkVer, 14);
        }
        if (this.ffq != null) {
            jceOutputStream.write(this.ffq, 15);
        }
        jceOutputStream.write(this.zPM, 16);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.zUp = jceInputStream.read(this.zUp, 0, true);
        this.zUq = jceInputStream.readString(1, true);
        if (zUv == null) {
            zUv = new ArrayList();
            zUv.add(new e());
        }
        this.zUr = (ArrayList) jceInputStream.read(zUv, 2, true);
        this.hLh = jceInputStream.read(this.hLh, 3, true);
        this.zSh = jceInputStream.readString(4, true);
        this.fCR = jceInputStream.read(this.fCR, 5, true);
        this.requestType = jceInputStream.read(this.requestType, 6, true);
        this.zUs = jceInputStream.readString(7, true);
        this.imei = jceInputStream.readString(8, false);
        this.imsi = jceInputStream.readString(9, false);
        this.hqd = jceInputStream.readString(10, false);
        this.model = jceInputStream.readString(11, false);
        this.zUt = jceInputStream.readString(12, false);
        this.zUu = jceInputStream.read(this.zUu, 13, false);
        this.sdkVer = jceInputStream.read(this.sdkVer, 14, false);
        this.ffq = jceInputStream.readString(15, false);
        this.zPM = jceInputStream.read(this.zPM, 16, false);
    }
}
