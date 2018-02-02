package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class MassSendHistoryUI$9 implements OnItemClickListener {
    final /* synthetic */ MassSendHistoryUI onL;

    MassSendHistoryUI$9(MassSendHistoryUI massSendHistoryUI) {
        this.onL = massSendHistoryUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.v("MicroMsg.MassSendHistoryUI", "onItemClick");
    }
}
