package com.tencent.mm.pluginsdk.ui.preference;

import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h$c;

class FMessageListView$4 implements OnLongClickListener {
    final /* synthetic */ FMessageListView vtj;
    final /* synthetic */ b vtk;

    FMessageListView$4(FMessageListView fMessageListView, b bVar) {
        this.vtj = fMessageListView;
        this.vtk = bVar;
    }

    public final boolean onLongClick(View view) {
        x.d("MicroMsg.FMessageListView", "jacks long click digest");
        h.a(this.vtj.getContext(), null, new String[]{this.vtj.getContext().getString(R.l.dQK)}, new h$c(this) {
            final /* synthetic */ FMessageListView$4 vtl;

            {
                this.vtl = r1;
            }

            public final void jl(int i) {
                switch (i) {
                    case 0:
                        ((ClipboardManager) this.vtl.vtj.getContext().getSystemService("clipboard")).setText(this.vtl.vtk.hef);
                        return;
                    default:
                        return;
                }
            }
        });
        return true;
    }
}
