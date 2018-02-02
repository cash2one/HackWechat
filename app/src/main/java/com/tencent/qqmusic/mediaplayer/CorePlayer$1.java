package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.MediaHTTPManager.OnBufferListener;
import com.tencent.qqmusic.mediaplayer.codec.mp3.MP3Decoder;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;

class CorePlayer$1 implements OnBufferListener {
    final /* synthetic */ CorePlayer this$0;

    CorePlayer$1(CorePlayer corePlayer) {
        this.this$0 = corePlayer;
    }

    public void onBufferReadyToPlay() {
        if (!CorePlayer.access$000(this.this$0)) {
            AudioType audioFormat = FormatDetector.getAudioFormat(CorePlayer.access$100(this.this$0), false);
            if (AudioFormat.isAudioType(audioFormat)) {
                CorePlayer.access$202(this.this$0, audioFormat);
                CorePlayer.access$302(this.this$0, MediaCodecFactory.createDecoderByType(audioFormat));
                if (CorePlayer.access$300(this.this$0) instanceof MP3Decoder) {
                    ((MP3Decoder) CorePlayer.access$300(this.this$0)).setFileTotalLength(CorePlayer.access$400(this.this$0));
                }
                CorePlayer.access$502(this.this$0, CorePlayer.access$600(audioFormat, CorePlayer.access$100(this.this$0)));
                new Thread(this.this$0, "decoder-" + CorePlayer.access$100(this.this$0)).start();
                return;
            }
            CorePlayer.access$700(this.this$0, 91, 55);
        }
    }

    public void onBufferProgress(long j, long j2) {
        CorePlayer.access$800(this.this$0, j, j2);
    }
}
