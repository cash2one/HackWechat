package com.tencent.mm.ui.gridviewheaders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f extends BaseAdapter implements b {
    private e zfl;
    private List<b> zfm;

    public f(e eVar) {
        this.zfl = eVar;
        eVar.registerDataSetObserver(new a(this, (byte) 0));
        this.zfm = a(eVar);
    }

    public final int getCount() {
        return this.zfl.getCount();
    }

    public final int Gz(int i) {
        try {
            return ((b) this.zfm.get(i)).mCount;
        } catch (IndexOutOfBoundsException e) {
            e.toString();
            return 0;
        }
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        return this.zfl.a(((b) this.zfm.get(i)).zfo, view, viewGroup);
    }

    public final Object getItem(int i) {
        return this.zfl.getItem(i);
    }

    public final long getItemId(int i) {
        return this.zfl.getItemId(i);
    }

    public final int cxl() {
        return this.zfm.size();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.zfl.getView(i, view, viewGroup);
    }

    protected final List<b> a(e eVar) {
        Map hashMap = new HashMap();
        List<b> arrayList = new ArrayList();
        for (int i = 0; i < eVar.getCount(); i++) {
            long om = eVar.om(i);
            b bVar = (b) hashMap.get(Long.valueOf(om));
            if (bVar == null) {
                bVar = new b(this, i);
                arrayList.add(bVar);
            }
            bVar.mCount++;
            hashMap.put(Long.valueOf(om), bVar);
        }
        return arrayList;
    }
}
