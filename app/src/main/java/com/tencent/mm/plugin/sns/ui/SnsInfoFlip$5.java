package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.sdk.platformtools.bh;

class SnsInfoFlip$5 implements OnItemLongClickListener {
    final /* synthetic */ SnsInfoFlip rCB;

    SnsInfoFlip$5(SnsInfoFlip snsInfoFlip) {
        this.rCB = snsInfoFlip;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!SnsInfoFlip.i(this.rCB)) {
            return true;
        }
        String str = ((b) SnsInfoFlip.d(this.rCB).getItem(i)).raG;
        if (bh.ov(str)) {
            return false;
        }
        String str2 = ((b) SnsInfoFlip.d(this.rCB).getItem(i)).fHC.nGJ;
        this.rCB.d(am.r(ae.getAccSnsPath(), str2) + i.l(((b) SnsInfoFlip.d(this.rCB).getItem(i)).fHC), str, str2, true);
        return true;
    }
}
