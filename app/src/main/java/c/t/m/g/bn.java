package c.t.m.g;

final class bn implements Runnable {
    private /* synthetic */ String a;
    private /* synthetic */ byte[] b;
    private /* synthetic */ bm c;

    bn(bm bmVar, String str, byte[] bArr) {
        this.c = bmVar;
        this.a = str;
        this.b = bArr;
    }

    public final void run() {
        String str = this.a;
        byte[] bArr = this.b;
        if (cg.a(str) || cg.a(bArr)) {
            p.e();
            str = p.b();
            bArr = this.c.a.a(str);
        }
        bo.c().a.a(str, bArr, null);
    }
}
