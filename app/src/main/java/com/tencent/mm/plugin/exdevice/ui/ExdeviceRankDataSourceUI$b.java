package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

final class ExdeviceRankDataSourceUI$b extends BaseAdapter {
    private c lRR;
    List<com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.a> lWM = new LinkedList();

    private static class a {
        ImageView jCP;
        TextView lgz;

        private a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return po(i);
    }

    public ExdeviceRankDataSourceUI$b() {
        com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
        aVar.hDP = R.g.bCa;
        this.lRR = aVar.PK();
    }

    public final synchronized com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.a zr(String str) {
        com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.a aVar;
        if (!bh.ov(str)) {
            for (com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.a aVar2 : this.lWM) {
                if (str.equals(aVar2.mac)) {
                    break;
                }
            }
        }
        aVar2 = null;
        return aVar2;
    }

    public final synchronized com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.a cs(String str, String str2) {
        com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.a aVar;
        for (com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.a aVar2 : this.lWM) {
            if (aVar2 != null && ExdeviceRankDataSourceUI.a(str, str2, aVar2.lWK)) {
                break;
            }
        }
        aVar2 = null;
        return aVar2;
    }

    public final int getCount() {
        return this.lWM.size();
    }

    private com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.a po(int i) {
        return (com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.a) this.lWM.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI.a po = po(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(viewGroup.getContext(), R.i.dgZ, null);
            aVar2.lgz = (TextView) view.findViewById(R.h.cyA);
            aVar2.jCP = (ImageView) view.findViewById(R.h.coK);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        x.d("MicroMsg.ExdeviceRankDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[]{Integer.valueOf(i), ExdeviceRankDataSourceUI.a(po), po.mac});
        aVar.lgz.setText(r1);
        o.PA().a(po.lWK.nfT, aVar.jCP, this.lRR);
        return view;
    }
}
