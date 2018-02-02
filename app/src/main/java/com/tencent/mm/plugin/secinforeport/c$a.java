package com.tencent.mm.plugin.secinforeport;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class c$a {
    private static final Map<Integer, Long> qfe = new HashMap();

    private static synchronized void ks() {
        Exception e;
        Throwable th;
        synchronized (c$a.class) {
            DataInputStream dataInputStream;
            try {
                dataInputStream = new DataInputStream(new FileInputStream(new File(g.Dj().cachePath, d.oSu.GG("!#?'8/f((6(1$\u001f2*>(s826"))));
                try {
                    if (dataInputStream.readShort() != (short) -774) {
                        throw new IllegalStateException("bad magic.");
                    }
                    dataInputStream.readShort();
                    int readInt = dataInputStream.readInt();
                    if (readInt < 0) {
                        throw new IllegalStateException("bad pair count.");
                    }
                    for (int i = 0; i < readInt; i++) {
                        qfe.put(Integer.valueOf(dataInputStream.readInt()), Long.valueOf(dataInputStream.readLong()));
                    }
                    x.i("MicroMsg.SecInfoReporterImpl", "normsg stat load done.");
                    try {
                        dataInputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                dataInputStream = null;
                try {
                    x.e("MicroMsg.SecInfoReporterImpl", "normsg stat load failed, use default.", new Object[]{e});
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dataInputStream = null;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw th;
            }
        }
        return;
    }

    private static synchronized void save() {
        Throwable th;
        synchronized (c$a.class) {
            File file = new File(g.Dj().cachePath, d.oSu.GG("!#?'8/f((6(1$\u001f2*>(s826"));
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            DataOutputStream dataOutputStream = null;
            DataOutputStream dataOutputStream2;
            try {
                dataOutputStream2 = new DataOutputStream(new FileOutputStream(file));
                try {
                    dataOutputStream2.writeShort(-774);
                    dataOutputStream2.writeShort(1);
                    dataOutputStream2.writeInt(qfe.size());
                    for (Entry entry : qfe.entrySet()) {
                        dataOutputStream2.writeInt(((Integer) entry.getKey()).intValue());
                        dataOutputStream2.writeLong(((Long) entry.getValue()).longValue());
                    }
                    x.i("MicroMsg.SecInfoReporterImpl", "normsg stat save done.");
                    try {
                        dataOutputStream2.close();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    dataOutputStream = dataOutputStream2;
                    try {
                        x.e("MicroMsg.SecInfoReporterImpl", "normsg stat save failed.");
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        dataOutputStream2 = dataOutputStream;
                        th = th2;
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (dataOutputStream2 != null) {
                        dataOutputStream2.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                x.e("MicroMsg.SecInfoReporterImpl", "normsg stat save failed.");
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                return;
            } catch (Throwable th22) {
                dataOutputStream2 = null;
                th = th22;
                if (dataOutputStream2 != null) {
                    dataOutputStream2.close();
                }
                throw th;
            }
        }
        return;
    }

    static synchronized boolean G(int i, long j) {
        boolean z;
        synchronized (c$a.class) {
            if (j < 0) {
                x.w("MicroMsg.SecInfoReporterImpl", "bad interval: %s", new Object[]{Long.valueOf(j)});
                z = false;
            } else {
                if (!qfe.containsKey(Integer.valueOf(i))) {
                    ks();
                }
                Long l = (Long) qfe.get(Integer.valueOf(i));
                long currentTimeMillis = System.currentTimeMillis();
                if (l == null || currentTimeMillis < l.longValue()) {
                    qfe.put(Integer.valueOf(i), Long.valueOf(0));
                    save();
                    z = false;
                } else if (currentTimeMillis - l.longValue() > j) {
                    qfe.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
                    save();
                    z = true;
                } else {
                    z = false;
                }
            }
        }
        return z;
    }
}
