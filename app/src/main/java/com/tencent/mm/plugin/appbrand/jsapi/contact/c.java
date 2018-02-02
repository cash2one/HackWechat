package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.c.agf;
import com.tencent.mm.protocal.c.agg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 145;
    public static final String NAME = "enterContact";
    public static int jfv = 0;
    private p jgr;
    private String jiL;
    private String jiM;
    private String jiN;
    private String jiO;
    private boolean jiP;
    private int jiQ = 1;
    private String sessionFrom;

    public final void a(p pVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            pVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiEnterContact", "data is null");
            return;
        }
        x.i("MicroMsg.JsApiEnterContact", "enterContact appId:%s, data:%s", pVar.mAppId, jSONObject.toString());
        this.jgr = pVar;
        this.sessionFrom = jSONObject.optString("sessionFrom");
        this.jiL = jSONObject.optString("businessId");
        this.jiM = jSONObject.optString("sendMessageTitle");
        this.jiN = jSONObject.optString("sendMessagePath");
        this.jiO = jSONObject.optString("sendMessageImg");
        this.jiP = jSONObject.optBoolean("showMessageCard", false);
        this.jiQ = 1;
        if (this.sessionFrom.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            this.sessionFrom = this.sessionFrom.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            x.i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
        }
        if (this.jiP) {
            if (s.eE(this.jiO, "http://") || s.eE(this.jiO, "https://")) {
                this.jiQ = 4;
            } else if (!bh.ov(this.jiO) && this.jiO.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(pVar.mAppId, this.jiO);
                if (!(itemByLocalId == null || TextUtils.isEmpty(itemByLocalId.hhZ))) {
                    this.jiO = itemByLocalId.hhZ;
                    this.jiQ = 2;
                }
            } else if (!bh.ov(this.jiO)) {
                Bitmap j = o.j(pVar.irP, this.jiO);
                if (j != null) {
                    this.jiO = AppBrandLocalMediaObjectManager.genMediaFilePath(pVar.mAppId, "share_" + System.currentTimeMillis());
                    try {
                        d.a(j, 100, CompressFormat.PNG, this.jiO, true);
                        this.jiQ = 3;
                        if (!(j == null || j.isRecycled())) {
                            j.recycle();
                        }
                    } catch (IOException e) {
                        x.w("MicroMsg.JsApiEnterContact", "save temp bitmap to file failed, . exception : %s", e);
                        if (!(j == null || j.isRecycled())) {
                            j.recycle();
                        }
                    } catch (Exception e2) {
                        x.w("MicroMsg.JsApiEnterContact", "save temp bitmap to file failed, . exception : %s", e2);
                        if (!(j == null || j.isRecycled())) {
                            j.recycle();
                        }
                    } catch (Throwable th) {
                        if (!(j == null || j.isRecycled())) {
                            j.recycle();
                        }
                    }
                }
            }
            if (this.jiP && this.jiQ == 1) {
                this.jiO = AppBrandLocalMediaObjectManager.genMediaFilePath(pVar.mAppId, "share_" + System.currentTimeMillis());
                com.tencent.mm.plugin.appbrand.c.a(pVar.mAppId, new 1(this, pVar));
            }
        }
        if (TextUtils.isEmpty(this.jiL)) {
            x.i("MicroMsg.JsApiEnterContact", "businessId is empty, enter to chatting");
            aA("", i);
            return;
        }
        x.i("MicroMsg.JsApiEnterContact", "do GetSubBusinessInfo cgi");
        b.a aVar = new b.a();
        aVar.hmj = new agf();
        aVar.hmk = new agg();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
        aVar.hmi = 1303;
        aVar.hml = 0;
        aVar.hmm = 0;
        b JZ = aVar.JZ();
        agf com_tencent_mm_protocal_c_agf = (agf) JZ.hmg.hmo;
        AppBrandSysConfig appBrandSysConfig = pVar.irP.iqx;
        if (appBrandSysConfig != null) {
            com_tencent_mm_protocal_c_agf.username = appBrandSysConfig.fnl;
            x.i("MicroMsg.JsApiEnterContact", "req.username:%s", com_tencent_mm_protocal_c_agf.username);
        } else {
            x.e("MicroMsg.JsApiEnterContact", "getSysConfig is null, username is empty");
        }
        com_tencent_mm_protocal_c_agf.wnF = this.jiL;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(JZ, new 2(this, pVar, i));
    }

    private void aA(String str, final int i) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        final WxaExposedParams.a aVar = new WxaExposedParams.a();
        if (this.jgr.jDS != null) {
            str4 = this.jgr.jDS.jET;
        }
        AppBrandSysConfig appBrandSysConfig = this.jgr.irP.iqx;
        if (appBrandSysConfig != null) {
            str2 = appBrandSysConfig.fnl;
            str3 = appBrandSysConfig.frn;
            aVar.appId = this.jgr.mAppId;
            aVar.username = appBrandSysConfig.fnl;
            aVar.fpL = appBrandSysConfig.frn;
            aVar.iconUrl = appBrandSysConfig.iOg;
            aVar.iGK = appBrandSysConfig.iOI.iGK;
            aVar.iGL = appBrandSysConfig.iOI.iGL;
            aVar.iPL = appBrandSysConfig.iOI.fqR;
            aVar.fqe = 5;
            aVar.fCp = str4;
            aVar.iPM = l.pr(this.jgr.mAppId);
        }
        str4 = str3;
        str3 = str2;
        if (bh.ov(str3)) {
            x.e("MicroMsg.JsApiEnterContact", "onInsertView username is empty!!!");
        }
        final MainProcessTask jsApiChattingTask = new JsApiChattingTask();
        if (TextUtils.isEmpty(str)) {
            jsApiChattingTask.username = str3;
            jsApiChattingTask.fpL = str4;
        } else {
            jsApiChattingTask.username = str;
            jsApiChattingTask.fpL = "";
        }
        jsApiChattingTask.sessionFrom = this.sessionFrom;
        jsApiChattingTask.jcI = new Runnable(this) {
            final /* synthetic */ c jiR;

            public final void run() {
                x.i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
                Intent intent = new Intent();
                intent.setFlags(67108864);
                intent.putExtra("Chat_User", jsApiChattingTask.username);
                intent.putExtra("app_brand_chatting_from_scene", 2);
                intent.putExtra("app_brand_chatting_expose_params", aVar.ace());
                intent.putExtra("key_temp_session_from", jsApiChattingTask.sessionFrom);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                if (this.jiR.jiP) {
                    intent.putExtra("sendMessageTitle", this.jiR.jiM);
                    intent.putExtra("sendMessagePath", this.jiR.jiN);
                    intent.putExtra("sendMessageImg", this.jiR.jiO);
                    intent.putExtra("isBitmapFrom", this.jiR.jiQ);
                }
                intent.putExtra("showMessageCard", this.jiR.jiP);
                MMActivity mMActivity = (MMActivity) this.jiR.jgr.mContext;
                if (mMActivity == null) {
                    this.jiR.jgr.E(i, this.jiR.e("fail", null));
                    x.e("MicroMsg.JsApiEnterContact", "mmActivity is null, invoke fail!");
                    return;
                }
                mMActivity.jwN = new 1(this);
                com.tencent.mm.bm.d.a(this.jiR.jgr.mContext, ".ui.chatting.AppBrandServiceChattingUI", intent, 1);
                if (c.jfv > 0) {
                    c.jfv--;
                    this.jiR.jgr.irP.YE();
                }
                if (c.jfv == 0) {
                    c.jfv++;
                    this.jiR.jgr.irP.YD();
                }
                com.tencent.mm.plugin.appbrand.c.a(this.jiR.jgr.mAppId, new 2(this));
                x.i("MicroMsg.JsApiEnterContact", "doEnterChatting lockCount:%d", Integer.valueOf(c.jfv));
            }
        };
        jsApiChattingTask.afi();
        AppBrandMainProcessService.a(jsApiChattingTask);
    }
}
