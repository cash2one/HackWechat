package com.google.android.exoplayer2.f.g;

import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.f.g.e.a;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b extends com.google.android.exoplayer2.f.b {
    private static final int azv = t.ak("payl");
    private static final int azw = t.ak("sttg");
    private static final int azx = t.ak("vttc");
    private final j amI = new j();
    private final a azy = new a();

    protected final /* synthetic */ d a(byte[] bArr, int i, boolean z) {
        this.amI.l(bArr, i);
        List arrayList = new ArrayList();
        while (this.amI.lF() > 0) {
            if (this.amI.lF() < 8) {
                throw new f("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int readInt = this.amI.readInt();
            if (this.amI.readInt() == azx) {
                arrayList.add(a(this.amI, this.azy, readInt - 8));
            } else {
                this.amI.cV(readInt - 8);
            }
        }
        return new c(arrayList);
    }

    public b() {
        super("Mp4WebvttDecoder");
    }

    private static com.google.android.exoplayer2.f.a a(j jVar, a aVar, int i) {
        aVar.reset();
        while (i > 0) {
            if (i < 8) {
                throw new f("Incomplete vtt cue box header found.");
            }
            int readInt = jVar.readInt();
            int readInt2 = jVar.readInt();
            int i2 = i - 8;
            readInt -= 8;
            String str = new String(jVar.data, jVar.position, readInt);
            jVar.cV(readInt);
            i = i2 - readInt;
            if (readInt2 == azw) {
                f.a(str, aVar);
            } else if (readInt2 == azv) {
                f.a(null, str.trim(), aVar, Collections.emptyList());
            }
        }
        return aVar.le();
    }
}
