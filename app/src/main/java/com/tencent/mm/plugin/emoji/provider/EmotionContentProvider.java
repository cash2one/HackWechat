package com.tencent.mm.plugin.emoji.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;

public class EmotionContentProvider extends ContentProvider {
    private static final UriMatcher lzp;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        lzp = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.storage.provider.emotion", "EmojiGroupInfo", 1);
        lzp.addURI("com.tencent.mm.storage.provider.emotion", "userinfo", 2);
        lzp.addURI("com.tencent.mm.storage.provider.emotion", "GetEmotionListCache", 3);
        lzp.addURI("com.tencent.mm.storage.provider.emotion", "EmojiInfo", 4);
        lzp.addURI("com.tencent.mm.storage.provider.emotion", "EmojiInfoDesc", 5);
    }

    public boolean onCreate() {
        x.i("MicroMsg.EmotionContentProvider", "[onCreate]");
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.EmotionContentProvider", "[query] path:%s selection:%s", uri.getPath(), str);
        switch (lzp.match(uri)) {
            case 1:
                ar.Hg();
                return c.EV().a(str, strArr2, 2);
            case 3:
                ar.Hg();
                return c.EV().a(str, strArr2, 2);
            case 4:
                ar.Hg();
                return c.EV().a(str, strArr2, 2);
            case 5:
                ar.Hg();
                return c.EV().a(str, strArr2, 2);
            default:
                return null;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        switch (lzp.match(uri)) {
            case 3:
                ar.Hg();
                return Uri.withAppendedPath(uri, String.valueOf(c.EV().insert("GetEmotionListCache", o.gJc.xjz, contentValues)));
            default:
                return uri;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        switch (lzp.match(uri)) {
            case 3:
                ar.Hg();
                return c.EV().delete("GetEmotionListCache", str, strArr);
            default:
                return 0;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (!g.Dh().Cy()) {
            return -1;
        }
        switch (lzp.match(uri)) {
            case 1:
                ar.Hg();
                return c.EV().update("EmojiGroupInfo", contentValues, str, strArr);
            case 2:
                ar.Hg();
                c.CU().set(((Integer) contentValues.get(DownloadSettingTable$Columns.TYPE)).intValue(), contentValues.get(DownloadSettingTable$Columns.VALUE));
                return 0;
            default:
                return -1;
        }
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        boolean z = true;
        x.d("MicroMsg.EmotionContentProvider", "[call] method:%s", str);
        Bundle bundle2;
        if (str.equals("getAccPath")) {
            bundle2 = new Bundle();
            bundle2.putString("path", g.Dj().gQi);
            return bundle2;
        } else if (str.equals("getEmojiKey")) {
            bundle2 = new Bundle();
            bundle2.putString("key", i.aBE().lwL.getKey());
            return bundle2;
        } else if (str.equals("ConfigStorage.getBoolean")) {
            r2 = new Bundle();
            ar.Hg();
            r2.putBoolean("key", ((Boolean) c.CU().get(bundle.getInt("key"), Boolean.valueOf(false))).booleanValue());
            return r2;
        } else if (str.equals("ConfigStorage.getString")) {
            r1 = new Bundle();
            ar.Hg();
            r1.putString("key", (String) c.CU().get(bundle.getInt("key"), (Object) ""));
            return r1;
        } else if (str.equals("getAllCustomEmoji")) {
            bundle2 = new Bundle(EmojiInfo.class.getClassLoader());
            bundle2.putParcelableArrayList(SlookAirButtonFrequentContactAdapter.DATA, i.aBE().aBd());
            return bundle2;
        } else {
            if (str.equals("getRamdomEmoji")) {
                if (bundle != null) {
                    bundle.setClassLoader(EmojiInfo.class.getClassLoader());
                    EmojiInfo emojiInfo = (EmojiInfo) bundle.getParcelable("emoji");
                    r2 = new Bundle(EmojiInfo.class.getClassLoader());
                    r2.putParcelable(SlookAirButtonFrequentContactAdapter.DATA, ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().c(emojiInfo));
                    return r2;
                }
                String str3 = "MicroMsg.EmotionContentProvider";
                String str4 = "[getRamdomEmoji] extras:%s";
                Object[] objArr = new Object[1];
                if (bundle != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.e(str3, str4, objArr);
            } else if (str.equals("getCurLangDesc")) {
                bundle2 = new Bundle();
                bundle2.putString(SlookAirButtonFrequentContactAdapter.DATA, i.aBz().xZ(str2));
                return bundle2;
            } else if (str.equals("countCustomEmoji")) {
                r1 = new Bundle();
                r1.putInt(SlookAirButtonFrequentContactAdapter.DATA, i.aBE().lwL.lI(true));
                return r1;
            } else if (str.equals("countProductId")) {
                bundle2 = new Bundle();
                bundle2.putInt(SlookAirButtonFrequentContactAdapter.DATA, i.aBE().lwL.ym(str2));
                return bundle2;
            } else if (str.equals("getDownloadedCount")) {
                bundle2 = new Bundle();
                bundle2.putInt(SlookAirButtonFrequentContactAdapter.DATA, i.aBE().aBc());
                return bundle2;
            } else if (str.equals("getEmojiListByGroupId")) {
                r1 = new Bundle(EmojiInfo.class.getClassLoader());
                r1.putParcelableArrayList(SlookAirButtonFrequentContactAdapter.DATA, (ArrayList) ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ye(str2));
                return r1;
            } else if (str.equals("getEmojiGroupInfoList")) {
                bundle2 = new Bundle(EmojiGroupInfo.class.getClassLoader());
                bundle2.putParcelableArrayList(SlookAirButtonFrequentContactAdapter.DATA, i.aBE().aBb());
                return bundle2;
            }
            return null;
        }
    }
}
