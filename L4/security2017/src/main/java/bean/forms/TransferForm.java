package bean.forms;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TransferForm {

    @NotBlank
    @Pattern(regexp = "[0-9]+", message = "Account number should contain numbers")
    private String accountNumber;
    @NotBlank
    private String receiver;

    @NotNull(message = "may not be blank")
    @Digits(integer = 20, fraction = 2)
    private Double amount;

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
}
