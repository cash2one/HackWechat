package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class bg extends i<bf> implements g {
    public static final String[] gJN = new String[]{i.a(bf.gJc, "Stranger")};
    private e gJP;
    private final k<a, bf> xzI = new k<a, bf>(this) {
        final /* synthetic */ bg xzX;

        {
            this.xzX = r1;
        }

        protected final /* synthetic */ void p(Object obj, Object obj2) {
            ((a) obj).a((bf) obj2);
        }
    };

    public final /* synthetic */ boolean a(c cVar) {
        bf bfVar = (bf) cVar;
        Assert.assertTrue("stranger NULL !", bfVar != null);
        x.d("MicroMsg.StrangerStorage", "replace : encryptUsername=%s, conRemark=%s", bfVar.field_encryptUsername, bfVar.field_conRemark);
        if (this.gJP.replace("Stranger", "", bfVar.vI()) > 0) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i == 0) {
            return false;
        }
        b(bfVar);
        return true;
    }

    private void b(bf bfVar) {
        if (this.xzI.ca(bfVar)) {
            this.xzI.doNotify();
        }
    }

    public final void a(a aVar) {
        this.xzI.a(aVar, null);
    }

    public final void b(a aVar) {
        this.xzI.remove(aVar);
    }

    public bg(e eVar) {
        super(eVar, bf.gJc, "Stranger", null);
        this.gJP = eVar;
    }

    public final bf EZ(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        bf bfVar = new bf();
        Cursor a = this.gJP.a("Stranger", null, "encryptUsername = ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            bfVar.b(a);
        }
        a.close();
        return bfVar;
    }

    public final int Fa(String str) {
        int delete = this.gJP.delete("Stranger", "(encryptUsername=?)", new String[]{str});
        if (delete > 0) {
            doNotify();
        }
        x.i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + str + " result:" + delete);
        return delete;
    }
}
