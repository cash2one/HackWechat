package com.qq.wx.voice.embed.recognizer;

public final class e {
    public Grammar bgt;
    g bgu;
    byte[] c;
    public boolean d;
    public boolean e;

    public e() {
        this.bgt = null;
        this.bgu = new g();
        this.c = null;
        this.d = false;
        this.e = false;
        this.bgt = new Grammar();
    }

    public final int a(c cVar, byte[] bArr) {
        if (!this.d) {
            return -304;
        }
        if (!this.e) {
            return -302;
        }
        this.bgu.bgv = cVar;
        this.c = bArr;
        if (this.c == null) {
            return -301;
        }
        try {
            new Thread(new a(this, (byte) 0)).start();
            return 0;
        } catch (Exception e) {
            return -302;
        }
    }
}
