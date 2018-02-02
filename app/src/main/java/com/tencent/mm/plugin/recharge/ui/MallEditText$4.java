package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class MallEditText$4 implements OnItemClickListener {
    final /* synthetic */ MallEditText pCy;

    MallEditText$4(MallEditText mallEditText) {
        this.pCy = mallEditText;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MallEditText.a(this.pCy, MallEditText.d(this.pCy).vl(i));
        if (MallEditText.e(this.pCy) != null) {
            x.d("MicroMsg.MallEditText", "onItemClick record.record " + MallEditText.e(this.pCy).pBH + ", record.name " + MallEditText.e(this.pCy).name);
            this.pCy.b(MallEditText.e(this.pCy));
        }
        MallEditText.a(this.pCy).dismissDropDown();
    }
}
