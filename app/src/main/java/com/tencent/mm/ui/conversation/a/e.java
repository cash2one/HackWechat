package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.a.f;
import com.tencent.mm.z.a.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ay;
import com.tencent.mm.z.az;
import com.tencent.mm.z.az$a;
import com.tencent.mm.z.b.b.b;
import com.tencent.mm.z.c;

public final class e {
    public static a a(Context context, int i, Object[] objArr) {
        boolean z = false;
        String obj;
        String obj2;
        switch (1.zav[i - 1]) {
            case 1:
                if (objArr == null || objArr.length != 2) {
                    return null;
                }
                obj = objArr[0] != null ? objArr[0].toString() : null;
                if (objArr[1] != null) {
                    obj2 = objArr[1].toString();
                } else {
                    obj2 = null;
                }
                if (ar.Hg().FF() == null) {
                    x.w("MicroMsg.BannerFactory", "recommend banner stg is null. this may be caused by account async init.");
                }
                if (ar.Hg().FF() == null) {
                    return null;
                }
                if (ar.Hg().FF().ik(obj) || ar.Hg().FF().ik(obj2)) {
                    return new f(context, obj, obj2);
                }
                return null;
            case 2:
                if (objArr == null || objArr.length != 3) {
                    return null;
                }
                String obj3;
                boolean z2;
                obj2 = objArr[0] != null ? objArr[0].toString() : null;
                if (objArr[1] != null) {
                    obj3 = objArr[1].toString();
                } else {
                    obj3 = null;
                }
                if (objArr[2] == null || !(objArr[2] instanceof Boolean)) {
                    z2 = false;
                } else {
                    z2 = ((Boolean) objArr[2]).booleanValue();
                }
                if ((ar.Hj() && ar.Hg().FG() != null && ar.Hg().FG().ik(obj2)) || ar.Hg().FG().ik(obj3)) {
                    return new g(context, obj2, obj3, z2);
                }
                return null;
            case 3:
                return new n(context);
            case 4:
                return new h(context);
            case 5:
                return new a(context);
            case 6:
                az.Hs();
                ay Ht = az.Ht();
                if (Ht != null) {
                    return new k(context, Ht);
                }
                return null;
            case 7:
                com.tencent.mm.z.a.e ie = g.Ij().ie("4");
                if (ie == null) {
                    return null;
                }
                obj = ie.value;
                if (bh.ov(obj) || obj.equals("0")) {
                    return null;
                }
                Object obj4;
                a kVar;
                if (obj.equals("1")) {
                    ar.Hg();
                    obj4 = c.CU().get(328195, Boolean.valueOf(false));
                    if (obj4 instanceof Boolean) {
                        z = ((Boolean) obj4).booleanValue();
                    }
                    if (z) {
                        x.i("MicroMsg.BannerFactory", "[cpan] banner type bind mobile has clicked.");
                        return null;
                    }
                    az.Hs();
                    int Hu = az.Hu();
                    if (Hu == az$a.hgw || Hu == az$a.hgx) {
                        x.i("MicroMsg.BannerFactory", "already Bind the Mobile");
                        return null;
                    }
                    kVar = new k(context, new ay(1, 1, ""));
                    f.ii("4");
                    return kVar;
                } else if (!obj.equals("2")) {
                    return null;
                } else {
                    ar.Hg();
                    obj4 = c.CU().get(328196, Boolean.valueOf(false));
                    if (obj4 instanceof Boolean) {
                        z = ((Boolean) obj4).booleanValue();
                    }
                    if (z) {
                        x.i("MicroMsg.BannerFactory", "[cpan] banner type upload contact has clicked.");
                        return null;
                    }
                    az.Hs();
                    if (az.Hu() == az$a.hgw) {
                        x.i("MicroMsg.BannerFactory", "already upload the Mobile");
                        return null;
                    }
                    kVar = new k(context, new ay(2, 1, ""));
                    f.ii("4");
                    return kVar;
                }
            case 8:
                return new l(context);
            case 9:
                return new o(context);
            case 10:
                return new j(context);
            case 11:
                b bVar;
                if (objArr == null || objArr.length <= 0) {
                    bVar = b.hir;
                } else {
                    bVar = (b) objArr[0];
                }
                return new com.tencent.mm.ui.d.a(context, bVar);
            default:
                return null;
        }
    }
}
