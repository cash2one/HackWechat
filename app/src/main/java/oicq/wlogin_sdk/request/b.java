package oicq.wlogin_sdk.request;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.util;

public final class b {
    private static /* synthetic */ int[] AvP;
    public i AvG = new i();
    private j AvH = new j(this.AvG);
    private f AvI = new f(this.AvG);
    private g AvJ = new g(this.AvG);
    private h AvK = new h(this.AvG);
    private e AvL = new e(this.AvG);
    public d AvM = null;
    private int AvN = 66560;
    private int AvO = 1404;
    private Context mContext = null;

    public enum a {
        USER_WITH_PWD,
        USER_WITH_MD5,
        USER_WITH_A1
    }

    private static /* synthetic */ int[] cJL() {
        int[] iArr = AvP;
        if (iArr == null) {
            iArr = new int[a.values().length];
            try {
                iArr[a.USER_WITH_A1.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[a.USER_WITH_MD5.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[a.USER_WITH_PWD.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            AvP = iArr;
        }
        return iArr;
    }

    public b(Context context, int i) {
        this.mContext = context;
        i iVar = this.AvG;
        iVar._context = context;
        iVar.Awu = i;
        iVar.AwO = new c(context);
        Object obj = new byte[16];
        iVar.Awl.nextBytes(obj);
        System.arraycopy(obj, 0, iVar.Awo, 0, 16);
        cJK();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a(long j, a aVar, String str) {
        util.acy("wtlogin login with GetStWithPasswd:user:" + j + " appid:522017402 dwSigMap:8256" + " ...");
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        synchronized (this) {
            byte[] acw;
            Object obj;
            switch (cJL()[aVar.ordinal()]) {
                case 1:
                    if (str != null && str.length() != 0) {
                        acw = c.acw(str);
                        obj = null;
                        break;
                    }
                    util.acy("USER_WITH_PWD userPasswd null");
                    return null;
                    break;
                case 2:
                    if (str != null) {
                        if (str.length() != 0) {
                            try {
                                acw = (byte[]) str.getBytes("ISO-8859-1").clone();
                                obj = null;
                                break;
                            } catch (Exception e) {
                                return null;
                            }
                        }
                    }
                    util.acy("USER_WITH_MD5 userPasswd null");
                    return null;
                case 3:
                    WloginSigInfo M = this.AvG.M(j, 522017402);
                    if (M == null || M._en_A1 == null || M._en_A1.length <= 0) {
                        util.acy("userAccount:" + j + " appid:522017402" + " GetA1ByAccount return: null");
                        acw = null;
                    } else {
                        util.acy("userAccount:" + j + " appid:522017402" + " GetA1ByAccount return: not null");
                        acw = (byte[]) M._en_A1.clone();
                    }
                    if (acw != null && acw.length >= 16) {
                        obj = 1;
                        break;
                    }
                    util.acy("USER_WITH_A1 tmp_pwd null");
                    return null;
                default:
                    return null;
            }
            this.AvG.Awy = util.iY(this.mContext);
            this.AvG.AwA = util.jb(this.mContext).getBytes();
            this.AvG._uin = j;
            this.AvG.Awr = 522017402;
            this.AvG.Aws = 8256;
            this.AvG.Awp = new f();
            this.AvM = this.AvH;
            byte[] a;
            if (obj != null) {
                a = this.AvH.a(522017402, j, this.AvG.AwM, acw, this.AvO, this.AvN, 8256, this.AvG.AwJ);
            } else {
                byte[] bArr = new byte[4];
                util.d(bArr, 0, i.cJO());
                a = this.AvH.a(522017402, j, this.AvG.AwM, bArr, acw, this.AvO, this.AvN, 8256, this.AvG.AwJ);
            }
        }
    }

    public final byte[] f(long j, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        byte[] bW;
        util.acy("user:" + j + " CheckPicture ...");
        synchronized (this) {
            this.AvM = this.AvJ;
            bW = this.AvJ.bW(bArr);
        }
        util.acy("user:" + j + " CheckPicture end");
        return bW;
    }

    public final byte[] gJ(long j) {
        Object obj;
        synchronized (this) {
            g gVar = this.AvG.Awq;
            obj = new byte[gVar.Axb];
            if (gVar.Axb > 0) {
                System.arraycopy(gVar.Awb, gVar.Axd, obj, 0, gVar.Axb);
            }
        }
        util.acy("user:" + j + " GetPicture data len:" + obj.length);
        return obj;
    }

    public final void gK(long j) {
        util.acy("user:" + j + " ClearUserSigInfo");
        this.AvG.h(Long.valueOf(j));
    }

    private int cJK() {
        synchronized (this) {
            Object jd = util.jd(this.mContext);
            if (jd == null || jd.length <= 0) {
                jd = util.iW(this.mContext);
                if (jd == null || jd.length <= 0) {
                    jd = new String("%4;7t>;28<fc.5*6").getBytes();
                    this.AvG.AwH = 0;
                } else {
                    this.AvG.AwH = 1;
                }
                util.b(this.mContext, jd);
                this.AvG.AwG = 1;
                this.AvG.AwI = 1;
            } else {
                this.AvG.AwH = 1;
                this.AvG.AwG = 0;
                this.AvG.AwI = 0;
            }
            this.AvG.Awv = new byte[jd.length];
            System.arraycopy(jd, 0, this.AvG.Awv, 0, jd.length);
            Object obj = new byte[(jd.length + 1)];
            obj[0] = (byte) 35;
            System.arraycopy(jd, 0, obj, 1, jd.length);
            this.AvG.Awm = util.ce(obj);
            i.Aww = (byte[]) this.AvG.Awv.clone();
            this.AvG.Awx = util.iX(this.mContext);
            int iZ = util.iZ(this.mContext);
            this.AvG.Awy = util.iY(this.mContext);
            if (iZ != this.AvG.Awy) {
                util.ja(this.mContext);
                util.at(this.mContext, this.AvG.Awy);
            }
            this.AvG.AwA = util.jb(this.mContext).getBytes();
            this.AvG.AwJ = util.jc(this.mContext);
            this.AvG.Awz = util.je(this.mContext);
            this.AvG.AwC = util.bZ(this.mContext, new String(this.AvG.Awz));
            this.AvG.AwD = util.ca(this.mContext, new String(this.AvG.Awz));
            String str = Build.MODEL;
            if (str == null) {
                this.AvG.AwE = new byte[0];
            } else {
                this.AvG.AwE = str.getBytes();
            }
            if (util.isFileExist("/system/bin/su") || util.isFileExist("/system/xbin/su") || util.isFileExist("/sbin/su")) {
                iZ = 1;
            } else {
                iZ = 0;
            }
            i iVar = this.AvG;
            if (iZ != 0) {
                iZ = 1;
            } else {
                iZ = 0;
            }
            iVar.AwF = iZ;
            str = VERSION.RELEASE;
            if (str == null) {
                str = "";
            }
            util.acy("WtloginHelper init ok: android version:" + str + " release time:" + util.cKa());
        }
        return 0;
    }
}
