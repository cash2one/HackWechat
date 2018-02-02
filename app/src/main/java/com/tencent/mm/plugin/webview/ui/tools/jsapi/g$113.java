package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.alw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;

class g$113 implements a {
    final /* synthetic */ String jdc;
    final /* synthetic */ Bundle jdd;
    final /* synthetic */ String jde;
    final /* synthetic */ String jdf;
    final /* synthetic */ String jdg;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$113(g gVar, i iVar, String str, Bundle bundle, String str2, String str3, String str4) {
        this.tIj = gVar;
        this.tIg = iVar;
        this.jdc = str;
        this.jdd = bundle;
        this.jdg = str2;
        this.jde = str3;
        this.jdf = str4;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.d("MicroMsg.MsgHandler", "on RunCgi callback errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            alw com_tencent_mm_protocal_c_alw = (alw) bVar.hmh.hmo;
            switch (com_tencent_mm_protocal_c_alw.fts) {
                case 0:
                    List y;
                    Object b;
                    boolean a;
                    Object com_tencent_mm_plugin_webview_ui_tools_jsapi_g_d = new g$d(new 1(this));
                    x.i("MicroMsg.MsgHandler", "launchApplication check result(showType : %d, errCode : %d)", Integer.valueOf(com_tencent_mm_protocal_c_alw.wsR), Integer.valueOf(com_tencent_mm_protocal_c_alw.fts));
                    if (!bh.ov(this.jdc)) {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.jdc));
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        y = bh.y(g.i(this.tIj), intent);
                        if (!(y == null || y.isEmpty())) {
                            if (TextUtils.isEmpty(intent.getPackage()) && y.size() == 1) {
                                b = g.b((ResolveInfo) y.get(0));
                            } else {
                                b = intent.getPackage();
                            }
                            if (!bh.ou(ac.getPackageName()).equals(b)) {
                                com_tencent_mm_plugin_webview_ui_tools_jsapi_g_d.cH(g.a(g.i(this.tIj), intent, null, com_tencent_mm_protocal_c_alw.wsR, com_tencent_mm_plugin_webview_ui_tools_jsapi_g_d, this.jdd));
                                return 0;
                            }
                        }
                    }
                    IMediaObject wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = this.jdg;
                    WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                    wXMediaMessage.sdkVer = 620823552;
                    wXMediaMessage.messageExt = this.jdg;
                    com.tencent.mm.sdk.b.b iqVar = new iq();
                    iqVar.fza.fzc = wXMediaMessage;
                    iqVar.fza.appId = this.jde;
                    iqVar.fza.showType = com_tencent_mm_protocal_c_alw.wsR;
                    iqVar.fza.context = g.i(this.tIj);
                    iqVar.fza.fqh = this.jdd;
                    iqVar.fza.fzd = com_tencent_mm_plugin_webview_ui_tools_jsapi_g_d;
                    com.tencent.mm.sdk.b.a.xef.m(iqVar);
                    boolean z = iqVar.fzb.fze;
                    if (!z) {
                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(this.jde + "://" + this.jdf));
                        x.i("MicroMsg.MsgHandler", "launchApplication by opensdk failed, try to launch by scheme(%s).", r0);
                        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        y = bh.y(g.i(this.tIj), intent2);
                        if (!(y == null || y.isEmpty())) {
                            if (TextUtils.isEmpty(intent2.getPackage()) && y.size() == 1) {
                                b = g.b((ResolveInfo) y.get(0));
                            } else {
                                b = intent2.getPackage();
                            }
                            if (!bh.ou(ac.getPackageName()).equals(b)) {
                                com_tencent_mm_plugin_webview_ui_tools_jsapi_g_d.hns = false;
                                com_tencent_mm_plugin_webview_ui_tools_jsapi_g_d.jdp = false;
                                com_tencent_mm_plugin_webview_ui_tools_jsapi_g_d.jdq = false;
                                com_tencent_mm_plugin_webview_ui_tools_jsapi_g_d.fze = false;
                                a = g.a(g.i(this.tIj), intent2, null, com_tencent_mm_plugin_webview_ui_tools_jsapi_g_d, this.jdd);
                                com_tencent_mm_plugin_webview_ui_tools_jsapi_g_d.cH(a);
                                return 0;
                            }
                        }
                    }
                    a = z;
                    com_tencent_mm_plugin_webview_ui_tools_jsapi_g_d.cH(a);
                    return 0;
                case 2:
                    g.a(this.tIj, this.tIg, "launchApplication:fail_check fail forbidden scene", null);
                    return 0;
                default:
                    g.a(this.tIj, this.tIg, "launchApplication:fail_check fail", null);
                    return 0;
            }
        }
        g.a(this.tIj, this.tIg, "launchApplication:fail_check fail", null);
        return 0;
    }
}
