package com.tencent.mm.pluginsdk.b;

import com.tencent.mm.aq.a.a;
import com.tencent.mm.protocal.c.bis;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

public interface e {
    String FC();

    void a(bis com_tencent_mm_protocal_c_bis);

    boolean a(EmojiGroupInfo emojiGroupInfo);

    byte[] a(EmojiInfo emojiInfo);

    bis aAZ();

    int aBa();

    ArrayList<EmojiGroupInfo> aBb();

    int aBc();

    ArrayList<EmojiInfo> aBd();

    a aBe();

    boolean aBf();

    EmojiInfo c(EmojiInfo emojiInfo);

    void f(j.a aVar);

    void g(j.a aVar);

    void h(j.a aVar);

    void i(j.a aVar);

    void onDestroy();

    String xZ(String str);

    int ym(String str);

    ArrayList<EmojiInfo> yn(String str);
}
