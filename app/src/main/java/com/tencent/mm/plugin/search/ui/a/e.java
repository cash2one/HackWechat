package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.a.b$b;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.a.c;

public class e extends c {
    public String mLS;
    protected CharSequence qdQ;
    protected String qdR;
    protected CharSequence qdS;
    protected String qdT;
    public j qdU;
    private a qdV = new a(this);
    b qdW = new b(this);
    public int showType;

    public e(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(Context context, a aVar, Object... objArr) {
        String str = this.qdU.mLs;
        boolean z = false;
        boolean z2 = false;
        switch (this.qdU.mLr) {
            case 1:
                z2 = false;
                z = false;
                break;
            case 2:
                break;
            case 3:
                z = true;
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                z = true;
                break;
            default:
                String str2 = null;
                boolean z3 = false;
                boolean z4 = false;
                CharSequence charSequence = null;
                break;
        }
    }

    public b$b adp() {
        return this.qdV;
    }

    protected final a adq() {
        return this.qdW;
    }
}
