package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Comparator;

class m$2 implements Comparator<EmojiInfo> {
    final /* synthetic */ m vrP;

    m$2(m mVar) {
        this.vrP = mVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        EmojiInfo emojiInfo = (EmojiInfo) obj;
        EmojiInfo emojiInfo2 = (EmojiInfo) obj2;
        if (emojiInfo == null && emojiInfo2 == null) {
            return 0;
        }
        if (emojiInfo != null) {
            if (emojiInfo2 == null) {
                return 1;
            }
            if (emojiInfo.field_lastUseTime == emojiInfo2.field_lastUseTime) {
                return 0;
            }
            if (emojiInfo.field_lastUseTime > emojiInfo2.field_lastUseTime) {
                return 1;
            }
        }
        return -1;
    }
}
