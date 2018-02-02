package com.tencent.mm.storage.emotion;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends i<b> implements a {
    public static final String[] gJN = new String[]{i.a(b.gJc, "EmojiInfoDesc")};
    public e gJP;
    public SharedPreferences xAA;

    public final /* synthetic */ boolean b(com.tencent.mm.sdk.e.c cVar) {
        b bVar = (b) cVar;
        if (bVar != null) {
            if (bVar.Nr().length() == 32) {
                bVar.field_md5_lang = bVar.field_md5 + bVar.field_lang;
                long replace = this.gJP.replace("EmojiInfoDesc", "md5_lang", bVar.vI());
                if (replace != -1) {
                    Wc(bVar.Nr());
                }
                return replace >= 0;
            }
        }
        return false;
    }

    public c(e eVar) {
        this(eVar, b.gJc, "EmojiInfoDesc");
    }

    private c(e eVar, com.tencent.mm.sdk.e.c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gJP = eVar;
        this.xAA = PreferenceManager.getDefaultSharedPreferences(ac.getContext());
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    public final boolean XR(String str) {
        boolean z = true;
        boolean z2 = false;
        Cursor cursor = null;
        try {
            cursor = this.gJP.a(String.format("select %s from %s where %s=?", new Object[]{"click_flag", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                if ((cursor.getInt(cursor.getColumnIndex("click_flag")) & 1) != 1) {
                    z = false;
                }
                z2 = z;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            x.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", new Object[]{e.toString()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return z2;
    }

    public final boolean XS(String str) {
        boolean z = true;
        boolean z2 = false;
        Cursor cursor = null;
        try {
            cursor = this.gJP.a(String.format("select %s from %s where %s=?", new Object[]{"download_flag", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                if ((cursor.getInt(cursor.getColumnIndex("download_flag")) & 1) != 1) {
                    z = false;
                }
                z2 = z;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            x.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", new Object[]{e.toString()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return z2;
    }

    public final boolean XT(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                cursor = this.gJP.a(String.format("select %s from %s where %s=?", new Object[]{"desc", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
                if (cursor != null && cursor.moveToFirst()) {
                    z = true;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                x.w("MicroMsg.emoji.EmojiInfoDescStorage", e.toString());
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return z;
    }
}
