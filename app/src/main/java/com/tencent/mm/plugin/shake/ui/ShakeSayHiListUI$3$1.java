package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.3;

class ShakeSayHiListUI$3$1 implements OnClickListener {
    final /* synthetic */ 3 qss;

    ShakeSayHiListUI$3$1(3 3) {
        this.qss = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ShakeSayHiListUI.e(this.qss.qsr).Tt();
        ShakeSayHiListUI.b(this.qss.qsr).Xy();
        TextView textView = (TextView) this.qss.qsr.findViewById(R.h.cem);
        textView.setText(R.l.eHm);
        textView.setVisibility(0);
        this.qss.qsr.enableOptionMenu(false);
    }
}
