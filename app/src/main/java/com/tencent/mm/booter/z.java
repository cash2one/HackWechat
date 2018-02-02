package com.tencent.mm.booter;

import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.w;
import java.util.HashSet;
import java.util.Locale;

public final class z {
    public static z gyU = new z();
    public s gyV = new s(w.gZK + "staytime.cfg");
    public c gyW = new 1(this);
    public c gyX = new 2(this);
    public a gyY;
    public int gyZ = 0;
    HashSet<Long> gza = new HashSet();
    HashSet<Long> gzb = new HashSet();
    public long gzc;
    public long gzd;
    public String gze;
    public long gzf = -1;
    public int gzg = 20;
    public int gzh = 24;
    public int gzi = 30;
    public int gzj = 10800;
    public boolean hasInit = false;

    class a {
        public int fnm;
        final /* synthetic */ z gzk;
        public String gzl;
        public int gzm;
        public int gzn;
        public long gzo;
        public int gzp;
        public int gzq = 0;
        int gzr = 0;
        int gzs = 0;
        public long time;
        public int type;

        public a(z zVar) {
            this.gzk = zVar;
        }

        public final String toString() {
            return String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s#%d#%d#%d|", new Object[]{Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.gzm), Integer.valueOf(this.fnm), Integer.valueOf(this.gzn), Long.valueOf(this.gzo), Integer.valueOf(this.gzp), this.gzl, Integer.valueOf(this.gzq), Integer.valueOf(this.gzr), Integer.valueOf(this.gzs)});
        }
    }

    private z() {
    }

    public final void el(String str) {
        com.tencent.mm.sdk.b.a.xef.c(this.gyW);
        com.tencent.mm.sdk.b.a.xef.c(this.gyX);
        this.gzb.clear();
        this.gza.clear();
        if (str == null || this.gyY == null) {
            boolean z;
            String str2 = "MicroMsg.StayTimeReport";
            String str3 = "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (this.gyY == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str2, str3, objArr);
        } else if (str.equals(this.gyY.gzl)) {
            a aVar = this.gyY;
            aVar.time += t.bA(this.gzc) / 1000;
            this.gyV.set(5, ((String) this.gyV.get(5, "")) + this.gyY.toString());
            long j = this.gyV.getLong(4, 0);
            int Dl = this.gyV.Dl(6) + 1;
            this.gyV.setInt(6, Dl);
            x.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", new Object[]{this.gyY.gzl, Integer.valueOf(this.gyY.type), Long.valueOf(this.gyY.time), Integer.valueOf(this.gyY.gzp), Integer.valueOf(Dl)});
            x.i("MicroMsg.StayTimeReport", "exitChattingUI goBackHistoryStatus:%d, recnCnt:%d, sendCnt:%d", new Object[]{Integer.valueOf(this.gyY.gzq), Integer.valueOf(this.gyY.gzr), Integer.valueOf(this.gyY.gzs)});
            if (t.by(j) > ((long) this.gzj) || Dl > this.gzi) {
                Dl = 1;
            } else {
                Dl = 0;
            }
            if (Dl != 0) {
                x.i("MicroMsg.StayTimeReport", "report （13062） %d: %s", new Object[]{Integer.valueOf(13062), ((String) this.gyV.get(5, "")) + "," + j + "," + t.Wo()});
                g.pQN.k(13062, r0);
                this.gyV.setInt(6, 0);
                this.gyV.set(5, "");
            }
            this.gyY = null;
        } else {
            x.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", new Object[]{str, this.gyY.gzl});
        }
    }
}
