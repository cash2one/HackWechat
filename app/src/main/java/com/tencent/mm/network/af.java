package com.tencent.mm.network;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.ICallBack;
import com.tencent.mm.aj.a;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public final class af implements ICallBack {
    private static WakerLock ibh = null;
    private static int ibi = 1000000205;
    private static int ibj = g.CTRL_INDEX;
    private static byte[] ibk;
    private static byte[] ibl;

    private static String exception2String(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public final boolean makesureAuthed() {
        boolean z = false;
        if (aa.VQ() != null) {
            try {
                z = aa.VQ().Vv();
            } catch (Exception e) {
                x.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
            }
        }
        return z;
    }

    public final String[] onNewDns(String str) {
        return new String[0];
    }

    public final void onPush(int i, byte[] bArr) {
        if (aa.VS() != null) {
            try {
                if (ibh == null) {
                    ibh = new WakerLock(aa.getContext());
                }
                ibh.lock(1000, "StnLogic.onNotify");
                aa.VO().post(new 1(this, i, bArr));
            } catch (Exception e) {
                x.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            }
        }
    }

    public final boolean req2Buf(int i, Object obj, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2) {
        boolean z = false;
        if (aa.VR() != null) {
            try {
                z = aa.VR().a(i, byteArrayOutputStream, iArr, i2);
            } catch (Exception e) {
                x.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
            }
        }
        return z;
    }

    public final int buf2Resp(int i, Object obj, byte[] bArr, int[] iArr, int[] iArr2, int i2) {
        int i3 = -1;
        if (aa.VR() != null) {
            try {
                i3 = aa.VR().a(i, bArr, iArr, iArr2);
            } catch (Exception e) {
                x.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            }
        }
        return i3;
    }

    public final int onTaskEnd(int i, Object obj, int i2, int i3) {
        Exception exception;
        int i4;
        if (aa.VR() == null) {
            return 0;
        }
        try {
            int iR = aa.VR().iR(i);
            try {
                aa.VO().post(new 2(this, i, obj, i2, i3));
                return iR;
            } catch (Exception e) {
                exception = e;
                i4 = iR;
                x.e("StnCallBack", exception2String(exception));
                new StringBuilder().append(exception.getClass().getSimpleName()).append(":").append(exception.getStackTrace()[0]).append(", ").append(exception.getStackTrace()[1]);
                return i4;
            }
        } catch (Exception e2) {
            exception = e2;
            i4 = 0;
            x.e("StnCallBack", exception2String(exception));
            new StringBuilder().append(exception.getClass().getSimpleName()).append(":").append(exception.getStackTrace()[0]).append(", ").append(exception.getStackTrace()[1]);
            return i4;
        }
    }

    public final void reportConnectInfo(int i, int i2) {
        try {
            aa.VN().iT(i);
            a.hz(i);
        } catch (Throwable e) {
            x.e("StnCallBack", "reportConnectInfo :%s", bh.i(e));
        }
    }

    public final int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, int[] iArr) {
        iArr[0] = ibj;
        iArr[1] = ibi;
        if (a(byteArrayOutputStream, byteArrayOutputStream2) != 0 && byteArrayOutputStream.size() != 0 && byteArrayOutputStream2.size() != 0) {
            return StnLogic.ECHECK_NOW;
        }
        requestDoSync();
        return StnLogic.ECHECK_NEXT;
    }

    public final boolean onLongLinkIdentifyResp(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr2 == null)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr2);
            } catch (IOException e) {
            }
            onPush(ibi, byteArrayOutputStream.toByteArray());
        }
        return true;
    }

    public final String[] requestNetCheckShortLinkHosts() {
        return new String[0];
    }

    private static int a(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2) {
        int i = 0;
        if (aa.VQ() != null) {
            try {
                byte[] Vw = aa.VQ().Vw();
                if (Vw != null) {
                    byteArrayOutputStream.write(Vw);
                    ibk = Vw;
                }
                Vw = aa.VQ().gPQ;
                if (Vw != null) {
                    byteArrayOutputStream2.write(Vw);
                    ibl = Vw;
                }
                i = aa.VQ().hZK.Cg();
            } catch (Exception e) {
                x.e("StnCallBack", exception2String(e));
                if (!(ibk == null || ibl == null)) {
                    try {
                        byteArrayOutputStream.write(ibk);
                        byteArrayOutputStream2.write(ibl);
                    } catch (IOException e2) {
                    }
                }
            }
        }
        return i;
    }

    public final void requestDoSync() {
        if (aa.VS() != null) {
            try {
                aa.VO().post(new 3(this));
            } catch (Exception e) {
                x.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            }
        }
    }

    public final boolean isLogoned() {
        boolean z = false;
        if (aa.VQ() != null) {
            try {
                z = aa.VQ().hZK.Kt();
            } catch (Exception e) {
                x.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
            }
        }
        return z;
    }

    public final void networkAnalysisCallBack(int i, int i2, boolean z, String str) {
        x.i("StnCallBack", "networkAnalysisCallBack: status:%d, stage:%d, isDetectEnd:%b, kvInfo:%s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str);
        try {
            aa.VQ().hZS.networkAnalysisCallBack(i, i2, z, str);
        } catch (Throwable e) {
            x.printErrStackTrace("StnCallBack", e, "", new Object[0]);
            new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
        }
    }
}
