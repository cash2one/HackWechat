package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.a;
import com.google.android.exoplayer2.o;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.EOFException;

public final class b implements d {
    public static final g aiT = new 1();
    private static final int aiU = t.ak("Xing");
    private static final int aiV = t.ak("Info");
    private static final int aiW = t.ak("VBRI");
    private Metadata adT;
    private final long aiX;
    private final j aiY;
    private final i aiZ;
    private final h aja;
    private f ajb;
    private k ajc;
    private int ajd;
    private a aje;
    private long ajf;
    private long ajg;
    private int ajh;
    private final int flags;

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this(0, -9223372036854775807L);
    }

    public b(int i, long j) {
        this.flags = 0;
        this.aiX = j;
        this.aiY = new j(10);
        this.aiZ = new i();
        this.aja = new h();
        this.ajf = -9223372036854775807L;
    }

    public final void a(f fVar) {
        this.ajb = fVar;
        this.ajc = this.ajb.ck(0);
        this.ajb.ju();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(e eVar) {
        int i;
        int lH;
        int cl;
        int i2;
        int i3;
        if (this.ajd == 0) {
            i = 0;
            try {
                eVar.js();
                if (eVar.getPosition() == 0) {
                    int i4 = 0;
                    while (true) {
                        eVar.b(this.aiY.data, 0, 10);
                        this.aiY.cR(0);
                        if (this.aiY.lG() != a.amF) {
                            break;
                        }
                        this.aiY.cV(3);
                        lH = this.aiY.lH();
                        int i5 = lH + 10;
                        if (this.adT == null) {
                            Object obj = new byte[i5];
                            System.arraycopy(this.aiY.data, 0, obj, 0, 10);
                            eVar.b(obj, 10, lH);
                            this.adT = new a((this.flags & 2) != 0 ? h.aiG : null).b(obj, i5);
                            if (this.adT != null) {
                                h hVar = this.aja;
                                Metadata metadata = this.adT;
                                for (Entry entry : metadata.aqo) {
                                    if (entry instanceof CommentFrame) {
                                        CommentFrame commentFrame = (CommentFrame) entry;
                                        if (hVar.h(commentFrame.description, commentFrame.text)) {
                                            break;
                                        }
                                    }
                                }
                            }
                        } else {
                            eVar.cg(lH);
                        }
                        i4 += i5;
                    }
                    eVar.js();
                    eVar.cg(i4);
                    eVar.cf((int) eVar.jt());
                }
                i2 = 0;
                i3 = 0;
                while (true) {
                    if (!eVar.b(this.aiY.data, 0, 4, i > 0)) {
                        break;
                    }
                    this.aiY.cR(0);
                    lH = this.aiY.readInt();
                    if (i2 == 0 || e(lH, (long) i2)) {
                        cl = i.cl(lH);
                        if (cl != -1) {
                            i++;
                            if (i != 1) {
                                if (i == 4) {
                                    break;
                                }
                                lH = i2;
                            } else {
                                i.a(lH, this.aiZ);
                            }
                            eVar.cg(cl - 4);
                            i2 = lH;
                        }
                    }
                    lH = i3 + 1;
                    if (i3 == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                        throw new o("Searched too many bytes.");
                    }
                    i2 = 0;
                    eVar.cf(1);
                    i = 0;
                    i3 = lH;
                }
                eVar.js();
                this.ajd = i2;
            } catch (EOFException e) {
                return -1;
            }
        }
        if (this.aje == null) {
            int i6;
            i iVar;
            long position;
            long length;
            long j;
            int readInt;
            long a;
            Object dVar;
            long lI;
            long[] jArr;
            a b;
            h hVar2;
            Object obj2;
            j jVar = new j(this.aiZ.afs);
            eVar.b(jVar.data, 0, this.aiZ.afs);
            int i7 = (this.aiZ.version & 1) != 0 ? this.aiZ.channels != 1 ? 36 : 21 : this.aiZ.channels != 1 ? 21 : 13;
            if (jVar.asN >= i7 + 4) {
                jVar.cR(i7);
                lH = jVar.readInt();
                if (lH == aiU || lH == aiV) {
                    i6 = lH;
                    if (i6 != aiU || i6 == aiV) {
                        iVar = this.aiZ;
                        position = eVar.getPosition();
                        length = eVar.getLength();
                        i3 = iVar.aiP;
                        cl = iVar.sampleRate;
                        j = position + ((long) iVar.afs);
                        readInt = jVar.readInt();
                        if ((readInt & 1) == 1) {
                            lH = jVar.lI();
                            if (lH != 0) {
                                a = t.a((long) lH, ((long) i3) * 1000000, (long) cl);
                                if ((readInt & 6) != 6) {
                                    dVar = new d(j, a, length);
                                } else {
                                    lI = (long) jVar.lI();
                                    jVar.cV(1);
                                    jArr = new long[99];
                                    for (lH = 0; lH < 99; lH++) {
                                        jArr[lH] = (long) jVar.readUnsignedByte();
                                    }
                                    dVar = new d(j, a, length, jArr, lI, iVar.afs);
                                }
                                if (b != null) {
                                    hVar2 = this.aja;
                                    obj2 = (hVar2.aeh != -1 || hVar2.aei == -1) ? null : 1;
                                    if (obj2 == null) {
                                        eVar.js();
                                        eVar.cg(i7 + com.tencent.mm.plugin.appbrand.jsapi.map.j.CTRL_INDEX);
                                        eVar.b(this.aiY.data, 0, 3);
                                        this.aiY.cR(0);
                                        hVar2 = this.aja;
                                        i3 = this.aiY.lG();
                                        i = i3 >> 12;
                                        i3 &= 4095;
                                        if (i > 0 || i3 > 0) {
                                            hVar2.aeh = i;
                                            hVar2.aei = i3;
                                        }
                                    }
                                }
                                eVar.cf(this.aiZ.afs);
                                if (!(b == null || b.jr() || i6 != aiV)) {
                                    b = b(eVar);
                                }
                            }
                        }
                        b = null;
                        if (b != null) {
                            hVar2 = this.aja;
                            if (hVar2.aeh != -1) {
                            }
                            if (obj2 == null) {
                                eVar.js();
                                eVar.cg(i7 + com.tencent.mm.plugin.appbrand.jsapi.map.j.CTRL_INDEX);
                                eVar.b(this.aiY.data, 0, 3);
                                this.aiY.cR(0);
                                hVar2 = this.aja;
                                i3 = this.aiY.lG();
                                i = i3 >> 12;
                                i3 &= 4095;
                                hVar2.aeh = i;
                                hVar2.aei = i3;
                            }
                        }
                        eVar.cf(this.aiZ.afs);
                        b = b(eVar);
                    } else if (i6 == aiW) {
                        i iVar2 = this.aiZ;
                        long position2 = eVar.getPosition();
                        long length2 = eVar.getLength();
                        jVar.cV(10);
                        lH = jVar.readInt();
                        if (lH <= 0) {
                            b = null;
                        } else {
                            cl = iVar2.sampleRate;
                            long a2 = t.a((long) lH, ((long) (cl >= 32000 ? 1152 : 576)) * 1000000, (long) cl);
                            int readUnsignedShort = jVar.readUnsignedShort();
                            int readUnsignedShort2 = jVar.readUnsignedShort();
                            int readUnsignedShort3 = jVar.readUnsignedShort();
                            jVar.cV(2);
                            long j2 = position2 + ((long) iVar2.afs);
                            long[] jArr2 = new long[(readUnsignedShort + 1)];
                            jArr = new long[(readUnsignedShort + 1)];
                            jArr2[0] = 0;
                            jArr[0] = j2;
                            lH = 1;
                            while (lH < jArr2.length) {
                                switch (readUnsignedShort3) {
                                    case 1:
                                        i2 = jVar.readUnsignedByte();
                                        break;
                                    case 2:
                                        i2 = jVar.readUnsignedShort();
                                        break;
                                    case 3:
                                        i2 = jVar.lG();
                                        break;
                                    case 4:
                                        i2 = jVar.lI();
                                        break;
                                    default:
                                        b = null;
                                        break;
                                }
                            }
                            b = new c(jArr2, jArr, a2);
                        }
                        eVar.cf(this.aiZ.afs);
                    } else {
                        b = null;
                        eVar.js();
                    }
                    this.aje = b;
                    if (this.aje == null || !(this.aje.jr() || (this.flags & 1) == 0)) {
                        this.aje = b(eVar);
                    }
                    this.ajc.f(Format.a(null, this.aiZ.mimeType, null, -1, Downloads.RECV_BUFFER_SIZE, this.aiZ.channels, this.aiZ.sampleRate, -1, this.aja.aeh, this.aja.aei, null, null, 0, null, (this.flags & 2) != 0 ? null : this.adT));
                }
            }
            if (jVar.asN >= 40) {
                jVar.cR(36);
                if (jVar.readInt() == aiW) {
                    i6 = aiW;
                    if (i6 != aiU) {
                    }
                    iVar = this.aiZ;
                    position = eVar.getPosition();
                    length = eVar.getLength();
                    i3 = iVar.aiP;
                    cl = iVar.sampleRate;
                    j = position + ((long) iVar.afs);
                    readInt = jVar.readInt();
                    if ((readInt & 1) == 1) {
                        lH = jVar.lI();
                        if (lH != 0) {
                            a = t.a((long) lH, ((long) i3) * 1000000, (long) cl);
                            if ((readInt & 6) != 6) {
                                lI = (long) jVar.lI();
                                jVar.cV(1);
                                jArr = new long[99];
                                for (lH = 0; lH < 99; lH++) {
                                    jArr[lH] = (long) jVar.readUnsignedByte();
                                }
                                dVar = new d(j, a, length, jArr, lI, iVar.afs);
                            } else {
                                dVar = new d(j, a, length);
                            }
                            if (b != null) {
                                hVar2 = this.aja;
                                if (hVar2.aeh != -1) {
                                }
                                if (obj2 == null) {
                                    eVar.js();
                                    eVar.cg(i7 + com.tencent.mm.plugin.appbrand.jsapi.map.j.CTRL_INDEX);
                                    eVar.b(this.aiY.data, 0, 3);
                                    this.aiY.cR(0);
                                    hVar2 = this.aja;
                                    i3 = this.aiY.lG();
                                    i = i3 >> 12;
                                    i3 &= 4095;
                                    hVar2.aeh = i;
                                    hVar2.aei = i3;
                                }
                            }
                            eVar.cf(this.aiZ.afs);
                            b = b(eVar);
                            this.aje = b;
                            this.aje = b(eVar);
                            if ((this.flags & 2) != 0) {
                            }
                            this.ajc.f(Format.a(null, this.aiZ.mimeType, null, -1, Downloads.RECV_BUFFER_SIZE, this.aiZ.channels, this.aiZ.sampleRate, -1, this.aja.aeh, this.aja.aei, null, null, 0, null, (this.flags & 2) != 0 ? null : this.adT));
                        }
                    }
                    b = null;
                    if (b != null) {
                        hVar2 = this.aja;
                        if (hVar2.aeh != -1) {
                        }
                        if (obj2 == null) {
                            eVar.js();
                            eVar.cg(i7 + com.tencent.mm.plugin.appbrand.jsapi.map.j.CTRL_INDEX);
                            eVar.b(this.aiY.data, 0, 3);
                            this.aiY.cR(0);
                            hVar2 = this.aja;
                            i3 = this.aiY.lG();
                            i = i3 >> 12;
                            i3 &= 4095;
                            hVar2.aeh = i;
                            hVar2.aei = i3;
                        }
                    }
                    eVar.cf(this.aiZ.afs);
                    b = b(eVar);
                    this.aje = b;
                    this.aje = b(eVar);
                    if ((this.flags & 2) != 0) {
                    }
                    this.ajc.f(Format.a(null, this.aiZ.mimeType, null, -1, Downloads.RECV_BUFFER_SIZE, this.aiZ.channels, this.aiZ.sampleRate, -1, this.aja.aeh, this.aja.aei, null, null, 0, null, (this.flags & 2) != 0 ? null : this.adT));
                }
            }
            i6 = 0;
            if (i6 != aiU) {
            }
            iVar = this.aiZ;
            position = eVar.getPosition();
            length = eVar.getLength();
            i3 = iVar.aiP;
            cl = iVar.sampleRate;
            j = position + ((long) iVar.afs);
            readInt = jVar.readInt();
            if ((readInt & 1) == 1) {
                lH = jVar.lI();
                if (lH != 0) {
                    a = t.a((long) lH, ((long) i3) * 1000000, (long) cl);
                    if ((readInt & 6) != 6) {
                        dVar = new d(j, a, length);
                    } else {
                        lI = (long) jVar.lI();
                        jVar.cV(1);
                        jArr = new long[99];
                        for (lH = 0; lH < 99; lH++) {
                            jArr[lH] = (long) jVar.readUnsignedByte();
                        }
                        dVar = new d(j, a, length, jArr, lI, iVar.afs);
                    }
                    if (b != null) {
                        hVar2 = this.aja;
                        if (hVar2.aeh != -1) {
                        }
                        if (obj2 == null) {
                            eVar.js();
                            eVar.cg(i7 + com.tencent.mm.plugin.appbrand.jsapi.map.j.CTRL_INDEX);
                            eVar.b(this.aiY.data, 0, 3);
                            this.aiY.cR(0);
                            hVar2 = this.aja;
                            i3 = this.aiY.lG();
                            i = i3 >> 12;
                            i3 &= 4095;
                            hVar2.aeh = i;
                            hVar2.aei = i3;
                        }
                    }
                    eVar.cf(this.aiZ.afs);
                    b = b(eVar);
                    this.aje = b;
                    this.aje = b(eVar);
                    if ((this.flags & 2) != 0) {
                    }
                    this.ajc.f(Format.a(null, this.aiZ.mimeType, null, -1, Downloads.RECV_BUFFER_SIZE, this.aiZ.channels, this.aiZ.sampleRate, -1, this.aja.aeh, this.aja.aei, null, null, 0, null, (this.flags & 2) != 0 ? null : this.adT));
                }
            }
            b = null;
            if (b != null) {
                hVar2 = this.aja;
                if (hVar2.aeh != -1) {
                }
                if (obj2 == null) {
                    eVar.js();
                    eVar.cg(i7 + com.tencent.mm.plugin.appbrand.jsapi.map.j.CTRL_INDEX);
                    eVar.b(this.aiY.data, 0, 3);
                    this.aiY.cR(0);
                    hVar2 = this.aja;
                    i3 = this.aiY.lG();
                    i = i3 >> 12;
                    i3 &= 4095;
                    hVar2.aeh = i;
                    hVar2.aei = i3;
                }
            }
            eVar.cf(this.aiZ.afs);
            b = b(eVar);
            this.aje = b;
            this.aje = b(eVar);
            if ((this.flags & 2) != 0) {
            }
            this.ajc.f(Format.a(null, this.aiZ.mimeType, null, -1, Downloads.RECV_BUFFER_SIZE, this.aiZ.channels, this.aiZ.sampleRate, -1, this.aja.aeh, this.aja.aei, null, null, 0, null, (this.flags & 2) != 0 ? null : this.adT));
        }
        if (this.ajh == 0) {
            eVar.js();
            if (!eVar.b(this.aiY.data, 0, 4, true)) {
                return -1;
            }
            this.aiY.cR(0);
            lH = this.aiY.readInt();
            if (!e(lH, (long) this.ajd) || i.cl(lH) == -1) {
                eVar.cf(1);
                this.ajd = 0;
                return 0;
            }
            i.a(lH, this.aiZ);
            if (this.ajf == -9223372036854775807L) {
                this.ajf = this.aje.y(eVar.getPosition());
                if (this.aiX != -9223372036854775807L) {
                    this.ajf = (this.aiX - this.aje.y(0)) + this.ajf;
                }
            }
            this.ajh = this.aiZ.afs;
        }
        lH = this.ajc.a(eVar, this.ajh, true);
        if (lH == -1) {
            return -1;
        }
        this.ajh -= lH;
        if (this.ajh > 0) {
            return 0;
        }
        this.ajc.a(((this.ajg * 1000000) / ((long) this.aiZ.sampleRate)) + this.ajf, 1, this.aiZ.afs, 0, null);
        this.ajg += (long) this.aiZ.aiP;
        this.ajh = 0;
        return 0;
    }

    private a b(e eVar) {
        eVar.b(this.aiY.data, 0, 4);
        this.aiY.cR(0);
        i.a(this.aiY.readInt(), this.aiZ);
        return new a(eVar.getPosition(), this.aiZ.bitrate, eVar.getLength());
    }

    private static boolean e(int i, long j) {
        return ((long) (-128000 & i)) == (-128000 & j);
    }
}
