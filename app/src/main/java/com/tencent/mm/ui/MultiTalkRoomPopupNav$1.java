package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class MultiTalkRoomPopupNav$1 implements OnClickListener {
    final /* synthetic */ MultiTalkRoomPopupNav xLr;

    MultiTalkRoomPopupNav$1(MultiTalkRoomPopupNav multiTalkRoomPopupNav) {
        this.xLr = multiTalkRoomPopupNav;
    }

    public final void onClick(View view) {
        if (a.vcw != null && a.vcx.aW(this.xLr.getContext())) {
            x.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
        } else if (a.vcw == null || !a.vcw.aVK()) {
            MultiTalkRoomPopupNav.a(this.xLr);
        } else {
            Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.eps), 0).show();
            x.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
        }
    }
}
