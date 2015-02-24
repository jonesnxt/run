package run;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.security.SecureRandom;
import java.util.Scanner;

import crypto.Convert;
import crypto.Crypto;

public class Backend {

	String passphrase;
	long accountId;
	String accountRS;
	byte[] publicKey;
	public Backend() {
		passphrase = "";
		backInit();
	}
	
	public void backInit()
	{
		// check file exists to first time
		File f = new File("nxt.pass");
		if(f.exists() && !f.isDirectory()) {
			// it exists, read it and make us an RS
			Scanner sc;
			try {
				sc = new Scanner(new File("nxt.pass"));
				while(sc.hasNextLine()){
				    passphrase += sc.nextLine();                     
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			// we don't have a file, make one with randdata
			String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			for(int i=0;i<100;i++)
			{
				SecureRandom r = new SecureRandom();
				passphrase += alphabet.charAt(r.nextInt(alphabet.length()));
			}
			Writer writer = null;

			try {
			    writer = new BufferedWriter(new OutputStreamWriter(
			          new FileOutputStream("nxt.pass"), "utf-8"));
			    writer.write(passphrase);
			} catch (IOException ex) {
			  // report
			} finally {
			   try {writer.close();} catch (Exception ex) {}
			}
			
		}
		
		System.out.println(passphrase);		
		
		publicKey = Crypto.getPublicKey(passphrase);
		accountId = Convert.fullHashToId(Crypto.sha256().digest(publicKey));
		accountRS = Convert.rsAccount(accountId);
		System.out.println(accountRS);
	}
	
}
