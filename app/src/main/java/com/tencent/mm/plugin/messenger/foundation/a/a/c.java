package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.by.h;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public interface c extends f {

    public interface a {
        void a(c cVar, c cVar2);
    }

    public static class b {
        public long hzX;
        public String name;
        public a[] ooQ;
        public int ooR;

        private static class a {
            public long ooS;
            public long ooT;

            private a() {
            }
        }

        public b(int i, String str, a[] aVarArr) {
            boolean z;
            boolean z2 = true;
            Assert.assertTrue(str.length() > 0);
            this.name = str;
            if (aVarArr.length == 2) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            Assert.assertTrue(aVarArr[0].ooT >= aVarArr[0].ooS);
            Assert.assertTrue(aVarArr[1].ooT >= aVarArr[1].ooS);
            if (aVarArr[1].ooS < aVarArr[0].ooT) {
                z2 = false;
            }
            Assert.assertTrue(z2);
            this.ooQ = aVarArr;
            this.ooR = i;
            this.hzX = aVarArr[0].ooS;
        }

        public final synchronized void aZw() {
            if (this.hzX == this.ooQ[0].ooT) {
                this.hzX = this.ooQ[1].ooS;
                d.pPH.a(111, 251, 1, false);
            } else {
                this.hzX++;
            }
            if (!com.tencent.mm.sdk.a.b.ceM()) {
                x.i("MicroMsg.MsgTable", "incMsgLocalId %d  ", Long.valueOf(this.hzX));
            }
        }

        public final boolean dM(long j) {
            for (a aVar : this.ooQ) {
                boolean z = j >= aVar.ooS && j <= aVar.ooT;
                if (z) {
                    return true;
                }
            }
            return false;
        }

        public static a[] a(long j, long j2, long j3, long j4) {
            a[] aVarArr = new a[2];
            a aVar = new a();
            aVar.ooS = j;
            aVar.ooT = j2;
            aVarArr[0] = aVar;
            aVar = new a();
            aVar.ooS = j3;
            aVar.ooT = j4;
            aVarArr[1] = aVar;
            return aVarArr;
        }
    }

    public static class c {
        public long kGB;
        public String ooU;
        public ArrayList<au> ooV;
        public int ooW;
        public int ooX;
        public int ooY;
        public long ooZ;
        public String talker;

        public c(String str, String str2, au auVar) {
            this(str, str2, auVar, 0);
        }

        public c(String str, String str2, au auVar, int i) {
            long j = -1;
            this.ooV = new ArrayList();
            this.ooX = 0;
            this.ooY = 0;
            this.ooZ = 0;
            this.kGB = -1;
            this.talker = str;
            this.ooU = str2;
            this.ooW = i;
            if (auVar != null) {
                j = auVar.field_bizChatId;
            }
            this.kGB = j;
            if (auVar != null) {
                this.ooV.add(auVar);
            }
        }

        public c(String str, String str2, int i) {
            this(str, str2, null, 0);
            this.ooY = i;
        }

        public static boolean T(au auVar) {
            return auVar != null && auVar.field_isSend == 0 && auVar.field_status == 3;
        }
    }

    Cursor B(String str, String str2, int i);

    void E(String str, long j);

    List<au> EA(String str);

    Cursor EB(String str);

    void EC(String str);

    int ED(String str);

    boolean EE(String str);

    int EF(String str);

    Cursor EG(String str);

    Cursor EH(String str);

    com.tencent.mm.storage.au.c EI(String str);

    au.d EJ(String str);

    com.tencent.mm.storage.au.a EK(String str);

    com.tencent.mm.storage.au.b EL(String str);

    int EM(String str);

    boolean EN(String str);

    int EO(String str);

    int EP(String str);

    String EQ(String str);

    long ER(String str);

    long ES(String str);

    long ET(String str);

    au EU(String str);

    int EV(String str);

    List<au> EW(String str);

    long EX(String str);

    void Et(String str);

    void Eu(String str);

    Cursor Ev(String str);

    au Ew(String str);

    au Ex(String str);

    au Ey(String str);

    au Ez(String str);

    au F(String str, long j);

    au G(String str, long j);

    void G(ArrayList<Long> arrayList);

    au H(String str, long j);

    List<au> I(String str, long j);

    List<au> J(String str, long j);

    List<au> K(String str, int i, int i2);

    boolean K(String str, long j);

    long L(String str, long j);

    Cursor L(String str, int i, int i2);

    int M(String str, long j);

    int N(String str, long j);

    int O(String str, long j);

    int P(au auVar);

    String P(String str, long j);

    long Q(au auVar);

    au Q(String str, long j);

    long R(String str, long j);

    void R(au auVar);

    int S(au auVar);

    long S(String str, long j);

    Cursor a(String str, long j, long j2, boolean z);

    void a(long j, au auVar);

    void a(h hVar, String str);

    void a(a aVar);

    void a(a aVar, Looper looper);

    void a(b bVar);

    void a(c cVar);

    void a(e eVar);

    boolean a(long j, String str, String str2, String str3);

    h aZl();

    void aZm();

    void aZn();

    void aZo();

    ArrayList<au> aZp();

    List<au> aZq();

    Cursor aZr();

    Cursor aZs();

    String aZt();

    String aZu();

    List<au> aZv();

    long b(au auVar, boolean z);

    Cursor b(String str, long j, long j2, int i);

    void b(long j, au auVar);

    void b(String str, String str2, String[] strArr);

    int bA(String str, int i);

    Cursor bB(String str, int i);

    Cursor bC(String str, int i);

    int bD(String str, int i);

    Cursor bE(String str, int i);

    au[] bF(String str, int i);

    Cursor bG(String str, int i);

    List<au> bw(String str, int i);

    List<au> bx(String str, int i);

    Cursor by(String str, int i);

    Cursor bz(String str, int i);

    int c(String str, long j, int i);

    List<au> c(String str, long j, boolean z);

    Cursor d(String str, long j, int i);

    au dH(long j);

    int dI(long j);

    boolean dJ(long j);

    boolean dK(long j);

    void dL(long j);

    au dk(String str, String str2);

    Cursor dl(String str, String str2);

    int dm(String str, String str2);

    LinkedList<au> dn(String str, String str2);

    Cursor e(String str, int i, long j);

    Cursor f(String str, int i, long j);

    Cursor g(String str, int i, long j);

    Cursor k(String str, long j, long j2);

    int l(String str, long j, long j2);

    int m(String str, long j, long j2);

    Cursor n(String str, long j, long j2);

    int o(String str, long j, long j2);

    Cursor p(String str, long j, long j2);

    au su(int i);
}
