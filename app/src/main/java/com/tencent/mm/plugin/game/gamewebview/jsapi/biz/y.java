package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import org.json.JSONObject;

public final class y extends a {
    public static final int CTRL_BYTE = 52;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "launch3rdApp";

    public final void a(Context context, String str, final GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiLaunchApplication", "invoke");
        JSONObject sc = d.sc(str);
        if (sc == null) {
            aVar.sj(a.e("launch_3rdApp:invalid_data", null));
            return;
        }
        int optInt = sc.optInt(DownloadSettingTable$Columns.TYPE);
        String optString = sc.optString("appID");
        String optString2;
        if (optInt == 0) {
            optString2 = sc.optString("extInfo");
            x.i("MicroMsg.GameJsApiLaunchApplication", "appid:[%s], extinfo:[%s]", new Object[]{optString, optString2});
            if (bh.ov(optString)) {
                x.e("MicroMsg.GameJsApiLaunchApplication", "appid is null or nil");
                aVar.sj(a.e("launch_3rdApp:fail", null));
            } else if (com.tencent.mm.plugin.webview.a.a.ift.m(ac.getContext(), optString)) {
                IMediaObject wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = optString2;
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                wXMediaMessage.sdkVer = 620823552;
                wXMediaMessage.messageExt = optString2;
                b iqVar = new iq();
                iqVar.fza.fzc = wXMediaMessage;
                iqVar.fza.appId = optString;
                iqVar.fza.context = context;
                iqVar.fza.fzd = new g.a(this) {
                    final /* synthetic */ y mWN;

                    public final void cG(boolean z) {
                        GameJsApiMMTask.a aVar = aVar;
                        y yVar = this.mWN;
                        aVar.sj(a.e("launch_3rdApp:ok", null));
                    }
                };
                com.tencent.mm.sdk.b.a.xef.m(iqVar);
            } else {
                x.e("MicroMsg.GameJsApiLaunchApplication", "app is not installed, appid:[%s]", new Object[]{optString});
                aVar.sj(a.e("launch_3rdApp:fail", null));
            }
        } else if (optInt == 1) {
            String optString3 = sc.optString("signature");
            optString = sc.optString(DownloadInfoColumns.PACKAGENAME);
            x.i("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{optString3, optString, sc.optString("param")});
            if (bh.ov(optString3) || bh.ov(optString)) {
                x.e("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp invalid_args");
                aVar.sj(a.e("launch_3rdApp:fail_invalid_args", null));
            } else if (p.m(context, optString)) {
                Signature[] aX = p.aX(context, optString);
                if (!(aX == null || aX[0] == null)) {
                    String s = com.tencent.mm.a.g.s(aX[0].toByteArray());
                    if (s != null && s.equalsIgnoreCase(optString3)) {
                        optString3 = sc.optString("current_url");
                        optString2 = sc.optString("current_appid");
                        try {
                            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(optString);
                            if (launchIntentForPackage != null) {
                                Bundle bundle = new Bundle();
                                p.g(bundle, r3);
                                launchIntentForPackage.putExtras(bundle);
                                launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("current_page_url", optString3);
                                bundle2.putString("current_page_appid", optString2);
                                g.a(context, launchIntentForPackage, null, new 2(this, aVar), bundle2);
                                return;
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[]{e.getMessage()});
                        }
                        aVar.sj(a.e("launch_3rdApp:fail", null));
                        return;
                    }
                }
                x.e("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp signature_mismatch");
                aVar.sj(a.e("launch_3rdApp:fail_signature_mismatch", null));
            } else {
                x.e("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp not_install");
                aVar.sj(a.e("launch_3rdApp:fail_not_install", null));
            }
        } else {
            aVar.sj(a.e("launch_3rdApp:fail_invalid_type", null));
        }
    }
}
