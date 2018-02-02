package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class d implements j {
    private Context context;

    public d(Context context) {
        this.context = context;
    }

    public final void l(EmojiInfo emojiInfo) {
        Toast.makeText(this.context, this.context.getString(R.l.euG), 0).show();
    }

    public final void m(EmojiInfo emojiInfo) {
        Toast.makeText(this.context, this.context.getString(R.l.euG), 0).show();
    }

    public final boolean aZd() {
        return false;
    }

    public final boolean aZe() {
        return false;
    }

    public final void aZf() {
    }
}
