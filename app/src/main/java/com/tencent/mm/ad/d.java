package com.tencent.mm.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public final class d {
    private static int hkW = 150;
    private static int hkX = 150;
    static final Map<String, Integer> hkY;
    private static a hlc = new a(hkX);
    private k<a, String> hkZ = new k<a, String>(this) {
        final /* synthetic */ d hld;

        {
            this.hld = r1;
        }

        protected final /* synthetic */ void p(Object obj, Object obj2) {
            ((a) obj).jh((String) obj2);
        }
    };
    private Vector<WeakReference<a>> hla = new Vector();
    private final a hlb = new a(this) {
        final /* synthetic */ d hld;

        {
            this.hld = r1;
        }

        public final void jh(String str) {
            Collection vector = new Vector();
            x.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", str, Integer.valueOf(this.hld.hla.size()), Integer.valueOf(this.hld.hla.size()));
            Vector vector2 = new Vector();
            synchronized (this.hld.hla) {
                for (int i = 0; i < this.hld.hla.size(); i++) {
                    WeakReference weakReference = (WeakReference) this.hld.hla.get(i);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            vector2.add(aVar);
                        } else {
                            vector.add(weakReference);
                        }
                    }
                }
                this.hld.hla.removeAll(vector);
            }
            for (int i2 = 0; i2 < vector2.size(); i2++) {
                ((a) vector2.get(i2)).jh(str);
            }
        }
    };

    public interface a {
        void jh(String str);
    }

    public static class b {
        public static boolean ji(String str) {
            Bitmap jj = jj(str);
            if (jj == null || jj.isRecycled()) {
                return false;
            }
            OutputStream outputStream = null;
            try {
                outputStream = FileOp.iE(str);
                jj.compress(CompressFormat.PNG, 100, outputStream);
                FileOp.deleteFile(str + ".bm");
                if (outputStream == null) {
                    return true;
                }
                try {
                    outputStream.close();
                    return true;
                } catch (IOException e) {
                    return true;
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.AvatarStorage", e2, "Cannot write avatar file: %s", str);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return false;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        }

        public static Bitmap jj(String str) {
            InputStream openRead;
            ReadableByteChannel newChannel;
            Exception e;
            OutOfMemoryError e2;
            String str2 = str + ".bm";
            try {
                if (FileOp.bO(str2)) {
                    int me = (int) FileOp.me(str2);
                    if (me <= 0 || !(me == 36864 || me == 36880)) {
                        eq(str);
                        x.e("MicroMsg.AvatarStorage", "SmallBM get bm invalid size:%d file:%s", Integer.valueOf(me), str2);
                        return null;
                    }
                    openRead = FileOp.openRead(str2);
                    try {
                        newChannel = Channels.newChannel(openRead);
                        try {
                            boolean z;
                            Buffer allocateDirect = ByteBuffer.allocateDirect(36864);
                            newChannel.read(allocateDirect);
                            allocateDirect.position(0);
                            if (me == 36880) {
                                ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(16);
                                newChannel.read(allocateDirect2);
                                if (allocateDirect2.getLong(0) != 1) {
                                    x.e("MicroMsg.AvatarStorage", "SmallBM get bm header invalid flag:%d size:%d file:%s", Long.valueOf(allocateDirect2.getLong(0)), Integer.valueOf(me), str2);
                                    newChannel.close();
                                    openRead.close();
                                    eq(str);
                                    return null;
                                }
                                z = false;
                            } else {
                                z = true;
                            }
                            x.d("MicroMsg.AvatarStorage", "SmallBM get bm size:%d shouldRemoveCorner:%b file:%s", Integer.valueOf(me), Boolean.valueOf(z), str2);
                            newChannel.close();
                            openRead.close();
                            Bitmap createBitmap = Bitmap.createBitmap(96, 96, Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(allocateDirect);
                            if (!z) {
                                return createBitmap;
                            }
                            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 9, 9, 78, 78);
                            x.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", createBitmap.toString());
                            createBitmap.recycle();
                            return createBitmap2;
                        } catch (Exception e3) {
                            e = e3;
                            x.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                            if (newChannel != null) {
                                try {
                                    newChannel.close();
                                } catch (Exception e4) {
                                    return null;
                                }
                            }
                            if (openRead != null) {
                                return null;
                            }
                            openRead.close();
                            return null;
                        } catch (OutOfMemoryError e5) {
                            e2 = e5;
                            x.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                            if (newChannel != null) {
                                newChannel.close();
                            }
                            if (openRead != null) {
                                return null;
                            }
                            openRead.close();
                            return null;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        newChannel = null;
                        x.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                        if (newChannel != null) {
                            newChannel.close();
                        }
                        if (openRead != null) {
                            return null;
                        }
                        openRead.close();
                        return null;
                    } catch (OutOfMemoryError e7) {
                        e2 = e7;
                        newChannel = null;
                        x.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                        if (newChannel != null) {
                            newChannel.close();
                        }
                        if (openRead != null) {
                            return null;
                        }
                        openRead.close();
                        return null;
                    }
                }
                x.w("MicroMsg.AvatarStorage", "SmallBM get bm file not exsit:%s", str2);
                return null;
            } catch (Exception e8) {
                e = e8;
                newChannel = null;
                openRead = null;
                x.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                if (newChannel != null) {
                    newChannel.close();
                }
                if (openRead != null) {
                    return null;
                }
                openRead.close();
                return null;
            } catch (OutOfMemoryError e9) {
                e2 = e9;
                newChannel = null;
                openRead = null;
                x.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                if (newChannel != null) {
                    newChannel.close();
                }
                if (openRead != null) {
                    return null;
                }
                openRead.close();
                return null;
            }
        }

        static boolean eq(String str) {
            FileOp.deleteFile(str + ".bm");
            FileOp.deleteFile(str);
            return true;
        }
    }

    static {
        Map hashMap = new HashMap();
        hkY = hashMap;
        hashMap.put("voipapp", Integer.valueOf(g.loo));
        hkY.put("qqmail", Integer.valueOf(g.loi));
        hkY.put("fmessage", Integer.valueOf(g.loa));
        hkY.put("floatbottle", Integer.valueOf(g.lnX));
        hkY.put("lbsapp", Integer.valueOf(g.loe));
        hkY.put("shakeapp", Integer.valueOf(g.lol));
        hkY.put("medianote", Integer.valueOf(g.lod));
        hkY.put("qqfriend", Integer.valueOf(g.loh));
        hkY.put("masssendapp", Integer.valueOf(g.loc));
        hkY.put("feedsapp", Integer.valueOf(g.lnZ));
        hkY.put("facebookapp", Integer.valueOf(g.dyl));
        hkY.put("newsapp", Integer.valueOf(g.loj));
        hkY.put("helper_entry", Integer.valueOf(g.log));
        hkY.put("voicevoipapp", Integer.valueOf(g.lon));
        hkY.put("voiceinputapp", Integer.valueOf(g.lom));
        hkY.put("officialaccounts", Integer.valueOf(g.lnY));
        hkY.put("service_officialaccounts", Integer.valueOf(g.lok));
        hkY.put("linkedinplugin", Integer.valueOf(g.lob));
        hkY.put("notifymessage", Integer.valueOf(g.lof));
        hkY.put("appbrandcustomerservicemsg", Integer.valueOf(g.lnW));
    }

    public static void a(Context context, ImageView imageView, int i) {
        try {
            imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.compatible.f.a.decodeResource(context.getResources(), i), true, 1.0f));
        } catch (Throwable e) {
            x.e("MicroMsg.AvatarStorage", "exception:%s", bh.i(e));
        }
    }

    public d() {
        reset();
        this.hkZ.a(this.hlb, null);
    }

    public final void a(a aVar) {
        synchronized (this.hla) {
            this.hla.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        synchronized (this.hla) {
            this.hla.remove(c(aVar));
        }
    }

    private WeakReference<a> c(a aVar) {
        synchronized (this.hla) {
            for (int i = 0; i < this.hla.size(); i++) {
                WeakReference<a> weakReference = (WeakReference) this.hla.get(i);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        return weakReference;
                    }
                }
            }
            return null;
        }
    }

    @Deprecated
    public final void d(a aVar) {
        this.hkZ.a(aVar, Looper.getMainLooper());
    }

    @Deprecated
    public final void e(a aVar) {
        this.hkZ.remove(aVar);
    }

    public static void reset() {
        if (hlc == null) {
            hlc = new a(hkX);
        }
    }

    public static Bitmap jc(String str) {
        if (bh.ov(str)) {
            return null;
        }
        a aVar = hlc;
        Bitmap bitmap = aVar.hkE != null ? (Bitmap) aVar.hkE.get(str) : (Bitmap) com.tencent.mm.cache.e.a.D("avatar_cache", str);
        if (bitmap == null) {
            return null;
        }
        if (!bitmap.isRecycled()) {
            return bitmap;
        }
        aVar = hlc;
        if (aVar.hkE != null) {
            aVar.hkE.remove(str);
        } else {
            com.tencent.mm.cache.e.a.E("avatar_cache", str);
        }
        return null;
    }

    public final void d(String str, Bitmap bitmap) {
        a aVar = hlc;
        if (aVar.hkE != null) {
            aVar.hkE.l(str, bitmap);
        } else {
            com.tencent.mm.cache.e.a.a("avatar_cache", str, (Object) bitmap);
        }
        this.hkZ.ca(str);
        this.hkZ.doNotify();
        x.d("MicroMsg.AvatarStorage", "setToCache %s", str);
    }

    public final Bitmap bg(Context context) {
        context.getResources();
        Bitmap jc = jc("I_AM_NO_SDCARD_USER_NAME");
        if (m(jc) || jc == null) {
            return jc;
        }
        x.i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", Boolean.valueOf(jc.isRecycled()), "I_AM_NO_SDCARD_USER_NAME");
        jc = com.tencent.mm.sdk.platformtools.d.a(jc, true, 1.0f);
        d("I_AM_NO_SDCARD_USER_NAME", jc);
        return jc;
    }

    public static String x(String str, boolean z) {
        if (bh.ov(str)) {
            return null;
        }
        String a = i.a(com.tencent.mm.plugin.f.a.aoe(), "user_" + (z ? "hd_" : ""), com.tencent.mm.a.g.s(str.getBytes()), ".png", 1, false);
        if (a == null) {
            return null;
        }
        return !FileOp.mh(new File(a).getParent()) ? null : a;
    }

    public static boolean y(String str, boolean z) {
        String x = x(str, z);
        x.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", str, Boolean.valueOf(z), x);
        boolean deleteFile = FileOp.deleteFile(x);
        if (z) {
            return deleteFile;
        }
        return deleteFile | b.eq(x);
    }

    public static Bitmap jd(String str) {
        return jg(x(str, false));
    }

    public static Bitmap e(String str, byte[] bArr) {
        Throwable e;
        Bitmap a = com.tencent.mm.sdk.platformtools.d.a(bArr, 96, 96, 0, 0, 1);
        if (m(a)) {
            int width = a.getWidth();
            int height = a.getHeight();
            if (width != height) {
                if (width > height) {
                    a = Bitmap.createBitmap(a, (width - height) / 2, 0, height, height);
                } else {
                    a = Bitmap.createBitmap(a, 0, (height - width) / 2, width, width);
                }
            }
            OutputStream iE;
            try {
                iE = FileOp.iE(x(str, false));
                try {
                    iE.write(bArr, 0, bArr.length);
                    if (iE != null) {
                        try {
                            iE.close();
                        } catch (IOException e2) {
                        }
                    }
                    x.i("MicroMsg.AvatarStorage", "Saved avatar: %s", str);
                    return a;
                } catch (IOException e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                        if (iE != null) {
                            try {
                                iE.close();
                            } catch (IOException e4) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (iE != null) {
                            try {
                                iE.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                iE = null;
                x.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                if (iE != null) {
                    iE.close();
                }
                return null;
            } catch (Throwable th2) {
                e = th2;
                iE = null;
                if (iE != null) {
                    iE.close();
                }
                throw e;
            }
        }
        x.e("MicroMsg.AvatarStorage", "Failed to decode avatar: %s", str);
        return null;
    }

    public final boolean f(String str, byte[] bArr) {
        Bitmap e = e(str, bArr);
        if (!m(e)) {
            return false;
        }
        d(str, e);
        return true;
    }

    public final boolean ac(String str, String str2) {
        int i = 96;
        try {
            int i2;
            Options UL = com.tencent.mm.sdk.platformtools.d.UL(str);
            int i3 = UL.outWidth;
            int i4 = UL.outHeight;
            if (i4 < i3) {
                i2 = (i3 * 96) / i4;
            } else {
                i2 = 96;
                i = (i4 * 96) / i3;
            }
            x.d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(1));
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            options.inSampleSize = Math.min(i3 / i2, i4 / i);
            return e(str2, com.tencent.mm.sdk.platformtools.d.a(str, options, 0, 0, 1));
        } catch (Throwable e) {
            x.e("MicroMsg.AvatarStorage", "exception:%s", bh.i(e));
            return false;
        }
    }

    boolean e(String str, Bitmap bitmap) {
        Throwable e;
        OutputStream outputStream;
        if (!m(bitmap)) {
            return false;
        }
        Bitmap bitmap2;
        if (bitmap.getWidth() == 96 && bitmap.getHeight() == 96) {
            bitmap2 = bitmap;
        } else {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width != height) {
                    if (width > height) {
                        bitmap2 = Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height);
                    } else {
                        bitmap2 = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
                    }
                    bitmap2 = Bitmap.createScaledBitmap(bitmap2, 96, 96, true);
                } else {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap, 96, 96, true);
                }
            } catch (OutOfMemoryError e2) {
                x.e("MicroMsg.AvatarStorage", "kevin updateAvatar fail  %s ", str);
                if (m(bitmap)) {
                    x.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
                return false;
            }
        }
        if (!(bitmap2 == null || bitmap2 == bitmap)) {
            x.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", bitmap.toString());
            bitmap.recycle();
            bitmap = bitmap2;
        }
        OutputStream outputStream2 = null;
        try {
            outputStream2 = FileOp.iE(x(str, false));
            try {
                bitmap.compress(CompressFormat.PNG, 100, outputStream2);
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                d(str, bitmap);
                return true;
            } catch (IOException e4) {
                e = e4;
                outputStream = outputStream2;
                try {
                    x.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                outputStream = outputStream2;
                if (outputStream != null) {
                    outputStream.close();
                }
                throw e;
            }
        } catch (IOException e7) {
            e = e7;
            outputStream = outputStream2;
            x.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
            if (outputStream != null) {
                outputStream.close();
            }
            return false;
        } catch (Throwable th3) {
            e = th3;
            outputStream = outputStream2;
            if (outputStream != null) {
                outputStream.close();
            }
            throw e;
        }
    }

    public static Bitmap je(String str) {
        x.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", str);
        if (bh.ov(str)) {
            return null;
        }
        return com.tencent.mm.sdk.platformtools.d.a(x(str, true), 480, 480, null, 0, 0, 1);
    }

    public static Bitmap jf(String str) {
        Bitmap decodeResource;
        int i = 0;
        if (hkY.containsKey(str)) {
            i = ((Integer) hkY.get(str)).intValue();
        }
        if (i != 0) {
            n.JP();
            decodeResource = com.tencent.mm.compatible.f.a.decodeResource(n.getContext().getResources(), i);
        } else {
            decodeResource = null;
        }
        return com.tencent.mm.sdk.platformtools.d.a(decodeResource, true, 1.0f, true);
    }

    private static boolean m(Bitmap bitmap) {
        return (bitmap == null || bitmap.isRecycled()) ? false : true;
    }

    public static Bitmap jg(String str) {
        Bitmap a = FileOp.bO(str) ? com.tencent.mm.sdk.platformtools.d.a(str, null, 0, 0, 1) : null;
        if (a == null) {
            a = b.jj(str);
        }
        if (m(a)) {
            int width = a.getWidth();
            int height = a.getHeight();
            if (width != height) {
                if (width > height) {
                    a = Bitmap.createBitmap(a, (width - height) / 2, 0, height, height);
                } else {
                    a = Bitmap.createBitmap(a, 0, (height - width) / 2, width, width);
                }
            }
        }
        return m(a) ? a : null;
    }
}
