package org.b.c;

import java.util.Map;
import org.b.d.c;
import org.b.g.d;

public final class e implements d {
    public final String a(c cVar) {
        d.j(cVar, "Cannot extract a header from a null object");
        if (cVar.Ayq == null || cVar.Ayq.size() <= 0) {
            throw new org.b.b.c(cVar);
        }
        Map map = cVar.Ayq;
        StringBuffer stringBuffer = new StringBuffer(map.size() * 20);
        stringBuffer.append("OAuth ");
        for (String str : map.keySet()) {
            if (stringBuffer.length() > 6) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(String.format("%s=\"%s\"", new Object[]{str, org.b.g.c.encode((String) map.get(str))}));
        }
        return stringBuffer.toString();
    }
}
