package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

class FlacSeekTable$StreamInfoHandler implements FlacSeekTable$BlockHandler {
    final /* synthetic */ FlacSeekTable this$0;

    FlacSeekTable$StreamInfoHandler(FlacSeekTable flacSeekTable) {
        this.this$0 = flacSeekTable;
    }

    public boolean handle(Parsable parsable, int i) {
        if (i != 0) {
            return false;
        }
        parsable.skip(13);
        parsable.readBytes(new byte[3], 0, 3);
        parsable.skip(21);
        return true;
    }
}
