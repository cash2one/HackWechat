package com.google.android.exoplayer2.source.b.a;

import java.io.BufferedReader;
import java.util.Queue;

class d$a {
    private final BufferedReader avv;
    private final Queue<String> avw;
    private String avx;

    public d$a(Queue<String> queue, BufferedReader bufferedReader) {
        this.avw = queue;
        this.avv = bufferedReader;
    }

    public final boolean hasNext() {
        if (this.avx != null) {
            return true;
        }
        if (this.avw.isEmpty()) {
            do {
                String readLine = this.avv.readLine();
                this.avx = readLine;
                if (readLine == null) {
                    return false;
                }
                this.avx = this.avx.trim();
            } while (this.avx.isEmpty());
            return true;
        }
        this.avx = (String) this.avw.poll();
        return true;
    }

    public final String next() {
        if (!hasNext()) {
            return null;
        }
        String str = this.avx;
        this.avx = null;
        return str;
    }
}
