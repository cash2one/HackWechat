package com.tencent.mm.plugin.music.model.b;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.music.model.h.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.BitSet;

public final class c {
    public int count = 0;
    public long ieE = -1;
    public String mUrl;
    public BitSet oLf = new BitSet();
    public String oLg = "";

    public c(String str) {
        this.mUrl = str;
    }

    public final void bek() {
        int i = 0;
        if (!TextUtils.isEmpty(this.oLg)) {
            BitSet bitSet = this.oLf;
            byte[] bArr = new byte[(bitSet.size() / 8)];
            for (int i2 = 0; i2 < bitSet.size(); i2++) {
                int i3 = i2 / 8;
                bArr[i3] = (byte) (((bitSet.get(i2) ? 1 : 0) << (7 - (i2 % 8))) | bArr[i3]);
            }
            h.bdD().p(this.oLg, bArr);
        }
        x.d("MicroMsg.IndexBitMgr", "saveBitCache bitSet:%s", new Object[]{this.oLf.toString()});
        x.i("MicroMsg.IndexBitMgr", "saveBitCache bitSet count %d, cardinality:" + this.count + "," + this.oLf.cardinality());
        x.i("MicroMsg.IndexBitMgr", "isCacheComplete, count:%d, cardinality:%d", new Object[]{Integer.valueOf(this.count), Integer.valueOf(this.oLf.cardinality())});
        if (this.count > 0 && this.count == this.oLf.cardinality()) {
            i = 1;
        }
        if (i != 0) {
            tx(1);
        }
    }

    public final void clearCache() {
        x.i("MicroMsg.IndexBitMgr", "clearCache");
        this.oLf = new BitSet(this.count);
        tx(0);
        if (!TextUtils.isEmpty(this.oLg)) {
            h.bdD().p(this.oLg, null);
        }
    }

    private void tx(int i) {
        x.i("MicroMsg.IndexBitMgr", "setFileCacheComplete %d", new Object[]{Integer.valueOf(i)});
        if (!TextUtils.isEmpty(this.oLg)) {
            com.tencent.mm.plugin.music.model.h.c bdD = h.bdD();
            String str = this.oLg;
            ContentValues contentValues = new ContentValues();
            contentValues.put("fileCacheComplete", Integer.valueOf(i));
            int update = bdD.gJP.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{str});
            x.i("MicroMsg.PieceMusicInfoStorage", "updateMusicFileCacheComplete raw=%d musicId=%s fileCacheComplete=%d", new Object[]{Integer.valueOf(update), str, Integer.valueOf(i)});
            b bVar = (b) bdD.oMR.get(str);
            if (bVar != null) {
                bVar.field_fileCacheComplete = i;
            }
        }
    }

    public final int getIndex(int i) {
        if (((long) i) <= this.ieE) {
            return i / 8192;
        }
        x.e("MicroMsg.IndexBitMgr", "getIndex, offset is invalid, offset:%d, fileLength:%d", new Object[]{Integer.valueOf(i), Long.valueOf(this.ieE)});
        return 0;
    }

    public final boolean ty(int i) {
        return this.oLf.get(i);
    }

    public final void tz(int i) {
        this.oLf.set(i);
    }

    public final boolean cT(int i, int i2) {
        if (i < 0 || i2 < 0 || ((long) i) > this.ieE || ((long) (i + i2)) > this.ieE) {
            x.e("MicroMsg.IndexBitMgr", "canReadFromCache offset %d, size %d, fileLength %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(this.ieE)});
            x.e("MicroMsg.IndexBitMgr", "canReadFromCache invalid parameter!");
            return false;
        }
        int index = getIndex(i);
        int index2 = getIndex(i + i2);
        int i3 = index;
        while (i3 <= index2) {
            if (ty(index)) {
                i3++;
            } else {
                x.d("MicroMsg.IndexBitMgr", "index %d, indexBit 0", new Object[]{Integer.valueOf(i3)});
                return false;
            }
        }
        return true;
    }
}
