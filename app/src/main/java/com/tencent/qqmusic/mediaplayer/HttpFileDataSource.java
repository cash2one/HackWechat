package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;

public class HttpFileDataSource extends FileDataSource {
    private MediaHTTPManager mMediaHTTPManager;

    HttpFileDataSource(MediaHTTPManager mediaHTTPManager, String str) {
        super(str);
        this.mMediaHTTPManager = mediaHTTPManager;
    }

    public long getSize() {
        return this.mMediaHTTPManager.getSize();
    }
}
