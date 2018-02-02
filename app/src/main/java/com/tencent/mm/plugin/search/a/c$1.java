package com.tencent.mm.plugin.search.a;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

class c$1 extends c<bc> {
    final /* synthetic */ c qbq;

    c$1(c cVar) {
        this.qbq = cVar;
        this.xen = bc.class.getName().hashCode();
    }

    private boolean a(bc bcVar) {
        InputStream fileInputStream;
        Throwable e;
        int intValue;
        if (bcVar != null && bcVar.fpl.fpm == 27) {
            if (bcVar.fpl.fpn == 2 && !c.bpT()) {
                c.dq(bcVar.fpl.fpn, 12);
            }
            String zS = g.zS(bcVar.fpl.fpn);
            String zT = g.zT(bcVar.fpl.fpn);
            int zU = g.zU(bcVar.fpl.fpn);
            if (!(bh.ov(zS) || bh.ov(zT))) {
                File file = new File(bcVar.fpl.filePath);
                if (file.exists()) {
                    x.i("MicroMsg.FTS.SubCoreSearch", "checkResUpdateListener callback to update %s", file.getAbsoluteFile());
                    File file2 = new File(zS, "temp");
                    File file3 = new File(file2, zT);
                    file2.mkdirs();
                    e.x(file.getAbsolutePath(), file3.getAbsolutePath());
                    int ft = bh.ft(file3.getAbsolutePath(), file2.getAbsolutePath());
                    if (ft >= 0) {
                        Properties properties = new Properties();
                        try {
                            fileInputStream = new FileInputStream(new File(file2, "config.conf"));
                            try {
                                properties.load(fileInputStream);
                                e.c(fileInputStream);
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    x.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, e.getMessage(), new Object[0]);
                                    e.c(fileInputStream);
                                    intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                    e.g(file2);
                                    if (zU < intValue) {
                                        if (ft >= 0) {
                                            c.dq(bcVar.fpl.fpn, 11);
                                        } else {
                                            c.dq(bcVar.fpl.fpn, 13);
                                        }
                                        x.i("MicroMsg.FTS.SubCoreSearch", "res no need update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(bcVar.fpl.fpn), Integer.valueOf(zU), Integer.valueOf(intValue));
                                    } else {
                                        c.dq(bcVar.fpl.fpn, 9);
                                        x.i("MicroMsg.FTS.SubCoreSearch", "res update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(bcVar.fpl.fpn), Integer.valueOf(zU), Integer.valueOf(intValue));
                                        c.f(file, bcVar.fpl.fpn);
                                    }
                                    return false;
                                } catch (Throwable th) {
                                    e = th;
                                    e.c(fileInputStream);
                                    throw e;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            fileInputStream = null;
                            x.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, e.getMessage(), new Object[0]);
                            e.c(fileInputStream);
                            intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                            e.g(file2);
                            if (zU < intValue) {
                                c.dq(bcVar.fpl.fpn, 9);
                                x.i("MicroMsg.FTS.SubCoreSearch", "res update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(bcVar.fpl.fpn), Integer.valueOf(zU), Integer.valueOf(intValue));
                                c.f(file, bcVar.fpl.fpn);
                            } else {
                                if (ft >= 0) {
                                    c.dq(bcVar.fpl.fpn, 13);
                                } else {
                                    c.dq(bcVar.fpl.fpn, 11);
                                }
                                x.i("MicroMsg.FTS.SubCoreSearch", "res no need update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(bcVar.fpl.fpn), Integer.valueOf(zU), Integer.valueOf(intValue));
                            }
                            return false;
                        } catch (Throwable th2) {
                            e = th2;
                            fileInputStream = null;
                            e.c(fileInputStream);
                            throw e;
                        }
                        intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                    } else {
                        intValue = 1;
                    }
                    e.g(file2);
                    if (zU < intValue) {
                        c.dq(bcVar.fpl.fpn, 9);
                        x.i("MicroMsg.FTS.SubCoreSearch", "res update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(bcVar.fpl.fpn), Integer.valueOf(zU), Integer.valueOf(intValue));
                        c.f(file, bcVar.fpl.fpn);
                    } else {
                        if (ft >= 0) {
                            c.dq(bcVar.fpl.fpn, 13);
                        } else {
                            c.dq(bcVar.fpl.fpn, 11);
                        }
                        x.i("MicroMsg.FTS.SubCoreSearch", "res no need update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(bcVar.fpl.fpn), Integer.valueOf(zU), Integer.valueOf(intValue));
                    }
                } else {
                    x.e("MicroMsg.FTS.SubCoreSearch", "checkResUpdateListener file not exist");
                }
            }
        }
        return false;
    }
}
