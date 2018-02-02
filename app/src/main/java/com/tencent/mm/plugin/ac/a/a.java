package com.tencent.mm.plugin.ac.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.util.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public final class a {
    Set<Integer> fEB;
    boolean iu = false;
    a puR = null;
    long puS = 0;

    class b extends AsyncTask<String, Integer, d> {
        final /* synthetic */ a puT;

        b(a aVar) {
            this.puT = aVar;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return x((String[]) objArr);
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            d dVar = (d) obj;
            if (this.puT.puR != null) {
                this.puT.puR.a(dVar);
            }
        }

        private d x(String... strArr) {
            d dVar = null;
            x.d("dktest", "doInBackground :" + strArr);
            if (strArr != null && strArr.length == 1) {
                try {
                    this.puT.puS = System.currentTimeMillis();
                    com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                    dVar = this.puT.HW(strArr[0]);
                    x.d("MicroMsg.scanner.DecodeFile", "time: " + aVar.zi());
                } catch (OutOfMemoryError e) {
                    x.e("MicroMsg.scanner.DecodeFile", "decode failed, OutOfMemoryError");
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.scanner.DecodeFile", e2, "decode failed due to Exception", new Object[]{""});
                }
            }
            return dVar;
        }
    }

    final d HW(String str) {
        OutOfMemoryError e;
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.scanner.DecodeFile", "in decodeFile, file == null");
            return null;
        }
        Options UL = d.UL(str);
        if (UL != null) {
            UL.inJustDecodeBounds = false;
            UL.inPreferredConfig = Config.RGB_565;
        }
        if (this.iu) {
            return null;
        }
        d a;
        try {
            Bitmap decodeFile = d.decodeFile(str, UL);
            if (decodeFile == null) {
                x.e("MicroMsg.scanner.DecodeFile", "decode bitmap is null!");
                return null;
            }
            com.tencent.mm.plugin.scanner.util.d dVar = new com.tencent.mm.plugin.scanner.util.d(null, 0, false);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            a = a(dVar, decodeFile, 3);
            l.pST.boG();
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
            x.d("MicroMsg.scanner.DecodeFile", "decode once time(ms):" + elapsedRealtime);
            if (a == null || bh.ov(a.result)) {
                if (elapsedRealtime == 0) {
                    elapsedRealtime = 1;
                }
                x.i("MicroMsg.scanner.DecodeFile", "max retry time: %s", new Object[]{Integer.valueOf((int) (20000 / elapsedRealtime))});
                for (int i = 1; i < r3 && !this.iu; i++) {
                    int i2 = (i * 8) + 3;
                    if (i2 >= decodeFile.getWidth() || i2 >= decodeFile.getHeight() || System.currentTimeMillis() - this.puS > 5000) {
                        break;
                    }
                    a = a(dVar, decodeFile, i2);
                    l.pST.boG();
                    if (a != null && !bh.ov(a.result)) {
                        x.d("MicroMsg.scanner.DecodeFile", "Decode file done, i = %d, max times = %d, width = %d, height = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(r3), Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight())});
                        break;
                    }
                }
            }
            dVar.kL();
            try {
                String str2 = "MicroMsg.scanner.DecodeFile";
                String str3 = "decode result==null:%b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(a == null);
                x.d(str2, str3, objArr);
                return (a == null || bh.ov(a.result)) ? a : a;
            } catch (OutOfMemoryError e2) {
                e = e2;
                x.e("MicroMsg.scanner.DecodeFile", "OutOfMemoryError, e: %s", new Object[]{e.getMessage()});
                return a;
            }
        } catch (OutOfMemoryError e3) {
            OutOfMemoryError outOfMemoryError = e3;
            a = null;
            e = outOfMemoryError;
            x.e("MicroMsg.scanner.DecodeFile", "OutOfMemoryError, e: %s", new Object[]{e.getMessage()});
            return a;
        }
    }

    private d a(com.tencent.mm.plugin.scanner.util.d dVar, Bitmap bitmap, int i) {
        f.a fVar = new f(bitmap, i, i);
        if (fVar.bpy() == null || fVar.width <= 0 || fVar.height <= 0) {
            return null;
        }
        return dVar.a(fVar, this.fEB);
    }
}
