package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.plugin.brandservice.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class Plugin$1 extends c<ag> {
    final /* synthetic */ Plugin kEA;

    Plugin$1(Plugin plugin) {
        this.kEA = plugin;
        this.xen = ag.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ag agVar = (ag) bVar;
        if (agVar == null || !(agVar instanceof ag)) {
            return false;
        }
        ag agVar2 = agVar;
        switch (agVar2.fob.action) {
            case 1:
                Context context = agVar2.fob.context;
                String str = agVar2.fob.fod;
                String str2 = agVar2.fob.title;
                int i = agVar2.fob.fromScene;
                long j = agVar2.fob.foe;
                int i2 = agVar2.fob.offset;
                boolean z = agVar2.fob.fof;
                if (context == null || bh.ov(str)) {
                    x.e("MicroMsg.BrandService.BrandServiceLogic", "context(%s) or keyword(%s) is null or nil.", new Object[]{context, str});
                    return false;
                }
                ar.CG().a(1071, new c$a(context, str, j, i2, i, str2, z, agVar2));
                ar.CG().a(new h(str, j, i2, i, ""), 0);
                return true;
            default:
                x.d("MicroMsg.BrandService.BrandServiceLogic", "Do not support the action(%d).", new Object[]{Integer.valueOf(agVar2.fob.action)});
                return false;
        }
    }
}
