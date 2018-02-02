package com.tencent.mm.modelstat;

public final class f {
    private static f hRs = null;
    public com.tencent.mm.a.f<String, Long> hRt = new com.tencent.mm.a.f(10);
    public String hRu;

    public static f SU() {
        if (hRs == null) {
            hRs = new f();
        }
        return hRs;
    }

    private f() {
    }

    public final void q(String str, long j) {
        if (this.hRt != null) {
            this.hRu = str;
            this.hRt.put(str, Long.valueOf(j));
        }
    }
}
