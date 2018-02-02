package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class g {
    private static Map<Long, Long> mnV = new HashMap();
    private static Map<Long, Long> mnW = new HashMap();

    public static final void pE(int i) {
        d.pPH.a(802, (long) i, 1, false);
    }

    public static final void pF(int i) {
        d.pPH.a(802, 4, (long) i, false);
    }

    public static void cT(long j) {
        if (!mnV.containsKey(Long.valueOf(j))) {
            mnV.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static long cU(long j) {
        Long l = (Long) mnV.get(Long.valueOf(j));
        return l == null ? -1 : System.currentTimeMillis() - l.longValue();
    }

    public static void cV(long j) {
        if (!mnW.containsKey(Long.valueOf(j))) {
            mnW.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static int cw(int i, int i2) {
        if (i2 == -401) {
            return -4;
        }
        if (i == 4) {
            return -2;
        }
        return -1;
    }

    public static String a(a aVar) {
        int i = 1;
        x.v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", new Object[]{aVar.toString()});
        d.pPH.k(15098, r0);
        String str = "scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]";
        Object[] objArr = new Object[18];
        objArr[0] = Integer.valueOf(aVar.scene);
        objArr[1] = Integer.valueOf(aVar.index);
        objArr[2] = Long.valueOf(aVar.mnX);
        objArr[3] = Integer.valueOf(aVar.type);
        objArr[4] = aVar.mnY;
        objArr[5] = Integer.valueOf(aVar.cOY);
        objArr[6] = Long.valueOf(aVar.timestamp);
        objArr[7] = Long.valueOf(aVar.mnZ);
        objArr[8] = Long.valueOf(aVar.moa);
        objArr[9] = Integer.valueOf(aVar.mob ? 1 : 0);
        objArr[10] = Integer.valueOf(aVar.moc);
        objArr[11] = Integer.valueOf(aVar.mod);
        objArr[12] = Integer.valueOf(aVar.moe);
        objArr[13] = Integer.valueOf(aVar.mof);
        objArr[14] = Integer.valueOf(aVar.mog);
        objArr[15] = Integer.valueOf(aVar.moh ? 1 : 0);
        if (!aVar.moi) {
            i = 0;
        }
        objArr[16] = Integer.valueOf(i);
        objArr[17] = Integer.valueOf(aVar.moj);
        return String.format(str, objArr);
    }
}
