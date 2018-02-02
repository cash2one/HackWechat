package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.qq.wx.voice.embed.recognizer.b.a;
import com.qq.wx.voice.embed.recognizer.c;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.f;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.pluginsdk.e.a.b;
import com.tencent.mm.protocal.c.dc;
import com.tencent.mm.protocal.c.de;
import com.tencent.mm.protocal.c.dh;
import com.tencent.mm.protocal.c.di;
import com.tencent.mm.protocal.c.dj;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import com.tencent.wcdb.database.SQLiteDatabase;

public class ExtControlProviderVoiceControl extends ExtContentProviderBase implements e {
    private static final String[] lZI = new String[]{"retCode"};
    private Context context;
    private String[] lZV = null;
    private int lZW = -1;
    private long mbA;
    private long mbB;
    private long mbC;
    b mbD = new b();
    private long mbE = 0;
    private boolean mbF;
    private c mbG = new 5(this);
    private int mbz = 4;

    static /* synthetic */ void a(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        extControlProviderVoiceControl.mbF = false;
        extControlProviderVoiceControl.mbE = System.currentTimeMillis();
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl  hasInit:%s", new Object[]{Boolean.valueOf(ac.cft().getBoolean("hasInitVoiceControlData", true))});
        if (ac.cft().getBoolean("hasInitVoiceControlData", true)) {
            byte[] e = com.tencent.mm.a.e.e(str, 0, -1);
            com.qq.wx.voice.embed.recognizer.b bVar = a.bgn;
            int a = bVar.bgm.a(extControlProviderVoiceControl.mbG, e);
            x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "recognize ret:%s", new Object[]{Integer.valueOf(a)});
        }
    }

    static /* synthetic */ void c(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        Intent intent;
        if (f.jX(str)) {
            intent = new Intent();
            intent.putExtra("enterprise_biz_name", str);
            intent.putExtra("enterprise_biz_display_name", r.gu(str));
            d.a(extControlProviderVoiceControl.context, ".ui.conversation.EnterpriseConversationUI", intent);
        } else if (f.eE(str)) {
            intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.addFlags(67108864);
            intent.putExtra("biz_chat_from_scene", 7);
            d.a(extControlProviderVoiceControl.context, ".ui.bizchat.BizChatConversationUI", intent);
        } else if (f.jY(str)) {
            com.tencent.mm.ag.d jS = f.jS(str);
            String Li = jS == null ? null : jS.Li();
            if (Li == null) {
                Li = "";
            }
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", Li);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", str);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.addFlags(67108864);
            d.b(extControlProviderVoiceControl.context, "webview", ".ui.tools.WebViewUI", intent2);
        } else {
            intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
            com.tencent.mm.plugin.ext.a.ifs.e(intent, extControlProviderVoiceControl.context);
        }
    }

    public ExtControlProviderVoiceControl(String[] strArr, int i, Context context) {
        this.lZV = strArr;
        this.lZW = i;
        this.context = context;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", new Object[]{Integer.valueOf(this.lZW)});
        this.mbA = 0;
        this.mbB = 0;
        a(uri, this.context, this.lZW, this.lZV);
        if (uri == null) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
            cs(3, 5);
            return com.tencent.mm.pluginsdk.e.a.a.By(5);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (bh.ov(this.maf)) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
            cs(3, 7);
            return com.tencent.mm.pluginsdk.e.a.a.By(7);
        } else if (bh.ov(aFM())) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
            cs(3, 6);
            return com.tencent.mm.pluginsdk.e.a.a.By(6);
        } else {
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            long currentTimeMillis2 = System.currentTimeMillis() - System.currentTimeMillis();
            int aFN = aFN();
            if (aFN != 1) {
                x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = " + aFN);
                cs(2, aFN);
                return com.tencent.mm.pluginsdk.e.a.a.By(aFN);
            }
            x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2)});
            switch (this.lZW) {
                case 29:
                    x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
                    if (strArr2 == null || strArr2.length < 4) {
                        x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
                        cs(3, 3501);
                        this.mbz = 3501;
                        return com.tencent.mm.pluginsdk.e.a.a.By(3501);
                    }
                    String str3 = strArr2[0];
                    String str4 = strArr2[1];
                    String str5 = strArr2[2];
                    String str6 = strArr2[3];
                    String str7 = strArr2[4];
                    x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] args: %s, %s, %s, %s %s", new Object[]{str3, str4, str5, str6, str7});
                    if (bh.ov(str3) || bh.ov(str4) || bh.ov(str5) || bh.ov(str6) || bh.ov(str7)) {
                        cs(3, 3502);
                        x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
                        return com.tencent.mm.pluginsdk.e.a.a.By(3502);
                    } else if (com.tencent.mm.a.e.bO(str7)) {
                        this.mbA = System.currentTimeMillis();
                        ar.CG().a(985, this);
                        this.mbD.b(13000, new 1(this, str3, str7, str4, str5, str6));
                        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", new Object[]{Long.valueOf(this.mbB - this.mbA), Long.valueOf(System.currentTimeMillis() - this.mbB)});
                        ar.CG().b(985, this);
                        J(10, 0, 1);
                        if (1 != this.mbz) {
                            J(11, 4, 1);
                        } else {
                            J(10, 0, 1);
                        }
                        pp(0);
                        return com.tencent.mm.pluginsdk.e.a.a.By(this.mbz);
                    } else {
                        x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
                        cs(3, 3503);
                        return com.tencent.mm.pluginsdk.e.a.a.By(3503);
                    }
                default:
                    cs(3, 15);
                    return com.tencent.mm.pluginsdk.e.a.a.By(15);
            }
        }
    }

    public static boolean b(String str, int i, int i2, int i3, int i4, String str2) {
        String str3;
        byte[] e;
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "uploadVoiceStart ");
        if (i != 4) {
            str3 = str2 + ".speex";
            com.tencent.mm.e.c.d dVar = new com.tencent.mm.e.c.d();
            if (!com.tencent.mm.e.c.d.B(str2, str3)) {
                x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] decodePCMToSpeex error,pcmPath:%s,speexFilePath:%s", new Object[]{str2, str3});
                return false;
            }
        }
        str3 = str2;
        int bN = com.tencent.mm.a.e.bN(str3);
        dk dkVar = new dk();
        dkVar.vIE = 4;
        dkVar.vIF = 4;
        dkVar.vIG = i3;
        dkVar.vIH = i4;
        dj djVar = new dj();
        djVar.vIB = bN;
        djVar.vIC = 0;
        if (bN <= 16384) {
            djVar.vID = bN;
            e = com.tencent.mm.a.e.e(str3, 0, bN);
        } else {
            djVar.vID = 16384;
            e = com.tencent.mm.a.e.e(str3, 0, 16384);
        }
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(bN), Integer.valueOf(16384)});
        if (e == null || e.length <= 0) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
            return false;
        }
        di diVar = new di();
        diVar.vIz = dkVar;
        diVar.vIt = djVar;
        diVar.vIA = com.tencent.mm.bq.b.bc(e);
        int hashCode = (bh.Wp()).hashCode();
        ar.CG().a(new a(hashCode != Integer.MIN_VALUE ? Math.abs(hashCode) : Integer.MIN_VALUE, str, bN, str3, diVar), 0);
        return true;
    }

    private static boolean a(a aVar, int i, int i2) {
        if (aVar == null) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue netscene null");
            return false;
        } else if (aVar.mbR == null) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
            return false;
        } else if (aVar.mbR.vIt == null) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
            return false;
        } else {
            di diVar = new di();
            di diVar2 = aVar.mbR;
            diVar2.vIt.vIC = i;
            diVar2.vIt.vID = i2;
            byte[] e = com.tencent.mm.a.e.e(aVar.mbQ, i, i2);
            x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", new Object[]{Integer.valueOf(aVar.mbO), Integer.valueOf(i), Integer.valueOf(i2)});
            if (e == null || e.length <= 0) {
                x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", new Object[]{aVar.mbQ});
                return false;
            }
            diVar2.vIA = com.tencent.mm.bq.b.bc(e);
            k aVar2 = new a(aVar.mbO, aVar.appId, aVar.hlp, aVar.mbQ, diVar2);
            aVar2.hlq = aVar.hlq;
            ar.CG().a(aVar2, 0);
            return true;
        }
    }

    public final boolean a(int i, String str, com.tencent.mm.bq.b bVar) {
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", new Object[]{Integer.valueOf(i), str});
        if (this.mbB == 0) {
            this.mbB = System.currentTimeMillis();
        }
        this.mbC = System.currentTimeMillis();
        dc dcVar = new dc();
        dcVar.vIm = bVar;
        ar.CG().a(new a(i, str, dcVar, this.mbB), 0);
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
            this.mbz = 3506;
            this.mbD.countDown();
        } else if (i == 0 && i2 == 0) {
            x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", new Object[]{Integer.valueOf(kVar.getType())});
            if (kVar.getType() != 985) {
                return;
            }
            if (this.mbF) {
                x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
                return;
            }
            final a aVar = (a) kVar;
            a aVar2 = (a) kVar;
            final de deVar = (aVar2.gJQ == null || aVar2.gJQ.hmh.hmo == null) ? null : (de) aVar2.gJQ.hmh.hmo;
            if (deVar == null) {
                x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
                this.mbz = 3508;
                this.mbD.countDown();
                return;
            }
            aVar.mbP = deVar.vIm;
            String str2 = "MicroMsg.ext.ExtControlProviderVoiceControl";
            String str3 = "[voiceControl] opCode=%s, resp.Cookies=%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(aVar.fut);
            objArr[1] = deVar.vIm == null ? "null" : new String(deVar.vIm.oz);
            x.i(str2, str3, objArr);
            if ((aVar.fut == 1 ? 1 : null) == null) {
                if ((aVar.fut == 2 ? 1 : null) != null) {
                    Object obj;
                    x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
                    if (System.currentTimeMillis() - aVar.mbU > ((long) aVar.mbT)) {
                        x.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", new Object[]{Long.valueOf(System.currentTimeMillis() - aVar.mbU), Integer.valueOf(aVar.mbT)});
                        obj = 1;
                    } else {
                        x.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", new Object[]{Long.valueOf(System.currentTimeMillis() - aVar.mbU), Integer.valueOf(aVar.mbT)});
                        obj = null;
                    }
                    if (obj != null) {
                        this.mbz = 3509;
                        this.mbD.countDown();
                        return;
                    }
                    if (deVar.vIu != null) {
                        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", new Object[]{Integer.valueOf(deVar.vIu.vIn), Integer.valueOf(deVar.vIu.vIv)});
                    }
                    if (deVar.vIu == null || deVar.vIu.vIv != 0) {
                        if (System.currentTimeMillis() - this.mbC >= ((long) deVar.vIr)) {
                            ag.y(new 3(this, aVar));
                            return;
                        }
                        long currentTimeMillis = ((long) deVar.vIr) - (System.currentTimeMillis() - this.mbC);
                        if (currentTimeMillis > ((long) deVar.vIr)) {
                            currentTimeMillis = (long) deVar.vIr;
                        }
                        ag.h(new 4(this, aVar), currentTimeMillis);
                    } else if (deVar.vIu.vIw == null) {
                        x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
                        this.mbz = 3511;
                        this.mbD.countDown();
                    } else if (deVar.vIu.vIw.vIx == null || deVar.vIu.vIw.vIx.size() <= 0) {
                        x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
                        this.mbz = 3511;
                        this.mbD.countDown();
                    } else if (deVar.vIu.vIw.vIx.size() == 0) {
                        this.mbz = 3511;
                        this.mbD.countDown();
                    } else if (deVar.vIu.vIw.vIx.size() == 1) {
                        zG(((dh) deVar.vIu.vIw.vIx.get(0)).vIy);
                    } else {
                        String[] strArr = new String[deVar.vIu.vIw.vIx.size()];
                        for (int i3 = 0; i3 < strArr.length; i3++) {
                            strArr[i3] = ((dh) deVar.vIu.vIw.vIx.get(i3)).vIy;
                            x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", new Object[]{strArr[i3]});
                        }
                        Intent intent = new Intent();
                        intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
                        intent.putExtra("VoiceSearchResultUI_VoiceId", aVar.mbO);
                        intent.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
                        intent.setFlags(67108864);
                        intent.putExtra("VoiceSearchResultUI_ShowType", 1);
                        d.a(this.context, ".ui.voicesearch.VoiceSearchResultUI", intent);
                        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
                        this.mbz = 1;
                        this.mbD.countDown();
                    }
                }
            } else if (deVar.vIt == null) {
                x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
                this.mbz = 3508;
                this.mbD.countDown();
            } else {
                x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", new Object[]{Integer.valueOf(deVar.vIr), Integer.valueOf(deVar.vIs), Integer.valueOf(deVar.vIt.vIC), Integer.valueOf(deVar.vIt.vID)});
                if (deVar.vIt.vIC >= aVar.hlp) {
                    ag.h(new Runnable(this) {
                        final /* synthetic */ ExtControlProviderVoiceControl mbL;

                        public final void run() {
                            x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                            a aVar = aVar;
                            x.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", new Object[]{Integer.valueOf(deVar.vIs)});
                            aVar.mbT = r1;
                            this.mbL.a(aVar.mbO, aVar.appId, aVar.mbP);
                        }
                    }, (long) deVar.vIr);
                    return;
                }
                x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
                if (deVar.vIt.vIC == 0 || deVar.vIt.vIC != aVar.hlq) {
                    aVar.hlq = deVar.vIt.vIC;
                    if (deVar.vIt.vIC + deVar.vIt.vID < aVar.hlp) {
                        if (!a(aVar, deVar.vIt.vIC, deVar.vIt.vID)) {
                            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
                            this.mbz = 3510;
                            this.mbD.countDown();
                            return;
                        }
                        return;
                    } else if (!a(aVar, deVar.vIt.vIC, aVar.hlp - deVar.vIt.vIC)) {
                        x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
                        this.mbz = 3510;
                        this.mbD.countDown();
                        return;
                    } else {
                        return;
                    }
                }
                x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
            }
        } else {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
            this.mbz = 3507;
            this.mbD.countDown();
        }
    }

    private void zG(String str) {
        ar.Hg();
        af WO = com.tencent.mm.z.c.EY().WO(str);
        if (WO == null || !com.tencent.mm.l.a.fZ(WO.field_type)) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
            this.mbz = 3505;
            this.mbD.countDown();
            return;
        }
        com.tencent.mm.compatible.a.a.a(11, new 6(this, str));
        this.mbz = 1;
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", new Object[]{str});
        this.mbD.countDown();
    }
}
