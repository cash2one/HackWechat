package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.ag.y;
import com.tencent.mm.plugin.ae.a;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.base.model.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashSet;
import java.util.Set;

public final class al extends a {
    public static String ttp = "";

    public final int getType() {
        return 2;
    }

    public final void l(Context context, Intent intent) {
        String vG = c.vG(t.j(intent, SlookAirButtonFrequentContactAdapter.ID));
        String vG2 = c.vG(t.j(intent, "ext_info"));
        Object j = t.j(intent, "token");
        if (TextUtils.isEmpty(vG) || TextUtils.isEmpty(vG2) || TextUtils.isEmpty(j)) {
            x.e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        if (!j.equals(d.bJ(vG2, stringBuilder.append(com.tencent.mm.z.c.Cg()).toString()))) {
            SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("app_brand_global_sp", 0);
            if (sharedPreferences == null) {
                x.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, sp is null.");
                return;
            }
            Set<String> stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
            if (stringSet == null || stringSet.isEmpty()) {
                x.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, uin set is null or nil.");
                return;
            }
            Set hashSet = new HashSet();
            for (String bJ : stringSet) {
                hashSet.add(c.bJ(vG2, bJ));
            }
            if (!hashSet.contains(j)) {
                x.e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", new Object[]{j});
                Toast.makeText(context, context.getString(R.l.eYt), 1).show();
                return;
            }
        }
        intent.putExtra(DownloadSettingTable$Columns.TYPE, 0);
        intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, "");
        String bJ2 = "https://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=" + vG2;
        if (!bh.ov(ttp)) {
            bJ2 = bJ2 + "&" + ttp;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("rawUrl", bJ2);
        intent2.putExtra("from_shortcut", true);
        intent2.putExtra("game_hv_menu_appid", vG2);
        intent2.addFlags(67108864);
        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.game.H5GameWebViewUI", intent2);
        y.Mp().jw(vG);
        Object j2 = t.j(intent, "digest");
        if (TextUtils.isEmpty(j2)) {
            x.i("MicroMsg.WebViewShortcutEntry", "digest is null");
            return;
        }
        ar.Hg();
        com.tencent.mm.storage.x WO = com.tencent.mm.z.c.EY().WO(vG);
        if (WO == null || bh.ov(WO.AP())) {
            x.i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
            return;
        }
        String AP = WO.AP();
        h jm = n.JQ().jm(vG);
        if (jm == null || bh.ov(jm.JH())) {
            x.i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
        } else if (j2.equals(g.s((AP + jm.JH()).getBytes()))) {
            x.i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
        } else {
            Bitmap a = b.a(vG, false, -1);
            if (a == null || a.isRecycled()) {
                x.i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
                return;
            }
            x.i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", new Object[]{AP});
            d.c(context, vG, vG2, c.vG(t.j(intent, "ext_info_1")));
            ag.h(new 1(this, vG, vG2), 1000);
        }
    }
}
