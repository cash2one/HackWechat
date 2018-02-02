package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.storage.emotion.EmojiInfo;

class m$3 implements OnItemClickListener {
    final /* synthetic */ m vrP;

    m$3(m mVar) {
        this.vrP = mVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmojiInfo oO = this.vrP.vrL == null ? null : this.vrP.vrL.oO(i);
        if (!(oO == null || this.vrP.vrG == null || this.vrP.vqr == null)) {
            this.vrP.vrG.l(oO);
            this.vrP.vqr.clear();
            g.pQN.h(10994, new Object[]{Integer.valueOf(1), this.vrP.vrH, "", Integer.valueOf(i), oO.Nr(), Integer.valueOf(this.vrP.vrL.getCount())});
        }
        this.vrP.vrE.dismiss();
    }
}
