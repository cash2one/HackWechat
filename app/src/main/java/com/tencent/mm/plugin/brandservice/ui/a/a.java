package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;

public final class a extends b {
    public j iVU;
    public String iconUrl;
    public x jLe;
    public CharSequence kHu;
    public CharSequence kHv;
    private b kHw = new b(this);
    a kHx = new a(this);
    public String username;

    public class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View contentView;
        public ImageView iip;
        public TextView iiq;
        public TextView iir;
        final /* synthetic */ a kHy;

        public a(a aVar) {
            this.kHy = aVar;
            super(aVar);
        }
    }

    public a(int i) {
        super(4, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        this.username = this.iVU.mLs;
        ar.Hg();
        this.jLe = c.EY().WO(this.username);
        d jS = f.jS(this.username);
        this.iconUrl = jS == null ? "" : jS.field_brandIconURL;
        Object gu = r.gu(this.username);
        int i;
        if (jS == null || jS.Lk()) {
            i = 1;
        } else {
            i = 0;
        }
        boolean z;
        boolean z2;
        int i2;
        int i3;
        switch (this.iVU.mLr) {
            case 1:
                z = false;
                z2 = false;
                break;
            case 2:
                z = false;
                break;
            case 3:
                z = true;
                break;
            case 15:
                String vN = this.jLe.vN();
                if (bh.ov(vN)) {
                    vN = this.jLe.field_username;
                }
                i2 = 1;
                i3 = 0;
                Object string = context.getString(R.l.eIM);
                Object obj = vN;
                z = false;
                z2 = false;
                break;
            case 19:
                z2 = false;
                boolean z3 = false;
                break;
            case 20:
                z = false;
                break;
            case 21:
                z = true;
                break;
            default:
                z = false;
                z2 = false;
                i2 = 0;
                CharSequence charSequence = null;
                CharSequence charSequence2 = null;
                i3 = 0;
                break;
        }
    }

    public final b.b adp() {
        return this.kHw;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adq() {
        return this.kHx;
    }

    public final int ads() {
        return this.iVU.mMo;
    }
}
