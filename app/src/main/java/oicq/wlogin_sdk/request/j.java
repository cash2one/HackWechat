package oicq.wlogin_sdk.request;

import com.tencent.wcdb.FileUtils;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.aa;
import oicq.wlogin_sdk.a.ae;
import oicq.wlogin_sdk.a.ag;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.aj;
import oicq.wlogin_sdk.a.an;
import oicq.wlogin_sdk.a.b;
import oicq.wlogin_sdk.a.c;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.i;
import oicq.wlogin_sdk.a.k;
import oicq.wlogin_sdk.a.r;
import oicq.wlogin_sdk.a.y;
import oicq.wlogin_sdk.tools.util;

public final class j extends d {
    public j(i iVar) {
        this.Awh = 2064;
        this.Awi = 9;
        this.Awk = iVar;
    }

    public final byte[] a(long j, long j2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, byte[] bArr4) {
        Object bX;
        int i4 = this.Awk.Awu;
        this.Awk._uin = j2;
        util.gj("IMEI", util.cf(this.Awk.Awv));
        byte[] bArr5 = this.Awk.Awm;
        byte[] bArr6 = this.Awk.Awv;
        byte[] cJP = this.Awk.Awp.cJP();
        byte[] bArr7 = this.Awk.Awz;
        an anVar = new an();
        b bVar = new b();
        a hVar = new h();
        r rVar = new r();
        c cVar = new c();
        i iVar = new i();
        oicq.wlogin_sdk.a.j jVar = new oicq.wlogin_sdk.a.j();
        k kVar = new k();
        f fVar = new f();
        y yVar = new y();
        aa aaVar = new aa();
        ae aeVar = new ae();
        ag agVar = new ag();
        ah ahVar = new ah();
        aj ajVar = new aj();
        Object a = anVar.a(522017402, i4, j2, 0);
        Object g = bVar.g(j2, bArr);
        Object a2 = hVar.a(522017402, i4, j2, bArr2, bArr, bArr3, bArr5, this.Awk.AwH, this.Awk.Awv);
        this.Awk.AwL = super.bU(hVar.cJP());
        Object a3 = cVar.a(522017402, 1, i4, 8256);
        Object z = iVar.z(0, 1, 102400, 1);
        Object a4 = rVar.a(i, i2, null);
        Object cb = ahVar.cb(this.Awk.Awv);
        int i5 = 7;
        Object obj = new byte[0];
        byte[] bArr8 = new byte[0];
        Object obj2 = new byte[0];
        Object obj3 = new byte[0];
        if (bArr4.length > 0) {
            obj = jVar.bY(bArr4);
            i5 = 8;
        }
        if (bArr6.length > 0) {
            bArr8 = kVar.bZ(bArr6);
        }
        Object a5 = agVar.a(bArr8, yVar.a(util.cJU(), util.cJV(), this.Awk.Awy, this.Awk.Awx, new byte[0], this.Awk.AwA), aaVar.a(this.Awk.AwG, this.Awk.AwH, this.Awk.AwI, this.Awk.AwE, this.Awk.Awv), ajVar.a(522017402, this.Awk.AwC, this.Awk.AwD), this.Awk.Awm);
        i5++;
        Object ca = aeVar.ca(bArr7);
        int i6 = i5 + 1;
        if (cJP.length > 0) {
            bX = fVar.bX(cJP);
            i6++;
        } else {
            bX = obj2;
        }
        Object obj4 = new byte[(((((((((((a.length + g.length) + a2.length) + a4.length) + a3.length) + z.length) + obj.length) + a5.length) + bX.length) + ca.length) + 0) + cb.length)];
        System.arraycopy(a, 0, obj4, 0, a.length);
        int length = a.length + 0;
        System.arraycopy(g, 0, obj4, length, g.length);
        length += g.length;
        System.arraycopy(a2, 0, obj4, length, a2.length);
        length += a2.length;
        System.arraycopy(a4, 0, obj4, length, a4.length);
        length += a4.length;
        System.arraycopy(a3, 0, obj4, length, a3.length);
        length += a3.length;
        System.arraycopy(z, 0, obj4, length, z.length);
        length += z.length;
        System.arraycopy(obj, 0, obj4, length, obj.length);
        int length2 = obj.length + length;
        System.arraycopy(a5, 0, obj4, length2, a5.length);
        length2 += a5.length;
        System.arraycopy(ca, 0, obj4, length2, ca.length);
        length2 += ca.length;
        System.arraycopy(obj3, 0, obj4, length2, 0);
        length2 += 0;
        System.arraycopy(bX, 0, obj4, length2, bX.length);
        System.arraycopy(cb, 0, obj4, bX.length + length2, cb.length);
        long j3 = j2;
        int i7 = i4;
        a(this.Awc, this.Awh, Awd, j3, this.Awe, this.Awf, i7, this.Awg, super.u(obj4, this.Awi, i6));
        return super.cJM();
    }

    public final byte[] a(long j, long j2, byte[] bArr, byte[] bArr2, int i, int i2, int i3, byte[] bArr3) {
        int i4 = this.Awk.Awu;
        this.Awk._uin = j2;
        Object bV = super.bV(bArr2);
        if (bV == null) {
            return null;
        }
        Object obj;
        byte[] bArr4 = this.Awk.Awv;
        byte[] cJP = this.Awk.Awp.cJP();
        byte[] bArr5 = this.Awk.Awz;
        an anVar = new an();
        b bVar = new b();
        a hVar = new h();
        r rVar = new r();
        c cVar = new c();
        i iVar = new i();
        oicq.wlogin_sdk.a.j jVar = new oicq.wlogin_sdk.a.j();
        k kVar = new k();
        f fVar = new f();
        y yVar = new y();
        aa aaVar = new aa();
        ae aeVar = new ae();
        ag agVar = new ag();
        ah ahVar = new ah();
        aj ajVar = new aj();
        Object a = anVar.a(522017402, i4, j2, 0);
        Object g = bVar.g(j2, bArr);
        this.Awk.AwL = super.bU(bV);
        int length = bV.length;
        if (hVar.AwQ + length > hVar.AvV) {
            hVar.AvV = (hVar.AwQ + length) + FileUtils.S_IWUSR;
            obj = new byte[hVar.AvV];
            System.arraycopy(hVar.Awb, 0, obj, 0, hVar.AwQ);
            hVar.Awb = obj;
        }
        hVar.AvW = hVar.AwQ + length;
        System.arraycopy(bV, 0, hVar.Awb, hVar.AwQ, length);
        hVar.AwR = length;
        util.A(hVar.Awb, 0, hVar.Awh);
        util.A(hVar.Awb, 2, hVar.AwR);
        Object cJM = hVar.cJM();
        util.gj("req2 a1:", util.cf(cJM));
        Object a2 = cVar.a(522017402, 1, i4, 8256);
        Object z = iVar.z(0, 1, 102400, 1);
        Object a3 = rVar.a(i, i2, null);
        Object cb = ahVar.cb(this.Awk.Awv);
        int i5 = 7;
        Object obj2 = new byte[0];
        byte[] bArr6 = new byte[0];
        Object obj3 = new byte[0];
        Object obj4 = new byte[0];
        if (bArr3.length > 0) {
            obj2 = jVar.bY(bArr3);
            i5 = 8;
        }
        if (bArr4.length > 0) {
            bArr6 = kVar.bZ(bArr4);
        }
        Object a4 = agVar.a(bArr6, yVar.a(util.cJU(), util.cJV(), this.Awk.Awy, this.Awk.Awx, new byte[0], this.Awk.AwA), aaVar.a(this.Awk.AwG, this.Awk.AwH, this.Awk.AwI, this.Awk.AwE, this.Awk.Awv), ajVar.a(522017402, this.Awk.AwC, this.Awk.AwD), this.Awk.Awm);
        i5++;
        Object ca = aeVar.ca(bArr5);
        int i6 = i5 + 1;
        if (cJP.length > 0) {
            obj = fVar.bX(cJP);
            i6++;
        } else {
            obj = obj3;
        }
        Object obj5 = new byte[(((((((((((a.length + g.length) + cJM.length) + a3.length) + a2.length) + z.length) + obj2.length) + a4.length) + obj.length) + ca.length) + 0) + cb.length)];
        System.arraycopy(a, 0, obj5, 0, a.length);
        int length2 = a.length + 0;
        System.arraycopy(g, 0, obj5, length2, g.length);
        length2 += g.length;
        System.arraycopy(cJM, 0, obj5, length2, cJM.length);
        length2 += cJM.length;
        System.arraycopy(a3, 0, obj5, length2, a3.length);
        length2 += a3.length;
        System.arraycopy(a2, 0, obj5, length2, a2.length);
        length2 += a2.length;
        System.arraycopy(z, 0, obj5, length2, z.length);
        length2 += z.length;
        System.arraycopy(obj2, 0, obj5, length2, obj2.length);
        length = obj2.length + length2;
        System.arraycopy(a4, 0, obj5, length, a4.length);
        length += a4.length;
        System.arraycopy(ca, 0, obj5, length, ca.length);
        length += ca.length;
        System.arraycopy(obj4, 0, obj5, length, 0);
        length += 0;
        System.arraycopy(obj, 0, obj5, length, obj.length);
        System.arraycopy(cb, 0, obj5, length + obj.length, cb.length);
        long j3 = j2;
        int i7 = i4;
        a(this.Awc, this.Awh, Awd, j3, this.Awe, this.Awf, i7, this.Awg, super.u(obj5, this.Awi, i6));
        return super.cJM();
    }
}
