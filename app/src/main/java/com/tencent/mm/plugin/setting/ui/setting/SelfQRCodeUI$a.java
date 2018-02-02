package com.tencent.mm.plugin.setting.ui.setting;

import android.net.Uri;
import android.os.FileObserver;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public class SelfQRCodeUI$a extends FileObserver {
    final /* synthetic */ SelfQRCodeUI qhD;
    private MMActivity qhE;
    private String qhF;

    public SelfQRCodeUI$a(SelfQRCodeUI selfQRCodeUI, MMActivity mMActivity) {
        this.qhD = selfQRCodeUI;
        super(SelfQRCodeUI.bfT(), 8);
        this.qhE = mMActivity;
    }

    public final void onEvent(int i, String str) {
        if (str != null && i == 8) {
            if (this.qhF == null || !str.equalsIgnoreCase(this.qhF)) {
                this.qhF = str;
                Uri.fromFile(new File(SelfQRCodeUI.bfT() + str));
                SelfQRCodeUI.bqv();
                x.i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
            }
        }
    }

    public final void start() {
        super.startWatching();
    }

    public final void stop() {
        super.stopWatching();
    }
}
