package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.a.b$b;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.f;

public final class i extends b {
    public int actionType = -1;
    public j iVU;
    public CharSequence moP;
    public String moS;
    public CharSequence qeo;
    public String qep;
    public c qeq;
    private b qer = new b(this);
    a qes = new a(this);

    public i(int i) {
        super(3, i);
    }

    public final void a(Context context, a aVar, Object... objArr) {
        boolean z = true;
        this.qeq = (c) this.iVU.userData;
        if (this.qeq != null) {
            boolean z2;
            this.moP = this.qeq.field_title;
            this.qeo = this.qeq.field_tag;
            this.moS = this.qeq.field_iconPath;
            this.qep = this.qeq.field_androidUrl;
            this.actionType = this.qeq.field_actionType;
            switch (this.iVU.mLr) {
                case 1:
                    z = false;
                    z2 = false;
                    break;
                case 2:
                    z2 = false;
                    break;
                case 3:
                    z2 = true;
                    break;
                case 4:
                    this.qeo = f.a(com.tencent.mm.plugin.fts.d.b.a.a(this.qeo, this.mMb)).mQk;
                    return;
                default:
                    return;
            }
            this.moP = f.a(com.tencent.mm.plugin.fts.d.b.a.a(this.moP, this.mMb, z, z2)).mQk;
        }
    }

    public final b$b adp() {
        return this.qer;
    }

    protected final a adq() {
        return this.qes;
    }

    public final String adr() {
        return this.qeq.field_title;
    }

    public final int ads() {
        return this.iVU.mMo;
    }
}
