package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.5;

class NearbySayHiListUI$5$1 implements OnClickListener {
    final /* synthetic */ 5 oPp;

    NearbySayHiListUI$5$1(5 5) {
        this.oPp = 5;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        NearbySayHiListUI.e(this.oPp.oPo).Tt();
        NearbySayHiListUI.b(this.oPp.oPo).Xy();
        TextView textView = (TextView) this.oPp.oPo.findViewById(R.h.cem);
        textView.setText(R.l.eHm);
        textView.setVisibility(0);
        this.oPp.oPo.enableOptionMenu(false);
    }
}
