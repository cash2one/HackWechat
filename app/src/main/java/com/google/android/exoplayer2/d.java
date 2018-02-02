package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.a.i;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.f.j;
import com.google.android.exoplayer2.f.j.a;
import com.google.android.exoplayer2.video.c;
import com.google.android.exoplayer2.video.e;
import java.util.ArrayList;

public final class d implements u {
    private final long acA;
    private final b<com.google.android.exoplayer2.drm.d> acy;
    private final int acz;
    private final Context context;

    public d(Context context) {
        this(context, (byte) 0);
    }

    private d(Context context, byte b) {
        this(context, null);
    }

    private d(Context context, b<com.google.android.exoplayer2.drm.d> bVar) {
        this(context, null, 0);
    }

    private d(Context context, b<com.google.android.exoplayer2.drm.d> bVar, int i) {
        this.context = context;
        this.acy = bVar;
        this.acz = 0;
        this.acA = 5000;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final r[] a(Handler handler, e eVar, com.google.android.exoplayer2.a.e eVar2, a aVar, com.google.android.exoplayer2.metadata.e.a aVar2) {
        int size;
        int i;
        ArrayList arrayList = new ArrayList();
        Context context = this.context;
        b bVar = this.acy;
        long j = this.acA;
        int i2 = this.acz;
        arrayList.add(new c(context, com.google.android.exoplayer2.e.c.aqe, j, bVar, handler, eVar));
        if (i2 != 0) {
            size = arrayList.size();
            try {
                arrayList.add(i2 == 2 ? size - 1 : size, (r) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[]{Boolean.TYPE, Long.TYPE, Handler.class, e.class, Integer.TYPE}).newInstance(new Object[]{Boolean.valueOf(true), Long.valueOf(j), handler, eVar, Integer.valueOf(50)}));
            } catch (ClassNotFoundException e) {
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            }
        }
        Context context2 = this.context;
        b bVar2 = this.acy;
        com.google.android.exoplayer2.a.d[] dVarArr = new com.google.android.exoplayer2.a.d[0];
        int i3 = this.acz;
        arrayList.add(new i(com.google.android.exoplayer2.e.c.aqe, bVar2, handler, eVar2, com.google.android.exoplayer2.a.c.u(context2), dVarArr));
        if (i3 != 0) {
            int size2 = arrayList.size();
            if (i3 == 2) {
                size2--;
            }
            try {
                i = size2 + 1;
                arrayList.add(size2, (r) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(new Class[]{Handler.class, com.google.android.exoplayer2.a.e.class, com.google.android.exoplayer2.a.d[].class}).newInstance(new Object[]{handler, eVar2, dVarArr}));
                size2 = i;
            } catch (ClassNotFoundException e3) {
                size = size2;
                size2 = size;
                i = size2 + 1;
                arrayList.add(size2, (r) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(new Class[]{Handler.class, com.google.android.exoplayer2.a.e.class, com.google.android.exoplayer2.a.d[].class}).newInstance(new Object[]{handler, eVar2, dVarArr}));
                arrayList.add(i, (r) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(new Class[]{Handler.class, com.google.android.exoplayer2.a.e.class, com.google.android.exoplayer2.a.d[].class}).newInstance(new Object[]{handler, eVar2, dVarArr}));
                arrayList.add(new j(aVar, handler.getLooper()));
                arrayList.add(new com.google.android.exoplayer2.metadata.e(aVar2, handler.getLooper()));
                return (r[]) arrayList.toArray(new r[arrayList.size()]);
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            }
            try {
                i = size2 + 1;
                arrayList.add(size2, (r) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(new Class[]{Handler.class, com.google.android.exoplayer2.a.e.class, com.google.android.exoplayer2.a.d[].class}).newInstance(new Object[]{handler, eVar2, dVarArr}));
            } catch (ClassNotFoundException e4) {
                size = size2;
                i = size;
                arrayList.add(i, (r) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(new Class[]{Handler.class, com.google.android.exoplayer2.a.e.class, com.google.android.exoplayer2.a.d[].class}).newInstance(new Object[]{handler, eVar2, dVarArr}));
                arrayList.add(new j(aVar, handler.getLooper()));
                arrayList.add(new com.google.android.exoplayer2.metadata.e(aVar2, handler.getLooper()));
                return (r[]) arrayList.toArray(new r[arrayList.size()]);
            } catch (Throwable e222) {
                throw new RuntimeException(e222);
            }
            try {
                arrayList.add(i, (r) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(new Class[]{Handler.class, com.google.android.exoplayer2.a.e.class, com.google.android.exoplayer2.a.d[].class}).newInstance(new Object[]{handler, eVar2, dVarArr}));
            } catch (ClassNotFoundException e5) {
            } catch (Throwable e2222) {
                throw new RuntimeException(e2222);
            }
        }
        arrayList.add(new j(aVar, handler.getLooper()));
        arrayList.add(new com.google.android.exoplayer2.metadata.e(aVar2, handler.getLooper()));
        return (r[]) arrayList.toArray(new r[arrayList.size()]);
    }
}
