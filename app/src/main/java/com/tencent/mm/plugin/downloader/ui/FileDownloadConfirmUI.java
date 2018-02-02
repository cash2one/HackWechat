package com.tencent.mm.plugin.downloader.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.downloader.b$b;
import com.tencent.mm.plugin.downloader.b$c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.i.a;

public class FileDownloadConfirmUI extends MMBaseActivity {
    private i ibT = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b$b.empty);
        OnClickListener 1 = new 1(this, getIntent().getLongExtra("extra_download_id", -1));
        OnClickListener anonymousClass2 = new OnClickListener(this) {
            final /* synthetic */ FileDownloadConfirmUI lsV;

            {
                this.lsV = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        };
        OnDismissListener 3 = new 3(this);
        a aVar = new a(this);
        aVar.YF("");
        aVar.EA(b$c.lra);
        aVar.EC(b$c.dHd).a(1);
        aVar.ED(b$c.dFR).b(anonymousClass2);
        aVar.a(3);
        this.ibT = aVar.akx();
        this.ibT.show();
        x.i("MicroMsg.FileDownloadConfirmUI", "Confirm Dialog");
    }

    public void onNewIntent(Intent intent) {
        x.i("MicroMsg.FileDownloadConfirmUI", "onNewIntent");
    }

    protected void onStop() {
        super.onStop();
        this.ibT.dismiss();
    }
}
