package dao;

import bean.model.Transfer;
import bean.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Collection;

@Component
public class TransferDaoImpl implements TransferDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void addTransfer(Transfer transfer) {
        entityManager.persist(transfer);
    }

    @Override
    public Transfer getTransferById(int id) {
        return entityManager.find(Transfer.class, id);
    }

    @Override
    public Collection<Transfer> getAllTransfers(int userId) {
        return entityManager.createQuery("SELECT trans FROM "+Transfer.class.getName()+" trans JOIN "+User.class.getName()+" u ON trans.sender=u.Id WHERE u.id='"+userId+"'",Transfer.class).getResultList();
    }
}
