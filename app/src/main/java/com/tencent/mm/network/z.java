package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.Task;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

public final class z {
    final a[] iaF = new a[100];

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int iaG;
        final /* synthetic */ int iaH;
        final /* synthetic */ z iaI;

        AnonymousClass1(z zVar, int i, int i2) {
            this.iaI = zVar;
            this.iaG = i;
            this.iaH = i2;
        }

        public final void run() {
            MMLogic.reportCGIServerError(this.iaG, this.iaH);
        }
    }

    private static class a {
        r iaJ;
        l iaK;
        c iaL;
        long startTime;
        int taskId;

        private a() {
        }
    }

    protected final void finalize() {
        reset();
        super.finalize();
    }

    final boolean VE() {
        synchronized (this.iaF) {
            int i = 0;
            while (i < 100) {
                try {
                    if (this.iaF[i] != null && (701 == this.iaF[i].iaJ.getType() || 702 == this.iaF[i].iaJ.getType())) {
                        x.w("MicroMsg.MMNativeNetTaskAdapter", "hasAuthCmd Auth inQueue: netid=" + i + " type=" + this.iaF[i].iaJ.getType());
                        return true;
                    }
                } catch (Throwable e) {
                    this.iaF[i] = null;
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[]{bh.i(e), Integer.valueOf(i)});
                }
                i++;
            }
            return false;
        }
    }

    final boolean VF() {
        synchronized (this.iaF) {
            int i = 0;
            while (i < 100) {
                try {
                    if (this.iaF[i] != null && 1000 == this.iaF[i].iaJ.getType()) {
                        x.w("MicroMsg.MMNativeNetTaskAdapter", "hasWithoutLoginCmd inQueue: netid=" + i + " type=" + this.iaF[i].iaJ.getType());
                        return true;
                    }
                } catch (Throwable e) {
                    this.iaF[i] = null;
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[]{bh.i(e), Integer.valueOf(i)});
                }
                i++;
            }
            return false;
        }
    }

    final r ce(boolean z) {
        synchronized (this.iaF) {
            int i = 0;
            r rVar = null;
            while (i < 100) {
                if (this.iaF[i] != null) {
                    if (z) {
                        try {
                            if (this.iaF[i].iaJ instanceof com.tencent.mm.network.r.a) {
                                continue;
                            }
                        } catch (Throwable e) {
                            x.w("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bh.i(e)});
                        }
                    }
                    if (z || (this.iaF[i].iaJ instanceof com.tencent.mm.network.r.a)) {
                        if (701 == this.iaF[i].iaJ.getType() || 702 == this.iaF[i].iaJ.getType()) {
                            x.e("MicroMsg.MMNativeNetTaskAdapter", "getAutoAuthRR Auth inQueue: netid=" + i + " type=" + this.iaF[i].iaJ.getType());
                            return null;
                        } else if (rVar == null) {
                            rVar = this.iaF[i].iaJ;
                        } else {
                            continue;
                        }
                    }
                }
                i++;
            }
            return rVar;
        }
    }

    public final int VG() {
        int i = 0;
        for (int i2 = 0; i2 < 100; i2++) {
            try {
                if (this.iaF[i2] != null) {
                    this.iaF[i2].iaJ.getType();
                }
            } catch (Throwable e) {
                x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[]{bh.i(e), Integer.valueOf(i2)});
                i++;
                this.iaF[i2] = null;
            }
        }
        return i;
    }

    public final int a(r rVar, l lVar, c cVar, int i) {
        if (rVar == null) {
            x.e("MicroMsg.MMNativeNetTaskAdapter", "startTask  rr is null");
            return -1;
        }
        int i2;
        rVar.hashCode();
        Task task = new Task();
        synchronized (this.iaF) {
            int i3 = 0;
            while (i3 < 100) {
                try {
                    if (this.iaF[i3] == null) {
                        this.iaF[i3] = new a();
                        this.iaF[i3].iaJ = rVar;
                        this.iaF[i3].iaK = lVar;
                        this.iaF[i3].iaL = cVar;
                        this.iaF[i3].startTime = bh.Wp();
                        this.iaF[i3].taskId = task.taskID;
                        task.cmdID = rVar.KI().getCmdId();
                        task.cgi = rVar.getUri();
                        int type = rVar.getType();
                        task.needAuthed = (rVar.JY() & 1) != 1;
                        if (type == 126 || type == 701 || type == 702) {
                            task.needAuthed = false;
                            if (type == 701) {
                                task.retryCount = 1;
                            }
                        }
                        task.limitFlow = true;
                        if (type == f.CTRL_INDEX || type == JsApiChooseMedia.CTRL_INDEX || type == 220 || type == JsApiUploadWeRunData.CTRL_INDEX || type == p.CTRL_INDEX || type == 326 || type == 327) {
                            task.limitFlow = false;
                        }
                        task.channelStrategy = 0;
                        if (type == 233 || type == 835 || type == bc.CTRL_BYTE) {
                            task.channelStrategy = 1;
                        }
                        task.sendOnly = false;
                        if (type == 10 || type == 268369922) {
                            task.sendOnly = true;
                        }
                        if (rVar.KI().KH() && rVar.getUri() != null && rVar.getUri().length() > 0) {
                            task.channelSelect |= 1;
                        }
                        if (task.cmdID != 0) {
                            task.channelSelect |= 2;
                        }
                        task.reportArg = String.valueOf(type);
                        if (type == 522) {
                            task.totalTimeout = 300000;
                            task.priority = 0;
                        }
                        if (type == 710) {
                            task.totalTimeout = 15000;
                            task.serverProcessCost = 0;
                        }
                        x.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi startTask inQueue netid:%d hash[%d,%d] net:%d cgi:%s needAuthed:%b", new Object[]{Integer.valueOf(i3), Integer.valueOf(task.taskID), Integer.valueOf(rVar.Kh()), Integer.valueOf(task.channelSelect), task.cgi, Boolean.valueOf(task.needAuthed)});
                        i2 = i3;
                    } else {
                        i3++;
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bh.i(e)});
                }
            }
            i2 = -1;
        }
        if (-1 != i2) {
            if (i == 1) {
                task.retryCount = 0;
            }
            StnLogic.startTask(task);
        } else {
            x.e("MicroMsg.MMNativeNetTaskAdapter", "startTask err");
        }
        x.d("MicroMsg.MMNativeNetTaskAdapter", "startTask retsult=" + i2);
        return i2;
    }

    public final void reset() {
        x.i("MicroMsg.MMNativeNetTaskAdapter", "reset");
        StnLogic.reset();
        synchronized (this.iaF) {
            for (int i = 0; i < 100; i++) {
                if (this.iaF[i] != null) {
                    try {
                        x.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi reset outQueue: netId:%d hash:%d type:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.iaF[i].iaJ.getType()), Integer.valueOf(this.iaF[i].iaJ.Kh())});
                        this.iaF[i] = null;
                    } catch (Throwable e) {
                        x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bh.i(e)});
                    }
                }
            }
        }
    }

    public final void e(int i, int i2, String str) {
        x.i("MicroMsg.MMNativeNetTaskAdapter", "clearTaskAndCallback errType=" + i + ", errCode=" + i2 + ", errMsg=" + str);
        StnLogic.clearTask();
        StnLogic.reset();
        a[] aVarArr = new a[100];
        synchronized (this.iaF) {
            for (int i3 = 0; i3 < 100; i3++) {
                aVarArr[i3] = this.iaF[i3];
                this.iaF[i3] = null;
            }
        }
        for (int i4 = 0; i4 < 100; i4++) {
            if (aVarArr[i4] != null) {
                try {
                    x.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi clearTaskAndCallback outQueue: netId:%d hash:%d type:%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(aVarArr[i4].iaJ.getType()), Integer.valueOf(aVarArr[i4].iaJ.Kh())});
                    aVarArr[i4].iaK.a(i4, i, i2, str, aVarArr[i4].iaJ, null);
                } catch (Throwable e) {
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bh.i(e)});
                }
            }
        }
    }

    final int iR(int i) {
        int i2 = 0;
        synchronized (this.iaF) {
            int iS = iS(i);
            if (-1 == iS) {
                x.e("MicroMsg.MMNativeNetTaskAdapter", "-1 == index");
            } else {
                try {
                    i2 = this.iaF[iS].iaJ.KJ().KN();
                } catch (Throwable e) {
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bh.i(e)});
                }
            }
        }
        return i2;
    }

    final boolean a(int i, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2) {
        synchronized (this.iaF) {
            int iS = iS(i);
            if (-1 == iS) {
                return false;
            }
            boolean a;
            try {
                x.i("MicroMsg.MMNativeNetTaskAdapter", "link: %d req2Buf somr isfg:%b  cookie: %s", new Object[]{Integer.valueOf(i2), Boolean.valueOf(this.iaF[iS].iaL.Kv()), bh.by(this.iaF[iS].iaL.Ks())});
                this.iaF[iS].iaJ.KI().H(this.iaF[iS].iaL.CF());
                this.iaF[iS].iaJ.KI().eE(this.iaF[iS].iaL.Cg());
                a = this.iaF[iS].iaJ.KI().a(this.iaF[iS].iaJ.getType(), this.iaF[iS].iaL.CF(), this.iaF[iS].iaL.Ks(), this.iaF[iS].iaL.Ku(), 0, this.iaF[iS].iaL.Kv());
                if (a) {
                    byteArrayOutputStream.write(this.iaF[iS].iaJ.KI().KB());
                } else {
                    iArr[0] = 0;
                    d.pPH.a(162, (long) iArr[0], 1, false);
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "request to buffer using jni failed");
                }
            } catch (Throwable e) {
                iArr[0] = 1;
                d.pPH.a(162, (long) iArr[0], 1, false);
                x.e("MicroMsg.MMNativeNetTaskAdapter", "RemoteException:%s", new Object[]{bh.i(e)});
                a = false;
            } catch (Throwable e2) {
                iArr[0] = 2;
                d.pPH.a(162, (long) iArr[0], 1, false);
                x.e("MicroMsg.MMNativeNetTaskAdapter", "IOException:%s", new Object[]{bh.i(e2)});
                a = false;
            } catch (Throwable e22) {
                iArr[0] = 3;
                d.pPH.a(162, (long) iArr[0], 1, false);
                x.e("MicroMsg.MMNativeNetTaskAdapter", "Exception:%s", new Object[]{bh.i(e22)});
                a = false;
            }
            x.d("MicroMsg.MMNativeNetTaskAdapter", "req2Buf bOk: %b", new Object[]{Boolean.valueOf(a)});
            return a;
        }
    }

    final int a(int i, byte[] bArr, int[] iArr, int[] iArr2) {
        int iS;
        Throwable e;
        synchronized (this.iaF) {
            iS = iS(i);
            if (-1 == iS) {
                iS = -1;
            } else {
                int i2 = StnLogic.RESP_FAIL_HANDLE_DEFAULT;
                try {
                    byte[] KF = this.iaF[iS].iaJ.KI().KF();
                    h KJ = this.iaF[iS].iaJ.KJ();
                    if (KJ.a(this.iaF[iS].iaJ.getType(), bArr, KF)) {
                        iS = KJ.KL();
                        iArr2[0] = 0;
                        if ((iS & 2) == 0) {
                            iArr2[0] = iArr2[0] | 2;
                            d.pPH.a(656, 0, 1, false);
                        }
                        if ((iS & 4) == 0) {
                            iArr2[0] = iArr2[0] | 4;
                            d.pPH.a(656, 1, 1, false);
                        }
                        if (!(KJ.Ks() == null || -13 != KJ.KN() || aa.VQ() == null)) {
                            aa.VQ().Vu();
                        }
                        int i3;
                        if (-13 == KJ.KN()) {
                            i3 = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                            try {
                                iArr[0] = KJ.KN();
                                iS = i3;
                            } catch (RemoteException e2) {
                                e = e2;
                                i2 = i3;
                                d.pPH.a(162, 5, 1, false);
                                x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bh.i(e)});
                                iS = i2;
                                return iS;
                            } catch (Exception e3) {
                                e = e3;
                                i2 = i3;
                                d.pPH.a(162, 7, 1, false);
                                x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bh.i(e)});
                                iS = i2;
                                return iS;
                            }
                        } else if (-3002 == KJ.KN() || -3003 == KJ.KN()) {
                            i3 = StnLogic.RESP_FAIL_HANDLE_TASK_END;
                            iArr[0] = KJ.KN();
                            iS = i3;
                        } else if (-3001 == KJ.KN()) {
                            i3 = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                            iArr[0] = KJ.KN();
                            iS = i3;
                        } else {
                            iS = StnLogic.RESP_FAIL_HANDLE_NORMAL;
                        }
                    } else {
                        d.pPH.a(162, 4, 1, false);
                        x.e("MicroMsg.MMNativeNetTaskAdapter", "buf to resp failed, change server and try again");
                        iS = i2;
                    }
                } catch (RemoteException e4) {
                    e = e4;
                    d.pPH.a(162, 5, 1, false);
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bh.i(e)});
                    iS = i2;
                    return iS;
                } catch (Exception e5) {
                    e = e5;
                    d.pPH.a(162, 7, 1, false);
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bh.i(e)});
                    iS = i2;
                    return iS;
                }
            }
        }
        return iS;
    }

    final int iS(int i) {
        int i2 = 0;
        while (i2 < 100 && (this.iaF[i2] == null || i != this.iaF[i2].taskId)) {
            i2++;
        }
        if (100 <= i2) {
            return -1;
        }
        return i2;
    }
}
