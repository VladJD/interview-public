package com.devexperts.account;

import java.util.Objects;

/**
 * Unique Account identifier
 *
 * <p>
 * NOTE: we suspect that later {@link #accountId} is not going to be uniquely identifying an account,
 * as we might add human-readable account representation and some clearing codes for partners.
 * */
public class AccountKey {
    private final long accountId;

    public AccountKey(long accountId) {
        this.accountId = accountId;
    }

    public static AccountKey valueOf(long accountId) {
        return new AccountKey(accountId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountKey accountKey = (AccountKey) o;
        return accountId == accountKey.accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }
}
