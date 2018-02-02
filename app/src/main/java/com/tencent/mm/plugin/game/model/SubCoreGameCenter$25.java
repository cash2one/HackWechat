package com.tencent.mm.plugin.game.model;

import android.os.Bundle;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class SubCoreGameCenter$25 extends c<gm> {
    final /* synthetic */ SubCoreGameCenter nfd;

    SubCoreGameCenter$25(SubCoreGameCenter subCoreGameCenter) {
        this.nfd = subCoreGameCenter;
        this.xen = gm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gm gmVar = (gm) bVar;
        int i;
        switch (gmVar.fwC.actionCode) {
            case 1:
                g.a(gmVar.fwC.context, gmVar.fwC.appId, gmVar.fwC.messageAction, gmVar.fwC.messageExt, null);
                ap.a(gmVar.fwC.context, gmVar.fwC.scene, gmVar.fwC.scene, 1, 3, gmVar.fwC.appId, 0, null);
                break;
            case 2:
                i = gmVar.fwC.scene;
                x.i("MicroMsg.SubCoreGameCenter", "scene = %d, extinfo = %s", new Object[]{Integer.valueOf(i), gmVar.fwC.extMsg});
                Bundle bundle = new Bundle();
                bundle.putInt("game_report_from_scene", i);
                bundle.putCharSequence("game_app_id", gmVar.fwC.appId);
                bundle.putCharSequence("game_report_extra_click_extinfo", r1);
                ap.a(gmVar.fwC.context, gmVar.fwC.scene, gmVar.fwC.scene, 1, com.tencent.mm.plugin.game.d.c.a(gmVar.fwC.context, gmVar.fwC.appId, null, bundle), gmVar.fwC.appId, 0, null);
                break;
            case 3:
                s.update();
                break;
            case 5:
                i = gmVar.fwC.scene;
                SubCoreGameCenter.aRe();
                com.tencent.mm.plugin.game.d.c.a(w.aQp(), i);
                break;
        }
        return false;
    }
}
