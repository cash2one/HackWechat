package com.tencent.liteav.videodecoder;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

class b$a extends Handler {
    a a;
    d b;
    WeakReference<a> c;
    boolean d;
    boolean e;
    Surface f;
    private ByteBuffer g;
    private ByteBuffer h;

    public b$a(Looper looper) {
        super(looper);
    }

    public void a(boolean z, boolean z2, Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, d dVar, a aVar) {
        this.e = z;
        this.d = z2;
        this.f = surface;
        this.g = byteBuffer;
        this.h = byteBuffer2;
        this.b = dVar;
        this.c = new WeakReference(aVar);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                a(((Boolean) message.obj).booleanValue());
                return;
            case 101:
                try {
                    Bundle data = message.getData();
                    a(data.getByteArray("nal"), data.getLong("pts"), data.getLong("dts"), data.getInt("codecId"));
                    return;
                } catch (Exception e) {
                    return;
                }
            case 102:
                b();
                return;
            default:
                return;
        }
    }

    public int a() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.getDecoderCacheNum();
        }
        return 0;
    }

    private void a(byte[] bArr, long j, long j2, int i) {
        b bVar = new b();
        bVar.a = bArr;
        bVar.g = j;
        bVar.h = j2;
        bVar.i = i;
        if (this.a != null) {
            this.a.decode(bVar);
        }
    }

    private void b() {
        if (this.a != null) {
            this.a.stop();
            this.a.setListener(null);
            this.a.setNotifyListener(null);
            this.a = null;
        }
        Looper.myLooper().quit();
        TXCLog.w("TXCVideoDecoder", "play:decode: stop decode hwdec: " + this.d);
    }

    private void a(boolean z) {
        if (this.a != null) {
            TXCLog.w("TXCVideoDecoder", "play:decode: start decode ignore hwdec: " + this.d);
            return;
        }
        if (this.d) {
            this.a = new c();
        } else {
            this.a = new TXCVideoFfmpegDecoder();
        }
        this.a.setListener(this.b);
        this.a.setNotifyListener(this.c);
        this.a.config(this.f);
        this.a.start(this.g, this.h, z, this.e);
        TXCLog.w("TXCVideoDecoder", "play:decode: start decode hwdec: " + this.d + ", hevc: " + this.e);
    }
}
