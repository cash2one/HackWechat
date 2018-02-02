package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class j {
    private static Vector<WeakReference<a>> hla = new Vector();
    private static LinkedList<a> ich = new LinkedList();

    public interface a {
        void l(String str, Bitmap bitmap);
    }

    private enum b {
        ;
        
        private static DisplayMetrics icn;
        private Map<String, c> icj;
        private Map<String, WeakReference<Bitmap>> ick;
        private as icl;
        private as icm;

        static class c {
            boolean icr;
            int ics;
            int ict;

            c() {
            }

            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("fail[").append(this.icr).append("],");
                stringBuilder.append("tryTimes[").append(this.ics).append("],");
                stringBuilder.append("lastTS[").append(this.ict).append("]");
                return stringBuilder.toString();
            }
        }

        private b(String str) {
            this.icj = new HashMap();
            this.ick = new HashMap();
            this.icl = null;
            this.icm = null;
        }

        static {
            icn = null;
        }

        private Bitmap d(i iVar) {
            Assert.assertTrue("picture strategy here must be validity", j.b(iVar));
            String Wg = iVar.Wg();
            c cVar = (c) this.icj.get(Wg);
            if (cVar == null) {
                cVar = new c();
            }
            if (cVar.icr) {
                if (cVar.ics < 3) {
                    cVar.ics++;
                } else if (bh.by((long) cVar.ict) < 120) {
                    x.w("MicroMsg.MMPictureLogic", "download fail interval less than %d s for %s", Integer.valueOf(120), Wg);
                    return null;
                } else {
                    cVar.ics = 0;
                }
                cVar.icr = false;
                cVar.ict = (int) bh.Wo();
                this.icj.put(Wg, cVar);
            } else if (bh.by((long) cVar.ict) < 120) {
                x.d("MicroMsg.MMPictureLogic", "downloading interval less than %d s for %s", Integer.valueOf(120), Wg);
                return null;
            } else {
                cVar.ics++;
                cVar.ict = (int) bh.Wo();
                this.icj.put(Wg, cVar);
            }
            if (iVar.Wj()) {
                Bitmap oo;
                com.tencent.mm.platformtools.i.b We = iVar.We();
                if (We != null) {
                    oo = We.oo(iVar.Wf());
                } else {
                    oo = op(iVar.Wf());
                }
                if (oo != null) {
                    oo = a(iVar, oo);
                    this.icj.remove(Wg);
                    return oo;
                }
                if (this.icl == null || this.icl.cfT()) {
                    this.icl = new as(1, "readerapp-pic-logic-download", 3);
                }
                this.icl.c(new a(iVar));
                return null;
            }
            if (this.icm == null || this.icm.cfT()) {
                this.icm = new as(1, "readerapp-pic-logic-reader", 1);
            }
            this.icm.c(new b(iVar));
            return null;
        }

        protected final Bitmap a(i iVar, Bitmap bitmap) {
            Assert.assertTrue("picture strategy here must be validity", j.b(iVar));
            if (bitmap != null) {
                Bitmap a = iVar.a(bitmap, com.tencent.mm.platformtools.i.a.DISK, iVar.Wf());
                if (!(a == bitmap || bitmap.isRecycled())) {
                    x.i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
                b(iVar, a);
                return a;
            }
            iVar.a(com.tencent.mm.platformtools.i.a.DISK, null);
            return bitmap;
        }

        private void b(i iVar, Bitmap bitmap) {
            Assert.assertTrue("picture strategy here must be validity", j.b(iVar));
            String Wi = iVar.Wi();
            Bitmap bitmap2 = this.ick.containsKey(Wi) ? (Bitmap) ((WeakReference) this.ick.get(Wi)).get() : null;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                this.ick.remove(Wi);
                this.ick.put(Wi, new WeakReference(bitmap));
            }
        }

        public static Bitmap m(String str, int i, int i2) {
            Bitmap bitmap = null;
            if (bh.ov(str)) {
                x.w("MicroMsg.MMPictureLogic", "error input, path is null");
            } else if (i <= 0 || i2 <= 0) {
                x.w("MicroMsg.MMPictureLogic", "error input, targetWidth %d, targetHeight %d", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                bitmap = d.a(str, i, i2, decodeResultLogger, 0, new int[0]);
                if (bitmap == null && decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    g.pQN.k(12712, KVStatHelper.getKVStatString(str, 8, decodeResultLogger));
                }
            }
            return bitmap;
        }

        public static Bitmap op(String str) {
            if (icn == null) {
                icn = ac.getContext().getResources().getDisplayMetrics();
            }
            DisplayMetrics displayMetrics = icn;
            return m(str, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }

        public static Bitmap oq(String str) {
            if (bh.ov(str)) {
                x.w("MicroMsg.MMPictureLogic", "error input, path is null");
                return null;
            }
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            Bitmap a = d.a(str, 0, 0, decodeResultLogger, 0, new int[0]);
            if (a != null || decodeResultLogger.getDecodeResult() < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                return a;
            }
            g.pQN.k(12712, KVStatHelper.getKVStatString(str, 8, decodeResultLogger));
            return a;
        }
    }

    static /* synthetic */ void k(String str, Bitmap bitmap) {
        Collection vector = new Vector();
        for (int i = 0; i < hla.size(); i++) {
            WeakReference weakReference = (WeakReference) hla.get(i);
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.l(str, bitmap);
                } else {
                    vector.add(weakReference);
                }
            }
        }
        hla.removeAll(vector);
    }

    public static boolean a(a aVar) {
        return hla.add(new WeakReference(aVar));
    }

    public static boolean b(a aVar) {
        ich.remove(aVar);
        return ich.add(aVar);
    }

    public static boolean c(a aVar) {
        return ich.remove(aVar);
    }

    public static Bitmap a(i iVar) {
        if (!b(iVar)) {
            return null;
        }
        if (!com.tencent.mm.kernel.g.Dj().CX()) {
            return iVar.Wl();
        }
        if (iVar.Wk()) {
            return b.a(b.ici, iVar);
        }
        return b.b(b.ici, iVar);
    }

    public static Bitmap op(String str) {
        return b.op(str);
    }

    public static Bitmap m(String str, int i, int i2) {
        return b.m(str, i, i2);
    }

    public static Bitmap oq(String str) {
        return b.oq(str);
    }

    private static boolean b(i iVar) {
        if (iVar == null || bh.ov(iVar.Wg())) {
            return false;
        }
        return true;
    }
}
