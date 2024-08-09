package com.cbfacademy.restapiexercise.ious;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //corresponds to a table in database
@Table(name = "ious") // name of the table in database
// creating fields
public class IOU {
  @Id // 'id' field is the primary key of the entity
  @GeneratedValue(strategy = GenerationType.UUID) //primary key values should be generated as UUIDs
  private UUID id;
  private String borrower;
  private String lender;
  private BigDecimal amount;
  private Instant dateTime;

  // default constructors (no-arg)
  public IOU() {
    this(null, null, BigDecimal.ZERO, Instant.now());
  }
  // parametrized constructors
  public IOU(String borrower, String lender, BigDecimal amount, Instant dateTime) {
    this.borrower = borrower;
    this.lender = lender;
    this.amount = amount;
    this.dateTime = dateTime;
  }
// getters and setters
  public UUID getId() {
    return this.id;
  }
  
  public String getBorrower() {
    return this.borrower;
  }

  public void setBorrower(String borrower) {
    this.borrower = borrower;
  }

  public String getLender() {
    return this.lender;
  }

  public void setLender(String lender) {
    this.lender = lender;
  }

  public BigDecimal getAmount() {
    return this.amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Instant getDateTime() {
    return this.dateTime;
  }

  public void setDateTime(Instant dateTime) {
    this.dateTime = dateTime;
  }
}