package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.aq.d.a;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.f;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.k.g;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.chatting.ag;
import com.tencent.mm.z.ar;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class d extends a implements a, e$a {
    private static long yEo = ((long) (((double) Runtime.getRuntime().maxMemory()) * 0.05d));
    private HashMap<String, WeakReference<Bitmap>> txa = new HashMap();
    private c yEj;
    public HashMap<Long, Integer> yEk = new HashMap();
    public final e yEl = new e(this);
    private HashMap<au, String> yEm = new HashMap();
    private HashMap<au, String> yEn = new HashMap();
    private long yEp = 0;
    int yi = 0;

    public d(b bVar) {
        super(bVar);
        com.tencent.mm.sdk.b.a aVar = com.tencent.mm.sdk.b.a.xef;
        c agVar = new ag(ag.a.yxy, bVar.yCS);
        this.yEj = agVar;
        aVar.b(agVar);
        this.yEl.ax(a.yEE.mTE.snapshot());
        k.cvm().yGG = this;
    }

    public final void detach() {
        super.detach();
        com.tencent.mm.sdk.b.a.xef.c(this.yEj);
        if (this.txa != null) {
            for (Object obj : this.txa.keySet()) {
                Bitmap bitmap = (Bitmap) ((WeakReference) this.txa.get(obj)).get();
                if (!(bitmap == null || bitmap.isRecycled())) {
                    x.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[]{bitmap.toString()});
                    bitmap.recycle();
                }
            }
        }
        e eVar = this.yEl;
        eVar.yEv = null;
        eVar.mTA.clear();
        eVar.mTD.clear();
        eVar.mTC.clear();
        eVar.mTB.clear();
        eVar.aOt();
        o.Px().a(this);
        k cvm = k.cvm();
        if (equals(cvm.yGG)) {
            cvm.yGG = null;
        }
    }

    public final int bk(au auVar) {
        if (auVar == null || !this.yEk.containsKey(Long.valueOf(auVar.field_msgId))) {
            return 0;
        }
        return ((Integer) this.yEk.get(Long.valueOf(auVar.field_msgId))).intValue();
    }

    private void f(au auVar, int i) {
        this.yEk.put(Long.valueOf(auVar.field_msgId), Integer.valueOf(i));
    }

    private void y(long j, int i) {
        this.yEk.put(Long.valueOf(j), Integer.valueOf(i));
    }

    public final boolean a(j jVar, au auVar, int i) {
        super.a(jVar, auVar, i);
        if (jVar == null || auVar == null || i < 0) {
            return false;
        }
        int bk = bk(auVar);
        x.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s", new Object[]{Integer.valueOf(jVar.yGx.hashCode()), Integer.valueOf(i)});
        j.N(jVar.yGo, 8);
        e f = f(auVar, false);
        if (f == null) {
            return false;
        }
        switch (bk) {
            case 0:
                boolean cjs;
                x.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloadOrSucc");
                x.i("MicroMsg.ImageGalleryHolderImage", "deal LoadFail");
                if (auVar.field_isSend == 1) {
                    cjs = auVar.cjs();
                } else if (auVar.cjs()) {
                    cjs = true;
                } else {
                    String c = c(auVar, f);
                    if (!f.Pd() || (c != null && com.tencent.mm.a.e.bO(c))) {
                        Object obj = (System.currentTimeMillis() - auVar.field_createTime <= 259200000 || (!bh.ov(c) && com.tencent.mm.a.e.bO(c))) ? null : 1;
                        cjs = obj != null;
                    } else {
                        cjs = true;
                    }
                }
                if (!cjs) {
                    if (!a(jVar, auVar, f, i)) {
                        f(auVar, 2);
                    } else if (f.Pd()) {
                        f(auVar, 4);
                        break;
                    } else {
                        f(auVar, 1);
                    }
                    aj.t(auVar);
                    x.i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", new Object[]{Integer.valueOf(o.Px().a(f.hzP, auVar.field_msgId, 0, Integer.valueOf(i), R.g.bAH, this, 0))});
                    if (o.Px().a(f.hzP, auVar.field_msgId, 0, Integer.valueOf(i), R.g.bAH, this, 0) != -2) {
                        a(jVar, auVar, f, false, i);
                        break;
                    }
                    x.w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
                    e f2 = f(auVar, true);
                    if (f2 != null) {
                        if (!a(jVar, auVar, f2, i)) {
                            f(auVar, 2);
                        } else if (auVar.field_isSend == 1 || f2.Pd()) {
                            f(auVar, 4);
                            break;
                        } else {
                            f(auVar, 1);
                        }
                        x.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", new Object[]{Long.valueOf(f2.hzP), Boolean.valueOf(f2.Pd())});
                        a(jVar, auVar, f2, false, i);
                        break;
                    }
                    x.w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
                    break;
                }
                f(auVar, 5);
                a(auVar, jVar, 5);
                break;
                break;
            case 1:
            case 4:
                a(jVar, auVar, f, i);
                break;
            case 2:
                a(jVar, auVar, f, false, i);
                break;
            case 3:
                a(jVar, auVar, f, true, i);
                break;
            case 5:
            case 6:
                a(auVar, jVar, bk);
                jVar.mUL.invalidate();
                break;
        }
        return true;
    }

    public static e bl(au auVar) {
        if (!b.aW(auVar)) {
            return null;
        }
        if (auVar.field_isSend == 1) {
            e bi = o.Pw().bi(auVar.field_msgId);
            if (bi.hzP != 0) {
                return bi;
            }
        }
        return o.Pw().bh(auVar.field_msgSvrId);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final e f(au auVar, boolean z) {
        e eVar = null;
        if (b.aW(auVar)) {
            if (this.yCR == null || this.yCR.yCT == null) {
                x.e("MicroMsg.ImageGalleryHolderImage", "adapter is null!!");
            } else {
                if (!z) {
                    if (auVar.field_isSend == 1) {
                        eVar = (e) this.yCR.yCT.yDq.get(Long.valueOf(auVar.field_msgId));
                    }
                    if (eVar == null && auVar.field_msgSvrId > 0) {
                        eVar = (e) this.yCR.yCT.yDp.get(Long.valueOf(auVar.field_msgSvrId));
                    }
                }
                if (eVar == null) {
                    long j;
                    Object obj = null;
                    if (auVar.field_isSend == 1) {
                        j = auVar.field_msgId;
                        eVar = o.Pw().bi(j);
                    }
                    j = auVar.field_msgSvrId;
                    eVar = o.Pw().bh(j);
                    obj = 1;
                    b.a aVar = this.yCR.yCT;
                    if (obj != null) {
                        aVar.yDp.put(Long.valueOf(j), eVar);
                    } else {
                        aVar.yDq.put(Long.valueOf(j), eVar);
                    }
                }
            }
        }
        return eVar;
    }

    private String c(au auVar, e eVar) {
        String str = (String) this.yEm.get(auVar);
        if (str != null) {
            return str;
        }
        str = a(auVar, eVar, false);
        if (str == null || str.length() == 0) {
            return null;
        }
        this.yEm.put(auVar, str);
        return str;
    }

    private boolean a(j jVar, au auVar, e eVar, int i) {
        x.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
        String c = c(auVar, eVar);
        j.N(jVar.yGt, 8);
        String str = (String) this.yEn.get(auVar);
        if (str == null) {
            str = o.Pw().B(auVar.field_imgPath, true);
            this.yEn.put(auVar, str);
        }
        boolean a = a(jVar, str, c, auVar);
        if (i == this.yCR.yCS.cuT() && this.yCR.yCW) {
            this.yCR.bf(auVar);
            this.yCR.yCW = false;
        }
        return a;
    }

    private void a(j jVar, au auVar, e eVar, boolean z, int i) {
        a(jVar, auVar, eVar, z, true, i);
    }

    private void a(j jVar, au auVar, e eVar, boolean z, boolean z2, int i) {
        x.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = " + z);
        j.N(jVar.yGu, 8);
        String str = null;
        if (!z) {
            jVar.yGx.setVisibility(0);
        }
        e a = f.a(eVar);
        if (z && i == this.yCR.yCS.cuT()) {
            ImageGalleryUI imageGalleryUI = this.yCR.yCS;
            imageGalleryUI.ft(true);
            imageGalleryUI.cuS();
            imageGalleryUI.cuH().yEU.setVisibility(0);
            imageGalleryUI.cuH().yEV.setVisibility(8);
            imageGalleryUI.cuH().yEW.setVisibility(0);
            imageGalleryUI.cuH().yEX.setVisibility(8);
            imageGalleryUI.cuV();
            imageGalleryUI.cuW();
            imageGalleryUI.cuH().yEW.setText("0%");
        }
        if (z) {
            str = a(auVar, eVar, true);
        }
        if (bh.ov(str)) {
            str = o.Pw().m(a.hzS, "", "");
        }
        String B = o.Pw().B(auVar.field_imgPath, true);
        if (z2) {
            a(jVar, B, str, auVar);
        }
        if (!z) {
            int i2 = eVar.hlp;
            if (Math.max(1, (int) (i2 != 0 ? ((((long) eVar.offset) * 100) / ((long) i2)) - 1 : 0)) > 50) {
                jVar.cvi().yGt.setVisibility(8);
            } else {
                jVar.cvi().yGt.setVisibility(0);
            }
        }
        jVar.cvi().yGr.setVisibility(8);
        jVar.cvi().yGq.setVisibility(8);
        jVar.cvi().yGp.setVisibility(8);
    }

    private static void a(au auVar, j jVar, int i) {
        x.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
        String B = o.Pw().B(auVar.field_imgPath, true);
        j.N(jVar.yGt, 8);
        j.N(jVar.yGo, 8);
        j.N(jVar.yGx, 8);
        jVar.cvj().yGu.setVisibility(0);
        jVar.cvj().yGw.setImageResource(R.k.dyO);
        if (B == null || !com.tencent.mm.a.e.bO(B)) {
            jVar.cvj().yGv.setText(R.l.epq);
        } else if (i == 6) {
            jVar.cvj().yGv.setText(R.l.epo);
        } else if (auVar.cjs()) {
            jVar.cvj().yGv.setText(R.l.epm);
        } else {
            jVar.cvj().yGv.setText(R.l.epn);
        }
    }

    private boolean a(j jVar, String str, String str2, au auVar) {
        j.N(jVar.yGx, 0);
        j.N(jVar.yGo, 8);
        j.N(jVar.yGt, 8);
        j.N(jVar.yGu, 8);
        return a(true, jVar.yGx, str, str2, false, jVar.mPosition);
    }

    private boolean a(boolean z, MultiTouchImageView multiTouchImageView, String str, String str2, boolean z2, int i) {
        boolean z3;
        String str3;
        x.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", new Object[]{Integer.valueOf(multiTouchImageView.hashCode()), str2, Integer.valueOf(i)});
        if (str2 == null || !com.tencent.mm.a.e.bO(str2)) {
            z3 = false;
            Object obj = null;
        } else {
            z3 = true;
            str3 = str2;
        }
        String str4 = (str3 == null && str != null && com.tencent.mm.a.e.bO(str)) ? com.tencent.mm.a.e.bO(new StringBuilder().append(str).append("hd").toString()) ? str + "hd" : str : str3;
        if (str4 == null) {
            x.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, file does not exist, filePath %s", new Object[]{str2});
            return false;
        }
        Bitmap bitmap;
        if (!z2 && this.yEl.mTE.bt(str4)) {
            bitmap = (Bitmap) this.yEl.mTE.get(str4);
            if (!bitmap.isRecycled()) {
                x.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", new Object[]{str4});
                b(multiTouchImageView, bitmap);
                return true;
            }
        }
        if (z) {
            multiTouchImageView.setImageBitmap(null);
        }
        if (this.yCR.yDc) {
            bitmap = Zo(str4);
            if (bitmap == null) {
                bitmap = Zo(str);
            }
            if (bitmap != null) {
                c((ImageView) multiTouchImageView, bitmap);
                if (str4.equals(str2)) {
                    this.yEl.u(str4, bitmap);
                }
                return z3;
            }
        } else if (i >= 0) {
            this.yEl.b(multiTouchImageView, i);
        }
        e eVar = this.yEl;
        if (!eVar.tj.contains(str4)) {
            int hashCode = multiTouchImageView.hashCode();
            eVar.qz(hashCode);
            eVar.mTB.put(str4, Integer.valueOf(hashCode));
            eVar.mTC.put(hashCode, str4);
            eVar.mTA.put(hashCode, new WeakReference(multiTouchImageView));
            eVar.tj.add(str4);
            eVar.aOv();
        }
        return z3;
    }

    public final void c(ImageView imageView, Bitmap bitmap) {
        if (bitmap != null && imageView != null) {
            int hashCode = imageView.hashCode();
            int hashCode2 = bitmap.hashCode();
            int indexOfValue = this.yEl.mTF.indexOfValue(hashCode);
            if (indexOfValue >= 0) {
                this.yEl.mTF.removeAt(indexOfValue);
            }
            this.yEl.mTF.put(hashCode2, hashCode);
            if (imageView instanceof MultiTouchImageView) {
                b((MultiTouchImageView) imageView, bitmap);
            } else {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public final Bitmap Zn(String str) {
        return Zo(str);
    }

    private static Bitmap ae(String str, int i, int i2) {
        Throwable th;
        Throwable th2;
        Bitmap bitmap = null;
        String str2 = str + "_tmp.jpg";
        Bitmap bitmap2;
        try {
            if (com.tencent.mm.compatible.util.d.fN(16)) {
                return null;
            }
            if (!b.ceK()) {
                int i3 = bh.getInt(g.zY().getValue("UseOptImageRecv"), 0);
                ar.Hg();
                x.i("MicroMsg.ImageGalleryHolderImage", "fromPathToImgInfo opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[]{Integer.valueOf(i3), Long.valueOf(r2.longValue()), Long.valueOf(new com.tencent.mm.a.o(com.tencent.mm.z.c.Cg()).longValue() / 100), Boolean.valueOf(b.ceK()), Integer.valueOf(VERSION.SDK_INT)});
                if ((((int) (new com.tencent.mm.a.o(com.tencent.mm.z.c.Cg()).longValue() / 100)) % 100) + 1 > i3) {
                    return null;
                }
            }
            k.q(str, str2, false);
            boolean IsJpegFile = MMNativeJpeg.IsJpegFile(str2);
            boolean isProgressive = MMNativeJpeg.isProgressive(str2);
            boolean checkIntegrity = (bh.ov(str2) || !new File(str2).exists()) ? false : MMJpegOptim.checkIntegrity(str2);
            int bN = com.tencent.mm.a.e.bN(str2);
            if (IsJpegFile && isProgressive) {
                if (checkIntegrity) {
                    bitmap = MMNativeJpeg.decodeAsBitmap(str2);
                }
                try {
                    a.k(str, i2, i, bitmap != null ? bN : 0 - bN);
                    bitmap2 = bitmap;
                } catch (Throwable th3) {
                    th = th3;
                    bitmap2 = bitmap;
                    th2 = th;
                    x.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", new Object[]{str, bh.i(th2)});
                    com.tencent.mm.loader.stub.b.deleteFile(str2);
                    return bitmap2;
                }
            }
            bitmap2 = null;
            try {
                x.i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", new Object[]{Boolean.valueOf(IsJpegFile), Boolean.valueOf(isProgressive), Boolean.valueOf(checkIntegrity), Integer.valueOf(bN), Integer.valueOf(i2), Integer.valueOf(i), bitmap2, str});
            } catch (Throwable th4) {
                th2 = th4;
                x.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", new Object[]{str, bh.i(th2)});
                com.tencent.mm.loader.stub.b.deleteFile(str2);
                return bitmap2;
            }
            com.tencent.mm.loader.stub.b.deleteFile(str2);
            return bitmap2;
        } catch (Throwable th32) {
            x.e("MicroMsg.ImageGalleryHolderImage", "get useopt :%s", new Object[]{bh.i(th32)});
            return null;
        } catch (Throwable th322) {
            th = th322;
            bitmap2 = null;
            th2 = th;
            x.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", new Object[]{str, bh.i(th2)});
            com.tencent.mm.loader.stub.b.deleteFile(str2);
            return bitmap2;
        }
    }

    private static Bitmap Zo(String str) {
        if (str == null) {
            return null;
        }
        Bitmap ae;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            x.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[]{decodeFile.toString()});
            decodeFile.recycle();
        }
        int UJ = ExifHelper.UJ(str);
        int i = options.outWidth;
        int i2 = options.outHeight;
        try {
            long max = Math.max((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()) - yEo, 0);
            long j = (long) ((options.outWidth * options.outHeight) * 4);
            x.i("MicroMsg.ImageGalleryHolderImage", "hy: current free memory: %d, previewDecodedBmLength: %d", new Object[]{Long.valueOf(max), Long.valueOf(j)});
            if (max < j) {
                double sqrt = Math.sqrt(((double) max) / ((double) j));
                x.v("MicroMsg.ImageGalleryHolderImage", "hy: sample is %f", new Object[]{Double.valueOf(sqrt)});
                i = (int) (((double) i) * sqrt);
                i2 = (int) (((double) i2) * sqrt);
            }
            ae = ae(str, i2, i);
            if (ae == null) {
                ae = com.tencent.mm.sdk.platformtools.d.a(str, i, i2, 0.0f, null, 0, new int[0]);
            }
            if (ae == null && MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                ae = MMNativeJpeg.decodeAsBitmap(str);
                String str2 = "MicroMsg.ImageGalleryHolderImage";
                String str3 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(ae == null);
                x.i(str2, str3, objArr);
            }
            decodeFile = ae;
        } catch (Throwable e) {
            int i3 = i;
            x.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", e, "hy: out of memory! try use fallback bitmap", new Object[0]);
            Context context = ac.getContext();
            int i4 = context == null ? 0 : context.getResources().getDisplayMetrics().widthPixels;
            Context context2 = ac.getContext();
            decodeFile = c(str, i3, i2, i4, context2 == null ? 0 : context2.getResources().getDisplayMetrics().heightPixels);
        }
        if (decodeFile == null) {
            x.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, temBmp is null, filePath = " + str);
            return null;
        }
        ae = com.tencent.mm.sdk.platformtools.d.b(decodeFile, (float) UJ);
        if (ae != decodeFile || UJ % 360 == 0) {
            return ae;
        }
        x.e("MicroMsg.ImageGalleryHolderImage", "rotate failed degree:%d", new Object[]{Integer.valueOf(UJ)});
        return null;
    }

    private static Bitmap c(String str, int i, int i2, int i3, int i4) {
        x.e("MicroMsg.ImageGalleryHolderImage", "hy: enter fallback bitmap logic");
        x.i("MicroMsg.ImageGalleryHolderImage", "hy: oriImgPixelRate %d, displayPixelRate %d", new Object[]{Integer.valueOf(i * i2), Integer.valueOf(i3 * i4)});
        if (i * i2 > i3 * i4) {
            try {
                return com.tencent.mm.sdk.platformtools.d.a(str, i3, i4, 0.0f, null, 0, new int[0]);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", e, "hy: oom in fallback bitmap!", new Object[0]);
                return null;
            }
        }
        x.e("MicroMsg.ImageGalleryHolderImage", "hy: the picture is even smaller the screen! display nothing");
        return null;
    }

    public static String d(au auVar, e eVar) {
        return a(auVar, eVar, false);
    }

    private static String a(au auVar, e eVar, boolean z) {
        String m;
        if (auVar.field_isSend == 1) {
            m = o.Pw().m(o.Pw().d(eVar), "", "");
            if (com.tencent.mm.a.e.bO(m)) {
                return m;
            }
            m = o.Pw().m(eVar.hzQ, "", "");
            if (com.tencent.mm.a.e.bO(m)) {
                return m;
            }
            return null;
        } else if (z || eVar.Pd()) {
            String str = eVar.hzQ;
            if (eVar.Pe()) {
                m = o.Pw().d(eVar);
                if (m != null) {
                    m = o.Pw().m(m, "", "");
                    if (com.tencent.mm.a.e.bO(m)) {
                        x.i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
                        if (m == null) {
                            m = o.Pw().m(str, "", "");
                        }
                        x.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", new Object[]{m});
                        return m;
                    }
                }
            }
            m = null;
            if (m == null) {
                m = o.Pw().m(str, "", "");
            }
            x.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", new Object[]{m});
            return m;
        } else {
            x.w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(eVar.Pd())});
            return null;
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, com.tencent.mm.ae.k kVar) {
        if (this.yCR != null && this.yCR.yCS != null && this.yi == 0) {
            Integer num;
            if (k.cvm().go(j2)) {
                int a = a(j2, obj);
                if (a != -1) {
                    num = new Integer(a);
                } else {
                    return;
                }
            }
            num = obj;
            if (num instanceof Integer) {
                int intValue = num.intValue();
                x.i("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos[%d], offset[%d], totalLen[%d], resId[%d], compressType[%d], imgLocalId[%d],", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j)});
                if (intValue == -1) {
                    x.e("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos is -1");
                    return;
                } else if (this.yCR.EQ(intValue) != null) {
                    j jVar = (j) this.yCR.EQ(intValue).getTag();
                    if (jVar != null) {
                        int i5;
                        if (intValue == this.yCR.yCS.cuT() && !FY(i)) {
                            this.yCR.yCS.ft(false);
                        }
                        if (i3 == 0) {
                            i5 = 0;
                        } else {
                            i5 = (int) (i4 != 0 ? ((((float) i3) / ((float) i4)) * 100.0f) - 1.0f : 0.0f);
                        }
                        int max = Math.max(1, i5);
                        if (intValue == this.yCR.yCS.cuT() && FY(i)) {
                            x.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", new Object[]{Integer.valueOf(max), Long.valueOf(System.currentTimeMillis())});
                            this.yCR.yCS.Gf(max);
                        }
                        com.tencent.mm.aq.k kVar2 = (com.tencent.mm.aq.k) kVar;
                        boolean isProgressive = MMNativeJpeg.isProgressive(kVar2.hBq);
                        boolean z = kVar2.hBs;
                        long bA = bh.bA(this.yEp);
                        a.do(kVar2.hBq, i4);
                        x.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isProgressive), Long.valueOf(bA), Integer.valueOf(i3), Integer.valueOf(i4), kVar2.hBq});
                        if (z && isProgressive && bA > 1000) {
                            this.yEp = bh.Wq();
                            au FL = this.yCR.FL(intValue);
                            if (a(false, jVar.yGx, o.Pw().B(FL.field_imgPath, true), a(FL, f(FL, true), true), true, -1)) {
                                j.N(jVar.yGx, 0);
                                j.N(jVar.yGr, 8);
                                j.N(jVar.yGu, 8);
                                if (intValue == this.yCR.yCS.cuT() && !FY(i)) {
                                    if (max > 50) {
                                        j.N(jVar.yGt, 8);
                                        return;
                                    } else {
                                        j.N(jVar.yGt, 0);
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            x.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, com.tencent.mm.ae.k kVar) {
        if (this.yCR != null && this.yCR.yCS != null) {
            Integer num;
            if (k.cvm().go(j2)) {
                int a = a(j2, obj);
                if (a == -1) {
                    ar.Hg();
                    a(com.tencent.mm.z.c.Fa().dH(j2), "background", false);
                    return;
                }
                num = new Integer(a);
            } else {
                num = obj;
            }
            if (num instanceof Integer) {
                final int intValue = num.intValue();
                x.i("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos = " + intValue);
                if (intValue == -1) {
                    x.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos is -1");
                    com.tencent.mm.plugin.report.service.g.pQN.a(111, 3, 1, true);
                    return;
                }
                j jVar;
                if (this.yCR.EQ(intValue) != null) {
                    jVar = (j) this.yCR.EQ(intValue).getTag();
                } else {
                    jVar = null;
                }
                boolean go = k.cvm().go(j2);
                if (i3 == 0 && i4 == 0) {
                    if (go) {
                        a(this.yCR.FL(intValue), "hd_suc:" + intValue, intValue == this.yCR.yCS.cuT());
                    }
                    x.i("MicroMsg.ImageGalleryHolderImage", "pos = " + intValue + ", selectedPos = " + this.yCR.yCS.cuT(), new Object[0]);
                    y(j2, 4);
                    au FL = this.yCR.FL(intValue);
                    e f = f(FL, true);
                    if (jVar != null) {
                        this.yCR.yCS.ft(true);
                        if (intValue == this.yCR.yCS.cuT()) {
                            if (FY(i)) {
                                ImageGalleryUI imageGalleryUI = this.yCR.yCS;
                                imageGalleryUI.ft(true);
                                imageGalleryUI.ft(true);
                                Animation Ge = ImageGalleryUI.Ge(1000);
                                Ge.setAnimationListener(new ImageGalleryUI$10(imageGalleryUI));
                                imageGalleryUI.cuS();
                                imageGalleryUI.cuH().yEU.setVisibility(0);
                                imageGalleryUI.cuH().yEV.setVisibility(8);
                                imageGalleryUI.cuH().yEW.setVisibility(8);
                                imageGalleryUI.cuH().yEX.setVisibility(0);
                                imageGalleryUI.cuH().yEX.startAnimation(Ge);
                            } else {
                                jVar.yGx.post(new Runnable(this) {
                                    final /* synthetic */ d yEq;

                                    public final void run() {
                                        if (this.yEq.yCR != null && this.yEq.yCR.yCS != null) {
                                            this.yEq.yCR.yCS.Gb(intValue);
                                        }
                                    }
                                });
                            }
                        }
                        if (a(false, jVar.yGx, o.Pw().B(FL.field_imgPath, true), a(FL, f, true), true, -1)) {
                            j.N(jVar.yGx, 0);
                            j.N(jVar.yGo, 8);
                            j.N(jVar.yGt, 8);
                            j.N(jVar.yGu, 8);
                            if (bk(FL) == 4 && this.yCR.yCW) {
                                this.yCR.bf(FL);
                                this.yCR.yCW = false;
                                return;
                            }
                            return;
                        }
                        x.e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
                        com.tencent.mm.plugin.report.service.g.pQN.a(111, 2, 1, true);
                        return;
                    }
                    return;
                }
                if (go) {
                    a(this.yCR.FL(intValue), "hd_failed:" + intValue, intValue == this.yCR.yCS.cuT());
                }
                if (intValue == this.yCR.yCS.cuT()) {
                    this.yCR.yCS.ft(true);
                }
                if (i4 == -5103059) {
                    y(j2, 5);
                    com.tencent.mm.plugin.report.service.g.pQN.a(111, 0, 1, true);
                } else {
                    y(j2, 6);
                    com.tencent.mm.plugin.report.service.g.pQN.a(111, 1, 1, true);
                }
                x.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + i3 + ", errCode = " + i4);
                this.yCR.yCX.FK(intValue);
                return;
            }
            x.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        }
    }

    private int a(long j, Object obj) {
        int intValue;
        if (obj instanceof Integer) {
            intValue = ((Integer) obj).intValue();
            cf FL = this.yCR.FL(intValue);
            if (FL != null && FL.field_msgId == j) {
                return intValue;
            }
        }
        for (Integer intValue2 : this.yCR.yeQ.values()) {
            intValue = intValue2.intValue();
            cf FL2 = this.yCR.FL(intValue);
            if (FL2 != null && FL2.field_msgId == j) {
                return intValue;
            }
        }
        return -1;
    }

    private static void a(au auVar, String str, boolean z) {
        x.i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", new Object[]{Long.valueOf(auVar.field_msgId), str});
        b.b(ac.getContext(), auVar, z);
    }

    private static boolean FY(int i) {
        return i == 1;
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        if (obj instanceof Integer) {
            x.i("MicroMsg.ImageGalleryHolderImage", "image task canceled at pos " + ((Integer) obj).intValue(), new Object[0]);
            return;
        }
        x.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
    }

    public final void ah(int i, boolean z) {
        x.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = " + i);
        au FL = this.yCR.FL(i);
        if (FL == null || FL.field_msgId == 0) {
            x.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
        } else if (b.aW(FL)) {
            e f = f(FL, true);
            if (f == null || f.hzP == 0) {
                x.e("MicroMsg.ImageGalleryHolderImage", "viewHdImg fail, msgLocalId = " + (FL == null ? "null" : Long.valueOf(FL.field_msgId)) + ", imgLocalId = " + (f == null ? "null" : Long.valueOf(f.hzP)));
                return;
            }
            f(FL, 3);
            if (FJ(i) != null) {
                a(FJ(i), FL, f, true, false, i);
            }
            if (z) {
                a cvm = k.cvm();
                x.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", new Object[]{Long.valueOf(FL.field_msgId)});
                cvm.yGF.add(Long.valueOf(FL.field_msgId));
                o.Px().a(f.hzP, FL.field_msgId, 1, Integer.valueOf(i), R.g.bAH, cvm, 0);
                return;
            }
            o.Px().a(f.hzP, FL.field_msgId, 1, Integer.valueOf(i), R.g.bAH, this, 0);
        } else {
            x.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
        }
    }

    @TargetApi(11)
    private void b(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        if (this.yCR != null && this.yCR.yCS != null) {
            x.i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", new Object[]{Integer.valueOf(multiTouchImageView.hashCode()), Integer.valueOf(bitmap.hashCode())});
            if (VERSION.SDK_INT == 20) {
                multiTouchImageView.setLayerType(1, null);
            } else {
                l.k((View) multiTouchImageView.getParent(), bitmap.getWidth(), bitmap.getHeight());
            }
            multiTouchImageView.rCd = false;
            multiTouchImageView.eS(bitmap.getWidth(), bitmap.getHeight());
            multiTouchImageView.setImageBitmap(null);
            multiTouchImageView.setImageBitmap(bitmap);
            multiTouchImageView.invalidate();
        }
    }

    public final Bitmap FZ(int i) {
        if (this.yCR == null) {
            return null;
        }
        cf FW = this.yCR.yCT.FW(i);
        if (FW == null) {
            return null;
        }
        String str = (String) this.yEn.get(FW);
        if (str == null) {
            str = o.Pw().B(FW.field_imgPath, true);
            this.yEn.put(FW, str);
        }
        String str2 = str + "hd";
        if (com.tencent.mm.a.e.bO(str2)) {
            return Zo(str2);
        }
        return Zo(str);
    }
}
