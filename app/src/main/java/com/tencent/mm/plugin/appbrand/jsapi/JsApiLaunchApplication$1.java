package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUI;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.LaunchApplicationTask;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.alw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.List;

class JsApiLaunchApplication$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ String jdc;
    final /* synthetic */ Bundle jdd;
    final /* synthetic */ String jde;
    final /* synthetic */ String jdf;
    final /* synthetic */ String jdg;
    final /* synthetic */ JsApiLaunchApplication jdh;

    JsApiLaunchApplication$1(JsApiLaunchApplication jsApiLaunchApplication, j jVar, int i, String str, Bundle bundle, String str2, String str3, String str4) {
        this.jdh = jsApiLaunchApplication;
        this.iZy = jVar;
        this.gOK = i;
        this.jdc = str;
        this.jdd = bundle;
        this.jde = str2;
        this.jdf = str3;
        this.jdg = str4;
    }

    public final void a(int i, int i2, String str, b bVar) {
        x.i("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            alw com_tencent_mm_protocal_c_alw = (alw) bVar.hmh.hmo;
            switch (com_tencent_mm_protocal_c_alw.fts) {
                case 0:
                    JsApiLaunchApplication.a aVar = new JsApiLaunchApplication.a(new 1(this));
                    x.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_alw.wsR), Integer.valueOf(com_tencent_mm_protocal_c_alw.fts)});
                    if (!bh.ov(this.jdc)) {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.jdc));
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        List y = bh.y(this.iZy.getContext(), intent);
                        if (!(y == null || y.isEmpty())) {
                            Object b;
                            if (TextUtils.isEmpty(intent.getPackage()) && y.size() == 1) {
                                b = g.b((ResolveInfo) y.get(0));
                            } else {
                                b = intent.getPackage();
                            }
                            if (!bh.ou(ac.getPackageName()).equals(b)) {
                                ag.y(new 2(this, intent, com_tencent_mm_protocal_c_alw, aVar));
                                return;
                            }
                        }
                    }
                    AppBrandProxyTransparentUIProcessTask launchApplicationTask = new LaunchApplicationTask((MMActivity) this.iZy.getContext());
                    launchApplicationTask.appId = this.jde;
                    launchApplicationTask.jdm = this.jdf;
                    launchApplicationTask.extInfo = this.jdg;
                    launchApplicationTask.fqh = this.jdd;
                    launchApplicationTask.showType = com_tencent_mm_protocal_c_alw.wsR;
                    launchApplicationTask.jcI = new 3(this, launchApplicationTask);
                    launchApplicationTask.afi();
                    if (launchApplicationTask.mContext != null) {
                        AppBrandProxyTransparentUIProcessTask.jaM.put(launchApplicationTask.jbo, new WeakReference(launchApplicationTask));
                        Intent intent2 = new Intent();
                        intent2.setClass(launchApplicationTask.mContext, AppBrandProxyTransparentUI.class);
                        intent2.putExtra("task_object", launchApplicationTask);
                        intent2.putExtra("task_class_name", launchApplicationTask.getClass().getName());
                        intent2.putExtra("task_id", launchApplicationTask.jbo);
                        intent2.putExtra("orientation", launchApplicationTask.jbm);
                        if (launchApplicationTask.mContext instanceof MMActivity) {
                            launchApplicationTask.afi();
                            ((MMActivity) launchApplicationTask.mContext).jwN = launchApplicationTask.jbn;
                            ((MMActivity) launchApplicationTask.mContext).startActivityForResult(intent2, launchApplicationTask.hashCode() & 65535);
                            return;
                        }
                        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        launchApplicationTask.mContext.startActivity(intent2);
                        return;
                    }
                    return;
                case 2:
                    this.iZy.E(this.gOK, this.jdh.e("fail:check fail forbidden scene 2", null));
                    return;
                default:
                    this.iZy.E(this.gOK, this.jdh.e("fail:check fail 1", null));
                    return;
            }
        }
        this.iZy.E(this.gOK, this.jdh.e("fail:check fail", null));
    }
}
