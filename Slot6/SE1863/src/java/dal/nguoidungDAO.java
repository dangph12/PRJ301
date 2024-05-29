package dal;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.nguoidung;

public class nguoidungDAO extends DBContext {

    public List<nguoidung> getAll() {
        PreparedStatement stm;
        ResultSet rs;
        List<nguoidung> list = new ArrayList<>();
        try {
            String strSelect = "select * from tbnguoidung";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                nguoidung nd = new nguoidung(rs.getString("tensudung"), rs.getString("matkhau"), rs.getString("masinhvien"), rs.getString("lop"));
                list.add(nd);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<nguoidung> searchByName(String name) {
        PreparedStatement stm;
        ResultSet rs;
        List<nguoidung> list = new ArrayList<>();
        try {
            String strSelect = "select * from tbnguoidung where [tensudung] = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, name);
            rs = stm.executeQuery();
            while (rs.next()) {
                nguoidung nd = new nguoidung(rs.getString("tensudung"), rs.getString("matkhau"), rs.getString("masinhvien"), rs.getString("lop"));
                list.add(nd);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public nguoidung searchByName2(String name) {
        PreparedStatement stm;
        ResultSet rs;
        nguoidung nd = null;
        try {
            String strSelect = "select * from tbnguoidung where [tensudung] = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, name);
            rs = stm.executeQuery();
            while (rs.next()) {
                nd = new nguoidung(rs.getString("tensudung"), rs.getString("matkhau"), rs.getString("masinhvien"), rs.getString("lop"));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return nd;
    }

    public void addNew(HttpServletRequest request) {
        try {
            String strSelect = "insert tbnguoidung values (?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(strSelect);
            stm.setString(1, request.getParameter("username"));
            stm.setString(2, request.getParameter("password"));
            stm.setString(3, request.getParameter("code"));
            stm.setString(4, request.getParameter("class"));
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void remove(HttpServletRequest request) {
        try {
            String strSelect = "delete from tbnguoidung where [tensudung] = ?";
            PreparedStatement stm = connection.prepareStatement(strSelect);
            stm.setString(1, request.getParameter("tensudung"));
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        nguoidungDAO o = new nguoidungDAO();
        List<nguoidung> list = o.getAll();
        System.out.println(list.get(0).getTensudung());
    }

    public void update(HttpServletRequest request) {
        try {
            String strSelect = "update tbnguoidung set matkhau = ?, masinhvien = ?, lop = ? where tensudung = ?";
            PreparedStatement stm = connection.prepareStatement(strSelect);
            stm.setString(1, request.getParameter("password"));
            stm.setString(2, request.getParameter("code"));
            stm.setString(3, request.getParameter("class"));
            stm.setString(4, request.getParameter("username"));
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
