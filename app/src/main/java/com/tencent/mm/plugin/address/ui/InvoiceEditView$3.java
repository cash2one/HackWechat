package com.tencent.mm.plugin.address.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class InvoiceEditView$3 implements TextWatcher {
    final /* synthetic */ InvoiceEditView inj;

    InvoiceEditView$3(InvoiceEditView invoiceEditView) {
        this.inj = invoiceEditView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        int i = 0;
        if (InvoiceEditView.a(this.inj) == 5 && InvoiceEditView.b(this.inj) != editable.toString().length()) {
            CharSequence charSequence;
            InvoiceEditView.a(this.inj, editable.toString().length());
            InvoiceEditView invoiceEditView = this.inj;
            String obj = editable.toString();
            if (invoiceEditView.imU == 5) {
                String replace = obj.replace(" ", "");
                if (replace.length() >= 4) {
                    StringBuilder stringBuilder = new StringBuilder();
                    if (replace.length() % 4 == 0) {
                        while (i < (replace.length() / 4) - 1) {
                            stringBuilder.append(replace.substring(i * 4, (i + 1) * 4)).append(" ");
                            i++;
                        }
                        charSequence = obj;
                    } else {
                        while (i < replace.length() / 4) {
                            stringBuilder.append(replace.substring(i * 4, (i + 1) * 4)).append(" ");
                            i++;
                        }
                        charSequence = stringBuilder.append(replace.substring((replace.length() / 4) * 4, replace.length())).toString();
                    }
                    invoiceEditView.imQ.setText(charSequence);
                    invoiceEditView.imQ.setSelection(invoiceEditView.imQ.getText().length());
                }
            }
            Object obj2 = obj;
            invoiceEditView.imQ.setText(charSequence);
            invoiceEditView.imQ.setSelection(invoiceEditView.imQ.getText().length());
        }
        boolean XO = this.inj.XO();
        if (!(XO == this.inj.imY || InvoiceEditView.c(this.inj) == null)) {
            x.d("MicroMsg.InvoiceEditView", "View:" + InvoiceEditView.d(this.inj) + ", editType:" + InvoiceEditView.a(this.inj) + " inputValid change to " + XO);
            this.inj.imY = XO;
            InvoiceEditView.c(this.inj).XL();
        }
        if ((!this.inj.inf || this.inj.imY) && this.inj.inf && this.inj.imY) {
            InvoiceEditView.e(this.inj).setTextColor(this.inj.getResources().getColor(R.e.black));
        }
        InvoiceEditView.a(this.inj, InvoiceEditView.e(this.inj).isFocused());
    }
}
