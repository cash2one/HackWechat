package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.plugin.webview.stub.WebViewStubService.1;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

class WebViewStubService$1$1 implements Runnable {
    final /* synthetic */ Bundle fhp;
    final /* synthetic */ int tvF;
    final /* synthetic */ int tvG;
    final /* synthetic */ 1 tvH;

    WebViewStubService$1$1(1 1, int i, Bundle bundle, int i2) {
        this.tvH = 1;
        this.tvF = i;
        this.fhp = bundle;
        this.tvG = i2;
    }

    public final void run() {
        int i;
        int i2;
        Intent intent;
        String str;
        Bundle bundle;
        switch (this.tvF) {
            case 1:
                WebViewStubService.a(this.tvH.tvE, 2, this.fhp, this.tvG);
                return;
            case 2:
                u.fI(this.tvH.tvE);
                return;
            case 3:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("stat_scene", 4);
                g Be = h.Be(this.tvG);
                if (Be != null) {
                    bundle2.putString("stat_url", Be.aeq());
                }
                1.a(this.tvH, this.fhp, bundle2);
                return;
            case 4:
                WebViewStubService.a(this.tvH.tvE, 3, this.fhp, this.tvG);
                return;
            case 5:
                i = this.fhp.getInt("scene_end_type", 0);
                i2 = this.fhp.getInt("scene_end_listener_hash_code", -1);
                if (i2 != -1) {
                    WebViewStubService.a(this.tvH.tvE).add(Integer.valueOf(i2));
                }
                x.i("MicroMsg.WebViewStubService", "add Scene end, hashCode:[%d], set size:[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(WebViewStubService.a(this.tvH.tvE).size())});
                if (i > 0) {
                    WebViewStubService.b(this.tvH.tvE);
                    x.i("MicroMsg.WebViewStubService", "real add Scene end, hashCode:[%d]", new Object[]{Integer.valueOf(i2)});
                    ar.CG().a(233, this.tvH.tvE);
                    ar.CG().a(673, this.tvH.tvE);
                    ar.CG().a(666, this.tvH.tvE);
                    ar.CG().a(1254, this.tvH.tvE);
                    ar.CG().a(1373, this.tvH.tvE);
                    return;
                }
                return;
            case 6:
                i = this.fhp.getInt("scene_end_type", 0);
                i2 = this.fhp.getInt("scene_end_listener_hash_code", -1);
                if (i2 != -1) {
                    WebViewStubService.a(this.tvH.tvE).remove(Integer.valueOf(i2));
                }
                x.i("MicroMsg.WebViewStubService", "remove Scene end, hashCode:[%d], set size:[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(WebViewStubService.a(this.tvH.tvE).size())});
                if (i > 0) {
                    WebViewStubService.c(this.tvH.tvE);
                    if (WebViewStubService.d(this.tvH.tvE) <= 0 && WebViewStubService.a(this.tvH.tvE).size() <= 0) {
                        x.i("MicroMsg.WebViewStubService", "real remove Scene end, hashCode:[%d]", new Object[]{Integer.valueOf(i2)});
                        if (ar.Hj()) {
                            ar.CG().b(233, this.tvH.tvE);
                            ar.CG().b(673, this.tvH.tvE);
                            ar.CG().b(666, this.tvH.tvE);
                            ar.CG().b(1254, this.tvH.tvE);
                            ar.CG().b(1373, this.tvH.tvE);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 7:
                intent = new Intent();
                intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_ENTER_ANIMATION, 0);
                intent.putExtra(com.tencent.mm.ui.u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                a.ifs.u(intent, this.tvH.tvE);
                return;
            case 8:
                intent = new Intent();
                intent.putExtras(this.fhp);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                a.ifs.v(intent, this.tvH.tvE);
                return;
            case 20:
                this.fhp.setClassLoader(getClass().getClassLoader());
                h.Be(this.tvG).tHs = this.fhp.getBundle("jsapiargs");
                str = (String) this.fhp.getCharSequence("bizofstartfrom");
                bundle = this.fhp.getBundle("startwebviewparams");
                if (!(str == null || bundle == null)) {
                    b klVar = new kl();
                    klVar.fBJ.fBK = str;
                    klVar.fBJ.fBL = bundle;
                    com.tencent.mm.sdk.b.a.xef.m(klVar);
                }
                WebViewStubService.a(this.tvH.tvE, this.fhp.getInt("screen_orientation", -1));
                return;
            case 21:
                h.Be(this.tvG).bUv().putAll(this.fhp);
                return;
            case 29:
                str = this.fhp.getString("srcUsername");
                y.Mf();
                e.jP(str);
                y.Mf();
                e.jQ(str);
                y.Mo();
                if (!bh.ov(str) && f.jY(str)) {
                    y.Mo().b(str, null);
                    return;
                }
                return;
            case 30:
                str = this.fhp.getString("srcUsername");
                y.Mf();
                e.jR(str);
                y.Mo();
                if (!bh.ov(str) && f.jY(str)) {
                    y.Mo();
                    k.kd(str);
                    return;
                }
                return;
            case 41:
                if (ar.Hj()) {
                    g Be2 = h.Be(this.tvG);
                    bundle = this.fhp;
                    if (Be2.tIe != null) {
                        if (bundle == null || bundle.size() <= 0) {
                            Be2.a(Be2.fBH, Be2.tIe, "showKeyboard:fail", null, true, true);
                        } else {
                            Map hashMap = new HashMap();
                            hashMap.put("text", bh.ou(bundle.getString("show_kb_input_callback_text")));
                            Be2.a(Be2.fBH, Be2.tIe, "showKeyboard:ok", hashMap, true, true);
                        }
                        Be2.tIe = null;
                        return;
                    }
                    return;
                }
                return;
            default:
                x.e("MicroMsg.WebViewStubService", "not support action code:[%d]", new Object[]{Integer.valueOf(this.tvF)});
                return;
        }
    }
}
