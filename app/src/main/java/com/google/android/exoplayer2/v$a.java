package com.google.android.exoplayer2;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.f.j.a;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Iterator;
import java.util.List;

final class v$a implements Callback, SurfaceTextureListener, e, a, com.google.android.exoplayer2.metadata.e.a, com.google.android.exoplayer2.video.e {
    final /* synthetic */ v aeU;

    private v$a(v vVar) {
        this.aeU = vVar;
    }

    public final void a(d dVar) {
        this.aeU.aeP = dVar;
        if (this.aeU.aeO != null) {
            this.aeU.aeO.a(dVar);
        }
    }

    public final void c(Format format) {
        this.aeU.aeG = format;
        if (this.aeU.aeO != null) {
            this.aeU.aeO.c(format);
        }
    }

    public final void a(int i, int i2, int i3, float f) {
        Iterator it = this.aeU.aeB.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (this.aeU.aeO != null) {
            this.aeU.aeO.a(i, i2, i3, f);
        }
    }

    public final void b(Surface surface) {
        if (this.aeU.aeI == surface) {
            Iterator it = this.aeU.aeB.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (this.aeU.aeO != null) {
            this.aeU.aeO.b(surface);
        }
    }

    public final void b(d dVar) {
        if (this.aeU.aeO != null) {
            this.aeU.aeO.b(dVar);
        }
        this.aeU.aeG = null;
        this.aeU.aeP = null;
    }

    public final void c(d dVar) {
        this.aeU.aeQ = dVar;
        if (this.aeU.aeN != null) {
            this.aeU.aeN.c(dVar);
        }
    }

    public final void bW(int i) {
        this.aeU.aeR = i;
        if (this.aeU.aeN != null) {
            this.aeU.aeN.bW(i);
        }
    }

    public final void a(String str, long j, long j2) {
        if (this.aeU.aeN != null) {
            this.aeU.aeN.a(str, j, j2);
        }
    }

    public final void d(Format format) {
        this.aeU.aeH = format;
        if (this.aeU.aeN != null) {
            this.aeU.aeN.d(format);
        }
    }

    public final void c(int i, long j, long j2) {
        if (this.aeU.aeN != null) {
            this.aeU.aeN.c(i, j, j2);
        }
    }

    public final void d(d dVar) {
        if (this.aeU.aeN != null) {
            this.aeU.aeN.d(dVar);
        }
        this.aeU.aeH = null;
        this.aeU.aeQ = null;
        this.aeU.aeR = 0;
    }

    public final void i(List<com.google.android.exoplayer2.f.a> list) {
        Iterator it = this.aeU.aeC.iterator();
        while (it.hasNext()) {
            ((a) it.next()).i(list);
        }
    }

    public final void a(Metadata metadata) {
        Iterator it = this.aeU.aeD.iterator();
        while (it.hasNext()) {
            ((com.google.android.exoplayer2.metadata.e.a) it.next()).a(metadata);
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        v.a(this.aeU, surfaceHolder.getSurface(), false);
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        v.a(this.aeU, null, false);
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        v.a(this.aeU, new Surface(surfaceTexture), true);
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        v.a(this.aeU, null, true);
        return true;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
