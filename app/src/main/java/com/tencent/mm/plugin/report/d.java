package com.tencent.mm.plugin.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Map;

public enum d implements c {
    ;
    
    c pPI;

    private static class a implements c {
        private a() {
        }

        public final void a(long j, long j2, long j3, boolean z) {
            x.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void eE(int i) {
            x.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void h(int i, Object... objArr) {
            x.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void k(int i, String str) {
            x.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void a(int i, String str, boolean z, boolean z2) {
            x.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void a(int i, boolean z, boolean z2, Object... objArr) {
            x.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void a(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
            x.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void c(int i, int i2, int i3, int i4, boolean z) {
            x.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void c(String str, String str2, Map<String, Object> map) {
            x.i("MicroMsg.ReportService", "this is DummyReportService");
        }

        public final void a(ArrayList<IDKey> arrayList, boolean z) {
            x.i("MicroMsg.ReportService", "this is DummyReportService");
        }
    }

    private d(String str) {
        this.pPI = new a();
    }

    public final void h(int i, Object... objArr) {
        this.pPI.h(i, objArr);
    }

    public final void k(int i, String str) {
        this.pPI.k(i, str);
    }

    public final void a(int i, String str, boolean z, boolean z2) {
        this.pPI.a(i, str, z, z2);
    }

    public final void a(int i, boolean z, boolean z2, Object... objArr) {
        this.pPI.a(i, z, z2, objArr);
    }

    public final void a(long j, long j2, long j3, boolean z) {
        x.d("MicroMsg.ReportService", "idkeyStat [%d, %d] -> %d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
        this.pPI.a(j, j2, j3, z);
    }

    public final void a(ArrayList<IDKey> arrayList, boolean z) {
        this.pPI.a(arrayList, z);
    }

    public final void a(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        x.d("MicroMsg.ReportService", "idkeyGroupForPair [%d, %d] -> %d / [%d, %d] -> %d", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i6));
        this.pPI.a(i, i2, i3, i4, i5, i6, z);
    }

    public final void c(int i, int i2, int i3, int i4, boolean z) {
        x.d("MicroMsg.ReportService", "idkeyGroupForPairAverger [%d, %d] -> %d / [%d, %d] -> 1", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3));
        this.pPI.c(i, i2, i3, i4, z);
    }

    public final void eE(int i) {
        this.pPI.eE(i);
    }

    public static Object a(int i, int[] iArr, Object[] objArr) {
        int i2 = 0;
        if (iArr.length <= 0 || iArr.length + 1 != objArr.length) {
            return null;
        }
        if (i <= iArr[0]) {
            return objArr[0];
        }
        while (i2 < iArr.length - 1) {
            if (iArr[i2] >= iArr[i2 + 1]) {
                return null;
            }
            if (i > iArr[i2] && i <= iArr[i2 + 1]) {
                return objArr[i2 + 1];
            }
            i2++;
        }
        return objArr[objArr.length - 1];
    }

    public static Object a(int i, int[] iArr, int i2, int i3) {
        int i4 = 0;
        if (iArr == null || iArr.length <= 0 || i3 <= i2 || i3 > 255 || iArr.length != i3 - i2) {
            return null;
        }
        if (i <= iArr[0]) {
            return Integer.valueOf(i2);
        }
        while (i4 < iArr.length - 1) {
            if (iArr[i4] >= iArr[i4 + 1]) {
                return null;
            }
            if (i > iArr[i4] && i <= iArr[i4 + 1]) {
                return Integer.valueOf(i4 + (i2 + 1));
            }
            i4++;
        }
        return Integer.valueOf(i3);
    }

    public final void c(String str, String str2, Map<String, Object> map) {
        this.pPI.c(str, str2, map);
    }
}
