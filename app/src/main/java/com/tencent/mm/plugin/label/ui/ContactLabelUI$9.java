package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.bh;

class ContactLabelUI$9 implements OnItemClickListener {
    final /* synthetic */ ContactLabelUI nPX;

    ContactLabelUI$9(ContactLabelUI contactLabelUI) {
        this.nPX = contactLabelUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ContactLabelUI.f(this.nPX) != null) {
            String kC = ContactLabelUI.f(this.nPX).kC(i);
            if (!bh.ov(kC) && ContactLabelUI.b(this.nPX) != null) {
                ContactLabelUI.b(this.nPX).cpD();
                ContactLabelUI.b(this.nPX).bi(kC, true);
                ContactLabelUI.c(this.nPX).bj(kC, true);
            }
        }
    }
}
