package com.tencent.mm.bu;

import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.protocal.c.bis;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.HashMap;

public final class a implements e {
    public static a xbn = new a();
    public static b xbo = new b();
    public static c xbp = new c();
    private com.tencent.mm.aq.a.a lNS;
    private String xbj;
    private ArrayList<EmojiInfo> xbk = new ArrayList();
    private HashMap<String, ArrayList<EmojiInfo>> xbl = new HashMap();
    private ArrayList<EmojiGroupInfo> xbm = new ArrayList();

    public final String xZ(String str) {
        if (((h) g.Dg().CN()).DS()) {
            return ((c) g.k(c.class)).getEmojiMgr().xZ(str);
        }
        return ac.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getCurLangDesc", str, null).getString(SlookAirButtonFrequentContactAdapter.DATA, "");
    }

    public final bis aAZ() {
        if (((h) g.Dg().CN()).DS()) {
            return ((c) g.k(c.class)).getEmojiMgr().aAZ();
        }
        return null;
    }

    public final void a(bis com_tencent_mm_protocal_c_bis) {
        if (((h) g.Dg().CN()).DS()) {
            ((c) g.k(c.class)).getEmojiMgr().a(com_tencent_mm_protocal_c_bis);
        }
    }

    public final int aBa() {
        if (((h) g.Dg().CN()).DS()) {
            return ((c) g.k(c.class)).getEmojiMgr().aBa();
        }
        return ac.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "countCustomEmoji", null, null).getInt(SlookAirButtonFrequentContactAdapter.DATA, 0);
    }

    public final int ym(String str) {
        if (((h) g.Dg().CN()).DS()) {
            return ((c) g.k(c.class)).getEmojiMgr().ym(str);
        }
        return ac.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "countProductId", str, null).getInt(SlookAirButtonFrequentContactAdapter.DATA, 0);
    }

    public final int aBc() {
        if (((h) g.Dg().CN()).DS()) {
            return ((c) g.k(c.class)).getEmojiMgr().aBc();
        }
        return ac.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getDownloadedCount", null, null).getInt(SlookAirButtonFrequentContactAdapter.DATA, 0);
    }

    public final boolean a(EmojiGroupInfo emojiGroupInfo) {
        if (((h) g.Dg().CN()).DS()) {
            return ((c) g.k(c.class)).getEmojiMgr().a(emojiGroupInfo);
        }
        return false;
    }

    public final ArrayList<EmojiGroupInfo> aBb() {
        if (((h) g.Dg().CN()).DS()) {
            return ((c) g.k(c.class)).getEmojiMgr().aBb();
        }
        if (this.xbm.size() == 0) {
            Bundle call = ac.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiGroupInfoList", null, null);
            if (call != null) {
                call.setClassLoader(EmojiGroupInfo.class.getClassLoader());
                if (call.containsKey(SlookAirButtonFrequentContactAdapter.DATA)) {
                    this.xbm.addAll(call.getParcelableArrayList(SlookAirButtonFrequentContactAdapter.DATA));
                    x.i("MicroMsg.EmotionStorageResolver", "[getEmojiGroupInfoListExport] size%s", Integer.valueOf(r0.size()));
                }
            }
        }
        return this.xbm;
    }

    public final ArrayList<EmojiInfo> aBd() {
        if (((h) g.Dg().CN()).DS()) {
            return ((c) g.k(c.class)).getEmojiMgr().aBd();
        }
        if (this.xbk.size() == 0) {
            Bundle call = ac.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getAllCustomEmoji", "false", null);
            if (call != null) {
                call.setClassLoader(EmojiInfo.class.getClassLoader());
                if (call.containsKey(SlookAirButtonFrequentContactAdapter.DATA)) {
                    this.xbk.addAll(call.getParcelableArrayList(SlookAirButtonFrequentContactAdapter.DATA));
                    x.i("MicroMsg.EmotionStorageResolver", "[getAllCustomEmojiExport] size:%s", Integer.valueOf(r0.size()));
                }
            }
        }
        return this.xbk;
    }

    public final ArrayList<EmojiInfo> yn(String str) {
        if (((h) g.Dg().CN()).DS()) {
            return ((c) g.k(c.class)).getEmojiMgr().yn(str);
        }
        ArrayList<EmojiInfo> arrayList = (ArrayList) this.xbl.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.xbl.put(str, arrayList);
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        Bundle call = ac.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiListByGroupId", str, null);
        if (call == null) {
            return arrayList;
        }
        call.setClassLoader(EmojiInfo.class.getClassLoader());
        if (!call.containsKey(SlookAirButtonFrequentContactAdapter.DATA)) {
            return arrayList;
        }
        arrayList.addAll(call.getParcelableArrayList(SlookAirButtonFrequentContactAdapter.DATA));
        x.i("MicroMsg.EmotionStorageResolver", "[getEmojiListByGroupIdExport] size%s", Integer.valueOf(r1.size()));
        return arrayList;
    }

    public final com.tencent.mm.aq.a.a aBe() {
        if (((h) g.Dg().CN()).DS()) {
            return ((c) g.k(c.class)).getEmojiMgr().aBe();
        }
        if (this.lNS == null) {
            com.tencent.mm.aq.a.a.b.a aVar = new com.tencent.mm.aq.a.a.b.a(ac.getContext());
            aVar.hDo = new com.tencent.mm.view.d.a();
            this.lNS = new com.tencent.mm.aq.a.a(aVar.PJ());
        }
        return this.lNS;
    }

    public final void f(com.tencent.mm.sdk.e.j.a aVar) {
        if (((h) g.Dg().CN()).DS()) {
            ((c) g.k(c.class)).getEmojiMgr().f(aVar);
        }
    }

    public final byte[] a(EmojiInfo emojiInfo) {
        if (((h) g.Dg().CN()).DS()) {
            return ((c) g.k(c.class)).getEmojiMgr().a(emojiInfo);
        }
        if (emojiInfo == null) {
            x.w("MicroMsg.EmotionStorageResolver", "[decodeEmojiDataExport] failed. emoji is null.");
            return null;
        }
        String ckB = emojiInfo.ckB();
        Object d = com.tencent.mm.a.e.d(ckB, 0, com.tencent.mm.a.e.bN(ckB));
        if (com.tencent.mm.a.e.bN(ckB) <= 0 || d == null || d.length < 10) {
            x.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path is no exist :%s ", ckB);
            return null;
        }
        Object obj = new byte[10];
        System.arraycopy(d, 0, obj, 0, 10);
        if ((emojiInfo.field_reserved4 & EmojiInfo.xAz) != EmojiInfo.xAz || p.bp(obj)) {
            return d;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int bN = com.tencent.mm.a.e.bN(ckB);
        if (bN > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            bN = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        Object aesCryptEcb = !bh.ov(aAS()) ? AesEcb.aesCryptEcb(com.tencent.mm.a.e.d(ckB, 0, bN), aAS().getBytes(), false, false) : null;
        if (bh.bw(aesCryptEcb) || bh.bw(d)) {
            x.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path:%s return original ", ckB);
            return d;
        }
        System.arraycopy(aesCryptEcb, 0, d, 0, bN);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        x.d("MicroMsg.EmotionStorageResolver", "decode emoji file length:%d use time:%d", Integer.valueOf(d.length), Long.valueOf(currentTimeMillis2));
        return d;
    }

    public final void g(com.tencent.mm.sdk.e.j.a aVar) {
        if (((h) g.Dg().CN()).DS()) {
            ((c) g.k(c.class)).getEmojiMgr().g(aVar);
        }
    }

    public final void h(com.tencent.mm.sdk.e.j.a aVar) {
        if (((h) g.Dg().CN()).DS()) {
            ((c) g.k(c.class)).getEmojiMgr().h(aVar);
        }
    }

    public final void i(com.tencent.mm.sdk.e.j.a aVar) {
        if (((h) g.Dg().CN()).DS()) {
            ((c) g.k(c.class)).getEmojiMgr().i(aVar);
        }
    }

    public final EmojiInfo c(EmojiInfo emojiInfo) {
        if (((h) g.Dg().CN()).DS()) {
            return ((c) g.k(c.class)).getEmojiMgr().c(emojiInfo);
        }
        Bundle bundle = new Bundle(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("emoji", emojiInfo);
        bundle = ac.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getRamdomEmoji", null, bundle);
        if (bundle == null) {
            x.e("MicroMsg.EmotionStorageResolver", "[getRamdomEmoji] bunndle is null! ");
            return null;
        }
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        if (bundle.containsKey(SlookAirButtonFrequentContactAdapter.DATA)) {
            return (EmojiInfo) bundle.getParcelable(SlookAirButtonFrequentContactAdapter.DATA);
        }
        boolean z;
        String str = "MicroMsg.EmotionStorageResolver";
        String str2 = "[getRamdomEmoji] bundle is null?";
        Object[] objArr = new Object[1];
        if (bundle == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.e(str, str2, objArr);
        return null;
    }

    private static String aAS() {
        return ac.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiKey", null, null).getString("key", "");
    }

    public final String FC() {
        if (((h) g.Dg().CN()).DS()) {
            this.xbj = ((c) g.k(c.class)).getEmojiMgr().FC();
        } else if (bh.ov(this.xbj)) {
            this.xbj = ac.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getAccPath", null, null).getString("path");
        }
        return this.xbj;
    }

    public static a cdS() {
        return xbn;
    }

    public final void onDestroy() {
        this.xbm.clear();
    }

    public final boolean aBf() {
        if (((h) g.Dg().CN()).DS()) {
            return ((c) g.k(c.class)).getEmojiMgr().aBf();
        }
        return true;
    }
}
