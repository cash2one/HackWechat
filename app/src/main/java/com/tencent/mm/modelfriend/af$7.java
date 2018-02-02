package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class af$7 extends c<hb> {
    final /* synthetic */ af hxt;

    af$7(af afVar) {
        this.hxt = afVar;
        this.xen = hb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hb hbVar = (hb) bVar;
        if (hbVar instanceof hb) {
            String str = hbVar.fxj.fxl;
            if (bh.ov(str)) {
                x.e("MicroMsg.SubCoreFriend", "hy: mobile number is null");
            } else {
                Cursor a = af.OD().hhp.a("select addr_upload2.username from addr_upload2 where addr_upload2.moblie = " + str, null, 2);
                List linkedList = new LinkedList();
                while (a.moveToNext()) {
                    linkedList.add(a.getString(0));
                }
                a.close();
                x.i("MicroMsg.SubCoreFriend", "hy: username: %s", new Object[]{linkedList.size() == 0 ? "" : (String) linkedList.get(0)});
                hbVar.fxk.userName = str;
            }
        }
        return false;
    }
}
