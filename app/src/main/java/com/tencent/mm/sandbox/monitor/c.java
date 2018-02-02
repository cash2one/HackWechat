package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.c.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.b;
import com.tencent.mm.sandbox.updater.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public abstract class c implements b {
    public static final String xca = e.bnF;
    public int xcb;
    public int xcc;
    public int xcd;
    public String xce;
    private boolean xcf = false;

    public c(int i, String str, int i2, boolean z) {
        this.xcc = i;
        this.xce = str;
        this.xcb = i2;
        this.xcf = z;
        this.xcd = com.tencent.mm.a.e.bN(baW());
        File file = new File(xca);
        if (!file.exists()) {
            file.mkdirs();
        }
        x.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + baW() + " packOffset = " + this.xcd);
    }

    public String baW() {
        return xca + this.xce + ".temp";
    }

    public String ceg() {
        return xca + this.xce + ".apk";
    }

    public final void deleteTempFile() {
        try {
            x.d("MM.GetUpdatePack", "deleteTempFile");
            File file = new File(baW());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            x.e("MM.GetUpdatePack", "error in deleteTempFile");
        }
    }

    public static boolean UC(String str) {
        if (com.tencent.mm.a.e.bO(xca + str + ".temp")) {
            return true;
        }
        return false;
    }

    public static String UD(String str) {
        String str2 = xca + str + ".apk";
        return (com.tencent.mm.a.e.bO(str2) && a.ch(str2)) ? str2 : null;
    }

    public static String IB(String str) {
        return be(str, false);
    }

    public static String be(String str, boolean z) {
        Exception exception;
        g gVar;
        Object[] objArr;
        String str2 = xca + str + ".temp";
        String str3 = xca + str + ".apk";
        if (com.tencent.mm.a.e.bO(str2) && !z && (a.ch(str2) || str.equalsIgnoreCase(com.tencent.mm.a.g.bV(str2)))) {
            com.tencent.mm.a.e.g(xca, str + ".temp", str + ".apk");
            return str3;
        }
        if (com.tencent.mm.a.e.bO(str3)) {
            if (a.ch(str3)) {
                x.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
                return str3;
            }
            try {
                str2 = com.tencent.mm.c.c.k(new File(str3));
                try {
                    if (bh.ov(str2)) {
                        g.pQN.a(322, 10, 1, false);
                        g.pQN.h(11098, new Object[]{Integer.valueOf(4010)});
                    }
                } catch (Exception e) {
                    exception = e;
                    x.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + exception.getMessage());
                    g.pQN.a(322, 9, 1, false);
                    g.pQN.h(11098, new Object[]{Integer.valueOf(4009), exception.getMessage()});
                    x.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", new Object[]{str2});
                    if (bh.ov(str2)) {
                        x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", new Object[]{str2, i.ces()});
                        if (str2.equals(i.ces())) {
                            x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                            g.pQN.a(322, 11, 1, false);
                            gVar = g.pQN;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(4011);
                            objArr[1] = String.format("%s,%s", new Object[]{r10, str2});
                            gVar.h(11098, objArr);
                        } else {
                            x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                            return str3;
                        }
                    } else if (str.equalsIgnoreCase(com.tencent.mm.a.g.bV(str3))) {
                        x.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                        return str3;
                    }
                    x.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
                    com.tencent.mm.loader.stub.b.deleteFile(str3);
                    return null;
                }
            } catch (Exception e2) {
                exception = e2;
                str2 = null;
                x.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + exception.getMessage());
                g.pQN.a(322, 9, 1, false);
                g.pQN.h(11098, new Object[]{Integer.valueOf(4009), exception.getMessage()});
                x.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", new Object[]{str2});
                if (bh.ov(str2)) {
                    x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", new Object[]{str2, i.ces()});
                    if (str2.equals(i.ces())) {
                        x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                        return str3;
                    }
                    x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                    g.pQN.a(322, 11, 1, false);
                    gVar = g.pQN;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(4011);
                    objArr[1] = String.format("%s,%s", new Object[]{r10, str2});
                    gVar.h(11098, objArr);
                } else if (str.equalsIgnoreCase(com.tencent.mm.a.g.bV(str3))) {
                    x.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                    return str3;
                }
                x.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
                com.tencent.mm.loader.stub.b.deleteFile(str3);
                return null;
            }
            x.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", new Object[]{str2});
            if (bh.ov(str2)) {
                x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", new Object[]{str2, i.ces()});
                if (str2.equals(i.ces())) {
                    x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                    return str3;
                }
                x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                g.pQN.a(322, 11, 1, false);
                gVar = g.pQN;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4011);
                objArr[1] = String.format("%s,%s", new Object[]{r10, str2});
                gVar.h(11098, objArr);
            } else if (str.equalsIgnoreCase(com.tencent.mm.a.g.bV(str3))) {
                x.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                return str3;
            }
            x.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
            com.tencent.mm.loader.stub.b.deleteFile(str3);
        }
        return null;
    }

    public final boolean ceh() {
        if (!this.xcf || an.isWifi(ac.getContext())) {
            return false;
        }
        return true;
    }
}
