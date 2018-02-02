package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class l extends b implements a {
    ViewGroup mContainer;
    Map<String, Long> zaV = new HashMap();
    Map<Long, b> zaW = new HashMap();

    public l(Context context) {
        super(context);
        o.TU().a(this, Looper.getMainLooper());
        this.mContainer = (ViewGroup) this.view;
    }

    public final int getLayoutId() {
        return R.i.dng;
    }

    public final void destroy() {
        o.TU().a(this);
    }

    private void akJ() {
        x.i("MicroMsg.MassSightBanner", "call update status");
        Runnable aVar = new a((byte) 0);
        aVar.zaX = new WeakReference(this);
        ar.Dm().F(aVar);
    }

    public final void a(a.a aVar) {
        String str = aVar.fileName;
        Long l = (Long) this.zaV.get(str);
        if (l == null) {
            x.d("MicroMsg.MassSightBanner", "massSendId is null, fileName %s", new Object[]{str});
            if (bh.az(str, "").startsWith("DELETE_")) {
                akJ();
                return;
            }
            return;
        }
        b bVar = (b) this.zaW.get(l);
        if (bVar == null) {
            x.d("MicroMsg.MassSightBanner", "find massSendId %d, but holder is null", new Object[]{l});
            return;
        }
        r nF = t.nF(str);
        if (nF == null) {
            x.w("MicroMsg.MassSightBanner", "on nofify changed, filename %s, massSendId %d, but videoinfo is null", new Object[]{str, l});
        } else if (nF.status == 199) {
            x.i("MicroMsg.MassSightBanner", "fileName %s, massSendId %d, done", new Object[]{str, l});
            akJ();
        } else {
            c.a(bVar, nF);
        }
    }
}
