package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.platformtools.ac;

class o$2 implements OnClickListener {
    final /* synthetic */ o ysq;

    o$2(o oVar) {
        this.ysq = oVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (!a.vcx.Fs(this.ysq.crz())) {
            Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.ewG), 0).show();
        } else if (!a.vcx.Fz(this.ysq.crz())) {
            Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.ewh), 0).show();
        }
    }
}
