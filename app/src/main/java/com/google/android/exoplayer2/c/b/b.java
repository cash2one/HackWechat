package com.google.android.exoplayer2.c.b;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.b.a.a;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.c;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.wcdb.FileUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class b {
    private static final int akO = t.ak("meta");
    private static final int alg = t.ak("vide");
    private static final int alh = t.ak("soun");
    private static final int ali = t.ak("text");
    private static final int alj = t.ak("sbtl");
    private static final int alk = t.ak("subt");
    private static final int all = t.ak("clcp");
    private static final int alm = t.ak("cenc");

    private static final class b {
        final int aea;
        final long duration;
        final int id;

        public b(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.aea = i2;
        }
    }

    public static e a(a aVar, a$b com_google_android_exoplayer2_c_b_a_b, long j, DrmInitData drmInitData, boolean z) {
        a cr = aVar.cr(a.ajR);
        j jVar = cr.cq(a.akf).alf;
        jVar.cR(16);
        int readInt = jVar.readInt();
        int i = readInt == alh ? 1 : readInt == alg ? 2 : (readInt == ali || readInt == alj || readInt == alk || readInt == all) ? 3 : readInt == akO ? 4 : -1;
        if (i == -1) {
            return null;
        }
        int i2;
        long j2;
        long j3;
        j jVar2 = aVar.cq(a.akb).alf;
        jVar2.cR(8);
        int cn = a.cn(jVar2.readInt());
        jVar2.cV(cn == 0 ? 8 : 16);
        int readInt2 = jVar2.readInt();
        jVar2.cV(4);
        Object obj = 1;
        int i3 = jVar2.position;
        readInt = cn == 0 ? 4 : 8;
        for (i2 = 0; i2 < readInt; i2++) {
            if (jVar2.data[i3 + i2] != (byte) -1) {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            jVar2.cV(readInt);
            j2 = -9223372036854775807L;
        } else {
            j2 = cn == 0 ? jVar2.aK() : jVar2.lJ();
            if (j2 == 0) {
                j2 = -9223372036854775807L;
            }
        }
        jVar2.cV(16);
        i2 = jVar2.readInt();
        cn = jVar2.readInt();
        jVar2.cV(4);
        i3 = jVar2.readInt();
        int readInt3 = jVar2.readInt();
        i2 = (i2 == 0 && cn == 65536 && i3 == -65536 && readInt3 == 0) ? 90 : (i2 == 0 && cn == -65536 && i3 == 65536 && readInt3 == 0) ? 270 : (i2 == -65536 && cn == 0 && i3 == 0 && readInt3 == -65536) ? 180 : 0;
        b bVar = new b(readInt2, j2, i2);
        if (j == -9223372036854775807L) {
            j2 = bVar.duration;
        } else {
            j2 = j;
        }
        jVar2 = com_google_android_exoplayer2_c_b_a_b.alf;
        jVar2.cR(8);
        jVar2.cV(a.cn(jVar2.readInt()) == 0 ? 8 : 16);
        long aK = jVar2.aK();
        if (j2 == -9223372036854775807L) {
            j3 = -9223372036854775807L;
        } else {
            j3 = t.a(j2, 1000000, aK);
        }
        a cr2 = cr.cr(a.ajS).cr(a.ajT);
        j jVar3 = cr.cq(a.ake).alf;
        jVar3.cR(8);
        readInt3 = a.cn(jVar3.readInt());
        jVar3.cV(readInt3 == 0 ? 8 : 16);
        long aK2 = jVar3.aK();
        jVar3.cV(readInt3 == 0 ? 4 : 8);
        readInt = jVar3.readUnsignedShort();
        Pair create = Pair.create(Long.valueOf(aK2), ((char) (((readInt >> 10) & 31) + 96)) + ((char) (((readInt >> 5) & 31) + 96)) + ((char) ((readInt & 31) + 96)));
        a a = a(cr2.cq(a.akg).alf, bVar.id, bVar.aea, (String) create.second, drmInitData, false);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z) {
            Pair a2 = a(aVar.cr(a.akc));
            jArr2 = (long[]) a2.second;
            jArr = (long[]) a2.first;
        }
        if (a.aeo == null) {
            return null;
        }
        return new e(bVar.id, i, ((Long) create.first).longValue(), aK, j3, a.aeo, a.alp, a.aln, a.alo, jArr, jArr2);
    }

    private static a a(j jVar, int i, int i2, String str, DrmInitData drmInitData, boolean z) {
        jVar.cR(12);
        int readInt = jVar.readInt();
        a aVar = new a(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            int i4 = jVar.position;
            int readInt2 = jVar.readInt();
            com.google.android.exoplayer2.i.a.b(readInt2 > 0, "childAtomSize should be positive");
            int readInt3 = jVar.readInt();
            int readUnsignedShort;
            int i5;
            int intValue;
            DrmInitData drmInitData2;
            String str2;
            int i6;
            String str3;
            int readInt4;
            if (readInt3 == a.ajo || readInt3 == a.ajp || readInt3 == a.akm || readInt3 == a.aky || readInt3 == a.ajq || readInt3 == a.ajr || readInt3 == a.ajs || readInt3 == a.akX || readInt3 == a.akY) {
                DrmInitData drmInitData3;
                jVar.cR((i4 + 8) + 8);
                jVar.cV(16);
                readUnsignedShort = jVar.readUnsignedShort();
                int readUnsignedShort2 = jVar.readUnsignedShort();
                float f = 1.0f;
                jVar.cV(50);
                i5 = jVar.position;
                if (readInt3 == a.akm) {
                    Pair a = a(jVar, i4, readInt2);
                    if (a != null) {
                        intValue = ((Integer) a.first).intValue();
                        if (drmInitData == null) {
                            drmInitData2 = null;
                        } else {
                            drmInitData2 = drmInitData.O(((f) a.second).amj);
                        }
                        aVar.aln[i3] = (f) a.second;
                        readInt3 = intValue;
                    } else {
                        drmInitData2 = drmInitData;
                    }
                    jVar.cR(i5);
                    drmInitData3 = drmInitData2;
                    intValue = readInt3;
                } else {
                    drmInitData3 = drmInitData;
                    intValue = readInt3;
                }
                List list = null;
                str2 = null;
                byte[] bArr = null;
                int i7 = -1;
                int i8 = i5;
                Object obj = null;
                i6 = i8;
                while (i6 - i4 < readInt2) {
                    jVar.cR(i6);
                    int i9 = jVar.position;
                    int readInt5 = jVar.readInt();
                    if (readInt5 != 0 || jVar.position - i4 != readInt2) {
                        boolean z2;
                        Object obj2;
                        if (readInt5 > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        com.google.android.exoplayer2.i.a.b(z2, "childAtomSize should be positive");
                        readInt3 = jVar.readInt();
                        if (readInt3 == a.ajU) {
                            if (str2 == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            com.google.android.exoplayer2.i.a.an(z2);
                            str2 = "video/avc";
                            jVar.cR(i9 + 8);
                            com.google.android.exoplayer2.video.a m = com.google.android.exoplayer2.video.a.m(jVar);
                            list = m.adX;
                            aVar.alo = m.alo;
                            if (obj == null) {
                                f = m.aCj;
                            }
                            obj2 = obj;
                        } else if (readInt3 == a.ajV) {
                            com.google.android.exoplayer2.i.a.an(str2 == null);
                            str2 = "video/hevc";
                            jVar.cR(i9 + 8);
                            com.google.android.exoplayer2.video.b o = com.google.android.exoplayer2.video.b.o(jVar);
                            list = o.adX;
                            aVar.alo = o.alo;
                            obj2 = obj;
                        } else if (readInt3 == a.akZ) {
                            com.google.android.exoplayer2.i.a.an(str2 == null);
                            str2 = intValue == a.akX ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                            obj2 = obj;
                        } else if (readInt3 == a.ajt) {
                            com.google.android.exoplayer2.i.a.an(str2 == null);
                            str2 = "video/3gpp";
                            obj2 = obj;
                        } else if (readInt3 == a.ajW) {
                            com.google.android.exoplayer2.i.a.an(str2 == null);
                            Pair b = b(jVar, i9);
                            str3 = (String) b.first;
                            list = Collections.singletonList(b.second);
                            str2 = str3;
                            obj2 = obj;
                        } else if (readInt3 == a.akv) {
                            jVar.cR(i9 + 8);
                            f = ((float) jVar.lI()) / ((float) jVar.lI());
                            obj2 = 1;
                        } else if (readInt3 == a.akV) {
                            readInt3 = i9 + 8;
                            while (readInt3 - i9 < readInt5) {
                                jVar.cR(readInt3);
                                readInt4 = jVar.readInt();
                                if (jVar.readInt() == a.akW) {
                                    bArr = Arrays.copyOfRange(jVar.data, readInt3, readInt4 + readInt3);
                                    obj2 = obj;
                                } else {
                                    readInt3 += readInt4;
                                }
                            }
                            bArr = null;
                            obj2 = obj;
                        } else {
                            if (readInt3 == a.akU) {
                                readInt3 = jVar.readUnsignedByte();
                                jVar.cV(3);
                                if (readInt3 == 0) {
                                    switch (jVar.readUnsignedByte()) {
                                        case 0:
                                            i7 = 0;
                                            obj2 = obj;
                                            break;
                                        case 1:
                                            i7 = 1;
                                            obj2 = obj;
                                            break;
                                        case 2:
                                            i7 = 2;
                                            obj2 = obj;
                                            break;
                                        case 3:
                                            i7 = 3;
                                            obj2 = obj;
                                            break;
                                    }
                                }
                            }
                            obj2 = obj;
                        }
                        i6 += readInt5;
                        obj = obj2;
                    } else if (str2 != null) {
                        aVar.aeo = Format.a(Integer.toString(i), str2, null, -1, -1, readUnsignedShort, readUnsignedShort2, -1.0f, list, i2, f, bArr, i7, drmInitData3);
                    }
                }
                if (str2 != null) {
                    aVar.aeo = Format.a(Integer.toString(i), str2, null, -1, -1, readUnsignedShort, readUnsignedShort2, -1.0f, list, i2, f, bArr, i7, drmInitData3);
                }
            } else if (readInt3 == a.ajv || readInt3 == a.akn || readInt3 == a.ajA || readInt3 == a.ajC || readInt3 == a.ajE || readInt3 == a.ajH || readInt3 == a.ajF || readInt3 == a.ajG || readInt3 == a.akL || readInt3 == a.akM || readInt3 == a.ajy || readInt3 == a.ajz || readInt3 == a.ajw || readInt3 == a.alb) {
                Pair a2;
                DrmInitData drmInitData4;
                jVar.cR((i4 + 8) + 8);
                jVar.cV(8);
                i6 = jVar.readUnsignedShort();
                jVar.cV(6);
                byte[] bArr2 = jVar.data;
                intValue = jVar.position;
                jVar.position = intValue + 1;
                int i10 = (bArr2[intValue] & 255) << 8;
                byte[] bArr3 = jVar.data;
                i5 = jVar.position;
                jVar.position = i5 + 1;
                readUnsignedShort = i10 | (bArr3[i5] & 255);
                jVar.position += 2;
                int i11 = jVar.position;
                if (readInt3 == a.akn) {
                    a2 = a(jVar, i4, readInt2);
                    if (a2 != null) {
                        intValue = ((Integer) a2.first).intValue();
                        drmInitData2 = drmInitData == null ? null : drmInitData.O(((f) a2.second).amj);
                        aVar.aln[i3] = (f) a2.second;
                        readInt3 = intValue;
                    } else {
                        drmInitData2 = drmInitData;
                    }
                    jVar.cR(i11);
                    drmInitData4 = drmInitData2;
                } else {
                    drmInitData4 = drmInitData;
                }
                str3 = readInt3 == a.ajA ? "audio/ac3" : readInt3 == a.ajC ? "audio/eac3" : readInt3 == a.ajE ? "audio/vnd.dts" : (readInt3 == a.ajF || readInt3 == a.ajG) ? "audio/vnd.dts.hd" : readInt3 == a.ajH ? "audio/vnd.dts.hd;profile=lbr" : readInt3 == a.akL ? "audio/3gpp" : readInt3 == a.akM ? "audio/amr-wb" : (readInt3 == a.ajy || readInt3 == a.ajz) ? "audio/raw" : readInt3 == a.ajw ? "audio/mpeg" : readInt3 == a.alb ? "audio/alac" : null;
                Object obj3 = null;
                str2 = str3;
                while (i11 - i4 < readInt2) {
                    jVar.cR(i11);
                    readInt4 = jVar.readInt();
                    com.google.android.exoplayer2.i.a.b(readInt4 > 0, "childAtomSize should be positive");
                    readInt3 = jVar.readInt();
                    if (readInt3 == a.ajW) {
                        if (readInt3 == a.ajW) {
                            readInt3 = i11;
                        } else {
                            intValue = jVar.position;
                            while (intValue - i11 < readInt4) {
                                jVar.cR(intValue);
                                i5 = jVar.readInt();
                                com.google.android.exoplayer2.i.a.b(i5 > 0, "childAtomSize should be positive");
                                if (jVar.readInt() == a.ajW) {
                                    readInt3 = intValue;
                                } else {
                                    intValue += i5;
                                }
                            }
                            readInt3 = -1;
                        }
                        if (readInt3 != -1) {
                            Pair b2 = b(jVar, readInt3);
                            str2 = (String) b2.first;
                            r6 = (byte[]) b2.second;
                            if ("audio/mp4a-latm".equals(str2)) {
                                a2 = c.h(r6);
                                readUnsignedShort = ((Integer) a2.first).intValue();
                                i6 = ((Integer) a2.second).intValue();
                            }
                        } else {
                            r6 = obj3;
                        }
                        obj3 = r6;
                    } else if (readInt3 == a.ajB) {
                        jVar.cR(i11 + 8);
                        aVar.aeo = com.google.android.exoplayer2.a.a.a(jVar, Integer.toString(i), str, drmInitData4);
                    } else if (readInt3 == a.ajD) {
                        jVar.cR(i11 + 8);
                        aVar.aeo = com.google.android.exoplayer2.a.a.b(jVar, Integer.toString(i), str, drmInitData4);
                    } else if (readInt3 == a.ajI) {
                        aVar.aeo = Format.a(Integer.toString(i), str2, -1, -1, i6, readUnsignedShort, null, drmInitData4, str);
                    } else if (readInt3 == a.alb) {
                        obj3 = new byte[readInt4];
                        jVar.cR(i11);
                        jVar.readBytes(obj3, 0, readInt4);
                    }
                    i11 += readInt4;
                }
                if (aVar.aeo == null && str2 != null) {
                    aVar.aeo = Format.a(Integer.toString(i), str2, null, -1, -1, i6, readUnsignedShort, "audio/raw".equals(str2) ? 2 : -1, obj3 == null ? null : Collections.singletonList(obj3), drmInitData4, 0, str);
                }
            } else if (readInt3 == a.akw || readInt3 == a.akH || readInt3 == a.akI || readInt3 == a.akJ || readInt3 == a.akK) {
                jVar.cR((i4 + 8) + 8);
                List list2 = null;
                long j = Long.MAX_VALUE;
                if (readInt3 == a.akw) {
                    str2 = "application/ttml+xml";
                } else if (readInt3 == a.akH) {
                    str2 = "application/x-quicktime-tx3g";
                    readInt3 = (readInt2 - 8) - 8;
                    r6 = new byte[readInt3];
                    jVar.readBytes(r6, 0, readInt3);
                    list2 = Collections.singletonList(r6);
                } else if (readInt3 == a.akI) {
                    str2 = "application/x-mp4-vtt";
                } else if (readInt3 == a.akJ) {
                    str2 = "application/ttml+xml";
                    j = 0;
                } else if (readInt3 == a.akK) {
                    str2 = "application/x-mp4-cea-608";
                    aVar.alp = 1;
                } else {
                    throw new IllegalStateException();
                }
                aVar.aeo = Format.a(Integer.toString(i), str2, null, -1, 0, str, -1, null, j, list2);
            } else if (readInt3 == a.ala) {
                aVar.aeo = Format.g(Integer.toString(i), "application/x-camera-motion");
            }
            jVar.cR(i4 + readInt2);
        }
        return aVar;
    }

    private static Pair<long[], long[]> a(a aVar) {
        if (aVar != null) {
            a$b cq = aVar.cq(a.akd);
            if (cq != null) {
                j jVar = cq.alf;
                jVar.cR(8);
                int cn = a.cn(jVar.readInt());
                int lI = jVar.lI();
                Object obj = new long[lI];
                Object obj2 = new long[lI];
                for (int i = 0; i < lI; i++) {
                    obj[i] = cn == 1 ? jVar.lJ() : jVar.aK();
                    obj2[i] = cn == 1 ? jVar.readLong() : (long) jVar.readInt();
                    byte[] bArr = jVar.data;
                    int i2 = jVar.position;
                    jVar.position = i2 + 1;
                    int i3 = (bArr[i2] & 255) << 8;
                    byte[] bArr2 = jVar.data;
                    int i4 = jVar.position;
                    jVar.position = i4 + 1;
                    if (((short) (i3 | (bArr2[i4] & 255))) != (short) 1) {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                    jVar.cV(2);
                }
                return Pair.create(obj, obj2);
            }
        }
        return Pair.create(null, null);
    }

    private static Pair<String, byte[]> b(j jVar, int i) {
        Object obj = null;
        jVar.cR((i + 8) + 4);
        jVar.cV(1);
        a(jVar);
        jVar.cV(2);
        int readUnsignedByte = jVar.readUnsignedByte();
        if ((readUnsignedByte & FileUtils.S_IWUSR) != 0) {
            jVar.cV(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            jVar.cV(jVar.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            jVar.cV(2);
        }
        jVar.cV(1);
        a(jVar);
        switch (jVar.readUnsignedByte()) {
            case 32:
                obj = "video/mp4v-es";
                break;
            case 33:
                obj = "video/avc";
                break;
            case 35:
                obj = "video/hevc";
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                obj = "audio/mp4a-latm";
                break;
            case 96:
            case 97:
                obj = "video/mpeg2";
                break;
            case 107:
                return Pair.create("audio/mpeg", null);
            case 165:
                obj = "audio/ac3";
                break;
            case JsApiLaunchMiniProgram.CTRL_INDEX /*166*/:
                obj = "audio/eac3";
                break;
            case y.CTRL_INDEX /*169*/:
            case 172:
                return Pair.create("audio/vnd.dts", null);
            case 170:
            case 171:
                return Pair.create("audio/vnd.dts.hd", null);
        }
        jVar.cV(12);
        jVar.cV(1);
        readUnsignedByte = a(jVar);
        Object obj2 = new byte[readUnsignedByte];
        jVar.readBytes(obj2, 0, readUnsignedByte);
        return Pair.create(obj, obj2);
    }

    private static Pair<Integer, f> a(j jVar, int i, int i2) {
        int i3 = jVar.position;
        while (i3 - i < i2) {
            jVar.cR(i3);
            int readInt = jVar.readInt();
            com.google.android.exoplayer2.i.a.b(readInt > 0, "childAtomSize should be positive");
            if (jVar.readInt() == a.aki) {
                int readInt2;
                int readInt3;
                Pair<Integer, f> create;
                int i4 = i3 + 8;
                int i5 = -1;
                int i6 = 0;
                String str = null;
                Integer num = null;
                while (i4 - i3 < readInt) {
                    Integer valueOf;
                    jVar.cR(i4);
                    readInt2 = jVar.readInt();
                    readInt3 = jVar.readInt();
                    if (readInt3 == a.ako) {
                        valueOf = Integer.valueOf(jVar.readInt());
                    } else if (readInt3 == a.akj) {
                        jVar.cV(4);
                        str = jVar.readString(4);
                        valueOf = num;
                    } else if (readInt3 == a.akk) {
                        valueOf = num;
                        i6 = readInt2;
                        i5 = i4;
                    } else {
                        valueOf = num;
                    }
                    i4 += readInt2;
                    num = valueOf;
                }
                if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                    Object fVar;
                    com.google.android.exoplayer2.i.a.b(num != null, "frma atom is mandatory");
                    com.google.android.exoplayer2.i.a.b(i5 != -1, "schi atom is mandatory");
                    readInt3 = i5 + 8;
                    while (readInt3 - i5 < i6) {
                        jVar.cR(readInt3);
                        readInt2 = jVar.readInt();
                        if (jVar.readInt() == a.akl) {
                            readInt3 = a.cn(jVar.readInt());
                            jVar.cV(1);
                            i4 = 0;
                            int i7 = 0;
                            if (readInt3 == 0) {
                                jVar.cV(1);
                            } else {
                                readInt3 = jVar.readUnsignedByte();
                                i4 = (readInt3 & 240) >> 4;
                                i7 = readInt3 & 15;
                            }
                            boolean z = jVar.readUnsignedByte() == 1;
                            readInt2 = jVar.readUnsignedByte();
                            byte[] bArr = new byte[16];
                            jVar.readBytes(bArr, 0, 16);
                            byte[] bArr2 = null;
                            if (z && readInt2 == 0) {
                                readInt3 = jVar.readUnsignedByte();
                                bArr2 = new byte[readInt3];
                                jVar.readBytes(bArr2, 0, readInt3);
                            }
                            fVar = new f(z, str, readInt2, bArr, i4, i7, bArr2);
                            com.google.android.exoplayer2.i.a.b(fVar == null, "tenc atom is mandatory");
                            create = Pair.create(num, fVar);
                        } else {
                            readInt3 += readInt2;
                        }
                    }
                    fVar = null;
                    if (fVar == null) {
                    }
                    com.google.android.exoplayer2.i.a.b(fVar == null, "tenc atom is mandatory");
                    create = Pair.create(num, fVar);
                } else {
                    create = null;
                }
                if (create != null) {
                    return create;
                }
            }
            i3 += readInt;
        }
        return null;
    }

    private static int a(j jVar) {
        int readUnsignedByte = jVar.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & FileUtils.S_IWUSR) == FileUtils.S_IWUSR) {
            readUnsignedByte = jVar.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }
}
