package dao;

import java.util.*;

import entity.BanEntity;
import utils.ConnectDB;

import java.sql.*;

public class BanDAO {
	public List<BanEntity> getAll() {
		List<BanEntity> list = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnect();
			String sql = "SELECT * FROM BAN";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				BanEntity ban = new BanEntity(result.getInt("id"), result.getString("maban"),
						result.getString("tenban"), result.getString("sothich"), result.getInt("gioitinh"));
				list.add(ban);
			}

		} catch (Exception e) {
			System.out.println("Có lỗi getAll: " + e.getMessage());
		}
		return list;
	}

	public void insert(BanEntity ban) {
		try {
			Connection conn = ConnectDB.getConnect();
			String sql = "INSERT INTO BAN (MABAN, TENBAN, SOTHICH, GIOITINH) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ban.getMaBan());
			ps.setString(2, ban.getTenBan());
			ps.setString(3, ban.getSoThich());
			ps.setInt(4, ban.getGioiTinh());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Có lỗi insert: " + e.getMessage());
		}
	}

	public void delete(int id) {
		try {
			Connection conn = ConnectDB.getConnect();
			String sql = "DELETE FROM BAN WHERE ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Có lỗi delete: " + e.getMessage());
		}
	}
}
