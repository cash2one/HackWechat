package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.MediaHTTPManager.OnSniffListener;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;

class CorePlayer$3 implements OnSniffListener {
    final /* synthetic */ CorePlayer this$0;

    CorePlayer$3(CorePlayer corePlayer) {
        this.this$0 = corePlayer;
    }

    public boolean sniff() {
        boolean z = false;
        AudioType audioFormat = FormatDetector.getAudioFormat(CorePlayer.access$100(this.this$0), false);
        if (AudioFormat.isAudioType(audioFormat)) {
            BaseDecoder createDecoderByType = MediaCodecFactory.createDecoderByType(audioFormat);
            if (createDecoderByType.init(CorePlayer.access$100(this.this$0), false) == 0) {
                z = true;
            }
            if (z) {
                createDecoderByType.release();
            }
        }
        return z;
    }
}
