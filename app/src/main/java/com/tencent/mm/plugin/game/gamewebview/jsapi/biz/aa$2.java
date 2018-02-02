package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a$a;
import com.tencent.mm.protocal.c.aml;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

class aa$2 implements a {
    final /* synthetic */ int iTc;
    final /* synthetic */ aa mWT;
    final /* synthetic */ a$a mWw;

    aa$2(aa aaVar, a$a com_tencent_mm_plugin_game_gamewebview_jsapi_a_a, int i) {
        this.mWT = aaVar;
        this.mWw = com_tencent_mm_plugin_game_gamewebview_jsapi_a_a;
        this.iTc = i;
    }

    public final void a(int i, int i2, String str, b bVar) {
        x.i("MicroMsg.GameJsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        a$a com_tencent_mm_plugin_game_gamewebview_jsapi_a_a;
        aa aaVar;
        if (i != 0 || i2 != 0) {
            com_tencent_mm_plugin_game_gamewebview_jsapi_a_a = this.mWw;
            aaVar = this.mWT;
            com_tencent_mm_plugin_game_gamewebview_jsapi_a_a.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("loginfail", null));
        } else if (this.iTc == 2) {
            x.d("MicroMsg.GameJsApiLogin", "press reject button");
            com_tencent_mm_plugin_game_gamewebview_jsapi_a_a = this.mWw;
            aaVar = this.mWT;
            com_tencent_mm_plugin_game_gamewebview_jsapi_a_a.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("loginfail", null));
        } else {
            aml com_tencent_mm_protocal_c_aml = (aml) bVar.hmh.hmo;
            if (com_tencent_mm_protocal_c_aml == null || com_tencent_mm_protocal_c_aml.wte == null) {
                com_tencent_mm_plugin_game_gamewebview_jsapi_a_a = this.mWw;
                aaVar = this.mWT;
                com_tencent_mm_plugin_game_gamewebview_jsapi_a_a.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("loginfail", null));
                return;
            }
            int i3 = com_tencent_mm_protocal_c_aml.wte.fts;
            String str2 = com_tencent_mm_protocal_c_aml.wte.ftt;
            x.i("MicroMsg.GameJsApiLogin", "jsErrcode = %d", Integer.valueOf(i3));
            if (i3 == 0) {
                new HashMap().put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, com_tencent_mm_protocal_c_aml.wth);
                a$a com_tencent_mm_plugin_game_gamewebview_jsapi_a_a2 = this.mWw;
                aa aaVar2 = this.mWT;
                com_tencent_mm_plugin_game_gamewebview_jsapi_a_a2.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("loginok", null));
                x.d("MicroMsg.GameJsApiLogin", "resp data code [%s]", r0);
                return;
            }
            com_tencent_mm_plugin_game_gamewebview_jsapi_a_a = this.mWw;
            aaVar = this.mWT;
            com_tencent_mm_plugin_game_gamewebview_jsapi_a_a.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("loginfail", null));
            x.e("MicroMsg.GameJsApiLogin", "errMsg = %s", str2);
        }
    }
}
