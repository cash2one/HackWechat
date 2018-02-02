package com.google.android.exoplayer2.source.b;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.j.a;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.f.g.h;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.o;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class l implements d {
    private static final Pattern auy = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern auz = Pattern.compile("MPEGTS:(\\d+)");
    private final String ael;
    private final q alA;
    private f aoW;
    private final j auA = new j();
    private byte[] auB = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
    private int sampleSize;

    public l(String str, q qVar) {
        this.ael = str;
        this.alA = qVar;
    }

    public final void a(f fVar) {
        this.aoW = fVar;
        a aVar = new a(-9223372036854775807L);
    }

    public final int a(e eVar) {
        int i;
        int length = (int) eVar.getLength();
        if (this.sampleSize == this.auB.length) {
            byte[] bArr = this.auB;
            if (length != -1) {
                i = length;
            } else {
                i = this.auB.length;
            }
            this.auB = Arrays.copyOf(bArr, (i * 3) / 2);
        }
        i = eVar.read(this.auB, this.sampleSize, this.auB.length - this.sampleSize);
        if (i != -1) {
            this.sampleSize = i + this.sampleSize;
            if (length == -1 || this.sampleSize != length) {
                return 0;
            }
        }
        j jVar = new j(this.auB);
        try {
            h.k(jVar);
            long j = 0;
            long j2 = 0;
            while (true) {
                String readLine = jVar.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    break;
                } else if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                    Matcher matcher = auy.matcher(readLine);
                    if (matcher.find()) {
                        Matcher matcher2 = auz.matcher(readLine);
                        if (matcher2.find()) {
                            j2 = h.V(matcher.group(1));
                            j = q.S(Long.parseLong(matcher2.group(1)));
                        } else {
                            throw new o("X-TIMESTAMP-MAP doesn't contain media timestamp: " + readLine);
                        }
                    }
                    throw new o("X-TIMESTAMP-MAP doesn't contain local timestamp: " + readLine);
                }
            }
            Matcher l = h.l(jVar);
            if (l == null) {
                J(0);
            } else {
                long V = h.V(l.group(1));
                long Q = this.alA.Q(q.T((j + V) - j2));
                k J = J(Q - V);
                this.auA.l(this.auB, this.sampleSize);
                J.a(this.auA, this.sampleSize);
                J.a(Q, 1, this.sampleSize, 0, null);
            }
            return -1;
        } catch (Throwable e) {
            throw new o(e);
        }
    }

    private k J(long j) {
        k ck = this.aoW.ck(0);
        ck.f(Format.a("text/vtt", this.ael, j));
        this.aoW.ju();
        return ck;
    }
}
