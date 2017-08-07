package ca.deos.mail.service;

import ca.deos.store.domain.EmailObject;
import ca.deos.store.entity.Order;

import java.io.IOException;

public interface ReceiptService {

    public String getReceiptContactUs(EmailObject emailObject) throws IOException;

    public String getReceiptOrder(Order order) throws  IOException;
}
