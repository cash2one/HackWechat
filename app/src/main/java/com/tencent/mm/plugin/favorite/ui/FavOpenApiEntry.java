package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.z.q;

@a(3)
public class FavOpenApiEntry extends MMActivity {
    private String appId;
    private String bhd;
    private ak fhK = new ak(new 1(this), true);
    private Intent fzg;
    private Bundle msB;
    private Req msC;
    private String msD;
    private int msE = 0;

    static /* synthetic */ void a(FavOpenApiEntry favOpenApiEntry, WXMediaMessage wXMediaMessage) {
        boolean z = true;
        boolean z2 = false;
        if (wXMediaMessage == null) {
            x.e("MicroMsg.FavOpenApiEntry", "deal fail, WXMediaMessage is null");
            return;
        }
        int type = wXMediaMessage.getType();
        i b;
        switch (type) {
            case 1:
                if (!bh.ov(((WXTextObject) wXMediaMessage.mediaObject).text)) {
                    favOpenApiEntry.appId.equals("wx4310bbd51be7d979");
                    if (e.a(favOpenApiEntry.mController, wXMediaMessage.description, false, favOpenApiEntry.msD, favOpenApiEntry.a(wXMediaMessage)) != null) {
                        z2 = true;
                        break;
                    }
                }
                x.e("MicroMsg.FavOpenApiEntry", "dealText null!");
                break;
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                if (wXImageObject.imageData != null || com.tencent.mm.a.e.bO(wXImageObject.imagePath)) {
                    if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                        wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                        b = (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) ? e.b(favOpenApiEntry.mController, wXImageObject.imagePath, false, favOpenApiEntry.msD, favOpenApiEntry.a(wXMediaMessage)) : e.a(favOpenApiEntry.mController, wXImageObject.imageData, false, favOpenApiEntry.msD, favOpenApiEntry.a(wXMediaMessage));
                    } else {
                        b = e.a(favOpenApiEntry.mController, wXMediaMessage.thumbData, false, favOpenApiEntry.msD, favOpenApiEntry.a(wXMediaMessage));
                    }
                    if (b != null) {
                        z2 = true;
                        break;
                    } else {
                        x.e("MicroMsg.FavOpenApiEntry", "showImgDialog fail, invalid argument");
                        break;
                    }
                }
                break;
            case 3:
                b = (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) ? e.a(favOpenApiEntry.mController, R.k.dvn, wXMediaMessage.title, false, favOpenApiEntry.msD, favOpenApiEntry.a(wXMediaMessage)) : e.a(favOpenApiEntry.mController, wXMediaMessage.title, false, 2, favOpenApiEntry.msD, favOpenApiEntry.a(wXMediaMessage));
                if (b == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 4:
                b = (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) ? e.a(favOpenApiEntry.mController, R.k.dvA, wXMediaMessage.title, false, favOpenApiEntry.msD, favOpenApiEntry.a(wXMediaMessage)) : e.a(favOpenApiEntry.mController, wXMediaMessage.title, false, 1, favOpenApiEntry.msD, favOpenApiEntry.a(wXMediaMessage));
                if (b == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 5:
                if (e.a(favOpenApiEntry.mController, wXMediaMessage.title, wXMediaMessage.description, false, favOpenApiEntry.msD, favOpenApiEntry.a(wXMediaMessage)) == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 6:
                b = (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) ? e.a(favOpenApiEntry.mController, R.k.dvj, wXMediaMessage.title, false, favOpenApiEntry.msD, favOpenApiEntry.a(wXMediaMessage)) : e.a(favOpenApiEntry.mController, wXMediaMessage.title, false, 0, favOpenApiEntry.msD, favOpenApiEntry.a(wXMediaMessage));
                if (b == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 7:
            case 8:
                break;
            default:
                x.e("MicroMsg.FavOpenApiEntry", "unknown type = " + type);
                break;
        }
        if (!z2) {
            x.e("MicroMsg.FavOpenApiEntry", "deal fail, result is false finish()");
            favOpenApiEntry.finish();
        }
    }

    static /* synthetic */ int b(FavOpenApiEntry favOpenApiEntry) {
        int i = favOpenApiEntry.msE + 1;
        favOpenApiEntry.msE = i;
        return i;
    }

    static /* synthetic */ void b(FavOpenApiEntry favOpenApiEntry, WXMediaMessage wXMediaMessage) {
        if (wXMediaMessage == null) {
            x.e("MicroMsg.FavOpenApiEntry", "deal fail, WXMediaMessage is null");
            return;
        }
        int type = wXMediaMessage.getType();
        f fVar;
        uq uqVar;
        switch (type) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                if (!bh.ov(wXTextObject.text)) {
                    fVar = new f();
                    fVar.field_type = 1;
                    a(wXMediaMessage, fVar);
                    fVar.field_favProto.Uh(wXTextObject.text);
                    favOpenApiEntry.E(fVar);
                    com.tencent.mm.plugin.favorite.b.a.B(fVar);
                    break;
                }
                x.e("MicroMsg.FavOpenApiEntry", "addText null!");
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                if (wXImageObject.imageData != null || com.tencent.mm.a.e.bO(wXImageObject.imagePath)) {
                    fVar = new f();
                    fVar.field_type = 2;
                    a(wXMediaMessage, fVar);
                    favOpenApiEntry.E(fVar);
                    fVar.field_favProto.weU.add(a(wXMediaMessage, wXImageObject.imagePath, wXImageObject.imageData, fVar.field_type));
                    com.tencent.mm.plugin.favorite.b.a.B(fVar);
                    break;
                }
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) wXMediaMessage.mediaObject;
                if (!bh.ov(wXMusicObject.musicDataUrl) || !bh.ov(wXMusicObject.musicUrl) || !bh.ov(wXMusicObject.musicLowBandUrl)) {
                    fVar = new f();
                    fVar.field_type = 7;
                    a(wXMediaMessage, fVar);
                    uqVar = new uq();
                    uqVar.Tw(wXMusicObject.musicUrl);
                    uqVar.Ty(wXMusicObject.musicLowBandUrl);
                    uqVar.Tx(wXMusicObject.musicDataUrl);
                    uqVar.Tq(wXMediaMessage.title);
                    uqVar.Tr(wXMediaMessage.description);
                    a(wXMediaMessage, uqVar, fVar.field_type);
                    uqVar.ls(true);
                    uqVar.CJ(fVar.field_type);
                    fVar.field_favProto.weU.add(uqVar);
                    favOpenApiEntry.E(fVar);
                    com.tencent.mm.plugin.favorite.b.a.B(fVar);
                    break;
                }
                x.e("MicroMsg.FavOpenApiEntry", "addMusic, both url null");
                break;
                break;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) wXMediaMessage.mediaObject;
                if (!bh.ov(wXVideoObject.videoLowBandUrl) || !bh.ov(wXVideoObject.videoUrl)) {
                    fVar = new f();
                    fVar.field_type = 4;
                    a(wXMediaMessage, fVar);
                    uqVar = new uq();
                    uqVar.Tw(wXVideoObject.videoUrl);
                    uqVar.Ty(wXVideoObject.videoLowBandUrl);
                    uqVar.Tq(wXMediaMessage.title);
                    uqVar.Tr(wXMediaMessage.description);
                    a(wXMediaMessage, uqVar, fVar.field_type);
                    uqVar.ls(true);
                    uqVar.CJ(fVar.field_type);
                    fVar.field_favProto.weU.add(uqVar);
                    favOpenApiEntry.E(fVar);
                    com.tencent.mm.plugin.favorite.b.a.B(fVar);
                    break;
                }
                x.e("MicroMsg.FavOpenApiEntry", "addVideo, both url null");
                break;
                break;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) wXMediaMessage.mediaObject;
                if (!bh.ov(wXWebpageObject.webpageUrl)) {
                    fVar = new f();
                    fVar.field_sessionId = favOpenApiEntry.getIntent().getStringExtra("reportSessionId");
                    fVar.field_type = 5;
                    a(wXMediaMessage, fVar);
                    favOpenApiEntry.E(fVar);
                    fVar.field_favProto.weS.Up(wXWebpageObject.webpageUrl);
                    if (wXMediaMessage.thumbData != null) {
                        uq uqVar2 = new uq();
                        uqVar2.Tq(wXMediaMessage.title);
                        uqVar2.Tr(wXMediaMessage.description);
                        a(wXMediaMessage, uqVar2, fVar.field_type);
                        uqVar2.ls(true);
                        uqVar2.CJ(fVar.field_type);
                        fVar.field_favProto.weU.add(uqVar2);
                    }
                    com.tencent.mm.plugin.favorite.b.a.B(fVar);
                    break;
                }
                x.e("MicroMsg.FavOpenApiEntry", "addUrl null!");
                break;
            case 6:
                WXFileObject wXFileObject = (WXFileObject) wXMediaMessage.mediaObject;
                if (wXFileObject.fileData == null && !com.tencent.mm.a.e.bO(wXFileObject.filePath)) {
                    x.e("MicroMsg.FavOpenApiEntry", "addFile data null");
                    break;
                }
                fVar = new f();
                fVar.field_type = 8;
                a(wXMediaMessage, fVar);
                favOpenApiEntry.E(fVar);
                fVar.field_favProto.weU.add(a(wXMediaMessage, wXFileObject.filePath, wXFileObject.fileData, fVar.field_type));
                com.tencent.mm.plugin.favorite.b.a.B(fVar);
                break;
                break;
            default:
                x.e("MicroMsg.FavOpenApiEntry", "unsupport type = " + type);
                break;
        }
        favOpenApiEntry.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fzg == null) {
            this.fzg = getIntent();
        }
        this.msB = this.fzg.getExtras();
        this.appId = this.msB.getString("SendAppMessageWrapper_AppId");
        if (this.appId == null) {
            this.appId = Uri.parse(this.msB.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        }
        this.msC = new Req(this.msB);
        if (this.msC.scene != 2) {
            x.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
            finish();
            return;
        }
        this.msD = getString(R.l.eeE);
        String appName = d.getAppName(this, this.appId);
        this.bhd = getString(R.l.dUf, new Object[]{appName});
        this.fhK.J(100, 100);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.fzg = intent;
    }

    protected void onResume() {
        super.onResume();
    }

    private static void a(WXMediaMessage wXMediaMessage, f fVar) {
        fVar.field_sourceType = 4;
        fVar.field_favProto.Ug(wXMediaMessage.title);
        fVar.field_favProto.Uh(wXMediaMessage.description);
    }

    private void E(f fVar) {
        vk vkVar = new vk();
        vkVar.Uo(this.appId);
        vkVar.CS(4);
        vkVar.Ui(q.FS());
        vkVar.Uj(q.FS());
        fVar.field_fromUser = vkVar.fzO;
        fVar.field_toUser = vkVar.toUser;
        fVar.field_favProto.a(vkVar);
    }

    private static uq a(WXMediaMessage wXMediaMessage, String str, byte[] bArr, int i) {
        uq uqVar = new uq();
        uqVar.Tq(wXMediaMessage.title);
        uqVar.Tr(wXMediaMessage.description);
        uqVar.CJ(i);
        if (str != null) {
            uqVar.TE(str);
            uqVar.TA(com.tencent.mm.a.e.bQ(str));
        } else {
            String s = g.s(bArr);
            if (bArr.length >= 256) {
                uqVar.TC(s);
            } else {
                Object obj = new byte[256];
                System.arraycopy(bArr, 0, obj, 0, 256);
                uqVar.TC(g.s(obj));
            }
            uqVar.TB(s);
            uqVar.fw((long) bArr.length);
            uqVar.TD(j.bk(uqVar.toString(), i));
            com.tencent.mm.a.e.d(j.h(uqVar), bArr);
        }
        a(wXMediaMessage, uqVar, i);
        return uqVar;
    }

    private static void a(WXMediaMessage wXMediaMessage, uq uqVar, int i) {
        if (wXMediaMessage.thumbData != null) {
            String s = g.s(wXMediaMessage.thumbData);
            uqVar.TG(s);
            if (wXMediaMessage.thumbData.length >= 256) {
                uqVar.TH(s);
            } else {
                Object obj = new byte[256];
                System.arraycopy(wXMediaMessage.thumbData, 0, obj, 0, 256);
                uqVar.TH(g.s(obj));
            }
            if (bh.ov(uqVar.mvG)) {
                uqVar.TD(j.bk(uqVar.toString(), i));
            }
            uqVar.fx((long) wXMediaMessage.thumbData.length);
            com.tencent.mm.a.e.d(j.i(uqVar), wXMediaMessage.thumbData);
            return;
        }
        uqVar.lt(true);
    }

    private o.a a(final WXMediaMessage wXMediaMessage) {
        return new o.a(this) {
            final /* synthetic */ FavOpenApiEntry msF;

            public final void a(boolean z, String str, int i) {
                if (z) {
                    FavOpenApiEntry.b(this.msF, wXMediaMessage);
                    ReportUtil.a(this.msF, ReportUtil.b(this.msF.getIntent().getExtras(), 0));
                    return;
                }
                this.msF.finish();
                ReportUtil.a(this.msF, ReportUtil.b(this.msF.getIntent().getExtras(), -2));
            }
        };
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
