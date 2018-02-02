package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bh;

public final class g implements q {
    public final boolean a(cf cfVar, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        ve veVar = new ve();
        vk vkVar = new vk();
        uq uqVar = new uq();
        uqVar.CJ(5);
        uqVar.TF(str7);
        uqVar.Tw(str3);
        uqVar.CI(i);
        uqVar.Tq(str);
        uqVar.Tr(str2);
        uqVar.TO(str11);
        ut utVar = new ut();
        utVar.hdq = str;
        utVar.weC = i;
        utVar.hdo = str3;
        utVar.hds = str5;
        utVar.hdr = str4;
        utVar.hdt = str6;
        utVar.hdu = str9;
        utVar.hdv = str10;
        uqVar.a(utVar);
        vkVar.Ui(str8);
        vkVar.Uj(com.tencent.mm.z.q.FS());
        vkVar.CS(0);
        vkVar.fC(bh.Wp());
        veVar.a(vkVar);
        veVar.weU.add(uqVar);
        cfVar.fqp.title = uqVar.title;
        cfVar.fqp.desc = uqVar.title;
        cfVar.fqp.fqr = veVar;
        cfVar.fqp.type = 4;
        return true;
    }

    public final boolean a(cf cfVar, Intent intent) {
        return f.a(cfVar, intent);
    }

    public final boolean a(cf cfVar, long j) {
        return f.a(cfVar, j);
    }

    public final boolean a(cf cfVar, String str, String str2, String str3, String str4, String str5, String str6) {
        String format = String.format("%s#%s", new Object[]{str, ""});
        ve veVar = new ve();
        vk vkVar = new vk();
        vkVar.Ui(str2);
        vkVar.CS(2);
        vkVar.fC(System.currentTimeMillis());
        vkVar.Un(str);
        vkVar.Uk(format);
        uq uqVar = new uq();
        uqVar.TI(format);
        uqVar.lt(true);
        uqVar.CJ(5);
        uqVar.Tq(str3);
        uqVar.Tr(str4);
        uqVar.TP(str5);
        uqVar.ls(true);
        veVar.weU.add(uqVar);
        vt vtVar = new vt();
        vtVar.Uy(str6);
        veVar.b(vtVar);
        veVar.a(vkVar);
        cfVar.fqp.fqr = veVar;
        cfVar.fqp.desc = str3;
        cfVar.fqp.type = 5;
        return true;
    }
}
