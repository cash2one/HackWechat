package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.a.c;
import com.tencent.mm.a.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public static String seO;
    public static c seP;
    private final String TAG = "MicroMsg.MMTraceRoute";
    private final int seQ = 64;
    private boolean seR = false;
    f seS = new f(this, (byte) 0);
    public Map<String, Set<Integer>> seT = new HashMap();
    public e seU;
    public d seV;
    public c seW;
    public b seX;
    String userName;

    public interface e {
        void bFy();
    }

    private class g implements Runnable {
        final /* synthetic */ a seZ;
        private String serverIP;
        private String sfe;
        private boolean sff;
        private Integer sfg;

        public g(a aVar, String str, String str2, boolean z, Integer num) {
            this.seZ = aVar;
            this.sfe = str;
            this.serverIP = str2;
            this.sff = z;
            this.sfg = num;
        }

        public final void run() {
            a aVar = this.seZ;
            String str = this.sfe;
            String str2 = this.serverIP;
            Integer num = this.sfg;
            for (int i = 1; i <= 3; i++) {
                List A = b.A(new String[]{"ping", "-c 1", new StringBuilder("-t 64").toString(), str});
                if (A.size() == 2) {
                    String str3 = (String) A.get(0);
                    if (bh.ov(str3)) {
                        x.e("MicroMsg.MMTraceRoute", "runcommand err " + str);
                        aVar.a(str2, "run command err ", num);
                    } else {
                        String obj = A.get(1).toString();
                        if (b.Mw(str3) > 0) {
                            if (!bh.ov(b.Mv(str3))) {
                                str3 = String.format(" %sms ", new Object[]{b.Mv(str3)});
                            } else if (bh.ov(obj)) {
                                str3 = String.format("unable to get time", new Object[0]);
                            } else {
                                str3 = String.format(" %sms ", new Object[]{obj});
                            }
                        } else {
                            str3 = String.format(" router no response ", new Object[0]);
                        }
                        if (i == 3) {
                            str3 = str3 + "\n";
                        }
                        aVar.a(str2, str3, num);
                    }
                } else if (i == 3) {
                    aVar.a(str2, " router no response\n", num);
                } else {
                    aVar.a(str2, " router no response", num);
                }
            }
        }
    }

    private class i implements Runnable {
        private String ip;
        final /* synthetic */ a seZ;

        public i(a aVar, String str) {
            this.seZ = aVar;
            this.ip = str;
        }

        public final void run() {
            int i = 1;
            List A = b.A(new String[]{"ping", "-c 1", new StringBuilder("-t 64").toString(), this.ip});
            if (A.size() != 2) {
                this.seZ.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
                return;
            }
            String str = (String) A.get(0);
            if (bh.ov(str)) {
                this.seZ.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
                x.e("MicroMsg.MMTraceRoute", "runcommand err");
                return;
            }
            int Mw = b.Mw(str);
            if (Mw <= 0) {
                x.e("MicroMsg.MMTraceRoute", "failed to touch server:" + this.ip);
                this.seZ.a(this.ip, "failed to touch server: " + this.ip + "\n", Integer.valueOf(0));
                return;
            }
            String obj = A.get(1).toString();
            if (!bh.ov(b.Mv(str))) {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(Mw), b.Mv(str)});
            } else if (bh.ov(obj)) {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(Mw), "unknown"});
            } else {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(Mw), obj});
            }
            this.seZ.a(this.ip, str + "\n", Integer.valueOf(0));
            int i2 = (64 - Mw) + 5;
            if (i2 < 0) {
                i2 = 64;
            }
            while (i < i2 && !this.seZ.bFt()) {
                Runnable hVar = new h(this.seZ, this.ip, i);
                if (a.seP != null) {
                    a.seP.execute(hVar);
                }
                i++;
            }
        }
    }

    static /* synthetic */ void a(a aVar) {
        if (aVar.seX != null) {
            aVar.seX.bFv();
        }
    }

    final synchronized boolean bFt() {
        return this.seR;
    }

    final synchronized void iZ(boolean z) {
        this.seR = z;
    }

    public a(String str) {
        this.userName = str;
        seO = h.getExternalStorageDirectory().getAbsolutePath() + "/tencent/traceroute_log_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() + ".log";
    }

    public final void stop() {
        iZ(true);
        if (seP != null) {
            try {
                seP.shutdownNow();
            } catch (Exception e) {
                x.e("MicroMsg.MMTraceRoute", "failed to shutdown threadpool: " + e.getMessage());
            }
        }
    }

    public final void b(String[] strArr, boolean z) {
        if (strArr == null || strArr.length == 0) {
            x.e("MicroMsg.MMTraceRoute", "no ip contains");
            return;
        }
        String str = "";
        if (z) {
            str = str + "long: ";
        } else {
            str = str + "short: ";
        }
        int length = strArr.length;
        int i = 0;
        String str2 = str;
        while (i < length) {
            str = strArr[i];
            String[] split = str.split(":");
            if (split == null || split.length != 3) {
                x.e("MicroMsg.MMTraceRoute", "err ip " + str);
                str = str2;
            } else if (this.seT.containsKey(split[0])) {
                ((Set) this.seT.get(split[0])).add(Integer.valueOf(bh.getInt(split[1], 0)));
                str = str2;
            } else {
                Set hashSet = new HashSet();
                hashSet.add(Integer.valueOf(bh.getInt(split[1], 0)));
                this.seT.put(split[0], hashSet);
                str = str2 + split[0] + " ";
            }
            i++;
            str2 = str;
        }
        com.tencent.mm.a.e.d(seO, (str2 + "\n").getBytes());
    }

    final synchronized void a(String str, String str2, Integer num) {
        if (!(str == null || str2 == null)) {
            if (num.intValue() >= 0) {
                if (!this.seS.containsKey(str)) {
                    Map concurrentHashMap = new ConcurrentHashMap();
                    concurrentHashMap.put(num, new StringBuilder(str2));
                    this.seS.put(str, (ConcurrentHashMap) concurrentHashMap);
                } else if (((ConcurrentHashMap) this.seS.get(str)).containsKey(num)) {
                    ((StringBuilder) ((ConcurrentHashMap) this.seS.get(str)).get(num)).append(str2);
                } else {
                    new ConcurrentHashMap().put(num, new StringBuilder(str2));
                    ((ConcurrentHashMap) this.seS.get(str)).put(num, new StringBuilder(str2));
                }
            }
        }
    }

    public final synchronized void bFu() {
        if (this.seS != null) {
            String str;
            f fVar = this.seS;
            File file = new File(seO);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    com.tencent.mm.a.e.d(seO, (fVar.seZ.userName + "\n").getBytes());
                } catch (Throwable e) {
                    x.e("MicroMsg.MMTraceRoute", "create log file err " + e.getMessage());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                    a(fVar.seZ);
                }
            }
            for (Entry key : fVar.seZ.seS.entrySet()) {
                String str2 = (String) key.getKey();
                if (!bh.ov(str2) && fVar.seZ.seS.containsKey(str2)) {
                    Map map = (Map) fVar.seZ.seS.get(str2);
                    if (map != null) {
                        String str3 = "";
                        if (map.size() != 1 || map.get(Integer.valueOf(1)) == null) {
                            int i = 0;
                            Object obj = null;
                            while (i < map.size() && obj == null) {
                                Object obj2;
                                if (map.get(Integer.valueOf(i)) != null) {
                                    String stringBuilder = ((StringBuilder) map.get(Integer.valueOf(i))).toString();
                                    if (!bh.ov(stringBuilder)) {
                                        str = str3 + stringBuilder;
                                        obj2 = stringBuilder.contains("FIN") ? 1 : obj;
                                        i++;
                                        obj = obj2;
                                        str3 = str;
                                    }
                                }
                                str = str3;
                                obj2 = obj;
                                i++;
                                obj = obj2;
                                str3 = str;
                            }
                        } else {
                            str3 = str3 + ((StringBuilder) map.get(Integer.valueOf(1))).toString();
                        }
                        if (str3.length() > 0) {
                            x.i("MicroMsg.MMTraceRoute", str2 + str3);
                            com.tencent.mm.a.e.d(seO, str3.getBytes());
                        }
                    } else {
                        continue;
                    }
                }
            }
            byte[] d = com.tencent.mm.a.e.d(seO, 0, -1);
            if (bh.bw(d)) {
                x.e("MicroMsg.MMTraceRoute", "read log failed");
                a(fVar.seZ);
            } else {
                str = com.tencent.mm.a.g.s(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.vAz), Integer.valueOf(d.length)}).getBytes()).toLowerCase();
                d = q.q(d);
                PByteArray pByteArray = new PByteArray();
                c.a(pByteArray, d, str.getBytes());
                com.tencent.mm.sdk.f.e.post(new 1(fVar, r1, str, pByteArray), "MMTraceRoute_uploadLog");
            }
        }
        return;
    }
}
