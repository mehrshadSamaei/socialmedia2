package com.example.socialmedia2.repositorytest;

import com.example.socialmedia2.entity.AccountEntity;
import com.example.socialmedia2.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AccountRepository underTest;

    @Test
    void itShouldCheckedIfExistAccountByFindUsername() {
// given
        AccountEntity account = new AccountEntity(
                "merhshad", "samaei", "m74", "123456"
        );
        underTest.save(account);
//        when
        AccountEntity accountEntity = underTest.findByUsername("m74");
//                  then
        Assertions.assertEquals(accountEntity , "m74");
    }
}
