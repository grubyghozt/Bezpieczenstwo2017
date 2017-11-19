package services;

import bean.forms.TransferForm;
import bean.model.Transfer;
import bean.security.User;
import dao.TransferDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferDao transferDao;

    @Override
    public void addTransfer(TransferForm transferForm) {
        Transfer transfer = new Transfer();
        transfer.setAccountNumber(transferForm.getAccountNumber());
        transfer.setReceiver(transferForm.getReceiver());
        transfer.setAmount(transferForm.getAmount());
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        transfer.setSender(user);

        transferDao.addTransfer(transfer);
    }

    @Override
    public Collection<Transfer> getAllTransfers(User user) {
        return transferDao.getAllTransfers(user.getId());
    }
}
