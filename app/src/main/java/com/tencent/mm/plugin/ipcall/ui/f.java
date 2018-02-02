package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bc.b;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.List;

public final class f extends BaseAdapter {
    private String ilo;
    private List<a> list;
    private List<a> nIY = new ArrayList();
    private IPCallCountryCodeSelectUI nIZ;
    int[] nJa;
    boolean nJb = false;
    boolean nJc = false;

    static class a {
        TextView kEZ;
        TextView nJd;
        TextView nJe;

        a() {
        }
    }

    public f(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI, List<a> list) {
        this.nIZ = iPCallCountryCodeSelectUI;
        this.list = list;
        aUs();
        aUt();
    }

    private void aUs() {
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nIY.add(this.list.get(i));
        }
        this.nIZ.nIQ.setVisibility(8);
    }

    private void aUt() {
        this.nJa = new int[this.list.size()];
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.nJa[i] = ((a) this.list.get(i)).aUi();
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
                if (((a) this.nIY.get(i)).hEx.toUpperCase().contains(this.ilo.toUpperCase()) || ((a) this.nIY.get(i)).nGS.toUpperCase().contains(this.ilo.toUpperCase()) || ((a) this.nIY.get(i)).countryCode.contains(this.ilo)) {
                    this.list.add(this.nIY.get(i));
                }
                i++;
            }
            aUt();
            if (this.list.size() == 0) {
                this.nIZ.nIQ.setVisibility(0);
            } else {
                this.nIZ.nIQ.setVisibility(8);
            }
            super.notifyDataSetChanged();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2 = (a) getItem(i);
        if (view == null) {
            view = View.inflate(this.nIZ, R.i.dlX, null);
            aVar = new a();
            aVar.nJd = (TextView) view.findViewById(R.h.bYz);
            aVar.kEZ = (TextView) view.findViewById(R.h.bYB);
            aVar.nJe = (TextView) view.findViewById(R.h.bYE);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = i > 0 ? this.nJa[i - 1] : -1;
        if (i == 0) {
            aVar.nJd.setVisibility(0);
            if (this.nJc) {
                aVar.nJd.setText(R.l.eAS);
            } else {
                aVar.nJd.setText(ry(this.nJa[i]));
            }
        } else if (i <= 0 || this.nJa[i] == i2) {
            aVar.nJd.setVisibility(8);
        } else {
            aVar.nJd.setVisibility(0);
            aVar.nJd.setText(ry(this.nJa[i]));
        }
        if (bh.ov(this.ilo)) {
            aVar.kEZ.setText(aVar2.hEx);
            aVar.nJe.setText(" (+" + aVar2.countryCode + ")");
        } else {
            aVar.kEZ.setText(b.a(aVar2.hEx, this.ilo));
            aVar.nJe.setText(b.a(" (+" + aVar2.countryCode + ")", this.ilo));
        }
        if (this.nJb) {
            aVar.nJe.setVisibility(0);
        } else {
            aVar.nJe.setVisibility(4);
        }
        return view;
    }

    private static String ry(int i) {
        String valueOf = String.valueOf((char) i);
        for (String equals : IPCallCountryCodeScrollbar.nJf) {
            if (equals.equals(String.valueOf((char) i))) {
                return valueOf;
            }
        }
        return "#";
    }
}
