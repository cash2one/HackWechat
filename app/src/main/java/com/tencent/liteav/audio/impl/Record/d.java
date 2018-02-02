package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public class d extends b implements Runnable {
    private boolean d = false;
    private Thread e = null;
    private byte[] f = new byte[20480];
    private int g = 0;
    private int h = 0;

    public void a(Context context, int i, int i2, int i3) {
        super.a(context, i, i2, i3);
        c();
        this.d = true;
        this.e = new Thread(this, "AudioCustomRecord Thread");
        this.e.start();
    }

    public void c() {
        this.d = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(this.e == null || !this.e.isAlive() || Thread.currentThread().getId() == this.e.getId())) {
            try {
                this.e.join();
            } catch (InterruptedException e) {
                TXCLog.e("AudioCenter:TXCAudioCustomRecord", "custom record stop Exception: " + e.getMessage());
            }
        }
        TXCLog.i("AudioCenter:TXCAudioCustomRecord", "stop record cost time(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        this.e = null;
    }

    public boolean d() {
        return this.d;
    }

    public synchronized void a(byte[] bArr) {
        int length;
        if (bArr != null) {
            if (f() >= bArr.length) {
                if (this.g + bArr.length <= this.f.length) {
                    System.arraycopy(bArr, 0, this.f, this.g, bArr.length);
                    this.g += bArr.length;
                } else {
                    length = this.f.length - this.g;
                    System.arraycopy(bArr, 0, this.f, this.g, length);
                    this.g = bArr.length - length;
                    System.arraycopy(bArr, length, this.f, 0, this.g);
                }
            }
        }
        String str = "AudioCenter:TXCAudioCustomRecord";
        StringBuilder stringBuilder = new StringBuilder("缓冲区不够. 自定义数据长度 = ");
        if (bArr == null) {
            length = -1;
        } else {
            length = bArr.length;
        }
        TXCLog.e(str, stringBuilder.append(length).append(", 剩余缓冲区长度 = ").append(f()).toString());
    }

    private int e() {
        return ((this.g + this.f.length) - this.h) % this.f.length;
    }

    private int f() {
        return this.f.length - e();
    }

    public void run() {
        if (this.d) {
            a();
            int i = ((this.b * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) * this.c) / 8;
            Object obj = new byte[i];
            while (this.d && !Thread.interrupted()) {
                if (i <= e()) {
                    synchronized (this) {
                        if (this.h + i <= this.f.length) {
                            System.arraycopy(this.f, this.h, obj, 0, i);
                            this.h += i;
                        } else {
                            int length = this.f.length - this.h;
                            System.arraycopy(this.f, this.h, obj, 0, length);
                            this.h = i - length;
                            System.arraycopy(this.f, 0, obj, length, this.h);
                        }
                    }
                    a(obj, i, TXCTimeUtil.getTimeTick());
                } else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                }
            }
            b();
            return;
        }
        TXCLog.w("AudioCenter:TXCAudioCustomRecord", "audio custom record: abandom start audio sys record thread!");
    }
}
