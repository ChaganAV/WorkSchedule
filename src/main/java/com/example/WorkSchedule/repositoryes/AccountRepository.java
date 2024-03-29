package com.example.WorkSchedule.repositoryes;

import com.example.WorkSchedule.models.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account,Long> {
    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountsByName(String name);

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAmount(long id, BigDecimal amount);

    @Modifying
    @Query("INSERT INTO account (name,amount) VALUES(:name, :amount)")
    void addAmount(String name, BigDecimal amount);

    @Modifying
    @Query("DELETE FROM account WHERE id = :id")
    void deleteAmount(long id);
}
