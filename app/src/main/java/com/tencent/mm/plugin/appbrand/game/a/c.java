package com.tencent.mm.plugin.appbrand.game.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.f;

public final class c extends b {
    public j iVU;
    public CharSequence iVW;
    public i iXT;
    public com.tencent.mm.plugin.appbrand.game.a.a.b iXU;
    private b iXV = new b(this);
    a iXW = new a(this);

    public class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View contentView;
        public TextView iVZ;
        public TextView iWa;
        public TextView iXX;
        final /* synthetic */ c iXY;
        public ImageView iip;
        public TextView iiq;

        public a(c cVar) {
            this.iXY = cVar;
            super(cVar);
        }
    }

    public c(int i) {
        super(20, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        boolean z = true;
        boolean z2 = false;
        this.iXT = i.rI(this.iVU.mLs);
        this.iXU = i.rH(this.iVU.mLs);
        if (this.iXU != null) {
            switch (this.iVU.mLr) {
                case 2:
                    break;
                case 3:
                    z2 = true;
                    break;
                default:
                    z = false;
                    break;
            }
            this.iVW = f.a(com.tencent.mm.plugin.fts.d.b.a.a(this.iXU.field_AppName, this.mMb, z, z2)).mQk;
            this.info = this.iXU.field_AppId;
        }
    }

    public final b.b adp() {
        return this.iXV;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adq() {
        return this.iXW;
    }

    public final String adr() {
        if (this.iXU == null) {
            return ":";
        }
        return String.format("%s:%s", new Object[]{this.iXU.field_AppId, this.iXU.field_AppName});
    }

    public final int ads() {
        return this.iVU.mMo;
    }
}
