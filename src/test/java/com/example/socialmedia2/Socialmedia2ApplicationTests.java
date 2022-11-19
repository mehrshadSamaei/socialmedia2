package com.example.socialmedia2;

import com.example.socialmedia2.entity.AccountEntity;
import com.example.socialmedia2.repository.AccountRepository;
import com.example.socialmedia2.service.AccountService;
import com.example.socialmedia2.service.impl.AccountServiceImpl;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@DataJpaTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Socialmedia2Application.class)
//@TestPropertySource(locations = "classpath:application.properties")'
//@SpringBootTest
class Socialmedia2ApplicationTests {
    Calculate cal = new Calculate();

    @Test
    void addCalculate() {
//        given
        int numOne = 5;
        int numTwo = 6;
        // when
        int add = cal.add(numOne, numTwo);

//        then
        assertThat(add).isEqualTo(11);
    }

    @Test
    void contextLoads() {
    }

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    AccountEntity accountEntity = new AccountEntity("mehrshad", "samaei", "m714", "123456");
    List<AccountEntity> accountEntityList = new ArrayList<>();

    @Test
    public void saveAccountAdd() {
        when(this.accountRepository.save(accountEntity)).thenReturn(accountEntity);
    }

    @Test
    public void getAccountById() {
        when(this.accountRepository.getById(accountEntity.getId())).thenReturn(accountEntity);
    }

    @Test
    public void getAllAccounts() {
        when(this.accountRepository.findAll()).thenReturn(accountEntityList);
    }
}

class Calculate {
    int add(int a, int b) {
        return a + b;
    }
}
