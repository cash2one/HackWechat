package com.tencent.mm.memory;

import java.nio.ByteBuffer;

class h$1 implements Runnable {
    h$1() {
    }

    public final void run() {
        for (int i = 0; i < 10; i++) {
            h.a(h.gZY, ByteBuffer.allocate(16384));
        }
    }
}
