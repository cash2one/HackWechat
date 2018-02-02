package com.tencent.tinker.a.b.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
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
import com.tencent.mm.plugin.appbrand.jsapi.map.a;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.h;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
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
import com.tencent.wcdb.FileUtils;
import org.xwalk.core.R$styleable;

public final class d {
    private final g Aga;

    public d(g gVar) {
        this.Aga = gVar;
    }

    public final void a(e eVar) {
        a aVar = this.Aga;
        aVar.AfW.hX = 0;
        aVar.AfX = 0;
        while (true) {
            aVar = this.Aga;
            if ((aVar.AfX < aVar.Agf.length ? 1 : null) != null) {
                int i = this.Aga.AfX;
                int read = this.Aga.read();
                int i2 = read & 255;
                if (i2 == 0 || i2 == 255) {
                    i2 = read;
                }
                int i3;
                int i4;
                int read2;
                int i5;
                int i6;
                int Is;
                int readInt;
                int[] iArr;
                switch (i2) {
                    case -1:
                        eVar.a(i, read, 0, 1, 0, 0);
                        break;
                    case 0:
                    case 14:
                        eVar.a(i, read & 255, 0, 1, 0, (long) b.Ip(read));
                        break;
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
                    case com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX /*133*/:
                    case c.CTRL_INDEX /*134*/:
                    case a.CTRL_INDEX /*135*/:
                    case h.CTRL_INDEX /*136*/:
                    case 137:
                    case 138:
                    case v.CTRL_INDEX /*139*/:
                    case b.CTRL_INDEX /*140*/:
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
                        eVar.a(i, read & 255, 0, 1, 0, 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 2:
                    case 5:
                    case 8:
                        eVar.a(i, read & 255, 0, 1, 0, 0, b.Ip(read), this.Aga.read());
                        break;
                    case 3:
                    case 6:
                    case 9:
                        eVar.a(i, read & 255, 0, 1, 0, (long) b.Ip(read), this.Aga.read(), this.Aga.read());
                        break;
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
                        eVar.a(i, read & 255, 0, 1, 0, 0, b.Ip(read));
                        break;
                    case 18:
                        eVar.a(i, read & 255, 0, 1, 0, (long) ((((read >> 12) & 15) << 28) >> 28), (read >> 8) & 15);
                        break;
                    case 19:
                    case 22:
                        eVar.a(i, read & 255, 0, 1, 0, (long) ((short) this.Aga.read()), b.Ip(read));
                        break;
                    case 20:
                    case 23:
                        eVar.a(i, read & 255, 0, 1, 0, (long) this.Aga.readInt(), b.Ip(read));
                        break;
                    case 21:
                    case 25:
                        i3 = read & 255;
                        eVar.a(i, i3, 0, 1, 0, ((long) ((short) this.Aga.read())) << (i3 == 21 ? 16 : 48), b.Ip(read));
                        break;
                    case 24:
                        eVar.a(i, read & 255, 0, 1, 0, this.Aga.readLong(), b.Ip(read));
                        break;
                    case 26:
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
                        i3 = read & 255;
                        eVar.a(i, i3, this.Aga.read(), b.Is(i3), 0, 0, b.Ip(read));
                        break;
                    case 27:
                        i3 = read & 255;
                        eVar.a(i, i3, this.Aga.readInt(), b.Is(i3), 0, 0, b.Ip(read));
                        break;
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
                        i4 = read & 255;
                        eVar.a(i, i4, this.Aga.read(), b.Is(i4), 0, 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 36:
                    case 110:
                    case 111:
                    case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                    case 113:
                    case 114:
                        int i7 = read & 255;
                        int i8 = (read >> 8) & 15;
                        i2 = (read >> 12) & 15;
                        read2 = this.Aga.read();
                        read = this.Aga.read();
                        i5 = read & 15;
                        i3 = (read >> 4) & 15;
                        i4 = (read >> 8) & 15;
                        i6 = (read >> 12) & 15;
                        Is = b.Is(i7);
                        switch (i2) {
                            case 0:
                                eVar.a(i, i7, read2, Is, 0, 0);
                                break;
                            case 1:
                                eVar.a(i, i7, read2, Is, 0, 0, i5);
                                break;
                            case 2:
                                eVar.a(i, i7, read2, Is, 0, 0, i5, i3);
                                break;
                            case 3:
                                eVar.a(i, i7, read2, Is, 0, 0, i5, i3, i4);
                                break;
                            case 4:
                                eVar.a(i, i7, read2, Is, 0, 0, i5, i3, i4, i6);
                                break;
                            case 5:
                                eVar.a(i, i7, read2, Is, 0, 0, i5, i3, i4, i6, i8);
                                break;
                            default:
                                throw new com.tencent.tinker.a.a.j("bogus registerCount: " + new String(new char[]{Character.forDigit(i2 & 15, 16)}));
                        }
                    case 37:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                        i4 = read & 255;
                        eVar.b(i, i4, this.Aga.read(), b.Is(i4), 0, 0, this.Aga.read(), b.Ip(read));
                        break;
                    case 38:
                    case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                        i3 = read & 255;
                        i5 = b.Ip(read);
                        readInt = i + this.Aga.readInt();
                        switch (i3) {
                            case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                            case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                                this.Aga.fK(readInt + 1, i);
                                break;
                        }
                        eVar.a(i, i3, 0, 1, readInt, 0, i5);
                        break;
                    case 40:
                        eVar.a(i, read & 255, 0, 1, i + ((byte) b.Ip(read)), 0);
                        break;
                    case 41:
                        eVar.a(i, read & 255, 0, 1, i + ((short) this.Aga.read()), (long) b.Ip(read));
                        break;
                    case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                        eVar.a(i, read & 255, 0, 1, i + this.Aga.readInt(), (long) b.Ip(read));
                        break;
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
                    case e.CTRL_INDEX /*144*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*145*/:
                    case f.CTRL_INDEX /*146*/:
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
                        i6 = read & 255;
                        i5 = b.Ip(read);
                        i2 = this.Aga.read();
                        eVar.a(i, i6, 0, 1, 0, 0, i5, i2 & 255, b.Ip(i2));
                        break;
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                        eVar.a(i, read & 255, 0, 1, i + ((short) this.Aga.read()), 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                        eVar.a(i, read & 255, 0, 1, i + ((short) this.Aga.read()), 0, b.Ip(read));
                        break;
                    case com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX /*208*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX /*209*/:
                    case i.CTRL_INDEX /*210*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX /*213*/:
                    case JsApiCheckIsSupportFaceDetect.CTRL_INDEX /*214*/:
                    case bp.CTRL_INDEX /*215*/:
                        eVar.a(i, read & 255, 0, 1, 0, (long) ((short) this.Aga.read()), (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX /*216*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX /*217*/:
                    case 218:
                    case 219:
                    case 220:
                    case 221:
                    case 222:
                    case 223:
                    case 224:
                    case 225:
                    case com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX /*226*/:
                        i4 = read & 255;
                        i5 = b.Ip(read);
                        i2 = this.Aga.read();
                        eVar.a(i, i4, 0, 1, 0, (long) ((byte) b.Ip(i2)), i5, i2 & 255);
                        break;
                    case 256:
                        read2 = this.Aga.cGS();
                        Is = this.Aga.read();
                        readInt = this.Aga.readInt();
                        iArr = new int[Is];
                        for (i2 = 0; i2 < Is; i2++) {
                            iArr[i2] = this.Aga.readInt() + read2;
                        }
                        eVar.b(i, read, readInt, iArr);
                        break;
                    case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                        read2 = this.Aga.cGS();
                        Is = this.Aga.read();
                        int[] iArr2 = new int[Is];
                        iArr = new int[Is];
                        for (i2 = 0; i2 < Is; i2++) {
                            iArr2[i2] = this.Aga.readInt();
                        }
                        for (i2 = 0; i2 < Is; i2++) {
                            iArr[i2] = this.Aga.readInt() + read2;
                        }
                        eVar.a(i, read, iArr2, iArr);
                        break;
                    case 768:
                        i2 = this.Aga.read();
                        int readInt2 = this.Aga.readInt();
                        Object obj;
                        switch (i2) {
                            case 1:
                                obj = new byte[readInt2];
                                i2 = 0;
                                int i9 = 0;
                                Object obj2 = 1;
                                while (i9 < readInt2) {
                                    if (obj2 != null) {
                                        i2 = this.Aga.read();
                                    }
                                    obj[i9] = (byte) (i2 & 255);
                                    i9++;
                                    obj2 = obj2 == null ? 1 : null;
                                    i2 >>= 8;
                                }
                                eVar.a(i, read, obj, obj.length, 1);
                                break;
                            case 2:
                                obj = new short[readInt2];
                                for (i2 = 0; i2 < readInt2; i2++) {
                                    obj[i2] = (short) this.Aga.read();
                                }
                                eVar.a(i, read, obj, obj.length, 2);
                                break;
                            case 4:
                                obj = new int[readInt2];
                                for (i2 = 0; i2 < readInt2; i2++) {
                                    obj[i2] = this.Aga.readInt();
                                }
                                eVar.a(i, read, obj, obj.length, 4);
                                break;
                            case 8:
                                obj = new long[readInt2];
                                for (i2 = 0; i2 < readInt2; i2++) {
                                    obj[i2] = this.Aga.readLong();
                                }
                                eVar.a(i, read, obj, obj.length, 8);
                                break;
                            default:
                                throw new com.tencent.tinker.a.a.j("bogus element_width: " + com.tencent.tinker.a.b.b.a.Iw(i2));
                        }
                    default:
                        throw new IllegalStateException("Unknown opcode: " + com.tencent.tinker.a.b.b.a.Iv(i2));
                }
            }
            return;
        }
    }
}
