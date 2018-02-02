package com.tencent.mm.plugin.gms;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.google.android.gms.auth.a;
import com.google.android.gms.auth.b;
import com.google.android.gms.auth.c;
import com.google.android.gms.auth.d;
import java.io.IOException;

class MMGoogleAuthUtil$a extends AsyncTask<Void, Void, Void> {
    private String jey;
    private String jgk;
    private Context mContext;
    private int mErrorCode;
    private String nzA;
    final /* synthetic */ MMGoogleAuthUtil nzB;
    private boolean nzy = false;
    private boolean nzz;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return aSm();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Void) obj);
        if (!this.nzy) {
            Intent intent;
            if (this.nzz) {
                intent = new Intent();
                intent.putExtra("error_code", 0);
                intent.putExtra("token", MMGoogleAuthUtil.a(this.nzB));
                this.nzB.setResult(-1, intent);
                this.nzB.finish();
                return;
            }
            intent = new Intent();
            intent.putExtra("error_code", -1);
            intent.putExtra("error_msg", this.jey);
            this.nzB.setResult(-1, intent);
            this.nzB.finish();
        }
    }

    public MMGoogleAuthUtil$a(MMGoogleAuthUtil mMGoogleAuthUtil, Context context, String str, String str2) {
        this.nzB = mMGoogleAuthUtil;
        this.mContext = context;
        this.nzA = str;
        this.jgk = str2;
        this.nzy = false;
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        this.nzz = false;
    }

    private Void aSm() {
        try {
            MMGoogleAuthUtil.a(this.nzB, b.d(this.mContext, this.nzA, this.jgk));
            this.nzz = true;
            this.mErrorCode = 0;
        } catch (c e) {
            this.jey = e.getMessage();
            this.mErrorCode = -2;
        } catch (d e2) {
            d dVar = e2;
            this.jey = dVar.getMessage();
            this.mErrorCode = -3;
            if (this.nzB.nzx < 4) {
                MMGoogleAuthUtil mMGoogleAuthUtil = this.nzB;
                mMGoogleAuthUtil.nzx++;
                this.nzy = true;
                this.nzB.startActivityForResult(dVar.Ks == null ? null : new Intent(dVar.Ks), 2002);
            }
        } catch (IOException e3) {
            this.jey = e3.getMessage();
            this.mErrorCode = -4;
        } catch (a e4) {
            this.jey = e4.getMessage();
            this.mErrorCode = -5;
        } catch (Exception e5) {
            this.jey = e5.getMessage();
            this.mErrorCode = -1;
        }
        return null;
    }
}
