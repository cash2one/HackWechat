package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.m.b;
import com.tencent.mm.plugin.appbrand.p.k;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.o$a;
import com.tencent.mm.protocal.c.cas;
import com.tencent.mm.protocal.c.cat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.p;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bo;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.mm.z.u;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

@a(3)
public class SendAppMessageWrapperUI extends MMActivity {
    private String bhd = null;
    private ak fhK = new ak(new 1(this), true);
    private int msE = 0;
    private int scene = 0;
    private String toUser = null;
    private WXMediaMessage yuW = null;
    private f zpB = null;
    private boolean zpC = false;

    static /* synthetic */ void a(SendAppMessageWrapperUI sendAppMessageWrapperUI, WXMediaMessage wXMediaMessage, String str, int i) {
        x.d("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc msg[%s], text[%s], parsterLen[%d], scene[%d]", new Object[]{wXMediaMessage, str, Integer.valueOf(i), Integer.valueOf(sendAppMessageWrapperUI.scene)});
        if (sendAppMessageWrapperUI.scene == 0) {
            String str2;
            String hz;
            String str3;
            String str4;
            bo.HS().c(38, Integer.valueOf(1));
            if (wXMediaMessage.getType() != 8) {
                str2 = null;
            } else if (wXMediaMessage.thumbData == null) {
                x.e("MicroMsg.SendAppMessageWrapperUI", "summerbig code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                return;
            } else {
                str2 = ((c) g.k(c.class)).getEmojiMgr().a(sendAppMessageWrapperUI, wXMediaMessage, sendAppMessageWrapperUI.zpB.field_appId);
                if (str2 == null) {
                    x.v("MicroMsg.SendAppMessageWrapperUI", "summerbig sendEmoji Fail cause emojiconmd5 is null");
                    return;
                }
                EmojiInfo yc = ((c) g.k(c.class)).getEmojiMgr().yc(str2);
                if (yc == null) {
                    x.i("MicroMsg.SendAppMessageWrapperUI", "emoji is null.");
                    return;
                }
                if (yc.field_size > bh.getInt(com.tencent.mm.k.g.zY().getValue("InputLimitSendThirdPartyAppMsgEmotionBufSize"), SQLiteGlobal.journalSizeLimit)) {
                    x.i("MicroMsg.SendAppMessageWrapperUI", "third party shared emoji can't bigger 512 KB");
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(13461, new Object[]{sendAppMessageWrapperUI.zpB.field_appId, sendAppMessageWrapperUI.zpB.field_appName, Integer.valueOf(yc.field_size)});
            }
            if (wXMediaMessage.getType() == 5 || wXMediaMessage.getType() == 2) {
                x.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), appId : %s", new Object[]{sendAppMessageWrapperUI.zpB.field_appId});
                hz = u.hz("app_" + sendAppMessageWrapperUI.zpB.field_appId);
                u.GK().t(hz, true).o("prePublishId", "app_" + sendAppMessageWrapperUI.zpB.field_appId);
            } else {
                hz = null;
            }
            LinkedList linkedList = new LinkedList(bh.F(sendAppMessageWrapperUI.toUser.split(",")));
            if (wXMediaMessage.getType() == 36) {
                sendAppMessageWrapperUI.b(wXMediaMessage, linkedList);
            } else if (wXMediaMessage.getType() == 2) {
                sendAppMessageWrapperUI.a(wXMediaMessage, linkedList);
            } else {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    str3 = (String) it.next();
                    l.a(wXMediaMessage, sendAppMessageWrapperUI.zpB.field_appId, sendAppMessageWrapperUI.zpB.field_appName, str3, 2, str2, hz);
                }
            }
            if (sendAppMessageWrapperUI.zpB.field_appId.equals("wx4310bbd51be7d979")) {
                str4 = null;
            } else {
                str4 = sendAppMessageWrapperUI.getString(R.l.dTZ, new Object[]{sendAppMessageWrapperUI.zpB.field_appName});
            }
            if (str4 == null) {
                str4 = sendAppMessageWrapperUI.getString(R.l.dTY);
            }
            str3 = sendAppMessageWrapperUI.getString(R.l.dUg);
            o$a 4 = new 4(sendAppMessageWrapperUI);
            e.a(sendAppMessageWrapperUI.mController, sendAppMessageWrapperUI.getString(R.l.dUd), str4, str3, new 5(sendAppMessageWrapperUI), 4);
            if (str == null || str.length() == 0) {
                x.i("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc, text is empty");
                return;
            }
            x.d("MicroMsg.SendAppMessageWrapperUI", "summerbig dktext , send msg here:" + str);
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                ar.CG().a(new j((String) it2.next(), str, s.hp(sendAppMessageWrapperUI.toUser)), 0);
            }
            return;
        }
        if (n.qQx != null) {
            n.qQx.a(wXMediaMessage, str, sendAppMessageWrapperUI.zpB.field_appId, sendAppMessageWrapperUI.zpB.field_appName, i);
            n.qQx.buj();
        }
        ReportUtil.a(sendAppMessageWrapperUI, ReportUtil.b(sendAppMessageWrapperUI.getIntent().getExtras(), 0));
        sendAppMessageWrapperUI.finish();
    }

    static /* synthetic */ int b(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        int i = sendAppMessageWrapperUI.msE + 1;
        sendAppMessageWrapperUI.msE = i;
        return i;
    }

    static /* synthetic */ void c(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        boolean z = false;
        boolean z2 = true;
        if (sendAppMessageWrapperUI.yuW == null) {
            x.e("MicroMsg.SendAppMessageWrapperUI", "deal fail, WXMediaMessage is null");
            return;
        }
        int type = sendAppMessageWrapperUI.yuW.getType();
        WXMediaMessage wXMediaMessage;
        i b;
        WXMediaMessage wXMediaMessage2;
        WXMediaMessage wXMediaMessage3;
        e.a aVar;
        switch (type) {
            case 1:
                wXMediaMessage = sendAppMessageWrapperUI.yuW;
                WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                if (wXTextObject.text != null && wXTextObject.text.length() != 0) {
                    sendAppMessageWrapperUI.zpB.field_appId.equals("wx4310bbd51be7d979");
                    if (e.a(sendAppMessageWrapperUI.mController, wXMediaMessage.description, true, sendAppMessageWrapperUI.a(wXMediaMessage)) != null) {
                        break;
                    }
                }
                x.e("MicroMsg.SendAppMessageWrapperUI", "dealText fail, text is empty");
                z2 = false;
                break;
            case 2:
                wXMediaMessage = sendAppMessageWrapperUI.yuW;
                if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                    WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                    b = (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) ? e.b(sendAppMessageWrapperUI.mController, wXImageObject.imagePath, true, sendAppMessageWrapperUI.a(wXMediaMessage)) : e.a(sendAppMessageWrapperUI.mController, wXImageObject.imageData, true, sendAppMessageWrapperUI.a(wXMediaMessage));
                } else {
                    b = e.a(sendAppMessageWrapperUI.mController, wXMediaMessage.thumbData, true, sendAppMessageWrapperUI.a(wXMediaMessage));
                }
                if (b == null) {
                    x.e("MicroMsg.SendAppMessageWrapperUI", "showDialogItem3 fail, invalid argument");
                } else {
                    z = true;
                }
                z2 = z;
                break;
            case 3:
                wXMediaMessage2 = sendAppMessageWrapperUI.yuW;
                b = (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) ? e.a(sendAppMessageWrapperUI.mController, R.k.dvn, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2)) : e.a(sendAppMessageWrapperUI.mController, wXMediaMessage2.title, true, 2, sendAppMessageWrapperUI.a(wXMediaMessage2));
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 4:
                wXMediaMessage2 = sendAppMessageWrapperUI.yuW;
                b = (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) ? e.a(sendAppMessageWrapperUI.mController, R.k.dvA, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2)) : e.a(sendAppMessageWrapperUI.mController, wXMediaMessage2.title, true, 1, sendAppMessageWrapperUI.a(wXMediaMessage2));
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 5:
                wXMediaMessage3 = sendAppMessageWrapperUI.yuW;
                if (e.a(sendAppMessageWrapperUI.mController, wXMediaMessage3.title, wXMediaMessage3.description, true, sendAppMessageWrapperUI.mController.xIM.getResources().getString(R.l.dUe), sendAppMessageWrapperUI.a(wXMediaMessage3)) == null) {
                    z2 = false;
                    break;
                }
                break;
            case 6:
                wXMediaMessage2 = sendAppMessageWrapperUI.yuW;
                b = (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) ? e.a(sendAppMessageWrapperUI.mController, R.k.dvj, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2)) : e.a(sendAppMessageWrapperUI.mController, wXMediaMessage2.title, true, 0, sendAppMessageWrapperUI.a(wXMediaMessage2));
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 7:
                wXMediaMessage2 = sendAppMessageWrapperUI.yuW;
                if (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) {
                    Bitmap b2 = com.tencent.mm.pluginsdk.model.app.g.b(sendAppMessageWrapperUI.zpB.field_appId, 1, com.tencent.mm.bv.a.getDensity(sendAppMessageWrapperUI));
                    if (b2 == null || b2.isRecycled()) {
                        b = e.a(sendAppMessageWrapperUI.mController, R.k.dvD, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2));
                    } else {
                        p pVar = sendAppMessageWrapperUI.mController;
                        CharSequence charSequence = wXMediaMessage2.title;
                        CharSequence charSequence2 = wXMediaMessage2.description;
                        CharSequence charSequence3 = sendAppMessageWrapperUI.bhd;
                        o$a a = sendAppMessageWrapperUI.a(wXMediaMessage2);
                        View V = e.V(pVar.xIM, R.i.deD);
                        i.a aVar2 = new i.a(pVar.xIM);
                        aVar2.mi(false);
                        aVar2.mj(false);
                        e.l(V, true);
                        e.a(pVar, aVar2, a, V, pVar.xIM.getResources().getString(R.l.dUe));
                        TextView textView = (TextView) V.findViewById(R.h.bWW);
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xIM, charSequence, textView.getTextSize()));
                        textView = (TextView) V.findViewById(R.h.bWT);
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xIM, charSequence2, textView.getTextSize()));
                        textView = (TextView) V.findViewById(R.h.bWQ);
                        if (charSequence3 == null || charSequence3.length() == 0) {
                            textView.setVisibility(8);
                        } else {
                            textView.setText(charSequence3);
                            textView.setVisibility(0);
                        }
                        ImageView imageView = (ImageView) V.findViewById(R.h.bWV);
                        if (imageView != null) {
                            if (b2 == null || b2.isRecycled()) {
                                x.w("MicroMsg.MMConfirmDialog", "showDialogItem4, thumbBmp is null or recycled");
                                imageView.setVisibility(8);
                            } else {
                                imageView.setVisibility(0);
                                imageView.setImageBitmap(b2);
                                e.a(aVar2, b2);
                            }
                        }
                        aVar2.dk(V);
                        b = aVar2.akx();
                        b.show();
                    }
                } else {
                    b = e.a(sendAppMessageWrapperUI.mController, wXMediaMessage2.title, true, 0, sendAppMessageWrapperUI.a(wXMediaMessage2));
                }
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 8:
                wXMediaMessage = sendAppMessageWrapperUI.yuW;
                String a2 = ((c) g.k(c.class)).getEmojiMgr().a(sendAppMessageWrapperUI, wXMediaMessage, sendAppMessageWrapperUI.zpB.field_appId);
                String string = sendAppMessageWrapperUI.mController.xIM.getIntent().getExtras().getString("Select_Conv_User", null);
                if (bh.ov(a2)) {
                    if (e.a(sendAppMessageWrapperUI.mController, R.k.dvD, wXMediaMessage.title, true, sendAppMessageWrapperUI.a(wXMediaMessage)) == null) {
                        z2 = false;
                        break;
                    }
                }
                aVar = new e.a(sendAppMessageWrapperUI.mController.xIM);
                aVar.bS(string).Sr(a2).f(Boolean.valueOf(true)).BW(R.l.dGA).a(sendAppMessageWrapperUI.a(wXMediaMessage)).pyk.show();
                if (aVar.pyk == null) {
                    z2 = false;
                    break;
                }
                break;
            case 36:
                WXMediaMessage wXMediaMessage4 = sendAppMessageWrapperUI.yuW;
                if (wXMediaMessage4 != null && (wXMediaMessage4.mediaObject instanceof WXMiniProgramObject)) {
                    WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) wXMediaMessage4.mediaObject;
                    ((b) g.h(b.class)).qK(wXMiniProgramObject.userName);
                    aVar = new e.a(sendAppMessageWrapperUI.mController.xIM);
                    aVar.bS(sendAppMessageWrapperUI.mController.xIM.getIntent().getExtras().getString("Select_Conv_User", null));
                    View be = ((com.tencent.mm.modelappbrand.g) g.h(com.tencent.mm.modelappbrand.g.class)).be(sendAppMessageWrapperUI);
                    String bi = k.bi(sendAppMessageWrapperUI);
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("image_data", wXMediaMessage4.thumbData);
                    bundle.putString("title", wXMediaMessage4.title);
                    bundle.putString("msg_path", wXMiniProgramObject.path);
                    ((com.tencent.mm.modelappbrand.g) g.h(com.tencent.mm.modelappbrand.g.class)).a(bi, be, bundle);
                    aVar.da(be);
                    aVar.f(Boolean.valueOf(true));
                    aVar.caU();
                    aVar.jWl = new 2(sendAppMessageWrapperUI, bi, be);
                    aVar.BW(R.l.dGA);
                    aVar.a(sendAppMessageWrapperUI.a(wXMediaMessage4)).pyk.show();
                    break;
                }
                z2 = false;
                break;
            case 38:
                wXMediaMessage3 = sendAppMessageWrapperUI.yuW;
                if (e.a(sendAppMessageWrapperUI.mController, wXMediaMessage3.title, wXMediaMessage3.description, true, sendAppMessageWrapperUI.mController.xIM.getResources().getString(R.l.dUe), sendAppMessageWrapperUI.a(wXMediaMessage3), sendAppMessageWrapperUI.getResources().getString(R.l.dFf)) == null) {
                    z2 = false;
                    break;
                }
                break;
            default:
                x.e("MicroMsg.SendAppMessageWrapperUI", "unknown type = " + type);
                z2 = false;
                break;
        }
        if (!z2) {
            x.e("MicroMsg.SendAppMessageWrapperUI", "deal fail, result is false");
            sendAppMessageWrapperUI.finish();
        }
    }

    static /* synthetic */ void d(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        if (sendAppMessageWrapperUI.scene == 0) {
            Intent intent = new Intent();
            intent.putExtra("Select_Report_Args", ReportUtil.b(sendAppMessageWrapperUI.getIntent().getExtras(), -2));
            sendAppMessageWrapperUI.setResult(0, intent);
        } else {
            ReportUtil.a(sendAppMessageWrapperUI, ReportUtil.b(sendAppMessageWrapperUI.getIntent().getExtras(), -2));
        }
        sendAppMessageWrapperUI.finish();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable e;
        Intent intent;
        super.onCreate(bundle);
        getSupportActionBar().hide();
        SharedPreferences sharedPreferences = getSharedPreferences(ac.cfs(), 0);
        if (!sharedPreferences.getBoolean("settings_landscape_mode", false)) {
            x.d("MicroMsg.SendAppMessageWrapperUI", "change orientation");
            this.zpC = true;
            setRequestedOrientation(-1);
            sharedPreferences.edit().putBoolean("settings_landscape_mode", true).commit();
        }
        Bundle extras = getIntent().getExtras();
        Req req = new Req(extras);
        this.toUser = extras.getString("Select_Conv_User");
        this.scene = extras.getInt("SendAppMessageWrapper_Scene", 0);
        String string = extras.getString("SendAppMessageWrapper_AppId");
        if (string == null) {
            string = Uri.parse(extras.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        }
        this.zpB = new f();
        this.zpB.field_appId = string;
        an.bin().b(this.zpB, new String[0]);
        if (this.zpB.field_appName == null) {
            string = getString(R.l.dUh);
        } else {
            string = com.tencent.mm.pluginsdk.model.app.g.a(this.mController.xIM, this.zpB, null);
        }
        this.bhd = getString(R.l.dUf, new Object[]{string});
        this.yuW = req.message;
        x.i("MicroMsg.SendAppMessageWrapperUI", "onCreate, messageAction = %s, messageExt = %s", new Object[]{this.yuW.messageAction, this.yuW.messageExt});
        if (this.scene != 1) {
            this.fhK.J(100, 100);
        } else if (this.yuW.mediaObject == null) {
            finish();
        } else if (this.yuW.getType() == 38) {
            WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) this.yuW.mediaObject;
            String str = wXVideoFileObject.filePath;
            if (bh.ov(wXVideoFileObject.filePath) || !com.tencent.mm.a.e.bO(wXVideoFileObject.filePath)) {
                finish();
            } else {
                try {
                    mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(str);
                        x.i("MicroMsg.SendAppMessageWrapperUI", "video duration %d", new Object[]{Integer.valueOf(bh.getInt(mediaMetadataRetriever.extractMetadata(9), -1))});
                        if (bh.getInt(mediaMetadataRetriever.extractMetadata(9), -1) >= 10500) {
                            setResult(-5);
                            finish();
                        }
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e2, "%s", new Object[]{e2.getMessage()});
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            x.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e2, "Analysis duration of mediaItem %s error %s", new Object[]{str, e2.getMessage()});
                            if (mediaMetadataRetriever != null) {
                                try {
                                    mediaMetadataRetriever.release();
                                } catch (Throwable e22) {
                                    x.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e22, "%s", new Object[]{e22.getMessage()});
                                }
                            }
                            intent = new Intent();
                            intent.putExtra("K_SEGMENTVIDEOPATH", str);
                            intent.putExtra("KSEGMENTVIDEOTHUMBPATH", "");
                            d.b(this, "mmsight", ".segment.VideoCompressUI", intent, 2);
                        } catch (Throwable th) {
                            e22 = th;
                            if (mediaMetadataRetriever != null) {
                                try {
                                    mediaMetadataRetriever.release();
                                } catch (Throwable e4) {
                                    x.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e4, "%s", new Object[]{e4.getMessage()});
                                }
                            }
                            throw e22;
                        }
                    }
                } catch (Exception e5) {
                    e22 = e5;
                    mediaMetadataRetriever = null;
                    x.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e22, "Analysis duration of mediaItem %s error %s", new Object[]{str, e22.getMessage()});
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    intent = new Intent();
                    intent.putExtra("K_SEGMENTVIDEOPATH", str);
                    intent.putExtra("KSEGMENTVIDEOTHUMBPATH", "");
                    d.b(this, "mmsight", ".segment.VideoCompressUI", intent, 2);
                } catch (Throwable th2) {
                    e22 = th2;
                    mediaMetadataRetriever = null;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    throw e22;
                }
            }
            intent = new Intent();
            intent.putExtra("K_SEGMENTVIDEOPATH", str);
            intent.putExtra("KSEGMENTVIDEOTHUMBPATH", "");
            d.b(this, "mmsight", ".segment.VideoCompressUI", intent, 2);
        } else {
            if (this.yuW.getType() == 39) {
                WXGameVideoFileObject wXGameVideoFileObject = (WXGameVideoFileObject) this.yuW.mediaObject;
                if (!bh.ov(wXGameVideoFileObject.filePath) && com.tencent.mm.a.e.bO(wXGameVideoFileObject.filePath)) {
                    boolean z;
                    String str2 = wXGameVideoFileObject.filePath;
                    if (FileOp.me(str2) > ((long) com.tencent.mm.k.g.zY().getInt("ShareVideoMaxSize", 4194304))) {
                        x.e("MicroMsg.ShareSnsImpl", "file len too big ");
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        z = true;
                    } else {
                        com.tencent.mm.modelsns.a.a mA = com.tencent.mm.modelsns.a.a.mA(str2);
                        if (mA.videoWidth <= 0 || mA.videoHeight <= 0 || ((float) mA.videoWidth) / ((float) mA.videoHeight) > 3.0f || ((float) mA.videoWidth) / ((float) mA.videoHeight) < 0.5f) {
                            x.i("MicroMsg.ShareSnsImpl", "check ratio faild width = [%d], height = [%d]", new Object[]{Integer.valueOf(mA.videoWidth), Integer.valueOf(mA.videoHeight)});
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            x.i("MicroMsg.ShareSnsImpl", "check duration %d", new Object[]{Integer.valueOf(mA.hOr)});
                            z = mA.hOr <= 1000 ? true : mA.hOr >= 10500;
                            if (!z) {
                                x.d("MicroMsg.ShareSnsImpl", "checkFormat() called with: item = [%s]", new Object[]{mA});
                                if (!bh.ov(mA.hOo)) {
                                    string = mA.hOo;
                                    if (bh.ov(string)) {
                                        z = true;
                                    } else {
                                        if (com.tencent.mm.modelsns.a.hOn == null) {
                                            Set hashSet = new HashSet();
                                            com.tencent.mm.modelsns.a.hOn = hashSet;
                                            hashSet.add(".h264");
                                            com.tencent.mm.modelsns.a.hOn.add(".h26l");
                                            com.tencent.mm.modelsns.a.hOn.add(".264");
                                            com.tencent.mm.modelsns.a.hOn.add(".avc");
                                            com.tencent.mm.modelsns.a.hOn.add(".mov");
                                            com.tencent.mm.modelsns.a.hOn.add(".mp4");
                                            com.tencent.mm.modelsns.a.hOn.add(".m4a");
                                            com.tencent.mm.modelsns.a.hOn.add(".3gp");
                                            com.tencent.mm.modelsns.a.hOn.add(".3g2");
                                            com.tencent.mm.modelsns.a.hOn.add(".mj2");
                                            com.tencent.mm.modelsns.a.hOn.add(".m4v");
                                        }
                                        string = string.trim();
                                        int lastIndexOf = string.lastIndexOf(".");
                                        z = (lastIndexOf < 0 || lastIndexOf >= string.length()) ? true : !com.tencent.mm.modelsns.a.hOn.contains(string.substring(lastIndexOf));
                                    }
                                    if (!z && "video/avc".equalsIgnoreCase(mA.hOp) && (bh.ov(mA.hOq) || "audio/mp4a-latm".equalsIgnoreCase(mA.hOq))) {
                                        z = false;
                                        if (!z) {
                                            z = false;
                                        }
                                    }
                                }
                                x.i("MicroMsg.ShareSnsImpl", "check video format failed, dst format [video/avc], video format [%s]", new Object[]{mA.hOp});
                                z = true;
                                if (z) {
                                    z = false;
                                }
                            }
                        }
                        z = true;
                    }
                }
                ReportUtil.a(this, ReportUtil.b(getIntent().getExtras(), -5));
                finish();
                return;
            }
            cyq();
        }
    }

    private void cyq() {
        Intent a = com.tencent.mm.modelsns.a.a(this.yuW, this.zpB.field_appId, this.zpB.field_appName);
        if (a == null) {
            finish();
            return;
        }
        String str = null;
        if (this.yuW.getType() == 5 || this.yuW.getType() == 2 || this.yuW.getType() == 38) {
            x.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", new Object[]{this.zpB.field_appId});
            String hz = u.hz("app_" + this.zpB.field_appId);
            u.b t = u.GK().t(hz, true);
            t.o("prePublishId", "app_" + this.zpB.field_appId);
            if (this.yuW.mediaObject instanceof WXWebpageObject) {
                t.o(SlookSmartClipMetaTag.TAG_TYPE_URL, ((WXWebpageObject) this.yuW.mediaObject).webpageUrl);
            }
            str = hz;
        }
        a.putExtra("reportSessionId", str);
        d.b(this, "sns", ".ui.SnsUploadUI", a, 1);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.SendAppMessageWrapperUI", "requestCode " + i + " resultCode " + i2);
        if (i == 1) {
            if (i2 == -1) {
                ReportUtil.a(this, ReportUtil.b(getIntent().getExtras(), 0));
            } else {
                ReportUtil.a(this, ReportUtil.b(getIntent().getExtras(), -2));
            }
            finish();
        } else if (i == 2 && i2 == -1) {
            WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) this.yuW.mediaObject;
            wXVideoFileObject.filePath = intent.getStringExtra("K_SEGMENTVIDEOPATH");
            if (bh.ov(wXVideoFileObject.filePath) || !com.tencent.mm.a.e.bO(wXVideoFileObject.filePath)) {
                setResult(-5);
                finish();
                return;
            }
            cyq();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.zpC) {
            x.d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
            SharedPreferences sharedPreferences = getSharedPreferences(ac.cfs(), 0);
            setRequestedOrientation(1);
            sharedPreferences.edit().putBoolean("settings_landscape_mode", false).commit();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        aWs();
        return super.onTouchEvent(motionEvent);
    }

    private o$a a(WXMediaMessage wXMediaMessage) {
        return new 3(this, wXMediaMessage);
    }

    private void a(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        String str;
        if (wXMediaMessage == null || !(wXMediaMessage.mediaObject instanceof WXImageObject)) {
            x.w("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg msg not img");
            str = null;
        } else {
            WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
            if (bh.bw(wXImageObject.imageData)) {
                str = wXImageObject.imagePath;
            } else {
                x.d("MicroMsg.SendAppMessageWrapperUI", "getImagePath fileData:" + wXImageObject.imageData.length);
                str = l.bb(wXImageObject.imageData);
            }
        }
        if (bh.ov(str)) {
            x.e("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg imgPath is null");
            return;
        }
        int i;
        String str2;
        if (com.tencent.mm.a.e.bN(str) > 26214400) {
            i = 0;
        } else {
            i = 1;
        }
        String str3 = this.zpB.field_appId;
        String str4 = wXMediaMessage.mediaTagName;
        String str5 = wXMediaMessage.messageExt;
        String str6 = wXMediaMessage.messageAction;
        if (bh.ov(str3)) {
            str2 = null;
        } else {
            str2 = "<msg>" + com.tencent.mm.aq.f.c(str3, str4, str5, str6) + "</msg>";
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ar.CG().a(new com.tencent.mm.aq.l(6, q.FS(), (String) it.next(), str, i, null, 0, str2, "", true, R.g.bAI), 0);
        }
    }

    private void b(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) wXMediaMessage.mediaObject;
        ((b) g.h(b.class)).qK(wXMiniProgramObject.userName);
        StringBuilder stringBuilder = new StringBuilder("1_");
        stringBuilder.append(this.zpB.field_appId);
        stringBuilder.append("_");
        ar.Hg();
        stringBuilder.append(o.getString(com.tencent.mm.z.c.Cg()));
        stringBuilder.append("_");
        stringBuilder.append(bh.Wo());
        stringBuilder.append("_");
        stringBuilder.append("1");
        String stringBuilder2 = stringBuilder.toString();
        WxaAttributes qK = ((b) g.h(b.class)).qK(wXMiniProgramObject.userName);
        if (!wXMiniProgramObject.withShareTicket) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                com.tencent.mm.y.g.a aVar = new com.tencent.mm.y.g.a();
                aVar.appId = this.zpB.field_appId;
                aVar.hdy = qK.field_appId;
                aVar.hdE = wXMiniProgramObject.miniprogramType;
                aVar.appName = this.zpB.field_appName;
                aVar.hbe = 2;
                l.a(aVar, wXMediaMessage, str);
            }
        } else if (qK == null) {
            x.e("MicroMsg.SendAppMessageWrapperUI", "get wxaAttributes for appbrand info failed");
            setResult(-1);
            finish();
            ReportUtil.a(this, ReportUtil.b(getIntent().getExtras(), -1));
            return;
        } else {
            com.tencent.mm.ae.b.a aVar2 = new com.tencent.mm.ae.b.a();
            aVar2.hmi = 1118;
            aVar2.uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_cas = new cas();
            com_tencent_mm_protocal_c_cas.fFm = qK.field_appId;
            com_tencent_mm_protocal_c_cas.xaa = linkedList;
            aVar2.hmj = com_tencent_mm_protocal_c_cas;
            aVar2.hmk = new cat();
            com.tencent.mm.ae.u.a(aVar2.JZ(), new 6(this, linkedList, qK, wXMiniProgramObject, stringBuilder2, wXMediaMessage));
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            int i = ((String) it2.next()).endsWith("chatroom") ? 1 : 0;
            String encode = com.tencent.mm.compatible.util.p.encode(bh.ou(wXMiniProgramObject.webpageUrl));
            stringBuilder2 = com.tencent.mm.compatible.util.p.encode(bh.ou(wXMediaMessage.title));
            String encode2 = com.tencent.mm.compatible.util.p.encode(bh.ou(wXMediaMessage.description));
            String encode3 = com.tencent.mm.compatible.util.p.encode(bh.ou(wXMiniProgramObject.path));
            com.tencent.mm.plugin.report.service.g.pQN.h(14127, new Object[]{this.zpB.field_appId, wXMiniProgramObject.userName, encode3, stringBuilder2, encode2, "", encode, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i), str});
        }
    }

    protected final void initView() {
    }

    protected final int getLayoutId() {
        return -1;
    }
}
