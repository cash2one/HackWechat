package com.tencent.mm.plugin.music.model.f;

import com.tencent.mm.ac.d;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource.Factory;

public final class b implements Factory {
    public d hkz;

    public b(d dVar) {
        this.hkz = dVar;
    }

    public final IDataSource createDataSource() {
        return new a(this.hkz);
    }
}
