package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a$a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication.LaunchApplicationTask;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.alw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;

class GameJsApiLaunchApplication$2 implements a {
    final /* synthetic */ String jdc;
    final /* synthetic */ Bundle jdd;
    final /* synthetic */ String jde;
    final /* synthetic */ String jdg;
    final /* synthetic */ MMActivity jvm;
    final /* synthetic */ GameJsApiLaunchApplication mWO;
    final /* synthetic */ a$a mWw;

    GameJsApiLaunchApplication$2(GameJsApiLaunchApplication gameJsApiLaunchApplication, a$a com_tencent_mm_plugin_game_gamewebview_jsapi_a_a, String str, MMActivity mMActivity, Bundle bundle, String str2, String str3) {
        this.mWO = gameJsApiLaunchApplication;
        this.mWw = com_tencent_mm_plugin_game_gamewebview_jsapi_a_a;
        this.jdc = str;
        this.jvm = mMActivity;
        this.jdd = bundle;
        this.jde = str2;
        this.jdg = str3;
    }

    public final void a(int i, int i2, String str, b bVar) {
        x.d("MicroMsg.GameJsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        a$a com_tencent_mm_plugin_game_gamewebview_jsapi_a_a;
        GameJsApiLaunchApplication gameJsApiLaunchApplication;
        if (i == 0 && i2 == 0) {
            alw com_tencent_mm_protocal_c_alw = (alw) bVar.hmh.hmo;
            switch (com_tencent_mm_protocal_c_alw.fts) {
                case 0:
                    if (!bh.ov(this.jdc)) {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.jdc));
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        List y = bh.y(this.jvm, intent);
                        if (!(y == null || y.isEmpty())) {
                            Object b;
                            if (TextUtils.isEmpty(intent.getPackage()) && y.size() == 1) {
                                b = g.b((ResolveInfo) y.get(0));
                            } else {
                                b = intent.getPackage();
                            }
                            if (!bh.ou(ac.getPackageName()).equals(b)) {
                                g.a(this.jvm, intent, null, com_tencent_mm_protocal_c_alw.wsR, new 1(this), this.jdd);
                                return;
                            }
                        }
                    }
                    LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask(this.jvm);
                    launchApplicationTask.appId = this.jde;
                    launchApplicationTask.extInfo = this.jdg;
                    launchApplicationTask.fqh = this.jdd;
                    launchApplicationTask.showType = com_tencent_mm_protocal_c_alw.wsR == 1 ? 1 : 0;
                    launchApplicationTask.jcI = new 2(this, launchApplicationTask);
                    launchApplicationTask.aKE();
                    return;
                case 2:
                    com_tencent_mm_plugin_game_gamewebview_jsapi_a_a = this.mWw;
                    gameJsApiLaunchApplication = this.mWO;
                    com_tencent_mm_plugin_game_gamewebview_jsapi_a_a.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("launchApplication:fail_check fail forbidden scene", null));
                    return;
                default:
                    com_tencent_mm_plugin_game_gamewebview_jsapi_a_a = this.mWw;
                    gameJsApiLaunchApplication = this.mWO;
                    com_tencent_mm_plugin_game_gamewebview_jsapi_a_a.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("launchApplication:fail_check fail", null));
                    return;
            }
        }
        com_tencent_mm_plugin_game_gamewebview_jsapi_a_a = this.mWw;
        gameJsApiLaunchApplication = this.mWO;
        com_tencent_mm_plugin_game_gamewebview_jsapi_a_a.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("launchApplication:fail_check fail", null));
    }
}
