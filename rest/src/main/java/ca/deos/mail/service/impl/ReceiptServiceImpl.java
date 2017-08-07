package ca.deos.mail.service.impl;

import ca.deos.mail.service.ReceiptService;
import ca.deos.store.domain.EmailObject;
import ca.deos.store.entity.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.jboss.logging.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    ObjectMapper objectMapper;

    Logger log = Logger.getLogger(this.getClass());

    @Override
    public String getReceiptContactUs(EmailObject emailObject) throws IOException {

        VelocityContext context = new VelocityContext();
        context.put("name", emailObject.getName());
        context.put("number", emailObject.getNumber());
        context.put("from", emailObject.getFrom());
        context.put("text",emailObject.getText());
        return getTemplaterResult(context, "templates/contact-us.html");
    }

    @Override
    public String getReceiptOrder(Order order) throws IOException {
        VelocityContext context = new VelocityContext();
        JSONObject json = new JSONObject(order.getClient_address());
        String address = json.getString("address") +" " + json.getString("postal") + " delivery instructions:" + json.getString("delivery_instructions");
        log.debug("userAddress "+ address);
        context.put("id",order.getId());
        context.put("restaurant", order.getRes_name());
        context.put("time",order.getOrder_time());
        context.put("day", order.getOrder_day());
        context.put("delivery",order.getShip_via());
        context.put("client", order.getClient_name());
        context.put("address", address);
        context.put("fee", order.getService_fee());
        context.put("amount",order.getOrder_amount());
        context.put("status", order.getStatus());
        context.put("orderDetails", order.getOrderDetails());

        return getTemplaterResult(context, "templates/order.html");
    }

    private String getTemplaterResult(VelocityContext velocityContext, String templateFile) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        Template template = velocityEngine.getTemplate(templateFile, "UTF-8");
        StringWriter writer = new StringWriter();
        template.merge(velocityContext, writer);
        return writer.toString();
    }
}
