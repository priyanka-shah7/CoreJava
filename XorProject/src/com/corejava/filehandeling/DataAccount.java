package com.corejava.filehandeling;
import java.io.*;
 class Account{
	private int accNo;
	private String name;
	private double balance;
	public Account(int accNo, String name, double balance) {
		this.accNo = accNo;
		this.name = name;
		this.balance = balance;
	}

}
public class DataAccount {
	public static void main(String[] args)throws Exception {
	FileOutputStream fos=new FileOutputStream("D:/CoreJava/accDetails.txt");
	DataOutputStream dos=new DataOutputStream(fos);
	
	dos.writeInt(101);
	dos.writeUTF("ABC");
	dos.writeDouble(45.056);
	dos.writeInt(102);
	dos.writeUTF("PQR");
	dos.writeDouble(35.056);
	dos.flush();
	fos.flush();
	dos.close();
	fos.close();
	
	
	File file=new File("D:/CoreJava/accDetails.txt");
	FileInputStream fis = new FileInputStream(file);
	DataInputStream dis = new DataInputStream(fis); 
	int i=2;
	do {
		int id=dis.readInt();
		String name=dis.readUTF();
		Double balance=dis.readDouble();
		System.out.println("ID - "+id+" Name- "+name+" Balance - "+balance);
		i--;
	} while (i>0);

	dis.close();
	fis.close();
	}
}
