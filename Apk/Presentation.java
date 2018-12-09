package Apk;
import java.util.Scanner;
import Apk.Bisnis;
import Apk.Data;

import java.util.List;

public class Presentation {
	
	Scanner input = new Scanner(System.in);
	
	String username;
	String password;
	
	public void login() {
		System.out.println("Username: ");
		username = input.next();
		System.out.println("Password: ");
		password = input.next();
		
		if (username.equals("admin") && password.equals("admin")) {
			menu();
		} else {
			System.out.println("Login Failed!");
			login();
		}
		
	}
	public void menu() {
		System.out.println("Choose for menu: ");
		System.out.println("1. Input Data");
		System.out.println("2. View Data");
		System.out.println("3. Update Data");
		System.out.println("4. Delete Data");
		System.out.println("5. Exit!");
		
		int a = input.nextInt();		
    	try {
			switch(a) {
			case 1 :
				add();
				menu();
				break;
			case 2 :
				view();
				menu();
				break;
			case 3 :
				update();
				menu();
				break;
			case 4 :
				delete();
				menu();
				break;
			case 5 :
				System.out.println("Good Bye from my APK");
				System.exit(0);
				break;
			default:
				System.out.println("not number this Choose menu");
				menu();
				break;
			}
		}catch(Exception e){
			System.out.println("Your inserted is wrong!");
			menu();
		}
    }
	
	private String add() {
    	Bisnis bisn = new Bisnis();
    	Scanner input = new Scanner(System.in);
    	
    	System.out.print("norek :");
		String norek = input.nextLine();
		Scanner in = new Scanner(System.in);
		System.out.print("nama :");
		String nama = in.nextLine();
		System.out.print("alamat :");
		String alamat = input.nextLine();
		
		Data data = new Data (norek,nama,alamat);
		String data2 = bisn.insertData(data);
		System.out.println(data2);
		return data2;
	}
	
	private List<Data> view() {
		Bisnis data2 = new Bisnis();
		List<Data> list = data2.view();
		for(Data data : list) {
			System.out.println("---------------------------------");
			System.out.println("NOREK : "+data.getNorek());
			System.out.println("NAMA  : "+data.getNama());
			System.out.println("ALAMAT: "+data.getAlamat());
			System.out.println("---------------------------------");
		}
		return list;
	}
	
	private String update() {
		Scanner in = new Scanner(System.in);
    	Bisnis bisn = new Bisnis();
    	
    	System.out.print("norek :");
		String norek = in.nextLine();

		System.out.print("nama :");
		String nama = in.nextLine();
		System.out.print("alamat :");
		String alamat = in.nextLine();
		
		Data data = new Data(norek,nama,alamat);
		String data2 = bisn.updateData(data);
		System.out.println(data2);
		return data2;
	}
	
	private String delete() {
		Scanner in = new Scanner(System.in);
    	Bisnis bisn = new Bisnis();
    	
    	System.out.print("norek :");
		String norek = in.nextLine();
		
		Data data = new Data(norek);
		String data2 = bisn.deleteData(data);
		System.out.println(data2);
		return data2;
	}
}


