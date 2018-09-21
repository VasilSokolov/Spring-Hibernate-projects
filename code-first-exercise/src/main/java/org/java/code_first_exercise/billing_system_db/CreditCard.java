package org.java.code_first_exercise.billing_system_db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BasicBillingDetail {

    private CreditCardType cardType;
    private Date expirationMonth;
    private Date expirationYear;

    public CreditCard() {
    }

    @Column(name = "card_type")
    @Enumerated
    public CreditCardType getCardType() {
        return cardType;
    }

    public void setCardType(CreditCardType cardType) {
        this.cardType = cardType;
    }

    @Column(name = "expiration_month")
    public Date getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Date expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Column(name = "expiration_year")
    public Date getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Date expirationYear) {
        this.expirationYear = expirationYear;
    }
}
