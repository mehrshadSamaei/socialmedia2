package com.example.socialmedia2.servicetest;

import com.example.socialmedia2.entity.AccountEntity;
import com.example.socialmedia2.repository.AccountRepository;
import com.example.socialmedia2.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
//@SpringBootTest
//@Testcontainers
public class AccountServiceTest {
    AccountEntity account = new AccountEntity();




    @MockBean
    AccountRepository accountRepository;


    @InjectMocks
    AccountServiceImpl accountService;

    @Test
    public void testFindById(){
        AccountEntity accountEntity = accountService.findById(1L);

        Assertions.assertEquals(account.getFName(),"mehrshad");

    }
    @Test
    public void testFindAll(){
        List<AccountEntity> accountEntityList = accountRepository.findAll();
    }

}
