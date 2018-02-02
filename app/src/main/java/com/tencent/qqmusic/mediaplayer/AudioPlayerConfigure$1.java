package com.tencent.qqmusic.mediaplayer;

class AudioPlayerConfigure$1 implements ISoLibraryLoader {
    AudioPlayerConfigure$1() {
    }

    public final boolean load(String str) {
        System.loadLibrary(str);
        return true;
    }
}
