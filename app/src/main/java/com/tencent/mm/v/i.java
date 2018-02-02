package com.tencent.mm.v;

import com.eclipsesource.a.a;
import com.eclipsesource.a.b;
import com.eclipsesource.a.e;
import com.eclipsesource.a.h;
import java.util.Iterator;
import java.util.Map;

public final class i {
    public static e o(Map map) {
        e eVar = new e();
        if (map == null || map.isEmpty()) {
            return eVar;
        }
        for (Object next : map.keySet()) {
            a(eVar, (String) next, map.get(next));
        }
        return eVar;
    }

    private static e a(c cVar) {
        e eVar = new e();
        if (cVar == null) {
            return eVar;
        }
        try {
            Iterator keys = cVar.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                a(eVar, str, cVar.get(str));
            }
        } catch (f e) {
        }
        return eVar;
    }

    private static b a(a aVar) {
        b bVar = new b();
        if (aVar != null) {
            int i = 0;
            while (i < aVar.length()) {
                try {
                    a(bVar, aVar.get(i));
                    i++;
                } catch (f e) {
                }
            }
        }
        return bVar;
    }

    protected static void a(b bVar, Object obj) {
        if (obj instanceof c) {
            bVar.a(a((c) obj));
        } else if (obj instanceof a) {
            bVar.a(a((a) obj));
        } else if (obj instanceof Integer) {
            bVar.bT(((Integer) obj).intValue());
        } else if (obj instanceof String) {
            bVar.abw.add(a.z((String) obj));
        } else if (obj instanceof Boolean) {
            bVar.ab(((Boolean) obj).booleanValue());
        } else if (obj instanceof Long) {
            bVar.h(((Long) obj).longValue());
        } else if (obj instanceof Float) {
            bVar.abw.add(a.K(((Float) obj).floatValue()));
        } else if (obj instanceof Integer) {
            bVar.bT(((Integer) obj).intValue());
        } else if (obj instanceof Double) {
            bVar.e(((Double) obj).doubleValue());
        } else if (obj instanceof h) {
            bVar.a((h) obj);
        }
    }

    protected static void a(e eVar, String str, Object obj) {
        if (obj instanceof c) {
            eVar.b(str, a((c) obj));
        } else if (obj instanceof a) {
            eVar.b(str, a((a) obj));
        } else if (obj instanceof Integer) {
            eVar.g(str, ((Integer) obj).intValue());
        } else if (obj instanceof String) {
            eVar.b(str, a.z((String) obj));
        } else if (obj instanceof Boolean) {
            eVar.b(str, a.aa(((Boolean) obj).booleanValue()));
        } else if (obj instanceof Long) {
            eVar.b(str, a.g(((Long) obj).longValue()));
        } else if (obj instanceof Float) {
            eVar.b(str, a.K(((Float) obj).floatValue()));
        } else if (obj instanceof Integer) {
            eVar.g(str, ((Integer) obj).intValue());
        } else if (obj instanceof Double) {
            eVar.b(str, a.d(((Double) obj).doubleValue()));
        } else if (obj instanceof h) {
            eVar.b(str, (h) obj);
        }
    }
}
