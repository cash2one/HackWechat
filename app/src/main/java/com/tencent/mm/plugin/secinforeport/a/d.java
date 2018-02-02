package com.tencent.mm.plugin.secinforeport.a;

public enum d implements c {
    ;
    
    private static c qfj;

    private d(String str) {
    }

    static {
        qfj = new a((byte) 0);
    }

    public static void a(c cVar) {
        if (cVar != null) {
            qfj = cVar;
        }
    }

    public final boolean G(int i, long j) {
        return qfj.G(i, j);
    }

    public final void IX(String str) {
        qfj.IX(str);
    }

    public final void bX(String str, int i) {
        qfj.bX(str, i);
    }

    public final void IY(String str) {
        qfj.IY(str);
    }

    public final void bqp() {
        qfj.bqp();
    }
}
