package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import org.json.JSONObject;

public final class g extends d implements Runnable {
    private final int iDP;
    private final String iDQ;
    private final c iDR = new c(this) {
        final /* synthetic */ g iDU;

        {
            this.iDU = r1;
        }

        public final void enter() {
            super.enter();
            x.i("MicroMsg.LibIncrementalTestCase[incremental]", "WriteMockLibInfo enter");
            String ZU = y.ZU();
            if (bh.ov(ZU)) {
                ag.y(new 4(this.iDU, "!!MockLibInfo Path Error!!"));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", this.iDU.iDP);
                File file = new File(ZU);
                file.delete();
                file.createNewFile();
                byte[] bytes = jSONObject.toString().getBytes("UTF-8");
                int b = e.b(file.getAbsolutePath(), bytes, bytes.length);
                if (b != 0) {
                    ag.y(new 4(this.iDU, "MockLibInfo Write Error " + b));
                } else {
                    this.iDU.b(this.iDU.iDS);
                }
            } catch (Exception e) {
                ag.y(new 4(this.iDU, "MockLibInfo Write Exception " + e.getMessage()));
            }
        }
    };
    private final c iDS = new 2(this);
    final c iDT = new 3(this);

    public g(int i, String str) {
        super("LibIncrementalTestCase", Looper.getMainLooper());
        this.iDP = i;
        this.iDQ = str;
    }

    public final void run() {
        a(this.iDR);
        a(this.iDS);
        a(this.iDT);
        b(this.iDR);
        start();
    }

    protected final void ZF() {
        super.ZF();
        x.i("MicroMsg.LibIncrementalTestCase[incremental]", "TestCase onQuitting");
    }
}
