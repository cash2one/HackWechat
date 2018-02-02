package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class d extends BaseAdapter {
    private Context context;
    private String ilo;
    private List<c> list;
    private List<c> nIY = new ArrayList();
    int[] nJa;
    boolean nJb = false;

    public d(Context context, List<c> list) {
        this.context = context;
        this.list = list;
        aUs();
        aUt();
    }

    private void aUs() {
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nIY.add(this.list.get(i));
        }
    }

    private void aUt() {
        this.nJa = new int[this.list.size()];
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nJa[i] = ((c) this.list.get(i)).nGR;
        }
    }

    public final int getCount() {
        return this.list.size();
    }

    public final Object getItem(int i) {
        return this.list.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void CN(String str) {
        if (str != null) {
            this.ilo = str.trim();
            this.list.clear();
            int size = this.nIY.size();
            int i = 0;
            while (i < size) {
                if (((c) this.nIY.get(i)).hEx.toUpperCase().contains(this.ilo.toUpperCase()) || ((c) this.nIY.get(i)).nGS.toUpperCase().contains(this.ilo.toUpperCase()) || ((c) this.nIY.get(i)).countryCode.contains(this.ilo)) {
                    this.list.add(this.nIY.get(i));
                }
                i++;
            }
            aUt();
            super.notifyDataSetChanged();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        c cVar = (c) getItem(i);
        if (view == null) {
            View inflate;
            if (w.cfg()) {
                inflate = View.inflate(this.context, R.i.dfi, null);
            } else {
                inflate = View.inflate(this.context, R.i.dfh, null);
            }
            a aVar2 = new a();
            aVar2.nJd = (TextView) inflate.findViewById(R.h.bYz);
            aVar2.kEZ = (TextView) inflate.findViewById(R.h.bYB);
            aVar2.nJe = (TextView) inflate.findViewById(R.h.bYE);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = i > 0 ? this.nJa[i - 1] : -1;
        if (i == 0) {
            aVar.nJd.setVisibility(0);
            aVar.nJd.setText(ry(this.nJa[i]));
        } else if (i <= 0 || this.nJa[i] == i2) {
            aVar.nJd.setVisibility(8);
        } else {
            aVar.nJd.setVisibility(0);
            aVar.nJd.setText(ry(this.nJa[i]));
        }
        aVar.kEZ.setText(cVar.hEx);
        aVar.nJe.setText(cVar.countryCode);
        if (this.nJb) {
            aVar.nJe.setVisibility(0);
        } else {
            aVar.nJe.setVisibility(4);
        }
        return view;
    }

    private static String ry(int i) {
        if (w.cfg()) {
            return Integer.toString(i) + "劃";
        }
        return String.valueOf((char) i);
    }
}
