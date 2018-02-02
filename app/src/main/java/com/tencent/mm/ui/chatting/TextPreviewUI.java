package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bx.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.z;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.i;

@a(3)
public class TextPreviewUI extends MMActivity {
    private TextView kO = null;
    private CharSequence text = null;
    private TextView ytG = null;
    private z yxM;
    private i yxN;
    private CharSequence yxO;
    private View yxP;
    private final int yxQ = 0;
    private final int yxR = 1;
    private final int yxS = 2;

    static /* synthetic */ void b(Context context, CharSequence charSequence) {
        Intent intent = new Intent(context, MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", charSequence);
        intent.putExtra("Retr_Msg_Type", 4);
        context.startActivity(intent);
    }

    protected final int getLayoutId() {
        return R.i.ddE;
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        if (d.fM(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.yxP = findViewById(R.h.cQC);
        this.text = getIntent().getCharSequenceExtra("key_chat_text");
        this.kO = (TextView) findViewById(R.h.cko);
        this.ytG = (TextView) findViewById(R.h.ckp);
        CharSequence charSequence = this.text;
        TextView textView = this.ytG;
        if (charSequence instanceof SpannableString) {
            textView.setText(((SpannableString) charSequence).toString());
            com.tencent.mm.pluginsdk.ui.d.i.f(textView, 1);
            charSequence = textView.getText();
        }
        this.text = charSequence;
        this.kO.setText(g.chg().a(this.mController.xIM, this.text, this.kO.getTextSize()));
        this.yxN = new i(this.mController.xIM, this.kO);
        this.yxN.zuo = true;
        this.yxN.zum = new 1(this);
        this.yxN.rKD = new 2(this);
        if (this.yxM == null) {
            z.a aVar = new z.a(this.kO, this.yxN);
            aVar.ygU = R.e.btH;
            aVar.yhf = 18.0f;
            aVar.ygV = R.e.brU;
            this.yxM = new z(aVar);
        }
        this.yxM.ygP = new 3(this);
        this.yxP.setOnClickListener(new 4(this));
        this.kO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TextPreviewUI yxT;

            {
                this.yxT = r1;
            }

            public final void onClick(View view) {
                if (this.yxT.yxM == null) {
                    return;
                }
                if (this.yxT.yxM.fJl) {
                    this.yxT.finish();
                    return;
                }
                this.yxT.yxM.cqd();
                this.yxT.yxM.cqc();
            }
        });
        setBackBtn(new 6(this));
    }

    protected void onResume() {
        super.onResume();
        if (this.yxM != null && !this.yxM.fJl) {
            this.yxM.cqe();
        }
    }

    public void onBackPressed() {
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
