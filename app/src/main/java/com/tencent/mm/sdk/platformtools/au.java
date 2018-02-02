package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class au<K, V> {
    private final long aJe;
    public final ak fhK;
    public volatile boolean fhN = false;
    public final z<K, a<V>> nId;
    protected Object tag;
    private final long threshold;
    private boolean xhA = true;
    public final LinkedHashMap<K, b<K, V>> xhw = new LinkedHashMap();
    private final c<K, V> xhx;
    public final ak xhy;
    private final long xhz;

    static class a<V> {
        final V xhC;

        a(V v) {
            this.xhC = v;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.xhC != null) {
                return this.xhC.equals(aVar.xhC);
            }
            if (aVar.xhC == null) {
                return true;
            }
            return false;
        }
    }

    public static class b<K, V> {
        public V values;
        public K vxB;
        public int xhD;
    }

    public interface c<K, V> {
        boolean SY();

        void SZ();

        void a(au<K, V> auVar, b<K, V> bVar);
    }

    public au(c<K, V> cVar, Looper looper, int i, int i2, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("arg appender can not be null!");
        } else if (looper == null) {
            throw new IllegalArgumentException("arg looper can not be null!");
        } else if (i <= 0) {
            throw new IllegalArgumentException("arg size can not be <= 0!");
        } else {
            this.xhx = cVar;
            this.nId = new z(i);
            this.threshold = i2 > 0 ? (long) i2 : 40;
            if (j <= 0) {
                j = 60000;
            }
            this.xhz = j;
            if (j2 <= 0) {
                j2 = 60000;
            }
            this.aJe = j2;
            this.fhK = new ak(looper, new com.tencent.mm.sdk.platformtools.ak.a(this) {
                final /* synthetic */ au xhB;

                {
                    this.xhB = r1;
                }

                public final boolean uF() {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.xhB.lE(false);
                    x.i("MicroMsg.RWCache", "summer timer onTimerExpired e appendAll takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    return false;
                }
            }, false);
            this.xhy = new ak(new ag("RWCache_timeoutChecker").oAt.getLooper(), new com.tencent.mm.sdk.platformtools.ak.a(this) {
                final /* synthetic */ au xhB;

                {
                    this.xhB = r1;
                }

                public final boolean uF() {
                    this.xhB.fhN = true;
                    return false;
                }
            }, false);
        }
    }

    public final Object getTag() {
        return this.tag;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final V get(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        a aVar = (a) this.nId.get(k);
        if (aVar != null) {
            return aVar.xhC;
        }
        this.nId.put(k, new a(null));
        return null;
    }

    public final boolean r(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        a aVar = (a) this.nId.get(k);
        a aVar2 = new a(v);
        if (aVar2.equals(aVar)) {
            return false;
        }
        int i;
        this.nId.put(k, aVar2);
        b bVar = new b();
        bVar.vxB = k;
        bVar.values = v;
        if (v == null) {
            i = 2;
        } else {
            i = 1;
        }
        bVar.xhD = i;
        synchronized (this) {
            this.xhw.put(k, bVar);
            if (this.xhA && ((long) this.xhw.size()) > this.threshold) {
                this.fhK.J(0, 0);
                this.xhA = false;
            } else if (this.fhK.cfK()) {
                ak akVar = this.fhK;
                long j = this.xhz;
                akVar.J(j, j);
            }
        }
        return true;
    }

    public final void lE(boolean z) {
        x.i("MicroMsg.RWCache", "summer appendAll force: " + z + " tid: " + Thread.currentThread().getId() + " holderMap size: " + this.xhw.size());
        synchronized (this) {
            this.xhA = true;
            if (this.xhw.isEmpty()) {
            } else if (this.xhx.SY()) {
                Iterator it = this.xhw.entrySet().iterator();
                if (z) {
                    while (it.hasNext()) {
                        this.xhx.a(this, (b) ((Entry) it.next()).getValue());
                        it.remove();
                    }
                } else {
                    this.fhN = false;
                    ak akVar = this.xhy;
                    long j = this.aJe;
                    akVar.J(j, j);
                    while (!this.fhN && it.hasNext()) {
                        this.xhx.a(this, (b) ((Entry) it.next()).getValue());
                        it.remove();
                    }
                    if (this.fhN) {
                        x.i("MicroMsg.RWCache", "summer appendAll timeout size[%d] hasNext[%b] end", Integer.valueOf(this.xhw.size()), Boolean.valueOf(it.hasNext()));
                    }
                    this.xhy.TG();
                }
                this.xhx.SZ();
            }
        }
    }
}
