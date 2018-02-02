package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

final class ExdeviceAddDataSourceUI$a extends BaseAdapter {
    private List<ExdeviceAddDataSourceUI$b> lRD = new LinkedList();
    private c lRR;

    public final /* synthetic */ Object getItem(int i) {
        return pe(i);
    }

    public ExdeviceAddDataSourceUI$a() {
        a aVar = new a();
        aVar.hDP = R.g.bCa;
        this.lRR = aVar.PK();
    }

    public final void aD(List<ExdeviceAddDataSourceUI$b> list) {
        this.lRD.clear();
        if (list != null && list.size() != 0) {
            this.lRD.addAll(list);
        }
    }

    public final ExdeviceAddDataSourceUI$b zl(String str) {
        if (!bh.ov(str)) {
            for (ExdeviceAddDataSourceUI$b exdeviceAddDataSourceUI$b : this.lRD) {
                if (str.equalsIgnoreCase(exdeviceAddDataSourceUI$b.mac)) {
                    return exdeviceAddDataSourceUI$b;
                }
            }
        }
        return null;
    }

    public final int getCount() {
        return this.lRD.size();
    }

    public final ExdeviceAddDataSourceUI$b pe(int i) {
        return (ExdeviceAddDataSourceUI$b) this.lRD.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        ExdeviceAddDataSourceUI$b pe = pe(i);
        if (view == null) {
            a aVar2 = new a((byte) 0);
            view = View.inflate(viewGroup.getContext(), R.i.dgy, null);
            aVar2.jCP = (ImageView) view.findViewById(R.h.coK);
            aVar2.lgz = (TextView) view.findViewById(R.h.cyA);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        x.d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[]{Integer.valueOf(i), pe.name, pe.mac});
        aVar.lgz.setText(pe.name);
        o.PA().a(pe.iconUrl, aVar.jCP, this.lRR);
        return view;
    }
}
