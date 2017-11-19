package bean.model;

import bean.security.User;

import javax.persistence.*;

@Entity
@Table(name = "TRANSFERS")
public class Transfer {

    @Id
    @GeneratedValue
    private int Id;

    private String accountNumber;
    private String receiver;
    private Double amount;


    @OneToOne
    @JoinColumn(name = "userId")
    private User sender;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}
