package com.tencent.mm.plugin.talkroom.component;

import android.os.IInterface;

public interface a extends IInterface {
    int Close();

    int SetCurrentMicId(int i);

    int a(b bVar, int i, int i2, int i3, long j, int[] iArr, int[] iArr2, int i4);

    e a(c cVar);

    int bEv();

    d bEw();

    byte[] d(int[] iArr, String str);

    int uninitLive();
}
