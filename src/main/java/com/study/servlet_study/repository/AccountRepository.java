package com.study.servlet_study.repository;
// 이게 싱글톤이다.

import java.util.ArrayList;
import java.util.List;

import com.study.servlet_study.entity.Account;
	
public class AccountRepository {
	private List<Account> accountList;
	private static AccountRepository instance;
	
	private AccountRepository() {
		accountList = new ArrayList<>();	
	}
	public static AccountRepository getInstance() { 
		if(instance == null) {
			instance = new AccountRepository();
		}
		
		return instance;
	}
	
	public int saveAccount(Account account) {
		accountList.add(account);            // 
		return 1;   // 서비스로 간다.
	}
	public Account findAccountByUsername(String username) {
		Account findAccount = null;
		
		for(Account account : accountList) {
			if(account.getUsername().equals(username)) {
				findAccount = account; 
				break;  // 반복을 끝까지 돌 필요 없다
			}
		}
		return findAccount;  // 못 찾으면 null을 리턴
	}
}
