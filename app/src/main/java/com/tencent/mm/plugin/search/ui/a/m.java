package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.d.a.b;

public final class m extends e {
    private a qeI = new a(this);

    public class a extends e$a {
        final /* synthetic */ m qeJ;

        public a(m mVar) {
            this.qeJ = mVar;
            super(mVar);
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, b bVar, Object... objArr) {
            super.a(context, aVar, bVar, objArr);
            ((e$b) aVar).mPP.setVisibility(8);
        }
    }

    public m(int i) {
        super(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        String str = this.qdU.mLs;
        boolean z;
        boolean z2;
        switch (this.qdU.mLr) {
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
            case 5:
                z = false;
                z2 = false;
                break;
            case 6:
                z = false;
                break;
            case 7:
                z = true;
                break;
            default:
                String str2 = null;
                CharSequence charSequence = null;
                boolean z3 = false;
                boolean z4 = false;
                break;
        }
    }

    public final b.b adp() {
        return this.qeI;
    }
}
