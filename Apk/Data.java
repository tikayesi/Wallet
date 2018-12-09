package Apk;

public class Data {
	
	public String norek;
	public String nama;
	public String alamat;
	
	public Data() {
		
	}
	
	public Data(String norek) {
		this.norek=norek;
	}
	
	public Data(String norek, String nama, String alamat) {
		this.norek = norek;
		this.nama = nama;
		this.alamat = alamat;
	}
	
	public String getNorek() {
		return norek;
	}
	public String getNama() {
		return nama;
	}
	public String getAlamat() {
		return alamat;
	}
	
	
	public void setNorek(String norek) {
		this.norek = norek;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

}
