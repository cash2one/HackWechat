package com.tencent.liteav.videodecoder;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class b implements a {
    boolean a = true;
    boolean b = true;
    boolean c = false;
    boolean d = false;
    Surface e;
    d f;
    private ByteBuffer g;
    private ByteBuffer h;
    private long i;
    private boolean j = false;
    private ArrayList<com.tencent.liteav.basic.f.b> k = new ArrayList();
    private a l;
    private WeakReference<a> m;

    public void onNotifyEvent(int i, Bundle bundle) {
        com.tencent.liteav.basic.util.a.a(this.m, this.i, i, bundle);
    }

    public void a(long j) {
        this.i = j;
    }

    public void a(d dVar) {
        this.f = dVar;
    }

    public boolean a() {
        return this.b;
    }

    public void a(a aVar) {
        this.m = new WeakReference(aVar);
    }

    public int a(SurfaceTexture surfaceTexture, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2) {
        return a(new Surface(surfaceTexture), byteBuffer, byteBuffer2, z, z2);
    }

    public int a(Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2) {
        this.e = surface;
        this.g = byteBuffer;
        this.h = byteBuffer2;
        this.b = z;
        this.a = z2;
        return 0;
    }

    private void b(com.tencent.liteav.basic.f.b bVar) {
        boolean z = bVar.b == 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("iframe", z);
        bundle.putByteArray("nal", bVar.a);
        bundle.putLong("pts", bVar.g);
        bundle.putLong("dts", bVar.h);
        bundle.putInt("codecId", bVar.i);
        Message message = new Message();
        message.what = 101;
        message.setData(bundle);
        Handler handler = this.l;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    public void a(com.tencent.liteav.basic.f.b bVar) {
        try {
            Object obj = bVar.b == 0 ? 1 : null;
            if (this.d || obj != null) {
                if (!(this.d || obj == null)) {
                    TXCLog.e("TXCVideoDecoder", "play:decode: push first i frame");
                    this.d = true;
                }
                if (!(this.j || bVar.i != 1 || this.b)) {
                    TXCLog.w("TXCVideoDecoder", "play:decode: hevc decode error  ");
                    com.tencent.liteav.basic.util.a.a(this.m, TXLiveConstants.PLAY_ERR_HEVC_DECODE_FAIL, "h265解码失败");
                    this.j = true;
                }
                if (this.l != null) {
                    if (!this.k.isEmpty()) {
                        Iterator it = this.k.iterator();
                        while (it.hasNext()) {
                            b((com.tencent.liteav.basic.f.b) it.next());
                        }
                    }
                    this.k.clear();
                    b(bVar);
                    return;
                }
                if (!(obj == null || this.k.isEmpty())) {
                    this.k.clear();
                }
                this.k.add(bVar);
                if (!this.j) {
                    b();
                    return;
                }
                return;
            }
            TXCLog.e("TXCVideoDecoder", "play:decode: push nal ignore p frame when not got i frame");
        } catch (Exception e) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b() {
        if (this.e == null) {
            TXCLog.e("TXCVideoDecoder", "play:decode: start decoder error when not setup surface");
            return -1;
        }
        synchronized (this) {
            if (this.l != null) {
                TXCLog.e("TXCVideoDecoder", "play:decode: start decoder error when decoder is started");
                return -1;
            }
            this.j = false;
            HandlerThread handlerThread = new HandlerThread("VDecoder");
            handlerThread.start();
            handlerThread.setName("VDecoder" + handlerThread.getId());
            a aVar = new a(handlerThread.getLooper());
            aVar.a(this.c, this.b, this.e, this.g, this.h, this.f, this);
            TXCLog.w("TXCVideoDecoder", "play:decode: start decode thread");
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.obj = Boolean.valueOf(this.a);
            aVar.sendMessage(obtain);
            this.l = aVar;
        }
    }

    public void c() {
        synchronized (this) {
            if (this.l != null) {
                this.l.sendEmptyMessage(102);
            }
            this.l = null;
        }
        this.k.clear();
        this.d = false;
    }

    public void a(byte[] bArr, long j, int i) {
        a aVar = this.l;
        if (aVar != null && !aVar.d && aVar.a != null) {
            ((TXCVideoFfmpegDecoder) aVar.a).loadNativeData(bArr, j, i);
        }
    }

    public int d() {
        a aVar = this.l;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }
}
