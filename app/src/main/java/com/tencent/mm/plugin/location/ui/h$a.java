package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;

class h$a extends BaseAdapter {
    final /* synthetic */ h nTH;
    ArrayList<h$b> nTJ = new ArrayList();

    public h$a(h hVar, ArrayList<h$b> arrayList) {
        this.nTH = hVar;
        this.nTJ.addAll(arrayList);
    }

    public final int getCount() {
        return this.nTJ.size();
    }

    public final Object getItem(int i) {
        return this.nTJ.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return ((h$b) this.nTJ.get(i)).nTL.nTM;
    }

    public final h$b DH(String str) {
        for (int i = 0; i < this.nTJ.size(); i++) {
            if (((h$b) this.nTJ.get(i)).username.equals(str)) {
                return (h$b) this.nTJ.get(i);
            }
        }
        return null;
    }

    public final boolean DI(String str) {
        for (int i = 0; i < this.nTJ.size(); i++) {
            if (((h$b) this.nTJ.get(i)).username.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final ArrayList<String> aVR() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.nTJ.iterator();
        while (it.hasNext()) {
            arrayList.add(((h$b) it.next()).username);
        }
        return arrayList;
    }
}
