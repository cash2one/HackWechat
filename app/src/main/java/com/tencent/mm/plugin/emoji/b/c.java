package com.tencent.mm.plugin.emoji.b;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.b.e;

public interface c extends a {
    d getEmojiMgr();

    e getProvider();

    void removeEmojiMgr();

    void setEmojiMgr();
}
