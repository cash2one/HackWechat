package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ReadMailUI$7 implements OnClickListener {
    final /* synthetic */ ReadMailUI puG;

    ReadMailUI$7(ReadMailUI readMailUI) {
        this.puG = readMailUI;
    }

    public final void onClick(View view) {
        switch (ReadMailUI.w(this.puG)) {
            case 0:
                ReadMailUI.a(this.puG, 2);
                if (bh.ov(ReadMailUI.x(this.puG)) || bh.ov(ReadMailUI.y(this.puG))) {
                    ReadMailUI.A(this.puG);
                    return;
                } else {
                    ReadMailUI.z(this.puG);
                    return;
                }
            case 1:
                ReadMailUI.a(this.puG, 1);
                int intValue = ((Integer) new ReadMailProxy(ReadMailUI.l(this.puG), null).REMOTE_CALL("removeDownloadQQMailAppTask", new Object[]{Long.valueOf(ReadMailUI.B(this.puG))})).intValue();
                if (intValue == -1) {
                    x.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", new Object[]{Long.valueOf(ReadMailUI.B(this.puG))});
                    return;
                } else if (intValue <= 0) {
                    x.e("MicroMsg.ReadMailUI", "cancel_download_task:fail downloadId = %d", new Object[]{Long.valueOf(ReadMailUI.B(this.puG))});
                    return;
                } else {
                    x.i("MicroMsg.ReadMailUI", "cancel_download_task:ok downloadId = %d", new Object[]{Long.valueOf(ReadMailUI.B(this.puG))});
                    ReadMailUI.C(this.puG).TG();
                    ReadMailUI.b(this.puG, 0);
                    ReadMailUI.D(this.puG);
                    ReadMailUI.p(this.puG);
                    return;
                }
            case 2:
                ReadMailUI.a(this.puG, 3);
                ReadMailUI.E(this.puG);
                return;
            case 3:
                ReadMailUI.a(this.puG, 4);
                ReadMailUI.F(this.puG);
                return;
            default:
                return;
        }
    }
}
