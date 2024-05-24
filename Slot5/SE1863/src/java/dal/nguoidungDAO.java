package dal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.nguoidung;

public class nguoidungDAO extends DBContext{
    public List<nguoidung> getAll() {
        PreparedStatement stm;
        ResultSet rs;
        List<nguoidung> list = new ArrayList<>();
        try {
            String strSelect = "select * from tbnguoidung";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                nguoidung nd = new nguoidung(rs.getString("tensudung"), rs.getString("matkhau"), rs.getBoolean("isAttend"));
                list.add(nd);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public static void main(String[] args){
        nguoidungDAO o = new nguoidungDAO();
        List<nguoidung> list = o.getAll();
        System.out.println(list.get(0).getTensudung());
    }
    
}
