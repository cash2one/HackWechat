package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;

class SnsInfoFlip$4 implements OnItemSelectedListener {
    final /* synthetic */ SnsInfoFlip rCB;

    SnsInfoFlip$4(SnsInfoFlip snsInfoFlip) {
        this.rCB = snsInfoFlip;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (SnsInfoFlip.d(this.rCB) != null) {
            if (SnsInfoFlip.e(this.rCB) && SnsInfoFlip.d(this.rCB).getCount() > 1) {
                SnsInfoFlip.f(this.rCB).setVisibility(0);
                SnsInfoFlip.f(this.rCB).xa(i);
            }
            SnsInfoFlip.a(this.rCB, ((b) SnsInfoFlip.d(this.rCB).getItem(i)).fHC, i, ((b) SnsInfoFlip.d(this.rCB).getItem(i)).raG);
            if (view instanceof MultiTouchImageView) {
                ((MultiTouchImageView) view).cpS();
            }
            if ((SnsInfoFlip.g(this.rCB) instanceof MMGestureGallery) && (SnsInfoFlip.h(this.rCB) instanceof SnsBrowseUI)) {
                ((SnsBrowseUI) SnsInfoFlip.h(this.rCB)).bAz();
            }
        }
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
