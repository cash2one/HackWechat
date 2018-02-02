package com.tencent.mm.ui.chatting.e;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.p.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.a.b$e;
import com.tencent.mm.z.s;

public final class a extends b {
    private int jRy = -1;
    private c yHa;

    static /* synthetic */ void a(a aVar, a aVar2) {
        boolean z;
        boolean eV = s.eV(aVar.jRw);
        x.i("MicroMsg.AppBrandHistoryListPresenter", "username: %s , appid %s ,pkgType : %s", new Object[]{aVar2.fEt.hdx, aVar2.hdy, Integer.valueOf(aVar2.fEt.hdE)});
        String str = aVar.jRw;
        String str2 = aVar2.username;
        Bundle bundle = new Bundle();
        bundle.putInt("stat_scene", 9);
        bundle.putString("stat_msg_id", "msg_" + Long.toString(aVar2.fFo));
        bundle.putString("stat_chat_talker_username", str);
        bundle.putString("stat_send_msg_user", str2);
        switch (aVar2.fEt.hdz) {
            case 1:
                Intent intent = new Intent();
                intent.putExtra("key_username", aVar2.fEt.hdx);
                if (eV) {
                    intent.putExtra("key_from_scene", 1);
                    intent.putExtra("key_scene_note", str + ":" + str2);
                } else {
                    intent.putExtra("key_from_scene", 2);
                    intent.putExtra("key_scene_note", str);
                }
                intent.putExtra("_stat_obj", bundle);
                com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar3 = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
                aVar3.appId = aVar2.hdy;
                aVar3.fqe = 6;
                aVar3.iGK = aVar2.fEt.hdE;
                aVar3.iGL = aVar2.fEt.hdB;
                intent.putExtra("key_scene_exposed_params", aVar3.ace());
                d.b(aVar.mContext, "appbrand", ".ui.AppBrandProfileUI", intent);
                z = false;
                break;
            case 2:
                com.tencent.mm.modelappbrand.a.a(str, str2, eV, aVar2.fEt, bundle);
                z = false;
                break;
            case 3:
                com.tencent.mm.modelappbrand.a.b(str, str2, eV, aVar2.fEt, bundle);
                z = false;
                break;
            default:
                z = true;
                break;
        }
        if (z && aVar2.fEt.type == 36) {
            ((com.tencent.mm.plugin.appbrand.m.c) g.h(com.tencent.mm.plugin.appbrand.m.c.class)).a(aVar.mContext, aVar.jRw, aVar2.username, true, aVar2.fEt);
            z = false;
        }
        x.i("MicroMsg.AppBrandHistoryListPresenter", "goDefaultClickAction %b", new Object[]{Boolean.valueOf(z)});
        if (z && aVar2.fEt.url != null && !aVar2.fEt.url.equals("")) {
            str = p.A(aVar2.fEt.url, eV ? "groupmessage" : "singlemessage");
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("webpageTitle", aVar2.fEt.title);
            PackageInfo packageInfo = getPackageInfo(aVar.mContext, aVar2.fEt.appId);
            intent2.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
            intent2.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
            intent2.putExtra("shortUrl", aVar2.fEt.url);
            if (!bh.ov(aVar2.fEt.fGz)) {
                intent2.putExtra("srcUsername", aVar2.fEt.fGz);
                intent2.putExtra("srcDisplayname", aVar2.fEt.fGA);
            }
            intent2.putExtra("msg_id", aVar2.fqm);
            intent2.putExtra("KPublisherId", "msg_" + Long.toString(aVar2.fFo));
            intent2.putExtra("KAppId", aVar2.fEt.appId);
            intent2.putExtra("geta8key_username", aVar.jRw);
            intent2.putExtra("pre_username", aVar2.username);
            intent2.putExtra("from_scence", 2);
            intent2.putExtra("prePublishId", "msg_" + Long.toString(aVar2.fFo));
            intent2.putExtra("preUsername", aVar2.username);
            intent2.putExtra("preChatName", aVar.jRw);
            intent2.putExtra("preChatTYPE", 2);
            intent2.putExtra("preMsgIndex", 0);
            intent2.putExtra("share_report_pre_msg_url", aVar2.fEt.url);
            intent2.putExtra("share_report_pre_msg_title", aVar2.fEt.title);
            intent2.putExtra("share_report_pre_msg_desc", aVar2.fEt.description);
            intent2.putExtra("share_report_pre_msg_icon_url", aVar2.fEt.thumburl);
            intent2.putExtra("share_report_pre_msg_appid", aVar2.fEt.appId);
            intent2.putExtra("share_report_from_scene", 2);
            d.b(aVar.mContext, "webview", ".ui.tools.WebViewUI", intent2);
        }
    }

    public a(Context context) {
        super(context);
        com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
        aVar.hDP = R.k.dvG;
        aVar.bc(com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 50), com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 50)).hDy = true;
        this.yHa = aVar.PK();
    }

    public final int getType() {
        return 33;
    }

    public final void cur() {
        x.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", new Object[]{Boolean.valueOf(true)});
        this.yHf.cuv();
        b.a(this.jRw, new 1(this, true));
    }

    public final String WW() {
        return "";
    }

    public final String cuu() {
        return "";
    }

    public final b$e cus() {
        return new 2(this);
    }

    public final t l(ViewGroup viewGroup) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.daw, viewGroup, false));
    }

    public final void a(com.tencent.mm.ui.chatting.a.b.a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) FD(i);
        if (bh.ov(aVar2.desc)) {
            bVar.iir.setVisibility(8);
        } else {
            bVar.iir.setVisibility(0);
            bVar.iir.setText(bh.az(aVar2.desc, ""));
        }
        o.PA().a(aVar2.imagePath, bVar.iip, this.yHa);
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, true);
            if (aZ == null) {
                Object obj = packageInfo;
            } else {
                str2 = aZ.field_packageName;
            }
        }
        if (str2 != null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrandHistoryListPresenter", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }
}
