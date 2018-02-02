package oicq.wlogin_sdk.request;

import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Array;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.ab;
import oicq.wlogin_sdk.a.ac;
import oicq.wlogin_sdk.a.ad;
import oicq.wlogin_sdk.a.af;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.ai;
import oicq.wlogin_sdk.a.ak;
import oicq.wlogin_sdk.a.al;
import oicq.wlogin_sdk.a.am;
import oicq.wlogin_sdk.a.ap;
import oicq.wlogin_sdk.a.e;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.j;
import oicq.wlogin_sdk.a.l;
import oicq.wlogin_sdk.a.m;
import oicq.wlogin_sdk.a.n;
import oicq.wlogin_sdk.a.o;
import oicq.wlogin_sdk.a.p;
import oicq.wlogin_sdk.a.q;
import oicq.wlogin_sdk.a.s;
import oicq.wlogin_sdk.a.t;
import oicq.wlogin_sdk.a.u;
import oicq.wlogin_sdk.a.v;
import oicq.wlogin_sdk.a.w;
import oicq.wlogin_sdk.a.x;
import oicq.wlogin_sdk.a.z;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class d {
    protected static int Awd = 0;
    int AvV = Downloads.RECV_BUFFER_SIZE;
    int AvW = 0;
    int AvX = 27;
    int AvY = 0;
    public int AvZ = 15;
    protected int Awa = 0;
    protected byte[] Awb = new byte[this.AvV];
    protected int Awc = 8001;
    protected int Awe = 0;
    protected int Awf = 0;
    protected int Awg = 0;
    protected int Awh = 0;
    protected int Awi = 0;
    byte Awj;
    protected i Awk;

    public final void a(int i, int i2, int i3, long j, int i4, int i5, int i6, int i7, byte[] bArr) {
        int length = bArr.length;
        int i8 = Awd + 1;
        Awd = i8;
        this.AvW = 0;
        util.z(this.Awb, this.AvW, 2);
        this.AvW++;
        util.A(this.Awb, this.AvW, (this.AvX + 2) + length);
        this.AvW += 2;
        util.A(this.Awb, this.AvW, i);
        this.AvW += 2;
        util.A(this.Awb, this.AvW, i2);
        this.AvW += 2;
        util.A(this.Awb, this.AvW, i8);
        this.AvW += 2;
        util.B(this.Awb, this.AvW, (int) j);
        this.AvW += 4;
        util.z(this.Awb, this.AvW, 3);
        this.AvW++;
        util.z(this.Awb, this.AvW, 0);
        this.AvW++;
        util.z(this.Awb, this.AvW, i4);
        this.AvW++;
        util.B(this.Awb, this.AvW, i5);
        this.AvW += 4;
        util.B(this.Awb, this.AvW, i6);
        this.AvW += 4;
        util.B(this.Awb, this.AvW, i7);
        this.AvW += 4;
        if ((this.AvW + length) + 1 > this.AvV) {
            this.AvV = ((this.AvW + length) + 1) + FileUtils.S_IWUSR;
            Object obj = new byte[this.AvV];
            System.arraycopy(this.Awb, 0, obj, 0, this.AvW);
            this.Awb = obj;
        }
        System.arraycopy(bArr, 0, this.Awb, this.AvW, length);
        this.AvW = length + this.AvW;
        util.z(this.Awb, this.AvW, 3);
        this.AvW++;
    }

    public final int S(byte[] bArr, int i) {
        int i2 = 0;
        if (i <= this.AvZ + 2) {
            return -1009;
        }
        this.Awa = (i - this.AvZ) - 2;
        if (i > this.AvV) {
            this.AvV = i + FileUtils.S_IWUSR;
            this.Awb = new byte[this.AvV];
        }
        this.AvW = i;
        System.arraycopy(bArr, 0, this.Awb, 0, i);
        int i3 = this.AvZ + 1;
        Object decrypt = oicq.wlogin_sdk.tools.d.decrypt(this.Awb, i3, this.Awa, this.Awk.Awo);
        if (decrypt == null) {
            i2 = -1002;
        } else {
            this.Awa = decrypt.length;
            if ((decrypt.length + this.AvZ) + 2 > this.AvV) {
                this.AvV = (decrypt.length + this.AvZ) + 2;
                Object obj = new byte[this.AvV];
                System.arraycopy(this.Awb, 0, obj, 0, this.AvW);
                this.Awb = obj;
            }
            this.AvW = 0;
            System.arraycopy(decrypt, 0, this.Awb, i3, decrypt.length);
            this.AvW = (decrypt.length + (this.AvZ + 2)) + this.AvW;
        }
        if (i2 >= 0) {
            return w(this.Awb, this.AvZ + 1, this.Awa);
        }
        return -1002;
    }

    public final byte[] cJM() {
        Object obj = new byte[this.AvW];
        System.arraycopy(this.Awb, 0, obj, 0, this.AvW);
        return obj;
    }

    final byte[] u(byte[] bArr, int i, int i2) {
        Object obj = new byte[(bArr.length + 4)];
        util.A(obj, 0, i);
        util.A(obj, 2, i2);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        obj = oicq.wlogin_sdk.tools.d.b(obj, obj.length, this.Awk.Awo);
        Object obj2 = new byte[(obj.length + this.Awk.Awo.length)];
        System.arraycopy(this.Awk.Awo, 0, obj2, 0, this.Awk.Awo.length);
        System.arraycopy(obj, 0, obj2, this.Awk.Awo.length, obj.length);
        return obj2;
    }

    public final int T(byte[] bArr, int i) {
        this.Awj = bArr[i];
        return bArr[i] & 255;
    }

    public final void v(byte[] bArr, int i, int i2) {
        a aiVar = new ai();
        if (aiVar.y(bArr, i, i2) >= 0) {
            ErrMsg errMsg = this.Awk.AwK;
            Object obj = new byte[aiVar.Axz];
            System.arraycopy(aiVar.Awb, aiVar.AwQ + 6, obj, 0, aiVar.Axz);
            errMsg.title = new String(obj);
            errMsg = this.Awk.AwK;
            obj = new byte[aiVar.AxA];
            System.arraycopy(aiVar.Awb, (aiVar.AwQ + 8) + aiVar.Axz, obj, 0, aiVar.AxA);
            errMsg.message = new String(obj);
            errMsg = this.Awk.AwK;
            obj = new byte[aiVar.AxB];
            System.arraycopy(aiVar.Awb, ((aiVar.AwQ + 12) + aiVar.Axz) + aiVar.AxA, obj, 0, aiVar.AxB);
            errMsg.AxI = new String(obj);
            return;
        }
        this.Awk.AwK.cJT();
    }

    public final void cJN() {
        this.Awk.AwK.cJT();
    }

    public final byte[] bU(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[(bArr.length + this.Awk.Awm.length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(this.Awk.Awm, 0, bArr2, bArr.length, this.Awk.Awm.length);
        return bArr2;
    }

    public final byte[] bV(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return null;
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        int length = bArr2.length - 16;
        Object obj = new byte[length];
        System.arraycopy(bArr2, 0, obj, 0, length);
        this.Awk.Awm = new byte[16];
        System.arraycopy(bArr2, length, this.Awk.Awm, 0, 16);
        return obj;
    }

    private int a(s sVar) {
        long j = 4294967295L;
        a oVar = new o();
        a pVar = new p();
        a lVar = new l();
        a qVar = new q();
        a eVar = new e();
        a tVar = new t();
        a dVar = new oicq.wlogin_sdk.a.d();
        a mVar = new m();
        a uVar = new u();
        a wVar = new w();
        a xVar = new x();
        a jVar = new j();
        a hVar = new h();
        a nVar = new n();
        a zVar = new z();
        a vVar = new v();
        a adVar = new ad();
        a abVar = new ab();
        a afVar = new af();
        a apVar = new ap();
        a akVar = new ak();
        a alVar = new al();
        a amVar = new am();
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        byte[] bArr4 = null;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        byte[] bArr8 = null;
        a acVar = new ac();
        byte[] cJP = sVar.cJP();
        int length = cJP.length;
        oVar.y(cJP, 2, length);
        pVar.y(cJP, 2, length);
        lVar.y(cJP, 2, length);
        qVar.y(cJP, 2, length);
        int y = tVar.y(cJP, 2, length);
        if (y < 0) {
            return y;
        }
        Object obj;
        long Y;
        long j2;
        long j3;
        if (eVar.y(cJP, 2, length) >= 0) {
            bArr6 = eVar.cJP();
        }
        if (jVar.y(cJP, 2, length) >= 0) {
            util.a(this.Awk._context, jVar.cJP());
        }
        if (dVar.y(cJP, 2, length) >= 0) {
            bArr = dVar.cJP();
        }
        if (mVar.y(cJP, 2, length) >= 0) {
            bArr2 = mVar.cJP();
        }
        if (uVar.y(cJP, 2, length) >= 0) {
            bArr3 = uVar.cJP();
        }
        if (wVar.y(cJP, 2, length) >= 0) {
            bArr4 = wVar.cJP();
        }
        if (xVar.y(cJP, 2, length) >= 0) {
            bArr5 = xVar.cJP();
        }
        if (zVar.y(cJP, 2, length) >= 0) {
            bArr7 = new byte[zVar.Axp];
            System.arraycopy(zVar.Awb, zVar.AwQ + 2, bArr7, 0, bArr7.length);
            bArr8 = new byte[zVar.Axq];
            System.arraycopy(zVar.Awb, ((zVar.AwQ + 2) + zVar.Axp) + 2, bArr8, 0, bArr8.length);
        }
        if (alVar.y(cJP, 2, length) >= 0) {
            a hVar2 = new h();
            eVar = new n();
            dVar = new am();
            ah ahVar = new ah();
            byte[] cJP2 = alVar.cJP();
            int length2 = cJP2.length;
            if (hVar2.y(cJP2, 2, length2) < 0) {
                obj = null;
            } else if (eVar.y(cJP2, 2, length2) < 0) {
                obj = null;
            } else if (dVar.y(cJP2, 2, length2) < 0) {
                obj = null;
            } else {
                Object cJM = hVar2.cJM();
                obj = eVar.cJM();
                Object cJM2 = dVar.cJM();
                Object cb = ahVar.cb(this.Awk.Awv);
                Object obj2 = new byte[((((cJM.length + 3) + obj.length) + cJM2.length) + cb.length)];
                obj2[0] = (byte) 64;
                util.A(obj2, 1, 4);
                System.arraycopy(cJM, 0, obj2, 3, cJM.length);
                int length3 = cJM.length + 3;
                System.arraycopy(obj, 0, obj2, length3, obj.length);
                int length4 = obj.length + length3;
                System.arraycopy(cJM2, 0, obj2, length4, cJM2.length);
                System.arraycopy(cb, 0, obj2, length4 + cJM2.length, cb.length);
                obj = obj2;
            }
            if (obj == null || obj.length <= 0) {
                this.Awk.AwN = new byte[0];
            } else {
                this.Awk.AwN = (byte[]) obj.clone();
                util.gj("fast data:", util.cf(obj));
            }
        }
        byte[][] bArr9 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{7, 0});
        if (acVar.y(cJP, 2, length) >= 0) {
            bArr9[0] = acVar.cJP();
        }
        y = nVar.y(cJP, 2, length);
        if (hVar.y(cJP, 2, length) >= 0 && y >= 0) {
            this.Awk.Awm = nVar.cJP();
            this.Awk.AwL = bU(hVar.cJP());
            bArr9[1] = (byte[]) this.Awk.AwL.clone();
        }
        if (abVar.y(cJP, 2, length) >= 0) {
            obj = new byte[abVar.Axs];
            System.arraycopy(abVar.Awb, abVar.AwQ + 2, obj, 0, obj.length);
            bArr9[2] = obj;
        }
        if (afVar.y(cJP, 2, length) >= 0) {
            bArr9[3] = afVar.cJP();
        }
        if (apVar.y(cJP, 2, length) >= 0) {
            bArr9[4] = apVar.cJP();
        }
        if (akVar.y(cJP, 2, length) >= 0) {
            bArr9[5] = akVar.cJP();
        }
        if (amVar.y(cJP, 2, length) >= 0) {
            bArr9[6] = amVar.cJP();
        }
        if (vVar.y(cJP, 2, length) >= 0) {
            if (this.Awk.Awt == -1) {
                Y = (long) util.Y(vVar.Awb, vVar.AwQ);
            } else {
                Y = this.Awk.Awt;
            }
            j = 4294967295L & ((long) util.Y(vVar.Awb, vVar.AwQ + 4));
            j2 = Y;
        } else {
            j2 = 3600;
        }
        if (adVar.y(cJP, 2, length) < 0 || adVar.cJS() == 0) {
            Y = 2160000;
        } else {
            Y = (long) adVar.cJS();
        }
        if (Y < j2) {
            j3 = j2;
        } else {
            j3 = Y;
        }
        i iVar = this.Awk;
        long j4 = this.Awk._uin;
        long j5 = this.Awk.Awr;
        long cJO = i.cJO();
        j2 += i.cJO();
        j3 += i.cJO();
        Object obj3 = new byte[2];
        System.arraycopy(tVar.Awb, tVar.AwQ, obj3, 0, 2);
        Object obj4 = new byte[1];
        System.arraycopy(tVar.Awb, tVar.AwQ + 2, obj4, 0, 1);
        Object obj5 = new byte[1];
        System.arraycopy(tVar.Awb, (tVar.AwQ + 2) + 1, obj5, 0, 1);
        Object obj6 = new byte[tVar.Axn];
        System.arraycopy(tVar.Awb, (((tVar.AwQ + 2) + 1) + 1) + 1, obj6, 0, tVar.Axn);
        iVar.a(j4, j5, j, cJO, j2, j3, obj3, obj4, obj5, obj6, lVar.cJP(), oVar.cJP(), qVar.cJP(), pVar.cJP(), bArr6, bArr2, bArr, bArr3, bArr4, bArr5, bArr7, bArr8, bArr9);
        return 0;
    }

    public int w(byte[] bArr, int i, int i2) {
        a fVar = new f();
        a gVar = new g();
        a sVar = new s();
        if (this.Awh == 2064 && this.Awi == 9) {
            Object obj = null;
        } else if (this.Awh == 2064 && this.Awi == 10) {
            r2 = 1;
        } else if (this.Awh == 2064 && this.Awi == 2) {
            r2 = 2;
        } else if (this.Awh != 2064 || this.Awi != 13) {
            return -1012;
        } else {
            r2 = 4;
        }
        if (i2 < 5) {
            return -1009;
        }
        int T = T(bArr, i + 2);
        cJN();
        int i3 = i + 5;
        switch (T) {
            case 0:
                if (obj != 1) {
                    T = sVar.b(bArr, i3, (this.AvW - i3) - 1, this.Awk.Awm);
                } else if (this.Awk.Awn == null) {
                    return -1006;
                } else {
                    T = sVar.b(bArr, i3, (this.AvW - i3) - 1, this.Awk.Awn);
                }
                if (T < 0) {
                    util.acy("119 can not decrypt, ret=" + T);
                    return T;
                }
                T = a(sVar);
                if (T >= 0) {
                    return 0;
                }
                util.acy("parse 119 failed, ret=" + T);
                return T;
            case 1:
                v(bArr, i3, (this.AvW - i3) - 1);
                return T;
            case 2:
                int y = fVar.y(bArr, i3, (this.AvW - i3) - 1);
                if (y >= 0) {
                    this.Awk.Awp = fVar;
                    y = gVar.y(bArr, i3, (this.AvW - i3) - 1);
                    if (y >= 0) {
                        this.Awk.Awq = gVar;
                        return T;
                    }
                }
                return y;
            default:
                v(bArr, i3, (this.AvW - i3) - 1);
                return T;
        }
    }
}
