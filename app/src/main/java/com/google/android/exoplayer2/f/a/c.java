package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xwalk.core.R$styleable;

public final class c extends d {
    private final i awN = new i();
    private final int awO;
    private final a[] awP;
    private a awQ;
    private b awR;
    private int awS;
    private final j awt = new j();
    private List<a> awy;
    private List<a> awz;

    private static final class b {
        public final int axr;
        public final int axs;
        public final byte[] axt;
        int currentIndex = 0;

        public b(int i, int i2) {
            this.axr = i;
            this.axs = i2;
            this.axt = new byte[((i2 * 2) - 1)];
        }
    }

    public final /* bridge */ /* synthetic */ void K(long j) {
        super.K(j);
    }

    public final /* bridge */ /* synthetic */ void b(h hVar) {
        super.b(hVar);
    }

    public final /* bridge */ /* synthetic */ com.google.android.exoplayer2.f.i kS() {
        return super.kS();
    }

    public final /* bridge */ /* synthetic */ h kT() {
        return super.kT();
    }

    public final /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public c(int i) {
        if (i == -1) {
            i = 1;
        }
        this.awO = i;
        this.awP = new a[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.awP[i2] = new a();
        }
        this.awQ = this.awP[0];
        kR();
    }

    public final void flush() {
        super.flush();
        this.awy = null;
        this.awz = null;
        this.awS = 0;
        this.awQ = this.awP[this.awS];
        kR();
        this.awR = null;
    }

    protected final boolean kO() {
        return this.awy != this.awz;
    }

    protected final d kP() {
        this.awz = this.awy;
        return new f(this.awy);
    }

    protected final void a(h hVar) {
        this.awt.l(hVar.aif.array(), hVar.aif.limit());
        while (this.awt.lF() >= 3) {
            int readUnsignedByte = this.awt.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            Object obj = (readUnsignedByte & 4) == 4 ? 1 : null;
            byte readUnsignedByte2 = (byte) this.awt.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.awt.readUnsignedByte();
            if ((i == 2 || i == 3) && obj != null) {
                byte[] bArr;
                b bVar;
                int i2;
                if (i == 3) {
                    kY();
                    i = (readUnsignedByte2 & ar.CTRL_INDEX) >> 6;
                    readUnsignedByte = readUnsignedByte2 & 63;
                    if (readUnsignedByte == 0) {
                        readUnsignedByte = 64;
                    }
                    this.awR = new b(i, readUnsignedByte);
                    bArr = this.awR.axt;
                    bVar = this.awR;
                    i2 = bVar.currentIndex;
                    bVar.currentIndex = i2 + 1;
                    bArr[i2] = readUnsignedByte3;
                } else {
                    com.google.android.exoplayer2.i.a.am(i == 2);
                    if (this.awR != null) {
                        bArr = this.awR.axt;
                        bVar = this.awR;
                        int i3 = bVar.currentIndex;
                        bVar.currentIndex = i3 + 1;
                        bArr[i3] = readUnsignedByte2;
                        bArr = this.awR.axt;
                        bVar = this.awR;
                        i2 = bVar.currentIndex;
                        bVar.currentIndex = i2 + 1;
                        bArr[i2] = readUnsignedByte3;
                    }
                }
                if (this.awR.currentIndex == (this.awR.axs * 2) - 1) {
                    kY();
                }
            }
        }
    }

    private void kY() {
        if (this.awR != null) {
            if (this.awR.currentIndex != (this.awR.axs * 2) - 1) {
                new StringBuilder("DtvCcPacket ended prematurely; size is ").append((this.awR.axs * 2) - 1).append(", but current index is ").append(this.awR.currentIndex).append(" (sequence number ").append(this.awR.axr).append("); ignoring packet");
            } else {
                this.awN.l(this.awR.axt, this.awR.currentIndex);
                int cT = this.awN.cT(3);
                int cT2 = this.awN.cT(5);
                if (cT == 7) {
                    this.awN.cS(2);
                    cT += this.awN.cT(6);
                }
                if (cT2 == 0) {
                    if (cT != 0) {
                        new StringBuilder("serviceNumber is non-zero (").append(cT).append(") when blockSize is 0");
                    }
                } else if (cT == this.awO) {
                    Object obj = null;
                    while (this.awN.lA() > 0) {
                        cT2 = this.awN.cT(8);
                        if (cT2 == 16) {
                            cT2 = this.awN.cT(8);
                            if (cT2 <= 31) {
                                if (cT2 > 7) {
                                    if (cT2 <= 15) {
                                        this.awN.cS(8);
                                    } else if (cT2 <= 23) {
                                        this.awN.cS(16);
                                    } else if (cT2 <= 31) {
                                        this.awN.cS(24);
                                    }
                                }
                            } else if (cT2 <= 127) {
                                switch (cT2) {
                                    case 32:
                                        this.awQ.append(' ');
                                        break;
                                    case 33:
                                        this.awQ.append(' ');
                                        break;
                                    case 37:
                                        this.awQ.append('…');
                                        break;
                                    case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                                        this.awQ.append('Š');
                                        break;
                                    case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                                        this.awQ.append('Œ');
                                        break;
                                    case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                                        this.awQ.append('█');
                                        break;
                                    case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                                        this.awQ.append('‘');
                                        break;
                                    case 50:
                                        this.awQ.append('’');
                                        break;
                                    case 51:
                                        this.awQ.append('“');
                                        break;
                                    case 52:
                                        this.awQ.append('”');
                                        break;
                                    case 53:
                                        this.awQ.append('•');
                                        break;
                                    case 57:
                                        this.awQ.append('™');
                                        break;
                                    case 58:
                                        this.awQ.append('š');
                                        break;
                                    case 60:
                                        this.awQ.append('œ');
                                        break;
                                    case 61:
                                        this.awQ.append('℠');
                                        break;
                                    case 63:
                                        this.awQ.append('Ÿ');
                                        break;
                                    case 118:
                                        this.awQ.append('⅛');
                                        break;
                                    case 119:
                                        this.awQ.append('⅜');
                                        break;
                                    case 120:
                                        this.awQ.append('⅝');
                                        break;
                                    case 121:
                                        this.awQ.append('⅞');
                                        break;
                                    case 122:
                                        this.awQ.append('│');
                                        break;
                                    case 123:
                                        this.awQ.append('┐');
                                        break;
                                    case 124:
                                        this.awQ.append('└');
                                        break;
                                    case 125:
                                        this.awQ.append('─');
                                        break;
                                    case 126:
                                        this.awQ.append('┘');
                                        break;
                                    case 127:
                                        this.awQ.append('┌');
                                        break;
                                }
                                obj = 1;
                            } else if (cT2 <= JsApiGetBackgroundAudioState.CTRL_INDEX) {
                                if (cT2 <= com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX) {
                                    this.awN.cS(32);
                                } else if (cT2 <= 143) {
                                    this.awN.cS(40);
                                } else if (cT2 <= JsApiGetBackgroundAudioState.CTRL_INDEX) {
                                    this.awN.cS(2);
                                    this.awN.cS(this.awN.cT(6) * 8);
                                }
                            } else if (cT2 <= 255) {
                                if (cT2 == JsApiSetBackgroundAudioState.CTRL_INDEX) {
                                    this.awQ.append('㏄');
                                } else {
                                    this.awQ.append('_');
                                }
                                obj = 1;
                            }
                        } else if (cT2 <= 31) {
                            switch (cT2) {
                                case 0:
                                case 14:
                                    break;
                                case 3:
                                    this.awy = kQ();
                                    break;
                                case 8:
                                    a aVar = this.awQ;
                                    int length = aVar.awI.length();
                                    if (length <= 0) {
                                        break;
                                    }
                                    aVar.awI.delete(length - 1, length);
                                    break;
                                case 12:
                                    kR();
                                    break;
                                case 13:
                                    this.awQ.append('\n');
                                    break;
                                default:
                                    if (cT2 < 17 || cT2 > 23) {
                                        if (cT2 >= 24 && cT2 <= 31) {
                                            this.awN.cS(16);
                                            break;
                                        }
                                    }
                                    this.awN.cS(8);
                                    break;
                                    break;
                            }
                        } else if (cT2 <= 127) {
                            if (cT2 == 127) {
                                this.awQ.append('♫');
                            } else {
                                this.awQ.append((char) (cT2 & 255));
                            }
                            obj = 1;
                        } else if (cT2 <= JsApiGetBackgroundAudioState.CTRL_INDEX) {
                            cJ(cT2);
                            obj = 1;
                        } else if (cT2 <= 255) {
                            this.awQ.append((char) (cT2 & 255));
                            obj = 1;
                        }
                    }
                    if (obj != null) {
                        this.awy = kQ();
                    }
                }
            }
            this.awR = null;
        }
    }

    private void cJ(int i) {
        int i2;
        int i3;
        a aVar;
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
            case 129:
            case 130:
            case 131:
            case 132:
            case com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX /*133*/:
            case com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX /*134*/:
            case com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX /*135*/:
                i2 = i - 128;
                if (this.awS != i2) {
                    this.awS = i2;
                    this.awQ = this.awP[i2];
                    return;
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.map.h.CTRL_INDEX /*136*/:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.awN.lC()) {
                        this.awP[8 - i2].clear();
                    }
                }
                return;
            case 137:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.awN.lC()) {
                        this.awP[8 - i2].visible = true;
                    }
                }
                return;
            case 138:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.awN.lC()) {
                        this.awP[8 - i2].visible = false;
                    }
                }
                return;
            case v.CTRL_INDEX /*139*/:
                for (i3 = 1; i3 <= 8; i3++) {
                    if (this.awN.lC()) {
                        a aVar2 = this.awP[8 - i3];
                        aVar2.visible = !aVar2.visible;
                    }
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX /*140*/:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.awN.lC()) {
                        this.awP[8 - i2].reset();
                    }
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.map.j.CTRL_INDEX /*141*/:
                this.awN.cS(8);
                return;
            case 143:
                kR();
                return;
            case e.CTRL_INDEX /*144*/:
                if (this.awQ.axe) {
                    this.awN.cT(4);
                    this.awN.cT(2);
                    this.awN.cT(2);
                    boolean lC = this.awN.lC();
                    boolean lC2 = this.awN.lC();
                    this.awN.cT(3);
                    this.awN.cT(3);
                    this.awQ.e(lC, lC2);
                    return;
                }
                this.awN.cS(16);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*145*/:
                if (this.awQ.axe) {
                    i2 = a.g(this.awN.cT(2), this.awN.cT(2), this.awN.cT(2), this.awN.cT(2));
                    i3 = a.g(this.awN.cT(2), this.awN.cT(2), this.awN.cT(2), this.awN.cT(2));
                    this.awN.cS(2);
                    a.s(this.awN.cT(2), this.awN.cT(2), this.awN.cT(2));
                    this.awQ.aq(i2, i3);
                    return;
                }
                this.awN.cS(24);
                return;
            case f.CTRL_INDEX /*146*/:
                if (this.awQ.axe) {
                    this.awN.cS(4);
                    i2 = this.awN.cT(4);
                    this.awN.cS(2);
                    this.awN.cT(6);
                    aVar = this.awQ;
                    if (aVar.row != i2) {
                        aVar.append('\n');
                    }
                    aVar.row = i2;
                    return;
                }
                this.awN.cS(16);
                return;
            case 151:
                if (this.awQ.axe) {
                    i2 = a.g(this.awN.cT(2), this.awN.cT(2), this.awN.cT(2), this.awN.cT(2));
                    this.awN.cT(2);
                    a.s(this.awN.cT(2), this.awN.cT(2), this.awN.cT(2));
                    this.awN.lC();
                    this.awN.lC();
                    this.awN.cT(2);
                    this.awN.cT(2);
                    i3 = this.awN.cT(2);
                    this.awN.cS(8);
                    this.awQ.ap(i2, i3);
                    return;
                }
                this.awN.cS(32);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.contact.d.CTRL_INDEX /*152*/:
            case 153:
            case JsApiMakeVoIPCall.CTRL_INDEX /*154*/:
            case 155:
            case 156:
            case 157:
            case 158:
            case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
                int i4;
                i2 = i - 152;
                aVar = this.awP[i2];
                this.awN.cS(2);
                boolean lC3 = this.awN.lC();
                boolean lC4 = this.awN.lC();
                this.awN.lC();
                int cT = this.awN.cT(3);
                boolean lC5 = this.awN.lC();
                int cT2 = this.awN.cT(7);
                int cT3 = this.awN.cT(8);
                int cT4 = this.awN.cT(4);
                int cT5 = this.awN.cT(4);
                this.awN.cS(2);
                this.awN.cT(6);
                this.awN.cS(2);
                int cT6 = this.awN.cT(3);
                int cT7 = this.awN.cT(3);
                aVar.axe = true;
                aVar.visible = lC3;
                aVar.axj = lC4;
                aVar.priority = cT;
                aVar.axf = lC5;
                aVar.axg = cT2;
                aVar.axh = cT3;
                aVar.axi = cT4;
                if (aVar.rowCount != cT5 + 1) {
                    aVar.rowCount = cT5 + 1;
                    while (true) {
                        if ((lC4 && aVar.awH.size() >= aVar.rowCount) || aVar.awH.size() >= 15) {
                            aVar.awH.remove(0);
                        }
                    }
                }
                if (!(cT6 == 0 || aVar.axl == cT6)) {
                    aVar.axl = cT6;
                    i4 = cT6 - 1;
                    aVar.ap(a.axa[i4], a.awW[i4]);
                }
                if (!(cT7 == 0 || aVar.axm == cT7)) {
                    aVar.axm = cT7;
                    i4 = cT7 - 1;
                    aVar.e(false, false);
                    aVar.aq(a.awT, a.axd[i4]);
                }
                if (this.awS != i2) {
                    this.awS = i2;
                    this.awQ = this.awP[i2];
                    return;
                }
                return;
            default:
                return;
        }
    }

    private List<a> kQ() {
        List arrayList = new ArrayList();
        int i = 0;
        while (i < 8) {
            if (!this.awP[i].isEmpty() && this.awP[i].visible) {
                arrayList.add(this.awP[i].kZ());
            }
            i++;
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void kR() {
        for (int i = 0; i < 8; i++) {
            this.awP[i].reset();
        }
    }
}
