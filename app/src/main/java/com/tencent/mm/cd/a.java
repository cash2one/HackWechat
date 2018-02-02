package com.tencent.mm.cd;

import com.tencent.mm.vending.b.b;
import com.tencent.mm.vending.h.d;
import java.util.Iterator;

public class a<_Callback> extends com.tencent.mm.vending.b.a<_Callback> {

    public interface a<_Callback> {
        void az(_Callback _Callback);
    }

    public a() {
        super(new e());
    }

    public a(d dVar) {
        super(dVar);
    }

    public final void a(final a<_Callback> aVar) {
        Iterator it = czM().iterator();
        while (it.hasNext()) {
            final b bVar = (b) it.next();
            if (bVar != null) {
                if (bVar.ffh != null) {
                    this.zBL.b(bVar.ffh);
                    this.zBL.a(new com.tencent.mm.vending.c.a<Void, Void>(this) {
                        final /* synthetic */ a zJR;

                        public final /* synthetic */ Object call(Object obj) {
                            Void voidR = (Void) obj;
                            aVar.az(bVar.zBN);
                            return voidR;
                        }
                    }, com.tencent.mm.vending.c.a.zBS, true);
                } else {
                    aVar.az(bVar.zBN);
                }
            }
        }
    }

    public b<_Callback> aE(_Callback _Callback) {
        return super.a(new b(_Callback, this));
    }

    public final void remove(_Callback _Callback) {
        super.b(new b(_Callback, this));
    }
}
