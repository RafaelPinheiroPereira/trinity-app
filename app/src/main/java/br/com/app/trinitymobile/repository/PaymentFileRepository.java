package br.com.app.trinitymobile.repository;

import br.com.app.trinitymobile.model.entity.Payment;
import br.com.app.trinitymobile.utils.Constants;
import br.com.app.trinitymobile.utils.PaymentFile;
import br.com.app.trinitymobile.utils.Singleton;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaymentFileRepository implements  IFileRepository {
     List<Payment> payments=new ArrayList<>();
     PaymentFile paymentFile;

    public PaymentFileRepository() throws IllegalAccessException, InstantiationException {
        paymentFile= Singleton.getInstance(PaymentFile.class);
    }

    @Override
    public void readFile() throws IOException, InstantiationException, IllegalAccessException {
        File file = paymentFile.createFile(Constants.APP_DIRECTORY, Constants.INPUT_FILES[7]);
        paymentFile.readFile(file);
        this.setPayments(paymentFile.getPayments());

    }

    public List<Payment> getPayments() {
        return payments;
    }

    private void setPayments(final List<Payment> payments) {
        this.payments = payments;
    }
}
