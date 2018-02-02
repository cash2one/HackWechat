package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.lib.e.d;

class d$1 extends c<aw> {
    final /* synthetic */ d nAK;

    d$1(d dVar) {
        this.nAK = dVar;
        this.xen = aw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        aw awVar = (aw) bVar;
        if (this.nAK.nAF) {
            Context context = ac.getContext();
            String string = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_after_install", "");
            d dVar = a.ip(context).AiG;
            String str = dVar == null ? "" : dVar.AiL;
            x.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isAfterInstallDialogHaveShow currentVersion :%s tinkerVersion:%s", new Object[]{string, str});
            boolean z = bh.ov(string) || bh.ov(str) || !(bh.ov(string) || bh.ov(str) || !string.equalsIgnoreCase(str));
            if (!z) {
                str = ac.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_patch_msg_key", "");
                awVar.foZ.fpa = true;
                awVar.foZ.fpb = str;
                if (!bh.ov(str)) {
                    a.rg(2);
                }
                context = ac.getContext();
                Object string2 = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_patch_version_key", "");
                if (!TextUtils.isEmpty(string2)) {
                    context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_after_install", string2).apply();
                }
            }
            this.nAK.nAF = false;
        }
        return false;
    }
}
