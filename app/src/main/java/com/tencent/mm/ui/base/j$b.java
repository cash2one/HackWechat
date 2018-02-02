package com.tencent.mm.ui.base;

import android.content.Context;
import android.widget.RadioGroup;
import com.tencent.mm.ui.base.i.a;
import com.tencent.mm.w.a.d;
import java.util.ArrayList;

public class j$b {
    public Context mContext;
    public i pyk;
    public final a vnq;
    public String xZQ = null;
    public String xZR = null;
    private boolean xZS = false;
    public boolean xZT = false;
    private RadioGroup xZU;
    private ArrayList<Integer> xZV = new ArrayList();

    public j$b(Context context) {
        this.mContext = context;
        this.vnq = new a(this.mContext);
        this.vnq.mi(false);
        this.vnq.mj(false);
        this.vnq.a(new 1(this));
    }

    public final j$b YK(String str) {
        this.vnq.YG(str);
        return this;
    }

    public final j$b EG(int i) {
        this.xZQ = this.mContext.getResources().getString(i);
        return this;
    }

    public final j$b a(j.a aVar, j.a aVar2) {
        this.pyk = this.vnq.akx();
        if (this.xZU != null) {
            this.xZU.setTag(this.pyk);
        }
        j.a(this.mContext, this.pyk, this.xZQ, this.xZR, this.xZT, aVar2, aVar);
        if (this.xZS) {
            this.pyk.Ey(this.mContext.getResources().getColor(d.bsE));
        }
        return this;
    }

    public final j$b a(j.a aVar) {
        this.pyk = this.vnq.akx();
        if (this.xZU != null) {
            this.xZU.setTag(this.pyk);
        }
        j.a(this.mContext, this.pyk, this.xZQ, this.xZR, this.xZT, aVar, aVar);
        return this;
    }
}
