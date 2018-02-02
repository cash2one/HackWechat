package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.o.a.b;
import java.util.ArrayList;
import java.util.List;

public class InvoiceListUI$a extends BaseAdapter {
    private final Context context;
    List<b> hiv = new ArrayList();
    final /* synthetic */ InvoiceListUI ins;

    public final /* synthetic */ Object getItem(int i) {
        return jm(i);
    }

    public InvoiceListUI$a(InvoiceListUI invoiceListUI, Context context) {
        this.ins = invoiceListUI;
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2 = new a(this);
        if (view == null) {
            view = View.inflate(this.context, R.i.dtS, null);
            aVar2.inv = (ImageView) view.findViewById(R.h.bVW);
            aVar2.inu = (TextView) view.findViewById(R.h.bJf);
            aVar2.inw = (TextView) view.findViewById(R.h.bJl);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        b jm = jm(i);
        if (jm.type != null && jm.type.equals("0")) {
            aVar.inu.setText(R.l.eqg);
            aVar.inw.setText(jm.title);
        } else if (jm.type != null && jm.type.equals("1")) {
            aVar.inu.setText(R.l.eqi);
            aVar.inw.setText(jm.nBJ);
        }
        if (InvoiceListUI.d(this.ins) && InvoiceListUI.e(this.ins) != null && InvoiceListUI.e(this.ins).nBI == jm.nBI) {
            aVar.inv.setImageResource(R.k.dAr);
        } else {
            aVar.inv.setImageBitmap(null);
        }
        return view;
    }

    public final int getCount() {
        return this.hiv.size();
    }

    private b jm(int i) {
        return (b) this.hiv.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
