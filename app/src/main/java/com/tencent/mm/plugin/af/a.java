package com.tencent.mm.plugin.af;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

public final class a extends ContentObserver {
    private boolean hnr = false;
    private Context mContext;
    private ContentResolver qxW;
    private boolean qxX = false;
    private boolean qxY = false;
    public a qxZ;
    private long qya = 0;
    public String[] qyb;

    public a(Context context) {
        super(af.fetchFreeHandler());
        this.mContext = context;
    }

    public final void start() {
        this.qxX = false;
        this.qxY = false;
        this.hnr = false;
        boolean a = com.tencent.mm.pluginsdk.g.a.a((Activity) this.mContext, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "");
        x.i("MicroMsg.SmsVerifyObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bh.cgy(), this.mContext});
        try {
            long j;
            Uri parse = Uri.parse("content://sms/inbox");
            this.qxW = this.mContext.getContentResolver();
            String str = "( ";
            if (this.qyb != null) {
                int i = 0;
                while (i < this.qyb.length) {
                    String str2 = i == this.qyb.length + -1 ? str + " body like \"%" + this.qyb[i] + "%\" ) " : str + "body like \"%" + this.qyb[i] + "%\" or ";
                    i++;
                    str = str2;
                }
                x.v("MicroMsg.SmsVerifyObserver", "sql where:" + str);
            } else {
                str = "";
            }
            Cursor query = this.qxW.query(parse, new String[]{FFmpegMetadataRetriever.METADATA_KEY_DATE}, str, null, "date desc limit 1");
            if (query == null || query.getCount() <= 0) {
                j = 0;
            } else {
                query.moveToFirst();
                j = query.getLong(0);
            }
            if (query != null) {
                query.close();
            }
            this.qya = j;
            this.mContext.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
        }
    }

    public final void stop() {
        if (this.mContext != null) {
            try {
                this.mContext.getContentResolver().unregisterContentObserver(this);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
            }
        }
        this.hnr = true;
    }

    public final void onChange(boolean z) {
        String str = null;
        super.onChange(z);
        try {
            if (!this.qxX && !this.hnr && !this.qxY) {
                Uri parse = Uri.parse("content://sms/inbox");
                this.qxW = this.mContext.getContentResolver();
                String[] strArr = new String[]{"body", "_id", FFmpegMetadataRetriever.METADATA_KEY_DATE};
                String str2 = "( ";
                if (this.qyb != null) {
                    int i = 0;
                    while (i < this.qyb.length) {
                        str2 = i == this.qyb.length + -1 ? str2 + " body like \"%" + this.qyb[i] + "%\" ) " : str2 + "body like \"%" + this.qyb[i] + "%\" or ";
                        i++;
                    }
                    str = str2 + " and date > " + this.qya + " ";
                    x.v("MicroMsg.SmsVerifyObserver", "sql where:" + str);
                }
                if (str != null && !str.equals("")) {
                    Cursor query = this.qxW.query(parse, strArr, str, null, "date desc");
                    if (query != null) {
                        int i2 = -1;
                        long j = 0;
                        while (query.moveToNext()) {
                            int position;
                            long j2 = query.getLong(2);
                            if (j2 > j) {
                                position = query.getPosition();
                            } else {
                                j2 = j;
                                position = i2;
                            }
                            i2 = position;
                            j = j2;
                        }
                        if (i2 >= 0) {
                            query.moveToPosition(i2);
                            str2 = aC(0, query.getString(query.getColumnIndex("body")));
                            if (!bh.ov(str2) && str2.length() == 6) {
                                if (this.qxZ != null) {
                                    this.qxZ.si(str2);
                                }
                                this.qxY = true;
                            }
                        }
                        query.close();
                    }
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
        }
    }

    private String aC(int i, String str) {
        while (i < str.length()) {
            while (i < str.length() && !Character.isDigit(str.charAt(i))) {
                i++;
            }
            int i2 = i + 1;
            while (i2 < str.length() && Character.isDigit(str.charAt(i2))) {
                i2++;
            }
            String substring = str.substring(i, i2);
            x.v("MicroMsg.SmsVerifyObserver", "verify number from sms:" + substring);
            if (substring.length() == 6) {
                return substring;
            }
            i = i2 + 1;
        }
        return null;
    }
}
