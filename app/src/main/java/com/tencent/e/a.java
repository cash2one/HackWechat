package com.tencent.e;

public final class a implements com.tencent.e.b.a {
    private g Amv;
    private boolean Amw = true;

    protected a(g gVar) {
        this.Amv = gVar;
    }

    public final void w(String str, Object obj) {
        if (this.Amw) {
            f cHs = f.cHs();
            if (obj == null) {
                throw new h("TpfServiceCenter|registerService|name or service should not be null");
            }
            synchronized (cHs.AmC) {
                cHs.AmA.put(str, obj);
            }
        }
    }
}
