package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.i.t;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class a {
    public static final int ajA = t.ak("ac-3");
    public static final int ajB = t.ak("dac3");
    public static final int ajC = t.ak("ec-3");
    public static final int ajD = t.ak("dec3");
    public static final int ajE = t.ak("dtsc");
    public static final int ajF = t.ak("dtsh");
    public static final int ajG = t.ak("dtsl");
    public static final int ajH = t.ak("dtse");
    public static final int ajI = t.ak("ddts");
    public static final int ajJ = t.ak("tfdt");
    public static final int ajK = t.ak("tfhd");
    public static final int ajL = t.ak("trex");
    public static final int ajM = t.ak("trun");
    public static final int ajN = t.ak("sidx");
    public static final int ajO = t.ak("moov");
    public static final int ajP = t.ak("mvhd");
    public static final int ajQ = t.ak("trak");
    public static final int ajR = t.ak("mdia");
    public static final int ajS = t.ak("minf");
    public static final int ajT = t.ak("stbl");
    public static final int ajU = t.ak("avcC");
    public static final int ajV = t.ak("hvcC");
    public static final int ajW = t.ak("esds");
    public static final int ajX = t.ak("moof");
    public static final int ajY = t.ak("traf");
    public static final int ajZ = t.ak("mvex");
    public static final int ajn = t.ak("ftyp");
    public static final int ajo = t.ak("avc1");
    public static final int ajp = t.ak("avc3");
    public static final int ajq = t.ak("hvc1");
    public static final int ajr = t.ak("hev1");
    public static final int ajs = t.ak("s263");
    public static final int ajt = t.ak("d263");
    public static final int aju = t.ak("mdat");
    public static final int ajv = t.ak("mp4a");
    public static final int ajw = t.ak(".mp3");
    public static final int ajx = t.ak("wave");
    public static final int ajy = t.ak("lpcm");
    public static final int ajz = t.ak("sowt");
    public static final int akA = t.ak("stss");
    public static final int akB = t.ak("ctts");
    public static final int akC = t.ak("stsc");
    public static final int akD = t.ak("stsz");
    public static final int akE = t.ak("stz2");
    public static final int akF = t.ak("stco");
    public static final int akG = t.ak("co64");
    public static final int akH = t.ak("tx3g");
    public static final int akI = t.ak("wvtt");
    public static final int akJ = t.ak("stpp");
    public static final int akK = t.ak("c608");
    public static final int akL = t.ak("samr");
    public static final int akM = t.ak("sawb");
    public static final int akN = t.ak("udta");
    public static final int akO = t.ak("meta");
    public static final int akP = t.ak("ilst");
    public static final int akQ = t.ak("mean");
    public static final int akR = t.ak("name");
    public static final int akS = t.ak(SlookAirButtonFrequentContactAdapter.DATA);
    public static final int akT = t.ak("emsg");
    public static final int akU = t.ak("st3d");
    public static final int akV = t.ak("sv3d");
    public static final int akW = t.ak("proj");
    public static final int akX = t.ak("vp08");
    public static final int akY = t.ak("vp09");
    public static final int akZ = t.ak("vpcC");
    public static final int aka = t.ak("mehd");
    public static final int akb = t.ak("tkhd");
    public static final int akc = t.ak("edts");
    public static final int akd = t.ak("elst");
    public static final int ake = t.ak("mdhd");
    public static final int akf = t.ak("hdlr");
    public static final int akg = t.ak("stsd");
    public static final int akh = t.ak("pssh");
    public static final int aki = t.ak("sinf");
    public static final int akj = t.ak("schm");
    public static final int akk = t.ak("schi");
    public static final int akl = t.ak("tenc");
    public static final int akm = t.ak("encv");
    public static final int akn = t.ak("enca");
    public static final int ako = t.ak("frma");
    public static final int akp = t.ak("saiz");
    public static final int akq = t.ak("saio");
    public static final int akr = t.ak("sbgp");
    public static final int aks = t.ak("sgpd");
    public static final int akt = t.ak("uuid");
    public static final int aku = t.ak("senc");
    public static final int akv = t.ak("pasp");
    public static final int akw = t.ak("TTML");
    public static final int akx = t.ak("vmhd");
    public static final int aky = t.ak("mp4v");
    public static final int akz = t.ak("stts");
    public static final int ala = t.ak("camm");
    public static final int alb = t.ak("alac");
    public final int type;

    static final class a extends a {
        public final long alc;
        public final List<b> ald = new ArrayList();
        public final List<a> ale = new ArrayList();

        public a(int i, long j) {
            super(i);
            this.alc = j;
        }

        public final b cq(int i) {
            int size = this.ald.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = (b) this.ald.get(i2);
                if (bVar.type == i) {
                    return bVar;
                }
            }
            return null;
        }

        public final a cr(int i) {
            int size = this.ale.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) this.ale.get(i2);
                if (aVar.type == i) {
                    return aVar;
                }
            }
            return null;
        }

        public final String toString() {
            return a.cp(this.type) + " leaves: " + Arrays.toString(this.ald.toArray()) + " containers: " + Arrays.toString(this.ale.toArray());
        }
    }

    public a(int i) {
        this.type = i;
    }

    public String toString() {
        return cp(this.type);
    }

    public static int cn(int i) {
        return (i >> 24) & 255;
    }

    public static int co(int i) {
        return 16777215 & i;
    }

    public static String cp(int i) {
        return ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }
}
