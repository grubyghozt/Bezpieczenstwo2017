package dao;

import bean.model.Transfer;

import java.util.Collection;

public interface TransferDao {
    void addTransfer(Transfer transfer);
    Transfer getTransferById(int id);
    Collection<Transfer> getAllTransfers(int userId);
}
