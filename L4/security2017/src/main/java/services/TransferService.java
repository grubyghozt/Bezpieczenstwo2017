package services;

import bean.forms.TransferForm;
import bean.model.Transfer;
import bean.security.User;

import java.util.Collection;

public interface TransferService {
    void addTransfer(TransferForm transferForm);
    Collection<Transfer> getAllTransfers(User user);
}
