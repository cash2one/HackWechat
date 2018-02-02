package com.tencent.mm.ui.account;

import com.google.android.search.verification.client.SearchActionVerificationClientActivity;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.mm.modelvoiceaction.VoiceActionService;
import com.tencent.mm.sdk.platformtools.x;

public class VoiceActionActivity extends SearchActionVerificationClientActivity {
    public final Class<? extends SearchActionVerificationClientService> ru() {
        x.d("MicroMsg.VoiceActionActivity", "getServiceClass");
        return VoiceActionService.class;
    }
}
