package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.wcdb.database.SQLiteDatabase;

public class CommonActivityTask extends GameProcessActivityTask {
    public static final Creator<CommonActivityTask> CREATOR = new 3();
    public Bundle msB;
    public int type;

    public final void a(Context context, a aVar) {
        String string;
        String string2;
        switch (this.type) {
            case 1:
                string = this.msB.getString("result");
                if (!bh.ov(string)) {
                    string2 = this.msB.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    int i = this.msB.getInt("codeType");
                    int i2 = this.msB.getInt("codeVersion");
                    Intent intent = new Intent();
                    intent.setClass(context, WebviewScanImageActivity.class);
                    intent.setFlags(603979776);
                    intent.putExtra("key_string_for_scan", string);
                    intent.putExtra("key_string_for_url", string2);
                    intent.putExtra("key_codetype_for_scan", i);
                    intent.putExtra("key_codeversion_for_scan", i2);
                    context.startActivity(intent);
                    aVar.afh();
                    return;
                }
                return;
            case 2:
                string2 = this.msB.getString("img_path");
                if (p.UR(string2)) {
                    EmojiInfo yc = ((c) g.k(c.class)).getEmojiMgr().yc(com.tencent.mm.a.g.bV(string2));
                    EmojiInfo yc2 = (yc == null || !yc.cks()) ? ((c) g.k(c.class)).getEmojiMgr().yc(((c) g.k(c.class)).getEmojiMgr().yd(string2)) : yc;
                    boolean bN = yc2 == null ? false : e.bN(yc2.ckB());
                    string = yc2 == null ? string2 : yc2.ckB();
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    boolean z = (d.decodeFile(string, options) != null && options.outHeight > b.zE()) || options.outWidth > b.zE();
                    if (bN > b.zF() || z) {
                        h.a(context, context.getString(R.l.dZJ), "", context.getString(R.l.epk), null);
                        h.a(context, context.getString(R.l.dZJ), "", context.getString(R.l.epk), "", false, new 1(this, aVar), new 2(this, aVar));
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("Retr_File_Name", yc2 != null ? yc2.Nr() : "");
                    intent2.putExtra("Retr_Msg_Type", 5);
                    intent2.putExtra("Retr_MsgImgScene", 1);
                    com.tencent.mm.plugin.webview.a.a.ifs.l(intent2, context);
                    aVar.afh();
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("Retr_File_Name", string2);
                intent3.putExtra("Retr_Compress_Type", 0);
                intent3.putExtra("Retr_Msg_Type", 0);
                intent3.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                com.tencent.mm.plugin.webview.a.a.ifs.l(intent3, context);
                aVar.afh();
                return;
            default:
                return;
        }
    }

    public final void Ys() {
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.msB = parcel.readBundle(getClass().getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeBundle(this.msB);
    }

    public CommonActivityTask(Context context) {
        super(context);
        this.msB = new Bundle();
    }

    private CommonActivityTask(Parcel parcel) {
        this.msB = new Bundle();
        f(parcel);
    }
}
