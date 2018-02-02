package com.google.android.exoplayer2.f.a;

import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.f.c$a;
import com.tencent.mm.plugin.appbrand.jsapi.f.g;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.appbrand.jsapi.media.e;
import com.tencent.mm.plugin.appbrand.jsapi.media.f;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.j;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.mm.plugin.gif.MMGIFException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.R$styleable;

public final class a extends d {
    private static final int[] CE = new int[]{-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] awn = new int[]{11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] awo = new int[]{0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] awp = new int[]{32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, bd.CTRL_BYTE, g.CTRL_INDEX, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, an.CTRL_INDEX, c.CTRL_INDEX, GameJsApiGetGameCommInfo.CTRL_BYTE, 9632};
    private static final int[] awq = new int[]{GameJsApiOperateGameCenterMsg.CTRL_BYTE, 176, k.CTRL_BYTE, j.CTRL_BYTE, 8482, 162, 163, 9834, 224, 32, 232, com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, 234, bc.CTRL_BYTE, c$a.CTRL_INDEX, 251};
    private static final int[] awr = new int[]{JsApiChooseMedia.CTRL_INDEX, 201, h.CTRL_INDEX, 218, 220, 252, 8216, JsApiOperateBackgroundAudio.CTRL_INDEX, 42, 39, 8212, y.CTRL_INDEX, 8480, 8226, 8220, 8221, ar.CTRL_INDEX, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, 199, 200, 202, 203, 235, b.CTRL_INDEX, 207, ai.CTRL_BYTE, com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX, e.CTRL_INDEX, az.CTRL_INDEX, 219, 171, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.az.CTRL_BYTE};
    private static final int[] aws = new int[]{JsApiChooseWeChatContact.CTRL_INDEX, GameJsApiGetOpenDeviceId.CTRL_BYTE, com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX, d.CTRL_INDEX, JsApiGetSetting.CTRL_INDEX, i.CTRL_INDEX, 242, com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, 245, 123, 125, 92, 94, 95, 124, 126, 196, JsApiOpenWeRunSetting.CTRL_INDEX, JsApiCheckIsSupportFaceDetect.CTRL_INDEX, 246, 223, 165, 164, 9474, 197, be.CTRL_INDEX, f.CTRL_INDEX, 248, 9484, 9488, 9492, 9496};
    private int awA;
    private int awB;
    private boolean awC;
    private byte awD;
    private byte awE;
    private final com.google.android.exoplayer2.i.j awt = new com.google.android.exoplayer2.i.j();
    private final int awu;
    private final int awv;
    private final LinkedList<a> aww = new LinkedList();
    private a awx = new a(0, 4);
    private List<com.google.android.exoplayer2.f.a> awy;
    private List<com.google.android.exoplayer2.f.a> awz;

    private static class a {
        int acc;
        private int awA;
        int awB;
        final List<CharacterStyle> awF = new ArrayList();
        final List<a> awG = new ArrayList();
        final List<SpannableString> awH = new LinkedList();
        final SpannableStringBuilder awI = new SpannableStringBuilder();
        int awJ;
        int awK;
        int row;

        public a(int i, int i2) {
            reset(i, i2);
        }

        public final void reset(int i, int i2) {
            this.awF.clear();
            this.awG.clear();
            this.awH.clear();
            this.awI.clear();
            this.row = 15;
            this.acc = 0;
            this.awJ = 0;
            this.awA = i;
            this.awB = i2;
            this.awK = -1;
        }

        public final boolean isEmpty() {
            return this.awF.isEmpty() && this.awG.isEmpty() && this.awH.isEmpty() && this.awI.length() == 0;
        }

        public final void kU() {
            int length = this.awI.length();
            if (length > 0) {
                this.awI.delete(length - 1, length);
            }
        }

        public final void kV() {
            this.awH.add(kW());
            this.awI.clear();
            this.awF.clear();
            this.awG.clear();
            this.awK = -1;
            int min = Math.min(this.awB, this.row);
            while (this.awH.size() >= min) {
                this.awH.remove(0);
            }
        }

        public final void a(CharacterStyle characterStyle) {
            this.awF.add(characterStyle);
        }

        public final void a(CharacterStyle characterStyle, int i) {
            this.awG.add(new a(characterStyle, this.awI.length(), i));
        }

        public final void append(char c) {
            this.awI.append(c);
        }

        private SpannableString kW() {
            int length = this.awI.length();
            for (int i = 0; i < this.awF.size(); i++) {
                this.awI.setSpan(this.awF.get(i), 0, length, 33);
            }
            for (int i2 = 0; i2 < this.awG.size(); i2++) {
                int i3;
                a aVar = (a) this.awG.get(i2);
                if (i2 < this.awG.size() - aVar.awM) {
                    i3 = ((a) this.awG.get(aVar.awM + i2)).start;
                } else {
                    i3 = length;
                }
                this.awI.setSpan(aVar.awL, aVar.start, i3, 33);
            }
            if (this.awK != -1) {
                this.awI.setSpan(new UnderlineSpan(), this.awK, length, 33);
            }
            return new SpannableString(this.awI);
        }

        public final com.google.android.exoplayer2.f.a kX() {
            int i;
            int i2 = 2;
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            for (i = 0; i < this.awH.size(); i++) {
                spannableStringBuilder.append((CharSequence) this.awH.get(i));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(kW());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            float f;
            int i3;
            int i4;
            int i5 = this.acc + this.awJ;
            i = (32 - i5) - spannableStringBuilder.length();
            int i6 = i5 - i;
            if (this.awA == 2 && Math.abs(i6) < 3) {
                f = 0.5f;
                i3 = 1;
            } else if (this.awA != 2 || i6 <= 0) {
                f = ((((float) i5) / 32.0f) * 0.8f) + 0.1f;
                i3 = 0;
            } else {
                f = ((((float) (32 - i)) / 32.0f) * 0.8f) + 0.1f;
                i3 = 2;
            }
            if (this.awA == 1 || this.row > 7) {
                i4 = (this.row - 15) - 2;
            } else {
                i2 = 0;
                i4 = this.row;
            }
            return new com.google.android.exoplayer2.f.a(spannableStringBuilder, Alignment.ALIGN_NORMAL, (float) i4, 1, i2, f, i3, Float.MIN_VALUE);
        }

        public final String toString() {
            return this.awI.toString();
        }
    }

    public final /* bridge */ /* synthetic */ void K(long j) {
        super.K(j);
    }

    public final /* bridge */ /* synthetic */ void b(com.google.android.exoplayer2.f.h hVar) {
        super.b(hVar);
    }

    public final /* bridge */ /* synthetic */ com.google.android.exoplayer2.f.i kS() {
        return super.kS();
    }

    public final /* bridge */ /* synthetic */ com.google.android.exoplayer2.f.h kT() {
        return super.kT();
    }

    public a(String str, int i) {
        this.awu = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        switch (i) {
            case 3:
            case 4:
                this.awv = 2;
                break;
            default:
                this.awv = 1;
                break;
        }
        cI(0);
        kR();
    }

    public final void flush() {
        super.flush();
        this.awy = null;
        this.awz = null;
        cI(0);
        kR();
        this.awB = 4;
        this.awC = false;
        this.awD = (byte) 0;
        this.awE = (byte) 0;
    }

    public final void release() {
    }

    protected final boolean kO() {
        return this.awy != this.awz;
    }

    protected final com.google.android.exoplayer2.f.d kP() {
        this.awz = this.awy;
        return new f(this.awy);
    }

    protected final void a(com.google.android.exoplayer2.f.h hVar) {
        this.awt.l(hVar.aif.array(), hVar.aif.limit());
        boolean z = false;
        boolean z2 = false;
        while (this.awt.lF() >= this.awu) {
            int i;
            if (this.awu == 2) {
                i = -4;
            } else {
                i = (byte) this.awt.readUnsignedByte();
            }
            byte readUnsignedByte = (byte) (this.awt.readUnsignedByte() & 127);
            byte readUnsignedByte2 = (byte) (this.awt.readUnsignedByte() & 127);
            if ((i & 6) == 4 && ((this.awv != 1 || (i & 1) == 0) && ((this.awv != 2 || (i & 1) == 1) && !(readUnsignedByte == (byte) 0 && readUnsignedByte2 == (byte) 0)))) {
                if ((readUnsignedByte & an.CTRL_INDEX) == 17 && (readUnsignedByte2 & 240) == 48) {
                    this.awx.append((char) awq[readUnsignedByte2 & 15]);
                    z2 = true;
                } else if ((readUnsignedByte & 246) == 18 && (readUnsignedByte2 & 224) == 32) {
                    this.awx.kU();
                    if ((readUnsignedByte & 1) == 0) {
                        this.awx.append((char) awr[readUnsignedByte2 & 31]);
                        z2 = true;
                    } else {
                        this.awx.append((char) aws[readUnsignedByte2 & 31]);
                        z2 = true;
                    }
                } else if ((readUnsignedByte & 224) == 0) {
                    if ((readUnsignedByte & 240) == 16) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (this.awC && this.awD == readUnsignedByte && this.awE == readUnsignedByte2) {
                            this.awC = false;
                            z = true;
                            z2 = true;
                        } else {
                            this.awC = true;
                            this.awD = readUnsignedByte;
                            this.awE = readUnsignedByte2;
                        }
                    }
                    z = (readUnsignedByte & an.CTRL_INDEX) == 17 && (readUnsignedByte2 & 240) == 32;
                    int i2;
                    if (!z) {
                        z = (readUnsignedByte & 240) == 16 && (readUnsignedByte2 & ar.CTRL_INDEX) == 64;
                        if (!z) {
                            z = (readUnsignedByte & an.CTRL_INDEX) == 23 && readUnsignedByte2 >= (byte) 33 && readUnsignedByte2 <= (byte) 35;
                            if (!z) {
                                z = (readUnsignedByte & an.CTRL_INDEX) == 20 && (readUnsignedByte2 & 240) == 32;
                                if (z) {
                                    switch (readUnsignedByte2) {
                                        case (byte) 32:
                                            cI(2);
                                            break;
                                        case (byte) 37:
                                            this.awB = 2;
                                            cI(1);
                                            break;
                                        case (byte) 38:
                                            this.awB = 3;
                                            cI(1);
                                            break;
                                        case (byte) 39:
                                            this.awB = 4;
                                            cI(1);
                                            break;
                                        case (byte) 41:
                                            cI(3);
                                            break;
                                        default:
                                            if (this.awA != 0) {
                                                switch (readUnsignedByte2) {
                                                    case (byte) 33:
                                                        this.awx.kU();
                                                        break;
                                                    case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                                                        this.awy = null;
                                                        if (this.awA == 1 || this.awA == 3) {
                                                            kR();
                                                            break;
                                                        }
                                                    case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                                                        if (this.awA == 1 && !this.awx.isEmpty()) {
                                                            this.awx.kV();
                                                            break;
                                                        }
                                                    case (byte) 46:
                                                        kR();
                                                        break;
                                                    case (byte) 47:
                                                        this.awy = kQ();
                                                        kR();
                                                        break;
                                                    default:
                                                        break;
                                                }
                                            }
                                            break;
                                    }
                                }
                            }
                            this.awx.awJ = readUnsignedByte2 - 32;
                        } else {
                            i2 = awn[readUnsignedByte & 7];
                            if ((readUnsignedByte2 & 32) != 0) {
                                i2++;
                            }
                            if (i2 != this.awx.row) {
                                if (!(this.awA == 1 || this.awx.isEmpty())) {
                                    this.awx = new a(this.awA, this.awB);
                                    this.aww.add(this.awx);
                                }
                                this.awx.row = i2;
                            }
                            if ((readUnsignedByte2 & 1) == 1) {
                                this.awx.a(new UnderlineSpan());
                            }
                            i2 = (readUnsignedByte2 >> 1) & 15;
                            if (i2 > 7) {
                                this.awx.acc = awo[i2 & 7];
                            } else if (i2 == 7) {
                                this.awx.a(new StyleSpan(2));
                                this.awx.a(new ForegroundColorSpan(-1));
                            } else {
                                this.awx.a(new ForegroundColorSpan(CE[i2]));
                            }
                        }
                    } else {
                        z = (readUnsignedByte2 & 1) == 1;
                        a aVar = this.awx;
                        if (z) {
                            aVar.awK = aVar.awI.length();
                        } else if (aVar.awK != -1) {
                            aVar.awI.setSpan(new UnderlineSpan(), aVar.awK, aVar.awI.length(), 33);
                            aVar.awK = -1;
                        }
                        i2 = (readUnsignedByte2 >> 1) & 15;
                        if (i2 == 7) {
                            this.awx.a(new StyleSpan(2), 2);
                            this.awx.a(new ForegroundColorSpan(-1), 1);
                        } else {
                            this.awx.a(new ForegroundColorSpan(CE[i2]), 1);
                        }
                    }
                    z = z2;
                    z2 = true;
                } else {
                    this.awx.append(a(readUnsignedByte));
                    if ((readUnsignedByte2 & 224) != 0) {
                        this.awx.append(a(readUnsignedByte2));
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            if (!z) {
                this.awC = false;
            }
            if (this.awA == 1 || this.awA == 3) {
                this.awy = kQ();
            }
        }
    }

    private List<com.google.android.exoplayer2.f.a> kQ() {
        List<com.google.android.exoplayer2.f.a> arrayList = new ArrayList();
        for (int i = 0; i < this.aww.size(); i++) {
            com.google.android.exoplayer2.f.a kX = ((a) this.aww.get(i)).kX();
            if (kX != null) {
                arrayList.add(kX);
            }
        }
        return arrayList;
    }

    private void cI(int i) {
        if (this.awA != i) {
            int i2 = this.awA;
            this.awA = i;
            kR();
            if (i2 == 3 || i == 1 || i == 0) {
                this.awy = null;
            }
        }
    }

    private void kR() {
        this.awx.reset(this.awA, this.awB);
        this.aww.clear();
        this.aww.add(this.awx);
    }

    private static char a(byte b) {
        return (char) awp[(b & 127) - 32];
    }
}
