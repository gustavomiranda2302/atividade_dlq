package servico.auditor.dlq.dto;

import java.util.List;

public class EventoOrdemDTO {

    private String zipCode;
    private long customerId;
    private List<ItensDTO> orderItems;
    private String origin;
    private String occurredAt;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public List<ItensDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<ItensDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(String occurredAt) {
        this.occurredAt = occurredAt;
    }
}
