package bankrun;

import java.util.*;

import CustomException;
import bankLogic.*;
import internetBanking.*;

public class CallBankLogic {

	BankCache log=new BankCache();
	
	public String userCredentails(int userId,String userName,int id) throws CustomException
	{
		 return log.loginDetails(userId,userName, id);
	}
	
	
	public String  customerDetailsAdd(CustomerPojo custom) throws CustomException
	{
		return log.addCustomerDetails(custom);
	}
	public CustomerPojo getCustomerInfo(int id) throws CustomException
	{
		return log.getCustomerDetails(id);
	}
	//opening Account in online
	public String openAccount(CustomerPojo custom) throws CustomException
	{
		return log.openAccount(custom);
	}
	
	
	public void addAccount(AccountPojo acc) throws CustomException
	{
		log.addAccountDetails( acc);
	}
	public AccountPojo getAccountDetails(int accId) throws CustomException
	{
		return log.getAccountDetails(accId);
	}
	public long balanceCheck(int accountid) throws CustomException
	{
		return log.balaceEnquiryCheck(accountid);
	}
	//7
	public void TransferDetails(int accId,long bal,AccountPojo acc,int accId1) throws Exception
	{
		log.amountWithdrawal(accId, bal, acc);
		log.depositMoney( bal,accId, acc);
	}
	
}
