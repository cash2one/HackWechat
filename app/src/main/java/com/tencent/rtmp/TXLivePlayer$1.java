package com.tencent.rtmp;

import com.tencent.liteav.n;
import com.tencent.rtmp.TXLivePlayer.ITXVideoRawDataListener;

class TXLivePlayer$1 implements n {
    final /* synthetic */ TXLivePlayer this$0;
    final /* synthetic */ ITXVideoRawDataListener val$listener;

    TXLivePlayer$1(TXLivePlayer tXLivePlayer, ITXVideoRawDataListener iTXVideoRawDataListener) {
        this.this$0 = tXLivePlayer;
        this.val$listener = iTXVideoRawDataListener;
    }

    public void onVideoRawDataAvailable(byte[] bArr, int i, int i2, int i3) {
        this.val$listener.onVideoRawDataAvailable(bArr, i, i2, i3);
    }
}
