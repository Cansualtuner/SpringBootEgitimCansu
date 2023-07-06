package com.folksdev.account.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.UUIDGenerator")
    private String id;

    private BigDecimal balance;

    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Transaction> transaction;

    public Account(String id, BigDecimal balance, LocalDateTime creationDate, Customer customer, Set<Transaction> transaction) {
        this.id = id;
        this.balance = balance;
        this.creationDate = creationDate;
        this.customer = customer;
        this.transaction = transaction;
    }

    public Account(BigDecimal initialCredit, LocalDateTime now, Customer customer) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(id, account.id) && Objects.equals(balance, account.balance)
                && Objects.equals(creationDate, account.creationDate) &&
                Objects.equals(customer, account.customer) &&
                Objects.equals(transaction, account.transaction);
    }
//hashcode algoritması
    @Override
    public int hashCode() {
        return Objects.hash(id, balance, creationDate, customer, transaction);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<Transaction> transaction) {
        this.transaction = transaction;
    }
}



//    override fun equels(other:Any?): Boolean {
//        if (this == other) {
//            return true
//        }
//        if (javaClass != other?.javaClass){
//            return false
//        other as Account
//        if (id != other.id) {
//            return false
//        }
//        if (balance != other.balance){
//            return false
//        } if (creationDate != other.creationDate){
//            return false
//        } if (customer != other.customer){
//            return false
//        } if (transaction != other.balance){
//            return false
//        }else{
//            return true
//        }



