package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends i<m> implements a {
    public static final String[] gJN = new String[]{i.a(m.gJc, "EmotionRewardTipInfo")};
    private e gJP;

    public n(e eVar) {
        this(eVar, m.gJc, "EmotionRewardTipInfo");
    }

    private n(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gJP = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    public final m ckK() {
        Throwable e;
        Cursor a;
        try {
            a = this.gJP.a("select * from EmotionRewardTipInfo order by modifyTime desc limit 1 ", new String[0], 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        m mVar = new m();
                        mVar.b(a);
                        if (a == null) {
                            return mVar;
                        }
                        a.close();
                        return mVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.EmotionRewardTipStorage", "getLastSendProductID failed. :%s", new Object[]{bh.i(e)});
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.e("MicroMsg.emoji.EmotionRewardTipStorage", "getLastSendProductID failed. :%s", new Object[]{bh.i(e)});
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return null;
    }

    public final boolean dd(String str, int i) {
        if (bh.ov(str)) {
            x.w("MicroMsg.emoji.EmotionRewardTipStorage", "product id is null.");
            return false;
        }
        x.i("MicroMsg.emoji.EmotionRewardTipStorage", "updateFlag result:%b", new Object[]{Boolean.valueOf(this.gJP.fx("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'"))});
        return this.gJP.fx("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'");
    }

    public final boolean a(m mVar) {
        if (mVar == null) {
            x.w("MicroMsg.emoji.EmotionRewardTipStorage", "save failed info is null");
            return false;
        }
        long replace = this.gJP.replace("EmotionRewardTipInfo", "prodcutID", mVar.vI());
        if (replace > 0) {
            x.i("MicroMsg.emoji.EmotionRewardTipStorage", "save success");
        } else {
            x.i("MicroMsg.emoji.EmotionRewardTipStorage", "save failed");
        }
        if (replace > 0) {
            return true;
        }
        return false;
    }
}
