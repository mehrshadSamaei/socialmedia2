package com.example.socialmedia2.resources;

import com.example.socialmedia2.dto.AccountDto;
import com.example.socialmedia2.entity.AccountEntity;
import com.example.socialmedia2.mapper.AccountMapper;
import com.example.socialmedia2.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountRestController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping("/register-account")
    public ResponseEntity<AccountDto> addAccount(@Valid @RequestBody AccountDto accountDto){
        AccountEntity accountEntity = accountMapper.convertDtoToT(accountDto);
        return ResponseEntity.ok(
                accountMapper.convertTToDto(
                        accountService.saveOrUpdate(accountEntity)
                )
        );
    }
    @PutMapping("/update-info-account")
    public ResponseEntity<AccountDto> updateInfoAccount(@Valid @RequestBody AccountDto accountDto){
        AccountEntity accountEntity = accountMapper.convertDtoToT(accountDto);
        return ResponseEntity.ok(
                accountMapper.convertTToDto(
                        accountService.saveOrUpdate(accountEntity)
                )
        );
    }
    @GetMapping("/find-account-by-id")
    public ResponseEntity<AccountDto> findAccountById(@RequestParam Long id){
        return ResponseEntity.ok(
                accountMapper.convertTToDto(
                        accountService.findById(id)
                )
        );
    }
    @DeleteMapping("/delete-account-by-id/{id}")
    public void deleteAccountById(@PathVariable Long id){
        AccountEntity account = accountService.findById(id);
        accountService.deleteById(account.getId());
    }
//    @DeleteMapping("/delete-account")
//    public void deleteAccount(@RequestBody AccountDto accountDto){
//        AccountEntity accountEntity = accountMapper.convertDtoToT(accountDto);
//        accountService.deleteEntity(accountEntity);
//    }

}
