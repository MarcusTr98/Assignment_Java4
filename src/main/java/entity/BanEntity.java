package entity;

public class BanEntity {
	private int id;
	private String maBan, tenBan, soThich;
	private int gioiTinh;

	public BanEntity(int id, String maBan, String tenBan, String soThich, int gioiTinh) {
		super();
		this.id = id;
		this.maBan = maBan;
		this.tenBan = tenBan;
		this.soThich = soThich;
		this.gioiTinh = gioiTinh;
	}

	public BanEntity(String maBan, String tenBan, String soThich, int gioiTinh) {
		super();
		this.maBan = maBan;
		this.tenBan = tenBan;
		this.soThich = soThich;
		this.gioiTinh = gioiTinh;
	}

	public BanEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaBan() {
		return maBan;
	}

	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}

	public String getTenBan() {
		return tenBan;
	}

	public void setTenBan(String tenBan) {
		this.tenBan = tenBan;
	}

	public String getSoThich() {
		return soThich;
	}

	public void setSoThich(String soThich) {
		this.soThich = soThich;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

}
