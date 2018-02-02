package com.tencent.d.a.c;

public class d {
    private static volatile d Acl = null;
    public String Acm = a.Acj;

    public static d cFS() {
        if (Acl != null) {
            return Acl;
        }
        d dVar;
        synchronized (d.class) {
            if (Acl == null) {
                Acl = new d();
            }
            dVar = Acl;
        }
        return dVar;
    }
}
