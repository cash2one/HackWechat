package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI.a;
import com.tencent.mm.ui.base.h;

class ReaderAppSubscribeUI$1 implements OnItemClickListener {
    final /* synthetic */ ReaderAppSubscribeUI pAO;

    ReaderAppSubscribeUI$1(ReaderAppSubscribeUI readerAppSubscribeUI) {
        this.pAO = readerAppSubscribeUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = 1;
        a a = ReaderAppSubscribeUI.a(this.pAO);
        if ((a.pAQ & a.pAP[i]) != 0) {
            a.pAQ &= a.pAP[i] ^ -1;
            a.pAS--;
            if (a.pAS < 0) {
                a.pAS = 0;
            }
            a.notifyDataSetChanged();
        } else if (a.pAS < 3) {
            a.pAQ |= a.pAP[i];
            a.pAS++;
            if (a.pAS > a.pAP.length) {
                a.pAS = a.pAP.length;
            }
            a.notifyDataSetChanged();
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            h.h(this.pAO, R.l.dWa, R.l.dGO);
        }
    }
}
