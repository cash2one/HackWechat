package com.tencent.tinker.a.b.a;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.bp;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.plugin.appbrand.jsapi.map.h;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.appbrand.jsapi.media.e;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.az;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.b.a;
import com.tencent.wcdb.FileUtils;
import org.xwalk.core.R$styleable;

public final class f extends e {
    private final h Agc;
    private final c Agd;
    private final boolean Age = true;

    public f(h hVar, c cVar) {
        super(null);
        this.Agc = hVar;
        this.Agd = cVar;
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j) {
        if (this.Age) {
            i5 = this.Agd.Iu(i5);
        }
        switch (i2) {
            case -1:
            case 0:
            case 14:
                this.Agc.c((short) i2);
                return;
            case 36:
            case 110:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.Agc.a(b.fL(i2, b.fM(0, 0)), (short) i3, b.y(0, 0, 0, 0));
                return;
            case 40:
                byte b;
                if (this.Age) {
                    b = i5 - this.Agc.AfX;
                    if (b == ((byte) b)) {
                        this.Agc.c(b.fL(i2, b & 255));
                        return;
                    } else if (b != ((short) b)) {
                        this.Agc.a((short) 42, (short) b, (short) (b >> 16));
                        return;
                    } else {
                        this.Agc.b((short) 41, (short) b);
                        return;
                    }
                }
                b = i5 - this.Agc.AfX;
                if (b != ((byte) b)) {
                    throw new j("Target out of range: " + a.Iy(b) + ", perhaps you need to enable force jumbo mode.");
                }
                this.Agc.c(b.fL(i2, b & 255));
                return;
            case 41:
                short s;
                if (this.Age) {
                    short s2 = i5 - this.Agc.AfX;
                    if (s2 != ((short) s2)) {
                        this.Agc.a((short) 42, (short) s2, (short) (s2 >> 16));
                        return;
                    }
                    s = (short) i2;
                    this.Agc.b(s, (short) s2);
                    return;
                }
                s = (short) i2;
                this.Agc.b(s, b.fN(i5, this.Agc.AfX));
                return;
            case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                int i6 = i5 - this.Agc.AfX;
                this.Agc.a((short) i2, (short) i6, (short) (i6 >> 16));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.Ix(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        if (this.Age) {
            i5 = this.Agd.Iu(i5);
        }
        int i7;
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 17:
            case 29:
            case 30:
            case 39:
                this.Agc.c(b.fL(i2, i6));
                return;
            case 18:
                short s = (short) i2;
                h hVar = this.Agc;
                if (j < -8 || j > 7) {
                    throw new j("Literal out of range: " + a.gz(j));
                }
                hVar.c(b.fL(s, b.fM(i6, ((int) j) & 15)));
                return;
            case 19:
            case 22:
                this.Agc.b(b.fL(i2, i6), b.gy(j));
                return;
            case 20:
            case 23:
                if (j != ((long) ((int) j))) {
                    throw new j("Literal out of range: " + a.gz(j));
                }
                i7 = (int) j;
                this.Agc.a(b.fL(i2, i6), (short) i7, (short) (i7 >> 16));
                return;
            case 21:
            case 25:
                this.Agc.b(b.fL(i2, i6), (short) ((int) (j >> (i2 == 21 ? 16 : 48))));
                return;
            case 24:
                h hVar2 = this.Agc;
                short s2 = (short) ((int) j);
                short s3 = (short) ((int) (j >> 16));
                short s4 = (short) ((int) (j >> 32));
                short s5 = (short) ((int) (j >> 48));
                hVar2.c(b.fL(i2, i6));
                hVar2.c(s2);
                hVar2.c(s3);
                hVar2.c(s4);
                hVar2.c(s5);
                return;
            case 26:
                if (this.Age) {
                    if (i3 > 65535) {
                        this.Agc.a(b.fL(27, i6), (short) i3, (short) (i3 >> 16));
                        return;
                    } else {
                        this.Agc.b(b.fL(i2, i6), (short) i3);
                        return;
                    }
                } else if (i3 > 65535) {
                    throw new j("string index out of bound: " + a.Iv(i3) + ", perhaps you need to enable force jumbo mode.");
                } else {
                    this.Agc.b(b.fL(i2, i6), (short) i3);
                    return;
                }
            case 27:
                this.Agc.a(b.fL(i2, i6), (short) i3, (short) (i3 >> 16));
                return;
            case 28:
            case 31:
            case 34:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
                this.Agc.b(b.fL(i2, i6), (short) i3);
                return;
            case 36:
            case 110:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.Agc.a(b.fL(i2, b.fM(0, 1)), (short) i3, b.y(i6, 0, 0, 0));
                return;
            case 38:
            case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
            case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                switch (i2) {
                    case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                        this.Agc.fK(i5, this.Agc.AfX);
                        break;
                }
                i7 = i5 - this.Agc.AfX;
                this.Agc.a(b.fL(i2, i6), (short) i7, (short) (i7 >> 16));
                return;
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
                this.Agc.b(b.fL(i2, i6), b.fN(i5, this.Agc.AfX));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.Ix(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        if (this.Age) {
            i5 = this.Agd.Iu(i5);
        }
        switch (i2) {
            case 1:
            case 4:
            case 7:
            case 33:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case FileUtils.S_IWUSR /*128*/:
            case 129:
            case 130:
            case 131:
            case 132:
            case d.CTRL_INDEX /*133*/:
            case c.CTRL_INDEX /*134*/:
            case com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX /*135*/:
            case h.CTRL_INDEX /*136*/:
            case 137:
            case 138:
            case v.CTRL_INDEX /*139*/:
            case b.CTRL_INDEX /*140*/:
            case com.tencent.mm.plugin.appbrand.jsapi.map.j.CTRL_INDEX /*141*/:
            case 142:
            case 143:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 181:
            case au.CTRL_BYTE /*182*/:
            case 183:
            case 184:
            case 185:
            case 186:
            case az.CTRL_BYTE /*187*/:
            case n.CTRL_BYTE /*188*/:
            case k.CTRL_BYTE /*189*/:
            case 190:
            case com.tencent.mm.plugin.game.gamewebview.jsapi.biz.j.CTRL_BYTE /*191*/:
            case ar.CTRL_INDEX /*192*/:
            case JsApiChooseMedia.CTRL_INDEX /*193*/:
            case JsApiUploadEncryptedFileToCDN.CTRL_INDEX /*194*/:
            case JsApiChooseWeChatContact.CTRL_INDEX /*195*/:
            case 196:
            case 197:
            case bc.CTRL_INDEX /*198*/:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX /*204*/:
            case g.CTRL_INDEX /*205*/:
            case com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX /*206*/:
            case 207:
                this.Agc.c(b.fL((short) i2, b.fM(i6, i7)));
                return;
            case 2:
            case 5:
            case 8:
                this.Agc.b(b.fL(i2, i6), b.Ir(i7));
                return;
            case 3:
            case 6:
            case 9:
                this.Agc.a((short) i2, b.Iq(i6), b.Ir(i7));
                return;
            case 32:
            case 35:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case R$styleable.AppCompatTheme_colorControlHighlight /*87*/:
            case R$styleable.AppCompatTheme_colorButtonNormal /*88*/:
            case R$styleable.AppCompatTheme_colorSwitchThumbNormal /*89*/:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
                this.Agc.b(b.fL(i2, b.fM(i6, i7)), (short) i3);
                return;
            case 36:
            case 110:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.Agc.a(b.fL(i2, b.fM(0, 2)), (short) i3, b.y(i6, i7, 0, 0));
                return;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
                this.Agc.b(b.fL(i2, b.fM(i6, i7)), b.fN(i5, this.Agc.AfX));
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX /*208*/:
            case com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX /*209*/:
            case i.CTRL_INDEX /*210*/:
            case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX /*213*/:
            case JsApiCheckIsSupportFaceDetect.CTRL_INDEX /*214*/:
            case bp.CTRL_INDEX /*215*/:
                this.Agc.b(b.fL(i2, b.fM(i6, i7)), b.gy(j));
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX /*216*/:
            case e.CTRL_INDEX /*217*/:
            case 218:
            case 219:
            case 220:
            case 221:
            case 222:
            case 223:
            case 224:
            case 225:
            case com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX /*226*/:
                h hVar = this.Agc;
                short fL = b.fL(i2, i6);
                if (j != ((long) ((byte) ((int) j)))) {
                    throw new j("Literal out of range: " + a.gz(j));
                }
                hVar.b(fL, b.fL(i7, ((int) j) & 255));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.Ix(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.Agc.a(b.fL(i2, b.fM(0, 3)), (short) i3, b.y(i6, i7, i8, 0));
                return;
            case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
            case 46:
            case 47:
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
            case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
            case 68:
            case 69:
            case 70:
            case R$styleable.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
            case 72:
            case 73:
            case 74:
            case R$styleable.AppCompatTheme_listPopupWindowStyle /*75*/:
            case R$styleable.AppCompatTheme_textAppearanceListItem /*76*/:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX /*144*/:
            case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*145*/:
            case com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX /*146*/:
            case 147:
            case JsApiScanCode.CTRL_INDEX /*148*/:
            case com.tencent.mm.plugin.appbrand.jsapi.g.f.CTRL_INDEX /*149*/:
            case 150:
            case 151:
            case com.tencent.mm.plugin.appbrand.jsapi.contact.d.CTRL_INDEX /*152*/:
            case 153:
            case JsApiMakeVoIPCall.CTRL_INDEX /*154*/:
            case 155:
            case 156:
            case 157:
            case 158:
            case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
            case JsApiSetBackgroundAudioState.CTRL_INDEX /*160*/:
            case JsApiOperateBackgroundAudio.CTRL_INDEX /*161*/:
            case 162:
            case 163:
            case 164:
            case 165:
            case JsApiLaunchMiniProgram.CTRL_INDEX /*166*/:
            case 167:
            case JsApiSetClipboardData.CTRL_INDEX /*168*/:
            case y.CTRL_INDEX /*169*/:
            case 170:
            case 171:
            case 172:
            case af.CTRL_BYTE /*173*/:
            case GameJsApiOperateGameCenterMsg.CTRL_BYTE /*174*/:
            case ac.CTRL_BYTE /*175*/:
                this.Agc.b(b.fL(i2, i6), b.fL(i7, i8));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.Ix(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.Agc.a(b.fL(i2, b.fM(0, 4)), (short) i3, b.y(i6, i7, i8, i9));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.Ix(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.Agc.a(b.fL(i2, b.fM(i10, 5)), (short) i3, b.y(i6, i7, i8, i9));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.Ix(i2));
        }
    }

    public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        switch (i2) {
            case 37:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
                this.Agc.a(b.fL(i2, i7), (short) i3, b.Iq(i6));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.Ix(i2));
        }
    }

    public final void a(int i, int i2, int[] iArr, int[] iArr2) {
        int length;
        int i3 = 0;
        int cGS = this.Agc.cGS();
        this.Agc.c((short) i2);
        this.Agc.c(b.Io(iArr2.length));
        for (int writeInt : iArr) {
            this.Agc.writeInt(writeInt);
        }
        if (this.Age) {
            length = iArr2.length;
            while (i3 < length) {
                this.Agc.writeInt(this.Agd.Iu(iArr2[i3]) - cGS);
                i3++;
            }
            return;
        }
        length = iArr2.length;
        while (i3 < length) {
            this.Agc.writeInt(iArr2[i3] - cGS);
            i3++;
        }
    }

    public final void b(int i, int i2, int i3, int[] iArr) {
        int i4 = 0;
        int cGS = this.Agc.cGS();
        this.Agc.c((short) i2);
        this.Agc.c(b.Io(iArr.length));
        this.Agc.writeInt(i3);
        int length;
        if (this.Age) {
            length = iArr.length;
            while (i4 < length) {
                this.Agc.writeInt(this.Agd.Iu(iArr[i4]) - cGS);
                i4++;
            }
            return;
        }
        length = iArr.length;
        while (i4 < length) {
            this.Agc.writeInt(iArr[i4] - cGS);
            i4++;
        }
    }

    public final void a(int i, int i2, Object obj, int i3, int i4) {
        int i5 = 0;
        this.Agc.c((short) i2);
        this.Agc.c((short) i4);
        this.Agc.writeInt(i3);
        h hVar;
        int length;
        switch (i4) {
            case 1:
                h hVar2 = this.Agc;
                int i6 = 1;
                int i7 = 0;
                for (byte b : (byte[]) obj) {
                    if (i6 != 0) {
                        i7 = b & 255;
                        i6 = 0;
                    } else {
                        i6 = (b << 8) | i7;
                        hVar2.c((short) i6);
                        i7 = i6;
                        i6 = 1;
                    }
                }
                if (i6 == 0) {
                    hVar2.c((short) i7);
                    return;
                }
                return;
            case 2:
                hVar = this.Agc;
                short[] sArr = (short[]) obj;
                length = sArr.length;
                while (i5 < length) {
                    hVar.c(sArr[i5]);
                    i5++;
                }
                return;
            case 4:
                hVar = this.Agc;
                int[] iArr = (int[]) obj;
                length = iArr.length;
                while (i5 < length) {
                    hVar.writeInt(iArr[i5]);
                    i5++;
                }
                return;
            case 8:
                hVar = this.Agc;
                long[] jArr = (long[]) obj;
                length = jArr.length;
                while (i5 < length) {
                    long j = jArr[i5];
                    hVar.c((short) ((int) j));
                    hVar.c((short) ((int) (j >> 16)));
                    hVar.c((short) ((int) (j >> 32)));
                    hVar.c((short) ((int) (j >> 48)));
                    i5++;
                }
                return;
            default:
                throw new j("bogus element_width: " + a.Iw(i4));
        }
    }
}
