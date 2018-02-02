package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.ca.c;
import com.tencent.mm.ca.d$a;
import com.tencent.mm.g.a.if;
import com.tencent.mm.g.a.si;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.a.b.a;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.io.File;
import java.util.Map;

public final class l extends a implements d {
    public static long a(File file, long j) {
        long j2;
        Throwable e;
        try {
            File[] listFiles = file.listFiles();
            j2 = 0;
            int i = 0;
            while (i < listFiles.length) {
                try {
                    if (listFiles[i].isDirectory()) {
                        j2 += a(listFiles[i], j);
                    } else {
                        if (listFiles[i].length() > j) {
                            x.i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", new Object[]{Long.valueOf(listFiles[i].length()), listFiles[i].getPath()});
                        }
                        j2 += listFiles[i].length();
                    }
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            j2 = 0;
            e = th;
            x.e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", new Object[]{bh.i(e)});
            return j2;
        }
        return j2;
    }

    public final b b(d.a aVar) {
        if (g.Dh().Cy()) {
            String str = aVar.hmq.vGZ.wJF;
            x.d("MicroMsg.NetStatMsgExtension", "onPreAddMessage %s", new Object[]{str});
            if (!bh.ov(str)) {
                x.i("MicroMsg.NetStatMsgExtension", "get ipxx cmd=%s", new Object[]{str});
                Map y = bi.y(str, "cmd");
                if (y != null) {
                    int i = bh.getInt((String) y.get(".cmd.trace.$code"), -1);
                    if (i <= 0) {
                        int i2 = bh.getInt((String) y.get(".cmd.hprof.$type"), -1);
                        if (i2 > 0) {
                            x.d("MicroMsg.NetStatMsgExtension", "hprof type: %d", new Object[]{Integer.valueOf(i2)});
                            c.DG(i2);
                        } else {
                            if ("android".equalsIgnoreCase((String) y.get(".cmd.hotpatch.$os"))) {
                                com.tencent.mm.sdk.b.b ifVar = new if();
                                ifVar.fyD.fyE = (String) y.get(".cmd.hotpatch.xml.$url");
                                ifVar.fyD.fyF = (String) y.get(".cmd.hotpatch.xml.$signature");
                                ifVar.fyD.fyG = (String) y.get(".cmd.hotpatch.$url");
                                ifVar.fyD.fyH = (String) y.get(".cmd.hotpatch.$signature");
                                com.tencent.mm.sdk.b.a.xef.a(ifVar, Looper.myLooper());
                            } else {
                                String str2;
                                i2 = bh.getInt((String) y.get(".cmd.clearfile.$fb"), -1);
                                if (i2 == 1) {
                                    g.Dm().F(new 1(this, (long) bh.getInt((String) y.get(".cmd.clearfile.$ps"), 1048576)));
                                } else if (i2 == 2) {
                                    long length;
                                    str2 = (String) y.get(".cmd.clearfile.$pd");
                                    File file = new File(str2);
                                    String str3 = "MicroMsg.NetStatMsgExtension";
                                    String str4 = "clearfile delete :[%s] length:%s";
                                    Object[] objArr = new Object[2];
                                    objArr[0] = str2;
                                    objArr[1] = Long.valueOf(file.exists() ? file.length() : -1);
                                    x.i(str3, str4, objArr);
                                    com.tencent.mm.loader.stub.b.deleteFile(str2);
                                    file = new File(str2);
                                    String str5 = "MicroMsg.NetStatMsgExtension";
                                    String str6 = "clearfile delete finish :[%s] length:%s";
                                    Object[] objArr2 = new Object[2];
                                    objArr2[0] = str2;
                                    if (file.exists()) {
                                        length = file.length();
                                    } else {
                                        length = -1;
                                    }
                                    objArr2[1] = Long.valueOf(length);
                                    x.i(str5, str6, objArr2);
                                } else if (i2 == 3) {
                                    x.i("MicroMsg.NetStatMsgExtension", "running  clearfile start:" + g.Dj().CR() + ".tem");
                                    com.tencent.mm.loader.stub.b.deleteFile(g.Dj().CR() + ".tem");
                                    com.tencent.mm.loader.stub.b.deleteFile(g.Dj().CS() + ".tem");
                                    x.i("MicroMsg.NetStatMsgExtension", "running  clearfile end:" + g.Dj().CR() + ".tem");
                                }
                                final int i3 = bh.getInt((String) y.get(".cmd.updzh.$pt"), -1);
                                str2 = (String) y.get(".cmd.updzh.$pd");
                                x.d("MicroMsg.NetStatMsgExtension", "StackReportUploader pt:%d pd:%s", new Object[]{Integer.valueOf(i3), str2});
                                if (i3 > 0 && !bh.ov(str2)) {
                                    g.Dm().F(new Runnable(this) {
                                        final /* synthetic */ l hSh;

                                        public final void run() {
                                            switch (i3) {
                                                case 1:
                                                    q.a(g.Dj().gQi + str2, com.tencent.mm.z.q.FS(), false, true);
                                                    return;
                                                case 2:
                                                    q.a(g.Dj().cachePath + str2, com.tencent.mm.z.q.FS(), false, true);
                                                    return;
                                                case 3:
                                                    q.a(str2, com.tencent.mm.z.q.FS(), false, true);
                                                    return;
                                                default:
                                                    return;
                                            }
                                        }

                                        public final String toString() {
                                            return super.toString() + "|onPreAddMessage";
                                        }
                                    });
                                }
                            }
                        }
                    } else if (i == 6) {
                        com.tencent.mm.sdk.b.a.xef.m(new si());
                    } else {
                        com.tencent.mm.ca.d.clq().c(new d$a((String) y.get(".cmd.trace.$class"), i, bh.getInt((String) y.get(".cmd.trace.$size"), 0), bh.getInt((String) y.get(".cmd.trace.$type"), 0)));
                    }
                }
                x.cfk();
                g.CG().hmV.jq(str);
                try {
                    Thread.sleep(50, 0);
                } catch (Exception e) {
                }
                LogLogic.initIPxxLogInfo();
                MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
            }
        } else {
            x.e("MicroMsg.NetStatMsgExtension", "skip ipxx stat while account not set");
        }
        return null;
    }

    public final void a(int i, int i2, String str, int i3, String str2, boolean z) {
        g.Dm().g(new 3(this, i, i2, str, i3, str2, z), 3000);
    }

    public final void j(int i, int i2, int i3, int i4) {
        if (!g.Dh().Cy()) {
            return;
        }
        if (g.Dk().gQE.gQX) {
            x.i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            if (i <= 0) {
                i = 0;
            }
            if (i2 <= 0) {
                i2 = 0;
            }
            n.B(i, i2, 0);
            if (i3 <= 0) {
                i3 = 0;
            }
            if (i4 <= 0) {
                i4 = 0;
            }
            n.C(i3, i4, 0);
            return;
        }
        x.i("MicroMsg.NetStatMsgExtension", "kernel has not startup");
    }

    public static void b(int i, int i2, int i3, boolean z) {
        if (g.Dh().Cy()) {
            switch (i) {
                case 4:
                    x.d("MicroMsg.NetStatMsgExtension", "recv bytes flow:" + i3);
                    if (z) {
                        n.B(i3, 0, i2);
                        return;
                    } else {
                        n.C(i3, 0, i2);
                        return;
                    }
                case 5:
                    x.d("MicroMsg.NetStatMsgExtension", "send bytes flow:" + i3);
                    if (z) {
                        n.B(0, i3, i2);
                        return;
                    } else {
                        n.C(0, i3, i2);
                        return;
                    }
                case 8:
                    ae.Vc("dns_failed_report");
                    return;
                default:
                    return;
            }
        }
    }

    public final void h(au auVar) {
    }
}
