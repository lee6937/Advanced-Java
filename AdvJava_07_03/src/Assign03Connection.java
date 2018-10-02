import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Assign03Connection {
	public static Connection makeConnection() { //Connection 객체 생성
 		String url = "jdbc:mysql://localhost/fruits";  //fruits 데이터베이스 url 생성
		Connection con = null; //연결 변수 초기화
	try { 
		Class.forName("com.mysql.jdbc.Driver"); //JDBC 드라이버 등록
		con = DriverManager.getConnection(url,"root","ehdgur63"); //드라이버 매니저 연결
		System.out.println("객체 생성 중--"); //객체 생성 문구 출력
	} catch (ClassNotFoundException e) { //연결이 안되었을 시
		System.out.println("JDBC Driver not found..."); //못찾았다는 문구 출력
	} catch (SQLException e) { //예외가 발생했을 때
		System.out.println("fail.."); //실패 문구 출력
	}
	return con; //드라이버 매니저 출력
}
	
	public static void main(String[] arg) throws SQLException{ //SQL 문 실행

		Connection con = makeConnection(); //연결 객체 생성
		Statement stmt = con.createStatement(); //SQL문을 DBMS에 전송하는 객체 생성
		
		String sql1 = "INSERT INTO fruit (id, name, color, price) VALUES "
		+ "('1', '사과', '빨강', '2000')";
		String sql2 = "INSERT INTO fruit (id, name, color, price) VALUES "
		+ "('2', '바나나', '노랑', '1000')";
		String	sql3 =	"INSERT INTO fruit (id, name, color, price) VALUES "
	    + "('3', '포도', '보라', '1500')"; //insert문을 통해 추가
		
		if(stmt.executeUpdate(sql1) == 1) //SQL문을 수행, 영향받은 레코드의 개수 반환
			System.out.println("삽입 성공"); //전송 성공할 시에 출력
		else
			System.out.println("삽입 실패"); //전송 실패할 시에 출력
		
		if(stmt.executeUpdate(sql2) == 1) //SQL문을 수행, 영향받은 레코드의 개수 반환
			System.out.println("삽입 성공"); 
		else
			System.out.println("삽입 실패"); 
		
		if(stmt.executeUpdate(sql3) == 1) //SQL문을 수행, 영향받은 레코드의 개수 반환
			System.out.println("삽입 성공");
		else
			System.out.println("삽입 실패");
		
		String sql = "SELECT * FROM fruit;"; //모든 레코드를 읽어오기 위해 저장
		PreparedStatement pstmt = con.prepareStatement(sql); //모든 레코드들을 DBMS에 전달 => Statement의 자식객체
		ResultSet rs = pstmt.executeQuery(); //결과물들을 입력
		
		while (rs.next()) { //다음행으로 이동하면서
			System.out.print("ID : "+rs.getString(1) + ", name : " 
		+rs.getString(2)+", color : "+rs.getString(3)+", price : "+rs.getString(4) +"\n"); //1부터 4열까지 출력
			
		}
		
		con.close();
		stmt.close();
		rs.close(); //모두 종료
	}
}
