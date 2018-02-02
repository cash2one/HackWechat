package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import com.tencent.mm.plugin.voip.video.CaptureView;

public interface b {
    void MD(String str);

    void a(CaptureView captureView);

    void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6);

    void aJ(int i, String str);

    void aUI();

    void b(int i, int i2, int[] iArr);

    void bGZ();

    Context bIa();

    void bIb();

    void dQ(int i, int i2);

    void fe(long j);

    void setMute(boolean z);

    void uninit();

    void yL(int i);
}
