package com.tencent.pb.common.b;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.u;
import com.tencent.pb.common.b.a.a.v;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.pb.talkroom.sdk.e;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Iterator;
import java.util.LinkedList;

public class f {
    private static f zMp = null;
    private int zMq;
    private LinkedList<a> zMr;
    public e zMs;
    private boolean zMt;
    private boolean zMu;

    private f() {
        this.zMq = 0;
        this.zMr = null;
        this.zMs = null;
        this.zMt = false;
        this.zMu = true;
        this.zMr = new LinkedList();
        this.zMu = true;
    }

    private static v bD(byte[] bArr) {
        try {
            return (v) com.google.a.a.e.a(new v(), bArr, bArr.length);
        } catch (Exception e) {
            c.m("NETCMD", new Object[]{"Exception genReadPackageData" + e.getMessage()});
            return null;
        }
    }

    private int a(a aVar, c cVar, String str, int i, byte[] bArr, int i2, int i3, int i4) {
        byte[] bArr2;
        int cCG = cCG();
        byte[] bArr3 = null;
        try {
            u uVar;
            if (bArr.length < 200 || bArr == null || bArr.length >= bArr.length) {
                uVar = new u();
                uVar.pK = i;
                uVar.zNY = cCG;
                uVar.userName = a.cCV();
                uVar.zMR = i4;
            } else {
                uVar = new u();
                uVar.pK = i;
                uVar.zNY = cCG;
                uVar.userName = a.cCV();
                uVar.zMR = i4;
            }
            if (bArr == null) {
                c.m("NETCMD", new Object[]{"body null"});
                bArr3 = null;
            } else {
                com.google.a.a.e vVar = new v();
                vVar.zOa = uVar;
                vVar.body = bArr;
                bArr3 = com.google.a.a.e.b(vVar);
            }
            bArr2 = bArr3;
        } catch (Exception e) {
            c.m("NetError", new Object[]{"newTaskHelper addTask body null"});
            bArr2 = bArr3;
        }
        if (bArr2 == null) {
            c.m("NETCMD", new Object[]{"cmd:" + i + "|body is null"});
            return -1;
        } else if (bArr2.length > 61440) {
            c.m("NETCMD", new Object[]{"cmd:" + i + "|body too large"});
            return -1;
        } else {
            a aVar2 = new a(this, (byte) 0);
            aVar2.mTaskId = cCG;
            aVar2.zMw = aVar;
            aVar2.zMx = cVar;
            aVar2.zMv = str;
            synchronized (this.zMr) {
                this.zMr.add(aVar2);
            }
            int i5 = 1933;
            switch (i) {
                case com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX /*139*/:
                    i5 = 1918;
                    break;
                case j.CTRL_INDEX /*141*/:
                    i5 = 1919;
                    break;
                case 143:
                    i5 = 1927;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*145*/:
                    i5 = 1931;
                    break;
                case 147:
                    i5 = 1932;
                    break;
                case 181:
                    i5 = 1929;
                    break;
                case 183:
                    i5 = 1928;
                    break;
                case k.CTRL_BYTE /*189*/:
                    i5 = 1935;
                    break;
                case h.CTRL_INDEX /*211*/:
                    i5 = 1937;
                    break;
                case 221:
                    i5 = 1938;
                    break;
                case 223:
                    i5 = 1939;
                    break;
            }
            c.d("NETCMD", new Object[]{"CLTSEND|", Integer.valueOf(cCG), Integer.valueOf(i5), str, a.cCV()});
            if (this.zMs != null) {
                this.zMs.b(cCG, i5, bArr2);
            }
            return cCG;
        }
    }

    private int cCG() {
        int i;
        synchronized (this.zMr) {
            this.zMq++;
            i = this.zMq;
        }
        return i;
    }

    public final a HJ(int i) {
        a aVar;
        synchronized (this.zMr) {
            Iterator it = this.zMr.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.mTaskId == i) {
                    break;
                }
            }
            aVar = null;
        }
        return aVar;
    }

    public static f cCH() {
        if (zMp == null) {
            synchronized (f.class) {
                if (zMp == null) {
                    zMp = new f();
                }
            }
        }
        return zMp;
    }

    final int a(a aVar, c cVar, int i, String str, byte[] bArr, int i2) {
        if (!this.zMu) {
            c.m("NETCMD", new Object[]{"doSendTask mIsInitSucc is false"});
            return -1;
        } else if (this.zMt) {
            c.m("NETCMD", new Object[]{"doSendTask fail: isRefreshing, cmd=" + i + ", cmdTag=" + str});
            return -1;
        } else {
            try {
                return a(aVar, cVar, str, i, bArr, 0, 0, i2);
            } catch (Throwable th) {
                c.m("NETCMD", new Object[]{"Exception doSendTask", th});
                return -1;
            }
        }
    }

    public final int a(a aVar, String str, com.google.a.a.e eVar) {
        try {
            return a(aVar, null, 31, str, com.google.a.a.e.b(eVar), 0);
        } catch (Exception e) {
            c.m("NETCMD", new Object[]{"doSendTask exception:", e});
            return -1;
        }
    }

    public static int bE(byte[] bArr) {
        if (bArr == null) {
            c.m("NETCMD", new Object[]{"CLTNOT onNotify1 data == null ", Integer.valueOf(0)});
            com.tencent.wecall.talkroom.model.h.Jd(-1601);
            if (TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.cHv().nln) && TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.cHv().Anw)) {
                com.tencent.wecall.talkroom.model.h.a(com.tencent.wecall.talkroom.model.a.cHv().nJW, com.tencent.wecall.talkroom.model.a.cHv().Anx, new String[]{"notify", "datanull"});
            } else {
                com.tencent.wecall.talkroom.model.a.cHv().AnF.Q(new String[]{"notify", "datanull"});
            }
            return -1;
        }
        c.d("NETCMD", new Object[]{"CLTNOT onNotify data len=", Integer.valueOf(bArr.length)});
        return com.tencent.wecall.talkroom.model.a.cHv().bS(bArr);
    }

    public final void a(a aVar, int i, byte[] bArr) {
        try {
            if (aVar.zMx != null) {
                aVar.zMx.p(i, bArr);
            }
            if (aVar.zMw != null) {
                aVar.zMw.dD(aVar.zMv, i);
            }
        } catch (Exception e) {
            c.m("NETCMD", new Object[]{"postRespData", e.getMessage()});
        }
        synchronized (this.zMr) {
            this.zMr.remove(aVar);
        }
    }

    public final int q(int i, byte[] bArr) {
        a HJ = HJ(i);
        if (HJ != null || DownloadResult.CODE_UNDEFINED == i) {
            v bD = bD(bArr);
            if (bD == null || bD.zOa == null) {
                String str;
                String str2 = "NETCMD";
                Object[] objArr = new Object[2];
                objArr[0] = " pack.head: ";
                if (bD == null) {
                    str = " pack is null ";
                } else {
                    str = " head is " + bD.zOa;
                }
                objArr[1] = str;
                c.m(str2, objArr);
                a(HJ, -3, null);
                return -1;
            }
            int i2 = bD.zOa.ret;
            int i3 = bD.zOa.zNZ;
            String str3 = bD.zOa.userName;
            if (com.tencent.pb.common.a.a.zLG) {
                Toast.makeText(d.ssG, "retCode: " + i2 + " debugCode: " + i3, 0).show();
            }
            if (i2 != 0 && HJ != null) {
                c.m("NETCMD", new Object[]{"CLTRCV", Integer.valueOf(i), HJ.zMv, Integer.valueOf(i2), str3, Integer.valueOf(i3)});
            } else if (HJ != null) {
                c.d("NETCMD", new Object[]{"CLTRCV", Integer.valueOf(i), HJ.zMv, Integer.valueOf(i2), str3, Integer.valueOf(i3)});
            }
            byte[] bArr2 = bD.body;
            if (bArr2 != null) {
                a(HJ, i2, bArr2);
                return 0;
            }
            a(HJ, i2, null);
            return 0;
        }
        c.m("NETCMD", new Object[]{"buf2Resp fail: taskId:" + i + " not found"});
        com.tencent.pb.common.c.f.w(20007, 3, "-1202");
        return 1;
    }
}
