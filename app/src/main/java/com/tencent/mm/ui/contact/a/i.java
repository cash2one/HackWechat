package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;

public final class i extends a {
    public int mPo;
    public boolean mPp;
    private b yVB = new b(this);
    com.tencent.mm.ui.contact.a.a.a yVz = new a(this);

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public TextView mPs;
        public ImageView mPt;
        final /* synthetic */ i yVC;

        public a(i iVar) {
            this.yVC = iVar;
            super(iVar);
        }
    }

    public class b extends a$b {
        final /* synthetic */ i yVC;

        public b(i iVar) {
            this.yVC = iVar;
            super(iVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(f.qfD, viewGroup, false);
            a aVar = (a) this.yVC.yVz;
            aVar.mPs = (TextView) inflate.findViewById(e.mPa);
            aVar.mPt = (ImageView) inflate.findViewById(e.cxi);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            i iVar = (i) aVar2;
            Resources resources = context.getResources();
            if (this.yVC.mPp) {
                com.tencent.mm.plugin.fts.d.e.a(resources.getString(h.mPm, new Object[]{resources.getString(iVar.mPo)}), aVar3.mPs);
                aVar3.mPt.setRotation(0.0f);
                return;
            }
            com.tencent.mm.plugin.fts.d.e.a(resources.getString(h.mPn), aVar3.mPs);
            aVar3.mPt.setRotation(180.0f);
        }

        public final boolean WS() {
            return false;
        }
    }

    public i(int i) {
        super(1, i);
    }

    public final void bH(Context context) {
    }

    public final a$b WQ() {
        return this.yVB;
    }

    protected final com.tencent.mm.ui.contact.a.a.a WR() {
        return this.yVz;
    }
}
