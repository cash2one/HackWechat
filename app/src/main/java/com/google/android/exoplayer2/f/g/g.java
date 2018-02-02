package com.google.android.exoplayer2.f.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.i.j;
import java.util.ArrayList;
import java.util.List;

public final class g extends b {
    private final f azL = new f();
    private final j azM = new j();
    private final e$a azN = new e$a();
    private final a azO = new a();
    private final List<d> azP = new ArrayList();

    protected final /* synthetic */ d a(byte[] bArr, int i, boolean z) {
        this.azM.l(bArr, i);
        this.azN.reset();
        this.azP.clear();
        h.k(this.azM);
        do {
        } while (!TextUtils.isEmpty(this.azM.readLine()));
        List arrayList = new ArrayList();
        while (true) {
            int i2 = i(this.azM);
            if (i2 == 0) {
                return new i(arrayList);
            }
            if (i2 == 1) {
                j(this.azM);
            } else if (i2 == 2) {
                if (arrayList.isEmpty()) {
                    this.azM.readLine();
                    d g = this.azO.g(this.azM);
                    if (g != null) {
                        this.azP.add(g);
                    }
                } else {
                    throw new f("A style block was found after the first cue.");
                }
            } else if (i2 == 3 && this.azL.a(this.azM, this.azN, this.azP)) {
                arrayList.add(this.azN.le());
                this.azN.reset();
            }
        }
    }

    public g() {
        super("WebvttDecoder");
    }

    private static int i(j jVar) {
        int i = 0;
        int i2 = -1;
        while (i2 == -1) {
            i = jVar.position;
            String readLine = jVar.readLine();
            if (readLine == null) {
                i2 = 0;
            } else if ("STYLE".equals(readLine)) {
                i2 = 2;
            } else if ("NOTE".startsWith(readLine)) {
                i2 = 1;
            } else {
                i2 = 3;
            }
        }
        jVar.cR(i);
        return i2;
    }

    private static void j(j jVar) {
        do {
        } while (!TextUtils.isEmpty(jVar.readLine()));
    }
}
