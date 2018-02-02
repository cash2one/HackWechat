package com.tencent.mm.plugin.exdevice.b;

import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import junit.framework.Assert;

public final class k implements com.tencent.mm.ae.e {
    public static k lKh = null;
    private final HashMap<Long, e> lKg;
    public HashMap<String, Integer> lKi;
    public af mHandler;

    private static final class b {
        public String jcD;
        public int lJY;
        public int lKk;
        public com.tencent.mm.ae.k lKl;

        private b() {
            this.lJY = 0;
            this.lKk = 0;
            this.jcD = null;
            this.lKl = null;
        }
    }

    private static final class c {
        public byte[] kwG;
        public long mSessionId;

        private c() {
            this.mSessionId = 0;
            this.kwG = null;
        }
    }

    private static final class e {
        f lKn;
        private d lKo;
        int lKp;

        private e() {
            this.lKn = null;
            this.lKo = null;
            this.lKp = 0;
        }

        public final void a(f fVar) {
            Assert.assertNotNull(fVar);
            this.lKn = fVar;
        }

        public final void a(d dVar) {
            Assert.assertNotNull(dVar);
            this.lKo = dVar;
        }

        public final f aDM() {
            Assert.assertNotNull(this.lKn);
            return this.lKn;
        }

        public final d aDN() {
            Assert.assertNotNull(this.lKo);
            return this.lKo;
        }
    }

    public static final class f {
        private static f lKr = null;
        private long lKq;

        public f() {
            long j = 0;
            SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                j = sharedPreferences.getLong("local_message_seq", 0);
                x.i("MicroMsg.exdevice.Util", "lasted seq id is %d", new Object[]{Long.valueOf(j)});
            }
            this.lKq = j;
        }

        public static long aDO() {
            if (lKr == null) {
                lKr = new f();
            }
            f fVar = lKr;
            if (Long.MAX_VALUE == fVar.lKq) {
                x.w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
                fVar.lKq = 0;
            }
            long j = fVar.lKq + 1;
            fVar.lKq = j;
            SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                x.i("MicroMsg.exdevice.Util", "save locall seq id : %d", new Object[]{Long.valueOf(j)});
                sharedPreferences.edit().putLong("local_message_seq", j).commit();
            }
            return j;
        }
    }

    public static k aDL() {
        if (lKh != null) {
            return lKh;
        }
        k kVar = new k();
        lKh = kVar;
        return kVar;
    }

    private k() {
        this.lKg = new HashMap();
        this.mHandler = null;
        this.lKi = new HashMap();
        this.mHandler = new a(this, ar.Dm().oAt.getLooper());
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "******onSceneEnd******\r\n errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        b bVar = new b();
        bVar.lJY = i2;
        bVar.lKk = i;
        bVar.jcD = str;
        bVar.lKl = kVar;
        this.mHandler.obtainMessage(2, bVar).sendToTarget();
    }
}
