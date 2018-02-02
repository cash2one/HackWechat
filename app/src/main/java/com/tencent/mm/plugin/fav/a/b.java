package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ur;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class b {
    public static String a(uq uqVar) {
        ur urVar = uqVar.wdD;
        String str = "";
        switch (uqVar.bjS) {
            case 1:
                return cw(str, uqVar.desc);
            case 4:
                if (urVar.wef != null) {
                    return cw(str, urVar.wef.title);
                }
                return str;
            case 5:
                if (urVar.web != null) {
                    return cw(str, urVar.web.title);
                }
                return str;
            case 6:
                str = cw(str, urVar.iIj);
                if (urVar.wdZ != null) {
                    return cw(cw(str, urVar.wdZ.fDu), urVar.wdZ.label);
                }
                return str;
            case 8:
                return cw(str, urVar.title);
            case 10:
            case 11:
                if (urVar.wed != null) {
                    return cw(cw(str, urVar.wed.title), urVar.wed.desc);
                }
                return str;
            default:
                return cw(cw(str, urVar.title), urVar.desc);
        }
    }

    private static String cw(String str, String str2) {
        if (bh.ov(str)) {
            return str2;
        }
        if (bh.ov(str2)) {
            return str;
        }
        return str + "​" + str2;
    }

    public static long a(f fVar) {
        for (int i : a.mnR) {
            if (i == fVar.field_type) {
                long j;
                if (fVar.field_favProto != null) {
                    Iterator it = fVar.field_favProto.weU.iterator();
                    j = 0;
                    while (it.hasNext()) {
                        j = ((uq) it.next()).wde + j;
                    }
                } else {
                    j = 0;
                }
                fVar.field_datatotalsize = j;
                x.d("MicroMsg.Fav.FavApiLogic", "calFavItemInfoTotalLength id:%d,length:%d", new Object[]{Integer.valueOf(fVar.field_id), Long.valueOf(j)});
                return j;
            }
        }
        return 0;
    }

    public static long b(f fVar) {
        if (fVar == null) {
            return 0;
        }
        Iterator it = fVar.field_favProto.weU.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = (int) (((uq) it.next()).wde + ((long) i));
        }
        return (long) i;
    }
}
