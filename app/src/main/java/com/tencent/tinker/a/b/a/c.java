package com.tencent.tinker.a.b.a;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.plugin.appbrand.jsapi.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.bp;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.plugin.appbrand.jsapi.map.h;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
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
import com.tencent.tinker.a.b.b.a;
import com.tencent.tinker.a.c.b;
import com.tencent.wcdb.FileUtils;
import org.xwalk.core.R$styleable;

public final class c extends e {
    private final b AfY = new b();
    private int AfZ = 0;

    public c() {
        super(null);
    }

    private void It(int i) {
        if (i != this.AfZ) {
            b bVar = this.AfY;
            int i2 = this.AfZ;
            if (bVar.hX == 0 || i > bVar.wA[bVar.hX - 1]) {
                bVar.wA = b.d(bVar.wA, bVar.hX, i);
                bVar.Agi = b.d(bVar.Agi, bVar.hX, i2);
                bVar.hX++;
                return;
            }
            bVar.put(i, i2);
        }
    }

    public final int Iu(int i) {
        int indexOfKey = this.AfY.indexOfKey(i);
        return indexOfKey < 0 ? i : this.AfY.Agi[indexOfKey];
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j) {
        It(i);
        switch (i2) {
            case -1:
            case 0:
            case 14:
                this.AfZ++;
                return;
            case 36:
            case 110:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.AfZ += 3;
                return;
            case 40:
                byte b = i5 - this.AfZ;
                if (b == ((byte) b)) {
                    this.AfZ++;
                    return;
                } else if (b != ((short) b)) {
                    this.AfZ += 3;
                    return;
                } else {
                    this.AfZ += 2;
                    return;
                }
            case 41:
                short s = i5 - this.AfZ;
                if (s != ((short) s)) {
                    this.AfZ += 3;
                    return;
                } else {
                    this.AfZ += 2;
                    return;
                }
            case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                this.AfZ += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.Ix(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        It(i);
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 17:
            case 18:
            case 29:
            case 30:
            case 39:
                this.AfZ++;
                return;
            case 19:
            case 21:
            case 22:
            case 25:
            case 28:
            case 31:
            case 34:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
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
                this.AfZ += 2;
                return;
            case 20:
            case 23:
            case 36:
            case 38:
            case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
            case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
            case 110:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.AfZ += 3;
                return;
            case 24:
                this.AfZ += 5;
                return;
            case 26:
                if (i3 > 65535) {
                    this.AfZ += 3;
                    return;
                } else {
                    this.AfZ += 2;
                    return;
                }
            case 27:
                this.AfZ += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.Ix(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        It(i);
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
            case com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX /*134*/:
            case com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX /*135*/:
            case h.CTRL_INDEX /*136*/:
            case 137:
            case 138:
            case v.CTRL_INDEX /*139*/:
            case com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX /*140*/:
            case j.CTRL_INDEX /*141*/:
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
                this.AfZ++;
                return;
            case 2:
            case 5:
            case 8:
                this.AfZ += 2;
                return;
            case 3:
            case 6:
            case 9:
            case 36:
            case 110:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.AfZ += 3;
                return;
            case 32:
            case 35:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
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
            case f.CTRL_INDEX /*208*/:
            case com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX /*209*/:
            case i.CTRL_INDEX /*210*/:
            case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX /*213*/:
            case JsApiCheckIsSupportFaceDetect.CTRL_INDEX /*214*/:
            case bp.CTRL_INDEX /*215*/:
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
                this.AfZ += 2;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.Ix(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
        It(i);
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.AfZ += 3;
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
                this.AfZ += 2;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.Ix(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        It(i);
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.AfZ += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.Ix(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        It(i);
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.AfZ += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.Ix(i2));
        }
    }

    public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        It(i);
        switch (i2) {
            case 37:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
                this.AfZ += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.Ix(i2));
        }
    }

    public final void a(int i, int i2, int[] iArr, int[] iArr2) {
        It(i);
        this.AfZ += 2;
        this.AfZ += iArr.length * 2;
        this.AfZ += iArr2.length * 2;
    }

    public final void b(int i, int i2, int i3, int[] iArr) {
        It(i);
        this.AfZ += 4;
        this.AfZ += iArr.length * 2;
    }

    public final void a(int i, int i2, Object obj, int i3, int i4) {
        It(i);
        this.AfZ += 4;
        switch (i4) {
            case 1:
                int length = ((byte[]) obj).length;
                this.AfZ = ((length & 1) + (length >> 1)) + this.AfZ;
                return;
            case 2:
                this.AfZ += ((short[]) obj).length * 1;
                return;
            case 4:
                this.AfZ += ((int[]) obj).length * 2;
                return;
            case 8:
                this.AfZ += ((long[]) obj).length * 4;
                return;
            default:
                throw new com.tencent.tinker.a.a.j("bogus element_width: " + a.Iw(i4));
        }
    }
}
