package com.tencent.mm.plugin.bottle.a;

import android.database.Cursor;
import com.tencent.mm.ay.f;
import com.tencent.mm.by.h.d;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as.a;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.c;
import java.util.HashMap;

public final class i implements ap {
    private static HashMap<Integer, d> gwY;
    private a hgd = new 2(this);
    private b kAT;

    private static i arF() {
        ar.Ha();
        i iVar = (i) bp.hY("plugin.bottle");
        if (iVar != null) {
            return iVar;
        }
        Object iVar2 = new i();
        ar.Ha().a("plugin.bottle", iVar2);
        return iVar2;
    }

    public static b arG() {
        g.Dh().Ct();
        if (arF().kAT == null) {
            i arF = arF();
            ar.Hg();
            arF.kAT = new b(c.EV());
        }
        return arF().kAT;
    }

    public final void onAccountRelease() {
        ar.Hg();
        c.Fd().c(this.hgd);
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("THROWBOTTLEINFO_TABLE".hashCode()), new 1());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public static void arH() {
        ar.Hg();
        Cursor ciG = c.Fd().ciG();
        for (int i = 0; i < ciG.getCount(); i++) {
            ciG.moveToPosition(i);
            aj aeVar = new ae();
            aeVar.b(ciG);
            ar.Hg();
            cf Ew = c.Fa().Ew(aeVar.field_username);
            ar.Hg();
            c.EX().b(new com.tencent.mm.ay.d(aeVar.field_username, Ew.field_msgSvrId));
            ar.Hg();
            c.EX().b(new f(aeVar.field_username, 0));
            ar.Hg();
            c.EY().WU(aeVar.field_username);
        }
        ciG.close();
        ar.Hg();
        c.Fa().EE("@bottle");
        ar.Hg();
        c.Fd().ciA();
        ar.Hg();
        c.Fd().EE("floatbottle");
        ba.Hx();
        arG().hhp.delete("bottleinfo1", null, null);
    }

    public final void bq(boolean z) {
        c.arB();
        ar.Hg();
        c.Fd().b(this.hgd);
    }

    public final void br(boolean z) {
    }
}
