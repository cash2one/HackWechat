package com.tencent.mm.v;

import com.eclipsesource.a.a;
import com.eclipsesource.a.e;
import com.eclipsesource.a.h;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public final class k implements c {
    private e gPe;

    public k() {
        this.gPe = new e();
    }

    k(e eVar) {
        if (eVar == null) {
            eVar = new e();
        }
        this.gPe = eVar;
    }

    public k(Map map) {
        this.gPe = i.o(map);
    }

    public k(String str) {
        this.gPe = a.A(str).ht();
    }

    public final int length() {
        return this.gPe.abD.size();
    }

    public final c n(String str, boolean z) {
        this.gPe.a(str, a.aa(z));
        return this;
    }

    public final c a(String str, double d) {
        this.gPe.a(str, a.d(d));
        return this;
    }

    public final c C(String str, int i) {
        this.gPe.a(str, a.bS(i));
        return this;
    }

    public final c i(String str, long j) {
        this.gPe.a(str, a.g(j));
        return this;
    }

    public final c k(String str, Object obj) {
        i.a(this.gPe, str, obj);
        return this;
    }

    public final c l(String str, Object obj) {
        i.a(this.gPe, str, obj);
        return this;
    }

    public final String ft(String str) {
        if (str != null) {
            return str;
        }
        throw new f("Names must be non-null");
    }

    public final Object remove(String str) {
        h hVar = this.gPe;
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        int indexOf = hVar.indexOf(str);
        if (indexOf != -1) {
            hVar.abE.remove(indexOf);
            hVar.abD.remove(indexOf);
            hVar.abw.remove(indexOf);
        }
        if (hVar == null) {
            return null;
        }
        if (hVar.isNumber()) {
            return hVar.toString();
        }
        if (hVar.isBoolean()) {
            return Boolean.valueOf(hVar.hp());
        }
        if (hVar.isArray()) {
            return new j(hVar.ho());
        }
        if (hVar.isObject()) {
            return new k(hVar.ht());
        }
        if (hVar.isString()) {
            return hVar.hC();
        }
        return null;
    }

    public final boolean isNull(String str) {
        return this.gPe.C(str) == null;
    }

    public final boolean has(String str) {
        return this.gPe.C(str) != null;
    }

    public final Object get(String str) {
        return opt(str);
    }

    public final Object opt(String str) {
        h C = this.gPe.C(str);
        if (C == null) {
            return null;
        }
        if (C.isNumber()) {
            return C.toString();
        }
        if (C.isBoolean()) {
            return Boolean.valueOf(C.hp());
        }
        if (C.isArray()) {
            return new j(C.ho());
        }
        if (C.isObject()) {
            return new k(C.ht());
        }
        if (C.isString()) {
            return C.hC();
        }
        return null;
    }

    public final boolean getBoolean(String str) {
        h C = this.gPe.C(str);
        if (C == null) {
            throw new f(String.format("key %s do not exist.", new Object[]{str}));
        } else if (C.isBoolean()) {
            return C.hp();
        } else {
            if (C.isString()) {
                String hVar = C.toString();
                if ("true".equals(hVar)) {
                    return true;
                }
                if ("false".equals(hVar)) {
                    return false;
                }
            }
            throw new f(String.format("getBoolean by key : %s error, value : %s", new Object[]{str, C}));
        }
    }

    public final boolean optBoolean(String str, boolean z) {
        h C = this.gPe.C(str);
        if (C == null) {
            return z;
        }
        if (C.isBoolean()) {
            return C.hp();
        }
        if (!C.isString()) {
            return z;
        }
        String hVar = C.toString();
        if ("true".equals(hVar)) {
            return true;
        }
        if ("false".equals(hVar)) {
            return false;
        }
        return z;
    }

    public final double getDouble(String str) {
        h C = this.gPe.C(str);
        if (C == null) {
            throw new f(String.format("key %s do not exist.", new Object[]{str}));
        }
        try {
            if (C.isNumber()) {
                return C.hs();
            }
            if (C.isString()) {
                return Double.parseDouble(C.toString());
            }
            throw new f(String.format("getDouble by key : %s error, value : %s", new Object[]{str, C}));
        } catch (Exception e) {
        }
    }

    public final double optDouble(String str, double d) {
        h C = this.gPe.C(str);
        if (C == null) {
            return d;
        }
        try {
            if (C.isNumber()) {
                return C.hs();
            }
            if (C.isString()) {
                return Double.parseDouble(C.toString());
            }
            return d;
        } catch (Exception e) {
            return d;
        }
    }

    public final int getInt(String str) {
        Object C = this.gPe.C(str);
        if (C == null) {
            throw new f(String.format("key %s do not exist.", new Object[]{str}));
        }
        try {
            if (C.isNumber()) {
                try {
                    return C.hq();
                } catch (Exception e) {
                    return (int) C.hs();
                }
            }
            if (C.isString()) {
                return (int) Double.parseDouble(C.toString());
            }
            throw new f(String.format("getInt by key : %s error, value : %s", new Object[]{str, C}));
        } catch (Exception e2) {
        }
    }

    public final int optInt(String str, int i) {
        h C = this.gPe.C(str);
        if (C == null) {
            return i;
        }
        try {
            if (C.isNumber()) {
                try {
                    return C.hq();
                } catch (Exception e) {
                    return (int) C.hs();
                }
            } else if (C.isString()) {
                return (int) Double.parseDouble(C.toString());
            } else {
                return i;
            }
        } catch (Exception e2) {
            return i;
        }
    }

    public final long getLong(String str) {
        Object C = this.gPe.C(str);
        if (C == null) {
            throw new f(String.format("key %s do not exist.", new Object[]{str}));
        }
        try {
            if (C.isNumber()) {
                try {
                    return C.hr();
                } catch (Exception e) {
                    return (long) C.hs();
                }
            }
            if (C.isString()) {
                return (long) Double.parseDouble(C.toString());
            }
            throw new f(String.format("getLong by key : %s error, value : %s", new Object[]{str, C}));
        } catch (Exception e2) {
        }
    }

    public final long optLong(String str, long j) {
        h C = this.gPe.C(str);
        if (C == null) {
            return j;
        }
        try {
            if (C.isNumber()) {
                try {
                    return C.hr();
                } catch (Exception e) {
                    return (long) C.hs();
                }
            } else if (C.isString()) {
                return (long) Double.parseDouble(C.toString());
            } else {
                return j;
            }
        } catch (Exception e2) {
            return j;
        }
    }

    public final String getString(String str) {
        h C = this.gPe.C(str);
        if (C == null) {
            throw new f(String.format("key %s do not exist.", new Object[]{str}));
        } else if (C.isString()) {
            return C.hC();
        } else {
            return C.toString();
        }
    }

    public final String optString(String str) {
        return optString(str, null);
    }

    public final String optString(String str, String str2) {
        h C = this.gPe.C(str);
        if (C == null) {
            return null;
        }
        if (C.isString()) {
            return C.hC();
        }
        return C.toString();
    }

    public final a fu(String str) {
        h C = this.gPe.C(str);
        if (C != null) {
            return new j(C.ho());
        }
        throw new f(String.format("key %s do not exist.", new Object[]{str}));
    }

    public final a fv(String str) {
        h C = this.gPe.C(str);
        if (C == null) {
            return null;
        }
        return new j(C.ho());
    }

    public final c fw(String str) {
        h C = this.gPe.C(str);
        if (C != null) {
            return new k(C.ht());
        }
        throw new f(String.format("key %s do not exist.", new Object[]{str}));
    }

    public final c fx(String str) {
        h C = this.gPe.C(str);
        if (C == null) {
            return null;
        }
        return new k(C.ht());
    }

    public final Iterator<String> keys() {
        return Collections.unmodifiableList(this.gPe.abD).iterator();
    }

    public final String toString() {
        return this.gPe.toString();
    }
}
