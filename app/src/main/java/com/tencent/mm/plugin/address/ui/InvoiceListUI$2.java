package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.address.e.e;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.sdk.platformtools.x;

class InvoiceListUI$2 implements OnItemClickListener {
    final /* synthetic */ InvoiceListUI ins;

    InvoiceListUI$2(InvoiceListUI invoiceListUI) {
        this.ins = invoiceListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.InvoiceListUI", "select pos " + i);
        synchronized (InvoiceListUI.b(this.ins)) {
            if (i < InvoiceListUI.c(this.ins).size()) {
                InvoiceListUI.a(this.ins, (b) InvoiceListUI.c(this.ins).get(i));
                if (!InvoiceListUI.d(this.ins) && InvoiceListUI.e(this.ins) != null) {
                    InvoiceListUI.a(this.ins, InvoiceListUI.e(this.ins).nBI);
                } else if (!(InvoiceListUI.e(this.ins) == null || InvoiceListUI.e(this.ins).nBI == 0)) {
                    Intent intent = new Intent();
                    intent.putExtra("choose_invoice_title_info", e.a(InvoiceListUI.e(this.ins)));
                    this.ins.setResult(-1, intent);
                    this.ins.finish();
                }
            }
        }
        InvoiceListUI.f(this.ins).notifyDataSetChanged();
    }
}
