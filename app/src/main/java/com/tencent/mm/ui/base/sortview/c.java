package com.tencent.mm.ui.base.sortview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c extends BaseAdapter {
    public List<d> ykb = null;
    private Map<String, Integer> ykg;
    private a ykh;
    public Runnable yki = new 1(this);

    public c(a aVar) {
        if (aVar == null) {
            throw new RuntimeException("ViewCreator can not be null.");
        }
        this.ykh = aVar;
        this.ykb = new ArrayList();
        this.ykg = new HashMap();
    }

    public final void cZ(List<d> list) {
        if (this.ykb != list) {
            this.ykb.clear();
            if (list != null) {
                this.ykb.addAll(list);
            }
        }
        this.ykg.clear();
        int i = 0;
        String str = null;
        while (i < this.ykb.size()) {
            d dVar = (d) this.ykb.get(i);
            String str2 = (dVar == null || dVar.ykk == null) ? null : dVar.ykk;
            if (str2 == null || str2.equalsIgnoreCase(str)) {
                str2 = str;
            } else {
                this.ykg.put(str2, Integer.valueOf(i));
            }
            i++;
            str = str2;
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.ykb.size();
    }

    public final Object getItem(int i) {
        return this.ykb.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        d dVar = (d) getItem(i);
        String Fh = Fh(i);
        String Fh2 = Fh(i + 1);
        boolean z2 = i == YS(Fh);
        if (Fh == null || Fh.equalsIgnoreCase(Fh2)) {
            z = false;
        }
        a aVar = this.ykh;
        getCount();
        return aVar.a(dVar, view, i, z2, z);
    }

    private String Fh(int i) {
        if (i < 0 || i >= this.ykb.size()) {
            return null;
        }
        return ((d) this.ykb.get(i)).ykk;
    }

    public final int YS(String str) {
        return bh.a((Integer) this.ykg.get(str), -1);
    }
}
