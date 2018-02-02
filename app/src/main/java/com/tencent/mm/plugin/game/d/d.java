package com.tencent.mm.plugin.game.d;

import com.tencent.mm.plugin.y.a.a.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    public static void a(f fVar) {
        if (fVar == null) {
            x.e("MicroMsg.GameDataUtil", "Null appInfo");
        } else if (bh.ov(fVar.field_appId)) {
            x.e("MicroMsg.GameDataUtil", "Invalid appId");
        } else {
            f fVar2;
            boolean z;
            boolean l;
            String str = fVar.field_appId;
            f aZ = g.aZ(str, true);
            if (aZ == null) {
                aZ = new f();
                aZ.field_appId = str;
                fVar2 = aZ;
                z = true;
            } else {
                fVar2 = aZ;
                z = false;
            }
            String cfi = w.cfi();
            if (cfi.equals("zh_CN")) {
                fVar2.field_appName = fVar.field_appName;
            } else if (cfi.equals("zh_TW") || cfi.equals("zh_HK")) {
                fVar2.field_appName_tw = fVar.field_appName;
            } else {
                fVar2.field_appName_en = fVar.field_appName;
            }
            fVar2.field_appType = fVar.field_appType;
            fVar2.field_packageName = fVar.field_packageName;
            fVar2.cO(fVar.fQE);
            fVar2.cR(fVar.fQJ);
            fVar2.ev(fVar.fQN);
            fVar2.cS(fVar.fQK);
            fVar2.cX(fVar.fQQ);
            fVar2.cY(fVar.fQR);
            fVar2.cV(fVar.fQO);
            fVar2.cW(fVar.fQP);
            fVar2.ew(fVar.fQT);
            if (!bh.ov(fVar.fQH)) {
                fVar2.cP(fVar.fQH);
            }
            if (z) {
                l = an.bin().l(fVar2);
                a.bis().Hh(str);
            } else if (fVar2.field_appVersion < fVar.field_appVersion) {
                x.i("MicroMsg.GameDataUtil", "oldVersion = %s, newVersion = %s", new Object[]{Integer.valueOf(fVar2.field_appVersion), Integer.valueOf(fVar.field_appVersion)});
                l = an.bin().a(fVar2, new String[0]);
                a.bis().Hh(str);
            } else {
                boolean z2 = (fVar2 == null || bh.ov(fVar2.field_appIconUrl)) ? true : (fVar == null || bh.ov(fVar.field_appIconUrl)) ? false : !fVar2.field_appIconUrl.equals(fVar.field_appIconUrl);
                if (z2) {
                    x.i("MicroMsg.GameDataUtil", "oldIcon = %s, newIcon = %s", new Object[]{fVar2.field_appIconUrl, fVar.field_appIconUrl});
                    fVar2.field_appIconUrl = fVar.field_appIconUrl;
                    l = an.bin().a(fVar2, new String[0]);
                    an.bil().cP(str, 1);
                    an.bil().cP(str, 2);
                    an.bil().cP(str, 3);
                    an.bil().cP(str, 4);
                    an.bil().cP(str, 5);
                } else {
                    l = an.bin().a(fVar2, new String[0]);
                }
            }
            x.i("MicroMsg.GameDataUtil", "Saving AppInfo, appId: %s, insert?: %s, return: %s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(l)});
        }
    }

    public static void U(LinkedList<? extends f> linkedList) {
        if (linkedList == null) {
            x.e("MicroMsg.GameDataUtil", "Null appInfos");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a((f) it.next());
        }
    }
}
