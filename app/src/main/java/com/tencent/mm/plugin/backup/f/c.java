package com.tencent.mm.plugin.backup.f;

import android.util.Pair;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.e.j;
import com.tencent.mm.plugin.backup.h.x;
import com.tencent.mm.plugin.backup.h.y;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.protocal.c.es;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;

public final class c extends b {
    private static String TAG = "MicroMsg.BackupDataPushScene";
    private e hnN;
    private PByteArray koH = new PByteArray();
    public x koS = new x();
    private y koT = new y();
    private int koU = 0;
    private a koV = null;

    public static void a(b bVar, c cVar, String str, String str2, byte[] bArr) {
        int i;
        a aVar = new a(str2);
        if (aVar.hlp <= 0) {
            i = 1;
        } else {
            i = (int) (((long) aVar.hlp) / 524288);
            if (((long) aVar.hlp) % 524288 != 0) {
                i++;
            }
        }
        for (int i2 = 0; i2 < i; i2++) {
            cVar.a(new c(bVar, str, aVar, bArr));
        }
    }

    public static void a(b bVar, c cVar, String str, LinkedList<er> linkedList, byte[] bArr) {
        cVar.a(new c(bVar, str, (LinkedList) linkedList, bArr));
    }

    private c(b bVar, String str, a aVar, byte[] bArr) {
        Pair pair;
        boolean z = true;
        this.koS.ktR = str;
        this.koS.ktS = 2;
        this.hnN = new 1(this, bVar);
        this.koV = aVar;
        a.b(aVar, this);
        a aVar2 = this.koV;
        if (aVar2.hlp <= 0) {
            pair = new Pair(Integer.valueOf(0), new byte[0]);
        } else {
            int i = (int) (((long) (aVar2.hlp - aVar2.offset)) > 524288 ? 524288 : (long) (aVar2.hlp - aVar2.offset));
            Object obj = new byte[i];
            if (aVar2.koZ != null) {
                System.arraycopy(aVar2.koZ, aVar2.offset, obj, 0, i);
            } else {
                aVar2.b(obj, ((long) i) < 524288);
            }
            int i2 = aVar2.offset;
            aVar2.offset += i;
            pair = new Pair(Integer.valueOf(i2), obj);
        }
        if (pair.second == null || pair.first == null) {
            com.tencent.mm.sdk.platformtools.x.w(TAG, "BackupDataPushScene media backFileOp getNext error, file path:%s", new Object[]{this.koV.filePath});
            this.koS.ksB = null;
            return;
        }
        byte[] bArr2 = (byte[]) pair.second;
        this.koS.ktT = this.koV.hlp;
        this.koS.ktU = ((Integer) pair.first).intValue();
        this.koS.ktV = this.koS.ktU + bArr2.length;
        x xVar = this.koS;
        if (this.koS.ktV != this.koS.ktT) {
            z = false;
        }
        xVar.ksB = a(bArr2, z, bArr);
        apW();
    }

    private c(final b bVar, String str, LinkedList<er> linkedList, byte[] bArr) {
        byte[] toByteArray;
        this.koS.ktR = str;
        this.koS.ktS = 1;
        this.hnN = new e(this) {
            final /* synthetic */ c koX;

            public final void a(int i, int i2, String str, k kVar) {
                c cVar = (c) kVar;
                bVar.c(true, cVar.koS.ktR, cVar.apX());
            }
        };
        try {
            es esVar = new es();
            esVar.ksP = linkedList;
            esVar.ksO = linkedList.size();
            toByteArray = esVar.toByteArray();
        } catch (Exception e) {
            Exception exception = e;
            String str2 = TAG;
            String str3 = "BackupDataPushScene text, BakChatMsgList to buf error, list size[%d], errMsg:%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
            objArr[1] = exception.getMessage();
            com.tencent.mm.sdk.platformtools.x.e(str2, str3, objArr);
            toByteArray = null;
        }
        if (toByteArray == null) {
            toByteArray = new byte[0];
        }
        this.koS.ktU = 0;
        this.koS.ktV = toByteArray.length;
        this.koS.ktT = toByteArray.length;
        this.koS.ksB = a(toByteArray, true, bArr);
        apW();
    }

    public final void mL(int i) {
        this.hnN.a(0, this.koT.ktm, "", this);
    }

    private void apW() {
        this.koU = apS();
        try {
            j.a(this.koS.toByteArray(), this.koU, (short) 6, this.koH, b.kiF);
            int i = this.koU;
            PByteArray pByteArray = this.koH;
            this.koH = new PByteArray();
            this.koH.value = pByteArray.value;
            synchronized (b.koI) {
                b.koI.put(Integer.valueOf(i), this);
            }
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(TAG, e, "PacketBackupDataPush to buf fail:%s", new Object[]{e.toString()});
        }
    }

    public final boolean apQ() {
        byte[] bArr = this.koH.value;
        int i = this.koU;
        if (b.koK != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BackupBaseScene", "doSceneSameThread ret[%d], sendSeq[%d], type[%d], buflen[%d]", new Object[]{Integer.valueOf(b.koK.j(i, bArr)), Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(bArr.length)});
        }
        return true;
    }

    private static b a(byte[] bArr, boolean z, byte[] bArr2) {
        if (bh.bx(bArr2) <= 0 || bh.bx(bArr) <= 0) {
            return new b(bArr);
        }
        return new b(AesEcb.aesCryptEcb(bArr, bArr2, true, z));
    }

    public final int apX() {
        if (this.koH.value == null) {
            return 0;
        }
        return this.koH.value.length;
    }

    public final a apH() {
        return this.koT;
    }

    public final a apI() {
        return this.koS;
    }

    public final int getType() {
        return 6;
    }
}
