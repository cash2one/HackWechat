package com.tencent.mm.pluginsdk.b;

import android.content.Context;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.az.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import java.util.ArrayList;
import java.util.List;

public interface d extends e {
    String a(Context context, WXMediaMessage wXMediaMessage, String str);

    void a(Context context, au auVar);

    void a(String str, EmojiInfo emojiInfo, au auVar);

    boolean a(Context context, EmojiInfo emojiInfo, int i, String str);

    boolean a(String str, String str2, long j, String str3, a aVar);

    byte[] a(EmojiInfo emojiInfo);

    boolean aAU();

    ArrayList<q> aAV();

    ArrayList<String> aAW();

    ArrayList<s> aAX();

    f aAY();

    al cj(String str, String str2);

    String ck(String str, String str2);

    void d(EmojiInfo emojiInfo);

    int e(EmojiInfo emojiInfo);

    int[] f(EmojiInfo emojiInfo);

    boolean m(Context context, String str, String str2);

    boolean p(ArrayList<q> arrayList);

    boolean q(ArrayList<s> arrayList);

    EmojiInfo yc(String str);

    String yd(String str);

    List<EmojiInfo> ye(String str);

    boolean yf(String str);

    ArrayList<String> yg(String str);

    String yh(String str);

    String yi(String str);

    int yj(String str);

    String yk(String str);

    void yl(String str);
}
