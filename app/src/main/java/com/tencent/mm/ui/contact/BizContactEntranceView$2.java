package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.MMActivity;

class BizContactEntranceView$2 implements OnTouchListener {
    final /* synthetic */ BizContactEntranceView yRl;

    BizContactEntranceView$2(BizContactEntranceView bizContactEntranceView) {
        this.yRl = bizContactEntranceView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (BizContactEntranceView.a(this.yRl) instanceof MMActivity) {
            ((MMActivity) BizContactEntranceView.a(this.yRl)).aWs();
        }
        return false;
    }
}
