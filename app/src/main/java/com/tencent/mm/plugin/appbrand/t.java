package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.plugin.ae.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashSet;
import java.util.Set;

public final class t extends a {
    public final int getType() {
        return 1;
    }

    public final void l(Context context, Intent intent) {
        Object obj;
        g.pQN.a(443, 2, 1, false);
        String vG = c.vG(com.tencent.mm.sdk.platformtools.t.j(intent, SlookAirButtonFrequentContactAdapter.ID));
        String vG2 = c.vG(com.tencent.mm.sdk.platformtools.t.j(intent, "ext_info"));
        Object j = com.tencent.mm.sdk.platformtools.t.j(intent, "token");
        int a = com.tencent.mm.sdk.platformtools.t.a(intent, "ext_info_1", 0);
        if (TextUtils.isEmpty(vG) || TextUtils.isEmpty(vG2) || TextUtils.isEmpty(j)) {
            x.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username or appId or token is null or nil.");
            obj = null;
        } else if (i.fV(vG)) {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            com.tencent.mm.kernel.g.Dh();
            if (!j.equals(c.bJ(vG2, stringBuilder.append(com.tencent.mm.kernel.a.Cg()).toString()))) {
                SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("app_brand_global_sp", 0);
                if (sharedPreferences == null) {
                    x.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, sp is null.");
                    obj = null;
                } else {
                    Set<String> stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
                    if (stringSet == null || stringSet.isEmpty()) {
                        x.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, uin set is null or nil.");
                        obj = null;
                    } else {
                        Set hashSet = new HashSet();
                        for (String str2 : stringSet) {
                            hashSet.add(c.bJ(vG2, str2));
                        }
                        if (!hashSet.contains(j)) {
                            x.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, illegal token(%s).", new Object[]{j});
                            obj = null;
                        }
                    }
                }
            }
            if (b.ceK() || a != 1) {
                com.tencent.mm.sdk.b.b qpVar = new qp();
                qpVar.fIi.appId = vG2;
                qpVar.fIi.userName = vG;
                qpVar.fIi.fIl = a;
                qpVar.fIi.scene = 1023;
                qpVar.fIi.fIo = true;
                qpVar.fIi.context = context;
                qpVar.fIi.fIp = false;
                com.tencent.mm.sdk.b.a.xef.m(qpVar);
                if (qpVar.fIj.fIu) {
                    x.i("MiroMsg.WxaShortcutEntry", "open wxa with id : %s", new Object[]{vG});
                } else if (a == 1) {
                    Toast.makeText(context, j.iyL, 0).show();
                } else if (a == 2) {
                    Toast.makeText(context, j.iAj, 0).show();
                }
                Object j2 = com.tencent.mm.sdk.platformtools.t.j(intent, "digest");
                if (!TextUtils.isEmpty(j2)) {
                    WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(vG);
                    if (qK == null) {
                        x.e("MiroMsg.WxaShortcutEntry", "no such WeApp(%s)", new Object[]{vG});
                        obj = 1;
                    } else {
                        if (!j2.equals(com.tencent.mm.a.g.s((qK.field_nickname + qK.field_roundedSquareIconURL + qK.field_bigHeadURL).getBytes()))) {
                            x.i("MiroMsg.WxaShortcutEntry", "update shortcut for wxa(%s)", new Object[]{vG});
                            if (context == null) {
                                x.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
                            } else if (intent == null) {
                                x.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
                            } else {
                                qpVar = new bq();
                                qpVar.fpJ.username = vG;
                                com.tencent.mm.sdk.b.a.xef.m(qpVar);
                                if (qpVar.fpK.fpM == null) {
                                    x.e("MicroMsg.AppBrandShortcutManager", "no such WeApp(%s)", new Object[]{vG});
                                } else {
                                    str2 = TextUtils.isEmpty(qpVar.fpK.fpL) ? vG : qpVar.fpK.fpL;
                                    Intent intent2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
                                    intent2.putExtra("android.intent.extra.shortcut.NAME", str2);
                                    intent2.putExtra("duplicate", false);
                                    intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
                                    com.tencent.mm.plugin.base.model.b.p(context, intent);
                                    x.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", new Object[]{vG});
                                }
                            }
                            ag.h(new 1(this, context, vG, a), 1000);
                        }
                    }
                }
                intent.putExtra(DownloadSettingTable$Columns.TYPE, 0);
                intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, "");
                obj = 1;
            } else {
                x.i("MiroMsg.WxaShortcutEntry", "can not open testing WeApp in released WeChat.");
                obj = null;
            }
        } else {
            x.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username %s invalid ", new Object[]{vG});
            d.pPH.a(647, 1, 1, false);
            obj = null;
        }
        if (obj == null) {
            g.pQN.a(443, 3, 1, false);
        }
    }
}
