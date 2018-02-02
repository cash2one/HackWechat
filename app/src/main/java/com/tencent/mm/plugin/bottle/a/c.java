package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.k;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;

public final class c {
    private static int kAI = 1;
    private static int kAJ = 1;

    public static int ary() {
        return kAI;
    }

    public static int arz() {
        return kAJ;
    }

    public static void ng(int i) {
        kAI = i;
    }

    public static void nh(int i) {
        kAJ = i;
    }

    public static int arA() {
        return k.FO();
    }

    public static int ni(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                return 34;
            case 4:
                return 43;
            default:
                return -1;
        }
    }

    public static String vN(String str) {
        if (bh.ov(str)) {
            return null;
        }
        String[] split = str.split("@bottle:");
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    public static void vO(String str) {
        String[] strArr = null;
        a.ift.um();
        ar.Hg();
        if (com.tencent.mm.z.c.Fa().EM(str) == 1) {
            ar.Hg();
            cf Ex = com.tencent.mm.z.c.Fa().Ex(str);
            if (Ex != null && Ex.field_talker.equals(str)) {
                String vN = vN(str);
                if (!bh.ov(vN)) {
                    a aVar;
                    Cursor a = i.arG().hhp.a("select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + bh.ot(vN) + "\"", null, 0);
                    if (a == null) {
                        aVar = null;
                    } else {
                        if (a.moveToFirst()) {
                            strArr = new a();
                            strArr.kAC = a.getString(0);
                            strArr.kAD = a.getInt(1);
                            strArr.kAE = a.getString(2);
                            strArr.kAF = a.getInt(3);
                            strArr.msgType = a.getInt(4);
                            strArr.kAG = a.getInt(5);
                            strArr.content = a.getString(6);
                            strArr.kAH = a.getLong(7);
                            strArr.hhl = a.getInt(8);
                            strArr.hwo = a.getInt(9);
                            strArr.hhn = a.getString(10);
                            strArr.hho = a.getString(11);
                        }
                        a.close();
                        aVar = strArr;
                    }
                    if (aVar != null && aVar.arx().equals(vN) && aVar.kAF == 1) {
                        au auVar = new au();
                        auVar.dS(str);
                        auVar.aq(Ex.field_createTime <= aVar.kAH ? Ex.field_createTime - 1 : aVar.kAH);
                        auVar.setType(ni(aVar.msgType));
                        auVar.eQ(2);
                        auVar.eR(1);
                        if (auVar.getType() == 34) {
                            auVar.setContent(n.b(q.FS(), (long) aVar.kAG, false));
                            String str2 = aVar.we() + bh.Wp();
                            if (com.tencent.mm.sdk.platformtools.k.fp(com.tencent.mm.modelvoice.q.getFullPath(aVar.we()), com.tencent.mm.modelvoice.q.getFullPath(str2))) {
                                auVar.dT(str2);
                            } else {
                                x.e("MicroMsg.BottleLogic", "Copy Bottle Voice File Failed :" + aVar.we());
                                return;
                            }
                        }
                        auVar.setContent(aVar.we());
                        ar.Hg();
                        com.tencent.mm.z.c.Fa().Q(auVar);
                    }
                }
            }
        }
    }

    public static void arB() {
        String[] strArr;
        b arG = i.arG();
        Cursor a = arG.hhp.a("select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < " + (bh.Wp() - 7776000000L), null, 0);
        int count = a.getCount();
        if (count > 0) {
            strArr = new String[count];
            for (int i = 0; i < count; i++) {
                a.moveToPosition(i);
                if (a.getInt(1) == 3) {
                    strArr[i] = a.getString(0);
                } else {
                    strArr[i] = null;
                }
            }
        } else {
            strArr = null;
        }
        a.close();
        if (count > 0) {
            arG.hhp.delete("bottleinfo1", "createtime< ?", new String[]{String.valueOf(r6)});
        }
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                x.d("MicroMsg.BottleLogic", "delete path:" + com.tencent.mm.modelvoice.q.getFullPath(strArr[i2]));
                if (!bh.ov(com.tencent.mm.modelvoice.q.getFullPath(strArr[i2]))) {
                    b.deleteFile(com.tencent.mm.modelvoice.q.getFullPath(strArr[i2]));
                }
            }
        }
    }

    public static String a(Context context, com.tencent.mm.storage.x xVar) {
        if (xVar == null) {
            return context.getString(R.l.dMZ);
        }
        if (!RegionCodeDecoder.XE(xVar.getCountryCode())) {
            return context.getString(R.l.dMZ);
        }
        String city = xVar.getCity();
        if (!bh.ov(city)) {
            return city;
        }
        city = r.gw(xVar.getProvince());
        if (!bh.ov(city)) {
            return city;
        }
        RegionCodeDecoder.cjP();
        return RegionCodeDecoder.getLocName(xVar.getCountryCode());
    }

    public static String b(Context context, com.tencent.mm.storage.x xVar) {
        if (xVar == null) {
            return context.getString(R.l.dMZ);
        }
        String gw = r.gw(xVar.getProvince());
        if (RegionCodeDecoder.XE(xVar.getCountryCode())) {
            if (bh.ov(xVar.getCity())) {
                StringBuilder stringBuilder = new StringBuilder();
                RegionCodeDecoder.cjP();
                gw = stringBuilder.append(RegionCodeDecoder.getLocName(xVar.getCountryCode())).append(gw).toString();
            } else {
                gw = gw + xVar.getCity();
            }
        }
        return bh.ov(gw) ? context.getString(R.l.dMZ) : gw;
    }
}
