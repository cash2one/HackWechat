package com.tencent.mm.app;

import android.os.FileObserver;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

class i$a extends FileObserver {
    final /* synthetic */ i ffx;

    i$a(i iVar, String str) {
        this.ffx = iVar;
        super(str, 712);
    }

    public final void onEvent(int i, String str) {
        Object obj = null;
        if (System.currentTimeMillis() - i.a(this.ffx) < 120000) {
            obj = 1;
        }
        if (obj == null) {
            synchronized (this.ffx.ffm) {
                switch (i) {
                    case 8:
                        x.i("MicroMsg.MMCrashReporter", "Detected trace file changed: " + str);
                        this.ffx.ffp.open();
                        if (this.ffx.ffv == null) {
                            this.ffx.ffv = new i$b(this.ffx);
                            e.post(this.ffx.ffv, "MMCrashReporter_parseANRTrace");
                            break;
                        }
                        break;
                    case 64:
                    case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                        this.ffx.ffm.remove(str);
                        break;
                    case FileUtils.S_IWUSR /*128*/:
                        break;
                }
                this.ffx.ffm.add(str);
            }
        }
    }
}
