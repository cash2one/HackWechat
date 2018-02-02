package com.tencent.c.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c extends JceStruct {
    static b zSy = new b();
    public String guid = "";
    public String imei = "";
    public String imsi = "";
    public String ip = "";
    public String kKe = "";
    public double latitude = 0.0d;
    public double longitude = 0.0d;
    public String ned = "";
    public String reb = "";
    public String zSh = "";
    public String zSi = "";
    public String zSj = "";
    public int zSk = 0;
    public int zSl = 0;
    public b zSm = null;
    public int zSn = 0;
    public int zSo = 0;
    public int zSp = 0;
    public int zSq = 0;
    public short zSr = (short) 0;
    public String zSs = "";
    public int zSt = 0;
    public String zSu = "";
    public String zSv = "";
    public String zSw = "";
    public String zSx = "";
    public String zdc = "";

    public final JceStruct newInit() {
        return new c();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.imei, 0);
        if (this.zdc != null) {
            jceOutputStream.write(this.zdc, 1);
        }
        if (this.kKe != null) {
            jceOutputStream.write(this.kKe, 2);
        }
        if (this.ip != null) {
            jceOutputStream.write(this.ip, 3);
        }
        if (this.zSh != null) {
            jceOutputStream.write(this.zSh, 4);
        }
        if (this.zSi != null) {
            jceOutputStream.write(this.zSi, 5);
        }
        if (this.zSj != null) {
            jceOutputStream.write(this.zSj, 6);
        }
        if (this.zSk != 0) {
            jceOutputStream.write(this.zSk, 7);
        }
        if (this.zSl != 0) {
            jceOutputStream.write(this.zSl, 8);
        }
        if (this.zSm != null) {
            jceOutputStream.write(this.zSm, 9);
        }
        if (this.guid != null) {
            jceOutputStream.write(this.guid, 10);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 11);
        }
        if (this.zSn != 0) {
            jceOutputStream.write(this.zSn, 12);
        }
        if (this.zSo != 0) {
            jceOutputStream.write(this.zSo, 13);
        }
        if (this.zSp != 0) {
            jceOutputStream.write(this.zSp, 14);
        }
        if (this.zSq != 0) {
            jceOutputStream.write(this.zSq, 15);
        }
        if (this.ned != null) {
            jceOutputStream.write(this.ned, 16);
        }
        if (this.zSr != (short) 0) {
            jceOutputStream.write(this.zSr, 17);
        }
        if (this.longitude != 0.0d) {
            jceOutputStream.write(this.longitude, 18);
        }
        if (this.latitude != 0.0d) {
            jceOutputStream.write(this.latitude, 19);
        }
        if (this.zSs != null) {
            jceOutputStream.write(this.zSs, 20);
        }
        if (this.zSt != 0) {
            jceOutputStream.write(this.zSt, 21);
        }
        if (this.zSu != null) {
            jceOutputStream.write(this.zSu, 22);
        }
        if (this.zSv != null) {
            jceOutputStream.write(this.zSv, 23);
        }
        if (this.reb != null) {
            jceOutputStream.write(this.reb, 24);
        }
        if (this.zSw != null) {
            jceOutputStream.write(this.zSw, 25);
        }
        if (this.zSx != null) {
            jceOutputStream.write(this.zSx, 26);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.imei = jceInputStream.readString(0, true);
        this.zdc = jceInputStream.readString(1, false);
        this.kKe = jceInputStream.readString(2, false);
        this.ip = jceInputStream.readString(3, false);
        this.zSh = jceInputStream.readString(4, false);
        this.zSi = jceInputStream.readString(5, false);
        this.zSj = jceInputStream.readString(6, false);
        this.zSk = jceInputStream.read(this.zSk, 7, false);
        this.zSl = jceInputStream.read(this.zSl, 8, false);
        this.zSm = (b) jceInputStream.read(zSy, 9, false);
        this.guid = jceInputStream.readString(10, false);
        this.imsi = jceInputStream.readString(11, false);
        this.zSn = jceInputStream.read(this.zSn, 12, false);
        this.zSo = jceInputStream.read(this.zSo, 13, false);
        this.zSp = jceInputStream.read(this.zSp, 14, false);
        this.zSq = jceInputStream.read(this.zSq, 15, false);
        this.ned = jceInputStream.readString(16, false);
        this.zSr = jceInputStream.read(this.zSr, 17, false);
        this.longitude = jceInputStream.read(this.longitude, 18, false);
        this.latitude = jceInputStream.read(this.latitude, 19, false);
        this.zSs = jceInputStream.readString(20, false);
        this.zSt = jceInputStream.read(this.zSt, 21, false);
        this.zSu = jceInputStream.readString(22, false);
        this.zSv = jceInputStream.readString(23, false);
        this.reb = jceInputStream.readString(24, false);
        this.zSw = jceInputStream.readString(25, false);
        this.zSx = jceInputStream.readString(26, false);
    }
}
