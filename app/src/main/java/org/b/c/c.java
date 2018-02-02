package org.b.c;

import java.util.Collections;
import org.b.d.e;
import org.b.g.d;

public final class c implements b {
    public final String a(org.b.d.c cVar) {
        d.j(cVar, "Cannot extract base string from null object");
        if (cVar.Ayq == null || cVar.Ayq.size() <= 0) {
            throw new org.b.b.c(cVar);
        }
        String encode = org.b.g.c.encode(cVar.cKe().name());
        String encode2 = org.b.g.c.encode(cVar.cKj());
        e eVar = new e();
        eVar.a(cVar.cKd());
        eVar.a(cVar.cKi());
        eVar.a(new e(cVar.Ayq));
        e eVar2 = new e(eVar.Ayr);
        Collections.sort(eVar2.Ayr);
        String encode3 = org.b.g.c.encode(eVar2.cKk());
        return String.format("%s&%s&%s", new Object[]{encode, encode2, encode3});
    }
}
