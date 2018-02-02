package com.tencent.mm.ui;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ab.c;
import com.tencent.mm.ui.ab.d;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Map;

public final class aa {
    private static aa xLW = null;
    private long timestamp = 0;
    int xLX = 0;
    private SparseIntArray xLY = new SparseIntArray();
    private SparseArray<ab$b> xLZ = new SparseArray();
    private ArrayList<Integer> xMa = new ArrayList();
    public SparseArray<c> xMb = new SparseArray();
    private boolean xMc = false;

    public static aa cnB() {
        if (xLW == null) {
            xLW = new aa();
        }
        return xLW;
    }

    public final void Ea(int i) {
        if (this.xLZ.size() != 0) {
            ab$b com_tencent_mm_ui_ab_b = (ab$b) this.xLZ.get(i);
            if (com_tencent_mm_ui_ab_b != null && com_tencent_mm_ui_ab_b.xMh == 1) {
                this.xLY.put(com_tencent_mm_ui_ab_b.id, com_tencent_mm_ui_ab_b.hOH);
                this.xLX--;
                if (this.xMc) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i2 = 0; i2 < this.xLY.size(); i2++) {
                        int keyAt = this.xLY.keyAt(i2);
                        Integer valueOf = Integer.valueOf(this.xLY.get(keyAt));
                        stringBuffer.append(keyAt);
                        stringBuffer.append(":");
                        stringBuffer.append(valueOf);
                        stringBuffer.append("|");
                    }
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(299010, stringBuffer.toString());
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void lY(boolean z) {
        int i;
        if (!z) {
            try {
                int i2 = (this.xLZ.size() == 0 || System.currentTimeMillis() - this.timestamp > 3600000) ? true : 0;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.PlusMenaDataManager", e, "", new Object[0]);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.PlusMenaDataManager", "dynaConfigs size %d", new Object[]{Integer.valueOf(g.zY().eQ("TopRightMenu\\d*").size())});
        synchronized (this) {
            String value;
            this.xLZ.clear();
            this.xMa.clear();
            for (String value2 : r0) {
                Map y = bi.y(value2, "Menu");
                if (!(y == null || y.size() == 0)) {
                    int VI = bh.VI((String) y.get(".Menu.$id"));
                    int VI2 = bh.VI((String) y.get(".Menu.$shownew"));
                    int VI3 = bh.VI((String) y.get(".Menu.$seq"));
                    int VI4 = bh.VI((String) y.get(".Menu.$order"));
                    this.xLZ.put(VI, new ab$b(VI, VI2, VI3, VI4));
                    i = 0;
                    while (i < this.xMa.size() && ((ab$b) this.xLZ.get(((Integer) this.xMa.get(i)).intValue())).order <= VI4) {
                        i++;
                    }
                    this.xMa.add(i, Integer.valueOf(VI));
                }
            }
            x.i("MicroMsg.PlusMenaDataManager", "dynaMenuOrder size %d", new Object[]{Integer.valueOf(this.xMa.size())});
            if (this.xMa.size() == 0) {
                this.xLZ.clear();
                this.xMa.clear();
                value2 = g.zY().getValue("TopRightMenus");
                if (!bh.ov(value2)) {
                    Map y2 = bi.y(value2, "TopRightMenus");
                    if (y2 != null) {
                        VI = 0;
                        while (VI < 100) {
                            String str = ".TopRightMenus.Menu" + (VI == 0 ? "" : Integer.valueOf(VI));
                            value2 = (String) y2.get(str + ".$id");
                            if (value2 == null || bh.ov(value2)) {
                                break;
                            }
                            x.d("MicroMsg.PlusMenaDataManager", "got plus panel configs : %s %s %s", new Object[]{value2, (String) y2.get(str + ".$shownew"), (String) y2.get(str + ".$seq")});
                            this.xLZ.put(bh.VI(value2), new ab$b(bh.VI(value2), bh.VI(r1), bh.VI(str)));
                            this.xMa.add(Integer.valueOf(bh.VI(value2)));
                            VI++;
                        }
                    } else {
                        x.e("MicroMsg.PlusMenaDataManager", "TopRightMenus is not right");
                    }
                }
            }
        }
        if (this.xLZ.size() != 0) {
            cnC();
        }
        this.timestamp = System.currentTimeMillis();
        x.d("MicroMsg.PlusMenaDataManager", " plus menu load data spent time : %s", new Object[]{Long.valueOf(this.timestamp - currentTimeMillis)});
        this.xMb.clear();
        this.xLX = 0;
        int i3 = 0;
        for (i = 0; i < this.xMa.size(); i++) {
            VI = ((Integer) this.xMa.get(i)).intValue();
            ab$b com_tencent_mm_ui_ab_b = (ab$b) this.xLZ.get(VI);
            d Eb = ab.Eb(VI);
            if (Eb != null) {
                c cVar = new c(Eb);
                this.xMb.put(i3, cVar);
                int i4 = this.xLY.get(VI);
                if ((com_tencent_mm_ui_ab_b.xMh == 1 && i4 != com_tencent_mm_ui_ab_b.hOH) || (VI == 20 && com.tencent.mm.s.c.Bq().aR(262159, 266248))) {
                    cVar.xMj = true;
                    this.xLX++;
                }
                i3++;
            }
        }
        x.i("MicroMsg.PlusMenaDataManager", "dynaMenuOrder.size() %s menuDataMap.size() %s", new Object[]{Integer.valueOf(this.xMa.size()), Integer.valueOf(this.xMb.size())});
        if (f.ceQ()) {
            this.xMb.put(i3, new c(ab.Eb(2147483645)));
        } else {
            this.xMb.put(i3, new c(ab.Eb(Integer.MAX_VALUE)));
        }
    }

    private void cnC() {
        this.xLY.clear();
        ar.Hg();
        String str = (String) com.tencent.mm.z.c.CU().get(299010, null);
        if (!bh.ov(str)) {
            String[] split = str.split("\\|");
            for (String split2 : split) {
                String[] split3 = split2.split("\\:");
                if (split3.length == 2) {
                    this.xLY.put(bh.VI(split3[0]), bh.VI(split3[1]));
                }
            }
        }
        this.xMc = true;
    }
}
