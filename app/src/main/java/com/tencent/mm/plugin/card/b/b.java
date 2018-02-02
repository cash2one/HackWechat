package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.plugin.card.a;
import com.tencent.mm.plugin.card.ui.CardNewMsgUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.s;

public final class b {
    public static void a(MMActivity mMActivity, boolean z) {
        Intent intent = new Intent(mMActivity, CardNewMsgUI.class);
        intent.putExtra("from_menu", z);
        mMActivity.startActivity(intent);
        x.v("MicroMsg.CardActivityHelper", "start CardNewMsgUI");
        g.pQN.h(11324, new Object[]{"CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
    }

    public static void S(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            x.v("MicroMsg.CardActivityHelper", "username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        intent.putExtra("force_get_contact", true);
        a.ifs.d(intent, context);
    }

    public static void T(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            x.v("MicroMsg.CardActivityHelper", "username is null");
        } else if (!s.gE(str)) {
            S(context, str);
        } else if (TextUtils.isEmpty(str)) {
            x.v("MicroMsg.CardActivityHelper", "username is null");
        } else {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.putExtra("finish_direct", true);
            d.a(context, ".ui.chatting.ChattingUI", intent);
        }
    }

    public static void a(MMActivity mMActivity, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("stastic_scene", 0);
        intent.putExtra("rawUrl", str);
        intent.putExtra("title", str2);
        d.b(mMActivity, "webview", ".ui.tools.WebViewUI", intent);
    }

    public static void a(MMActivity mMActivity, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("stastic_scene", i);
        d.b(mMActivity, "webview", ".ui.tools.WebViewUI", intent);
    }

    public static void a(MMActivity mMActivity, float f, float f2, String str) {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kwebmap_slat", (double) f);
        intent.putExtra("kwebmap_lng", (double) f2);
        intent.putExtra("Kwebmap_locaion", str);
        d.b(mMActivity, "location", ".ui.RedirectUI", intent);
    }

    public static void a(MMActivity mMActivity, int i, MMActivity.a aVar) {
        Intent intent = new Intent();
        intent.putExtra("select_is_ret", false);
        intent.putExtra("Select_Conv_Type", 3);
        d.a(mMActivity, ".ui.transmit.SelectConversationUI", intent, i, aVar);
    }

    public static void a(MMActivity mMActivity, String str) {
        Intent intent = new Intent();
        intent.putExtra("KEY_BRAND_NAME", str);
        d.b(mMActivity, "card", ".ui.CardShowWaringTransparentUI", intent);
    }

    public static void a(MMActivity mMActivity, int i, String str, boolean z, com.tencent.mm.plugin.card.base.b bVar) {
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 3);
        intent.putExtra("key_expire_time", i);
        intent.putExtra("key_begin_time", System.currentTimeMillis());
        intent.putExtra("key_card_tips", str);
        intent.putExtra("key_is_mark", z);
        intent.putExtra("key_card_id", bVar.atG());
        intent.putExtra("key_user_card_id", bVar.atF());
        intent.putExtra("key_card_code", bVar.atC().code);
        d.b(mMActivity, "offline", ".ui.WalletOfflineEntranceUI", intent);
        g.pQN.h(11850, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
    }

    public static boolean a(String str, oq oqVar, int i, int i2) {
        if (oqVar != null) {
            return d(str, oqVar.vRx, oqVar.vRy, i, i2);
        }
        x.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField is null");
        return false;
    }

    public static boolean d(String str, String str2, String str3, int i, int i2) {
        if (bh.ov(str2)) {
            x.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField.app_brand_user_name is null");
            return false;
        }
        com.tencent.mm.sdk.b.b qpVar = new qp();
        qpVar.fIi.userName = str2;
        qpVar.fIi.fIk = bh.az(str3, "");
        qpVar.fIi.fIl = i2;
        if (i == 26) {
            qpVar.fIi.scene = 1029;
        } else {
            qpVar.fIi.scene = 1028;
        }
        qpVar.fIi.fnp = str;
        qpVar.fIi.fIo = true;
        com.tencent.mm.sdk.b.a.xef.m(qpVar);
        x.i("MicroMsg.CardActivityHelper", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d", new Object[]{qpVar.fIi.userName, qpVar.fIi.fIk, Integer.valueOf(qpVar.fIi.scene), Integer.valueOf(qpVar.fIi.fIl)});
        return true;
    }
}
