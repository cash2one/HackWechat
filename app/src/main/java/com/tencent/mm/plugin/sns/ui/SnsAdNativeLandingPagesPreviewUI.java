package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.u;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.i$a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.protocal.c.adt;
import com.tencent.mm.protocal.c.adu;
import com.tencent.mm.protocal.c.xo;
import com.tencent.mm.protocal.c.xp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class SnsAdNativeLandingPagesPreviewUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("SnsAdNativeLandingPagesPreviewUI", "setFullScreen");
        getWindow().getAttributes();
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        getWindow().getDecorView().setSystemUiVisibility(5126);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Object stringExtra = intent.getStringExtra("sns_landing_pages_xml");
        int i = intent.hasExtra("sns_landing_pages_canvasid") ? 1 : 0;
        long longExtra = intent.getLongExtra("sns_landing_pages_pageid", 0);
        String stringExtra2 = intent.getStringExtra("sns_landing_pages_canvasid");
        String stringExtra3 = intent.getStringExtra("sns_landing_pages_canvas_ext");
        if (TextUtils.isEmpty(stringExtra)) {
            if (intent.getIntExtra("sns_landing_pages_no_store", 0) != 1) {
                if (i == 1) {
                    stringExtra = i.bxQ().l(stringExtra2, stringExtra3, 0, 0);
                } else {
                    stringExtra = i.bxQ().h(longExtra, 0, 0);
                }
                intent.putExtra("sns_landing_pages_xml", stringExtra);
            }
        } else if (!f(intent, stringExtra)) {
            finish();
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            b bVar;
            View findViewById = findViewById(f.cEd);
            findViewById.setVisibility(0);
            b.a aVar = new b.a();
            b JZ;
            if (i == 0 && longExtra > 0) {
                x.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, pageId:%d", new Object[]{Long.valueOf(longExtra)});
                aVar.hmj = new xo();
                aVar.hmk = new xp();
                aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
                aVar.hmi = 1286;
                JZ = aVar.JZ();
                ((xo) JZ.hmg.hmo).wig = longExtra;
                bVar = JZ;
            } else if (i != 1 || bh.ov(stringExtra2)) {
                x.e("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, or pageId!");
                finish();
                return;
            } else {
                x.i("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, canvasId:%s", new Object[]{stringExtra2});
                aVar.hmj = new adt();
                aVar.hmk = new adu();
                aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
                aVar.hmi = 1890;
                JZ = aVar.JZ();
                adt com_tencent_mm_protocal_c_adt = (adt) JZ.hmg.hmo;
                com_tencent_mm_protocal_c_adt.wmk = stringExtra2;
                com_tencent_mm_protocal_c_adt.wml = stringExtra3;
                bVar = JZ;
            }
            u.a(bVar, new 1(this, findViewById, i, stringExtra2, stringExtra3, longExtra, intent));
        } else if (!g(intent, stringExtra)) {
            finish();
        }
    }

    private static boolean f(Intent intent, String str) {
        if (!bh.ov(str) && ac.Lc(str)) {
            String Ld = ac.Ld(str);
            if (bh.ov(Ld)) {
                return false;
            }
            intent.putExtra("sns_landing_pages_xml", "");
            intent.putExtra("sns_landing_pages_too_large_xml_path", Ld);
        }
        return true;
    }

    private boolean g(Intent intent, String str) {
        if (e.Lg(str)) {
            intent.setClass(this, SnsAdNativeLandingPagesUI.class);
            startActivity(intent);
            finish();
            if (intent.getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false)) {
                overridePendingTransition(0, 0);
                return true;
            }
            overridePendingTransition(i$a.bqB, i$a.bqA);
            return true;
        }
        x.i("SnsAdNativeLandingPagesPreviewUI", "unknown canvas goto webview, " + str);
        int indexOf = str.indexOf("<shareWebUrl>");
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf("</shareWebUrl>");
            if (indexOf2 > indexOf + 13) {
                String substring = str.substring(indexOf + 13, indexOf2);
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", substring);
                intent2.putExtra("showShare", true);
                d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
                finish();
                overridePendingTransition(i$a.bqB, i$a.bqA);
                return true;
            }
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.qGX;
    }
}
