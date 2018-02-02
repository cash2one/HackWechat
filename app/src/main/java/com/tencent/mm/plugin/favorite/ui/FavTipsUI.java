package com.tencent.mm.plugin.favorite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.i.a;

public class FavTipsUI extends MMBaseActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = new a(this);
        aVar.YF(getString(R.l.efG));
        aVar.YG(getString(R.l.efE) + "\n\n" + getString(R.l.efF));
        aVar.EC(R.l.efD).a(new 1(this));
        aVar.d(new OnCancelListener(this) {
            final /* synthetic */ FavTipsUI mtJ;

            {
                this.mtJ = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.mtJ.finish();
            }
        });
        aVar.akx().show();
    }
}
