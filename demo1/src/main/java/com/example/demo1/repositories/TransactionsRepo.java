package com.example.demo1.repositories;



import com.example.demo1.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transaction;
import java.util.List;

@Repository
public interface TransactionsRepo extends JpaRepository<Transactions,Long> {
    @Query(value="select * from transactions t where lower(concat(t.description,t.date)) like %:s% or lower(concat(t.date,t.description,t.date)) like %:s%",nativeQuery = true)
    List<Transactions> searchByString(@Param("s") String s);
}
