package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class r implements e {
    Context context;
    com.tencent.mm.ui.base.r mIl;
    l pZz;
    ak plq = new ak(new 1(this), false);
    String url;

    public r(Context context) {
        this.context = context;
    }

    final void b(String str, int i, byte[] bArr) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("geta8key_session_id", i);
        intent.putExtra("geta8key_cookie", bArr);
        b.ifs.j(intent, this.context);
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.plq.TG();
        if (this.mIl != null) {
            this.mIl.dismiss();
        }
        ar.CG().b(233, this);
        l lVar = (l) kVar;
        if (i == 0 && i2 == 0) {
            String RE = lVar.RE();
            if (RE == null || RE.length() == 0) {
                b(this.url, lVar.RM(), lVar.RN());
                return;
            } else {
                b(RE, lVar.RM(), lVar.RN());
                return;
            }
        }
        x.e("MicroMsg.scanner.ViewMMURL", "getA8Key fail, errType = " + i + ", errCode = " + i2);
        b(this.url, lVar.RM(), lVar.RN());
    }
}
