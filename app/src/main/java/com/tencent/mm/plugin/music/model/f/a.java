package com.tencent.mm.plugin.music.model.f;

import com.tencent.mm.ac.d;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public final class a implements IDataSource {
    public d hkz;

    public a(d dVar) {
        this.hkz = dVar;
    }

    public final void open() {
        Logger.i("MicroMsg.Audio.InputStreamDataSource", "open");
        if (this.hkz != null) {
            this.hkz.open();
        }
    }

    public final int readAt(long j, byte[] bArr, int i, int i2) {
        if (this.hkz != null) {
            return this.hkz.readAt(j, bArr, i, i2);
        }
        Logger.e("MicroMsg.Audio.InputStreamDataSource", "[readAt]audioDataSource is null");
        return -1;
    }

    public final long getSize() {
        return this.hkz != null ? this.hkz.getSize() : 0;
    }

    public final AudioType getAudioType() {
        if (this.hkz == null) {
            Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
            return AudioType.UNSUPPORT;
        }
        Logger.i("MicroMsg.Audio.InputStreamDataSource", "getAudioType:" + this.hkz.Jy());
        switch (this.hkz.Jy()) {
            case 0:
                return AudioType.UNSUPPORT;
            case 1:
                return AudioType.AAC;
            case 2:
                return AudioType.MP3;
            case 3:
                return AudioType.WAV;
            case 4:
                return AudioType.OGG;
            default:
                Logger.e("MicroMsg.Audio.InputStreamDataSource", "[getAudioType] unsupport");
                return AudioType.UNSUPPORT;
        }
    }

    public final void close() {
        Logger.i("MicroMsg.Audio.InputStreamDataSource", "close");
        if (this.hkz != null) {
            this.hkz.close();
        }
    }
}
