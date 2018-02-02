package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.b.b;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public final class ax extends BaseAdapter implements x {
    private static HashMap<Long, a> rJw = new HashMap();
    private boolean gPF = false;
    av rJu;
    public aw rJv;

    public final /* bridge */ /* synthetic */ Vending bzu() {
        return this.rJv;
    }

    public final /* synthetic */ Object getItem(int i) {
        return xt(i);
    }

    public ax(MMActivity mMActivity, ListView listView, b bVar, j jVar, String str) {
        this.rJu = new av(mMActivity, listView, bVar, jVar, 10, this);
        this.rJu.rzb = true;
        this.rJv = new aw();
        aw awVar = this.rJv;
        av avVar = this.rJu;
        awVar.mContext = mMActivity;
        awVar.rJk = avVar;
        awVar.rIa = str;
        g.Dk();
        awVar.hhy = ((h) g.h(h.class)).EY();
        com.tencent.mm.vending.base.b bVar2 = this.rJv;
        a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", new Object[]{Integer.valueOf(10)});
        bVar2.zBn = 10;
        this.rJv.addVendingDataChangedCallback(new 1(this));
    }

    public final void ks() {
        if (!this.gPF) {
            this.gPF = true;
            this.rJv.notifyVendingDataChangeSynchronize();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.rJu.i(i, view);
    }

    public final int getViewTypeCount() {
        return 13;
    }

    public final int getItemViewType(int i) {
        return this.rJu.getItemViewType(i);
    }

    public final void bzt() {
        this.rJv.notifyVendingDataChange();
    }

    public final m xt(int i) {
        ay ayVar = (ay) this.rJv.get(i);
        if (ayVar == null) {
            return null;
        }
        return ayVar.qyg;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getCount() {
        return this.rJv.mCount;
    }

    public static void C(m mVar) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (!rJw.containsKey(Long.valueOf(j))) {
                a aVar = new a();
                if (mVar.bxV() != null && mVar.bxV().wQo != null && mVar.bxV().wQo.vYc == 1 && mVar.bxV().wQo.vYd != null && mVar.bxV().wQo.vYd.size() > 0) {
                    aVar.het = mVar.bxV().wQo.vYd.size();
                    aVar.rJy = new HashSet();
                    aVar.rJz = new HashSet();
                    aVar.rJA = new HashSet();
                    aVar.rJB = new HashSet();
                    aVar.id = mVar.bxV().nGJ;
                    try {
                        bjv n = ai.n(mVar);
                        aVar.rJE = n.wMY;
                        aVar.rJF = n.wNb;
                    } catch (Exception e) {
                        aVar.rJE = 0;
                        aVar.rJF = 0;
                    }
                    try {
                        g.Dk();
                        aVar.mNS = ((h) g.h(h.class)).aZi().EM(mVar.field_userName);
                        long currentTimeMillis = System.currentTimeMillis();
                        g.Dk();
                        aVar.rJD = (currentTimeMillis - ((h) g.h(h.class)).aZi().ES(mVar.field_userName)) / 1000;
                    } catch (Exception e2) {
                        aVar.mNS = 0;
                        aVar.rJD = 0;
                    }
                    rJw.put(Long.valueOf(j), aVar);
                }
            }
        }
    }

    public static void b(m mVar, int i) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (rJw.containsKey(Long.valueOf(j))) {
                a aVar = (a) rJw.get(Long.valueOf(j));
                if (aVar.rJC == 0) {
                    aVar.rJC = i + 1;
                }
                if (aVar.rJy == null) {
                    aVar.rJy = new HashSet();
                }
                aVar.rJy.add(Integer.valueOf(i + 1));
            }
        }
    }

    public static void c(m mVar, int i) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (rJw.containsKey(Long.valueOf(j))) {
                a aVar = (a) rJw.get(Long.valueOf(j));
                if (aVar.rJz == null) {
                    aVar.rJz = new HashSet();
                }
                if (!aVar.rJz.contains(Integer.valueOf(i + 1))) {
                    aVar.rJz.add(Integer.valueOf(i + 1));
                }
            }
        }
    }

    public static void d(m mVar, int i) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (rJw.containsKey(Long.valueOf(j))) {
                a aVar = (a) rJw.get(Long.valueOf(j));
                if (aVar.rJA == null) {
                    aVar.rJA = new HashSet();
                }
                if (!aVar.rJA.contains(Integer.valueOf(i + 1))) {
                    aVar.rJA.add(Integer.valueOf(i + 1));
                }
            }
        }
    }

    public static void e(m mVar, int i) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (rJw.containsKey(Long.valueOf(j))) {
                a aVar = (a) rJw.get(Long.valueOf(j));
                if (aVar.rJB == null) {
                    aVar.rJB = new HashSet();
                }
                if (!aVar.rJB.contains(Integer.valueOf(i + 1))) {
                    aVar.rJB.add(Integer.valueOf(i + 1));
                }
            }
        }
    }

    public static void bBV() {
        for (Entry value : rJw.entrySet()) {
            a aVar = (a) value.getValue();
            aVar.networkType = i.bum();
            x.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", new Object[]{Integer.valueOf(aVar.het), Integer.valueOf(aVar.rJy.size()), Integer.valueOf(aVar.rJC), Integer.valueOf(aVar.networkType), aVar.id});
            Iterator it = aVar.rJz.iterator();
            String str = "";
            while (it.hasNext()) {
                str = str + ((Integer) it.next()) + "|";
            }
            if (str.length() >= 2) {
                str = str.substring(0, str.length() - 1);
            }
            Iterator it2 = aVar.rJA.iterator();
            String str2 = "";
            while (it2.hasNext()) {
                str2 = str2 + ((Integer) it2.next()) + "|";
            }
            if (str2.length() >= 2) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            Iterator it3 = aVar.rJB.iterator();
            String str3 = "";
            while (it3.hasNext()) {
                str3 = str3 + ((Integer) it3.next()) + "|";
            }
            if (str3.length() >= 2) {
                str3 = str3.substring(0, str3.length() - 1);
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(11599, new Object[]{Integer.valueOf(aVar.het), Integer.valueOf(aVar.rJy.size()), Integer.valueOf(aVar.rJC), Integer.valueOf(aVar.networkType), Integer.valueOf(0), aVar.id, Long.valueOf(aVar.rJD), Integer.valueOf(aVar.mNS), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aVar.rJE), Integer.valueOf(aVar.rJF), Integer.valueOf(0), str, str2, str3});
        }
        rJw.clear();
    }
}
