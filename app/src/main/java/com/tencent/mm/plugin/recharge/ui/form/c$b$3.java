package com.tencent.mm.plugin.recharge.ui.form;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.recharge.ui.form.c.b;
import com.tencent.mm.sdk.platformtools.x;

class c$b$3 implements OnItemClickListener {
    final /* synthetic */ b pEe;
    final /* synthetic */ InstantAutoCompleteTextView pEf;

    public c$b$3(b bVar, InstantAutoCompleteTextView instantAutoCompleteTextView) {
        this.pEe = bVar;
        this.pEf = instantAutoCompleteTextView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.pEe.pCu = this.pEe.pEc.vl(i);
        if (this.pEe.pCu != null) {
            x.i(c.TAG, "onItemClick record.record " + this.pEe.pCu.pBH + ", record.name " + this.pEe.pCu.name);
            this.pEe.pEd = true;
            this.pEe.b(this.pEe.pCu);
        } else {
            x.w(c.TAG, "record is null");
        }
        this.pEf.dismissDropDown();
    }
}
