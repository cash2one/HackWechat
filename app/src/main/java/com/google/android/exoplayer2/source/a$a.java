package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.i.a;
import java.io.IOException;

public final class a$a {
    public final a ars;
    private final long art;
    public final Handler handler;

    static /* synthetic */ long a(a$a com_google_android_exoplayer2_source_a_a, long j) {
        long j2 = b.j(j);
        return j2 == -9223372036854775807L ? -9223372036854775807L : com_google_android_exoplayer2_source_a_a.art + j2;
    }

    public a$a(Handler handler, a aVar) {
        this(handler, aVar, (byte) 0);
    }

    private a$a(Handler handler, a aVar, byte b) {
        this.handler = aVar != null ? (Handler) a.Y(handler) : null;
        this.ars = aVar;
        this.art = 0;
    }

    public final void a(i iVar, long j, long j2, long j3) {
        a(iVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
    }

    public final void a(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        if (this.ars != null) {
            this.handler.post(new 2(this, iVar, i, i2, format, i3, obj, j, j2, j3, j4, j5));
        }
    }

    public final void b(i iVar, long j, long j2, long j3) {
        b(iVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
    }

    public final void b(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        if (this.ars != null) {
            this.handler.post(new 3(this, iVar, i, i2, format, i3, obj, j, j2, j3, j4, j5));
        }
    }

    public final void a(i iVar, long j, long j2, long j3, IOException iOException, boolean z) {
        a(iVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
    }

    public final void a(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
        if (this.ars != null) {
            this.handler.post(new 4(this, iVar, i, i2, format, i3, obj, j, j2, j3, j4, j5, iOException, z));
        }
    }

    public final void jW() {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ a$a arD;

            {
                this.arD = r1;
            }

            public final void run() {
                this.arD.ars.jV();
            }
        });
    }
}
