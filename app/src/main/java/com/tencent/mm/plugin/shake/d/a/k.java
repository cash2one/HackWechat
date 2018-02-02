package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.b.af;
import com.tencent.mm.k.g;
import com.tencent.mm.l.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.ui.TVInfoUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class k {
    public static void a(d dVar, Context context, boolean z) {
        int i = 4;
        if (dVar != null) {
            Intent intent;
            switch (dVar.field_type) {
                case 6:
                    String str = dVar.field_username;
                    ar.Hg();
                    af WO = c.EY().WO(str);
                    if (WO != null) {
                        Intent intent2 = new Intent();
                        if (a.fZ(WO.field_type) && WO.cia()) {
                            y.Mf().jK(str);
                            if (dVar.field_distance.equals("1")) {
                                intent2.putExtra("Chat_User", str);
                                intent2.putExtra("finish_direct", true);
                                com.tencent.mm.plugin.shake.a.ifs.e(intent2, context);
                                return;
                            }
                        }
                        intent2.putExtra("Contact_User", str);
                        intent2.putExtra("force_get_contact", true);
                        com.tencent.mm.bm.d.b(context, "profile", ".ui.ContactInfoUI", intent2);
                        return;
                    }
                    return;
                case 7:
                    Intent intent3 = new Intent();
                    i = 18;
                    if (z) {
                        i = 26;
                    }
                    intent3.putExtra("geta8key_scene", i);
                    intent3.putExtra("stastic_scene", 6);
                    intent3.putExtra("KAppId", "wxaf060266bfa9a35c");
                    Bundle bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", "wxaf060266bfa9a35c");
                    intent3.putExtra("jsapiargs", bundle);
                    intent3.putExtra("rawUrl", dVar.field_username);
                    intent3.putExtra("srcUsername", dVar.field_distance);
                    com.tencent.mm.plugin.shake.a.ifs.j(intent3, context);
                    return;
                case 8:
                    intent = new Intent();
                    intent.setClass(context, TVInfoUI.class);
                    intent.putExtra("key_TV_xml_bytes", dVar.field_lvbuffer);
                    intent.putExtra("key_TV_come_from_shake", true);
                    context.startActivity(intent);
                    return;
                case 9:
                    b gwVar = new gw();
                    gwVar.fxb.actionCode = 11;
                    gwVar.fxb.result = dVar.field_username;
                    gwVar.fxb.context = context;
                    gwVar.fqI = null;
                    com.tencent.mm.sdk.b.a.xef.a(gwVar, Looper.myLooper());
                    return;
                case 10:
                    intent = new Intent();
                    intent.putExtra("key_product_id", dVar.field_username);
                    intent.putExtra("key_product_scene", 9);
                    com.tencent.mm.bm.d.b(context, "product", ".ui.MallProductUI", intent);
                    return;
                case 12:
                    if (!z) {
                        i = 3;
                    }
                    a(dVar.field_distance, dVar.field_username, i, context);
                    return;
                case 13:
                    String str2 = dVar.field_username;
                    String str3 = dVar.field_reserved3;
                    int i2 = dVar.field_reserved2;
                    if (bh.ov(str2)) {
                        x.i("Micromsg.ShakeTVLogic", "gotoAppBrand commField.app_brand_user_name is null");
                        return;
                    }
                    b qpVar = new qp();
                    qpVar.fIi.userName = str2;
                    qpVar.fIi.fIk = bh.az(str3, "");
                    qpVar.fIi.fIl = 0;
                    qpVar.fIi.scene = 1039;
                    qpVar.fIi.fIm = i2;
                    com.tencent.mm.sdk.b.a.xef.m(qpVar);
                    x.i("Micromsg.ShakeTVLogic", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d version:%d", qpVar.fIi.userName, qpVar.fIi.fIk, Integer.valueOf(qpVar.fIi.scene), Integer.valueOf(qpVar.fIi.fIl), Integer.valueOf(qpVar.fIi.fIm));
                    return;
                default:
                    return;
            }
        }
    }

    public static boolean we(int i) {
        return 7 == i || 6 == i || 8 == i || 9 == i || 10 == i || 12 == i || 13 == i;
    }

    public static boolean brA() {
        if (r.idk) {
            return true;
        }
        String value = g.zY().getValue("ShowShakeTV");
        x.d("Micromsg.ShakeTVLogic", "DynamicConfig Get ShowShakeTV: %s", value);
        if (bh.ov(value) || !value.equals("1")) {
            return false;
        }
        return true;
    }

    public static void a(n nVar, Context context, int i) {
        if (nVar != null) {
            if (bh.ov(nVar.field_username) && bh.ov(nVar.field_deeplink)) {
                com.tencent.mm.plugin.report.service.g.pQN.h(12108, bh.ou(nVar.field_username), Integer.valueOf(i), Integer.valueOf(0));
                return;
            }
            a(nVar.field_username, nVar.field_deeplink, i, context);
            x.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start do nth");
        }
    }

    private static void a(String str, String str2, int i, Context context) {
        if (!bh.ov(str2)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str2));
            int i2 = 16;
            if (i == 3 || i == 4) {
                i2 = 17;
            }
            intent.putExtra("translate_link_scene", i2);
            context.startActivity(intent);
            x.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
            com.tencent.mm.plugin.report.service.g.pQN.h(12108, bh.ou(str), Integer.valueOf(i), Integer.valueOf(1));
        }
    }
}
