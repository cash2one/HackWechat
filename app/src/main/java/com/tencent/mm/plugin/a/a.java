package com.tencent.mm.plugin.a;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;

public class a {
    public static final int ajA = c.ak("ac-3");
    public static final int ajB = c.ak("dac3");
    public static final int ajC = c.ak("ec-3");
    public static final int ajD = c.ak("dec3");
    public static final int ajE = c.ak("dtsc");
    public static final int ajF = c.ak("dtsh");
    public static final int ajG = c.ak("dtsl");
    public static final int ajH = c.ak("dtse");
    public static final int ajI = c.ak("ddts");
    public static final int ajJ = c.ak("tfdt");
    public static final int ajK = c.ak("tfhd");
    public static final int ajL = c.ak("trex");
    public static final int ajM = c.ak("trun");
    public static final int ajN = c.ak("sidx");
    public static final int ajO = c.ak("moov");
    public static final int ajP = c.ak("mvhd");
    public static final int ajQ = c.ak("trak");
    public static final int ajR = c.ak("mdia");
    public static final int ajS = c.ak("minf");
    public static final int ajT = c.ak("stbl");
    public static final int ajU = c.ak("avcC");
    public static final int ajV = c.ak("hvcC");
    public static final int ajW = c.ak("esds");
    public static final int ajX = c.ak("moof");
    public static final int ajY = c.ak("traf");
    public static final int ajZ = c.ak("mvex");
    public static final int ajn = c.ak("ftyp");
    public static final int ajo = c.ak("avc1");
    public static final int ajp = c.ak("avc3");
    public static final int ajq = c.ak("hvc1");
    public static final int ajr = c.ak("hev1");
    public static final int ajs = c.ak("s263");
    public static final int ajt = c.ak("d263");
    public static final int aju = c.ak("mdat");
    public static final int ajv = c.ak("mp4a");
    public static final int ajx = c.ak("wave");
    public static final int akA = c.ak("stss");
    public static final int akB = c.ak("ctts");
    public static final int akC = c.ak("stsc");
    public static final int akD = c.ak("stsz");
    public static final int akF = c.ak("stco");
    public static final int akG = c.ak("co64");
    public static final int akH = c.ak("tx3g");
    public static final int akI = c.ak("wvtt");
    public static final int akJ = c.ak("stpp");
    public static final int akL = c.ak("samr");
    public static final int akM = c.ak("sawb");
    public static final int akN = c.ak("udta");
    public static final int akO = c.ak("meta");
    public static final int akP = c.ak("ilst");
    public static final int akQ = c.ak("mean");
    public static final int akR = c.ak("name");
    public static final int akS = c.ak(SlookAirButtonFrequentContactAdapter.DATA);
    public static final int akb = c.ak("tkhd");
    public static final int akc = c.ak("edts");
    public static final int akd = c.ak("elst");
    public static final int ake = c.ak("mdhd");
    public static final int akf = c.ak("hdlr");
    public static final int akg = c.ak("stsd");
    public static final int akh = c.ak("pssh");
    public static final int aki = c.ak("sinf");
    public static final int akj = c.ak("schm");
    public static final int akk = c.ak("schi");
    public static final int akl = c.ak("tenc");
    public static final int akm = c.ak("encv");
    public static final int akn = c.ak("enca");
    public static final int ako = c.ak("frma");
    public static final int akp = c.ak("saiz");
    public static final int akq = c.ak("saio");
    public static final int akt = c.ak("uuid");
    public static final int aku = c.ak("senc");
    public static final int akv = c.ak("pasp");
    public static final int akw = c.ak("TTML");
    public static final int akx = c.ak("vmhd");
    public static final int aky = c.ak("mp4v");
    public static final int akz = c.ak("stts");
    public static final int iey = c.ak("----");
    private long ieA;
    public long ieB;
    private int iez;
    private int type;

    public a(int i, long j, int i2, long j2) {
        this.iez = i;
        this.ieB = j;
        this.type = i2;
        this.ieA = j2;
    }

    public final boolean Wt() {
        return this.type == ajO;
    }

    public final boolean Wu() {
        return this.iez == 0;
    }

    public final long Wv() {
        return this.ieB + getSize();
    }

    public final long getSize() {
        if (this.ieA > 0) {
            return this.ieA;
        }
        return (long) this.iez;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("Atom{atomSize=").append(this.iez).append(", atomLargeSize=").append(this.ieA).append(", type=");
        int i = this.type;
        return append.append(new String(new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)})).append(", beginPos=").append(this.ieB).append('}').toString();
    }
}
