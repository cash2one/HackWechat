package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a$a;
import com.tencent.mm.protocal.c.amn;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.LinkedList;

class aa$1 implements a {
    final /* synthetic */ String fgU;
    final /* synthetic */ aa mWT;
    final /* synthetic */ a$a mWw;
    final /* synthetic */ Context val$context;

    aa$1(aa aaVar, a$a com_tencent_mm_plugin_game_gamewebview_jsapi_a_a, Context context, String str) {
        this.mWT = aaVar;
        this.mWw = com_tencent_mm_plugin_game_gamewebview_jsapi_a_a;
        this.val$context = context;
        this.fgU = str;
    }

    public final void a(int i, int i2, String str, b bVar) {
        x.i("MicroMsg.GameJsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        a$a com_tencent_mm_plugin_game_gamewebview_jsapi_a_a;
        aa aaVar;
        if (i == 0 && i2 == 0) {
            amn com_tencent_mm_protocal_c_amn = (amn) bVar.hmh.hmo;
            if (com_tencent_mm_protocal_c_amn == null || com_tencent_mm_protocal_c_amn.wte == null) {
                com_tencent_mm_plugin_game_gamewebview_jsapi_a_a = this.mWw;
                aaVar = this.mWT;
                com_tencent_mm_plugin_game_gamewebview_jsapi_a_a.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("loginfail", null));
                return;
            }
            int i3 = com_tencent_mm_protocal_c_amn.wte.fts;
            String str2 = com_tencent_mm_protocal_c_amn.wte.ftt;
            String str3 = com_tencent_mm_protocal_c_amn.wtg;
            x.i("MicroMsg.GameJsApiLogin", "NetSceneJSLogin jsErrcode %d", Integer.valueOf(i3));
            if (i3 == -12000) {
                LinkedList linkedList = com_tencent_mm_protocal_c_amn.whQ;
                x.d("MicroMsg.GameJsApiLogin", "appName %s, appIconUrl %s", com_tencent_mm_protocal_c_amn.niZ, com_tencent_mm_protocal_c_amn.vFW);
                ag.y(new 1(this, str3, linkedList, r4, r5));
                return;
            } else if (i3 == 0) {
                new HashMap().put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, com_tencent_mm_protocal_c_amn.wth);
                x.d("MicroMsg.GameJsApiLogin", "resp data code [%s]", r0);
                com_tencent_mm_plugin_game_gamewebview_jsapi_a_a = this.mWw;
                aaVar = this.mWT;
                com_tencent_mm_plugin_game_gamewebview_jsapi_a_a.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("loginok", null));
                return;
            } else {
                x.e("MicroMsg.GameJsApiLogin", "onSceneEnd NetSceneJSLogin %s", str2);
                com_tencent_mm_plugin_game_gamewebview_jsapi_a_a = this.mWw;
                aaVar = this.mWT;
                com_tencent_mm_plugin_game_gamewebview_jsapi_a_a.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("loginfail", null));
                return;
            }
        }
        com_tencent_mm_plugin_game_gamewebview_jsapi_a_a = this.mWw;
        aaVar = this.mWT;
        com_tencent_mm_plugin_game_gamewebview_jsapi_a_a.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("loginfail", null));
    }
}
