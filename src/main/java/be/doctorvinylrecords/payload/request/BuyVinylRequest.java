package be.doctorvinylrecords.payload.request;

import org.antlr.v4.runtime.misc.NotNull;

public class BuyVinylRequest {
    @NotNull
    private long accountId;
    @NotNull
    private long vinylId;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getVinylId() {
        return vinylId;
    }

    public void setVinylId(long vinylId) {
        this.vinylId = vinylId;
    }
}
