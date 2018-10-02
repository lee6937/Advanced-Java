import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Assign03Connection {
	public static Connection makeConnection() { //Connection ��ü ����
 		String url = "jdbc:mysql://localhost/fruits";  //fruits �����ͺ��̽� url ����
		Connection con = null; //���� ���� �ʱ�ȭ
	try { 
		Class.forName("com.mysql.jdbc.Driver"); //JDBC ����̹� ���
		con = DriverManager.getConnection(url,"root","ehdgur63"); //����̹� �Ŵ��� ����
		System.out.println("��ü ���� ��--"); //��ü ���� ���� ���
	} catch (ClassNotFoundException e) { //������ �ȵǾ��� ��
		System.out.println("JDBC Driver not found..."); //��ã�Ҵٴ� ���� ���
	} catch (SQLException e) { //���ܰ� �߻����� ��
		System.out.println("fail.."); //���� ���� ���
	}
	return con; //����̹� �Ŵ��� ���
}
	
	public static void main(String[] arg) throws SQLException{ //SQL �� ����

		Connection con = makeConnection(); //���� ��ü ����
		Statement stmt = con.createStatement(); //SQL���� DBMS�� �����ϴ� ��ü ����
		
		String sql1 = "INSERT INTO fruit (id, name, color, price) VALUES "
		+ "('1', '���', '����', '2000')";
		String sql2 = "INSERT INTO fruit (id, name, color, price) VALUES "
		+ "('2', '�ٳ���', '���', '1000')";
		String	sql3 =	"INSERT INTO fruit (id, name, color, price) VALUES "
	    + "('3', '����', '����', '1500')"; //insert���� ���� �߰�
		
		if(stmt.executeUpdate(sql1) == 1) //SQL���� ����, ������� ���ڵ��� ���� ��ȯ
			System.out.println("���� ����"); //���� ������ �ÿ� ���
		else
			System.out.println("���� ����"); //���� ������ �ÿ� ���
		
		if(stmt.executeUpdate(sql2) == 1) //SQL���� ����, ������� ���ڵ��� ���� ��ȯ
			System.out.println("���� ����"); 
		else
			System.out.println("���� ����"); 
		
		if(stmt.executeUpdate(sql3) == 1) //SQL���� ����, ������� ���ڵ��� ���� ��ȯ
			System.out.println("���� ����");
		else
			System.out.println("���� ����");
		
		String sql = "SELECT * FROM fruit;"; //��� ���ڵ带 �о���� ���� ����
		PreparedStatement pstmt = con.prepareStatement(sql); //��� ���ڵ���� DBMS�� ���� => Statement�� �ڽİ�ü
		ResultSet rs = pstmt.executeQuery(); //��������� �Է�
		
		while (rs.next()) { //���������� �̵��ϸ鼭
			System.out.print("ID : "+rs.getString(1) + ", name : " 
		+rs.getString(2)+", color : "+rs.getString(3)+", price : "+rs.getString(4) +"\n"); //1���� 4������ ���
			
		}
		
		con.close();
		stmt.close();
		rs.close(); //��� ����
	}
}
