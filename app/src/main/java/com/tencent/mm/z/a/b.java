package com.tencent.mm.z.a;

import java.util.HashMap;

public final class b {
    public String hib;
    public String hic;
    public String hid;
    public String hie;
    public HashMap<String, e> hif = new HashMap();

    public final e ie(String str) {
        if (this.hif == null || !this.hif.containsKey(str)) {
            return null;
        }
        return (e) this.hif.get(str);
    }
}
