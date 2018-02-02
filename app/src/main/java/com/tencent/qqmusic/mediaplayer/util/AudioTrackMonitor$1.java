package com.tencent.qqmusic.mediaplayer.util;

import android.media.AudioTrack;

class AudioTrackMonitor$1 extends Thread {
    final /* synthetic */ AudioTrackMonitor this$0;

    AudioTrackMonitor$1(AudioTrackMonitor audioTrackMonitor, String str) {
        this.this$0 = audioTrackMonitor;
        super(str);
    }

    public void run() {
        super.run();
        while (!AudioTrackMonitor.access$000(this.this$0)) {
            try {
                Thread.currentThread();
                Thread.sleep((long) AudioTrackMonitor.access$100(this.this$0));
            } catch (Throwable th) {
                Logger.e("AudioTrackMonitor", th);
            }
            try {
                if (AudioTrackMonitor.access$200(this.this$0) != null && AudioTrackMonitor.access$200(this.this$0).get() != null) {
                    AudioTrack audioTrack = (AudioTrack) AudioTrackMonitor.access$200(this.this$0).get();
                    if (audioTrack != null) {
                        int playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
                        long access$300 = ((long) playbackHeadPosition) - AudioTrackMonitor.access$300(this.this$0);
                        AudioTrackMonitor.access$302(this.this$0, (long) playbackHeadPosition);
                        long nanoTime = System.nanoTime() - AudioTrackMonitor.access$400(this.this$0);
                        AudioTrackMonitor.access$402(this.this$0, System.nanoTime());
                        AudioTrackMonitor.access$500(this.this$0).append("play-speedTime-").append(nanoTime).append(",play-speedPosition-").append(access$300);
                        AudioTrackMonitor.access$500(this.this$0).append(",playstate-").append(audioTrack.getPlayState());
                        Logger.e("AudioTrackMonitor", AudioTrackMonitor.access$500(this.this$0).toString());
                        AudioTrackMonitor.access$500(this.this$0).delete(0, AudioTrackMonitor.access$500(this.this$0).length());
                    }
                } else {
                    return;
                }
            } catch (Throwable th2) {
                Logger.e("AudioTrackMonitor", th2);
            }
        }
    }
}
