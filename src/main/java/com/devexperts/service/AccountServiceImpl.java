package com.devexperts.service;

import com.devexperts.account.Account;
import com.devexperts.account.AccountKey;
import com.devexperts.exceptions.AccountNotFoundException;
import com.devexperts.exceptions.AmountIsInvalidException;
import com.devexperts.exceptions.InsufficientAccountBalanceException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    private final Map<AccountKey, Account> accounts = new HashMap<>();

    @Override
    public void clear() {
        accounts.clear();
    }

    @Override
    public void createAccount(Account account) {
        if (!accounts.containsKey(account.getAccountKey())) {
            accounts.put(account.getAccountKey(), account);
        }
    }

    @Override
    public Account getAccount(long id) {
        return accounts.get(AccountKey.valueOf(id));
    }

    @Override
    public synchronized void transfer(Account source, Account target, double amount) throws InsufficientAccountBalanceException, AmountIsInvalidException, AccountNotFoundException {
        if (amount <= 0) {
            throw new AmountIsInvalidException("Amount is invalid");
        }

        if (source == null) {
            throw new AccountNotFoundException("Source account is not found");
        }

        if (target == null) {
            throw new AccountNotFoundException("Target account is not found");
        }

        if (source.getBalance() - amount >= 0) {
            source.setBalance(source.getBalance() - amount);
            target.setBalance(target.getBalance() + amount);
        } else {
            throw new InsufficientAccountBalanceException("Insufficient account balance");
        }
    }
}
