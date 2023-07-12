package com.example.cashcard.repository;


import com.example.cashcard.bean.CashCard;
import org.springframework.data.repository.CrudRepository;

/**
 * the interface between the application and the database,
 * providing a common abstraction for any database
 */
public interface CashCardRepository extends CrudRepository<CashCard, Long> {


}
