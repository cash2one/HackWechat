package c.t.m.g;

import android.os.SystemClock;
import c.t.m.g.ar.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import java.util.HashMap;
import java.util.Map;

public final class am extends ar {
    private Object a;
    private a b;

    public final boolean a(byte[] bArr, int i, boolean z, Object obj, a aVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.b = aVar;
        this.a = obj;
        if (cg.a(bArr)) {
            this.b.a(false, this.a);
            return false;
        }
        Object obj2;
        Map hashMap = new HashMap();
        hashMap.put("B-Length", String.valueOf(i));
        String str = "HLReportCmd";
        if (z) {
            obj2 = "realtime_speed";
        } else {
            obj2 = "hllog";
        }
        hashMap.put(str, obj2);
        ag a = ag.a("https://up-hl.3g.qq.com/upreport", hashMap, bArr, HardCoderJNI.sHCENCODEVIDEOTIMEOUT, cg.d(), null);
        a.o = "event";
        try {
            x.a.a().a.execute(new an(this, a, elapsedRealtime));
            return true;
        } catch (Throwable th) {
            this.b.a(false, this.a);
            return false;
        }
    }
}
