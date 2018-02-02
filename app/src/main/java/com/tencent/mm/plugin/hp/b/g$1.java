package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.ac;

class g$1 implements OnClickListener {
    final /* synthetic */ g nAQ;

    g$1(g gVar) {
        this.nAQ = gVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Toast.makeText(ac.getContext(), "OK", 0).show();
    }
}
