package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;

public class NoRomSpaceDexUI extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bh.initLanguage(ac.getContext());
        setContentView(R.i.dpb);
        CharSequence string = getString(R.l.dTt);
        n nVar = new n(this);
        nVar.setTitle(R.l.dTu);
        nVar.xIb.setVisibility(0);
        nVar.xHZ.setVisibility(0);
        nVar.xHZ.setText(string);
        string = getString(R.l.dTr);
        OnClickListener anonymousClass1 = new OnClickListener(this) {
            final /* synthetic */ NoRomSpaceDexUI xLV;

            {
                this.xLV = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                Process.killProcess(Process.myPid());
            }
        };
        if (nVar.sVn != null) {
            nVar.sVn.setVisibility(0);
            nVar.sVn.setText(string);
            nVar.sVn.setOnClickListener(new com.tencent.mm.ui.n.AnonymousClass1(nVar, anonymousClass1, true));
        }
        nVar.setCancelable(false);
        nVar.cmN();
        nVar.show();
    }
}
