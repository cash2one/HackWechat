package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.by.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class bd extends j implements a, f {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS role_info ( id TEXT PRIMARY KEY, name TEXT, status INT, text_reserved1 TEXT, text_reserved2 TEXT, text_reserved3 TEXT, text_reserved4 TEXT, int_reserved1 INT, int_reserved2 INT, int_reserved3 INT, int_reserved4 INT )"};
    private e gJP = null;

    public bd(h hVar) {
        this.gJP = hVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    public final String getTableName() {
        return "role_info";
    }

    public final bc EY(String str) {
        bc bcVar = null;
        if (str != null && str.length() > 0) {
            bc bcVar2 = new bc();
            Cursor a = this.gJP.a("role_info", null, "name LIKE ?", new String[]{"%" + str}, null, null, null, 2);
            if (a.moveToFirst()) {
                bcVar2.b(a);
                bcVar = bcVar2;
            }
            a.close();
        }
        return bcVar;
    }

    private bc XI(String str) {
        bc bcVar = null;
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        bc bcVar2 = new bc();
        Cursor a = this.gJP.a("role_info", null, "name= ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            bcVar2.b(a);
            bcVar = bcVar2;
        }
        a.close();
        return bcVar;
    }

    public final List<bc> aZx() {
        List<bc> linkedList = new LinkedList();
        Cursor a = this.gJP.a("role_info", null, new StringBuilder("int_reserved1=1").toString(), null, null, null, null, 2);
        while (a.moveToNext()) {
            bc bcVar = new bc();
            bcVar.b(a);
            linkedList.add(bcVar);
        }
        a.close();
        return linkedList;
    }

    private void a(bc bcVar) {
        bcVar.fDt = com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX;
        ContentValues vI = bcVar.vI();
        if (vI.size() > 0 && this.gJP.insert("role_info", SlookAirButtonFrequentContactAdapter.ID, vI) != 0) {
            doNotify();
        }
    }

    public final boolean has(String str) {
        bc EY = EY(new bc.a(str).XH(""));
        return EY != null && str.equals(EY.name);
    }

    public final void bH(String str, int i) {
        if (bh.ov(str)) {
            x.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
        } else if (XI(str) == null) {
            a(new bc(str, true, i));
            x.d("MicroMsg.RoleStorage", "insert new role, user=" + str);
        }
    }

    public final void ar(String str, boolean z) {
        if (bh.ov(str)) {
            x.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            return;
        }
        bc XI = XI(str);
        if (XI == null) {
            a(new bc(str, z, 2));
            x.d("MicroMsg.RoleStorage", "insert new role, user=" + str);
            return;
        }
        XI.ge(z);
        XI.fDt = 4;
        b(XI);
    }

    public final void c(String str, boolean z, boolean z2) {
        int i = 2;
        if (bh.ov(str)) {
            x.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            return;
        }
        bc XI = XI(str);
        if (XI == null) {
            a(new bc(str, z, 2));
            x.d("MicroMsg.RoleStorage", "insert new role, user=" + str);
            return;
        }
        XI.ge(z);
        if (z2) {
            int i2 = XI.status;
            if (!z2) {
                i = 0;
            }
            XI.status = i | i2;
        } else {
            XI.status &= -3;
        }
        XI.fDt = 4;
        b(XI);
    }

    private void b(bc bcVar) {
        ContentValues vI = bcVar.vI();
        if (vI.size() > 0) {
            int update = this.gJP.update("role_info", vI, "name like ?", new String[]{bcVar.name});
            x.d("MicroMsg.RoleStorage", "update role info, name=" + bcVar.name + ", res:" + update);
            if (update > 0) {
                doNotify();
            }
        }
    }

    public final void jL(String str) {
        Assert.assertTrue(str.length() > 0);
        int delete = this.gJP.delete("role_info", "name=?", new String[]{str});
        x.d("MicroMsg.RoleStorage", "delete name name :" + str + ", res:" + delete);
        if (delete > 0) {
            doNotify();
        }
    }
}
