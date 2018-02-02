package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class e extends i<f> implements d {
    private com.tencent.mm.sdk.e.e gJP;
    private Vector<c> pFm = new Vector();

    public final /* synthetic */ boolean a(long j, com.tencent.mm.sdk.e.c cVar) {
        f fVar = (f) cVar;
        if (!super.a(j, fVar)) {
            return false;
        }
        b(1, fVar);
        return true;
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.e.c cVar) {
        f fVar = (f) cVar;
        if (!super.a(fVar)) {
            return false;
        }
        b(1, fVar);
        return true;
    }

    public final /* synthetic */ boolean b(com.tencent.mm.sdk.e.c cVar) {
        return a((f) cVar);
    }

    public final /* synthetic */ boolean c(com.tencent.mm.sdk.e.c cVar, String[] strArr) {
        return b((f) cVar, strArr);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, f.gJc, "RecordCDNInfo", null);
        this.gJP = eVar;
    }

    public final void a(final c cVar) {
        g.Dm().F(new Runnable(this) {
            final /* synthetic */ e pFo;

            public final void run() {
                if (!this.pFo.pFm.contains(cVar)) {
                    this.pFo.pFm.add(cVar);
                }
            }
        });
    }

    public final void b(c cVar) {
        g.Dm().F(new 2(this, cVar));
    }

    private void b(final int i, final f fVar) {
        g.Dm().F(new Runnable(this) {
            final /* synthetic */ e pFo;

            public final void run() {
                Iterator it = this.pFo.pFm.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(i, fVar);
                }
            }
        });
    }

    public final List<f> bmM() {
        List<f> linkedList = new LinkedList();
        Cursor a = this.gJP.a("SELECT * FROM RecordCDNInfo WHERE status != 3 AND status != 4 AND status != 2", null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                f fVar = new f();
                fVar.b(a);
                linkedList.add(fVar);
            }
            a.close();
        }
        x.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    public final List<f> vp(int i) {
        List<f> linkedList = new LinkedList();
        Cursor a = this.gJP.a("SELECT * FROM RecordCDNInfo WHERE recordLocalId = " + i, null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                f fVar = new f();
                fVar.b(a);
                linkedList.add(fVar);
            }
            a.close();
        }
        x.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    public final f Ij(String str) {
        f fVar = null;
        Cursor a = this.gJP.a("SELECT * FROM RecordCDNInfo WHERE mediaId='" + str + "'", null, 2);
        if (a != null && a.moveToFirst()) {
            fVar = new f();
            fVar.b(a);
        }
        if (a != null) {
            a.close();
        }
        return fVar;
    }

    public final boolean a(f fVar, String... strArr) {
        if (!super.a(fVar, strArr)) {
            return false;
        }
        b(0, fVar);
        return true;
    }

    public final boolean b(f fVar, String... strArr) {
        if (!super.c(fVar, strArr)) {
            return false;
        }
        b(1, fVar);
        return true;
    }

    public final boolean a(f fVar) {
        if (fVar != null) {
            x.v("MicroMsg.RecordMsgCDNStorage", "insert record cdn info %s", new Object[]{fVar});
            if (!super.b(fVar)) {
                return false;
            }
            b(2, fVar);
            return true;
        }
        x.e("MicroMsg.RecordMsgCDNStorage", "insert null record cdn info");
        return false;
    }
}
