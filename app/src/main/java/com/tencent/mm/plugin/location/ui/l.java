package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class l {
    public i iRs = null;
    public Context mContext;
    public Resources mResources;
    public a nUR;

    class AnonymousClass8 implements OnClickListener {
        final /* synthetic */ int iGh;
        final /* synthetic */ l nUS;

        public AnonymousClass8(l lVar, int i) {
            this.nUS = lVar;
            this.iGh = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.nUS.nUR != null) {
                this.nUS.nUR.rQ(this.iGh);
            }
        }
    }

    public l(Context context, a aVar) {
        this.mContext = context;
        this.nUR = aVar;
        this.mResources = this.mContext.getResources();
    }

    public final void aWh() {
        if (!rO(67590)) {
            h.a(this.mContext, this.mResources.getString(R.l.eto), "", false, new 4(this), new 5(this));
            rP(67590);
        } else if (this.nUR != null) {
            this.nUR.aWi();
        }
    }

    public static boolean rO(int i) {
        ar.Hg();
        Object obj = c.CU().get(i, null);
        if (obj == null) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public static void rP(int i) {
        ar.Hg();
        c.CU().set(i, Boolean.valueOf(true));
    }
}
