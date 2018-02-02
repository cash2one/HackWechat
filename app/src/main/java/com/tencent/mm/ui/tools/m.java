package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.a;
import com.tencent.mm.ui.base.p.b;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.v;
import com.tencent.mm.w.a.k;

public final class m extends q {
    private LayoutInflater DF;
    public c rKC;
    public d rKD;
    private n rKE;
    private boolean ryW = true;
    private a zlt;
    private b zlu;
    private a zly;

    static /* synthetic */ CharSequence f(m mVar) {
        return (mVar.rKE.Lp == null || mVar.rKE.Lp.length() == 0) ? mVar.mContext.getResources().getString(k.gYv) : mVar.rKE.Lp;
    }

    public m(Context context) {
        super(context);
        this.DF = v.fv(context);
        this.rKE = new n();
    }

    public final boolean dM() {
        if (this.rKC != null) {
            this.rKC.a(this.rKE);
        }
        boolean z = this.rKE.Lp != null && this.rKE.Lp.length() > 0;
        this.ryW = z;
        return super.dM();
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.ryW || i != 0) {
            if (this.ryW) {
                i--;
            }
            if (this.rKD != null) {
                this.rKD.onMMMenuItemSelected(this.rKE.getItem(i), i);
            }
            dismiss();
        }
    }

    protected final BaseAdapter asU() {
        if (this.zly == null) {
            this.zly = new a(this, (byte) 0);
        }
        return this.zly;
    }
}
