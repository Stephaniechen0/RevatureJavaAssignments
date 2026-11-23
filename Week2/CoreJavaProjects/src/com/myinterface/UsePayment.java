package com.myinterface;

public class UsePayment {
	public static void main(String[] args) {
		CreditCardPayment ccp = new CreditCardPayment();
		ccp.pay(200);
		
		UPIPayment upi = new UPIPayment();
		upi.pay(200);
		
		Payment p = new UPIPayment();
		p.pay(4000);
		
		System.out.println(p.minPayment);
		System.out.println(Payment.minPayment);
		
		// variables in interface are by default FINAL
//		Payment.minPayment = 2;
		
		
		
	}
}
