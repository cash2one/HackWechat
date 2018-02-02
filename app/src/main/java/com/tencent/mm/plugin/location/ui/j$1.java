package com.tencent.mm.plugin.location.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.r;

class j$1 extends af {
    final /* synthetic */ j nUq;

    j$1(j jVar, Looper looper) {
        this.nUq = jVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        j jVar;
        Message obtain;
        String gu;
        switch (message.what) {
            case 1:
                this.nUq.FN.setText(this.nUq.nUp);
                return;
            case 2:
                x.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", new Object[]{Boolean.valueOf(this.nUq.nTU), Boolean.valueOf(this.nUq.nUo)});
                if (!this.nUq.nTU && !this.nUq.nUo) {
                    jVar = this.nUq;
                    jVar.FN.setTextColor(jVar.nUl);
                    jVar.FN.invalidate();
                    int intValue = ((Integer) message.obj).intValue();
                    if (intValue == 0) {
                        this.nUq.FN.setText(this.nUq.context.getString(R.l.eRl));
                        return;
                    }
                    this.nUq.FN.setText(this.nUq.context.getResources().getQuantityString(R.j.duL, intValue, new Object[]{Integer.valueOf(intValue)}));
                    return;
                }
                return;
            case 3:
                if (this.nUq.nUo || this.nUq.nTU) {
                    removeMessages(3);
                    obtain = Message.obtain();
                    obtain.what = 3;
                    obtain.obj = message.obj;
                    sendMessage(obtain);
                    return;
                }
                this.nUq.nUp = this.nUq.FN.getText().toString();
                j.a(this.nUq);
                gu = r.gu((String) message.obj);
                this.nUq.FN.setText(this.nUq.context.getString(R.l.eRr, new Object[]{gu}));
                if (this.nUq.nTU || this.nUq.nUo) {
                    j.b(this.nUq);
                    return;
                }
                return;
            case 4:
                if (this.nUq.nUo || this.nUq.nTU) {
                    removeMessages(4);
                    obtain = Message.obtain();
                    obtain.what = 4;
                    obtain.obj = message.obj;
                    sendMessage(obtain);
                    return;
                }
                this.nUq.nUp = this.nUq.FN.getText().toString();
                j.a(this.nUq);
                gu = r.gu((String) message.obj);
                this.nUq.FN.setText(this.nUq.context.getString(R.l.eRs, new Object[]{gu}));
                if (this.nUq.nTU || this.nUq.nUo) {
                    j.b(this.nUq);
                    return;
                }
                return;
            case 5:
                this.nUq.nUo = true;
                this.nUq.nTU = false;
                j.a(this.nUq);
                gu = r.gu((String) message.obj);
                this.nUq.FN.setText(this.nUq.context.getString(R.l.eRt, new Object[]{gu}));
                return;
            case 6:
                this.nUq.nTU = true;
                this.nUq.nUo = false;
                j.a(this.nUq);
                this.nUq.FN.setText(this.nUq.context.getString(R.l.eRq));
                return;
            case 7:
                this.nUq.nUo = true;
                jVar = this.nUq;
                jVar.FN.setTextColor(jVar.nUm);
                jVar.FN.invalidate();
                this.nUq.FN.setText(this.nUq.context.getString(R.l.eRu));
                this.nUq.nUp = this.nUq.FN.getText().toString();
                j.b(this.nUq);
                return;
            case 8:
                jVar = this.nUq;
                jVar.FN.setTextColor(jVar.nUn);
                jVar.FN.invalidate();
                this.nUq.FN.setText(this.nUq.context.getString(R.l.eRv));
                return;
            case 9:
                this.nUq.nTU = false;
                if (!this.nUq.nUo) {
                    this.nUq.gn(true);
                    return;
                }
                return;
            case 10:
                this.nUq.nUo = false;
                this.nUq.gn(false);
                return;
            default:
                return;
        }
    }
}
