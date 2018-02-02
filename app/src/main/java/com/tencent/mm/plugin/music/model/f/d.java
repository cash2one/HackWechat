package com.tencent.mm.plugin.music.model.f;

import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public final class d implements IMediaHTTPService {
    public final IMediaHTTPConnection makeHTTPConnection() {
        Logger.i("MicroMsg.MMMediaHTTPService", "makeHTTPConnection");
        return new c();
    }
}
