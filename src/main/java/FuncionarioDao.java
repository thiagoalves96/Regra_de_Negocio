import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_exemplo", "root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static int save(Funcionario e) {
		int status = 0;
		try {
			Connection con = FuncionarioDao.getConnection();
			System.out.println("Conexão com o banco de dados estabelecida.");

			PreparedStatement ps = con
					.prepareStatement("insert into usuario (nome, senha, email, pais) values (?, ?, ?, ?)");

			if (e.getNome() != null && !e.getNome().isEmpty()) {
				ps.setString(1, e.getNome());
				System.out.println("Inserindo nome no banco de dados: " + e.getNome());
			} else {
				System.out.println("Nome está vazio ou nulo. Lidando com isso...");
				// Lida com o caso em que 'nome' está vazio ou nulo, talvez lançando uma exceção
				// ou definindo um valor padrão.
			}

			ps.setString(2, e.getSenha());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getPais());

			status = ps.executeUpdate();
			System.out.println("Inserção no banco de dados bem-sucedida.");

			con.close();
			System.out.println("Conexão com o banco de dados fechada.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Funcionario e) {
		int status = 0;
		try {
			Connection con = FuncionarioDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update usuario set nome=?,senha=?,email=?,pais=? where idusuario=?");
			ps.setString(1, e.getNome());
			ps.setString(2, e.getSenha());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getPais());
			ps.setInt(5, e.getIdusuario());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int idusuario) {
		int status = 0;
		try {
			Connection con = FuncionarioDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from usuario where idusuario=?");
			ps.setInt(1, idusuario);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Funcionario getFuncionarioByidusuario(int idusuario) {
		Funcionario e = new Funcionario();

		try {
			Connection con = FuncionarioDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from usuario where idusuario=?");
			ps.setInt(1, idusuario);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setIdusuario(rs.getInt(1));
				e.setNome(rs.getString(2));
				e.setSenha(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setPais(rs.getString(5));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<Funcionario> getAllFuncionario() {
		List<Funcionario> list = new ArrayList<Funcionario>();

		try {
			Connection con = FuncionarioDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from usuario");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Funcionario e = new Funcionario();
				e.setIdusuario(rs.getInt(1));
				e.setNome(rs.getString(2));
				e.setSenha(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setPais(rs.getString(5));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
