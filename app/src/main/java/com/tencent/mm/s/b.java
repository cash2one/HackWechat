package com.tencent.mm.s;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

public final class b {
    SparseArray<a> gLD = new SparseArray();
    HashMap<com.tencent.mm.storage.w.a, a> gLE = new HashMap();
    SparseArray<b> gLF = new SparseArray();
    HashMap<com.tencent.mm.storage.w.a, b> gLG = new HashMap();
    private Random gLH = new Random();
    t gLI = null;

    public class a {
        String frP;
        com.tencent.mm.storage.w.a gLA;
        final /* synthetic */ b gLJ;
        int gLz;
        int type;
        public String value;

        public a(b bVar) {
            this.gLJ = bVar;
        }
    }

    private static String fe(String str) {
        return str.replaceAll("\\|", "%7C");
    }

    private static String unescape(String str) {
        return str.replaceAll("%7C", "|");
    }

    final void a(a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(aVar.type);
        stringBuffer.append("|");
        stringBuffer.append(fe(aVar.value));
        stringBuffer.append("|");
        stringBuffer.append(fe(aVar.frP));
        if (aVar.gLA != null) {
            this.gLI.a(aVar.gLA, stringBuffer.toString());
        } else {
            this.gLI.set(aVar.gLz, stringBuffer.toString());
        }
    }

    final void a(b bVar) {
        StringBuffer stringBuffer = new StringBuffer();
        int i;
        if (bVar.gLC != null) {
            i = 0;
            for (Entry entry : bVar.gLM.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (i != 0) {
                    stringBuffer.append("|");
                }
                stringBuffer.append(str);
                stringBuffer.append("|");
                stringBuffer.append(fe(str2));
                i++;
            }
            this.gLI.a(bVar.gLC, stringBuffer.toString());
            return;
        }
        for (int i2 = 0; i2 < bVar.gLL.size(); i2++) {
            i = bVar.gLL.keyAt(i2);
            str2 = (String) bVar.gLL.get(i);
            if (i2 != 0) {
                stringBuffer.append("|");
            }
            stringBuffer.append(i);
            stringBuffer.append("|");
            stringBuffer.append(fe(str2));
        }
        this.gLI.set(bVar.gLK, stringBuffer.toString());
    }

    private a gg(int i) {
        String str = (String) this.gLI.get(i, null);
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            x.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", str);
            return null;
        }
        try {
            return a(i, Integer.valueOf(split[0]).intValue(), unescape(split[1]), unescape(split[2]));
        } catch (Throwable e) {
            x.e("MicroMsg.NewBadgeDecoder", "exception:%s", bh.i(e));
            x.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", str);
            return null;
        }
    }

    private a c(com.tencent.mm.storage.w.a aVar) {
        String str = (String) this.gLI.get(aVar, null);
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            x.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", str);
            return null;
        }
        try {
            return a(aVar, Integer.valueOf(split[0]).intValue(), unescape(split[1]), unescape(split[2]));
        } catch (Throwable e) {
            x.e("MicroMsg.NewBadgeDecoder", "exception:%s", bh.i(e));
            x.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", str);
            return null;
        }
    }

    private b gh(int i) {
        String str = (String) this.gLI.get(i, null);
        if (str == null) {
            return gi(i);
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            x.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", str);
            return null;
        }
        try {
            b gi = gi(i);
            for (int i2 = 0; i2 < split.length; i2 += 2) {
                gi.gLL.put(Integer.valueOf(split[i2]).intValue(), unescape(split[i2 + 1]));
            }
            return gi;
        } catch (Throwable e) {
            x.e("MicroMsg.NewBadgeDecoder", "exception:%s", bh.i(e));
            x.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", str);
            return null;
        }
    }

    private b d(com.tencent.mm.storage.w.a aVar) {
        String str = (String) this.gLI.get(aVar, null);
        if (str == null) {
            return e(aVar);
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            x.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", str);
            return null;
        }
        try {
            b e = e(aVar);
            for (int i = 0; i < split.length; i += 2) {
                e.gLM.put(split[i], unescape(split[i + 1]));
            }
            return e;
        } catch (Throwable e2) {
            x.e("MicroMsg.NewBadgeDecoder", "exception:%s", bh.i(e2));
            x.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", str);
            return null;
        }
    }

    final String Bp() {
        long currentTimeMillis = System.currentTimeMillis();
        int nextInt = this.gLH.nextInt(Math.abs(this.gLH.nextInt(Integer.MAX_VALUE))) % 10000;
        return String.format("%d%04d", new Object[]{Long.valueOf(currentTimeMillis), Integer.valueOf(nextInt)});
    }

    final b gi(int i) {
        b bVar = new b(this);
        bVar.gLK = i;
        return bVar;
    }

    final b e(com.tencent.mm.storage.w.a aVar) {
        b bVar = new b(this);
        bVar.gLC = aVar;
        return bVar;
    }

    final a a(int i, int i2, String str, String str2) {
        a aVar = new a(this);
        aVar.gLz = i;
        aVar.type = i2;
        aVar.value = str;
        aVar.frP = str2;
        return aVar;
    }

    final a a(com.tencent.mm.storage.w.a aVar, int i, String str, String str2) {
        a aVar2 = new a(this);
        aVar2.gLA = aVar;
        aVar2.type = i;
        aVar2.value = str;
        aVar2.frP = str2;
        return aVar2;
    }

    public final a gj(int i) {
        a aVar = (a) this.gLD.get(i);
        if (aVar == null) {
            aVar = gg(i);
            if (aVar != null) {
                this.gLD.put(i, aVar);
            }
        }
        return aVar;
    }

    public final a f(com.tencent.mm.storage.w.a aVar) {
        a aVar2 = (a) this.gLE.get(aVar);
        if (aVar2 == null) {
            aVar2 = c(aVar);
            if (aVar2 != null) {
                this.gLE.put(aVar, aVar2);
            }
        }
        return aVar2;
    }

    final b gk(int i) {
        b bVar = (b) this.gLF.get(i);
        if (bVar != null) {
            return bVar;
        }
        bVar = gh(i);
        if (bVar == null) {
            x.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
            return null;
        }
        this.gLF.put(i, bVar);
        return bVar;
    }

    final b g(com.tencent.mm.storage.w.a aVar) {
        b bVar = (b) this.gLG.get(aVar);
        if (bVar != null) {
            return bVar;
        }
        bVar = d(aVar);
        if (bVar == null) {
            x.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
            return null;
        }
        this.gLG.put(aVar, bVar);
        return bVar;
    }

    public final a x(int i, int i2, int i3) {
        x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceId %d, watcherId %d, type %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        a gj = gj(i);
        if (gj == null) {
            x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            return null;
        } else if ((gj.type & i3) == 0) {
            x.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            return null;
        } else {
            b gk = gk(i2);
            if (gk != null) {
                String str = (String) gk.gLL.get(i);
                if (str != null && str.equals(gj.frP)) {
                    return null;
                }
                if (str == null) {
                    gk.gLL.put(i, Bp());
                    a(gk);
                }
                return gj;
            }
            x.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
            return null;
        }
    }

    public final a a(com.tencent.mm.storage.w.a aVar, com.tencent.mm.storage.w.a aVar2, int i) {
        x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherKey %s, type %d", aVar, aVar2, Integer.valueOf(i));
        a f = f(aVar);
        if (f == null) {
            x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            return null;
        } else if ((f.type & i) == 0) {
            x.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            return null;
        } else {
            b g = g(aVar2);
            if (g != null) {
                String str = (String) g.gLM.get(aVar.name());
                if (str != null && str.equals(f.frP)) {
                    return null;
                }
                if (str == null) {
                    g.gLM.put(aVar.name(), Bp());
                    a(g);
                }
                return f;
            }
            x.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
            return null;
        }
    }
}
